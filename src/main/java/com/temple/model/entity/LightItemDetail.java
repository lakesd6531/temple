package com.temple.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "light_item_detail")
public class LightItemDetail {

    @Id
    @Column(name = "oid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer oid;

    @Column(name = "light_item_oid", nullable = false)
    private Integer lightItemOid;

    @Column(name = "name", nullable = false)
    private String name;
}
