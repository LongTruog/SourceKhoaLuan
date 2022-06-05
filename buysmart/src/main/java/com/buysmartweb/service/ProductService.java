package com.buysmartweb.service;

import com.buysmartweb.entity.Cart;
import com.buysmartweb.entity.OrderDetail;
import com.buysmartweb.entity.Product;
import com.buysmartweb.modelutil.CartItem;
import com.buysmartweb.modelutil.ProductAdminDTO;

import java.util.List;
public interface ProductService {
    List<Product> getListProductByCategoryId(int id);
    long getTotalPageByFill(float start, float end, int id);
    List<Product> getListProductFillByPage(float start, float end, long currentPage, int id);
    int getTotalByFill(float start, float end, int id);
    int getTotal(int id);
    List<Product> getListProductByHot();
    List<Product> getListSaleProduct();
    Product getProductById(int id);
    long getTotalPage(int id);
    List<Product> getByPage(long currentPage, int id);
    int getCategoryId(int id);
    List<CartItem> getProductFromCart(List<Cart> cartList);
    Float getTempPriceOfCart(List<CartItem> itemList);
    boolean addProduct(Product product);
    boolean deleteProduct(int id);
    void updateProduct(int id, Product product);
    List<ProductAdminDTO> findAll();
    List<Product> findProductByName(int id, String keyWord, long currentPage);
    long getTotalPageByName(int id, String keyWord);
    void saveAfterOrder(Product product, OrderDetail orderDetail);
}
