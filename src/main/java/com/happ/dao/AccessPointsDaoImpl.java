package com.happ.dao;

import org.hibernate.Session;
import com.happ.AccessPointsEnum;
import com.happ.model.AccessPoints;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Created by ievgenii.tsybaiev on 10.01.2017.
 */

@Repository
public class AccessPointsDaoImpl implements AccessPointsDao {

    SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public int getAccessPointId(AccessPointsEnum accessPointsEnum) {
        Session session = this.sessionFactory.getCurrentSession();
        String hql = "from AccessPoints where accessPointName = :pointName";
        Query query = session.createQuery(hql);
        Query userId = query.setParameter("pointName", accessPointsEnum.getName());
        List<AccessPoints> list = userId.list();

        if(list != null && !list.isEmpty()){
            return list.get(0).getId();
        }else {
            System.out.println("Can't find id for access point " + accessPointsEnum.getName());
            return -1;
        }

    }

    @Override
    public List<AccessPoints> getAllAccessPoints() {
        System.out.println("Getting accessPointsList");
        Session session = this.sessionFactory.getCurrentSession();
        List<AccessPoints> accessPointsList = session.createQuery("from AccessPoints ").list();

        for(AccessPoints accessPoint : accessPointsList){
            System.out.println("Got accessPoint " + accessPoint);
        }
        return accessPointsList;
    }


    @Override
    public AccessPoints getAccessPointById(int id) {
        System.out.println("Getting accessPoint by Id");
        Session session = this.sessionFactory.getCurrentSession();
        AccessPoints accessPoint = (AccessPoints) session.load(AccessPoints.class, new Integer(id));
        System.out.println("Got accessPoint: " + accessPoint);
        return accessPoint;
    }

}
