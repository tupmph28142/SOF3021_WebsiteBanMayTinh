package com.example.demo.repository;

import com.example.demo.model.HoaDonChiTiet;
import com.example.demo.model.IdHoaDonChiTiet;
import com.example.demo.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface HoaDonChiTietRepository extends JpaRepository<HoaDonChiTiet, IdHoaDonChiTiet> {

}
