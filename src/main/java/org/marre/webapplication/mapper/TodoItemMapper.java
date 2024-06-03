package org.marre.webapplication.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.marre.webapplication.model.TodoItem;

/**
 * @author :marRE
 * @Description:
 * @Date :2024/5/28
 */
@Mapper
public interface TodoItemMapper extends BaseMapper<TodoItem> {
}
