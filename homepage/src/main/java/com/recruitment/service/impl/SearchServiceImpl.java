package com.recruitment.service.impl;

import com.recruitment.dao.AddressRepository;
import com.recruitment.dao.CompanyRepository;
import com.recruitment.dao.HrRepository;
import com.recruitment.dao.PositionRepository;
import com.recruitment.domain.Address;
import com.recruitment.domain.Company;
import com.recruitment.domain.Hr;
import com.recruitment.domain.Position;
import com.recruitment.service.SearchService;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.IndicesClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author: 吴佐彬
 * @Date: 2019/11/14
 * @Time: 20:17
 * @description:
 */
@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private RestHighLevelClient restHighLevelClient;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private PositionRepository positionRepository;
    @Autowired
    private HrRepository hrRepository;
    @Autowired
    private AddressRepository addressRepository;


    public void setES() throws IOException {
        //建立索引（相当于建库）
        CreateIndexRequest createIndexRequest = new CreateIndexRequest("company");
        //设置切片
        createIndexRequest.settings(Settings.builder().put("number_of_shards",1).put("number_of_replicas",0));
        //设置映射
        createIndexRequest.mapping("doc"," {\n" +
                "    \"properties\": {\n" +
                "           \"company_id\": {\n" +
                "              \"type\": \"keyword\"\n" +
                "           },\n" +
                "           \"company_name\": {\n" +
                "              \"type\": \"text\",\n" +
                "              \"analyzer\":\"ik_max_word\",\n" +
                "              \"search_analyzer\":\"ik_smart\"\n" +
                "           },\n" +
                "           \"company_description\": {\n" +
                "           \t \"analyzer\":\"ik_max_word\",\n" +
                "              \"search_analyzer\":\"ik_smart\",\n" +
                "              \"type\": \"text\"\n" +
                "           },\n" +
                "           \"company_pic\": {\n" +
                "              \"type\": \"keyword\"\n" +
                "           },\n" +
                "           \"company_population\": {\n" +
                "                \"type\":   \"keyword\"\n" +
                "            },\n" +
                "            \"company_email\": {\n" +
                "                \"type\":   \"keyword\"\n" +
                "            },\n" +
                "            \"company_type\": {\n" +
                "                \"type\":   \"keyword\"\n" +
                "            },\n" +
                "            \"info1\": {\n" +
                "                \"type\":   \"keyword\"\n" +
                "            },\n" +
                "            \"info2\": {\n" +
                "                \"type\":   \"keyword\"\n" +
                "            },\n" +
                "            \"info3\": {\n" +
                "                \"type\":   \"keyword\"\n" +
                "            },\n" +
                "            \"company_url\": {\n" +
                "                \"type\":   \"keyword\"\n" +
                "            },\n" +
                "            \"positionId\": {\n" +
                "                \"type\":   \"keyword\"\n" +
                "            },\n" +
                "            \"companyId\": {\n" +
                "                \"type\":   \"keyword\"\n" +
                "            },\n" +
                "            \"positionName\": {\n" +
                "                \"type\":   \"text\",\n" +
                "                \"analyzer\":\"ik_max_word\",\n" +
                "              \"search_analyzer\":\"ik_smart\"\n" +
                "            },\n" +
                "            \"positiondeScription\": {\n" +
                "                \"type\":   \"text\",\n" +
                "                \"analyzer\":\"ik_max_word\",\n" +
                "              \"search_analyzer\":\"ik_smart\"\n" +
                "            },\n" +
                "            \"positionType\": {\n" +
                "                \"type\":   \"keyword\"\n" +
                "            },\n" +
                "            \"positionNum\": {\n" +
                "                \"type\":   \"keyword\"\n" +
                "            },\n" +
                "            \"educationRequire\": {\n" +
                "                \"type\":   \"keyword\"\n" +
                "            },\n" +
                "            \"startYearRequire\": {\n" +
                "                \"type\":   \"keyword\"\n" +
                "            },\n" +
                "            \"endYearRequire\": {\n" +
                "                \"type\":   \"keyword\"\n" +
                "            },\n" +
                "            \"lowestSalary\": {\n" +
                "                \"type\":   \"keyword\"\n" +
                "            },\n" +
                "            \"highestSalary\": {\n" +
                "                \"type\":   \"keyword\"\n" +
                "            },\n" +
                "            \"hrId\": {\n" +
                "                \"type\":   \"keyword\"\n" +
                "            },\n" +
                "            \"hrPic\": {\n" +
                "                \"type\":   \"keyword\"\n" +
                "            },\n" +
                "            \"hrPosition\": {\n" +
                "                \"type\":   \"keyword\"\n" +
                "            } ,\n" +
                "            \"isVip\": {\n" +
                "                \"type\":   \"keyword\"\n" +
                "            } ,\n" +
                "            \"hrPhone\": {\n" +
                "                \"type\":   \"keyword\"\n" +
                "            },\n" +
                "            \"addressId\": {\n" +
                "                \"type\":   \"keyword\"\n" +
                "            },\n" +
                "            \"province\": {\n" +
                "                \"type\":   \"keyword\"\n" +
                "            },\n" +
                "            \"city\": {\n" +
                "                \"type\":   \"keyword\"\n" +
                "            } ,\n" +
                "            \"district\": {\n" +
                "                \"type\":   \"keyword\"\n" +
                "            }  ,\n" +
                "            \"street\": {\n" +
                "                \"type\":   \"keyword\"\n" +
                "            } ,\n" +
                "            \"door\": {\n" +
                "                \"type\":   \"keyword\"\n" +
                "            },\n" +
                "            \"longitude\": {\n" +
                "                \"type\":   \"keyword\"\n" +
                "            },\n" +
                "            \"latitude\": {\n" +
                "                \"type\":   \"keyword\"\n" +
                "            }\n" +
                "           \n" +
                "            \n" +
                "\n" +
                "        }\n" +
                "}",XContentType.JSON);
        //创建执行的客户端
        IndicesClient indices = restHighLevelClient.indices();
        CreateIndexResponse createIndexResponse = indices.create(createIndexRequest);
        if (createIndexResponse.isAcknowledged()){

        }

    }

    public void add() throws IOException {
        List<Position> all = positionRepository.findAll();
        Map map =  new HashMap();
        for (Position p:all) {
            IndexRequest indexRequest = new IndexRequest("company", "doc");
            Optional<Company> byId = companyRepository.findById(p.getCompanyId());
            if(byId.isPresent()){
                Company c = byId.get();
                Address a = addressRepository.findByCompanyId(c.getCompanyId());
                map.put("addressId",a.getAddressId());
                map.put("province",a.getProvince());
                map.put("city",a.getCity());
                map.put("district",a.getDistrict());
                map.put("street",a.getStreet());
                map.put("door",a.getDoor());
                map.put("longitude",a.getLongitude());
                map.put("latitude",a.getLatitude());


                map.put("company_name",c.getCompanyName());
                map.put("company_description",c.getCompanyDescription());
                map.put("company_pic",c.getCompanyPic());
                map.put("company_population",c.getCompanyPopulation());
                map.put("company_email",c.getCompanyEmail());
                map.put("company_type",c.getCompanyType());
                map.put("company_url",c.getCompanyUrl());
                map.put("info1",c.getInfo1());
                map.put("info2",c.getInfo2());
                map.put("info3",c.getInfo3());
            }
            Optional<Hr> byId1 = hrRepository.findById(p.getHrId());
            if(byId1.isPresent()){
                Hr h = byId1.get();
                map.put("hrId",h.getHrId());
                map.put("hrPic",h.getHrPic());
                map.put("hrPosition",h.getHrPosition());
                map.put("isVip",h.getIsVip());
                map.put("hrPhone",h.getHrPhone());
            }

            map.put("companyId",p.getCompanyId());
            map.put("positionName",p.getPositionName());
            map.put("positiondeScription",p.getPositiondeScription());
            map.put("positionType",p.getPositionType());
            map.put("positionNum",p.getPositionNum());
            map.put("educationRequire",p.getEducationRequire());
            map.put("startYearRequire",p.getStartYearRequire());
            map.put("endYearRequire",p.getEndYearRequire()) ;
            map.put("lowestSalary",p.getLowestSalary());
            map.put("highestSalary",p.getHighestSalary());
            map.put("positionId",p.getPositionId());

            indexRequest.source(map);
            IndexResponse index = restHighLevelClient.index(indexRequest);

        }
    }






}


