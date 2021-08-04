<div align="center">

<br/>
<br/>

<img src="admin/images/logo.png" width="90px" style="margin-top:30px;"/>
  <h1 align="center">
    minio-spring-boot-starter
  </h1>
  <h4 align="center">
    基 于 Minio 对 象 存 储 的 Spring Boot 快 速 启 动 器，开 箱 即 用
  </h4> 

     [官 网](http://www.pearadmin.com/)   |   [群聊](https://jq.qq.com/?_wv=1027&k=5OdSmve)   |   [社区](http://forum.pearadmin.com/)|   [文档](http://www.pearadmin.com/doc)

</div>


<p align="center">
	<a target="_blank" href="https://jitpack.io/#com.gitee.pear-admin/minio-spring-boot-starter">
	    <img src="https://jitpack.io/v/com.gitee.pear-admin/minio-spring-boot-starter.svg" />
	</a>
	<a target="_blank" href="https://gitee.com/pear-admin/minio-spring-boot-starter/blob/master/LICENSE">
	    <img src="https://img.shields.io/badge/license-Apache--2.0-blue" />
	</a>
	<a target="_blank" href="https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html">
	    <img src="https://img.shields.io/badge/JDK-8+-green.svg" />
	</a>
        <a target="_blank" href='https://gitee.com/pear-admin/minio-spring-boot-starter/stargazers'>
            <img src='https://gitee.com/pear-admin/minio-spring-boot-starter/badge/star.svg?theme=dark' alt='star'></img>
	</a>
	<a href='https://gitee.com/pear-admin/minio-spring-boot-starter/members'>
    	    <img src='https://gitee.com/pear-admin/minio-spring-boot-starter/badge/fork.svg?theme=dark' alt='fork'/>
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

<p>
    <a target="_blank" href="https://apidoc.gitee.com/pear-admin/minio-spring-boot-starter"> 
        参考API
    </a>
</p>



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

