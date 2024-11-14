package com.example.SpringDemosProject.cacheableAnno;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2023/08/21 21:22:56
 * @Version: 1.0.0
 */
@Component
public class CacheableAnnoLearn {

    @Cacheable(value = {"byModel", "byId"}, key = " 'ID-' + #queryParam.Id")
    public Model getModelById(QueryParam queryParam) {
        try{
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Model();
    }

    @Cacheable(value = {"byId"}, key = " 'ID-' + #id")
    public Model getModelById(Integer id) {
        try{
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Model();
    }
}

class QueryParam{
    public Integer Id;
    public String type;

    public QueryParam setId(Integer id) {
        Id = id;
        return this;
    }
}



class Model{
    public Integer lId;

    public String name;

    public String subModel;
}
