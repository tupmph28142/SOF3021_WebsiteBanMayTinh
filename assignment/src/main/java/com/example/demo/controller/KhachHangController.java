package com.example.demo.controller;

import com.example.demo.model.ChiTietSanPham;
import com.example.demo.model.DongSanPham;
import com.example.demo.model.KhachHang;

import com.example.demo.model.KhachHang;
import com.example.demo.model.MauSac;
import com.example.demo.model.NhaSanXuat;
import com.example.demo.model.NhanVien;
import com.example.demo.model.SanPham;
import com.example.demo.repository.GioHangRepository;
import com.example.demo.repository.KhachHangRepository;
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
@RequestMapping("/khach-hang")

public class KhachHangController {

    @Autowired
    KhachHangRepository khachHangRepository;



    @GetMapping("/hien-thi")
    public String hienThi(Model model) {
        ArrayList<KhachHang> list = (ArrayList<KhachHang>) khachHangRepository.findAll();
        model.addAttribute("listGH", list);
        System.out.println(list);
        return "khach-hang/khach-hang";
    }
    @GetMapping("/view-add")
    public String viewAdd(Model model){
        model.addAttribute("khachhang", new KhachHang());
        ArrayList<KhachHang> listkh = (ArrayList<KhachHang>) khachHangRepository.findAll();

        model.addAttribute("listKH", listkh);

        return "khach-hang/add-khach-hang";
    }

    @PostMapping("/add")
    public String them(Model model,
                       @ModelAttribute("khachhang") KhachHang chucVu,
                       BindingResult result
    ) {


        khachHangRepository.save(chucVu);
        return "redirect:/khach-hang/hien-thi";
    }

    @GetMapping("/xoa/{id}")
    public String xoa(Model model,
                      @PathVariable("id") UUID id) {

        khachHangRepository.deleteById(id);

        return "redirect:/khach-hang/hien-thi";
    }


    @GetMapping("/detail/{id}")
    public String detail(Model model,
                         @PathVariable("id") UUID id) {

        KhachHang chucVu = khachHangRepository.findById(id).get();
        model.addAttribute("nv", chucVu);
        System.out.println(chucVu.toString());
        return "khach-hang/detail-khach-hang";

    }

    @GetMapping("/update/{id}")
    public String updat(Model model, @PathVariable("id") UUID id,@ModelAttribute("khachhangupdate") KhachHang gioHangChiTiet) {
        KhachHang gioHang = khachHangRepository.findById(id).get();
        model.addAttribute("khachhangupdate", gioHang);
        return "khach-hang/update-khach-hang";
    }


    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") UUID id,


                         @ModelAttribute("khachhangupdate") KhachHang gioHang
    ) {

        KhachHang gioHang1 = khachHangRepository.findById(id).get();

        gioHang.setId(gioHang1.getId());
        BeanUtils.copyProperties(gioHang,gioHang1);

        khachHangRepository.save(gioHang1);

        return "redirect:/khach-hang/hien-thi";
    }

    @PostMapping("/search")
    public String search(Model model,
                         @RequestParam("hoTen") String hoTen) {
        List<KhachHang> listsearch = khachHangRepository.findByMa(hoTen);

        model.addAttribute("listGH", listsearch);


        return "/khach-hang/khach-hang";
    }
}