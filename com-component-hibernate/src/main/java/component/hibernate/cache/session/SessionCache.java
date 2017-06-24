package component.hibernate.cache.session;

import component.hibernate.entity.Dbuser;
import component.hibernate.util.HibernateUtil;
import org.hibernate.Session;

import java.util.Iterator;

/**
 * Created by wangjianjun on 2017/6/21.
 */
public class SessionCache {

    /**
     * 只有在第一次的时候会查询数据库，只有session没有关闭，则直接从session加载
     */
    public void testFisrtSession() {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Dbuser dbuser = (Dbuser) session.load(Dbuser.class, 111);
            System.out.println(dbuser.getCreateDate());

            dbuser = (Dbuser) session.load(Dbuser.class, 111);
            System.out.println(dbuser.getCreateDate());

            session.getTransaction().commit();
            dbuser = (Dbuser) session.load(Dbuser.class, 111);
            System.out.println(dbuser.getCreateDate());

        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            HibernateUtil.getSessionFactory().close();
        }
    }

    //第一次调用迭代器的查询时，首先发出查询id的语句，并根据id查询学生。当第二次调用时，只会发出查询id的语句，不会再根据id来查询对应的学生对象。这说明iterate（迭代器）是支持缓存的。
    public void testIteratorSession() {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Iterator iter = session.createQuery("from Dbuser ").iterate();
            while(iter.hasNext()) {
                Dbuser dbuser = (Dbuser) iter.next();
                System.out.println(dbuser.getUsername());
            }
            System.out.println("--------------------------------------");

            //iterate查询普通属性，一级缓存不会缓存，所以发出查询语句
            //一级缓存是缓存实体对象的
            iter= session.createQuery("from Dbuser").iterate();
            while(iter.hasNext()) {
                Dbuser dbuser = (Dbuser) iter.next();
                System.out.println(dbuser.getUsername());
            }
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            HibernateUtil.getSessionFactory().close();
        }
    }

    //根据显示结果可知，迭代器查询普通属性，一级缓存不会存储，所以当第二次查询的时候仍然发出查询语句。这说明iterate一级缓存缓存的是实体对象，对于普通属性不会缓存
    public void testIteratorSession_() {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Iterator iter = session.createQuery("select username from Dbuser ").iterate();
            while(iter.hasNext()) {
                String name = (String)iter.next();
                System.out.println(name);
            }
            System.out.println("--------------------------------------");

            //iterate查询普通属性，一级缓存不会缓存，所以发出查询语句
            //一级缓存是缓存实体对象的
            iter= session.createQuery("select username from Dbuser").iterate();
            while(iter.hasNext()) {
                String name = (String)iter.next();
                System.out.println(name);
            }
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            HibernateUtil.getSessionFactory().close();
        }
    }
}
