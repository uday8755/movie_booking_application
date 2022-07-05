package com.uday.mbs.services;

import com.uday.mbs.entities.Status;
import com.uday.mbs.exceptions.StatusDetailsNotFoundException;

import java.util.List;

public interface StatusService {
    public Status acceptStatusDetails(Status status);
    public Status getStatusDetails(int id) throws StatusDetailsNotFoundException;
    public Status getStatusDetailsByStatusName(String statusName) throws StatusDetailsNotFoundException;
    public boolean deleteStatus(int id) throws StatusDetailsNotFoundException;
    public List<Status> getAllStatusDetails();
}
