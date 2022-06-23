package com.example.shoppingcart.seeder;

import com.example.shoppingcart.entity.*;
import com.example.shoppingcart.entity.enums.UserStatus;
import com.example.shoppingcart.repository.UserRepository;
import com.github.javafaker.Faker;
import com.example.shoppingcart.entity.enums.OrderSimpleStatus;
import com.example.shoppingcart.entity.enums.ProductSimpleStatus;
import com.example.shoppingcart.repository.OrderRepository;
import com.example.shoppingcart.repository.ProductRepository;
import com.example.shoppingcart.util.StringHelper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.*;

@Component
public class ApplicationSeeder implements CommandLineRunner {

    boolean createSeedData = false;
    final OrderRepository orderRepository;
    final ProductRepository productRepository;
    final UserRepository userRepository;
    Faker faker;
    int numberOfProduct = 200;
    int numberOfOrder = 10000;
    int numberOfUser = 20;

    public ApplicationSeeder(
            OrderRepository orderRepository,
            ProductRepository productRepository,
            UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
        this.faker = new Faker();
    }

    @Override
    public void run(String... args) throws Exception {
        if(createSeedData){
            orderRepository.deleteAll();
            productRepository.deleteAll();
            userRepository.deleteAll();
            seedUser();
            seedProduct();
            seedOrder();

        }
    }

    private void seedUser(){
        List<User> listUser = new ArrayList<>();
        for (int i = 0; i < numberOfUser; i++) {
            System.out.println(i + 1);
            User user = new User();
            user.setId(UUID.randomUUID().toString());
            user.setFullName(faker.name().title());
            user.setPassword(faker.internet().password());
            user.setEmail(faker.internet().emailAddress());
            user.setPhone(faker.phoneNumber().toString());
            user.setAddress(faker.address().toString());
            Date randomDob = faker.date().birthday(18, 60);
            user.setDob(randomDob);
            user.setStatus(UserStatus.ACTIVE);
            listUser.add(user);
            System.out.println(user.toString());
        }
        userRepository.saveAll(listUser);
    }
    private void seedOrder() {
        List<Product> products = productRepository.findAll();
        List<Order> orders = new ArrayList<>();
        List<User> users = userRepository.findAll();
        for (int i = 0; i < numberOfOrder; i++) {
            Order order = new Order();
            String randomUserId = String.valueOf(faker.number().numberBetween(1, 20));
            order.setUserId(String.valueOf(users.get(Integer.parseInt(randomUserId))));
            order.setId(UUID.randomUUID().toString());
            Set<OrderDetail> orderDetails = new HashSet<>();
            int randomOrderDetailNumber = faker.number().numberBetween(1, 5);
            HashSet<String> existingProductId = new HashSet<>();
            for (int j = 0; j < randomOrderDetailNumber; j++) {
                OrderDetail orderDetail = new OrderDetail();
                Product randomProduct = products.get(
                        faker.number().numberBetween(0, products.size() - 1));
                if (existingProductId.contains(randomProduct.getId())) {
                    continue;
                }
                existingProductId.add(randomProduct.getId());
                orderDetail.setId(new OrderDetailId(order.getId(), randomProduct.getId()));
                orderDetail.setOrder(order);
                orderDetail.setProduct(randomProduct);
                orderDetail.setUnitPrice(randomProduct.getPrice());
                orderDetail.setQuantity(faker.number().numberBetween(1, 5));
                order.addTotalPrice(orderDetail);
                orderDetails.add(orderDetail);
                System.out.println(order.toString());
            }
            order.setOrderDetails(orderDetails);
            order.setStatus(OrderSimpleStatus.DONE);
            orders.add(order);
        }
        orderRepository.saveAll(orders);
    }

    private void seedProduct() {
        List<Product> listProduct = new ArrayList<>();
        for (int i = 0; i < numberOfProduct; i++) {
            System.out.println(i + 1);
            Product product = new Product();
            product.setId(UUID.randomUUID().toString());
            product.setName(faker.name().title());
            product.setSlug(StringHelper.toSlug(product.getName()));
            product.setDescription(faker.lorem().sentence());
            product.setPrice(
                    new BigDecimal(faker.number().numberBetween(100, 200) * 10000));
            product.setCreatedBy("0");
            product.setUpdatedBy("0");
            product.setDetail(faker.lorem().sentence());
            product.setThumbnail(faker.avatar().image());
            product.setStatus(ProductSimpleStatus.ACTIVE);
            listProduct.add(product);
            System.out.println(product.toString());
        }
        productRepository.saveAll(listProduct);
    }

    public static void main(String[] args) {

    }
}
