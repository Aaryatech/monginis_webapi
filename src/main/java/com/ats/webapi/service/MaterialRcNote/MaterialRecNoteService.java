package com.ats.webapi.service.MaterialRcNote;

import org.springframework.stereotype.Service;

import com.ats.webapi.model.ErrorMessage;
import com.ats.webapi.model.GetMaterialRecNoteList;
import com.ats.webapi.model.MaterialRecNote;

@Service
public interface MaterialRecNoteService {

	ErrorMessage postMaterialRecNote(MaterialRecNote materialRecNote);

	GetMaterialRecNoteList getMaterialRecNote();


}