package operations;


import java.util.List;

import models.Cart;

public interface CartOperations {
    boolean addToCart(int consumerId, int productId, int quantity);
    boolean removeFromCart(int consumerId, int productId);
    List<Cart> viewCart(int consumerId);
}