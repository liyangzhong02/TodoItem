package org.marre.webapplication.model;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * @author :marRE
 * @Description:
 * @Date :2024/5/28
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("todo_item")
public class TodoItem {
    private Integer id;
    private String title;
    private String description;
    private Boolean completed;
    private String name; // 外键，关联到User实体
    private int priority;
}
