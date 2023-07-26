package com.example.demo.controller;

import com.example.demo.model.NhaSanXuat;

import com.example.demo.repository.NhaSanXuatRepository;
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
@RequestMapping("/nha-san-xuat")
public class NhaSanXuatController {
    @Autowired
    NhaSanXuatRepository nhaSanXuatRepository;

    @GetMapping("/hien-thi")
    public String hienThi(Model model) {


        ArrayList<NhaSanXuat> list = (ArrayList<NhaSanXuat>) nhaSanXuatRepository.findAll();
        model.addAttribute("listCV", list);
        System.out.println(list);



        return "/nha-san-xuat/nha-san-xuat";
    }
    @GetMapping("/view-add")
    public String viewAdd(Model model){
        model.addAttribute("nhasanxuat", new NhaSanXuat());

        return "/nha-san-xuat/add-nha-san-xuat";
    }

    @PostMapping("/add")
    public String them(Model model,
                       @ModelAttribute("nhasanxuat") NhaSanXuat chucVu,
                       BindingResult result
    ) {
        nhaSanXuatRepository.save(chucVu);
        return "redirect:/nha-san-xuat/hien-thi";
    }

    @GetMapping("/xoa/{id}")
    public String xoa(Model model,
                      @PathVariable("id") UUID id) {

        nhaSanXuatRepository.deleteById(id);

        return "redirect:/nha-san-xuat/hien-thi";
    }


    @GetMapping("/detail/{id}")
    public String detail(Model model,
                         @PathVariable("id") UUID id) {

        NhaSanXuat chucVu = nhaSanXuatRepository.findById(id).get();
        model.addAttribute("nv", chucVu);
        System.out.println(chucVu.toString());
        return "/nha-san-xuat/detail-nha-san-xuat";

    }

    @GetMapping("/update/{id}")
    public String updat(Model model, @PathVariable("id") UUID id,@ModelAttribute("nhasanxuatupdate") NhaSanXuat gioHangChiTiet) {
        NhaSanXuat chiTietSanPham = nhaSanXuatRepository.findById(id).get();


        model.addAttribute("nhasanxuatupdate", chiTietSanPham);


        return "nha-san-xuat/update-nha-san-xuat";
    }


    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") UUID id,


                         @ModelAttribute("nhasanxuatupdate") NhaSanXuat chiTietSanPham
    ) {

        NhaSanXuat chiTietSanPham1 = nhaSanXuatRepository.findById(id).get();

        chiTietSanPham.setId(chiTietSanPham1.getId());
        BeanUtils.copyProperties(chiTietSanPham,chiTietSanPham1);

        nhaSanXuatRepository.save(chiTietSanPham1);

        return "redirect:/nha-san-xuat/hien-thi";
    }
    @PostMapping("/search")
    public String search(Model model,
                         @RequestParam("hoTen") String hoTen) {
        List<NhaSanXuat> listsearch = nhaSanXuatRepository.findByTen(hoTen);

        model.addAttribute("listCV", listsearch);


        return "/nha-san-xuat/nha-san-xuat";
    }
}

