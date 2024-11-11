package org.example;

import static org.junit.Assert.assertTrue;

import cn.hutool.core.date.DateUtil;
import org.apache.commons.compress.utils.Lists;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp);
    }
}
