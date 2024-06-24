package sys.service;

import sys.entity.Order;

public interface OrderService {
    Order saveOrder(Order order);

    Order getOrderById(Long orderId);

    void deleteOrder(Long orderId);
}
