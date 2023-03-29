package com.project.dao.rcm;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entities.rcm.Product;


public interface ProductRepository extends JpaRepository<Product, Integer> {

}
