package org.marre.webapplication.service;

import org.marre.webapplication.model.TodoItem;

import java.util.List;

/**
 * @author :marRE
 * @Description:
 * @Date :2024/5/28
 */

public interface TodoItemService {
    TodoItem addTodoItem(TodoItem todoItem);
    void deleteTodoItem(int id);
    List<TodoItem> getTodoItemsByUserName(String name);
    void updateTodoItemCompletion(int id, boolean completed);
}
