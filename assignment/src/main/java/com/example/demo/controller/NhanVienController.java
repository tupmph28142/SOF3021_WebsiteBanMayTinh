package com.example.demo.controller;

import com.example.demo.model.ChiTietSanPham;
import com.example.demo.model.ChucVu;
import com.example.demo.model.NhanVien;

import com.example.demo.repository.ChiTietSanPhamRepository;
import com.example.demo.repository.ChucVuRepository;
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
@RequestMapping("/nhan-vien")
public class NhanVienController {


    @Autowired
    NhanVienRepository nhanVienRepository;

    @Autowired
    ChucVuRepository chucVuRepository;

    @Autowired
    ChiTietSanPhamRepository chiTietSanPhamRepository;


    @GetMapping("/hien-thi")
    public String hienThi(Model model) {

        ArrayList<NhanVien> list = (ArrayList<NhanVien>) nhanVienRepository.findAll();
//        ArrayList<ChucVu> list = (ArrayList<ChucVu>) chucVuRepository.findAll();
        model.addAttribute("listNV", list);



        return "/nhan-vien/index";
    }
    @GetMapping("/view-add")
    public String viewAdd(Model model){
        model.addAttribute("nhanvien", new NhanVien());

        return "/nhan-vien/add-nhan-vien";
    }

    @PostMapping("/add")
    public String them(Model model,
                       @ModelAttribute("nhanvien") NhanVien nhanVien,
                       BindingResult result
    ) {
        nhanVienRepository.save(nhanVien);
        return "redirect:/nhan-vien/hien-thi";
    }

    @GetMapping("/xoa/{id}")
    public String xoa(Model model,
                      @PathVariable("id") UUID id) {

        nhanVienRepository.deleteById(id);

        return "redirect:/nhan-vien/hien-thi";
    }


    @GetMapping("/detail/{id}")
    public String detail(Model model,
                         @PathVariable("id") UUID id) {

        NhanVien nhanVien = nhanVienRepository.getOne(id);
        model.addAttribute("nv", nhanVien);
        System.out.println(nhanVien.toString());
        return "/nhan-vien/detail";

    }

    @GetMapping("/update/{id}")
    public String updat(Model model,@PathVariable("id") UUID id,@ModelAttribute("nhanvienupdate") NhanVien nhanVien) {
        NhanVien nhanVien1 = nhanVienRepository.findById(id).get();
        model.addAttribute("nhanvienupdate",nhanVien1);

        return "/nhan-vien/update-nhan-vien";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") UUID id,@ModelAttribute("nhanvienupdate") NhanVien nhanVien

                         ) {


        NhanVien nhanVienUpdate = nhanVienRepository.findById(id).get();
        nhanVien.setId(nhanVienUpdate.getId());
        BeanUtils.copyProperties(nhanVien,nhanVienUpdate);


        nhanVienRepository.save(nhanVienUpdate);

        return "redirect:/nhan-vien/hien-thi";
    }

    @PostMapping("/search")
    public String search(Model model,
                         @RequestParam("hoTen") String hoTen) {
        List<NhanVien> listsearch = nhanVienRepository.findByTen(hoTen);

        model.addAttribute("listNV", listsearch);


        return "/nhan-vien/index";
    }


}
