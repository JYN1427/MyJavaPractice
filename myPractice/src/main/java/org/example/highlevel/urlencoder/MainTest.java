package org.example.highlevel.urlencoder;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * TODO
 *
 * @author jiayn01
 * @date 2023-09-21 10:28:24
 */
public class MainTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String encode = URLEncoder.encode("年金工作汇报", "UTF-8");
        System.out.println(encode);

        String decode = URLDecoder.decode("%E5%B9%B4%E9%87%91%E5%B7%A5%E4%BD%9C%E6%B1%87%E6%8A%A5", "UTF-8");
        System.out.println(decode);

    }

    @Test
    public void encodeTest() throws UnsupportedEncodingException {
        String encode = URLEncoder.encode("爱仕达股份有限公司", "UTF-8");
        System.out.println(encode);
    }
}
