package com.example.demo.controller;

import com.example.demo.model.ChiTietSanPham;
import com.example.demo.model.DongSanPham;
import com.example.demo.model.GioHang;

import com.example.demo.model.KhachHang;
import com.example.demo.model.MauSac;
import com.example.demo.model.NhaSanXuat;
import com.example.demo.model.NhanVien;
import com.example.demo.model.SanPham;
import com.example.demo.repository.GioHangRepository;
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
@RequestMapping("/gio-hang")

public class GioHangController {
    @Autowired
    GioHangRepository gioHangRepository;
      @Autowired
      NhanVienRepository nhanVienRepository;
      @Autowired
      KhachHangRepository khachHangRepository;



    @GetMapping("/hien-thi")
    public String hienThi(Model model) {


        ArrayList<GioHang> list = (ArrayList<GioHang>) gioHangRepository.findAll();
        ArrayList<KhachHang> listkh = (ArrayList<KhachHang>) khachHangRepository.findAll();
        ArrayList<NhanVien> listnv = (ArrayList<NhanVien>) nhanVienRepository.findAll();


        model.addAttribute("listGH", list);
        model.addAttribute("listKH", listkh);
        model.addAttribute("listNV", listnv);
        System.out.println(list);



        return "gio-hang/gio-hang";
    }
    @GetMapping("/view-add")
    public String viewAdd(Model model){
        model.addAttribute("giohang", new GioHang());
        ArrayList<KhachHang> listkh = (ArrayList<KhachHang>) khachHangRepository.findAll();
        ArrayList<NhanVien> listnv = (ArrayList<NhanVien>) nhanVienRepository.findAll();
        model.addAttribute("listKH", listkh);
        model.addAttribute("listNV", listnv);
        return "gio-hang/view-add-gio-hang";
    }

    @PostMapping("/add")
    public String them(Model model,
                       @ModelAttribute("giohang") GioHang chucVu,
                       BindingResult result
    ) {
        KhachHang khachHang = new KhachHang();
        NhanVien nhanVien = new NhanVien();
        khachHang.setId(chucVu.getKhachHang().getId());
        nhanVien.setId(chucVu.getNhanVien().getId());

        gioHangRepository.save(chucVu);
        return "redirect:/gio-hang/hien-thi";
    }

    @GetMapping("/xoa/{id}")
    public String xoa(Model model,
                      @PathVariable("id") UUID id) {

        gioHangRepository.deleteById(id);

        return "redirect:/gio-hang/hien-thi";
    }


    @GetMapping("/detail/{id}")
    public String detail(Model model,
                         @PathVariable("id") UUID id) {

        GioHang chucVu = gioHangRepository.getOne(id);
        model.addAttribute("nv", chucVu);
        System.out.println(chucVu.toString());
        return "gio-hang/detail-gio-hang";

    }

    @GetMapping("/update/{id}")
    public String updat(Model model, @PathVariable("id") UUID id,@ModelAttribute("giohangupdate") GioHang gioHangChiTiet) {
        GioHang gioHang = gioHangRepository.findById(id).get();
        List<KhachHang> listKH = khachHangRepository.findAll();
        List<NhanVien> listNV= nhanVienRepository.findAll();

        model.addAttribute("giohangupdate", gioHang);
        model.addAttribute("listKH", listKH);
        model.addAttribute("listNV", listNV);


        return "gio-hang/update-gio-hang";
    }


    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") UUID id,


                         @ModelAttribute("giohangupdate") GioHang gioHang
    ) {

        GioHang gioHang1 = gioHangRepository.findById(id).get();

        gioHang.setId(gioHang1.getId());
        BeanUtils.copyProperties(gioHang,gioHang1);

        gioHangRepository.save(gioHang1);

        return "redirect:/gio-hang/hien-thi";
    }


    @PostMapping("/search")
    public String search(Model model,
                         @RequestParam("hoTen") String hoTen) {
        List<GioHang> listsearch = gioHangRepository.findByMa(hoTen);

        model.addAttribute("listGH", listsearch);


        return "/gio-hang/gio-hang";
    }
}