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
@TableName("user")
public class User {

    private Integer id;

    private String name;

    private String pwd;

}
