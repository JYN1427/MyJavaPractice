package com.example.SpringDemosProject.excel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.example.SpringDemosProject.excel.mapper.UserMapperForExcel;
import com.example.SpringDemosProject.oracle.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.cursor.Cursor;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2024/07/05 21:41:35
 * @Version: 1.0.0
 */
@Slf4j
@Service
public class ExcelExportService {

    @Value("/tmp/")
    private String path;

    @Autowired
    private UserMapperForExcel userMapperForExcel;

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    public void exportExcel(HttpServletResponse response, Boolean useCursor) {
        // 流式查询需要保持连接, 这样一把查下去是会报错. 会获取不到iterator()
        // Cursor<User> users = userMapperForExcel.getAllUsersForExcel();

        // 正确用法:
        doExport(response, useCursor);
    }

    private void doExport(HttpServletResponse response, Boolean useCursor) {
        String fileName = getTimeStr();
        String filePath = path + fileName + ".xlsx";
        File parentFolder = new File(path);
        if (!parentFolder.exists()) {
            parentFolder.mkdirs();
        }

        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 1. 导出excel文件
        // 多次查询分页数据，重复写入同一个excel
        ExcelWriter excelWriter = EasyExcel.write(filePath, UserData.class).build();
        try {
            // 这里注意 如果同一个sheet只要创建一次
            WriteSheet writeSheet = EasyExcel.writerSheet().build();

            Iterator<User> iterator = null;
            if (useCursor) {
                // 使用游标
                Cursor<User> usersCursor = sqlSession.getMapper(UserMapperForExcel.class).getAllUsersByCursor();
                iterator = usersCursor.iterator();
            }
            else {
                // 一次性查到内存
                List<User> userList = sqlSession.getMapper(UserMapperForExcel.class).getAllUsersByList();
                iterator = userList.iterator();
            }

            int count = 0;
            List<UserData> list = new ArrayList<>();
            while (iterator.hasNext()) {
                User next = iterator.next();
                count++;
                list.add(new UserData(next.getId(),
                        next.getUsername(),
                        next.getPassword(),
                        next.getEmail(),
                        next.getCreated_at()));
                if (count % ExcelConstants.USERS_EXPORT_FETCH_SIZE == 0) {
                    // 写入
                    excelWriter.write(list, writeSheet);
                    list.clear();
                }
                log.info("iterator: " + next.getId());
            }
            log.info("count: " + count);
        } catch (Exception e) {
            log.error("错误堆栈信息: " + e);
        } finally {
            sqlSession.close();
            excelWriter.close();
        }

        // 2. 下载excel文件
//        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
//        response.setCharacterEncoding("utf-8");
//        try {
//            fileName = URLEncoder.encode(fileName, "UTF-8").replaceAll("\\+", "%20");
//            response.setHeader("Content-Disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
//        } catch (Exception e) {
//            log.error("导出excel失败");
//            e.printStackTrace();
//        }

    }

    public static String getTimeStr() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        return sdf.format(new Date());
    }
}