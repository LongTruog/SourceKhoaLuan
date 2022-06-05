package com.buysmartweb.service;

import com.buysmartweb.entity.OrderDetail;
import com.buysmartweb.entity.Orders;
import com.buysmartweb.entity.Product;

public interface OrderDetailService {
    OrderDetail saveOrderDetail(Product product, Orders orders, Float price, Integer quantity);
}
