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
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;
import java.util.UUID;

@Entity
@Table(name = "hoa_don")

@Getter
@Setter

@NoArgsConstructor
@AllArgsConstructor
@ToString

public class HoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

    @Column(name = "id")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "id_kh", referencedColumnName = "id")
    private KhachHang khachHang;

    @ManyToOne
    @JoinColumn(name = "id_nv", referencedColumnName = "id")
    private NhanVien nhanVien;

    @Column(name = "ma")
    private String ma;

    @Column(name = "ngay_tao")
    private Date ngayTao;

    @Column(name = "ngay_thanh_toan")
    private Date ngayThanhToan;

    @Column(name = "ngay_ship")
    private Date ngayShip;

    @Column(name = "ngay_nhan")
    private Date ngayNhan;

    @Column(name = "tinh_trang")
    private int tinhTrang;

    @Column(name = "ten_nguoi_nhan")
    private String tenNguoiNhan;

    @Column(name = "dia_chi")
    private String diaChi;

    @Column(name = "sdt")
    private String sdt;

    public HoaDon(String ma, Date ngayTao, int tinhTrang, String tenNguoiNhan, String diaChi, String sdt) {
        this.ma = ma;
        this.ngayTao = ngayTao;

        this.tinhTrang = tinhTrang;
        this.tenNguoiNhan = tenNguoiNhan;
        this.diaChi = diaChi;
        this.sdt = sdt;
    }

    public HoaDon(KhachHang khachHang, NhanVien nhanVien, String ma, Date ngayTao, int tinhTrang, String tenNguoiNhan, String diaChi, String sdt) {
        this.khachHang = khachHang;
        this.nhanVien = nhanVien;
        this.ma = ma;
        this.ngayTao = ngayTao;
        this.tinhTrang = tinhTrang;
        this.tenNguoiNhan = tenNguoiNhan;
        this.diaChi = diaChi;
        this.sdt = sdt;
    }
}