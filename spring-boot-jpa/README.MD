##### `    JPA整理 正向工程`

​    实质JPA 是一套规范 不过Hibernate实现这个规范  （正向工程） 它为 Java 开发人员提供了一种对象/关联映射工具来管理 Java 应用中的关系数据
​    
​    注明：jpa不需要建表 正向工程 现有代码  我们通常mybatis 都是逆向工程 先有表后有代码
​    
​    配置类：
​    
​    pom：
​    

```
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        
        

```

​    ![](https://wl-picture.oss-cn-hangzhou.aliyuncs.com/github/Snipaste_2020-05-12_22-22-36.jpg)
​    

## `自定义简单查询（？1 写法很简单  就是代表  占位符   参数个数 第一个 ？2 代表第二个参数）

| Keyword           | Sample                                    | JPQL snippet                                                 |
| ----------------- | ----------------------------------------- | ------------------------------------------------------------ |
| And               | findByLastnameAndFirstname                | … where x.lastname = ?1 and x.firstname = ?2                 |
| Or                | findByLastnameOrFirstname                 | … where x.lastname = ?1 or x.firstname = ?2                  |
| Is,Equals         | findByFirstnameIs,findByFirstnameEquals   | … where x.firstname = ?1                                     |
| Between           | findByStartDateBetween                    | … where x.startDate between ?1 and ?2                        |
| LessThan          | findByAgeLessThan                         | … where x.age < ?1                                           |
| LessThanEqual     | findByAgeLessThanEqual                    | … where x.age ⇐ ?1                                           |
| GreaterThan       | findByAgeGreaterThan                      | … where x.age > ?1                                           |
| GreaterThanEqual  | findByAgeGreaterThanEqual                 | … where x.age >= ?1                                          |
| After             | findByStartDateAfter                      | … where x.startDate > ?1                                     |
| Before            | findByStartDateBefore                     | … where x.startDate < ?1                                     |
| IsNull            | findByAgeIsNull                           | … where x.age is null                                        |
| IsNotNull,NotNull | findByAge(Is)NotNull                      | … where x.age not null                                       |
| Like              | findByFirstnameLike                       | … where x.firstname like ?1                                  |
| NotLike           | findByFirstnameNotLike                    | … where x.firstname not like ?1                              |
| StartingWith      | findByFirstnameStartingWith               | … where x.firstname like ?1 (parameter bound with appended %) |
| EndingWith        | findByFirstnameEndingWith                 | … where x.firstname like ?1 (parameter bound with prepended %) |
| Containing        |                                           |                                                              |
|                   |                                           |                                                              |
|                   |                                           |                                                              |
|                   | findByAgeIn(Collection<age> ages)</age>   | … where x.age in ?1                                          |
| NotIn             | findByAgeNotIn(Collection<age> age)</age> | … where x.age not in ?1                                      |
| NotIn             | findByAgeNotIn(Collection<age> age)</age> | … where x.age not in ?1                                      |
| FALSE             | findByActiveFalse()                       | … where x.active = false                                     |
| IgnoreCase        | findByFirstnameIgnoreCase                 | … where UPPER(x.firstame) = UPPER(?1)                        |

​    

## 简单增删改查：

​    
​    ![](https://wl-picture.oss-cn-hangzhou.aliyuncs.com/github/Snipaste_2020-05-12_23-20-15.jpg)
​    
​    
​    
​    ![](https://wl-picture.oss-cn-hangzhou.aliyuncs.com/github/QQ图片20200512232113.png)
​    

# 具体查看代码 TEST


# 第二版 多数据源

config配置类 是配置多数据源   与 yml-prod 连起来看   

![](https://wl-picture.oss-cn-hangzhou.aliyuncs.com/github/Snipaste_2020-05-14_22-48-12.jpg)



第三版 jpa 一对一 一对多  多对多 


查看实体类 model 结构    参考仓库  https://github.com/mqxu/spring-boot-review/tree/master/spring-boot-jpa