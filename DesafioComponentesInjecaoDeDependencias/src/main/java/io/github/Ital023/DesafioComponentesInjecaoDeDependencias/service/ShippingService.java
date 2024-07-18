package io.github.Ital023.DesafioComponentesInjecaoDeDependencias.service;

import io.github.Ital023.DesafioComponentesInjecaoDeDependencias.Entities.OrderEntity;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {

    public double shipment(OrderEntity orderEntity){
        if(isLessThanOneHundred(orderEntity.getBasic(), orderEntity.getDiscount())) return 20;

        if(isBetweenOneHundredAndTwoHundred(orderEntity.getBasic(), orderEntity.getDiscount())) return 12;

        return 0;
    }

    private boolean isLessThanOneHundred(Double basic, Double discount) {
        if ( getValueOfValueWithDiscount(basic, discount)  < 100 ) return true;

        return false;
    }

    private boolean isBetweenOneHundredAndTwoHundred(Double basic, Double discount) {
        if( getValueOfValueWithDiscount(basic, discount) >= 100
                && getValueOfValueWithDiscount(basic, discount) <= 200 ) {
            return true;
        }
        return false;
    }


    private double getValueOfValueWithDiscount(Double basic, Double discount){
        return basic - (basic * (discount / 100) );
    }

}
