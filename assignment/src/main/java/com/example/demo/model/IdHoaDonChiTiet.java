package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IdHoaDonChiTiet implements Serializable {
    @ManyToOne
    @JoinColumn(name = "id_hoa_don")
    private HoaDon hoaDon;


    @ManyToOne
    @JoinColumn(name = "id_chi_tiet_sp")
    private ChiTietSanPham chiTietSanPham;

}
