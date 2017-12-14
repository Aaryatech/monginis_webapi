package com.ats.webapi.service.spprod;

import com.ats.webapi.model.ErrorMessage;
import com.ats.webapi.model.spprod.Employee;
import com.ats.webapi.model.spprod.EmployeeList;
import com.ats.webapi.model.spprod.Instrument;
import com.ats.webapi.model.spprod.InstrumentList;
import com.ats.webapi.model.spprod.MDept;
import com.ats.webapi.model.spprod.MDeptList;
import com.ats.webapi.model.spprod.SpStation;
import com.ats.webapi.model.spprod.SpStationList;

public interface SpProdService {

	SpStation saveStation(SpStation spStation);

	Employee saveEmployee(Employee employee);

	Instrument saveInstrument(Instrument instrument);

	SpStationList getSpStationList();

	EmployeeList getEmployeeList();

	InstrumentList getInstrumentList();

	SpStation getSpStationByStId(int stId);

	Employee getEmployeeByEmpId(int empId);

	Instrument getInstrumentByInstrumentId(int instrumentId);
	
	public ErrorMessage save(MDept MDept);

	public MDeptList allListMDept();

	public ErrorMessage deleteMdeptById(int deptId);

	ErrorMessage deleteInstrument(int instrumentId);

	ErrorMessage deleteEmployee(int empId);

	ErrorMessage deleteSPStation(int spId);

	MDept getDepartment(int deptId);


}
