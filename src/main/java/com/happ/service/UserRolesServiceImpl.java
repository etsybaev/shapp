package com.happ.service;

import com.happ.UserRolesEnum;
import com.happ.dao.UserRolesDao;
import com.happ.model.UserRoles;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ievgenii.tsybaiev on 12.01.2017.
 */

@Service
public class UserRolesServiceImpl implements UserRolesService {

    UserRolesDao userRolesDao;

    public void setUserRolesDao(UserRolesDao userRolesDao) {
        this.userRolesDao = userRolesDao;
    }

    @Override
    @Transactional
    public int getUserRolesId(UserRolesEnum userRolesEnum) {
        return this.userRolesDao.getUserRolesId(userRolesEnum);
    }

    @Override
    @Transactional
    public List<UserRoles> getAllUserRoles() {
        return this.userRolesDao.getAllUserRoles();
    }
}
