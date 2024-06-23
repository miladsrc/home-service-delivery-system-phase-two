package service.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import repository.OrderRepository;
import service.OrderService;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
}
