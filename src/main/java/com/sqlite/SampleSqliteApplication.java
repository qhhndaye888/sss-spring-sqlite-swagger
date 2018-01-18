
package com.sqlite;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.sqlite.dao.CustomerDao;
import com.sqlite.entities.Customer;


@SpringBootApplication
public class SampleSqliteApplication {
	private static final Logger log = LoggerFactory.getLogger(SampleSqliteApplication.class);

    	public static void main(String[] args) {
    	  ApplicationContext ctx = 
	  		SpringApplication.run(SampleSqliteApplication.class, args);
    }
    	@Bean
    	public CommandLineRunner demo(CustomerDao repository) {
    		return (args) -> {
    			// save a couple of customers
    			repository.save(new Customer("Jack", "Bauer"));
    			repository.save(new Customer("Chloe", "O'Brian"));
    			repository.save(new Customer("Kim", "Bauer"));
    			repository.save(new Customer("David", "Palmer"));
    			repository.save(new Customer("Michelle", "Dessler"));

    			// fetch all customers
    			log.info("Customers found with findAll():");
    			log.info("-------------------------------");
    			for (Customer customer : repository.findAll()) {
    				log.info(customer.toString());
    			}
    			log.info("");

    			// fetch an individual customer by ID
    			Customer customer = repository.findOne(1L);
    			log.info("Customer found with findOne(1L):");
    			log.info("--------------------------------");
    			log.info(customer.toString());
    			log.info("");

 
    		};
    	}
}
