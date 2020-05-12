# spring-boot-start模块

###### 1.yml配置文件dev、prod环境切换

环境切换：

不同yml  文件名如下图 调用  

主配置调用代码

```
spring:
  profiles:
    active: dev   这里也可以是 prod  等等 取决于定义的yml
```

![](https://wl-picture.oss-cn-hangzhou.aliyuncs.com/github/Snipaste_2020-05-11_22-09-03.jpg)

###### 2.标准的SpringBoot风格接口和Spring MVC风格接口
@Controller 处理http请求
@RestController Spring框架4版本之后出来的注解,之前版本返回json数据需要@ResponseBody配合@Controller
@RequestMapping 配置url映射关系
@PathVariable 获取url中的数据
@RequestParam 获取请求参数的值
@GetMapping 组合注解
————————————————
版权声明：本文为CSDN博主「InvQ」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/uniquewonderq/java/article/details/79971433
实列：

![](https://wl-picture.oss-cn-hangzhou.aliyuncs.com/github/Snipaste_2020-05-11_22-37-03.jpg)

![](https://wl-picture.oss-cn-hangzhou.aliyuncs.com/github/Snipaste_2020-05-11_22-37-21.jpg)


###### 3.路径参数和查询参数
**@RequestParam与@PathVariable的区别**

 在spring MVC中，两者的作用都是将request里的参数的值绑定到contorl里的方法参数里的，区别在于，URL写法不同。

 使用@RequestParam时，URL是这样的：http://host:port/path?参数名=参数值

使用@PathVariable时，URL是这样的：http://host:port/path/参数值

###### 4.MockMvc使用


###### 5.默认的pom(2.2.7)和不依赖父级依赖的pom(2.2.4)配置写法

![](https://wl-picture.oss-cn-hangzhou.aliyuncs.com/github/Snipaste_2020-05-11_22-46-33.jpg)


