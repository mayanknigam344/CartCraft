package org.example.util;

import lombok.experimental.UtilityClass;
import org.example.model.dto.ShoppingCartResponse;
import org.example.service.product.CartProduct;
import org.example.service.product.Product;

@UtilityClass
public class ProductPaymentUtil {

    public Product applyDiscountToProduct(Product product, double discountPercentage) {
        double originalPrice = getProductPrice(product);
        double discountedPrice = originalPrice - (originalPrice * discountPercentage) / 100;

        return product.toBuilder().finalPrice(discountedPrice).build();
    }

    public double calculateTotalPrice(ShoppingCartResponse shoppingCartResponse) {
        double totalPrice = 0.0;

        for (var entry : shoppingCartResponse.getCartProductLists().entrySet()) {
            CartProduct cartProduct = entry.getValue();
            double productTotalPrice = calculateProductTotalPrice(cartProduct);
            totalPrice += productTotalPrice;

            System.out.println("Product ID: " + entry.getKey() + " | Total price: " + productTotalPrice);
        }

        return totalPrice;
    }

    private double calculateProductTotalPrice(CartProduct cartProduct) {
        double finalPrice = getProductPrice(cartProduct.getProduct());
        return finalPrice * cartProduct.getQuantity();
    }
    private double getProductPrice(Product product) {
        return product.getFinalPrice() != 0 ? product.getFinalPrice() : product.getOriginalPrice();
    }
}
