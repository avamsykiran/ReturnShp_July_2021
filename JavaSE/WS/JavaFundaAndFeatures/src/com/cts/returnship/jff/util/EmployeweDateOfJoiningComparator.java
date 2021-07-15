package com.cts.returnship.jff.util;

import java.util.Comparator;

import com.cts.returnship.jff.model.Employee;

public class EmployeweDateOfJoiningComparator implements Comparator<Employee>{

	@Override
	public int compare(Employee arg0, Employee arg1) {
		return arg0.getDateOfJoining().compareTo(arg1.getDateOfJoining());
	}

}
