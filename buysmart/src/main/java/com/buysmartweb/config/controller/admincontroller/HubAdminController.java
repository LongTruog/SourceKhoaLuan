package com.buysmartweb.config.controller.admincontroller;

import com.buysmartweb.constaint.FormatPrice;
import com.buysmartweb.modelutil.ProductAdminDTO;
import com.buysmartweb.modelutil.SearchDTO;
import com.buysmartweb.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
//Kho Hang Admin
public class HubAdminController {
    private final AdminService adminService;
    private final FormatPrice formatPrice;

    public HubAdminController(AdminService adminService, FormatPrice formatPrice) {
        this.adminService = adminService;
        this.formatPrice = formatPrice;
    }

    @ModelAttribute
    public void addFormatService(Model model) {
        model.addAttribute("format", formatPrice);
    }

    @GetMapping("/admin/hub")
    public String getViewHub(Model model) {
        List<ProductAdminDTO> dsProduct = adminService.getHub();
        model.addAttribute("input", new SearchDTO());
        model.addAttribute("dsProduct", dsProduct);
        return "admin-page/hub";
    }

}
