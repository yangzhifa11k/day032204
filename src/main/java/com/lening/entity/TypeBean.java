package com.lening.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="tb_type")
public class TypeBean {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer tid;
    private Integer pid;
    private String tname;


}
