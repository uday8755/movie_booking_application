package com.uday.mbs.dao;

import com.uday.mbs.entities.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusDao extends JpaRepository<Status, Integer> {
    public  Status findByStatusName(String statusName);
}
