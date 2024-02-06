package com.backend.springbootdeveloper.order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);

}
