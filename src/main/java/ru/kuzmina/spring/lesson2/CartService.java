package ru.kuzmina.spring.lesson2;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Optional;

@Service
@Scope("prototype")
public class CartService {
    private ProductRepository products;
    private Cart cart;

    public CartService(ProductRepository productRepository) {
        products = productRepository;
    }

    @PostConstruct
    private void init() {
        cart = new Cart();
    }

    public void addProductById(Long productId) {
        Optional<Product> product = products.getById(productId);
        product.ifPresent(value -> cart.add(value));
    }

    public Cart getCart() {
        return cart;
    }

    public void clear() {
        cart.clear();
    }
}
