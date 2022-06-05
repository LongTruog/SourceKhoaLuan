package com.buysmartweb.service.impl;

import com.buysmartweb.entity.OrderDetail;
import com.buysmartweb.entity.Orders;
import com.buysmartweb.entity.Product;
import com.buysmartweb.repository.OrderDetailRepo;
import com.buysmartweb.service.OrderDetailService;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailServiceImp implements OrderDetailService {

    private final OrderDetailRepo orderDetailRepo;

    public OrderDetailServiceImp(OrderDetailRepo orderDetailRepo) {
        this.orderDetailRepo = orderDetailRepo;
    }

    @Override
    public OrderDetail saveOrderDetail(
            Product product, Orders orders, Float price, Integer quantity) {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrders(orders);
        orderDetail.setProduct(product);
        if(product.getQuantityProd() <= quantity) orderDetail.setQuantity(product.getQuantityProd());
        else orderDetail.setQuantity(quantity);
        orderDetail.setPrice(orderDetail.getQuantity()* product.getSalePrice() * (100-product.getPercentDiscount())/100);
        return orderDetailRepo.saveAndFlush(orderDetail);
    }
}
