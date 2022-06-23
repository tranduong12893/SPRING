package com.example.shoppingcart.service;

import com.example.shoppingcart.entity.Product;
import com.example.shoppingcart.repository.OrderDetailRepository;
import com.example.shoppingcart.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    public List<Product> findAll(){
        return orderDetailRepository.findAll();
    }

    public Optional<Product> findById(Long id){
        return orderDetailRepository.findById(id);
    }

    public Product save( Product product){
        return orderDetailRepository.save(product);
    }

    public void deleteById( Long id){
        orderDetailRepository.deleteById(id);
    }

}
