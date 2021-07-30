package com.pearadmin.server;

import io.minio.messages.Bucket;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;
import java.util.Optional;

/**
 * minio 接口层
 *
 * @author lihao3
 * @date 2021/7/23 10:23
 */
public interface IMinioServer {

    /**
     * 判断桶是否存在
     *
     * @param bucketName bucket名称
     * @return
     */
    Boolean bucketExists(String bucketName);

    /**
     * 创建bucket
     *
     * @param bucketName bucket名称
     */
    void createBucket(String bucketName);

    /**
     * 上传MultipartFile文件到全局默认文件桶中
     *
     * @param file 文件
     * @return 文件对应的URL
     */
    String putObject(MultipartFile file);

    /**
     * 上传文件
     *
     * @param objectName  文件名
     * @param inputStream 文件流
     * @param contentType 文件类型
     * @return 文件url
     */
    String putObject(String objectName, InputStream inputStream, String contentType);

    /**
     * 上传bytes文件
     *
     * @param objectName  文件名
     * @param bytes       字节
     * @param contentType 文件类型
     * @return 文件url
     */
    String putObject(String objectName, byte[] bytes, String contentType);

    /**
     * 上传MultipartFile文件到全局默认文件桶下的folder文件夹下
     *
     * @param objectName 文件名称, 如果要带文件夹请用 / 分割, 例如 /help/index.html
     * @param file       文件
     * @return 文件对应的URL
     */
    String putObject(String objectName, MultipartFile file);

    /**
     * 上传MultipartFile文件到指定的文件桶下
     *
     * @param bucketName 桶名称
     * @param objectName 文件名称, 如果要带文件夹请用 / 分割, 例如 /help/index.html
     * @param file       文件
     * @return 文件对应的URL
     */
    String putObject(String bucketName, String objectName, MultipartFile file);

    /**
     * 上传流到指定的文件桶下
     *
     * @param bucketName  桶名称
     * @param objectName  文件名称, 如果要带文件夹请用 / 分割, 例如 /help/index.html
     * @param inputStream 文件流
     * @param contentType 文件类型, 例如 image/jpeg: jpg图片格式, 详细可看: https://www.runoob.com/http/http-content-type.html
     * @return 文件对应的URL
     */
    String putObject(String bucketName, String objectName, InputStream inputStream, String contentType);

    /**
     * 上传流到指定的文件桶下
     *
     * @param bucketName  桶名称
     * @param objectName  文件名称, 如果要带文件夹请用 / 分割, 例如 /help/index.html
     * @param bytes       字节
     * @param contentType 文件类型, 例如 image/jpeg: jpg图片格式, 详细可看: https://www.runoob.com/http/http-content-type.html
     * @return 文件对应的URL
     */
    String putObject(String bucketName, String objectName, byte[] bytes, String contentType);

    /**
     * 判断文件是否存在
     *
     * @param objectName 文件名称, 如果要带文件夹请用 / 分割, 例如 /help/index.html
     * @return true存在, 反之
     */
    Boolean checkFileIsExist(String objectName);

    /**
     * 判断文件夹是否存在
     *
     * @param folderName 文件夹名称
     * @return true存在, 反之
     */
    Boolean checkFolderIsExist(String folderName);

    /**
     * 判断文件是否存在
     *
     * @param bucketName 桶名称
     * @param objectName 文件名称, 如果要带文件夹请用 / 分割, 例如 /help/index.html
     * @return true存在, 反之
     */
    Boolean checkFileIsExist(String bucketName, String objectName);

    /**
     * 判断文件夹是否存在
     *
     * @param bucketName 桶名称
     * @param folderName 文件夹名称
     * @return true存在, 反之
     */
    Boolean checkFolderIsExist(String bucketName, String folderName);

    /**
     * 根据文件全路径获取文件流
     *
     * @param objectName
     * @return
     */
    InputStream getObject(String objectName);

    /**
     * 根据文件桶和文件全路径获取文件流
     *
     * @param bucketName
     * @param objectName
     * @return
     */
    InputStream getObject(String bucketName, String objectName);

    /**
     * 根据url获取文件流
     *
     * @param url
     * @return
     */
    InputStream getObjectByUrl(String url);

    /**
     * 获取全部bucket
     *
     * @return
     */
    List<Bucket> getAllBuckets();

    /**
     * 根据bucketName获取信息
     *
     * @param bucketName bucket名称
     * @return
     */
    Optional<Bucket> getBucket(String bucketName);

    /**
     * 根据bucketName删除信息
     *
     * @param bucketName bucket名称
     */
    void removeBucket(String bucketName);

    /**
     * 删除文件
     *
     * @param objectName 文件名称
     */
    void removeObject(String objectName);

    /**
     * 删除文件
     *
     * @param bucketName bucket名称
     * @param objectName 文件名称
     */
    void removeObject(String bucketName, String objectName);
}
