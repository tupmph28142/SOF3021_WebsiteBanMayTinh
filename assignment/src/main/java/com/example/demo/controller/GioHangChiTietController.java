package com.example.demo.controller;





import com.example.demo.model.ChiTietSanPham;
import com.example.demo.model.GioHang;

import com.example.demo.model.GioHangChiTiet;
import com.example.demo.model.IdGioHangChiTiet;
import com.example.demo.repository.ChiTietSanPhamRepository;
import com.example.demo.repository.GioHangChiTietRepository;
import com.example.demo.repository.GioHangRepository;
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

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/gio-hang-chi-tiet")

public class GioHangChiTietController {
    @Autowired
    GioHangRepository gioHangRepository;
    @Autowired
    ChiTietSanPhamRepository chiTietSanPhamRepository;

    @Autowired
    GioHangChiTietRepository gioHangChiTietRepository;

    private IdGioHangChiTiet idGioHangChiTiet = new IdGioHangChiTiet();



    @GetMapping("/hien-thi")
    public String hienThi(Model model) {


        ArrayList<GioHangChiTiet> list = (ArrayList<GioHangChiTiet>) gioHangChiTietRepository.findAll();


        model.addAttribute("listGH", list);
//        System.out.println(list);



        return "/gio-hang-chi-tiet/gio-hang-chi-tiet";
    }
    @GetMapping("/view-add")
    public String viewAdd(Model model){
        model.addAttribute("giohangchitiet", new GioHangChiTiet());
        ArrayList<GioHang> listgh = (ArrayList<GioHang>) gioHangRepository.findAll();
        ArrayList<ChiTietSanPham> listctsp = (ArrayList<ChiTietSanPham>) chiTietSanPhamRepository.findAll();
        model.addAttribute("listGH", listgh);
        model.addAttribute("listCTSP", listctsp);
        return "/gio-hang-chi-tiet/add-gio-hang-chi-tiet";
    }

    @PostMapping("/add")
    public String them(Model model,
                       @ModelAttribute("giohangchitiet") GioHangChiTiet gioHangChiTiet,
                       BindingResult result
    ) {
       gioHangChiTietRepository.save(gioHangChiTiet);
        return "redirect:/gio-hang-chi-tiet/hien-thi";
    }

    @GetMapping("/xoa/{idGH}/{idCTSP}")
    public String xoa(Model model,
                      @PathVariable("idGH") UUID idGH,
                      @PathVariable("idCTSP") UUID idCTSP
                      ) {
        IdGioHangChiTiet idGioHangChiTiet = new IdGioHangChiTiet(idGH,idCTSP);

        gioHangChiTietRepository.deleteById(idGioHangChiTiet);

        return "redirect:/gio-hang-chi-tiet/hien-thi";
    }


    @GetMapping("/detail/{idGH}/{idCTSP}")
    public String detail(Model model, @PathVariable("idGH") UUID idGH,@PathVariable("idCTSP") UUID idCTSP) {
        IdGioHangChiTiet idGioHangChiTiet = new IdGioHangChiTiet(idGH,idCTSP);
        GioHangChiTiet gioHangChiTiet = gioHangChiTietRepository.findById(idGioHangChiTiet).orElse(null);
        model.addAttribute("nv", gioHangChiTiet);
        System.out.println(gioHangChiTiet.toString());
        return "/gio-hang-chi-tiet/detail-gio-hang-chi-tiet";
    }

    @GetMapping("/update/{idGH}/{idCTSP}")
    public String updat(Model model, @PathVariable("idGH") UUID idGH,@PathVariable("idCTSP") UUID idCTSP,@ModelAttribute("giohangchitietupdate") GioHangChiTiet gioHangChiTiet) {
        IdGioHangChiTiet idGioHangChiTiet = new IdGioHangChiTiet(idGH,idCTSP);
        GioHangChiTiet gioHangChiTietUpdate = gioHangChiTietRepository.findById(idGioHangChiTiet).get();

        GioHangChiTiet gioHangChiTietFind= gioHangChiTietRepository.findById(idGioHangChiTiet).get();
        List<GioHang> listGH=gioHangRepository.findAll();
        List<ChiTietSanPham> listCTSP = chiTietSanPhamRepository.findAll();

        model.addAttribute("giohangchitietupdate", gioHangChiTietUpdate);
        model.addAttribute("ctgh", gioHangChiTietUpdate);
        model.addAttribute("listGH", listGH);
        model.addAttribute("listCTSP", listCTSP);
        model.addAttribute("ghctf", gioHangChiTietFind);

        return "/gio-hang-chi-tiet/update-gio-hang-chi-tiet";
    }

    @PostMapping("/update/{idGH}/{idCTSP}")
    public String update(@PathVariable("idGH") UUID idGH,
                        @PathVariable("idCTSP") UUID idCTSP,

                        @ModelAttribute("giohangchitietupdate") GioHangChiTiet gioHangChiTiet
    ) {
        IdGioHangChiTiet idGioHangChiTiet = new IdGioHangChiTiet(idGH,idCTSP);

        GioHangChiTiet gioHangChiTiet1 = gioHangChiTietRepository.findById(idGioHangChiTiet).get();
        IdGioHangChiTiet idGioHangChiTiet1 = gioHangChiTiet1.getId();
        gioHangChiTiet.setId(idGioHangChiTiet1);
        BeanUtils.copyProperties(gioHangChiTiet,gioHangChiTiet1);

        gioHangChiTietRepository.save(gioHangChiTiet1);

        return "redirect:/gio-hang-chi-tiet/hien-thi";
    }

//    @PostMapping("/search")
//    public String search(Model model,
//                         @RequestParam("hoTen") String hoTen) {
//        List<GioHangChiTiet> listsearch = gioHangChiTietRepository.findByMa(hoTen);
//
//        model.addAttribute("listGH", listsearch);
//
//
//        return "gio-hang-chi-tiet";
//    }
}