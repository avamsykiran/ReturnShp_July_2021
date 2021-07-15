package com.cts.srm.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.cts.srm.exception.DatabaseException;
import com.cts.srm.model.SalesRecord;

public class SalesRecordDaoImpl implements SalesRecordDao {

	private static final String ADD_QRY = "INSERT INTO sales VALUES(?,?,?,?,?,?,?)";
	private static final String GET_ALL_QRY = "SELECT * FROM sales WHERE receipt_date between ? and ?";
	private static final String EXISTS_QRY = "SELECT receipt_no FROM sales WHERE receipt_no=?";

	private ConnectionProvider conProv;
	private Logger logger;

	public SalesRecordDaoImpl() throws DatabaseException {
		logger = Logger.getLogger(this.getClass());
		try {
			this.conProv = ConnectionProvider.getInstance();
		} catch (IOException exp) {
			logger.fatal(exp);
			throw new DatabaseException("Unable to prepare data connectivity.");
		}
	}

	@Override
	public SalesRecord add(SalesRecord record) throws DatabaseException {
		if (record != null) {
			try (Connection con = conProv.getConnection(); PreparedStatement pst = con.prepareStatement(ADD_QRY)) {

				pst.setLong(1, record.getReceiptNo());
				pst.setString(2, record.getItemName());
				pst.setString(3, record.getArea());
				pst.setInt(4, record.getQuantity());
				pst.setDouble(5, record.getAmount());
				pst.setDouble(6, record.getRate());
				pst.setDate(7, Date.valueOf(record.getReceiptDate()));

				pst.executeUpdate();

			} catch (SQLException exp) {
				logger.error(exp);
				throw new DatabaseException("Unable to add the record#" + record.getReceiptNo());
			}
		}
		return record;
	}

	@Override
	public List<SalesRecord> getAllByDate(LocalDate start, LocalDate end) throws DatabaseException {
		List<SalesRecord> records = new ArrayList<SalesRecord>();

		try (Connection con = conProv.getConnection(); PreparedStatement pst = con.prepareStatement(GET_ALL_QRY)) {

			pst.setDate(1, Date.valueOf(start));
			pst.setDate(2, Date.valueOf(end));

			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				SalesRecord record = new SalesRecord();
				record.setReceiptNo(rs.getLong(1));
				record.setItemName(rs.getString(2));
				record.setArea(rs.getString(3));
				record.setQuantity(rs.getInt(4));
				record.setAmount(rs.getDouble(5));
				record.setRate(rs.getDouble(6));
				record.setReceiptDate(rs.getDate(7).toLocalDate());
				records.add(record);
			}

		} catch (SQLException exp) {
			logger.error(exp);
			throw new DatabaseException("Unable to retrive records");
		}

		return records.isEmpty() ? null : records;
	}

	@Override
	public boolean existsById(Long receiptNo) throws DatabaseException {
		boolean isFound = false;

		try (Connection con = conProv.getConnection(); PreparedStatement pst = con.prepareStatement(EXISTS_QRY)) {
			pst.setLong(1, receiptNo);
			isFound = pst.executeQuery().next();
		} catch (SQLException exp) {
			logger.error(exp);
			throw new DatabaseException("Unable to retrive records");
		}

		return isFound;
	}

}
