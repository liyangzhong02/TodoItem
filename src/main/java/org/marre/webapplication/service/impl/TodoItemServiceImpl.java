package org.marre.webapplication.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.marre.webapplication.mapper.TodoItemMapper;
import org.marre.webapplication.model.TodoItem;
import org.marre.webapplication.service.TodoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author :marRE
 * @Description:
 * @Date :2024/5/28
 */
@Service
public class TodoItemServiceImpl implements TodoItemService {

    @Autowired
    private TodoItemMapper todoItemMapper;
    @Override
    public TodoItem addTodoItem(TodoItem todoItem) {
        todoItemMapper.insert(todoItem);
        return todoItem;
    }

    @Override
    public void deleteTodoItem(int id) {
        todoItemMapper.deleteById(id);
    }

    @Override
    public List<TodoItem> getTodoItemsByUserName(String name) {
        return todoItemMapper.selectList(new QueryWrapper<TodoItem>().eq("name", name));
    }

    @Override
    public void updateTodoItemCompletion(int id, boolean completed) {
        UpdateWrapper<TodoItem> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", id).set("completed", completed);

        int rows = todoItemMapper.update(null, updateWrapper);
        if (rows == 0) {
            throw new RuntimeException("Todo item not found");
        }
    }
}
