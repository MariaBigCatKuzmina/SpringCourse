package ru.kuzmina.spring.lesson2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.naming.Context;

public class MainApp {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        CartService cart1 = context.getBean(CartService.class);
        cart1.addProductById(2L);
        cart1.addProductById(4L);

        CartService cart2 = context.getBean(CartService.class);
        cart2.addProductById(1L);
        cart2.addProductById(5L);
        cart2.addProductById(2L);

        System.out.println("Cart1: " + cart1.getCart());
        System.out.println("Cart2: " + cart2.getCart());



        context.close();
    }



}
