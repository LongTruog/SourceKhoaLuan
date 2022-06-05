package com.buysmartweb.service.impl;

import com.buysmartweb.entity.Category;
import com.buysmartweb.repository.CategoryRepo;
import com.buysmartweb.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImp implements CategoryService {
    private final CategoryRepo categoryRepo;

    public CategoryServiceImp(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @Override
    public List<Category> getListCategory() {
        return categoryRepo.findAll();
    }

    @Override
    public Optional<Category> getCategoryById(int id) {
        return categoryRepo.findById(id);
    }

    @Override
    public boolean addCategory(Category category) {
        categoryRepo.save(category);
        return true;
    }

    @Override
    public boolean deleteCategory(int id) {
        categoryRepo.delete(categoryRepo.getById(id));
        return true;
    }

    @Override
    public void updateCategory(int id, Category category) {
        Category categoryDB = categoryRepo.getById(id);
        if (!category.getName().isEmpty()) categoryDB.setName(category.getName());
        if (!category.getDescription().isEmpty()) categoryDB.setDescription(category.getDescription());
        categoryRepo.save(categoryDB);
    }

    @Override
    public Category save(Category category) {
        return this.categoryRepo.save(category);
    }
}
