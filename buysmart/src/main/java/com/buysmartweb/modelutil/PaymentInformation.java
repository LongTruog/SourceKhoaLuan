package com.buysmartweb.modelutil;

import com.buysmartweb.entity.Orders;
import com.buysmartweb.entity.Product;
import com.buysmartweb.entity.User;
import lombok.Data;

@Data
public class PaymentInformation {
     User user;
     Product product;
     Orders order;
}
