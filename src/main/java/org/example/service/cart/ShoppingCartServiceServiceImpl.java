package org.example.service.cart;

import lombok.extern.slf4j.Slf4j;
import org.example.model.dto.ShoppingCartRequest;
import org.example.model.dto.ShoppingCartResponse;
import org.example.service.decorator.CouponDecorator;
import org.example.support.ProductProcessingResult;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ShoppingCartServiceServiceImpl implements ShoppingCartService {

    List<CouponDecorator> couponDecoratorList;

    public ShoppingCartServiceServiceImpl(List<CouponDecorator> couponDecoratorList) {
        this.couponDecoratorList = couponDecoratorList;
    }

    @Override
    public ShoppingCartResponse addToCart(ShoppingCartRequest request) {
        var initialCartProducts = request.getCartProductLists();

        var processingResult = ProductProcessingResult.builder().cartProductsList(initialCartProducts).build();

        for(CouponDecorator couponDecorator : couponDecoratorList) {
            if(couponDecorator.isApplicable(request)){
                log.info("CouponDecorator [{}] is applicable and will be applied.", couponDecorator.getClass().getSimpleName());
                processingResult = couponDecorator.process(processingResult);
            }
        }
       return ShoppingCartResponse
               .builder()
               .cartProductLists(processingResult.getCartProductsList())
               .build();
    }
}
