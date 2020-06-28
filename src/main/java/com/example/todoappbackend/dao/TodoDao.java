package com.example.todoappbackend.dao;

import com.example.todoappbackend.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoDao extends JpaRepository<Todo, Integer> { }
