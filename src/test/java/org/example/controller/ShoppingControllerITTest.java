package org.example.controller;

import org.example.model.dto.ShoppingCartRequest;
import org.example.service.product.CartProduct;
import org.example.service.product.Category;
import org.example.service.product.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.HashMap;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext
@EnableAutoConfiguration
@ActiveProfiles("logs-stdout")

// TODO: This is just for reference
class ShoppingControllerITTest {

    private static final String SHOW_CART_URL = "/showCart";

    @Autowired private MockMvc mockMvc;

    @Test
    void showCart() throws Exception {
        // given
        var request = buildShoppingCartRequest();

        // when then
        mockMvc
                .perform(
                        MockMvcRequestBuilders.post(SHOW_CART_URL)
                                .contentType(MediaType.APPLICATION_JSON_VALUE)
                                .accept(MediaType.APPLICATION_JSON_VALUE)
                                .content(request.toString()))
                // TODO: Add the expected message here
                .andExpect(
                        MockMvcResultMatchers.content().string("expectedMessage"))
                .andExpect(status().isOk());
    }

    private ShoppingCartRequest buildShoppingCartRequest() {
        var shoppingCartRequest = new ShoppingCartRequest();
        var product = Product.builder().id(1).productName("ABC").category(Category.ELECTRONICS).originalPrice(1000).build();
        var cartProduct = CartProduct.builder().product(product).quantity(2).build();
        HashMap<Integer,CartProduct> cartProductHashMap = new HashMap<>();
        cartProductHashMap.put(1,cartProduct);
        shoppingCartRequest.setCartProductLists(cartProductHashMap);
        return shoppingCartRequest;
    }
}