package component.module.mybatis.dao;

import component.module.mybatis.MyBatisUtil;
import component.module.mybatis.entity.Classes;
import component.module.mybatis.entity.Teacher;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wangjianjun on 2017/7/6.
 */
public class ClassDao {


    @Test
    public void testSelect(){

        SqlSession session = MyBatisUtil.getSqlSession();

        String statement =  "component.module.mybatis.entity.ClassMapper.selectClassById";
        statement =  "component.module.mybatis.entity.ClassMapper.selectClassById2";
        statement =  "component.module.mybatis.entity.ClassMapper.selectClassById3";
//        statement =  "component.module.mybatis.entity.ClassMapper.selectNameById";
        Classes class_ = session.selectOne(statement,1);

        session.close();
        System.out.println(class_);
    }

//    调用PROCEDURE
    @Test
    public void testProcedure(){
        SqlSession session = MyBatisUtil.getSqlSession();

        String statement =  "component.module.mybatis.entity.ClassMapper.getStudentCountById";
        Map<String,Integer> parameterMap = new HashMap<>();
        parameterMap.put("stu_id",1);
        parameterMap.put("stu_count",-1);

        session.selectOne(statement,parameterMap);
        Integer result = parameterMap.get("stu_count");
        System.out.println(result);

        session.close();
    }

    @Test
    public void testSelectKey(){

        SqlSession session = MyBatisUtil.getSqlSession();

        String statement =  "component.module.mybatis.entity.ClassMapper.selectTeacherByName";
        statement =  "component.module.mybatis.entity.ClassMapper.selectTeacherByName2";
        Teacher class_ = session.selectOne(statement,"ls_1");

        session.close();
        System.out.println(class_);
    }

    @Test
    public void testSelectList(){

        SqlSession session = MyBatisUtil.getSqlSession();

        String statement =  "component.module.mybatis.entity.ClassMapper.selectTeacherByName";
        statement =  "component.module.mybatis.entity.ClassMapper.selectTeacherByIds";
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        //list为空，或不存在数据
//        list.clear();
//        statement =  "component.module.mybatis.entity.ClassMapper.selectTeacherByIds_";

        List<Teacher> class_ = session.selectList(statement,list);

        session.close();
        for (Teacher t:class_)
            System.out.println(t);
    }

    @Test
    public void testSelectObjectList(){

        SqlSession session = MyBatisUtil.getSqlSession();

        String statement =  "component.module.mybatis.entity.ClassMapper.selectTeacherByName";
        statement =  "component.module.mybatis.entity.ClassMapper.selectTeacherByTeachers";
        List<Teacher> list = new ArrayList<>();
        Teacher teacher = new Teacher(1,"ls_1");
        list.add(teacher);
        Teacher teacher1 = new Teacher(2,"ls_1");
        list.add(teacher1);

        List<Teacher> class_ = session.selectList(statement,list);

        session.close();
        for (Teacher t:class_)
            System.out.println(t);
    }

    @Test
    public void testSelectMap(){

        SqlSession session = MyBatisUtil.getSqlSession();

        String statement =  "component.module.mybatis.entity.ClassMapper.selectTeacherByMap";

        Map<String,Object>  map = new HashMap<>();
        map.put("id",1);

//        map.clear();
        Teacher class_ = session.selectOne(statement,map);

        session.close();
        System.out.println(class_);
    }

    @Test
    public void testSelectWhere(){

        SqlSession session = MyBatisUtil.getSqlSession();

        String statement =  "component.module.mybatis.entity.ClassMapper.selectTeacherByWhere_";

        Teacher teacher = new Teacher(2,"ls_2");
        Teacher class_ = session.selectOne(statement,teacher);

        session.close();
        System.out.println(class_);
    }

    @Test
    public void testInsertTeacher(){

        SqlSession session = MyBatisUtil.getSqlSession();

        String statement =  "component.module.mybatis.entity.ClassMapper.insertTeacher";

        Teacher teacher = new Teacher("ls_3");
        int result = session.insert(statement,teacher);//默认返回值为操作的记录

        session.commit();//手动提交任务
        session.close();
        System.out.println(result);
        System.out.println(teacher.getId());//可以得到主键
    }
}
