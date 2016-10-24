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

import com.testservice.adventureworks2014.Table13;


/**
 * ServiceImpl object for domain model class Table13.
 *
 * @see Table13
 */
@Service("AdventureWorks2014.Table13Service")
public class Table13ServiceImpl implements Table13Service {

    private static final Logger LOGGER = LoggerFactory.getLogger(Table13ServiceImpl.class);


    @Autowired
    @Qualifier("AdventureWorks2014.Table13Dao")
    private WMGenericDao<Table13, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Table13, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "AdventureWorks2014TransactionManager")
    @Override
	public Table13 create(Table13 table13) {
        LOGGER.debug("Creating a new Table13 with information: {}", table13);
        Table13 table13Created = this.wmGenericDao.create(table13);
        return table13Created;
    }

	@Transactional(readOnly = true, value = "AdventureWorks2014TransactionManager")
	@Override
	public Table13 getById(Integer table13Id) throws EntityNotFoundException {
        LOGGER.debug("Finding Table13 by id: {}", table13Id);
        Table13 table13 = this.wmGenericDao.findById(table13Id);
        if (table13 == null){
            LOGGER.debug("No Table13 found with id: {}", table13Id);
            throw new EntityNotFoundException(String.valueOf(table13Id));
        }
        return table13;
    }

    @Transactional(readOnly = true, value = "AdventureWorks2014TransactionManager")
	@Override
	public Table13 findById(Integer table13Id) {
        LOGGER.debug("Finding Table13 by id: {}", table13Id);
        return this.wmGenericDao.findById(table13Id);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "AdventureWorks2014TransactionManager")
	@Override
	public Table13 update(Table13 table13) throws EntityNotFoundException {
        LOGGER.debug("Updating Table13 with information: {}", table13);
        this.wmGenericDao.update(table13);

        Integer table13Id = table13.getId();

        return this.wmGenericDao.findById(table13Id);
    }

    @Transactional(value = "AdventureWorks2014TransactionManager")
	@Override
	public Table13 delete(Integer table13Id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Table13 with id: {}", table13Id);
        Table13 deleted = this.wmGenericDao.findById(table13Id);
        if (deleted == null) {
            LOGGER.debug("No Table13 found with id: {}", table13Id);
            throw new EntityNotFoundException(String.valueOf(table13Id));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "AdventureWorks2014TransactionManager")
	@Override
	public Page<Table13> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Table13s");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "AdventureWorks2014TransactionManager")
    @Override
    public Page<Table13> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Table13s");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "AdventureWorks2014TransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service AdventureWorks2014 for table Table13 to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

	@Transactional(readOnly = true, value = "AdventureWorks2014TransactionManager")
	@Override
	public long count(String query) {
        return this.wmGenericDao.count(query);
    }



}

