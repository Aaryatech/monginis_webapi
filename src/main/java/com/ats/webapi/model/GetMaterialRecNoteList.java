package com.ats.webapi.model;

import java.io.Serializable;
import java.util.List;

public class GetMaterialRecNoteList implements Serializable{

	List<GetMaterialRecNote> materialRecNoteList;
	
	ErrorMessage errorMessage;

	public List<GetMaterialRecNote> getMaterialRecNoteList() {
		return materialRecNoteList;
	}

	public void setMaterialRecNoteList(List<GetMaterialRecNote> materialRecNoteList) {
		this.materialRecNoteList = materialRecNoteList;
	}

	public ErrorMessage getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(ErrorMessage errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public String toString() {
		return "GetMaterialRecNoteList [materialRecNoteList=" + materialRecNoteList + ", errorMessage=" + errorMessage
				+ "]";
	}

	
	
}
