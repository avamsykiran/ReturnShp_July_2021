package com.cts.srm.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;

import com.cts.srm.dao.SalesRecordDao;
import com.cts.srm.dao.SalesRecordDaoImpl;
import com.cts.srm.exception.DatabaseException;
import com.cts.srm.exception.InvalidUploadFileException;
import com.cts.srm.model.SalesRecord;
import com.cts.srm.model.SalesSummary;
import com.cts.srm.model.UploadSummary;

public class SalesRecordServiceImpl implements SalesRecordService {

	private SalesRecordDao dao;
	private Logger logger;
	
	public SalesRecordServiceImpl() throws DatabaseException {
		this.logger = Logger.getLogger(this.getClass());
		this.dao = new SalesRecordDaoImpl();
	}

	private UploadSummary parseAndSave(String line) {
		List<String> errors = new ArrayList<>();
		
		String details[] = line.split(",");
		
		if(details.length!=7) {
			errors.add("Incorrect number of attributes in "+line);
		}else {
			SalesRecord record = new SalesRecord();
			
			//parsing and validation
			
			try {
				dao.add(record);
			} catch (DatabaseException exp) {
				errors.add(exp.getMessage());
			}
		}
		
		return new UploadSummary(1,errors.isEmpty()?1:0,errors);
	}

	@Override
	public UploadSummary uploadData(String fileName) throws InvalidUploadFileException, DatabaseException {
		UploadSummary summary = null;

		final Path PATH = Paths.get(fileName);

		if (!Files.exists(PATH)) {
			throw new InvalidUploadFileException("The file to be uplaoded is not found");
		}

		try {
			summary = 
					Files.readAllLines(PATH)
					.stream()
					.map(this::parseAndSave)
					.reduce((s1, s2) -> new UploadSummary(s1,s2)).orElse(null);			
		} catch (IOException exp) {
			logger.error(exp);
			throw new InvalidUploadFileException("Unable to proces the uplaod file.");
		}

		return summary;
	}

	@Override
	public SalesSummary getSalesSummary(LocalDate start, LocalDate end) throws DatabaseException {
		// TODO Auto-generated method stub
		return null;
	}

}
