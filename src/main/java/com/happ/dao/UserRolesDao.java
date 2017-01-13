package com.happ.dao;

import com.happ.UserRolesEnum;
import com.happ.model.UserRoles;

import java.util.List;

/**
 * Created by ievgenii.tsybaiev on 10.01.2017.
 */
public interface UserRolesDao {
    public int getUserRolesId(UserRolesEnum userRolesEnum);
    public List<UserRoles> getAllUserRoles();
}
