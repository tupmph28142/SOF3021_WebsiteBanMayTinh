package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "hoa_don_chi_tiet")
@Data

public class HoaDonChiTiet {
    @EmbeddedId
    private IdHoaDonChiTiet id;

    private Integer soLuong;

    private BigDecimal donGia;


}
