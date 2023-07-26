package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.UUID;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class IdGioHangChiTiet implements Serializable {
    @Column(name = "id_gio_hang")
    private UUID idGioHang;

    @Column(name = "id_chi_tiet_sp")

    private UUID idChiTietSanPham;
}
