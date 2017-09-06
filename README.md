# SpringMybatis 学习总结

### 日常学习SSM总结
### 主要知识点：
* ##### SSM文件基本配置
* ##### 页面请求基本逻辑
* ##### 前台form post请求数据乱码
* ##### 自定义拦截器权限控制
* ##### [学习参考](http://www.jianshu.com/u/86b79c50cfb3)
---
### 学习总结
* ##### 常用工具类
![image](http://github-1252100560.cossh.myqcloud.com/%E5%B8%B8%E7%94%A8%E5%B7%A5%E5%85%B7%E7%B1%BB.PNG)
* ##### web.xml文件中配置
###### 1.在servlet标签下添加拦截器以及springmvc需要加载的配置文件放在init-param标签下
###### 2.添加过滤器，过滤参数传递中乱码问题
###### 3.配置错误页面，让无法访问的页面可以统一定向到固定页面
* ##### spring配置文件
###### 1.一般见到的都是将springmvc中web,dao,service放在一个配置文件中,这里将其分离成三个分别是：spring-dao.xml,spring-service.xml,spring-web.xml
###### 2.spring-dao.xml文件中主要配置：
- 扫描数据库连接配置文件
- 数据库连接池配置
- 连接池工厂配置
- 扫描dao接口包，动态实现dao接口
###### 3.spring-service.xml文件中主要配置：
- service扫描路径
- 数据库事务管理
###### 4.spring-web.xml文件中主要配置：
- 开启springmvc注解模式
- 针对页面访问静态资源配置：css/js/img/font等
- 访问拦截器,权限控制
- 配置jsp页面，显示ViewResolver
- 扫描web相关bean,扫描controller

---

### 编译运行过程遇到问题
1.  ##### 报如下错
```
java.lang.ClassNotFoundException: com.sun.tools.javac.util.List
```
##### 解决方法：在maven中添加如下依赖
```
<dependency>
  <groupId>org.checkerframework</groupId>
  <artifactId>compiler</artifactId>
  <version>1.9.4</version>
</dependency>
```