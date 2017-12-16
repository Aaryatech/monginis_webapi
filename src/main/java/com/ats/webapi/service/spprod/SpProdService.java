package com.ats.webapi.service.spprod;

import java.util.List;

import com.ats.webapi.model.ErrorMessage;
import com.ats.webapi.model.spprod.Employee;
import com.ats.webapi.model.spprod.EmployeeList;
import com.ats.webapi.model.spprod.GetEmployeeList;
import com.ats.webapi.model.spprod.Instrument;
import com.ats.webapi.model.spprod.InstrumentList;
import com.ats.webapi.model.spprod.MDept;
import com.ats.webapi.model.spprod.MDeptList;
import com.ats.webapi.model.spprod.Shift;
import com.ats.webapi.model.spprod.ShiftList;
import com.ats.webapi.model.spprod.SpStation;
import com.ats.webapi.model.spprod.SpStationList;
import com.ats.webapi.model.spprod.StationAllocList;
import com.ats.webapi.model.spprod.StationAllocation;
import com.ats.webapi.model.spprod.TypeList;

public interface SpProdService {

	SpStation saveStation(SpStation spStation);

	Employee saveEmployee(Employee employee);

	Instrument saveInstrument(Instrument instrument);

	SpStationList getSpStationList();

	EmployeeList getEmployeeList(int empType);

	InstrumentList getInstrumentList(int instType);

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

	Shift saveShift(Shift shift);

	Shift getShift(int shiftId);

	ShiftList getShiftList();

	ErrorMessage deleteShift(int shiftId);

	TypeList getTypeList(int typeId);

	ErrorMessage deleteStationAllocation(int allocationId);

	StationAllocList getStationAllocList();

	StationAllocation getStationAlloc(int allocationId);

	StationAllocation saveProdStationAllocation(StationAllocation stationAllocation);

	GetEmployeeList  getEmployeesByType(int empType);


}
