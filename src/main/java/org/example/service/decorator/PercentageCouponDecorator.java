package org.example.service.decorator;


import org.example.service.product.Product;

public class PercentageCouponDecorator extends CouponDecorator{

    public Product product;
    int discountPercentage;

    public PercentageCouponDecorator(Product product, int discountPercentage) {
        this.product = product;
        this.discountPercentage = discountPercentage;
    }

    @Override
    public double getPrice() {
        double price =  product.getPrice();
        return price- (price*discountPercentage)/100;
    }
}
