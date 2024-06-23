package sys.service.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sys.repository.OrderRepository;
import sys.service.OrderService;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
}
