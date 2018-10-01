package com.ats.webapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.purchaseorder.GetRmRateAndTax;

public interface GetRmRateAndTaxRepository extends JpaRepository<GetRmRateAndTax, Integer>{

	
/*	@Query(value=" select r.rm_id, r.rm_name, r.rm_uom_id, r.rm_specification,"
			+" (t.cgst_per + t.sgst_per)as gst_per, t.sgst_per, t.cgst_per, t.igst_per,"
			+ " coalesce((select m_rm_rate_verif.rate_tax_incl from m_rm_rate_verif where"
			+ " m_rm_rate_verif.rm_id=:rmId AND supp_id=:suppId),0)as rate_tax_incl, coalesce((select"
			+ "  m_rm_rate_verif.rate_tax_extra from m_rm_rate_verif where m_rm_rate_verif.rm_id=:rmId"
			+ " AND supp_id=:suppId),0)as rate_tax_extra from m_rm r, m_rm_tax t where r.rm_id=:rmId"
			+ " AND t.tax_id=r.tax_id",nativeQuery=true)
	GetRmRateAndTax getRmDetailById(@Param("rmId")int rmId, @Param("suppId")int suppId);*/
	@Query(value=" select r.rm_id, r.rm_name, r.rm_uom_id, r.rm_specification, (t.cgst_per + t.sgst_per)as gst_per,"
			+ " t.sgst_per, t.cgst_per, t.igst_per, v.rate_tax_extra, v.rate_tax_incl from m_rm r, m_rm_tax t,"
			+ " m_rm_rate_verif v where r.rm_id=:rmId AND v.rm_id=:rmId AND v.supp_id=:suppId AND t.tax_id=r.tax_id",nativeQuery=true)
	GetRmRateAndTax getRmDetailById(@Param("rmId")int rmId, @Param("suppId")int suppId);

	@Query(value=" select i.id as rm_id,i.item_name as rm_name, s.uom_id as rm_uom_id,i.item_name as rm_specification, (i.item_tax1 + i.item_tax2)as gst_per,i.item_tax1 as sgst_per, i.item_tax2 as cgst_per, i.item_tax3 as igst_per, v.rate_tax_extra, v.rate_tax_incl from m_item i,m_item_sup s, m_rm_rate_verif v where i.id=:rmId AND v.rm_id=:rmId AND v.supp_id=:suppId and i.id=s.item_id",nativeQuery=true)
	GetRmRateAndTax getRmDetailByItemId(@Param("rmId")int rmId,@Param("suppId") int suppId);

	
	
}
