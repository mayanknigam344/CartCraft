package org.example.service.decorator;

import org.example.service.product.Product;
import org.example.service.product.ProductType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TypeCouponDecorator implements CouponDecorator{
    private static final Logger log = LoggerFactory.getLogger(TypeCouponDecorator.class);
    static List<ProductType> typeList = new ArrayList<>();
    static{
        typeList.add(ProductType.ELECTRONICS);
    }

    @Override
    public Product process(Product product) {
        double orgPrice = product.getOriginalPrice();
        if(typeList.contains(product.getProductType())){
            double discountedPrice = orgPrice - (orgPrice*10)/100;
            log.info("Price After type discount {}",discountedPrice);
            product.setFinalPrice(discountedPrice);
            return product;
        }
        return product;
    }
}
