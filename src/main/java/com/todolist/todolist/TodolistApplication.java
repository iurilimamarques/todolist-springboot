package com.todolist.todolist;

import com.todolist.todolist.resources.AtividadeResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TodolistApplication {
        
        @Autowired
        AtividadeResource atividadeResource;
        
	public static void main(String[] args) {
		SpringApplication.run(TodolistApplication.class, args);
	}
        
        @Bean
	public CommandLineRunner seedServicosTable() {
            return args -> { 


            };	
	}

}
