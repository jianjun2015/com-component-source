package component.spring.jdbc;

import java.util.List;
import java.util.Map;

import component.spring.entity.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


public class JdbcTemplateTest {

    private ApplicationContext ctx= null;
    private JdbcTemplate jdbcTemplate = null;
//	private EmployeeDao employee;

    {
        ctx = new ClassPathXmlApplicationContext("spring-jdbc.xml");
        jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
    }

    @Test
    public void jdbcTest(){

        String sql = "select name from t_user where id=1";

        String result = jdbcTemplate.queryForObject(sql, String.class);
        System.out.println(result);

        //返回对象需要做列名映射
        sql = "select * from t_user where id=1";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
        User bean = jdbcTemplate.queryForObject(sql, rowMapper);

        List<Map<String, Object>> obj = jdbcTemplate.queryForList(sql);

        System.out.println(obj);
    }

}
