<center>
    <h2>minio-spring-boot-starter</h2>
</center>

<p align="center">
	<a target="_blank" href="https://jitpack.io/#com.gitee.pear-admin/minio-spring-boot-starter">
		<img src="https://jitpack.io/v/com.gitee.pear-admin/minio-spring-boot-starter.svg" />
	</a>
	<a target="_blank" href="https://license.coscl.org.cn/MulanPSL2/">
		<img src="https://img.shields.io/badge/license-Apache--2.0-blue" />
	</a>
	<a target="_blank" href="https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html">
		<img src="https://img.shields.io/badge/JDK-8+-green.svg" />
	</a>
    <a href='https://gitee.com/pear-admin/minio-spring-boot-starter/stargazers'>
        <img src='https://gitee.com/pear-admin/minio-spring-boot-starter/badge/star.svg?theme=dark' alt='star'></img>
	</a>
	<a target="_blank">
		<img src="https://img.shields.io/badge/minio-7.1.0-blue" />
	</a>
	<a target="_blank">
		<img src="https://img.shields.io/badge/spring--boot-2.3.7.RELEASE-blue" />
	</a>
</p>



# 工程简介

minio和springboot的整合项目, 让你快速上手, 方便使用

[参考API](https://apidoc.gitee.com/pear-admin/minio-spring-boot-starter)



# 所用jar包

|  项目名称   |    版本号     | 官网地址                                              |
| :---------: | :-----------: | ----------------------------------------------------- |
|    minio    |     7.1.0     | https://docs.min.io/docs/java-client-quickstart-guide |
| spring-boot | 2.3.7.RELEASE | https://spring.io/projects/spring-boot                |
| hutool-core |     5.7.5     | https://www.hutool.cn                                 |



# 如何使用

## maven

在项目的pom.xml中添加

```xml
    <repositories>
        <repository>
            <id>jitpack.io</id>
            <url>https://jitpack.io</url>
        </repository>
    </repositories>
```

```xml
	<dependency>
	    <groupId>com.gitee.pear-admin</groupId>
	    <artifactId>minio-spring-boot-starter</artifactId>
	    <version>${last.version}</version>
	</dependency>
```



## gradle

```groovy
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

```groovy
	dependencies {
	        implementation 'com.gitee.pear-admin:minio-spring-boot-starter:${last.version}'
	}
```

