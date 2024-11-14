package com.example.SpringDemosProject.service.file;

import com.alibaba.fastjson.JSON;
import com.example.SpringDemosProject.common.constants.ESConstant;
import com.example.SpringDemosProject.models.es.FileInfo;
import com.example.SpringDemosProject.utils.FileUtil;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * TODO
 *
 * @author jiayn01
 * @date 2024-10-17 16:02:00
 */
@Service
@Slf4j
public class FileInfoService {

    @Autowired
    private RestHighLevelClient client;

//    @Resource
//    private FileInfoMapper fileInfoMapper;

    /**
     * 上传文件并进行文件内容识别上传到es
     * @param file
     * @return
     */
    public void uploadFileInfo(MultipartFile file) {
        try {
            FileInfo fileInfo = new FileInfo();
            String fileName = file.getName();
            String prefix = fileName.substring(fileName.lastIndexOf(".") + 1);

            // 上传文件到文档中心
            // response = FileUtils.upload(file);

            // 属性填充
            fileInfo.setFileName(fileName);
            fileInfo.setFileType(prefix);
            fileInfo.setFileUrl("...");
            fileInfo.setContentType("normal");

            // 持久化文件信息数据到数据库
            // fileInfoMapper.insertSelective(fileInfo);

            // 文件转base64
            File realFile = File.createTempFile(fileName, prefix);
            file.transferTo(realFile);
            String base64 = FileUtil.getBase64(realFile);
            fileInfo.setContent(base64);

            //上传doc、使用attachment pipline进行文件提取
            IndexRequest indexRequest = new IndexRequest(ESConstant.FILE_SEARCH_INDEX);
            indexRequest.source(JSON.toJSONString(fileInfo), XContentType.JSON);
            indexRequest.setPipeline("attachment");
            IndexResponse indexResponse = client.index(indexRequest, RequestOptions.DEFAULT);
            log.info("indexResponse:" + indexResponse);

        } catch (Exception e) {
            log.error("错误: ", e);
        }

    }





}
