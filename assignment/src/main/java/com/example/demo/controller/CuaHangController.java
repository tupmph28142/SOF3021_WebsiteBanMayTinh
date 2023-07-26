package com.example.demo.controller;

import com.example.demo.model.CuaHang;

import com.example.demo.repository.CuaHangRepository;
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
@RequestMapping("/cua-hang")
public class CuaHangController {
    @Autowired
    CuaHangRepository cuaHangRepository;

    @GetMapping("/hien-thi")
    public String hienThi(Model model) {


        ArrayList<CuaHang> list = (ArrayList<CuaHang>) cuaHangRepository.findAll();
        model.addAttribute("listCV", list);
        System.out.println(list);



        return "/cua-hang/cua-hang";
    }
    @GetMapping("/view-add")
    public String viewAdd(Model model){
        model.addAttribute("cuahang", new CuaHang());

        return "/cua-hang/add-cua-hang";
    }

    @PostMapping("/add")
    public String them(Model model,
                       @ModelAttribute("cuahang") CuaHang chucVu,
                       BindingResult result
    ) {
        cuaHangRepository.save(chucVu);
        return "redirect:/cua-hang/hien-thi";
    }

    @GetMapping("/xoa/{id}")
    public String xoa(Model model,
                      @PathVariable("id") UUID id) {

        cuaHangRepository.deleteById(id);

        return "redirect:/cua-hang/hien-thi";
    }


    @GetMapping("/detail/{id}")
    public String detail(Model model,
                         @PathVariable("id") UUID id) {

        CuaHang chucVu = cuaHangRepository.findById(id).get();
        model.addAttribute("nv", chucVu);
        System.out.println(chucVu.toString());
        return "/cua-hang/detail-cua-hang";

    }

    @GetMapping("/update/{id}")
    public String updat(Model model, @PathVariable("id") UUID id,@ModelAttribute("cuahangupdate") CuaHang gioHangChiTiet) {
        CuaHang chiTietSanPham = cuaHangRepository.findById(id).get();


        model.addAttribute("cuahangupdate", chiTietSanPham);


        return "cua-hang/update-cua-hang";
    }


    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") UUID id,


                         @ModelAttribute("cuahangupdate") CuaHang chiTietSanPham
    ) {

        CuaHang chiTietSanPham1 = cuaHangRepository.findById(id).get();

        chiTietSanPham.setId(chiTietSanPham1.getId());
        BeanUtils.copyProperties(chiTietSanPham,chiTietSanPham1);

        cuaHangRepository.save(chiTietSanPham1);

        return "redirect:/cua-hang/hien-thi";
    }
    @PostMapping("/search")
    public String search(Model model,
                         @RequestParam("hoTen") String hoTen) {
        List<CuaHang> listsearch = cuaHangRepository.findByTen(hoTen);

        model.addAttribute("listCV", listsearch);


        return "/cua-hang/cua-hang";
    }
}

