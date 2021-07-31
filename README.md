# VaaS SDK for Java

## 概述

这是 VaaS API 的 Java 版本封装开发包，是由一览云官方提供的，一般支持最新的 API 功能。

对应的 REST API 文档：<http://doc.yilan.tv/feedv2/server/api/video_flow>

## 安装

### maven 方式
将下边的依赖条件放到你项目的 maven pom.xml 文件里。
```
<repositories>
    ...
    <repository>
        <id>maven-releases</id>
        <url>http://nexus.1lan.tv/repository/maven-releases</url>
    </repository>
    ...
</repositories>

<dependencies>
    ...
    <dependency>
        <groupId>com.vaas</groupId>
        <artifactId>vaas-sdk-java</artifactId>
        <version>最新版本</version>
    </dependency>
    ...
<dependencies>
```
### jar 包方式

请到 [Release页面](https://github.com/yilanyun/vaas-sdk-java/releases) 下载最新版本的发布包。

### 导入源码项目

* 可以采用 `git clone https://github.com/yilanyun/vaas-sdk-java.git` 命令下载源码
* 如果不使用git，请到 [github](https://github.com/yilanyun/vaas-sdk-java.git) 下载源码包并解压
* 采用eclipse导入下载的源码工程，推荐采用maven的方式，方便依赖包的管理
* 开发者需要注意，将本项目的编码格式设置为UTF-8
* 可以用 Eclipse 类 IDE 导出 jar 包。建议直接使用 maven，执行命令：


    mvn clean package
    
## 关于ACCESS_KEY / ACCESS_TOKEN

### ACCESS_KEY / ACCESS_TOKEN 注册申请流程

1.使用帐号/密码 [登录](https://yuncms.yilan.tv/admin/default/login) 控制台；

2.选择一级菜单“应用管理”->选择二级菜单“应用列表”,点击“新建应用”按钮创建应用；

3.创建过程中，请正确填写应用包名。 对于SDK，建议在“详情页地址”处填写正确的应用下载地址，以便之后进行广告配置以及运营工作。若应用暂未上架，此处可以先填写公司网址。待应用上架后请及时更新；

4.创建完成后，等待应用审核。一览将在3个工作日内审核完成。应用创建后分配access key和access token。

### ACCESS_KEY/ACCESS_TOKEN在sdk中的使用

- (option 1 推荐) 在代码里显示调用方法 setAccessKey / setAccessToken，例：
```
  client.setAccessKey("your access_key");
  client.setAccessToken("your access_token");
```

- (option 2) 放在配置文件 vaas-sdk-java/src/mian/resources/application.properties，格式为：
```
  ACCESS_KEY = "your access_key"
  ACCESS_TOKEN = "your access_token"
```

## 使用样例

> 以下片断来自项目代码里的文件：com.vaas.example.channel.GetChannelDemo

### 初始化

```		
import java.util.List;

import com.vaas.api.ChannelService;
import com.vaas.api.entity.Channel;
import com.vaas.api.entity.CommonEntity;
import com.vaas.api.VaaSClient;
...
    CommonEntity comm = new CommonEntity();
    comm.setUdid("df757f33b10f142596106bb451fa2187");
    comm.setPlatform(5);
    comm.setPkg_name("vaas-demo");
    VaaSClient client = new VaaSClient(comm);
    // call below method if you dont set access_key and access_token in vaas-sdk-java/src/main/resources/application.properties
    client.setAccessKey("your access_key");
    client.setAccessToken("your access_token");
...
```

## Examples

测试样例 com.vaas.example.channel.GetChannelDemo

