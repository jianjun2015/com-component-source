package component.module.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * Created by wangjianjun on 2017/7/6.
 */
public class MyBatisUtil {

    public static SqlSession getSqlSession(){

        String config= "Configuration.xml";
        InputStream is = ClassLoader.getSystemResourceAsStream(config);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        //factory.openSession(true); 任务自动提交
        SqlSession sqlSession = factory.openSession();

        return sqlSession;
    }
}
