package com.ats.webapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.webapi.model.ErrorMessage;
import com.ats.webapi.model.GetMixingList;
import com.ats.webapi.model.Info;
import com.ats.webapi.model.MixingHeader;
import com.ats.webapi.model.spprod.Employee;
import com.ats.webapi.model.spprod.EmployeeList;
import com.ats.webapi.model.spprod.GetEmployeeList;
import com.ats.webapi.model.spprod.GetSpStation;
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
import com.ats.webapi.service.spprod.SpProdService;

@RestController
@RequestMapping("spProduction")
public class SpProdController {

	@Autowired
	private SpProdService spProdService;

	// ----------------------------SAVE SPStation---------------------------
	@RequestMapping(value = { "/saveStation" }, method = RequestMethod.POST)
	@ResponseBody
	public Info saveStation(@RequestBody SpStation spStation) {

		SpStation spStationRes = null;
		Info info = new Info();
		try {

			System.out.println("SpStation :" + spStation);
			spStationRes = spProdService.saveStation(spStation);

			if (spStationRes != null) {
				info.setError(false);
				info.setMessage("Sp Station Saved Successfully.");
			} else {
				info.setError(true);
				info.setMessage("Sp Station Not Saved .");
			}

		} catch (Exception e) {

			info.setError(true);
			info.setMessage("Sp Station Not Saved .");

			e.printStackTrace();
			System.out.println("Exception In SpProdController /saveStation" + e.getMessage());

		}
		return info;

	}

	// ------------------------Delete SPStation------------------------------------
	@RequestMapping(value = { "/deleteSPStation" }, method = RequestMethod.POST)
	@ResponseBody
	public ErrorMessage deleteSPStation(@RequestParam int spId) {

		ErrorMessage errorMessage = spProdService.deleteSPStation(spId);
		return errorMessage;
	}

	// ------------------------Delete Employee------------------------------------
	@RequestMapping(value = { "/deleteEmployee" }, method = RequestMethod.POST)
	@ResponseBody
	public ErrorMessage deleteEmployee(@RequestParam int empId) {

		ErrorMessage errorMessage = spProdService.deleteEmployee(empId);
		return errorMessage;
	}

	// ------------------------Delete Employee------------------------------------
	@RequestMapping(value = { "/deleteInstrument" }, method = RequestMethod.POST)
	@ResponseBody
	public ErrorMessage deleteInstrument(@RequestParam int instrumentId) {

		ErrorMessage errorMessage = spProdService.deleteInstrument(instrumentId);
		return errorMessage;
	}

	// ------------------------SAVE Employee---------------------------------
	@RequestMapping(value = { "/saveEmployee" }, method = RequestMethod.POST)
	@ResponseBody
	public Info saveEmployee(@RequestBody Employee employee) {

		Employee employeeRes = null;
		Info info = new Info();
		try {

			System.out.println("Employee :" + employee);
			employeeRes = spProdService.saveEmployee(employee);

			if (employeeRes != null) {
				info.setError(false);
				info.setMessage("Employee Saved Successfully.");
			} else {
				info.setError(true);
				info.setMessage("Employee Not Saved .");
			}

		} catch (Exception e) {

			info.setError(true);
			info.setMessage("Employee Not Saved .");

			e.printStackTrace();
			System.out.println("Exception In SpProdController /saveEmployee" + e.getMessage());

		}
		return info;

	}

	// -------------------------------------------------------------------------
	// ----------------------------SAVE Instrument-----------------------------
	@RequestMapping(value = { "/saveInstrument" }, method = RequestMethod.POST)
	@ResponseBody
	public Info saveInstrument(@RequestBody Instrument instrument) {

		Instrument instrumentRes = null;
		Info info = new Info();
		try {

			System.out.println("instrument :" + instrument);
			instrumentRes = spProdService.saveInstrument(instrument);

			if (instrumentRes != null) {
				info.setError(false);
				info.setMessage("Instrument Saved Successfully.");
			} else {
				info.setError(true);
				info.setMessage("Instrument Not Saved .");
			}

		} catch (Exception e) {

			info.setError(true);
			info.setMessage("Instrument Not Saved .");

			e.printStackTrace();
			System.out.println("Exception In SpProdController /saveInstrument" + e.getMessage());

		}
		return info;

	}

	// ---------------------------Getting SpStation List-----------------------
	@RequestMapping(value = { "/getSpStationList" }, method = RequestMethod.GET)
	public @ResponseBody SpStationList getSpStationList() {

		SpStationList spStationList = spProdService.getSpStationList();

		return spStationList;

	}

	// ---------------------------Getting Employee List-------------------------
	@RequestMapping(value = { "/getEmployeeList" }, method = RequestMethod.POST)
	public @ResponseBody EmployeeList getEmployeeList(@RequestParam("empType")int empType) {

		EmployeeList employeeList = spProdService.getEmployeeList(empType);

		return employeeList;

	}
	// ---------------------------Getting Employee List-------------------------
	@RequestMapping(value = { "/getEmployeesByType" }, method = RequestMethod.POST)
	public @ResponseBody GetEmployeeList getEmployeesByType(@RequestParam("empType")int empType) {

		GetEmployeeList employeeList = spProdService.getEmployeesByType(empType);

		return employeeList;

	}
	// ---------------------------Getting Instrument List----------------------
	@RequestMapping(value = { "/getInstrumentList" }, method = RequestMethod.POST)
	public @ResponseBody InstrumentList getInstrumentList(@RequestParam("instType")int instType) {

		InstrumentList instrumentList = spProdService.getInstrumentList(instType);

		return instrumentList;

	}

	// ------------------------Getting One Sp Station by Id-----------------------
	@RequestMapping(value = { "/getSpStation" }, method = RequestMethod.POST)
	public @ResponseBody SpStation getSpStation(@RequestParam("stId") int stId) {

		SpStation getSpStation = null;
		try {
			getSpStation = spProdService.getSpStationByStId(stId);

			if (getSpStation != null) {
				getSpStation.setError(false);
				getSpStation.setMessage("SpStation Found Successfully");
			} else {
				getSpStation = new SpStation();
				getSpStation.setError(true);
				getSpStation.setMessage("SpStation Not Found");
			}
		} catch (Exception e) {
			getSpStation = new SpStation();
			getSpStation.setError(true);
			getSpStation.setMessage("SpStation Not Found");
			System.out.println("Exception In getSpStation:" + e.getMessage());
		}

		return getSpStation;

	}

	// -----------------------Getting Employee By Id----------------------------
	@RequestMapping(value = { "/getEmployee" }, method = RequestMethod.POST)
	public @ResponseBody Employee getEmployee(@RequestParam("empId") int empId) {

		Employee employee = null;
		try {
			employee = spProdService.getEmployeeByEmpId(empId);

			if (employee != null) {
				employee.setError(false);
				employee.setMessage("Employee Found Successfully");
			} else {
				employee = new Employee();
				employee.setError(true);
				employee.setMessage("Employee Not Found");
			}
		} catch (Exception e) {
			employee = new Employee();
			employee.setError(true);
			employee.setMessage("Employee Not Found");
		}
		return employee;

	}

	// ---------------------------Getting Instrument By
	// Id----------------------------
	@RequestMapping(value = { "/getInstrument" }, method = RequestMethod.POST)
	public @ResponseBody Instrument getInstrument(@RequestParam("instrumentId") int instrumentId) {

		Instrument instrument = null;
		try {
			instrument = spProdService.getInstrumentByInstrumentId(instrumentId);

			if (instrument != null) {
				instrument.setError(false);
				instrument.setMessage("Instrument Found Successfully");
			} else {
				instrument = new Instrument();
				instrument.setError(true);
				instrument.setMessage("Instrument Not Found");
			}
		} catch (Exception e) {
			instrument = new Instrument();

			instrument.setError(true);
			instrument.setMessage("Instrument Not Found");
		}
		return instrument;

	}
	// --------------------------------------------------------------------------
	// -----------------------------------m_cm_dept-----------------------------

	@RequestMapping(value = { "/saveDept" }, method = RequestMethod.POST)
	@ResponseBody
	public ErrorMessage insertmdept(@RequestBody MDept mDept) {

		ErrorMessage errorMessage = spProdService.save(mDept);
		return errorMessage;

	}

	@RequestMapping(value = { "/editDept" }, method = RequestMethod.POST)
	@ResponseBody
	public ErrorMessage editmdept(@RequestBody MDept mDept) {

		ErrorMessage errorMessage = spProdService.save(mDept);
		return errorMessage;
	}

	@RequestMapping(value = { "/mDeptList" }, method = RequestMethod.GET)
	@ResponseBody
	public MDeptList mDeptList() {

		MDeptList mDeptList = spProdService.allListMDept();
		return mDeptList;
	}

	@RequestMapping(value = { "/deleteMDept" }, method = RequestMethod.POST)
	@ResponseBody
	public ErrorMessage deleteMDept(@RequestParam int deptId) {

		ErrorMessage errorMessage = spProdService.deleteMdeptById(deptId);
		return errorMessage;
	}

	@RequestMapping(value = { "/getDepartment" }, method = RequestMethod.POST)
	@ResponseBody
	public MDept getDepartment(@RequestParam int deptId) {

		MDept mDept = null;
		try {
			mDept = spProdService.getDepartment(deptId);

			if (mDept != null) {
				mDept.setError(false);
				mDept.setMessage("Dept Found Successfully");
			} else {
				mDept = new MDept();
				mDept.setError(true);
				mDept.setMessage("Dept Not Found");
			}
		} catch (Exception e) {

			mDept = new MDept();
			mDept.setError(true);
			mDept.setMessage("Dept Not Found");

		}
		return mDept;
	}

	// ---------------------------------------------------------------------------
	// ----------------------------SAVE Shift------------------------------------
	@RequestMapping(value = { "/saveShift" }, method = RequestMethod.POST)
	@ResponseBody
	public Info saveShift(@RequestBody Shift shift) {

		Shift shiftRes = null;
		Info info = new Info();
		try {

			System.out.println("SpStation :" + shift);
			shiftRes = spProdService.saveShift(shift);

			if (shiftRes != null) {
				info.setError(false);
				info.setMessage("Shift Saved Successfully.");
			} else {
				info.setError(true);
				info.setMessage("Shift Not Saved .");
			}

		} catch (Exception e) {

			info.setError(true);
			info.setMessage("Shift Not Saved .");

			e.printStackTrace();
			System.out.println("Exception In SpProdController /saveShift" + e.getMessage());

		}
		return info;

	}
   //---------------------------Get Shift By Shift Id-----------------------
	@RequestMapping(value = { "/getShift" }, method = RequestMethod.POST)
	@ResponseBody
	public Shift getShift(@RequestParam int shiftId) {

		Shift shiftRes = null;
		try {
			shiftRes = spProdService.getShift(shiftId);

			if (shiftRes != null) {
				shiftRes.setError(false);
				shiftRes.setMessage("Shift Found Successfully");
			} else {
				shiftRes = new Shift();
				shiftRes.setError(true);
				shiftRes.setMessage("Shift Not Found");
			}
		} catch (Exception e) {

			shiftRes = new Shift();
			shiftRes.setError(true);
			shiftRes.setMessage("Shift Not Found");

		}
		return shiftRes;
	}

	// ---------------------------------------------------------------------------
	// ---------------------------Getting Shift List-------------------------
	@RequestMapping(value = { "/getShiftList" }, method = RequestMethod.GET)
	public @ResponseBody ShiftList getShiftList() {

		ShiftList shiftList = spProdService.getShiftList();
		return shiftList;
	}
	// ---------------------------------------------------------------------------
	// ---------------------------Getting Type List-------------------------
		@RequestMapping(value = { "/getTypeList" }, method = RequestMethod.POST)
		public @ResponseBody TypeList getTypeList(@RequestParam int typeId) {

			TypeList typeList = spProdService.getTypeList(typeId);
			return typeList;
		}
		// ---------------------------------------------------------------------------

	// ------------------------Delete Shift------------------------------------
	@RequestMapping(value = { "/deleteShift" }, method = RequestMethod.POST)
	@ResponseBody
	public ErrorMessage deleteShift(@RequestParam int shiftId) {

		ErrorMessage errorMessage = spProdService.deleteShift(shiftId);
		return errorMessage;
	}
	// ------------------------------END-----------------------------------
	// ----------------------------SAVE ProdStationAllocation-----------------------------
	@RequestMapping(value = { "/saveProdStationAllocation" }, method = RequestMethod.POST)
	@ResponseBody
	public Info saveStationAllocation(@RequestBody StationAllocation stationAllocation) {

		StationAllocation stationAllocationRes = null;
		Info info = new Info();
		try {

			System.out.println("stationAllocation :" + stationAllocation);
			stationAllocationRes = spProdService.saveProdStationAllocation(stationAllocation);

			if (stationAllocationRes != null) {
				info.setError(false);
				info.setMessage("StationAllocation Saved Successfully.");
			} else {
				info.setError(true);
				info.setMessage("StationAllocation Not Saved .");
			}

		} catch (Exception e) {

			info.setError(true);
			info.setMessage("StationAllocation Not Saved .");

			e.printStackTrace();
			System.out.println("Exception In SpProdController /saveStationAllocation" + e.getMessage());

		}
		return info;

	}
	// ------------------------Delete Station Allocation------------------------------------
		@RequestMapping(value = { "/deleteStationAllocation" }, method = RequestMethod.POST)
		@ResponseBody
		public ErrorMessage deleteStationAllocation(@RequestParam int allocationId) {

			ErrorMessage errorMessage = spProdService.deleteStationAllocation(allocationId);
			return errorMessage;
		}
	// ------------------------------END---------------------------------------------------
	// ---------------------------Getting StationAllocation List-------------------------
		@RequestMapping(value = { "/getStationAllocList" }, method = RequestMethod.GET)
		public @ResponseBody StationAllocList getStationAllocList() {

			StationAllocList stationAllocList = spProdService.getStationAllocList();
			return stationAllocList;
		}
	// ---------------------------------------------------------------------------	
		 //---------------------------Get StationAllocation By Id-----------------------
		@RequestMapping(value = { "/getStationAlloc" }, method = RequestMethod.POST)
		@ResponseBody
		public StationAllocation getStationAlloc(@RequestParam int allocationId) {

			StationAllocation stationAllocationRes = null;
			try {
				stationAllocationRes = spProdService.getStationAlloc(allocationId);

				if (stationAllocationRes != null) {
					stationAllocationRes.setError(false);
					stationAllocationRes.setMessage("StationAllocation Found Successfully");
				} else {
					stationAllocationRes = new StationAllocation();
					stationAllocationRes.setError(true);
					stationAllocationRes.setMessage("StationAllocation Not Found");
				}
			} catch (Exception e) {

				stationAllocationRes = new StationAllocation();
				stationAllocationRes.setError(true);
				stationAllocationRes.setMessage("StationAllocation Not Found");

			}
			return stationAllocationRes;
		}

		// ---------------------------------------------------------------------------	
}
