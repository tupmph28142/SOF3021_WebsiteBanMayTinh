package com.example.demo.controller;

import com.example.demo.model.MauSac;
import com.example.demo.model.SanPham;
import com.example.demo.repository.MauSacRepository;
import com.example.demo.repository.SanPhamRepository;
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
@RequestMapping("/mau-sac")
public class MauSacController {
    @Autowired
    MauSacRepository mauSacRepository;

    @GetMapping("/hien-thi")
    public String hienThi(Model model) {


        ArrayList<MauSac> list = (ArrayList<MauSac>) mauSacRepository.findAll();
        model.addAttribute("listSP", list);
        System.out.println(list);



        return "/mau-sac/mau-sac";
    }
    @GetMapping("/view-add")
    public String viewAdd(Model model){
        model.addAttribute("mausac", new MauSac());

        return "/mau-sac/add-mau-sac";
    }

    @PostMapping("/add")
    public String them(Model model,
                       @ModelAttribute("mausac") MauSac sanPham,
                       BindingResult result
    ) {
        mauSacRepository.save(sanPham);
        return "redirect:/mau-sac/hien-thi";
    }

    @GetMapping("/xoa/{id}")
    public String xoa(Model model,
                      @PathVariable("id") UUID id) {

        mauSacRepository.deleteById(id);

        return "redirect:/mau-sac/hien-thi";
    }


    @GetMapping("/detail/{id}")
    public String detail(Model model,
                         @PathVariable("id") UUID id) {

        MauSac sanPham = mauSacRepository.findById(id).get();
        model.addAttribute("nv", sanPham);
        System.out.println(sanPham.toString());
        return "/mau-sac/detail-mau-sac";

    }

    @GetMapping("/update/{id}")
    public String updat(Model model, @PathVariable("id") UUID id) {
        MauSac sanPham = mauSacRepository.getOne(id);
        model.addAttribute("nv", sanPham);
        System.out.println(sanPham.toString());
        return "/mau-sac/update-mau-sac";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") UUID id,

                         @RequestParam("ma") String ma,
                         @RequestParam("ten") String ten
    ) {


        MauSac sanPhamUpdate = mauSacRepository.getOne(id);
        sanPhamUpdate.setMa(ma);
        sanPhamUpdate.setTen(ten);

        mauSacRepository.save(sanPhamUpdate);

        return "redirect:/mau-sac/hien-thi";
    }

//    @PostMapping("/search")
//    public String search(Model model,
//                         @RequestParam("hoTen") String hoTen) {
//        List<MauSac> listsearch = mauSacRepository.findByTen(hoTen);
//
//        model.addAttribute("listSP", listsearch);
//
//
//        return "/mau-sac/mau-sac";
//    }
}
