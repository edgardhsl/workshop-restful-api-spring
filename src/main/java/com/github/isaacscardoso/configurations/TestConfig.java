package com.github.isaacscardoso.configurations;

import com.github.isaacscardoso.domain.Category;
import com.github.isaacscardoso.domain.Customer;
import com.github.isaacscardoso.domain.Order;
import com.github.isaacscardoso.domain.Product;
import com.github.isaacscardoso.domain.enums.OrderStatus;
import com.github.isaacscardoso.repositories.CategoryRepository;
import com.github.isaacscardoso.repositories.CustomerRepository;
import com.github.isaacscardoso.repositories.OrderRepository;
import com.github.isaacscardoso.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class TestConfig implements CommandLineRunner {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {

        categoryRepository.deleteAll();
        customerRepository.deleteAll();
        orderRepository.deleteAll();
        productRepository.deleteAll();

        Category cat1 = new Category(null, "Eletronics");
        Category cat2 = new Category(null, "Tools");
        Category cat3 = new Category(null, "Furniture");

        Customer customer1 = new Customer(null, "Isaac Cardoso Silva", "140.693.576-02","19/12/1998" , "isaacsilvablues@outlook.com", "(37) 99916-2472");
        Order order1 = new Order(null, OrderStatus.PAID, customer1);
        Product product1 = new Product(null, "RTX 3090", "A melhor placa de vídeo.", 4999.99, "https://www.nvidia.com/content/dam/en-zz/Solutions/geforce/ampere/rtx-3090/geforce-rtx-3090-shop-600-p@2x.png");

        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        customerRepository.save(customer1);
        orderRepository.save(order1);
        productRepository.save(product1);
    }
}
