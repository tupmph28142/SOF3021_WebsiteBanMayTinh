package com.example.demo.controller;





import com.example.demo.model.ChiTietSanPham;
import com.example.demo.model.GioHang;

import com.example.demo.model.GioHangChiTiet;
import com.example.demo.model.HoaDon;
import com.example.demo.model.HoaDonChiTiet;
import com.example.demo.model.IdGioHangChiTiet;
import com.example.demo.model.IdHoaDonChiTiet;
import com.example.demo.repository.ChiTietSanPhamRepository;
import com.example.demo.repository.GioHangChiTietRepository;
import com.example.demo.repository.GioHangRepository;
import com.example.demo.repository.HoaDonChiTietRepository;
import com.example.demo.repository.HoaDonRepository;
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
@RequestMapping("/hoa-don-chi-tiet")

public class HoaDonChiTietController {
    @Autowired
    HoaDonChiTietRepository hoaDonChiTietRepository;
    @Autowired
    ChiTietSanPhamRepository chiTietSanPhamRepository;

    @Autowired
    HoaDonRepository hoaDonRepository;





    @GetMapping("/hien-thi")
    public String hienThi(Model model) {


        ArrayList<HoaDonChiTiet> list = (ArrayList<HoaDonChiTiet>) hoaDonChiTietRepository.findAll();


        model.addAttribute("listHDCT", list);
//        System.out.println(list);



        return "/hoa-don-chi-tiet/hoa-don-chi-tiet";
    }
    @GetMapping("/view-add")
    public String viewAdd(Model model){
        model.addAttribute("hoadonchitiet", new HoaDonChiTiet());
        ArrayList<HoaDon> listhd = (ArrayList<HoaDon>) hoaDonRepository.findAll();
        ArrayList<ChiTietSanPham> listctsp = (ArrayList<ChiTietSanPham>) chiTietSanPhamRepository.findAll();
        model.addAttribute("listHD", listhd);
        model.addAttribute("listCTSP", listctsp);
        return "/hoa-don-chi-tiet/add-hoa-don-chi-tiet";
    }

    @PostMapping("/add")
    public String them(Model model,
                       @ModelAttribute("hoadonchitiet") HoaDonChiTiet hoaDonChiTiet,
                       BindingResult result
    ) {
        hoaDonChiTietRepository.save(hoaDonChiTiet);
        return "redirect:/hoa-don-chi-tiet/hien-thi";
    }

    @GetMapping("/xoa/{idHD}/{idCTSP}")
    public String xoa(Model model,
                      @PathVariable("idHD") UUID idHD,
                      @PathVariable("idCTSP") UUID idCTSP
    ) {
        HoaDon hoaDon = new HoaDon();
        hoaDon.setId(idHD);
        ChiTietSanPham chiTietSanPham = new ChiTietSanPham();
        chiTietSanPham.setId(idCTSP);
        IdHoaDonChiTiet idHoaDonChiTiet = new IdHoaDonChiTiet(hoaDon,chiTietSanPham);

        hoaDonChiTietRepository.deleteById(idHoaDonChiTiet);

        return "redirect:/hoa-don-chi-tiet/hien-thi";
    }


    @GetMapping("/detail/{idHD}/{idCTSP}")
    public String detail(Model model, @PathVariable("idHD") UUID idHD,@PathVariable("idCTSP") UUID idCTSP) {
        HoaDon hoaDon = new HoaDon();
        hoaDon.setId(idHD);
        ChiTietSanPham chiTietSanPham = new ChiTietSanPham();
        chiTietSanPham.setId(idCTSP);
        IdHoaDonChiTiet idHoaDonChiTiet = new IdHoaDonChiTiet(hoaDon,chiTietSanPham);
        HoaDonChiTiet hoaDonChiTiet = hoaDonChiTietRepository.findById(idHoaDonChiTiet).orElse(null);
        model.addAttribute("nv", hoaDonChiTiet);
        System.out.println(hoaDonChiTiet.toString());
        return "/hoa-don-chi-tiet/detail-hoa-don-chi-tiet";
    }

    @GetMapping("/update/{idHD}/{idCTSP}")
    public String updat(Model model, @PathVariable("idHD") UUID idHD,@PathVariable("idCTSP") UUID idCTSP,@ModelAttribute("hoadonchitietupdate") HoaDonChiTiet hoaDonChiTiet) {
        HoaDon hoaDon = new HoaDon();
        hoaDon.setId(idHD);
        ChiTietSanPham chiTietSanPham = new ChiTietSanPham();
        chiTietSanPham.setId(idCTSP);
        IdHoaDonChiTiet idHoaDonChiTiet = new IdHoaDonChiTiet(hoaDon,chiTietSanPham);
        HoaDonChiTiet hoaDonChiTietUpdate = hoaDonChiTietRepository.findById(idHoaDonChiTiet).orElse(null);
        HoaDonChiTiet hoaDonChiTietFind= hoaDonChiTietRepository.findById(idHoaDonChiTiet).get();
        List<HoaDon> listHD=hoaDonRepository.findAll();
        List<ChiTietSanPham> listCTSP = chiTietSanPhamRepository.findAll();

        model.addAttribute("hoadonchitietupdate", hoaDonChiTietUpdate);
        model.addAttribute("ctgh", hoaDonChiTietUpdate);
        model.addAttribute("listHD", listHD);
        model.addAttribute("listCTSP", listCTSP);
        model.addAttribute("hdctf", hoaDonChiTietFind);

        return "/hoa-don-chi-tiet/update-hoa-don-chi-tiet";
    }

    @PostMapping("/update/{idHD}/{idCTSP}")
    public String update(@PathVariable("idHD") UUID idHD,
                         @PathVariable("idCTSP") UUID idCTSP,

                         @ModelAttribute("hoadonchitietupdate") HoaDonChiTiet hoaDonChiTiet
    ) {
        HoaDon hoaDon = new HoaDon();
        hoaDon.setId(idHD);
        ChiTietSanPham chiTietSanPham = new ChiTietSanPham();
        chiTietSanPham.setId(idCTSP);
        IdHoaDonChiTiet idHoaDonChiTiet = new IdHoaDonChiTiet(hoaDon,chiTietSanPham);

        HoaDonChiTiet hoaDonChiTiet1 = hoaDonChiTietRepository.findById(idHoaDonChiTiet).get();
        IdHoaDonChiTiet idHoaDonChiTiet1 = hoaDonChiTiet1.getId();
        hoaDonChiTiet.setId(idHoaDonChiTiet1);
        BeanUtils.copyProperties(hoaDonChiTiet,hoaDonChiTiet1);
//



        hoaDonChiTietRepository.save(hoaDonChiTiet1);


//


        return "redirect:/hoa-don-chi-tiet/hien-thi";
    }

//    @PostMapping("/search")
//    public String search(Model model,
//                         @RequestParam("hoTen") String hoTen) {
//        List<HoaDonChiTiet> listsearch = hoaDonChiTietRepository.findByMa(hoTen);
//
//        model.addAttribute("listGH", listsearch);
//
//
//        return "hoa-don-chi-tiet";
//    }
}