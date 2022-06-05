package com.buysmartweb.service.impl;

import com.buysmartweb.entity.Cart;
import com.buysmartweb.entity.Category;
import com.buysmartweb.entity.Product;
import com.buysmartweb.modelutil.StaffsDTO;
import com.buysmartweb.repository.ProductRepo;
import com.buysmartweb.service.CartService;
import com.buysmartweb.service.CategoryService;
import com.buysmartweb.service.StartupService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.BooleanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StartupServiceImpl implements StartupService {

    private final ProductRepo productRepo;

    @Value("${data.staff.override:false}")
    private Boolean override;

    @Value("classpath:thoitrang.json")
    private Resource staffResource;

    @Value("${category_id}")
    private Integer categoryId;

    @Autowired
    private CategoryService categoryService;

    @PostConstruct
    public void init() throws IOException {
        if(BooleanUtils.isTrue(override)) {
            StaffsDTO staffsDTO = new ObjectMapper().readValue(staffResource.getFile(), StaffsDTO.class);

            Category category = this.categoryService.getCategoryById(this.categoryId)
                    .orElse(new Category(this.categoryId));

            Category category1 = this.categoryService.save(category);

            List<Product> products = staffsDTO.getStaff().stream().map(d -> {
                Product p = new Product();
                p.setCategory(category1);
                p.setImage(d.getImage());
                p.setUrl(d.getUrl());
                p.setDescription(d.getContent());
                p.setName(d.getContent());
                p.setPercentDiscount(0F);
                p.setQuantityProd(100);
                p.setCost(d.getPrice() == null ? 0 : Float.parseFloat((d.getPrice().split(" ")[0]).replace(".", "")));
                p.setSalePrice(d.getPrice() == null ? 0 : Float.parseFloat((d.getPrice().split(" ")[0]).replace(".", "")));
                return p;
            }).collect(Collectors.toList());
            productRepo.saveAll(products);
            System.out.println(staffsDTO);
        }
    }

}
