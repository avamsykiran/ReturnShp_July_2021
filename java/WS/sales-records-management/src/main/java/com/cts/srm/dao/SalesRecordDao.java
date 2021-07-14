package com.cts.srm.dao;

import java.time.LocalDate;
import java.util.List;

import com.cts.srm.exception.DatabaseException;
import com.cts.srm.model.SalesRecord;

public interface SalesRecordDao {
	boolean existsById(Long receiptNo) throws DatabaseException;
	SalesRecord add(SalesRecord record) throws DatabaseException;
	List<SalesRecord> getAllByDate(LocalDate start,LocalDate end) throws DatabaseException;
}
