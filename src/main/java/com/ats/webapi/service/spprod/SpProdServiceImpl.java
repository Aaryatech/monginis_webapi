package com.ats.webapi.service.spprod;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.ErrorMessage;
import com.ats.webapi.model.Info;
import com.ats.webapi.model.spprod.Employee;
import com.ats.webapi.model.spprod.EmployeeList;
import com.ats.webapi.model.spprod.GetEmployee;
import com.ats.webapi.model.spprod.GetEmployeeList;
import com.ats.webapi.model.spprod.GetSpStation;
import com.ats.webapi.model.spprod.GetStationAllocation;
import com.ats.webapi.model.spprod.Instrument;
import com.ats.webapi.model.spprod.InstrumentList;
import com.ats.webapi.model.spprod.MDept;
import com.ats.webapi.model.spprod.MDeptList;
import com.ats.webapi.model.spprod.MType;
import com.ats.webapi.model.spprod.Shift;
import com.ats.webapi.model.spprod.ShiftList;
import com.ats.webapi.model.spprod.SpStation;
import com.ats.webapi.model.spprod.SpStationList;
import com.ats.webapi.model.spprod.StationAllocList;
import com.ats.webapi.model.spprod.StationAllocation;
import com.ats.webapi.model.spprod.TypeList;
import com.ats.webapi.repository.EmployeeRepository;
import com.ats.webapi.repository.GetEmployeeRepository;
import com.ats.webapi.repository.GetSpStationRepository;
import com.ats.webapi.repository.GetStationAllocRepository;
import com.ats.webapi.repository.InstrumentRepository;
import com.ats.webapi.repository.MDeptRepository;
import com.ats.webapi.repository.ProdStationAllocRepository;
import com.ats.webapi.repository.ShiftRepository;
import com.ats.webapi.repository.SpStationRepository;
import com.ats.webapi.repository.TypeRepository;

@Service
public class SpProdServiceImpl implements SpProdService{

	@Autowired
	ProdStationAllocRepository prodStationAllocRepository;
	
	@Autowired
	GetStationAllocRepository getStationAllocRepository;
	
	@Autowired
	SpStationRepository spStationRepository;
	
	@Autowired
	GetSpStationRepository getSpStationRepository;
	
	@Autowired
	InstrumentRepository instrumentRepository;
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	GetEmployeeRepository getEmployeeRepository;
	
	@Autowired
	private MDeptRepository mDeptRepository;
	
	@Autowired
	private ShiftRepository shiftRepository;
	
	@Autowired
	TypeRepository typeRepository;
	
	@Override
	public SpStation saveStation(SpStation spStation) {

		SpStation spStationRes=spStationRepository.save(spStation);
		
		return spStationRes;
	}
	
	@Override
	public Instrument saveInstrument(Instrument instrument) {

		Instrument instrumentRes=instrumentRepository.save(instrument);
		
		return instrumentRes;
	}
	
	@Override
	public Employee saveEmployee(Employee employee) {

		Employee employeeRes=employeeRepository.save(employee);
		
		return employeeRes;
	}

	@Override
	public SpStationList getSpStationList() {

		SpStationList spStationList=new SpStationList();
		Info info=new Info();
		
		List<GetSpStation> spStationListRes=getSpStationRepository.findGetSpStationByDelStatus();
		
		if(!spStationListRes.isEmpty())
		{
			info.setError(false);
            info.setMessage("SpStation List Found Successfully");
            spStationList.setSpStationList(spStationListRes);
            spStationList.setInfo(info);
		}
		else
		{
			info.setError(true);
            info.setMessage("SpStation List Not Found");
            spStationList.setInfo(info);
		}
		return spStationList;
	}

	@Override
	public EmployeeList getEmployeeList(int empType) {

		EmployeeList employeeList=new EmployeeList();
		Info info=new Info();
		
		List<GetEmployee> empListRes=getEmployeeRepository.findGetEmployeeByDelStatus(empType);
		
		if(!empListRes.isEmpty())
		{
			info.setError(false);
            info.setMessage("Employee List Found Successfully");
			employeeList.setEmployeeList(empListRes);
			employeeList.setInfo(info);
		}
		else
		{
			info.setError(true);
            info.setMessage("Employee List Not Found");
			employeeList.setInfo(info);
		}
		return employeeList;
	}

	@Override
	public InstrumentList getInstrumentList(int instType) {
		
		InstrumentList instrumentList=new InstrumentList();
		Info info=new Info();
		
		List<Instrument> instrumentRes=instrumentRepository.findAllByDelStatus(0,instType);
		
		if(!instrumentRes.isEmpty())
		{
			info.setError(false);
            info.setMessage("Instrument List Found Successfully");
            instrumentList.setInstrumentList(instrumentRes);
            instrumentList.setInfo(info);
		}
		else
		{
			info.setError(true);
            info.setMessage("Instrument List Not Found");
            instrumentList.setInfo(info);
		}
		return instrumentList;
	}

	@Override
	public SpStation getSpStationByStId(int stId) {

		SpStation spStation=spStationRepository.findSpStationByStId(stId);
		
		return spStation;
	}

	@Override
	public Employee getEmployeeByEmpId(int empId) {

		Employee employee=employeeRepository.findEmployeeByEmpId(empId);
		
		return employee;
	}

	@Override
	public Instrument getInstrumentByInstrumentId(int instrumentId) {

		Instrument instrument=instrumentRepository.findInstrumentByInstrumentId(instrumentId);
		return instrument;
	}
	
	@Override
	public ErrorMessage save(MDept MDept) {
		
		ErrorMessage errorMessage = new ErrorMessage();
		try {
				MDept dept = mDeptRepository.save(MDept);
					if (dept != null) 
					{
						errorMessage.setError(false);
						errorMessage.setMessage("Department Saved Successfully.");
					} 
					else 
					{
						errorMessage.setError(true);
						errorMessage.setMessage("Failed To Save Department.");
					}
		
			}catch(Exception e)
			{
				errorMessage.setError(true);
				errorMessage.setMessage("Failed To Save Department EXC");
			}
		return errorMessage;
	
	}


	@Override
	public MDeptList allListMDept() {
		
		MDeptList mDeptList = new MDeptList();
		ErrorMessage errorMessage = new ErrorMessage();
		try
		{
			List<MDept> mDeptListRes = mDeptRepository.findMDeptByDelStatus(0);
			
			if(!mDeptListRes.isEmpty())
			{
			  mDeptList.setList(mDeptListRes);
			       errorMessage.setError(false);
			       errorMessage.setMessage("MDept List Found Successfully.");
			  mDeptList.setErrorMessage(errorMessage);
			}
			else
			{
				errorMessage.setError(false);
				errorMessage.setMessage("MDept List Not Found.");
				mDeptList.setErrorMessage(errorMessage);
			}
			
		}catch(Exception e)
		{
			
			errorMessage.setError(true);
			errorMessage.setMessage("MDepts List Not Found");
			mDeptList.setErrorMessage(errorMessage);
		}
		return mDeptList;
	}

	@Override
	public ErrorMessage deleteMdeptById(int deptId) {

		ErrorMessage errorMessage = new ErrorMessage();
		try
		{
			int delete = mDeptRepository.deleteById(deptId);
			if(delete==0)
			{
				errorMessage.setError(true);
				errorMessage.setMessage("MDept Deletion Failed");
						}
			else
			{
				errorMessage.setError(false);
				errorMessage.setMessage("MDept Successfully Deleted");
			}
			
		}catch(Exception e)
		{
			errorMessage.setError(true);
			errorMessage.setMessage("MDept Deletion Failed EXC");
		}
		return errorMessage;
		
	}

	@Override
	public ErrorMessage deleteInstrument(int instrumentId) {
		
		ErrorMessage errorMessage = new ErrorMessage();
		try
		{
			int delete = instrumentRepository.deleteByInstrumentId(instrumentId);
			if(delete==0)
			{
				errorMessage.setError(true);
				errorMessage.setMessage("Instrument Deletion Failed");
			}
			else
			{
				errorMessage.setError(false);
				errorMessage.setMessage("Instrument Successfully Deleted");
			}
			
		}catch(Exception e)
		{
			errorMessage.setError(true);
			errorMessage.setMessage("Instrument Deletion Failed EXC");
		}
		return errorMessage;
	}

	@Override
	public ErrorMessage deleteEmployee(int empId) {
		ErrorMessage errorMessage = new ErrorMessage();
		try
		{
			int delete = employeeRepository.deleteByEmpId(empId);
			if(delete==0)
			{
				errorMessage.setError(true);
				errorMessage.setMessage("Employee Deletion Failed");
			}
			else
			{
				errorMessage.setError(false);
				errorMessage.setMessage("Employee Successfully Deleted");
			}
			
		}catch(Exception e)
		{
			errorMessage.setError(true);
			errorMessage.setMessage("Employee Deletion Failed EXC");
		}
		return errorMessage;
	}

	@Override
	public ErrorMessage deleteSPStation(int spId) {
	
		ErrorMessage errorMessage = new ErrorMessage();
		try
		{
			int delete = spStationRepository.deleteBySpId(spId);
			if(delete==0)
			{
				errorMessage.setError(true);
				errorMessage.setMessage("SPStation Deletion Failed");
			}
			else
			{
				errorMessage.setError(false);
				errorMessage.setMessage("SPStation Successfully Deleted");
			}
			
		}catch(Exception e)
		{
			errorMessage.setError(true);
			errorMessage.setMessage("SPStation Deletion Failed EXC");
		}
		return errorMessage;
	}

	@Override
	public MDept getDepartment(int deptId) {

		MDept mDept=mDeptRepository.findMDeptByDeptId(deptId);
		return mDept;
	}

	@Override
	public Shift saveShift(Shift shift) {

		Shift shiftRes=shiftRepository.save(shift);
		return shiftRes;
	}

	@Override
	public Shift getShift(int shiftId) {

		Shift shiftRes=shiftRepository.findShiftByShiftId(shiftId);
		return shiftRes;
	}

	@Override
	public ShiftList getShiftList() {

		ShiftList shiftList = new ShiftList();
		ErrorMessage errorMessage = new ErrorMessage();
		try
		{
			List<Shift> shiftListRes = shiftRepository.findShiftByDelStatus(0);
			
			if(!shiftListRes.isEmpty())
			{
				shiftList.setShiftList(shiftListRes);
			       errorMessage.setError(false);
			       errorMessage.setMessage("ShiftList Found Successfully.");
			       shiftList.setErrorMessage(errorMessage);
			}
			else
			{
				errorMessage.setError(false);
				errorMessage.setMessage("ShiftList Not Found.");
				shiftList.setErrorMessage(errorMessage);
			}
			
		}catch(Exception e)
		{
			
			errorMessage.setError(true);
			errorMessage.setMessage("ShiftList Not Found");
			shiftList.setErrorMessage(errorMessage);
		}
		return shiftList;
	}

	@Override
	public ErrorMessage deleteShift(int shiftId) {
		ErrorMessage errorMessage = new ErrorMessage();
		try
		{
			int deleteRes = shiftRepository.deleteByShiftId(shiftId);
			if(deleteRes==0)
			{
				errorMessage.setError(true);
				errorMessage.setMessage("Shift Deletion Failed");
			}
			else
			{
				errorMessage.setError(false);
				errorMessage.setMessage("Shift Successfully Deleted");
			}
			
		}catch(Exception e)
		{
			errorMessage.setError(true);
			errorMessage.setMessage("Shift Deletion Failed EXC");
		}
		return errorMessage;
	}

	@Override
	public TypeList getTypeList(int typeId) {

		TypeList typeList = new TypeList();
		ErrorMessage errorMessage = new ErrorMessage();
		try
		{
			List<MType> typeListRes = typeRepository.findMTypeByDelStatusAndSubType(0,typeId);
			
			if(!typeListRes.isEmpty())
			{
				   typeList.setTypeList(typeListRes);
			       errorMessage.setError(false);
			       errorMessage.setMessage("TypeList Found Successfully.");
			       typeList.setErrorMessage(errorMessage);
			}
			else
			{
				errorMessage.setError(false);
				errorMessage.setMessage("TypeList Not Found.");
				typeList.setErrorMessage(errorMessage);
			}
			
		}catch(Exception e)
		{
			
			errorMessage.setError(true);
			errorMessage.setMessage("TypeList Not Found");
			typeList.setErrorMessage(errorMessage);
		}
		return typeList;
	}

	@Override
	public StationAllocation saveProdStationAllocation(StationAllocation stationAllocation) {

		StationAllocation sTAllocation=prodStationAllocRepository.save(stationAllocation);
		
		return sTAllocation;
	}

	@Override
	public ErrorMessage deleteStationAllocation(int allocationId) {
		ErrorMessage errorMessage = new ErrorMessage();
		try
		{
			int deleteRes = prodStationAllocRepository.deleteByAllocationId(allocationId);
			if(deleteRes==0)
			{
				errorMessage.setError(true);
				errorMessage.setMessage("StationAllocation Deletion Failed");
			}
			else
			{
				errorMessage.setError(false);
				errorMessage.setMessage("StationAllocation Successfully Deleted");
			}
			
		}catch(Exception e)
		{
			errorMessage.setError(true);
			errorMessage.setMessage("StationAllocation Deletion Failed EXC");
		}
		return errorMessage;
	}

	@Override
	public StationAllocList getStationAllocList() {

		StationAllocList stationAllocList = new StationAllocList();
		ErrorMessage errorMessage = new ErrorMessage();
		try
		{
			List<GetStationAllocation> stationListRes = getStationAllocRepository.findStationAllocations();
			
			if(!stationListRes.isEmpty())
			{
				stationAllocList.setStationAllocationList(stationListRes);
			       errorMessage.setError(false);
			       errorMessage.setMessage("StationAllocList Found Successfully.");
			       stationAllocList.setErrorMessage(errorMessage);
			}
			else
			{
				errorMessage.setError(false);
				errorMessage.setMessage("StationAllocList Not Found.");
				stationAllocList.setErrorMessage(errorMessage);
			}
			
		}catch(Exception e)
		{
			
			errorMessage.setError(true);
			errorMessage.setMessage("StationAllocList Not Found");
			stationAllocList.setErrorMessage(errorMessage);
		}
		return stationAllocList;
	}

	@Override
	public StationAllocation getStationAlloc(int allocationId) {

		StationAllocation stationAllocationRes = prodStationAllocRepository.findStationAllocationByAllocationId(allocationId);
		return stationAllocationRes;
	}

	@Override
	public GetEmployeeList getEmployeesByType(int empType) {
		
		
		GetEmployeeList employeeList=new GetEmployeeList();
		ErrorMessage errorMessage=new ErrorMessage();
		
		List<Employee> empListRes=employeeRepository.findEmployeeByEmpTypeAndDelStatus(empType,0);
		
		if(!empListRes.isEmpty())
		{
			errorMessage.setError(false);
			errorMessage.setMessage("Employee List Found Successfully");
			employeeList.setGetEmpList(empListRes);
			employeeList.setErrorMessage(errorMessage);
		}
		else
		{
			errorMessage.setError(true);
			errorMessage.setMessage("Employee List Not Found");
			employeeList.setErrorMessage(errorMessage);
		}
		
		
		return employeeList;
	}


}