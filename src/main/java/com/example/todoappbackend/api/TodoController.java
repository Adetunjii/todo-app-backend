package com.example.todoappbackend.api;


import com.example.todoappbackend.dao.TodoDao;
import com.example.todoappbackend.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000"})
@RequestMapping(path = "/api/todo")
public class TodoController {

    @Autowired
    private final TodoDao todoDao;

    public TodoController(TodoDao todoDao) {
        this.todoDao = todoDao;
    }

    @GetMapping
    public List<Todo> getAllItems() {
        return this.todoDao.findAll();
    }

    @GetMapping("/{id}")
    public Todo getTodoById(@PathVariable Integer id) {
        return todoDao.findById(id)
                .orElseThrow(() -> new TodoNotFoundException(id));
    }

    @PostMapping("/post")
    public Todo addTodoItem(@RequestBody Todo todoItem){
         return todoDao.save(todoItem);
    }

    @DeleteMapping("/{id}")
    public void deleteTodoItem(@PathVariable Integer id) {
        todoDao.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public Todo updateTodoItem(@PathVariable Integer id, @RequestBody Todo todo) {
        Todo itemToUpdate = todoDao.findById(id).orElseThrow(() -> new TodoNotFoundException(id));
        itemToUpdate.setName(todo.getName());
        itemToUpdate.setDescription(todo.getDescription());
        return todoDao.save(itemToUpdate);
    }


}
