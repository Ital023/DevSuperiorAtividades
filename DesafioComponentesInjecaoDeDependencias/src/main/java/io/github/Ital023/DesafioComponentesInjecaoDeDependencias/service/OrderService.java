package io.github.Ital023.DesafioComponentesInjecaoDeDependencias.service;

import io.github.Ital023.DesafioComponentesInjecaoDeDependencias.Entities.OrderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private ShippingService shippingService;

    public double total(OrderEntity orderEntity){
        double shippingTax = shippingService.shipment(orderEntity);

        return orderEntity.getBasic() - (orderEntity.getBasic() * (orderEntity.getDiscount() / 100) ) + shippingTax;
    }



}
