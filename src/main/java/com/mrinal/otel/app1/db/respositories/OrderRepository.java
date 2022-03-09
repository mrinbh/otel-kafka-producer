package com.mrinal.otel.app1.db.respositories;

import com.mrinal.otel.app1.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findById(int id);

    List<Order> findByStatus(String status);
}