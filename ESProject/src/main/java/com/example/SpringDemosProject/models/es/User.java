package com.example.SpringDemosProject.models.es;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @Document(indexName = "user-demo") 索引名称为user-demo
 */

@Data
@Accessors(chain = true)
// @Document(indexName = "user-demo")
public class User {
    @Id
    private String id;

    @Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
    private String username;

    @Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
    private String address;

    @Field(type = FieldType.Integer)
    private Integer age;

    @Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
    private String gender;

}