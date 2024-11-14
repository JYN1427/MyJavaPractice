package com.example.SpringDemosProject.models.es;

import com.example.SpringDemosProject.common.constants.ESConstant;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

/**
 * 文件检索 索引
 *
 * @author jiayn01
 * @date 2024-10-17 15:55:26
 */
@Setter
@Getter
@Document(indexName = ESConstant.FILE_SEARCH_INDEX, createIndex = false)
public class FileInfo {
    /**
     * 主键
     */
    @Field(name = "id", type = FieldType.Integer)
    private Integer id;

    /**
     * 文件名称
     */
    @Field(name = "fileName", type = FieldType.Text,analyzer = "jieba_index",searchAnalyzer = "jieba_index")
    private String fileName;

    /**
     * 文件类型
     */
    @Field(name = "fileType",  type = FieldType.Keyword)
    private String fileType;

    /**
     * 内容类型
     */
    @Field(name = "contentType", type = FieldType.Text)
    private String contentType;

    /**
     * 附件内容
     */
    @Field(name = "attachment.content", type = FieldType.Text,analyzer = "jieba_index",searchAnalyzer = "jieba_index")
    // @TableField(exist = false)
    private String content;

    /**
     * 文件地址
     */
    @Field(name = "fileUrl", type = FieldType.Text)
    private String fileUrl;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}