package com.cts.srm.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

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

	private final String numRegx = "(\\s*\\d+\\s*)";
	private final String decRegx = "(\\s*\\d+\\.?\\d+\\s*)";
	private final String dateRegx = "([0-9]{1,2}-[A-Z[a-z]]{3}-[0-9]{4})";
	private String regex;
	private final DateTimeFormatter dtFormatter;
	
	public SalesRecordServiceImpl() throws DatabaseException {
		this.dao = new SalesRecordDaoImpl();
		this.logger = Logger.getLogger(this.getClass());
		this.dtFormatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
		this.regex = numRegx + ",(.*),(.*)," + numRegx + "," + decRegx + "," + decRegx + "," + dateRegx;
	}

	private UploadSummary parseAndSave(String line) {
		List<String> errors = new ArrayList<>();

		if (!line.matches(regex))
			errors.add("Incorrect format of attributes at " + line);
		else {

			String details[] = line.split(",");
			SalesRecord record = new SalesRecord();
			
			try {
				record.setReceiptNo(Long.parseLong(details[0]));
				record.setItemName(details[1]);
				record.setArea(details[2]);
				record.setQuantity(Integer.parseInt(details[3]));
				record.setAmount(Double.parseDouble(details[4]));
				record.setRate(Double.parseDouble(details[5]));
				record.setReceiptDate(LocalDate.parse(details[6],dtFormatter));
				dao.add(record);
			} catch (DateTimeParseException | DatabaseException exp) {
				errors.add(exp.getMessage());
			}
		}

		return new UploadSummary(1, errors.isEmpty() ? 1 : 0, errors);
	}

	@Override
	public UploadSummary uploadData(String fileName) throws InvalidUploadFileException, DatabaseException {
		UploadSummary summary = null;

		final Path PATH = Paths.get(fileName);

		if (!Files.exists(PATH)) {
			throw new InvalidUploadFileException("The file to be uplaoded is not found");
		}

		try {
			summary = Files.readAllLines(PATH).stream().map(this::parseAndSave)
					.reduce((s1, s2) -> new UploadSummary(s1, s2)).orElse(null);
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
