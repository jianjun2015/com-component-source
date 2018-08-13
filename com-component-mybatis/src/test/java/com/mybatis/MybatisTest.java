package com.mybatis;

import org.apache.ibatis.builder.xml.XMLMapperBuilder;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: JianJun
 * @Description:
 * @Date: Created in 15:22 2018/7/25
 * @Modify:
 * @Version:
 */
public class MybatisTest {

    /**
     * 新建一个会话工厂构建器
     * 基于配置文件转换成configuration
     * 获取一个会话request执行【生命周期在request】
     * 执行sql语句
     * @throws IOException
     */

    @Test
    public void queryBlogTest() throws IOException {

        String resource = "/mybatis-config.xml";
        InputStream inputStream = getClass().getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        sqlSessionFactory.getConfiguration();//加载mybatis的配置信息   如：驼峰设计

        SqlSession session = sqlSessionFactory.openSession();
        Object o = session.selectOne("com.mybatis.BlogMapper.selectBlog", 1);
        System.out.println(o instanceof Blog);
        System.out.println((Blog)o);
    }

    @Test
    public void parseConfigurationTest() throws IOException {

        Configuration configuration = new Configuration();

        String resource = "sqlmapper/BlogMapper.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        XMLMapperBuilder builder = new XMLMapperBuilder(inputStream,configuration,"sqlmapper/BlogMapper.xml",configuration.getSqlFragments());

        builder.parse();
        configuration.getMappedStatement("com.mybatis.BlogMapper.selectBlog");

    }
}
