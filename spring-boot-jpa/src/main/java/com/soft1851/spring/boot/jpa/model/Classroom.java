package com.soft1851.spring.boot.jpa.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author wl
 * @ClassNameClass
 * @Description TODO
 * @Date 2020/5/13
 * @Version 1.0
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private String className;

}

