package component.hibernate.main;

import component.hibernate.cache.session.SecondCache;

/**
 * Created by wangjianjun on 2017/6/21.
 */
public class Main {

    public static void main(String[] args) {

//        System.out.println("maven hibernate mysql");
//        Session session = HibernateUtil.getSessionFactory().openSession();
//
//        session.beginTransaction();
//        Dbuser dbuser = new Dbuser();
//        dbuser.setUserId(100);
//        dbuser.setUsername("marry");
//        dbuser.setCreateBy("jack");
//        dbuser.setCreateDate(new Date());
//
//        session.save(dbuser);
//        session.getTransaction().commit();
//
//        Dbuser dbuserA  = (Dbuser) session.load(Dbuser.class,100);//加载第一条记录
//        System.out.println(dbuserA.getCreateDate());

//        DbUserDao dbUserDao = new DbUserDao();
//        dbUserDao.batchUpdateDbuser();

//        SessionCache sessionCache = new SessionCache();
//        sessionCache.testIteratorSession();

        SecondCache secondCache = new SecondCache();
        secondCache.fun_secondCache();
    }
}
