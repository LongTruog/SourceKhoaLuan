package com.buysmartweb.service;

import com.buysmartweb.entity.Cart;
import com.buysmartweb.entity.Orders;
import com.buysmartweb.entity.Product;

import java.util.List;
import java.util.Optional;

public interface CartService {
    boolean saveItemToCart(Product product, Integer quantity);
    List<Cart> getAllCartByUser();
    Integer countNumberOfItemInCart();
    boolean deleteAllItemInCart();
    void saveNewQuantity(List<Cart> cartList, List<Integer> soluong);
    boolean deleteAnItemInCart(int productId);
    void saveItemToCartByOrder(Orders orders);

    Optional<Cart> findById(Integer id);

    Cart save(Cart cart);
}
