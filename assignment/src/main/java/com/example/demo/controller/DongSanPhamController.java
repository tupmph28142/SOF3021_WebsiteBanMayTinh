package com.example.demo.controller;

import com.example.demo.model.ChiTietSanPham;
import com.example.demo.model.ChucVu;
import com.example.demo.model.DongSanPham;
import com.example.demo.model.MauSac;
import com.example.demo.model.NhaSanXuat;
import com.example.demo.model.SanPham;
import com.example.demo.repository.ChucVuRepository;
import com.example.demo.repository.DongSanPhamRepository;
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
@RequestMapping("/dong-san-pham")
public class DongSanPhamController {
    @Autowired
    DongSanPhamRepository dongSanPhamRepository;

    @GetMapping("/hien-thi")
    public String hienThi(Model model) {


        ArrayList<DongSanPham> list = (ArrayList<DongSanPham>) dongSanPhamRepository.findAll();
        model.addAttribute("listCV", list);
        System.out.println(list);



        return "/dong-san-pham/dong-san-pham";
    }
    @GetMapping("/view-add")
    public String viewAdd(Model model){
        model.addAttribute("dongsanpham", new DongSanPham());

        return "/dong-san-pham/add-dong-san-pham";
    }

    @PostMapping("/add")
    public String them(Model model,
                       @ModelAttribute("dongsanpham") DongSanPham chucVu,
                       BindingResult result
    ) {
        dongSanPhamRepository.save(chucVu);
        return "redirect:/dong-san-pham/hien-thi";
    }

    @GetMapping("/xoa/{id}")
    public String xoa(Model model,
                      @PathVariable("id") UUID id) {

        dongSanPhamRepository.deleteById(id);

        return "redirect:/dong-san-pham/hien-thi";
    }


    @GetMapping("/detail/{id}")
    public String detail(Model model,
                         @PathVariable("id") UUID id) {

        DongSanPham chucVu = dongSanPhamRepository.findById(id).get();
        model.addAttribute("nv", chucVu);
        System.out.println(chucVu.toString());
        return "/dong-san-pham/detail-dong-san-pham";

    }

    @GetMapping("/update/{id}")
    public String updat(Model model, @PathVariable("id") UUID id,@ModelAttribute("dongsanphamupdate") DongSanPham gioHangChiTiet) {
        DongSanPham chiTietSanPham = dongSanPhamRepository.findById(id).get();


        model.addAttribute("dongsanphamupdate", chiTietSanPham);


        return "dong-san-pham/update-dong-san-pham";
    }


    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") UUID id,


                         @ModelAttribute("dongsanphamupdate") DongSanPham chiTietSanPham
    ) {

        DongSanPham chiTietSanPham1 = dongSanPhamRepository.findById(id).get();

        chiTietSanPham.setId(chiTietSanPham1.getId());
        BeanUtils.copyProperties(chiTietSanPham,chiTietSanPham1);

        dongSanPhamRepository.save(chiTietSanPham1);

        return "redirect:/dong-san-pham/hien-thi";
    }
    @PostMapping("/search")
    public String search(Model model,
                         @RequestParam("hoTen") String hoTen) {
        List<DongSanPham> listsearch = dongSanPhamRepository.findByTen(hoTen);

        model.addAttribute("listCV", listsearch);


        return "/dong-san-pham/dong-san-pham";
    }
}
