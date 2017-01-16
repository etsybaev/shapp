package com.happ.service;

import com.happ.AccessPointsEnum;
import com.happ.dao.AccessPointsDao;
import com.happ.model.AccessPoints;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ievgenii.tsybaiev on 10.01.2017.
 */

@Service
public class AccessPointsServiceImpl implements AccessPointsService {

    private AccessPointsDao accessPointsDao;

    public void setAccessPointsDao(AccessPointsDao accessPointsDao) {
        this.accessPointsDao = accessPointsDao;
    }

    @Override
    @Transactional
    public int getAccessPointId(AccessPointsEnum accessPointsEnum){
        return this.accessPointsDao.getAccessPointId(accessPointsEnum);
    }

    @Override
    @Transactional
    public List<AccessPoints> getAllAccessPoints(){
        return this.accessPointsDao.getAllAccessPoints();
    }

    @Override
    @Transactional
    public AccessPoints getAccessPointById(int id) {
        return accessPointsDao.getAccessPointById(id);
    }
}
