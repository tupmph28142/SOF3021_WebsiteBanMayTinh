package com.example.demo.controller;

import com.example.demo.model.ChiTietSanPham;
import com.example.demo.model.DongSanPham;

import com.example.demo.model.GioHang;
import com.example.demo.model.GioHangChiTiet;
import com.example.demo.model.IdGioHangChiTiet;
import com.example.demo.model.MauSac;
import com.example.demo.model.NhaSanXuat;
import com.example.demo.model.NhanVien;
import com.example.demo.model.SanPham;
import com.example.demo.repository.ChiTietSanPhamRepository;
import com.example.demo.repository.DongSanPhamRepository;
import com.example.demo.repository.MauSacRepository;
import com.example.demo.repository.NhaSanXuatRepository;
import com.example.demo.repository.SanPhamRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
@RequestMapping("/chi-tiet-san-pham")

public class ChiTietSanPhamController {
    @Autowired
    ChiTietSanPhamRepository chiTietSanPhamRepository;
    @Autowired
    MauSacRepository mauSacRepository;
    @Autowired
    SanPhamRepository sanPhamRepository;

    @Autowired
    NhaSanXuatRepository nhaSanXuatRepository;

    @Autowired
    DongSanPhamRepository dongSanPhamRepository;


    @GetMapping("/hien-thi")
    public String hienThi(Model model,@RequestParam(name = "page",defaultValue = "0") Integer pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber,3);
//        Page<ChiTietSanPham> chiTietSanPhamPage = chiTietSanPhamRepository.findAll(pageable);
//        model.addAttribute("listCTSP",chiTietSanPhamPage);


        ArrayList<ChiTietSanPham> listctsp = (ArrayList<ChiTietSanPham>) chiTietSanPhamRepository.findAll();


        model.addAttribute("listCTSP", listctsp);


        return "chi-tiet-san-pham/chi-tiet-san-pham";
    }

    @GetMapping("/view-add")
    public String viewAdd(Model model) {
        model.addAttribute("chitietsanpham", new ChiTietSanPham());
        ArrayList<ChiTietSanPham> listctsp = (ArrayList<ChiTietSanPham>) chiTietSanPhamRepository.findAll();
        ArrayList<MauSac> listms = (ArrayList<MauSac>) mauSacRepository.findAll();
        ArrayList<SanPham> listsp = (ArrayList<SanPham>) sanPhamRepository.findAll();
        ArrayList<NhaSanXuat> listnsx = (ArrayList<NhaSanXuat>) nhaSanXuatRepository.findAll();
        ArrayList<DongSanPham> listdsp = (ArrayList<DongSanPham>) dongSanPhamRepository.findAll();
        model.addAttribute("listMS", listms);
        model.addAttribute("listSP", listsp);
        model.addAttribute("listNSX", listnsx);
        model.addAttribute("listDSP", listdsp);
        return "chi-tiet-san-pham/add-chi-tiet-san-pham";
    }

    @PostMapping("/add")
    public String them(Model model,
                       @ModelAttribute("chitietsanpham") ChiTietSanPham chucVu,
                       BindingResult result
    ) {


        chiTietSanPhamRepository.save(chucVu);
        return "redirect:/chi-tiet-san-pham/hien-thi";
    }

    @GetMapping("/xoa/{id}")
    public String xoa(Model model,
                      @PathVariable("id") UUID id) {

        chiTietSanPhamRepository.deleteById(id);

        return "redirect:/chi-tiet-san-pham/hien-thi";
    }


    @GetMapping("/detail/{id}")
    public String detail(Model model,
                         @PathVariable("id") UUID id) {

        ChiTietSanPham chucVu = chiTietSanPhamRepository.findById(id).get();
        model.addAttribute("nv", chucVu);
        System.out.println(chucVu.toString());
        return "chi-tiet-san-pham/detail-chi-tiet-san-pham";

    }
    @GetMapping("/update/{id}")
    public String updat(Model model, @PathVariable("id") UUID id,@ModelAttribute("chitietsanphamupdate") ChiTietSanPham gioHangChiTiet) {
        ChiTietSanPham chiTietSanPham = chiTietSanPhamRepository.findById(id).get();
        List<SanPham> listSP = sanPhamRepository.findAll();
        List<NhaSanXuat> listNSX= nhaSanXuatRepository.findAll();
        List<MauSac> listMS = mauSacRepository.findAll();
        List<DongSanPham> listDSP = dongSanPhamRepository.findAll();
        model.addAttribute("chitietsanphamupdate", chiTietSanPham);
        model.addAttribute("listSP", listSP);
        model.addAttribute("listNSX", listNSX);
        model.addAttribute("listMS", listMS);
        model.addAttribute("listDSP", listDSP);

        return "chi-tiet-san-pham/update-chi-tiet-san-pham";
    }


    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") UUID id,


                         @ModelAttribute("chitietsanphamupdate") ChiTietSanPham chiTietSanPham
    ) {

        ChiTietSanPham chiTietSanPham1 = chiTietSanPhamRepository.findById(id).get();

        chiTietSanPham.setId(chiTietSanPham1.getId());
        BeanUtils.copyProperties(chiTietSanPham,chiTietSanPham1);

        chiTietSanPhamRepository.save(chiTietSanPham1);

        return "redirect:/chi-tiet-san-pham/hien-thi";
    }


    @PostMapping("/search")
    public String search(Model model,
                         @RequestParam("hoTen") String hoTen) {
//        List<ChiTietSanPham> listsearch = chiTietSanPhamRepository.(hoTen);

//        model.addAttribute("listGH", listsearch);


        return "chi-tiet-san-pham/chi-tiet-san-pham";
    }
}