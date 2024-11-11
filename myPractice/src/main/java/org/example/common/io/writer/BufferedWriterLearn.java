package org.example.common.io.writer;

import org.apache.poi.ss.formula.functions.T;

import java.io.*;
import java.util.Arrays;
import java.util.List;

/**
 * 用BufferedWriter输出文件
 *
 * @author jiayn01
 * @date 2023-10-19 17:57:49
 */
public class BufferedWriterLearn {
    public static void main(String[] args) throws IOException {
        out(Arrays.asList("head1", "heaad2"),
                Arrays.asList(new JynInfo("one", "two"), new JynInfo("ooo", "ttt")),
                "C:\\Users\\jiayn01\\IdeaProjects\\MyJavaPractice-master\\myPractice\\src\\main\\resources\\test.csv"
                );
    }

    public static <T extends BaseInfo> void out(List<String> headerString, List<T> dataList, String fileName) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), "utf-8"));

        try {
            StringBuffer header = new StringBuffer("");
            for (int i = 0; i < headerString.size(); i++) {
                header.append(headerString.get(i));
                header.append(i == headerString.size() - 1 ? "" : ",");
            }

            bufferedWriter.newLine();
            bufferedWriter.write(header.toString());
            bufferedWriter.flush();

            for (T data : dataList) {
                StringBuffer line = new StringBuffer("");
                line.append(data.getValue1()).append(",").append(data.getValue2());

                bufferedWriter.newLine();
                bufferedWriter.write(line.toString());
                bufferedWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
        }







    }
}

class JynInfo extends BaseInfo {
    public JynInfo(String a, String b) {
        super(a, b);
    }
}

class BaseInfo {

    public BaseInfo(String value1, String value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    private String value1;

    private String value2;

    public String getValue1() {
        return value1;
    }

    public void setValue1(String value1) {
        this.value1 = value1;
    }

    public String getValue2() {
        return value2;
    }

    public void setValue2(String value2) {
        this.value2 = value2;
    }
}


