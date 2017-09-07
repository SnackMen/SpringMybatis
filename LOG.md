## SpringMVC中日志系统总结
#### [参考文章](http://josephpei.github.io/2014/08/25/Spring-MVC-%E5%AD%A6%E4%B9%A0%E7%AC%94%E8%AE%B06-SLF4J-Logback-%E6%97%A5%E5%BF%97/)
> ### 说明
* ##### SLF4J提供了一组抽象接口，在部署应用时后端可以选择不同的日志框架，而无需更改已有代码。
* ##### Logback 是项目 Log4j 的后继。它由三个模块组成：==logback-core, logback-classic, logback-access==。其中 logback-core 是基础模块。logback-classic 是 log4j 的改良版，是 slf4j api 的原生实现，可以方便地更换成其它日志框架。logback-access 模块与 Servlet 容器集成提供Http-access 日志的功能。
* ##### Spring 默认使用 Jakarta Commons Logging，但可以切换成其它日志框架。
---
> ### 操作步骤
* ##### 添加maven依赖
```
<!--日志配置文件sl4j+logback-->
    <dependency>
      <groupId>ch.qos.logback</groupId>
      <artifactId>logback-classic</artifactId>
      <version>1.1.3</version>
    </dependency>
    <dependency>
      <groupId>org.logback-extensions</groupId>
      <artifactId>logback-ext-spring</artifactId>
      <version>0.1.2</version>
    </dependency>
    <!--spring 内部默认使用的日志框架是： commons-logging（需排除该依赖）， 引入“jcl-over-slf4j”依赖，使spring对common-logging的调用转为对slf4j的调用-->
    <dependency>
      <groupId>org.slf4j</groupId>
      <artifactId>jcl-over-slf4j</artifactId>
      <version>1.7.12</version>
    </dependency>
    <dependency>
      <groupId>org.slf4j</groupId>
      <artifactId>slf4j-api</artifactId>
      <version>1.7.25</version>
    </dependency>
```
* ##### 移除spring-core 对 commons-logging 依赖
```
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-core</artifactId>
    <version>4.3.2.RELEASE</version>
    <exclusions>
        <exclusion>
           <groupId>commons-logging</groupId>
           <artifactId>commons-logging</artifactId>
        </exclusion>
    </exclusions>
</dependency>
```
* ##### 在web.xml中添加config和listener
```
<context-param>
    <param-name>logbackConfigLocation</param-name>
    <param-value>classpath:logback.xml</param-value>
</context-param>
<listener>
    <listener-class>ch.qos.logback.ext.spring.web.LogbackConfigListener</listener-class>
</listener>
```
* ##### 在需要添加log的地方添加代码
```
private Logger logger = LoggerFactory.getLogger(MainController.class);
logger.debug("debug");
```