package com.soft1851.spring.boot.jpa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * @author wl
 * @ClassNameCourse
 * @Description TODO
 * @Date 2020/5/13
 * @Version 1.0
 */

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    /**
     * 自增主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;


    @Column
    private String courseName;

    /**
     * optional属性是定义该关联类是否必须存在，值为false 时，关联类双方都必须存在，如果关系被维护端不存在，
     * 查询的结果为null。值为true 时, 关系被维护端可以不存在，查询的结果仍然会返回关系维护端，
     * 在关系维护端中指向关系被维护端的属性为null。optional属性的默认值是true。optional属性实际上指定关联类与被关联类的join 查询关系，
     * 如optional=false 时join 查询关系为inner join,optional=true 时join 查询关系为leftjoin。
     */
//    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private Teacher teacher;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<User> userList;
}
