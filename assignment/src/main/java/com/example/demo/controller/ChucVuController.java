package com.example.demo.controller;

import com.example.demo.model.ChucVu;
import com.example.demo.model.ChucVu;
import com.example.demo.repository.ChucVuRepository;
import jakarta.validation.Valid;
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
@RequestMapping("/chuc-vu")

public class ChucVuController {
    @Autowired
    ChucVuRepository chucVuRepository;

    @GetMapping("/hien-thi")
    public String hienThi(Model model) {


        ArrayList<ChucVu> list = (ArrayList<ChucVu>) chucVuRepository.findAll();
        model.addAttribute("listCV", list);
        System.out.println(list);



        return "/chuc-vu/chuc-vu";
    }
    @GetMapping("/view-add")
    public String viewAdd(Model model){
        model.addAttribute("chucvu", new ChucVu());

        return "/chuc-vu/add-chuc-vu";
    }

    @PostMapping("/add")
    public String them(Model model,
                       @Valid  @ModelAttribute("chucvu")  ChucVu chucVu,
                       BindingResult result
    ) {
        if (result.hasErrors()) {
            return "/chuc-vu/add-chuc-vu";
        }
        chucVuRepository.save(chucVu);
        return "redirect:/chuc-vu/hien-thi";
    }

    @GetMapping("/xoa/{id}")
    public String xoa(Model model,
                      @PathVariable("id") UUID id) {

        chucVuRepository.deleteById(id);

        return "redirect:/chuc-vu/hien-thi";
    }


    @GetMapping("/detail/{id}")
    public String detail(Model model,
                         @PathVariable("id") UUID id) {

        ChucVu chucVu = chucVuRepository.getOne(id);
        model.addAttribute("nv", chucVu);
        System.out.println(chucVu.toString());
        return "/chuc-vu/detail-chuc-vu";

    }

    @GetMapping("/update/{id}")
    public String updat(Model model, @PathVariable("id") UUID id) {
        ChucVu chucVu = chucVuRepository.getOne(id);
        model.addAttribute("nv", chucVu);
        System.out.println(chucVu.toString());
        return "/chuc-vu/update-chuc-vu";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") UUID id,

                         @RequestParam("ma") String ma,
                         @RequestParam("ten") String ten
                         ) {


        ChucVu chucVuUpdate = chucVuRepository.getOne(id);
        chucVuUpdate.setMa(ma);
        chucVuUpdate.setTen(ten);

        chucVuRepository.save(chucVuUpdate);

        return "redirect:/chuc-vu/hien-thi";
    }

    @PostMapping("/search")
    public String search(Model model,
                         @RequestParam("hoTen") String hoTen) {
        List<ChucVu> listsearch = chucVuRepository.findByTen(hoTen);

        model.addAttribute("listCV", listsearch);


        return "/chuc-vu/chuc-vu";
    }

}
