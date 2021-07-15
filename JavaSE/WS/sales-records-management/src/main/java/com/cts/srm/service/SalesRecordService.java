package com.cts.srm.service;

import java.time.LocalDate;

import com.cts.srm.exception.DatabaseException;
import com.cts.srm.exception.InvalidUploadFileException;
import com.cts.srm.model.SalesSummary;
import com.cts.srm.model.UploadSummary;

public interface SalesRecordService {
	UploadSummary uploadData(String fileName) throws InvalidUploadFileException,DatabaseException;
	SalesSummary getSalesSummary(LocalDate start,LocalDate end) throws DatabaseException;
}
