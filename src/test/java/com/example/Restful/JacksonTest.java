package com.example.Restful;

import com.example.Restful.model.Article;
import com.example.Restful.model.Reader;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JacksonTest {

    //check serialize && deserialize
    @Test
    void testJackson() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        List<Reader> readers = new ArrayList<Reader>(){{
            add(new Reader("kobe", 21));
            add(new Reader("james", 20));
        }};

        Article article = Article.builder()
                .id(2L)
                .author("Max")
                .content("Spring course")
                .createTime(new Date())
                .reader(readers)
                .title("t1")
                .build();

        String jsonStr = mapper.writeValueAsString(article);
        System.out.println(jsonStr);

//        Article article1 = mapper.readValue("{\"content\":\"Spring course\",\"title\":\"t1\",\"createTime\":\"2022/01/21 17:20:26\",\"reader\":[{\"name\":\"kobe\",\"age\":21},{\"name\":\"james\",\"age\":20}],\"auther\":\"Max}",
//        Article.class);
//        System.out.println(article1);




    }
}

