package com.ats.webapi.repository.tray;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.tray.TrayMgtHeader;

@Repository
public interface TrayMgtHeaderRepository extends JpaRepository<TrayMgtHeader, Integer>{

}
