package com.kurmi.todos.controllers;

import com.kurmi.todos.domain.Todo;
import com.kurmi.todos.others.NotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TodosController {

    private final List<Todo> todoItems;

    public TodosController() {
        todoItems = new ArrayList<Todo>();
        todoItems.add(new Todo("Prayer", "Go to temple", false));
        todoItems.add(new Todo("Bike", "Get it cleaned", false));
        todoItems.add(new Todo("Car", "You don't have car", false));
        todoItems.add(new Todo("Go home", "No need to remind", false));
    }

    @GetMapping("/")
    public String home(){
       return " <h2> Welcome! It's time to do ! </h2> ";
    }

    @GetMapping("/todos")
    public List<Todo> getTodos(){
        return todoItems;
    }

    @GetMapping("/todos/{id}")
    public Todo getTodoById(@PathVariable int id){
        if(id < 0 || id > todoItems.size()) {
            throw new NotFoundException("No todo found with id : " + id);
        }

        return todoItems.get(id);
    }
}
