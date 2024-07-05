package sys.service;

import sys.entity.Order;

import java.util.List;

public interface OrderService {
    Order saveOrder(Order order);

    Order getOrderById(Long orderId);

    void deleteOrder(Long orderId);

}
