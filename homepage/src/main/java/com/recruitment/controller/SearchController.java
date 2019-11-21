package com.recruitment.controller;

import com.recruitment.domain.*;

import com.recruitment.service.impl.SearchServiceImpl;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author: 吴佐彬
 * @Date: 2019/11/15
 * @Time: 10:35
 * @description:
 */
@RestController
public class SearchController {


    @Autowired
    private SearchServiceImpl searchServiceImpl;
    @Autowired
    private RestHighLevelClient restHighLevelClient;


    @RequestMapping("/search")
    public List<CompanySet> Search(@RequestParam String input) throws IOException {

        System.out.println("++++"+input+"++++");
//        searchServiceImpl.setES();
//        searchServiceImpl.add();
        List list = new ArrayList();
        //设置搜索的索引
        SearchRequest searchRequest = new SearchRequest("company");
        //设置类型
        searchRequest.types("doc");
        //new一个查询的核心类
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        if (input == null || "".equals(input) ||input.length()==0 || input.trim().isEmpty()){
            searchSourceBuilder.query(QueryBuilders.matchAllQuery());
            searchRequest.source(searchSourceBuilder);
        }else {
            searchSourceBuilder.query(QueryBuilders.multiMatchQuery(input,"company_name","positionName"));
            searchRequest.source(searchSourceBuilder);
        }
        SearchResponse search = restHighLevelClient.search(searchRequest);
        SearchHits hits = search.getHits();
        SearchHit[] hits1 = hits.getHits();
        for (SearchHit searchHit : hits1){
            Map<String, Object> res = searchHit.getSourceAsMap();
            Company company = new Company();
            Position position = new Position();
            Hr hr = new Hr();
            Address address = new Address();

            company.setCompanyDescription((String)res.get("company_description"));
            company.setCompanyEmail((String)res.get("company_email"));
            company.setCompanyId((Integer)res.get("_id"));
            company.setCompanyName((String)res.get("company_name"));
            company.setCompanyPic((String)res.get("company_pic"));
            company.setCompanyPopulation((Integer)res.get("company_population"));
            company.setCompanyUrl((String)res.get("company_url"));
            company.setCompanyType((Integer)res.get("company_type"));

            position.setCompanyId((Integer)res.get("companyId"));
            position.setPositionId((Integer)res.get("positionId"));
            position.setPositionName((String)res.get("positionName"));
            position.setPositionType((String)res.get("positionType"));
            position.setPositiondeScription((String)res.get("positiondeScription"));
            position.setPositionNum((Integer)res.get("positionNum"));
            position.setEducationRequire((Integer)res.get("educationRequire"));
            position.setStartYearRequire((Integer)res.get("startYearRequire"));
            position.setEndYearRequire((Integer)res.get("endYearRequire"));
            position.setLowestSalary((Integer)res.get("lowestSalary"));
            position.setHighestSalary((Integer)res.get("highestSalary"));

            hr.setHrId((Integer)res.get("hrId"));
            hr.setHrPic((String)res.get("hrPic"));
            hr.setHrPosition((String)res.get("hrPosition"));
            hr.setHrPhone((String)res.get("hrPhone"));
            hr.setIsVip((Integer)res.get("isVip"));

            address.setAddressId((Integer)res.get("addressId"));
            address.setProvince((String)res.get("province"));
            address.setCity((String)res.get("city"));
            address.setDistrict((String)res.get("district"));
            address.setStreet((String)res.get("street"));
            address.setDoor((String)res.get("door"));
            address.setLatitude((Double) res.get("longitude"));
            address.setLongitude((Double)res.get("latitude"));

            CompanySet companySet = new CompanySet();
            companySet.setAddress(address);
            companySet.setPosition(position);
            companySet.setHr(hr);
            companySet.setCompany(company);
            list.add(companySet);
        }
        return list;
    }

    @RequestMapping("/set")
    public String set() throws IOException {
        searchServiceImpl.setES();
        return "d";
    }
}
