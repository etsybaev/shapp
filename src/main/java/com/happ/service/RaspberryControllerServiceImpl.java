package com.happ.service;


import com.happ.AccessPointsEnum;
import com.happ.dao.RaspberryControllerDaoImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by ievgenii.tsybaiev on 11.01.2017.
 */


@Service
public class RaspberryControllerServiceImpl implements RaspberryControllerService {

    @Override
    @Transactional
    public void openAccessPoint(AccessPointsEnum accessPoint){
        RaspberryControllerDaoImpl.getInstance(accessPoint).openAccessPoint();
    }

}
