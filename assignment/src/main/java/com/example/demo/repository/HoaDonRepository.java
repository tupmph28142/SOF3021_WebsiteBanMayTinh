package com.example.demo.repository;

import com.example.demo.model.GioHang;
import com.example.demo.model.HoaDon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository

public interface HoaDonRepository extends JpaRepository<HoaDon, UUID> {
    List<HoaDon> findByMa(String ma);
}
