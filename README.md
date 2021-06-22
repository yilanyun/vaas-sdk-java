# VaaS SDK for Java

## 概述

这是 VaaS 视频云 REST API 的 Java 版本封装开发包，是由一览云官方提供的，一般支持最新的 API 功能。

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

请到 [Release页面](https://github.com/yilanyun/vaas-sdk-java/releases)下载最新版本的发布包。

### 导入本项目

* 可以采用 `git clone https://github.com/yilanyun/vaas-sdk-java.git` 命令下载源码
* 如果不使用git，请到[github](https://github.com/yilanyun/vaas-sdk-java.git)下载源码包并解压
* 采用eclipse导入下载的源码工程，推荐采用maven的方式，方便依赖包的管理
* 开发者需要注意，将本项目的编码格式设置为UTF-8

### 构建本项目

可以用 Eclipse 类 IDE 导出 jar 包。建议直接使用 maven，执行命令：

    mvn package

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
#### 公共参数说明
| 参数名称 | 类型 | 是否必传 | 解释 |
| --- | --- | --- | --- |
| udid | string | 是 | 设备唯一标识 |
| platform | int | 是 | 1-Android，2-iOS，3-H5，4-小程序，5-web |
| pkg_name | string | 是 | 应用包名(与申请应用时包名一致，长度5到64位) |

### 频道相关服务
```
    ChannelService cs = client.channel();
    List<Channel> data = cs.getChannel();
    System.out.println("channel data: ");
    for (Channel ch: data) {
        System.out.println(ch.toString());
    }
```

### 推荐信息流服务
```
    RecommendService rs = client.recommendService();
    List<Video> data = rs.feed(1, 10169, 0, 6);
    System.out.println("video feed list: ");
    for (Video v: data) {
        System.out.println(v.toString());
    }
```
#### 参数说明
| 参数名称 | 类型 | 默认值 | 是否必传 | 解释 |
| --- | --- | --- | --- | --- |
| video_type | int |  无 | 是 | 视频类型，1-横屏，2-竖屏 |
| channelId | int |  无 | 否 | 频道ID |
| load_type | int | 0 | 否 | 加载方式 0-上拉加载更多 1-非首次下拉刷新时 2-首次刷新某个频道 |
| size | int | 8 | 否 | 返回条数（1～8） |

### 推荐相关服务
```
    RecommendService rs = client.recommendService();
    List<Video> data = rs.relation("JMewZ4zoXO5K", 8);
    System.out.println("video relation list: ");
    for (Video v: data) {
        System.out.println(v.toString());
    }
```
#### 参数说明
| 参数名称 | 类型 | 默认值 | 是否必传 | 解释 |
| --- | --- | --- | --- | --- |
| id | string |  无 | 是 | 视频ID |
| size | int | 20 | 否 | 返回条数（1～8） |

### 视频详情服务
```
    VideoService vs = client.video();
    List<Video> data = vs.details("JMewZ4zoXO5K,njz3DnwDD45V", 1);
    System.out.println("video details: ");
    for (Video v: data) {
        System.out.println(v.toString());
    }
```
#### 参数说明
| 参数名称 | 类型 | 默认值 | 是否必传 | 解释 |
| --- | --- | --- | --- | --- |
| ids | string | 无 | 是 | 视频ID，多个用英文逗号隔开 |
| video_type | int |  无 | 是 | 视频类型，1-横屏，2-竖屏 |

### 视频播放信息服务
```
    VideoService vs = client.video();
    List<Play> data = vs.play("JMewZ4zoXO5K");
    System.out.println("video play data: ");
    for (Play pl: data) {
        System.out.println(pl.toString());
    }
```
#### 参数说明
| 参数名称 | 类型 | 默认值 | 是否必传 | 解释 |
| --- | --- | --- | --- | --- |
| id | string | 无 | 是 | 视频ID |

### 作者详情服务
```
    CpService cs = client.cp();
    Cp info = cs.cpInfo("DVjdRzOxny8d", 1);
    System.out.println("cp data: " + info.toString());
```
#### 参数说明
| 参数名称 | 类型 | 默认值 | 是否必传 | 解释 |
| --- | --- | --- | --- | --- |
| id | string | 无 | 是 | 作者ID |
| video_type | int |  无 | 是 | 视频类型，1-横屏，2-竖屏 |

### 作者视频列表服务
```
    CpService cs = client.cp();
    List<Video> data = cs.cpVideoList("d4jrXOJm0OyG", 1, 1, 10);
    System.out.println("cp video list: ");
    for (Video v: data) {
        System.out.println(v.toString());
    }
```
#### 参数说明
| 参数名称 | 类型 | 默认值 | 是否必传 | 解释 |
| --- | --- | --- | --- | --- |
| id | string | 无 | 是 | 作者ID |
| video_type | int |  无 | 是 | 视频类型，1-横屏，2-竖屏 |
| page | int | 1 | 否 | 页数 |
| size | int | 20 | 否 | 返回条数 |

## Examples

测试样例 com.vaas.example.channel.GetChannelDemo

## License
MIT
