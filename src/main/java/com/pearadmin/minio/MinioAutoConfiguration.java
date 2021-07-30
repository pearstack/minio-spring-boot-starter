package com.pearadmin.minio;

import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * Minio 自动配置
 *
 * @author lihao3
 * @date 2021/7/23 10:28
 */
@Slf4j
@Configuration
@ConditionalOnClass(MinioClient.class)
@EnableConfigurationProperties(MinioAutoProperties.class)
public class MinioAutoConfiguration {

    @Resource
    private MinioAutoProperties minioAutoProperties;

    @Bean
    public MinioClient minioClient() {

        MinioClient minioClient = MinioClient
                .builder()
                .endpoint(minioAutoProperties.getUrl())
                .credentials(minioAutoProperties.getAccessKey(), minioAutoProperties.getSecretKey())
                .build();

        minioClient.setTimeout(
                minioAutoProperties.getConnectTimeout(),
                minioAutoProperties.getWriteTimeout(),
                minioAutoProperties.getReadTimeout()
        );

        // Start detection
        if (minioAutoProperties.isCheckBucket()) {
            String bucketName = minioAutoProperties.getBucket();
            if (!checkBucket(bucketName,minioClient)) {
                if (minioAutoProperties.isCreateBucket()) {
                    createBucket(bucketName, minioClient);
                }
            }
        }
        return minioClient;
    }

    private boolean checkBucket(String bucketName, MinioClient minioClient) {
        boolean isExists = false;
        try {
            isExists = minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
        } catch (Exception e) {
            throw new RuntimeException("failed to check if the bucket exists", e);
        }
        return isExists;
    }

    private void createBucket(String bucketName, MinioClient minioClient) {
        try {
            minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
        } catch (Exception e) {
            throw new RuntimeException("failed to create default bucket", e);
        }
    }
}
