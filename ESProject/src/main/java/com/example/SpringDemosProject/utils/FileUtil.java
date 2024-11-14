package com.example.SpringDemosProject.utils;

import lombok.extern.slf4j.Slf4j;
import org.osgi.framework.ServiceException;

import java.io.*;
import java.util.Base64;

/**
 * TODO
 *
 * @author jiayn01
 * @date 2024-10-18 10:12:44
 */
@Slf4j
public class FileUtil {
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\jynStudy\\workSpace\\ideaProjects\\files\\西藏自治区贰号职业年金计划投资管理合同.doc");
        String base64 = getBase64(file);
        // System.out.println(base64);
        createAndWrite("D:/jynStudy/workSpace/ideaProjects/files/target/base64File" + System.currentTimeMillis() + ".txt", base64);
    }


    /**
     * 文件转base64
     * 可以在实现功能的时候主观上对文件大小做限制
     *
     * @param file
     * @return
     * @throws IOException
     */
    public static String getBase64(File file) throws IOException {

        long fileSize = file.length();
        if (fileSize > Integer.MAX_VALUE) {
            log.info("file too big...");
            return null;
        }
        FileInputStream fi = new FileInputStream(file);
        byte[] buffer = new byte[(int) fileSize];
        int offset = 0;
        int numRead = 0;
        while (offset < buffer.length
                && (numRead = fi.read(buffer, offset, buffer.length - offset)) >= 0) {
            offset += numRead;
        }
        // 确保所有数据均被读取
        if (offset != buffer.length) {
            throw new ServiceException("Could not completely read file "
                    + file.getName());
        }
        fi.close();

        String base64 = Base64.getEncoder().encodeToString(buffer);
        return base64;
    }

    public static void createAndWrite(String targetFilePath, String longString) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(targetFilePath))) {
            writer.write(longString);
            System.out.println("字符串已成功写入文件。");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
