package org.marre.webapplication.controller;

import org.marre.webapplication.model.TodoItem;
import org.marre.webapplication.service.TodoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author :marRE
 * @Description:
 * @Date :2024/5/28
 */
@RestController
@RequestMapping("/todo")
@CrossOrigin(origins = "http://localhost:8080")
public class TodoItemController {

    @Autowired
    private TodoItemService todoItemService;

    @RequestMapping("/add")
    public ResponseEntity<?> addTodoItem(@RequestBody TodoItem todoItem){
        try{
            TodoItem addTodoItem = todoItemService.addTodoItem(todoItem);
            return ResponseEntity.ok(addTodoItem);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add todo item: " + e.getMessage());
        }


    }

    @RequestMapping("/update")
    public String updateTodoItem(@RequestBody Map<String, Object> updateData){
        int id = (Integer) updateData.get("id");
        boolean completed = (Boolean) updateData.get("completed");
        todoItemService.updateTodoItemCompletion(id, completed);
        return "update Successful!";
    }

    @RequestMapping("/delete")
    public void deleteTodoItem(@RequestParam int id) {
        todoItemService.deleteTodoItem(id);
    }

    @RequestMapping("/select")
    public List<TodoItem> getTodoItemsByUserName(String name){

        return todoItemService.getTodoItemsByUserName(name);
    }
}
