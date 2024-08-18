package org.example.service.decorator;

import org.example.service.product.Product;
import org.example.service.product.ProductType;

import java.util.ArrayList;
import java.util.List;

public class TypeCouponDecorator extends CouponDecorator{
    Product product;
    int discountPercentage;
    ProductType productType;

    static List<ProductType> typeList = new ArrayList<>();
    static{
        typeList.add(ProductType.ELECTRONICS);
    }

    public TypeCouponDecorator(Product product, int discountPercentage,ProductType productType) {
        this.product = product;
        this.discountPercentage = discountPercentage;
        this.productType = productType;
    }

    @Override
    public double getPrice() {
        double price = product.getPrice();
        if(typeList.contains(productType)){
            return price - (price*discountPercentage)/100;
        }
        return price;
    }
}
