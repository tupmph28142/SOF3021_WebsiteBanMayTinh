package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "cua_hang")
@Data

public class CuaHang {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

    @Column(name = "id")
    private UUID id;

    @Column(name = "ma")
    private String ma;

    @Column(name = "ten")
    private String ten;

     @Column(name = "dia_chi")
    private String diaChi;

     @Column(name = "thanh_pho")
    private String thanhPho;

     @Column(name = "quoc_gia")
    private String quocGia;



}
