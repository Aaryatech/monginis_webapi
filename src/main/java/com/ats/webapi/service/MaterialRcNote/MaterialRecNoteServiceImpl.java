package com.ats.webapi.service.MaterialRcNote;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.ErrorMessage;
import com.ats.webapi.model.GetMaterialRecNote;
import com.ats.webapi.model.GetMaterialRecNoteList;
import com.ats.webapi.model.MaterialRecNote;
import com.ats.webapi.model.MaterialRecNoteDetails;
import com.ats.webapi.repository.MaterialRNoteDetailRepository;
import com.ats.webapi.repository.MaterialRecNoteRepository;

@Service
public class MaterialRecNoteServiceImpl implements MaterialRecNoteService{

	@Autowired
	MaterialRecNoteRepository materialRecNoteRepository;
	
	@Autowired
	MaterialRNoteDetailRepository materialRNoteDetailRepository;

	

	
	
	@Override
	public MaterialRecNote postMaterialRecNote(MaterialRecNote materialRecNote) {

		ErrorMessage errorMessage = null;
		try {
			
		
		MaterialRecNote materialRecNotes=materialRecNoteRepository.save(materialRecNote);
		
        int mrnId=materialRecNotes.getMrnId();
        System.out.println(materialRecNotes.getGateEntryDate());
        
        for(MaterialRecNoteDetails materialRecNoteDetails:materialRecNotes.getMaterialRecNoteDetails())
        {
        	materialRecNoteDetails.setMrnId(mrnId);//setting header mrnId to Detail
        	MaterialRecNoteDetails materialRecNoteDetailRes=materialRNoteDetailRepository.save(materialRecNoteDetails);
        	        	
      
        
        }
          if(materialRecNotes!=null)
          {
        	  errorMessage=new ErrorMessage();
        	  errorMessage.setError(false);
        	  errorMessage.setMessage("MaterialRecNote Inserted Successfully.");
        	  
          }
         
           
		}
		catch(Exception e)
		{
			System.out.println("Exception In Saving Material Rec Note.");
			 errorMessage=new ErrorMessage();
      	     errorMessage.setError(true);
      	     errorMessage.setMessage("MaterialRecNote Insertion Failed.");
		}
		return materialRecNote;
		
		
	}

	@Override
	public GetMaterialRecNoteList getMaterialRecNote() {

		GetMaterialRecNoteList getMaterialRecNoteList=new GetMaterialRecNoteList();
		List<GetMaterialRecNote> materialRecNoteRes=new ArrayList<GetMaterialRecNote>();
		ErrorMessage errorMessage;
		try
		{
		List<MaterialRecNote> materialRecNoteData=materialRecNoteRepository.findMaterialRecNoteByDelStatus(0);
		
		for(MaterialRecNote materialRecNote:materialRecNoteData)
		{
			GetMaterialRecNote getMaterialRecNote=new GetMaterialRecNote();
			
			List<MaterialRecNoteDetails> materialRecNoteDetailList=materialRNoteDetailRepository.findMaterialRecNoteDetailsByMrnId(materialRecNote.getMrnId());
			
			getMaterialRecNote.setMaterialRecNote(materialRecNote);
			
			getMaterialRecNote.setMaterialRecNoteDetailList(materialRecNoteDetailList);
			
			materialRecNoteRes.add(getMaterialRecNote);
		}
		
		if(materialRecNoteRes!=null) {
			
			errorMessage=new ErrorMessage();
			errorMessage.setError(false);
			errorMessage.setMessage("Material Rec Note List Found Successfully");
			
			getMaterialRecNoteList.setErrorMessage(errorMessage);
			getMaterialRecNoteList.setMaterialRecNoteList(materialRecNoteRes);
			
		}
		}
		catch(Exception e)
		{
			System.out.println("Exception in getting all MaterialRecNote.");
			errorMessage=new ErrorMessage();
			errorMessage.setError(true);
			errorMessage.setMessage("Material Rec Note List Not Found");
			
			getMaterialRecNoteList.setErrorMessage(errorMessage);

		}
		return getMaterialRecNoteList;
	}

}
