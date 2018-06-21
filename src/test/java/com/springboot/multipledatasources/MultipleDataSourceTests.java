package com.springboot.multipledatasources;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MultipleDataSourceTests {

    @Autowired
    @Qualifier("primaryJdbcTemplate")
    protected JdbcTemplate jdbcTemplate1;


    @Autowired
    @Qualifier("secondaryJdbcTemplate")
    protected JdbcTemplate jdbcTemplate2;


    @Test
    public void multipleDatasources() {
        List<Map<String, Object>> list = jdbcTemplate1.queryForList("SELECT * FROM carinfo");
        for(Map<String,Object> stringObjectMap : list){
             System.out.println(stringObjectMap);
        }

        list = jdbcTemplate2.queryForList("SELECT * FROM jbbs_bankuai");
        for(Map<String,Object> stringObjectMap : list){
            System.out.println(stringObjectMap);
        }
    }

}
