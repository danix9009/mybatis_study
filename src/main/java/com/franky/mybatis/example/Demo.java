package com.franky.mybatis.example;

import com.franky.mybatis.example.dao.BlogMapper;
import com.franky.mybatis.example.model.Blog;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Title
 * @Description
 * @Author hdan
 * @Since 2021/9/18
 * @See
 */
public class Demo {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Blog blog = mapper.selectById(1L);
        System.out.println(blog);

        sqlSession.close();
        inputStream.close();
    }
}
