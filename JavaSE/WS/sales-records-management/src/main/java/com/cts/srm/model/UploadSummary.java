package com.cts.srm.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UploadSummary {
	
	private int totalRecords;
	private int recordsInserted;
	private List<String> errorLog;

	public UploadSummary() {
		this.errorLog=new ArrayList<String>();
	}
	
	public UploadSummary(UploadSummary s1, UploadSummary s2) {
		super();
		this.totalRecords = s1.totalRecords+s2.totalRecords;
		this.recordsInserted = s1.recordsInserted+s2.recordsInserted;
		this.errorLog = this.merge(s1.getErrorLog(),s2.getErrorLog());
	}

	public UploadSummary(int i, int j, List<String> errorLog) {
		this.totalRecords = totalRecords;
		this.recordsInserted = recordsInserted;
		this.errorLog=errorLog;
	}

	private List<String> merge(List<String> ...errLogs){
		return Arrays.stream(errLogs).flatMap(List<String>::stream).collect(Collectors.toList());
	}
	
	public int getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}

	public int getRecordsInserted() {
		return recordsInserted;
	}

	public void setRecordsInserted(int recordsInserted) {
		this.recordsInserted = recordsInserted;
	}

	public List<String> getErrorLog() {
		return errorLog;
	}

	public void setErrorLog(List<String> errorLog) {
		this.errorLog = errorLog;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((errorLog == null) ? 0 : errorLog.hashCode());
		result = prime * result + recordsInserted;
		result = prime * result + totalRecords;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UploadSummary other = (UploadSummary) obj;
		if (errorLog == null) {
			if (other.errorLog != null)
				return false;
		} else if (!errorLog.equals(other.errorLog))
			return false;
		if (recordsInserted != other.recordsInserted)
			return false;
		if (totalRecords != other.totalRecords)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UploadSummary [totalRecords=" + totalRecords + ", recordsInserted=" + recordsInserted + ", errorLog="
				+ errorLog + "]";
	}
	
	
}
