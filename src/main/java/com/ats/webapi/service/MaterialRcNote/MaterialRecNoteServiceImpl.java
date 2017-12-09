package com.ats.webapi.service.MaterialRcNote;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.ErrorMessage; 
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
        MaterialRecNote materialRec=new MaterialRecNote();
        try {
            
        if(materialRec.getStatus()==1)
        {
        	SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yyyy");
        	Date utilCurrentDate = sf.parse(sf.format(new Date()));
			 SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm:ss");

			    Date now = new Date();
			    
			    materialRec.setMrnStoreDate(now);
			    
        }
        if(materialRec.getStatus()==1)
            materialRec=materialRecNoteRepository.save(materialRecNote);
        
        int mrnId=materialRec.getMrnId();
        System.out.println(materialRec.getGateEntryDate());
        List<MaterialRecNoteDetails> materialRecNoteDetailsList=new ArrayList<MaterialRecNoteDetails>();
        for(int i=0;i<materialRecNote.getMaterialRecNoteDetails().size();i++)
        {
            MaterialRecNoteDetails materialRecNoteDetail=materialRecNote.getMaterialRecNoteDetails().get(i);
            materialRecNoteDetail.setMrnId(mrnId);
            MaterialRecNoteDetails materialRecNoteDetailRes=materialRNoteDetailRepository.save(materialRecNoteDetail);
             
            materialRecNoteDetailsList.add(materialRecNoteDetailRes);
        }
        materialRec.setMaterialRecNoteDetails(materialRecNoteDetailsList);
        
          if(materialRec!=null)
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
        return materialRec;
        
        
    }
	@Override
	public GetMaterialRecNoteList getMaterialRecNote(List<String> status) {

		GetMaterialRecNoteList getMaterialRecNoteList=new GetMaterialRecNoteList();
		 
		ErrorMessage errorMessage;
		try
		{
			List<MaterialRecNote> materialRecNoteList=materialRecNoteRepository.getMaterialByStatus( status);
			 
		
		if(materialRecNoteList!=null) {
			
			errorMessage=new ErrorMessage();
			errorMessage.setError(false);
			errorMessage.setMessage("Material Rec Note List Found Successfully");
			}
		else {
					
					errorMessage=new ErrorMessage();
					errorMessage.setError(true);
					errorMessage.setMessage("Material Rec Note List Found Failed");
		}
			getMaterialRecNoteList.setErrorMessage(errorMessage);
			getMaterialRecNoteList.setMaterialRecNoteList(materialRecNoteList);
			 
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
	@Override
	public MaterialRecNote getMaterialRecNotesHeaderDetails(int mrnId) {
		

		MaterialRecNote materialRecNote=materialRecNoteRepository.findByMrnId(mrnId);
		
		//int mrnId=materialRecNote.getMrnId();
		
		List<MaterialRecNoteDetails> materialRecNoteDetailsList=materialRNoteDetailRepository.findByMrnId(mrnId);
		materialRecNote.setMaterialRecNoteDetails(materialRecNoteDetailsList);
		return materialRecNote;
	}

}
