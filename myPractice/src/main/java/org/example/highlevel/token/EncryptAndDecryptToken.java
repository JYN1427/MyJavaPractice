package org.example.highlevel.token;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.HexUtil;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricCrypto;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * TODO
 *
 * @author jiayn01
 * @date 2023-10-20 14:10:20
 */
public class EncryptAndDecryptToken {

    private static final Charset UTF_8 = StandardCharsets.UTF_8;

    private static final String key = HexUtil.encodeHexStr("xrychhqc");

    public static void main(String[] args) {
        String encryptString = encrypt("jiayn01");
        decrypt(encryptString);
    }

    public static String encrypt(String userId) {
        SymmetricCrypto aes = new SymmetricCrypto(SymmetricAlgorithm.AES, key.getBytes());
        byte[] passwordDis = aes.encrypt(UUID.randomUUID().toString().replace("-", "") + "_" + DateUtil.format(new Date(), "yyyyMMdd") + "_" + userId, CharsetUtil.UTF_8);
        String encryptString = HexUtil.encodeHexStr(passwordDis);
        System.out.println("加密出来的token----->" + encryptString);
        return encryptString;
    }

    public static void decrypt(String encryptString) {
        SymmetricCrypto aes = new SymmetricCrypto(SymmetricAlgorithm.AES, key.getBytes());
        String passwordName = aes.decryptStr(encryptString, UTF_8);
        System.out.println("解析token出的内容----->" + passwordName);
    }
}
