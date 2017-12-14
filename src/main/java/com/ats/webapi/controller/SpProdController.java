package com.ats.webapi.controller;

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
import com.ats.webapi.model.spprod.GetSpStation;
import com.ats.webapi.model.spprod.Instrument;
import com.ats.webapi.model.spprod.InstrumentList;
import com.ats.webapi.model.spprod.MDept;
import com.ats.webapi.model.spprod.MDeptList;
import com.ats.webapi.model.spprod.SpStation;
import com.ats.webapi.model.spprod.SpStationList;
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
	@RequestMapping(value = { "/getEmployeeList" }, method = RequestMethod.GET)
	public @ResponseBody EmployeeList getEmployeeList() {

		EmployeeList employeeList = spProdService.getEmployeeList();

		return employeeList;

	}

	// ---------------------------Getting Instrument List----------------------
	@RequestMapping(value = { "/getInstrumentList" }, method = RequestMethod.GET)
	public @ResponseBody InstrumentList getInstrumentList() {

		InstrumentList instrumentList = spProdService.getInstrumentList();

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

		MDept mDept  = null;
		try {
			mDept = spProdService.getDepartment(deptId);

			if (mDept != null)
			{
				mDept.setError(false);
				mDept.setMessage("Dept Found Successfully");			
			}
			else
			{
			    mDept = new MDept();
			    mDept.setError(true);
				mDept.setMessage("Dept Not Found");		
			}
		}catch (Exception e) {
			
			    mDept = new MDept();
			    mDept.setError(true);
				mDept.setMessage("Dept Not Found");	

		}
		return mDept;
	}
	// ---------------------------------------------------------------------------

}
