package com.example.SpringDemosProject.models.vo;

import lombok.Data;

import java.util.List;

/**
 * TODO
 *
 * @author jiayn01
 * @date 2024-10-17 16:07:20
 */
@Data
public class WarningInfoVo {
    /**
     * 页数
     */
    private Integer pageIndex;

    /**
     * 每页数量
     */
    private Integer pageSize;

    /**
     * 查询关键词
     */
    private String keyword;

    /**
     * 内容类型
     */
    private List<String> contentType;

    /**
     * 用户手机号
     */
    private String phone;
}
