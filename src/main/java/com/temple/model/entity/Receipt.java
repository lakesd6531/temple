package com.temple.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "receipt")
public class Receipt {

    /**
     * 識別碼
     */
    @Id
    @Column(name = "oid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer oid;

    /**
     * 信徒識別碼
     */
    @Column(name = "believer_oid", nullable = false)
    private Integer believerOid;

    /**
     * 信徒姓名
     */
    @Column(name = "believer_name", nullable = false)
    private String believerName;

    /**
     * 總額
     */
    @Column(name = "total", nullable = false)
    private Integer total;

    /**
     * 類別
     */
    @Column(name = "category", nullable = false)
    private String category;

    /**
     * 經手人
     */
    @Column(name = "handler", nullable = false)
    private String handler;

    /**
     * 日期
     */
    @Column(name = "date", nullable = false)
    private LocalDate date;
}
