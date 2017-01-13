package com.happ.dao;

import com.happ.model.AccessHistory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ievgenii.tsybaiev on 10.01.2017.
 */

@Repository
public class AccessHistoryDaoImpl implements AccessHistoryDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void addHistoryRecord(AccessHistory accessHistory) {
        System.out.println("Adding accessHistory " + accessHistory);
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(accessHistory);
        System.out.println("AccessHistory " + accessHistory + " has been added");
    }

    @Override
    public List<AccessHistory> getAllUserHistoryByUserId(int id) {
        System.out.println("Getting AccessHistory list for user with id " + id);
        Session session = this.sessionFactory.getCurrentSession();

        String hql = "from AccessHistory where userId = :userId";
        Query query = session.createQuery(hql);
        Query userId = query.setParameter("userId", id);
        List<AccessHistory> list = userId.list();

        for(AccessHistory accessHistory : list){
            System.out.println("Got AccessHistory " + accessHistory);
        }
        return list;
    }
}
