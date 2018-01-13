package com.ats.webapi.repository.gatesale;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ats.webapi.model.gatesale.GateSaleBillHeader;
@Repository
public interface GateSaleBillHeaderRepository extends JpaRepository<GateSaleBillHeader, Integer>{

	GateSaleBillHeader saveAndFlush(GateSaleBillHeader gateSaleBillHeader);

	    @Transactional
		@Modifying
		@Query("UPDATE GateSaleBillHeader SET is_approved =:isApproved,approved_date=:approvedDate,approved_user_id=:approvedUserId  WHERE bill_id=:billId")
		int approveGetSaleBill(@Param("billId")int billId,@Param("isApproved") int isApproved,@Param("approvedDate") String approvedDate, @Param("approvedUserId")int approvedUserId);
	   
	    @Transactional
		@Modifying
		@Query("UPDATE GateSaleBillHeader  SET amt_is_collected =:amtIsCollected,collected_date=:collectedDate,collected_user_id=:collectedUserId  WHERE bill_id=:billId")
		int updateCollectGetSaleAmt(@Param("billId")int billId, @Param("amtIsCollected")int amtIsCollected, @Param("collectedDate")String collectedDate,@Param("collectedUserId") int collectedUserId);

}
