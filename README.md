
# 🛒 CartCraft – A Smart Shopping Cart System with Dynamic Coupon Processing

This project is a simplified **Online Shopping Management System** implemented in Java using Spring Boot. It provides a backend structure for an e-commerce cart system where:

- Products can be added or removed from the cart.
- Each product can have **multiple coupons** applied.
- The system calculates the final price after applying applicable discounts.
- Implemented with extensible design patterns like the **Decorator Pattern** for coupon logic.

---

## 🚀 Features

- Add/Remove items from a shopping cart.
- Apply **multiple coupons** (e.g., type-based, percentage-based) to each product.
- Calculate final price using utilities.
- Payment strategy support (Card, Cash, etc.)
- Modular design using **Decorator Pattern** for coupon processing.
- Lightweight, extensible architecture with clean DTOs and services.
- Tested with JUnit 5

---

🧱 Design Patterns Used

✅ Decorator Pattern

Used to apply different types of discounts to cart products. You can chain decorators like PercentageCouponDecoratorImpl, TypeCouponDecoratorImpl, etc., to apply various discount rules.

✅ Strategy Pattern

Implemented basic skeleton for handling different payment methods.

💡 Extensibility

New coupon types can be added by creating a new CouponDecorator implementation.

New payment types can be added by implementing PaymentStrategy interface.

---

## 🛍️ Add to Cart Page Behavior

You can dynamically:
- Add more items to the cart.
- Delete items from the cart.
- Apply **multiple coupons per product**, and the system automatically processes them in the configured sequence.

---

## 🔧 Technologies Used

- Java 17
- Spring Boot
- JUnit 5
- Mockito
- Lombok

---

## 📁 Project Structure

```
├── controller
│   └── ShoppingController.java
├── service
│   ├── cart
│   │   └── ShoppingCartServiceImpl.java
│   └── decorator
│       ├── PercentageCouponDecoratorImpl.java
│       └── TypeCouponDecoratorImpl.java
├── model
│   ├── dto
│   └── product
├── util
│   └── ProductPaymentUtil.java
└── test
    └── controller
        └── ShoppingControllerTest.java
```

📬 Feedback or Contributions

Feel free to open an issue or submit a pull request!
