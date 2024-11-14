package com.example.SpringDemosProject.controller.es;

import com.example.SpringDemosProject.models.es.FileInfo;
import com.example.SpringDemosProject.models.vo.WarningInfoVo;
import com.example.SpringDemosProject.service.es.ElasticsearchService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO
 *
 * @author jiayn01
 * @date 2024-10-17 16:08:09
 */
@RestController
@RequestMapping("/es")
public class ElasticsearchController {
    @Resource
    private ElasticsearchService elasticsearchService;

    /**
     * 告警信息关键词联想
     *
     * @param warningInfoVo
     * @return
     */
    @PostMapping("/getAssociation")
    public Map<Object, Object> getAssociation(@RequestBody WarningInfoVo warningInfoVo) {
        List<String> list = elasticsearchService.getAssociationalWordOther(warningInfoVo);
        Map<Object, Object> map = new HashMap<>();
        map.put("list", list);
        return map;
    }


    /**
     * 告警信息高亮分词分页查询
     *
     * @param warningInfoVo
     * @return
     */
    @PostMapping("/queryHighLightDoc")
    public Map<Object, Object> queryHighLightDoc(@RequestBody WarningInfoVo warningInfoVo) {
        List<FileInfo> list = elasticsearchService.queryHighLightWordOther(warningInfoVo);
        Map<Object, Object> map = new HashMap<>();
        map.put("list", list);
        return map;
    }
}