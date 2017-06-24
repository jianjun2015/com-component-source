package component.hibernate.dao;

import component.hibernate.entity.Dbuser;
import component.hibernate.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.Iterator;
import java.util.List;

/**
 * Created by wangjianjun on 2017/6/21.
 */
public class DbUserDao {

    public Dbuser getDbuser(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Dbuser dbuser = (Dbuser) session.load(Dbuser.class,100);

        return dbuser;
    }

    public void deleteDbUser(){
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            session.getTransaction().begin();
            Dbuser dbuser = (Dbuser) session.load(Dbuser.class,100);
            session.delete(dbuser);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            HibernateUtil.getSessionFactory().close();
        }
    }

    public List<Dbuser> getDbusers(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        Query query = session.createQuery("from Dbuser");

        //设置分页
        query.setFirstResult(0);//第几个开始查询
        query.setMaxResults(2);//最大记录数

        List<Dbuser> dbusers = query.list();

        for (Iterator it=dbusers.iterator();it.hasNext();){
            Dbuser dbuser = (Dbuser) it.next();
            System.out.println(dbuser.getCreateDate());
        }

        return dbusers;
    }

    public void updateDbUser(){
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            session.getTransaction().begin();
            Dbuser dbuser = (Dbuser) session.load(Dbuser.class,100);

            dbuser.setUsername("lisi");
            session.update(dbuser);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            HibernateUtil.getSessionFactory().close();
        }
    }

    public void batchUpdateDbuser(){

        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            session.getTransaction().begin();
            Query query = session.createQuery("update Dbuser set username=:newName");

            int updates = query.setString("newName","lisi").executeUpdate();
            System.out.println(updates);

            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            HibernateUtil.getSessionFactory().close();
        }
    }
}
