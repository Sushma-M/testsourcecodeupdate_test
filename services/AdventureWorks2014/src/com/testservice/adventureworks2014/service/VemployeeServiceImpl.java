/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testservice.adventureworks2014.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wavemaker.runtime.data.dao.WMGenericDao;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.file.model.Downloadable;

import com.testservice.adventureworks2014.Vemployee;
import com.testservice.adventureworks2014.VemployeeId;


/**
 * ServiceImpl object for domain model class Vemployee.
 *
 * @see Vemployee
 */
@Service("AdventureWorks2014.VemployeeService")
public class VemployeeServiceImpl implements VemployeeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(VemployeeServiceImpl.class);


    @Autowired
    @Qualifier("AdventureWorks2014.VemployeeDao")
    private WMGenericDao<Vemployee, VemployeeId> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Vemployee, VemployeeId> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

	@Transactional(readOnly = true, value = "AdventureWorks2014TransactionManager")
	@Override
	public Vemployee getById(VemployeeId vemployeeId) throws EntityNotFoundException {
        LOGGER.debug("Finding Vemployee by id: {}", vemployeeId);
        Vemployee vemployee = this.wmGenericDao.findById(vemployeeId);
        if (vemployee == null){
            LOGGER.debug("No Vemployee found with id: {}", vemployeeId);
            throw new EntityNotFoundException(String.valueOf(vemployeeId));
        }
        return vemployee;
    }

    @Transactional(readOnly = true, value = "AdventureWorks2014TransactionManager")
	@Override
	public Vemployee findById(VemployeeId vemployeeId) {
        LOGGER.debug("Finding Vemployee by id: {}", vemployeeId);
        return this.wmGenericDao.findById(vemployeeId);
    }


	@Transactional(readOnly = true, value = "AdventureWorks2014TransactionManager")
	@Override
	public Page<Vemployee> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Vemployees");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "AdventureWorks2014TransactionManager")
    @Override
    public Page<Vemployee> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Vemployees");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "AdventureWorks2014TransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service AdventureWorks2014 for table Vemployee to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

	@Transactional(readOnly = true, value = "AdventureWorks2014TransactionManager")
	@Override
	public long count(String query) {
        return this.wmGenericDao.count(query);
    }



}

