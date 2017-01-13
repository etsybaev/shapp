package com.happ.dao;

import com.happ.AccessPointsEnum;
import com.happ.model.AccessPoints;

import java.util.List;

/**
 * Created by ievgenii.tsybaiev on 10.01.2017.
 */
public interface AccessPointsDao {
    public int getAccessPointId(AccessPointsEnum accessPointsEnum);
    public List<AccessPoints> getAllAccessPoints();
}
