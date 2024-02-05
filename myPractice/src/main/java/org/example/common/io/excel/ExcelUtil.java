package org.example.common.io.excel;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author jiayn01
 * @date 2023-10-19 17:03:47
 */
public class ExcelUtil {

    /**
     * 从
     *
     * @param filePath
     * @param clz
     * @param columns
     * @param <T>
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public static <T> List<T> getDataFromExcel(String filePath, Class<T> clz, String[] columns) throws IllegalAccessException, InstantiationException {
        try {
            // 创建文件输入流对象
            InputStream inputStream = Thread.currentThread()
                    .getContextClassLoader()
                    .getResourceAsStream(filePath);

            // 创建工作簿对象
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);

            // 选择要读取的工作表（假设第一个工作表）
            XSSFSheet sheet = workbook.getSheetAt(0);

            List<T> resultList = new ArrayList<>();

            // 迭代每一行
            int rowNum = sheet.getPhysicalNumberOfRows();
            for (int i = 1; i < rowNum; i++) {
                // 迭代每一个Cell
                T obj = clz.newInstance();
                Row row = sheet.getRow(i);
                int colNum = row.getPhysicalNumberOfCells();
                for (int j = 0; j < colNum; j++) {
                    // 获取数据
                    DataFormatter formatter = new DataFormatter();
                    String val = formatter.formatCellValue(row.getCell(j));

                    // 存入属性值
                    Field field = clz.getField(columns[j]);
                    field.set(obj, val);
                }
                // 加入本行数据
                resultList.add(obj);
            }

            // 关闭workbook和文件输入流
            workbook.close();
            inputStream.close();

            return resultList;
        } catch (IOException | NoSuchFieldException e) {
            // log.info()
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}