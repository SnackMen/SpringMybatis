## SpringMVC配置文件学习
##### 在学习SpringMVC初期，仅仅知道怎么使用配置文件，却不知道为什么这样使用可以，本着刨根问底精神，在此记录学习总结。
> #### 问题：在配置web.xml文件时，常常遇到下面两种配置方式，但是一直不清楚两种方式区别。

* ##### 方式一：
```
<context-param>  
    <param-name>contextConfigLocation</param-name>  
    <param-value>  
    /WEB-INF/conf/application-*.xml  
    </param-value>  
</context-param>

<listener>  
    <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>  
</listener>
```
* ##### 方式二：
```
<servlet>
    <servlet-name>mvc-dispatcher</servlet-name> <!--mvc调度器-->
    <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
    <!--配置mvc需要加载的配置文件
      spring-dao.xml,spring-service.xml,spring-web.xml
            Mybatis - > spring -> springmvc
    -->
    <init-param>
      <param-name>contextConfigLocation</param-name>
      <param-value>classpath:spring/spring-*.xml</param-value>
    </init-param>
  </servlet>
  <servlet-mapping>
    <servlet-name>mvc-dispatcher</servlet-name>
    <url-pattern>/</url-pattern>
  </servlet-mapping>
```
##### ==上面两种方式都可以加载Spring配置，但是这两种有什么区别？用哪一种更加常见？==

这就要说到Spring IOC容器的两种设计实现方式

> #### Spring-IOC的两种设计实现方式
#### [参考文章](http://blog.csdn.net/mengdonghui123456/article/details/77511324)
* ##### SpringIOC将对象的创建和生命周期的管理交给了容器来管理
* ##### 具备容器担当的ben主要有BeanFactory和AppliationContext两个系列
* ##### 前一种简单实现BeanFactory这个BeanFactory接口，后一种不但实现BeanFactory还实现了其他接口，赋予ApplicationContext系列容器更多的特性
* ##### 实际开发过程中以第二种方式为主
---
> #### IOC容器初始化步骤
* ##### 利用加载数据源的Resource类读取配置文件信息
* ##### 将Resource类读取的信息解析成Document对象，之后再解析成Bean的抽象的数据结构（BeanFactory可以依据这些数据结构实例化定义的Bean类）
* ##### 拿到这些数据结构之后，将数据以HashMap形式保存到BeanFactory中，可以通过BeanFatory的实例调用getBean(Key)的方法，Spring会通过反射的机制给我注入我们想要的Bean
---
> #### 针对web.xml文件中两种配置方式总结
#### [参考文章](https://my.oschina.net/heroShane/blog/195983)
* ##### ContextLoaderListener初始化的上下文加载的Bean是对于整个应用程序共享的，不管是使用什么表现层技术，一般如DAO层、Service层Bean
* ##### DispatcherServlet初始化的上下文加载的Bean是只对Spring Web MVC有效的Bean，如Controller、HandlerMapping、HandlerAdapter等等，该初始化上下文应该只加载Web相关组件。
* ##### 图解二者关系
![image](http://github-1252100560.cossh.myqcloud.com/IOC.PNG)
* ##### 所以使用DispatcherServlet初始化的上下文，你的应用程序是无法使用WebApplicationContext的
---
#### 其他参考链接：
* [关于ContextLoaderListener那点事](http://blog.csdn.net/gzu_imis/article/details/18989679)
* [Spring-MVC理解之一：应用上下文webApplicationContext](http://www.cnblogs.com/brolanda/p/4265597.html)