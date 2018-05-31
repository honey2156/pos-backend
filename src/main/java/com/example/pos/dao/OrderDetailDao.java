package com.example.pos.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.pos.model.OrderDetail;

/**
 * @author mandeepsingh
 *
 */
public interface OrderDetailDao extends CrudRepository<OrderDetail, Integer> {

}
