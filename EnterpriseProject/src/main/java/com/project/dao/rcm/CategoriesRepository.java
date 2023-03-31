package com.project.dao.rcm;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entities.rcm.Categories;

public interface CategoriesRepository extends JpaRepository<Categories, Integer> {

}
