package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.purchaseorder.PoDetailsByChkSupp;

public interface PoDetailsByChkSuppRepository extends JpaRepository<PoDetailsByChkSupp, Integer>{

	@Query(value="select\n" + 
			"       :suppId as supp_id,\n" + 
			"        r.rm_id,\n" + 
			"        r.rm_name,\n" + 
			"        r.rm_uom_id,\n" + 
			"        r.rm_specification as specification,\n" + 
			"        (t.cgst_per + t.sgst_per) as gst_per,\n" + 
			"        0 as disc_per,\n" + 
			"        1 as po_qty,\n" + 
			"        t.sgst_per,\n" + 
			"        t.cgst_per,\n" + 
			"        t.igst_per,\n" + 
			"        verif.rate_tax_extra,\n" + 
			"        verif.rate_tax_incl,\n" + 
			"m_supplier.supp_email5 as sch_days\n" + 
			"       \n" + 
			"    from      m_rm r,  m_rm_tax t ,m_rm_rate_verif verif,m_supplier where   t.tax_id=r.tax_id And verif.supp_id= m_supplier.supp_id And m_supplier.supp_id= :suppId AND r.rm_id = verif.rm_id and verif.grp_id=:grpId",nativeQuery=true)
	List<PoDetailsByChkSupp> getPoDetailsBySuppId(@Param("suppId")int suppId,@Param("grpId")int grpId);
	@Query(value="select :suppId as supp_id,i.id as rm_id,i.item_name as rm_name, s.uom_id as rm_uom_id,i.item_name as rm_specification, (i.item_tax1 + i.item_tax2)as gst_per,i.item_tax1 as sgst_per, i.item_tax2 as cgst_per, i.item_tax3 as igst_per, v.rate_tax_extra, v.rate_tax_incl,m_supplier.supp_email5 as sch_days from m_item i,m_item_sup s, m_rm_rate_verif v,m_supplier where i.id=:rmId AND v.rm_id=:rmId AND v.supp_id=:suppId and i.id=s.item_id   And v.supp_id= m_supplier.supp_id and v.grp_id=:grpId",nativeQuery=true)
	List<PoDetailsByChkSupp> getPoItemDetailsBySuppId(@Param("suppId")int suppId,@Param("grpId")int grpId);

}
