package com.sqlite.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sqlite.entities.Customer;
@Repository
public interface CustomerDao extends JpaRepository<Customer, Long>{

}
