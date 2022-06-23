package com.example.shoppingcart.service;

import com.example.shoppingcart.entity.Order;
import com.example.shoppingcart.entity.Product;
import com.example.shoppingcart.entity.search.FilterParameter;
import com.example.shoppingcart.entity.search.OrderSpecification;
import com.example.shoppingcart.entity.search.SearchCriteria;
import com.example.shoppingcart.entity.search.SearchCriteriaOperator;
import com.example.shoppingcart.repository.OrderRepository;
import com.example.shoppingcart.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Page<Order> findAll(FilterParameter param) {
        Specification<Order> specification = Specification.where(null);
        if (param.getKeyword() != null && param.getKeyword().length() > 0) {
            SearchCriteria searchCriteria
                    = new SearchCriteria("keyword", SearchCriteriaOperator.JOIN, param.getKeyword());
            OrderSpecification filter = new OrderSpecification(searchCriteria);
            specification = specification.and(filter);
        }
        if (param.getStatus() != 0) {
            SearchCriteria searchCriteria
                    = new SearchCriteria("status", SearchCriteriaOperator.EQUALS, param.getStatus());
            OrderSpecification filter = new OrderSpecification(searchCriteria);
            specification = specification.and(filter);
        }
        if (param.getUserId() != null) {
            SearchCriteria searchCriteria
                    = new SearchCriteria("userId", SearchCriteriaOperator.EQUALS, param.getUserId());
            OrderSpecification filter = new OrderSpecification(searchCriteria);
            specification = specification.and(filter);
        }
        return orderRepository.findAll(
                specification, PageRequest.of(param.getPage() - 1, param.getLimit()));
    }

    public Optional<Order> findById(String id){
        return orderRepository.findById(id);
    }

    public Order save( Order product){
        return orderRepository.save(product);
    }

    public void deleteById( String id){
        orderRepository.deleteById(id);
    }


}
