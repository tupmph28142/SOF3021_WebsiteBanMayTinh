package com.example.demo.controller;

import com.example.demo.model.ChiTietSanPham;
import com.example.demo.model.DongSanPham;
import com.example.demo.model.HoaDon;

import com.example.demo.model.KhachHang;
import com.example.demo.model.MauSac;
import com.example.demo.model.NhaSanXuat;
import com.example.demo.model.NhanVien;
import com.example.demo.model.SanPham;
import com.example.demo.repository.GioHangRepository;
import com.example.demo.repository.HoaDonRepository;
import com.example.demo.repository.KhachHangRepository;
import com.example.demo.repository.NhanVienRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/hoa-don")

public class HoaDonController {
    @Autowired
    HoaDonRepository hoaDonRepository;
    @Autowired
    NhanVienRepository nhanVienRepository;
    @Autowired
    KhachHangRepository khachHangRepository;



    @GetMapping("/hien-thi")
    public String hienThi(Model model) {
        ArrayList<HoaDon> list = (ArrayList<HoaDon>) hoaDonRepository.findAll();
        model.addAttribute("listGH", list);
        System.out.println(list);
        return "hoa-don/hoa-don";
    }
    @GetMapping("/view-add")
    public String viewAdd(Model model){
        model.addAttribute("hoadon", new HoaDon());
        ArrayList<KhachHang> listkh = (ArrayList<KhachHang>) khachHangRepository.findAll();
        ArrayList<NhanVien> listnv = (ArrayList<NhanVien>) nhanVienRepository.findAll();
        model.addAttribute("listKH", listkh);
        model.addAttribute("listNV", listnv);
        return "hoa-don/add-hoa-don";
    }

    @PostMapping("/add")
    public String them(Model model,
                       @ModelAttribute("hoadon") HoaDon chucVu,
                       BindingResult result
    ) {


        hoaDonRepository.save(chucVu);
        return "redirect:/hoa-don/hien-thi";
    }

    @GetMapping("/xoa/{id}")
    public String xoa(Model model,
                      @PathVariable("id") UUID id) {

        hoaDonRepository.deleteById(id);

        return "redirect:/hoa-don/hien-thi";
    }


    @GetMapping("/detail/{id}")
    public String detail(Model model,
                         @PathVariable("id") UUID id) {

        HoaDon chucVu = hoaDonRepository.findById(id).get();
        model.addAttribute("nv", chucVu);
        System.out.println(chucVu.toString());
        return "hoa-don/detail-hoa-don";

    }

    @GetMapping("/update/{id}")
    public String updat(Model model, @PathVariable("id") UUID id,@ModelAttribute("hoadonupdate") HoaDon gioHangChiTiet) {
        HoaDon gioHang = hoaDonRepository.findById(id).get();
        List<KhachHang> listKH = khachHangRepository.findAll();
        List<NhanVien> listNV= nhanVienRepository.findAll();

        model.addAttribute("hoadonupdate", gioHang);
        model.addAttribute("listKH", listKH);
        model.addAttribute("listNV", listNV);


        return "hoa-don/update-hoa-don";
    }


    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") UUID id,


                         @ModelAttribute("hoadonupdate") HoaDon gioHang
    ) {

        HoaDon gioHang1 = hoaDonRepository.findById(id).get();

        gioHang.setId(gioHang1.getId());
        BeanUtils.copyProperties(gioHang,gioHang1);

        hoaDonRepository.save(gioHang1);

        return "redirect:/hoa-don/hien-thi";
    }

    @PostMapping("/search")
    public String search(Model model,
                         @RequestParam("hoTen") String hoTen) {
        List<HoaDon> listsearch = hoaDonRepository.findByMa(hoTen);

        model.addAttribute("listGH", listsearch);


        return "/hoa-don/hoa-don";
    }
}