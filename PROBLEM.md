#### 2017/09/08更新
#####  在springMVC配置redis缓存时遇到了一个问题，当我配置cache注解之后，运行项目报错
```
Caused by: org.springframework.beans.factory.BeanNotOfRequiredTypeException: Bean named 'userService' is expected to be of type [com.ws.service.impl.UserServiceImpl] but was actually of type [com.sun.proxy.$Proxy25]
```
##### 配置文件中配置，实现类中注解如下
```
<!--启用缓存注解功能，必须的，否则在代码中使用注解不会生效，另外该注解一定要声明在spring配置文件中才会生效-->
    <!--可以想象，如果想针对jdbc使用注解方式，是否也可以在配置文件中启用其注解功能-->
    <cache:annotation-driven cache-manager="cacheManager" />
```
```
@Service("userService")
public class UserServiceImpl implements UserService {}
```
##### 除此之外还在其他地方配置了相关的mvc注解支持，以及事务注解支持
```
<tx:annotation-driven transaction-manager="transactionManager" />
```
```
 <mvc:annotation-driven />
```
### 分析
* ##### 从报错可以看出，我们注解的bean期望是UserServiceImpl，但是spring容器却将其认成了$Proxy25类型，这是一个代理方面的错误
* ##### 查阅资料，发现针对于spring的注解，主要有两种代理方式，一种是JDK代理，另外一种是CGLIB代理
* ##### 我们可以通过设置proxy-target-class来设定其为JDK动态代理还是CGLIB动态代理，proxy-target-class默认为false即jdk动态代理，当该值为true，那么就是CGLIB动态代理。
* ##### 除此之外，在该标签下还存在一个属性名字叫做mode，缺省模式下mode的值为proxy，指的是使用Spring AOP框架处理带注解的bean，而在将其设置为aspectj的值时，就不会再使用Spring AOP框架进行处理，而是使用AspectJ代替Spring Aspectj处理相关bean。（相关配置如下）
```
<cache:annotation-driven cache-manager="cacheManager" mode="aspectj"/>
```
### 针对问题进行解决
##### 从我们的分析中可以看出，我们只需要将标签中的proxy-target-class属性设置为true，让其代理模式不是JDK动态代理，而是使用CGLIB动态代理到类，便可以直接解决问题。
*关于JDK动态代理和CGLIB动态代理的区别问题，不在本次研究问题之内，可以查看链接*
##### [Spring：AOP（JDK动态代理与CGLIB代理）](https://github.com/pzxwhc/MineKnowContainer/issues/28)
##### [记一个Spring动态代理的坑](http://blog.onlycatch.com/post/%E5%AF%84%E4%B8%80%E4%B8%AASpring%E5%8A%A8%E6%80%81%E4%BB%A3%E7%90%86%E7%9A%84%E5%9D%91)
##### [Part V. 数据访问-17. 事务管理-17.5 声明式事务管理](http://blog.csdn.net/lovesomnus/article/details/73733989)