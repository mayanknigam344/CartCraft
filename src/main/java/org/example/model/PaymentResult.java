package org.example.model;

import lombok.Builder;
import lombok.Value;
import org.assertj.core.error.future.Warning;
import org.example.model.dto.ShoppingCartResponse;

import java.util.List;

@Value
@Builder
public class PaymentResult {
    ShoppingCartResponse shoppingCartResponse;
    List<Warning> warnings;

    public boolean isSuccessful() {
        return warnings.isEmpty();
    }
}
