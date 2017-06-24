package component.hibernate.cache.session;

import component.hibernate.entity.Dbuser;
import component.hibernate.util.HibernateUtil;
import org.hibernate.CacheMode;
import org.hibernate.Session;

/**
 * 二级缓存:SessionFactory
 * 缓存的生命周期和SessionFactory（线程安全，一个数据库对应一个，重量级）的生命周期一致，所以SessionFactory可以管理二级缓存
 * Created by wangjianjun on 2017/6/21.
 */
public class SecondCache {

    public void fun_secondCache(){
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            Dbuser dbuser = (Dbuser) session.load(Dbuser.class,111);
            System.out.println(dbuser.getUsername());
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            session.flush();
        }

        HibernateUtil.getSessionFactory().evict(Dbuser.class,1111);//清空session缓存
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            session.setCacheMode(CacheMode.IGNORE);//关闭二级缓存
            Dbuser dbuser = (Dbuser) session.load(Dbuser.class,111);
            System.out.println("stu:"+dbuser.getUsername());
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            HibernateUtil.getSessionFactory().close();
        }
    }
}
