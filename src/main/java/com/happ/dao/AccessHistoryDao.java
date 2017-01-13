package com.happ.dao;


import com.happ.model.AccessHistory;

import java.util.List;

/**
 * Created by ievgenii.tsybaiev on 10.01.2017.
 */


public interface AccessHistoryDao {
    public void addHistoryRecord(AccessHistory accessHistory);
    public List<AccessHistory> getAllUserHistoryByUserId(int id);
}

