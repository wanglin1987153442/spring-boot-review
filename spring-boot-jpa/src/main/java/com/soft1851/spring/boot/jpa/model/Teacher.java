package com.soft1851.spring.boot.jpa.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wl
 * @ClassNameteacher
 * @Description TODO
 * @Date 2020/5/13
 * @Version 1.0
 */
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor


public class Teacher {
    /**
     * 自增主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    /**
     * 老师账号
     */

    @Column(nullable = false, unique = true)
    private String account;
    /**
     * 密码
     */
    @Column(nullable = false, length = 32)
    private String password;
    /**
     * 4>fatch
     * <p>
     * 可选择项包括：FetchType.EAGER和FetchType.LAZY。前者表示关系类(本例是OrderItem 类)在主类(本例是Order类)加载的时候同时加载，后者表示关系类在被访问时才加载。默认值是FetchType.LAZY。
     * <p>
     * <p>
     * 1>targetEntity
     * <p>
     * 定义关系类的类型，默认是该成员属性对应的类类型，所以通常不需要提供定义。
     * <p>
     * <p>
     * 3>cascade
     * <p>
     * 该属性定义类和类之间的级联关系。定义的级联关系将被容器视为对当前类对象及其关联类对象采取相同的操作，而且这种关系是递归调用的。举个例子：Order 和OrderItem有级联关系，那么删除Order时将同时删除它所对应的OrderItem对象。而如果OrderItem还和其他的对象之间有级联关系，那么这样的操作会一直递归执行下去。
     * <p>
     * <p>
     * <p>
     * cascade的值只能从CascadeType.PERSIST（级联新建）、CascadeType.REMOVE（级联删除）、CascadeType.REFRESH（级联刷新）、CascadeType.MERGE（级联更新）中选择一个或多个。还有一个选择是使用CascadeType.ALL，表示选择全部四项。
     * <p>
     * <p>
     * <p>
     * 2>mappedBy
     * <p>
     * 定义类之间的双向关系。如果类之间是单向关系，不需要提供定义，如果类和类之间形成双向关系，我们就需要使用这个属性进行定义，否则可能引起数据一致性的问题。
     * <p>
     * 该属性的值是“多”方class里的“一”方的变量名
     */
//new arrlist 这样装配时候 就无须装配   fetch 饿汉式  这样装配
//    @OneToMany(mappedBy = "teacher",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//    private List<Course> courseList = new ArrayList<>();


    //如果此处不进行装配我们自己可以去装配 嘿嘿
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id")
    private List<Course> courseList ;


}
