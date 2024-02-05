package org.example.common.Map_;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 *
 * @author jiayn01
 * @date 2023-12-13 15:54:16
 */
public class WhenNull {
    @Test
    public void whenNullTest(){
        Map<String, String> map = new HashMap<>();
        map.put(null, "1");
        map.put("1", null);
        map.put(null, null);
        System.out.println(map.toString());
    }
}
