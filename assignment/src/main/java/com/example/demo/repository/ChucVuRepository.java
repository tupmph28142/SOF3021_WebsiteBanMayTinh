package com.example.demo.repository;

import com.example.demo.model.ChucVu;
import com.example.demo.model.DongSanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository

public interface ChucVuRepository extends JpaRepository<ChucVu, UUID> {
    List<ChucVu> findByTen(String name);
}
