package ru.kuzmina.spring.lesson2;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository {
    private List<Product> products;

    @PostConstruct
    public void init() {
        products = new ArrayList<>();
        products.add(new Product(1L, "Milk", 100));
        products.add(new Product(2L, "Eggs", 120));
        products.add(new Product(3L, "Bread", 50));
        products.add(new Product(4L, "Chicken", 200));
        products.add(new Product(5L, "Carrots", 45));
    }

    public List<Product> getAll(){
        return products;
    }

    public Optional<Product> getById(long id){
        return products.stream().filter(product -> product.getId()==id).findFirst();
    }

    @Override
    public String toString() {
        return "ProductRepository{" +
                "products=" + products +
                '}';
    }
}
