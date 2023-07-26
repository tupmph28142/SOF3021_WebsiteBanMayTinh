package com.example.demo.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;
import java.util.UUID;

@Entity(name = "NhanVien")
@Table(name = "nhan_vien")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class NhanVien {

    @Id
//    @GeneratedValue(generator = "system-uuid")
    @Column(name = "id", unique = true, nullable = false, length = 36)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "ma")
    private String ma;

    @Column(name = "ten")
    private String ten;

    @Column(name = "ten_dem")
    private String tenDem;

    @Column(name = "ho")
    private String ho;

    @Column(name = "gioi_tinh")
    private String gioiTinh;

    @Column(name = "ngay_sinh")
    private Date ngaySinh;

    @Column(name = "dia_chi")
    private String diaChi;

    @Column(name = "sdt")
    private String sdt;

    @Column(name = "mat_khau")
    private String matKhau;

    @ManyToOne
    @JoinColumn(name = "id_ch",referencedColumnName = "id")
    private CuaHang cuaHang;

    @ManyToOne
    @JoinColumn(name = "id_cv",referencedColumnName = "id")
    private ChucVu chucVu;

    @Column(name = "id_gui_bc")
    private UUID idGuiBC;



    @Column(name = "trang_thai")
    private int trangThai;



}
