package com.ats.webapi.service.tally;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.ErrorMessage;
import com.ats.webapi.model.tally.SpCakeList;
import com.ats.webapi.model.tally.SpecialCakeTally;
import com.ats.webapi.repository.tally.TallySpCakeRepository;
import com.ats.webapi.repository.tally.TallySpCakeUpdateRepository;

@Service
public class SpCakeServiceTallyImpl implements SpCakeService {

	@Autowired
	TallySpCakeRepository tallySpCakeRepository;
	
	@Autowired
	TallySpCakeUpdateRepository tallySpCakeUpdateRepository;
	
	@Override
	public SpCakeList getAllSpCake() {
		 List<SpecialCakeTally> spCakeList=tallySpCakeRepository.findByIsTallySync();
			
			SpCakeList allSpCakeList=new SpCakeList();
			ErrorMessage errorMessage=new ErrorMessage();
			
			if(spCakeList==null)
			{
			
				errorMessage.setError(true);
				errorMessage.setMessage("Item Not Found");
				
				allSpCakeList.setErrorMessage(errorMessage);
			}
			else
			{
				errorMessage.setError(false);
				errorMessage.setMessage("Item Found Successfully");
				
				allSpCakeList.setSpecialCakeList(spCakeList);
				allSpCakeList.setErrorMessage(errorMessage);			
			}
		return allSpCakeList;
	}
	
	//Anmol-----------17-6-2019
	@Override
	public SpCakeList getAllSpCakeAndAlbum() {
		 List<SpecialCakeTally> spCakeList=tallySpCakeRepository.findByIsTallySyncSpAndAlbum();
			
			SpCakeList allSpCakeList=new SpCakeList();
			ErrorMessage errorMessage=new ErrorMessage();
			
			if(spCakeList==null)
			{
			
				errorMessage.setError(true);
				errorMessage.setMessage("Item Not Found");
				
				allSpCakeList.setErrorMessage(errorMessage);
			}
			else
			{
				errorMessage.setError(false);
				errorMessage.setMessage("Item Found Successfully");
				
				allSpCakeList.setSpecialCakeList(spCakeList);
				allSpCakeList.setErrorMessage(errorMessage);			
			}
		return allSpCakeList;
	}

	@Override
	public ErrorMessage updateSpCakes(int spId, int isTallySync) {
		
		ErrorMessage errorMessage=new ErrorMessage();
		
		int i=tallySpCakeUpdateRepository.updateSpCakes(spId,isTallySync);
	
		if(i==1) {
		
		errorMessage.setError(false);
		errorMessage.setMessage("Special Cake Updated Successfully");
		}
		else
		{
			errorMessage.setError(false);
			errorMessage.setMessage("Special Cake Updation Failed");
			
		}
		return errorMessage;
		
		
	}

}
