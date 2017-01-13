package com.happ.service;


import com.happ.model.AccessHistory;

import java.util.List;

/**
 * Created by ievgenii.tsybaiev on 10.01.2017.
 */

public interface AccessHistoryService {
    public void addHistoryRecord(AccessHistory accessHistory);
    public List<AccessHistory> getAllUserHistoryByUserId(int id);
}
