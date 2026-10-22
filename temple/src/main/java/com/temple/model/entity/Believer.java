package com.temple.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "believer")
public class Believer {

    /**
     * 識別碼
     */
    @Id
    @Column(name = "oid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer oid;

    /**
     * 姓名
     */
    @Column(name = "name", nullable = false)
    private String name;

    /**
     * 聯絡電話
     */
    @Column(name = "phone", nullable = false)
    private String phone;

    /**
     * 行動電話
     */
    @Column(name = "cell_phone", nullable = false)
    private String cellPhone;

    /**
     * 地址
     */
    @Column(name = "address", nullable = false)
    private String address;

    /**
     * 國曆生日
     */
    @Column(name = "birthday")
    private String birthday;

    /**
     * 身分證號
     */
    @Column(name = "id_number")
    private String idNumber;
}
