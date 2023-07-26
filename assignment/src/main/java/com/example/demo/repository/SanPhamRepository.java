package com.example.demo.repository;

import com.example.demo.model.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface SanPhamRepository extends JpaRepository<SanPham, UUID> {
    List<SanPham> findByTen(String  name);
}
