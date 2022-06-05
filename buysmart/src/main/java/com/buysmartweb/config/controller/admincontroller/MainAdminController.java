package com.buysmartweb.config.controller.admincontroller;

import com.buysmartweb.constaint.FormatPrice;
import com.buysmartweb.modelutil.ChartDTO;
import com.buysmartweb.modelutil.DateFilterDTO;
import com.buysmartweb.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainAdminController {
    private final AdminService adminService;
    private final FormatPrice formatPrice;

    public MainAdminController(AdminService adminService, FormatPrice formatPrice) {
        this.adminService = adminService;
        this.formatPrice = formatPrice;
    }

    @ModelAttribute
    public void getTopOrder(Model model) {
        model.addAttribute("topOder", adminService.getTopOrderDetail());
        model.addAttribute("format", formatPrice);
        model.addAttribute("countUser", adminService.countCustomer());
        model.addAttribute("getRevenue", adminService.getRevenue());
        model.addAttribute("countOrder", adminService.countOrders());
        model.addAttribute("getCostOfProduct", adminService.getCostOfProduct());
    }
    @GetMapping("/admin")
    public String getViewMainAdmin(Model model) {
        model.addAttribute("dateFill", new DateFilterDTO());
        model.addAttribute("dsProduct", adminService.getListProduct());
        return "admin-page/admin";
    }
    @PostMapping("/admin/fill")
    public String getViewStatisticAdmin(Model model, @ModelAttribute DateFilterDTO dateFilterDTO, BindingResult bindingResult) {
        if (dateFilterDTO.getStartFill() == null || dateFilterDTO.getEndFill() == null || bindingResult.hasErrors()) return "redirect:/admin";
        ChartDTO chartDTO = new ChartDTO();
        chartDTO.setRevenue(adminService.getTotalPriceByDate(dateFilterDTO.getStartFill(),dateFilterDTO.getEndFill()));
        chartDTO.setCost(adminService.getImportPriceByDate(dateFilterDTO.getStartFill(),dateFilterDTO.getEndFill()));
        model.addAttribute("totalFill", chartDTO.getRevenue());
        model.addAttribute("importFill", chartDTO.getCost());
        model.addAttribute("countOrdersFill", adminService.getTotalOrdersByDate(dateFilterDTO.getStartFill(),dateFilterDTO.getEndFill()));
        model.addAttribute("countUserFill", adminService.getTotalUserId(dateFilterDTO.getStartFill(),dateFilterDTO.getEndFill()));
        model.addAttribute("dateFill", dateFilterDTO);
        model.addAttribute("dateParam", dateFilterDTO);
        model.addAttribute("chartDTO", chartDTO);
        adminService.findOrderDetailByDay(dateFilterDTO.getStartFill(), dateFilterDTO.getEndFill()).forEach(orderAdmin -> System.err.println(orderAdmin.toString()));
        model.addAttribute("dsProduct", adminService.findOrderDetailByDay(dateFilterDTO.getStartFill(), dateFilterDTO.getEndFill()));

        return "admin-page/admin2";
    }

    @GetMapping("/get-chart-information")
    @ResponseBody
    public ChartDTO handleChartInformation() {
        return adminService.getInformationForChart();
    }

}
