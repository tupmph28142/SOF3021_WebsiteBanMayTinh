package com.example.demo.controller;

import com.example.demo.model.ChucVu;
import com.example.demo.model.SanPham;
import com.example.demo.model.SanPham;
import com.example.demo.repository.SanPhamRepository;
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
@RequestMapping("/san-pham")

public class SanPhamController {
    @Autowired
    SanPhamRepository sanphamrepo;

    @GetMapping("/hien-thi")
    public String hienThi(Model model) {


        ArrayList<SanPham> list = (ArrayList<SanPham>) sanphamrepo.findAll();
        model.addAttribute("listSP", list);
        System.out.println(list);



        return "san-pham/san-pham";
    }
    @GetMapping("/view-add")
    public String viewAdd(Model model){
        model.addAttribute("sanpham", new SanPham());

        return "san-pham/add-san-pham";
    }

    @PostMapping("/add")
    public String them(Model model,
                       @ModelAttribute("sanpham") SanPham sanPham,
                       BindingResult result
    ) {
        sanphamrepo.save(sanPham);
        return "redirect:/san-pham/hien-thi";
    }

    @GetMapping("/xoa/{id}")
    public String xoa(Model model,
                      @PathVariable("id") UUID id) {

        sanphamrepo.deleteById(id);

        return "redirect:/san-pham/hien-thi";
    }


    @GetMapping("/detail/{id}")
    public String detail(Model model,
                         @PathVariable("id") UUID id) {

        SanPham sanPham = sanphamrepo.findById(id).get();
        model.addAttribute("nv", sanPham);
        System.out.println(sanPham.toString());
        return "san-pham/detail-san-pham";

    }

    @GetMapping("/update/{id}")
    public String updat(Model model, @PathVariable("id") UUID id,@ModelAttribute("sanphamupdate") SanPham sanPham) {
        SanPham sanPham1 = sanphamrepo.findById(id).get();


        model.addAttribute("sanphamupdate", sanPham1);


        return "san-pham/update-san-pham";
    }


    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") UUID id,


                         @ModelAttribute("sanphamupdate") SanPham sanPham
    ) {

        SanPham sanpham1 = sanphamrepo.findById(id).get();

        sanPham.setId(sanpham1.getId());
        BeanUtils.copyProperties(sanPham,sanpham1);

        sanphamrepo.save(sanpham1);

        return "redirect:/san-pham/hien-thi";
    }

    @PostMapping("/search")
    public String search(Model model,
                         @RequestParam("hoTen") String hoTen) {
        List<SanPham> listsearch = sanphamrepo.findByTen(hoTen);

        model.addAttribute("listSP", listsearch);


        return "san-pham/san-pham";
    }
}