package com.Darshan.LearnException.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Darshan.LearnException.Model.Products;

public interface ProductRepos extends JpaRepository<Products, Long>{
	
	Products findByPid(long id);

}
