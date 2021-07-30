package com.pearadmin.config;

import com.pearadmin.properties.MinioProperties;
import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * minio 配置类
 *
 * @author lihao3
 * @date 2021/7/23 10:28
 */
@Slf4j
@Configuration
@ConditionalOnClass(MinioClient.class)
@EnableConfigurationProperties(MinioProperties.class)
public class MinioConfig {

    @Autowired
    private MinioProperties minioProperties;

    @Bean
    public MinioClient minioClient() {
        // 初始化空MinioClient用于接受
        MinioClient minioClient = null;
        // 填充基本信息
        minioClient = MinioClient
                .builder()
                .endpoint(minioProperties.getUrl())
                .credentials(minioProperties.getAccessKey(), minioProperties.getSecretKey())
                .build();
        minioClient.setTimeout(
                minioProperties.getConnectTimeout(),
                minioProperties.getWriteTimeout(),
                minioProperties.getReadTimeout()
        );
        // 判断是否需要启动时检查桶是否存在
        if (minioProperties.isCheckBucket()) {
            log.info("开始检查桶[{}]是否存在", minioProperties.getBucket());
            boolean bucketExists = false;
            try {
                bucketExists = minioClient.bucketExists(BucketExistsArgs.builder().bucket(minioProperties.getBucket()).build());
            } catch (Exception e) {
                throw new RuntimeException("minio服务检查桶是否存在失败", e);
            }
            // 如果桶不存在
            if (!bucketExists) {
                // 检查是否需要自动创建文件桶
                if (minioProperties.isCreateBucket()) {
                    try {
                        minioClient.makeBucket(MakeBucketArgs.builder().bucket(minioProperties.getBucket()).build());
                    } catch (Exception e) {
                        throw new RuntimeException("minio新建桶失败", e);
                    }
                }
            }
        }
        return minioClient;
    }
}
