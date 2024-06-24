package sys.service.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sys.entity.Order;
import sys.exceptions.NotFoundException;
import sys.repository.OrderRepository;
import sys.service.OrderService;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;


    @Override
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order getOrderById(Long orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new NotFoundException("Order not found with ID: " + orderId));
    }

    @Override
    public void deleteOrder(Long orderId) {
        if (!orderRepository.findById(orderId).isPresent()) {
            throw new NotFoundException("Order not found with ID: " + orderId);
        }
        orderRepository.deleteById(orderId);
    }

}
