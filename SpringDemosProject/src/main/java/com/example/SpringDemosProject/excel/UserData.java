package com.example.SpringDemosProject.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2024/07/05 22:01:30
 * @Version: 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ContentRowHeight(100)
@ColumnWidth(100 / 8)
public class UserData {
    @ExcelProperty(value = "ID", index = 0)
    private Long id;

    @ExcelProperty(value = "用户名", index = 1)
    private String username;

    @ExcelProperty(value = "密码", index = 2)
    private String password;

    @ExcelProperty(value = "邮箱", index = 3)
    private String email;

    @ExcelProperty(value = "创建时间", index = 4)
    private Date created_at;
}
