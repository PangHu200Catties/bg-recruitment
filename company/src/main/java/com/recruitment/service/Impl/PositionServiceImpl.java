package com.recruitment.service.Impl;

import com.recruitment.dao.PositionMapper;
import com.recruitment.domain.PageBean;
import com.recruitment.domain.Position;
import com.recruitment.service.PositionService;
import org.apache.commons.lang.StringUtils;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 张浩
 * @Date: 2019/11/18 14:48
 */
public class PositionServiceImpl implements PositionService {
    @Autowired
    PositionMapper positionMapper;
    @Override
    public void setAll() {
        List<Position> all = positionMapper.findAll();

        HttpSolrServer httpSolrServer = new HttpSolrServer("http://localhost:18080/solr");
        SolrInputDocument solrInputFields = new SolrInputDocument();
        for (Position p:all) {
            solrInputFields.setField("positionId;",p.getPositionId());
            solrInputFields.setField("companyId",p.getCompanyId());
            solrInputFields.setField("positionname",p.getPositionName());
            solrInputFields.setField("positionName",p.getPositionType());
            solrInputFields.setField("positiondeScription",p.getPositiondeScription());
            solrInputFields.setField("educationRequire",p.getEducationRequire());
            solrInputFields.setField("endYearRequire",p.getEndYearRequire());
            solrInputFields.setField("startYearRequire",p.getStartYearRequire());
            solrInputFields.setField("highestSalary",p.getHighestSalary());
            solrInputFields.setField("lowestSalary",p.getLowestSalary());
//            solrInputFields.setField("id",p.getHid());
            try {
                httpSolrServer.add(solrInputFields);
            } catch (SolrServerException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public PageBean getResults(PageBean pageBean) {
        List list = new ArrayList<>();
        PageBean pageBean1 = new PageBean();
        HttpSolrServer httpSolrServer = new HttpSolrServer("http://localhost:18080/solr");
        SolrQuery query = new SolrQuery();
        int start = pageBean.getPage()-1;
        if(start<1){
            start=0;
        }
        if(StringUtils.isEmpty(pageBean.getAddress())){
            query.setQuery("*:*");
        }else{
            try {
//                String s = new String(pageBean.getAddress().getBytes("GBK"), "UTF-8");
                query.setQuery(pageBean.getAddress());
            } catch ( Exception e) {
                e.printStackTrace();
            }
        }
        query.setStart(start*pageBean.getSize());
        query.setRows(pageBean.getSize());
        query.set("df","address");
        try {
            QueryResponse query1 = httpSolrServer.query(query);
            SolrDocumentList results = query1.getResults();
            for (SolrDocument sd:results) {
                int positionId =Integer.parseInt((String)sd.getFieldValue("positionId"));
                int companyId =Integer.parseInt((String)sd.getFieldValue("companyId"));
                String positionname =(String) sd.getFieldValue("positionname");
                String positiondeScription =(String) sd.getFieldValue("positiondeScription");
                int educationRequire =Integer.parseInt((String)sd.getFieldValue("educationRequire"));
                int endYearRequire =Integer.parseInt((String)sd.getFieldValue("endYearRequire"));
                int startYearRequire =Integer.parseInt((String)sd.getFieldValue("startYearRequire"));
                int highestSalary =Integer.parseInt((String)sd.getFieldValue("highestSalary"));
                int lowestSalary =Integer.parseInt((String)sd.getFieldValue("lowestSalary"));

                Position position = new Position();
                position.setPositionId(positionId);
                position.setCompanyId(companyId);
                position.setPositionName(positionname);
                position.setPositiondeScription(positiondeScription);
                position.setEducationRequire(educationRequire);
                position.setEndYearRequire(endYearRequire);
                position.setStartYearRequire(startYearRequire);
                position.setHighestSalary(highestSalary);
                position.setLowestSalary(lowestSalary);
                list.add(position);
            }
            long total = results.getNumFound();
            pageBean.setList(list);
            pageBean.setTotal(total);
        } catch (SolrServerException e) {
            e.printStackTrace();
        }
        return pageBean;
    }

}
