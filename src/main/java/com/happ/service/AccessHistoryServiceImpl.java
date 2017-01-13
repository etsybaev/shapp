package com.happ.service;

import com.happ.dao.AccessHistoryDao;
import com.happ.model.AccessHistory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ievgenii.tsybaiev on 10.01.2017.
 */

@Service
public class AccessHistoryServiceImpl implements AccessHistoryService {

    AccessHistoryDao accessHistoryDao;

    public void setAccessHistoryDao(AccessHistoryDao accessHistoryDao) {
        this.accessHistoryDao = accessHistoryDao;
    }


    @Override
    @Transactional
    public void addHistoryRecord(AccessHistory accessHistory) {
        this.accessHistoryDao.addHistoryRecord(accessHistory);
    }

    @Override
    @Transactional
    public List<AccessHistory> getAllUserHistoryByUserId(int id) {
        return this.accessHistoryDao.getAllUserHistoryByUserId(id);
    }
}
