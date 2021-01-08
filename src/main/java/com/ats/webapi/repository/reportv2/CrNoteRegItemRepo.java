package com.ats.webapi.repository.reportv2;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.reportv2.CrNoteRegItem;

public interface CrNoteRegItemRepo extends JpaRepository<CrNoteRegItem, Integer> {

	@Query(value = " SELECT t_credit_note_header.crn_id,t_credit_note_header.crn_date,t_credit_note_header.crn_no as invoice_no,"
			+ " t_credit_note_details.crnd_id ,"
			+ " t_credit_note_header.crn_date as bill_date,m_franchisee.fr_name,t_credit_note_header.crn_no as fr_code,m_franchisee.fr_gst_no,"
			+ "	SUM(t_credit_note_details.grn_gvn_qty)crn_qty,SUM(t_credit_note_details.taxable_amt)crn_taxable,"
			+ " t_credit_note_details.cgst_per,t_credit_note_details.sgst_per,t_credit_note_details.igst_per,SUM(t_credit_note_details.sgst_rs) "
			+ " AS sgst_amt ,SUM(t_credit_note_details.cgst_rs) as cgst_amt,"
			+ " SUM(t_credit_note_details.igst_rs) as igst_amt,"
			+ "	SUM(t_credit_note_details.grn_gvn_amt) as crn_amt, 0 AS ttl_taxable, 0 AS ttl_tax_amt, 0 AS ttl_crn_amt, 0 as is_same_state, 0 as is_grn"
			+ "	FROM t_credit_note_header,t_credit_note_details ,m_franchisee,m_item"
			+ "	WHERE t_credit_note_header.crn_id=t_credit_note_details.crn_id AND t_credit_note_header.crn_date BETWEEN :fromDate AND :toDate "
			+ "	AND t_credit_note_header.fr_id=m_franchisee.fr_id AND t_credit_note_details.item_id=m_item.id"
			+ " AND m_franchisee.fr_id=:frId  "
			+ "	GROUP BY (t_credit_note_details.cgst_per+t_credit_note_details.sgst_per),t_credit_note_details.crn_id  order by t_credit_note_header.crn_no", nativeQuery = true)

	List<CrNoteRegItem> getCrNoteRegItemDoneByFrId(@Param("frId") int frId, @Param("fromDate") String fromDate,
			@Param("toDate") String toDate);

	@Query(value = "SELECT\n" + 
			"    t1.*,\n" + 
			"    COALESCE(t2.crn_taxable, 0) AS ttl_taxable,\n" + 
			"    COALESCE((t2.sgst_amt + t2.cgst_amt),\n" + 
			"    0) AS ttl_tax_amt,\n" + 
			"    COALESCE(t2.crn_amt, 0) AS ttl_crn_amt\n" + 
			"FROM\n" + 
			"    (\n" + 
			"    SELECT\n" + 
			"        t_credit_note_details.bill_no,\n" + 
			"        t_credit_note_header.crn_id,\n" + 
			"        t_credit_note_header.is_grn,\n" + 
			"        t_credit_note_header.crn_date,\n" + 
			"        t_bill_header.invoice_no,\n" + 
			"        t_credit_note_details.crnd_id,\n" + 
			"        t_bill_header.bill_date,\n" + 
			"        m_franchisee.fr_name, m_franchisee.is_same_state,\n" + 
			"        t_credit_note_header.crn_no AS fr_code,\n" + 
			"        m_franchisee.fr_gst_no,\n" + 
			"        t_credit_note_details.cgst_per,\n" + 
			"        t_credit_note_details.sgst_per,\n" + 
			"        t_credit_note_details.igst_per,\n" + 
			"        (\n" + 
			"            t_credit_note_details.cgst_per + t_credit_note_details.sgst_per\n" + 
			"        ) AS per,\n" + 
			"        SUM(\n" + 
			"            t_credit_note_details.grn_gvn_qty\n" + 
			"        ) crn_qty,\n" + 
			"        SUM(\n" + 
			"            t_credit_note_details.taxable_amt\n" + 
			"        ) crn_taxable,\n" + 
			"        SUM(t_credit_note_details.sgst_rs) AS sgst_amt,\n" + 
			"        SUM(t_credit_note_details.cgst_rs) AS cgst_amt,\n" + 
			"        SUM(t_credit_note_details.igst_rs) AS igst_amt,\n" + 
			"        SUM(\n" + 
			"            t_credit_note_details.grn_gvn_amt\n" + 
			"        ) AS crn_amt\n" + 
			"    FROM\n" + 
			"        t_credit_note_header,\n" + 
			"        t_credit_note_details,\n" + 
			"        t_bill_header,\n" + 
			"        m_franchisee\n" + 
			"    WHERE\n" + 
			"        t_credit_note_header.crn_id = t_credit_note_details.crn_id AND t_credit_note_header.crn_date BETWEEN :fromDate AND :toDate AND t_credit_note_header.fr_id = m_franchisee.fr_id AND t_bill_header.bill_no = t_credit_note_details.bill_no AND t_credit_note_details.del_status = 0 AND t_bill_header.del_status = 0 AND t_credit_note_header.is_grn = :CreditNoteType\n" + 
			"    GROUP BY\n" + 
			"        t_credit_note_details.crn_id,\n" + 
			"        per\n" + 
			"    ORDER BY\n" + 
			"        t_credit_note_header.crn_id,\n" + 
			"        per\n" + 
			") t1\n" + 
			"LEFT JOIN(\n" + 
			"    SELECT\n" + 
			"        t_credit_note_header.crn_id,\n" + 
			"        t_credit_note_details.bill_no,\n" + 
			"        SUM(\n" + 
			"            t_credit_note_details.taxable_amt\n" + 
			"        ) crn_taxable,\n" + 
			"        SUM(t_credit_note_details.sgst_rs) AS sgst_amt,\n" + 
			"        SUM(t_credit_note_details.cgst_rs) AS cgst_amt,\n" + 
			"        SUM(\n" + 
			"            t_credit_note_details.grn_gvn_amt\n" + 
			"        ) AS crn_amt\n" + 
			"    FROM\n" + 
			"        t_credit_note_header,\n" + 
			"        t_credit_note_details,\n" + 
			"        t_bill_header,\n" + 
			"        m_franchisee\n" + 
			"    WHERE\n" + 
			"        t_credit_note_header.crn_id = t_credit_note_details.crn_id AND t_credit_note_header.crn_date BETWEEN :fromDate AND :toDate AND t_credit_note_header.fr_id = m_franchisee.fr_id AND t_bill_header.bill_no = t_credit_note_details.bill_no AND t_credit_note_details.del_status = 0 AND t_bill_header.del_status = 0 AND t_credit_note_header.is_grn = :CreditNoteType\n" + 
			"    GROUP BY\n" + 
			"         t_credit_note_details.crn_id\n" + 
			") t2\n" + 
			"ON\n" + 
			"    t1.crn_id = t2.crn_id", nativeQuery = true)

	List<CrNoteRegItem> getCrNoteRegItemDone(@Param("fromDate") String fromDate, @Param("toDate")
	String toDate,@Param("CreditNoteType") String CreditNoteType);

		@Query(value="SELECT\n" + 
				"    t1.*,\n" + 
				"    COALESCE(t2.crn_taxable, 0) AS ttl_taxable,\n" + 
				"    COALESCE((t2.sgst_amt + t2.cgst_amt),\n" + 
				"    0) AS ttl_tax_amt,\n" + 
				"    COALESCE(t2.crn_amt, 0) AS ttl_crn_amt\n" + 
				"FROM\n" + 
				"    (\n" + 
				"    SELECT\n" + 
				"        t_credit_note_details.bill_no,\n" + 
				"        t_credit_note_header.is_grn,\n" + 
				"        t_credit_note_header.crn_id,\n" + 
				"        t_credit_note_header.crn_date,\n" + 
				"        t_bill_header.invoice_no,\n" + 
				"        t_credit_note_details.crnd_id,\n" + 
				"        t_bill_header.bill_date,\n" + 
				"        m_franchisee.fr_name,\n" + 
				"        m_franchisee.is_same_state,\n" + 
				"        t_credit_note_header.crn_no AS fr_code,\n" + 
				"        m_franchisee.fr_gst_no,\n" + 
				"        t_credit_note_details.cgst_per,\n" + 
				"        t_credit_note_details.sgst_per,\n" + 
				"        t_credit_note_details.igst_per,\n" + 
				"        (\n" + 
				"            t_credit_note_details.cgst_per + t_credit_note_details.sgst_per\n" + 
				"        ) AS per,\n" + 
				"        SUM(\n" + 
				"            t_credit_note_details.grn_gvn_qty\n" + 
				"        ) crn_qty,\n" + 
				"        SUM(\n" + 
				"            t_credit_note_details.taxable_amt\n" + 
				"        ) crn_taxable,\n" + 
				"        SUM(t_credit_note_details.sgst_rs) AS sgst_amt,\n" + 
				"        SUM(t_credit_note_details.cgst_rs) AS cgst_amt,\n" + 
				"        SUM(t_credit_note_details.igst_rs) AS igst_amt,\n" + 
				"        SUM(\n" + 
				"            t_credit_note_details.grn_gvn_amt\n" + 
				"        ) AS crn_amt\n" + 
				"    FROM\n" + 
				"        t_credit_note_header,\n" + 
				"        t_credit_note_details,\n" + 
				"        t_bill_header,\n" + 
				"        m_franchisee\n" + 
				"    WHERE\n" + 
				"        t_credit_note_header.crn_id = t_credit_note_details.crn_id AND t_credit_note_header.crn_date BETWEEN :fromDate AND :toDate AND t_credit_note_header.fr_id = m_franchisee.fr_id AND t_bill_header.bill_no = t_credit_note_details.bill_no AND t_credit_note_details.del_status = 0 AND t_bill_header.del_status = 0 \n" + 
				"    GROUP BY\n" + 
				"        t_credit_note_details.crn_id,\n" + 
				"        per\n" + 
				"    ORDER BY\n" + 
				"        t_credit_note_header.crn_id,\n" + 
				"        per\n" + 
				") t1\n" + 
				"LEFT JOIN(\n" + 
				"    SELECT\n" + 
				"        t_credit_note_header.crn_id,\n" + 
				"        t_credit_note_details.bill_no,\n" + 
				"        SUM(\n" + 
				"            t_credit_note_details.taxable_amt\n" + 
				"        ) crn_taxable,\n" + 
				"        SUM(t_credit_note_details.sgst_rs) AS sgst_amt,\n" + 
				"        SUM(t_credit_note_details.cgst_rs) AS cgst_amt,\n" + 
				"        SUM(\n" + 
				"            t_credit_note_details.grn_gvn_amt\n" + 
				"        ) AS crn_amt\n" + 
				"    FROM\n" + 
				"        t_credit_note_header,\n" + 
				"        t_credit_note_details,\n" + 
				"        t_bill_header,\n" + 
				"        m_franchisee\n" + 
				"    WHERE\n" + 
				"        t_credit_note_header.crn_id = t_credit_note_details.crn_id AND t_credit_note_header.crn_date BETWEEN :fromDate AND :toDate AND t_credit_note_header.fr_id = m_franchisee.fr_id AND t_bill_header.bill_no = t_credit_note_details.bill_no AND t_credit_note_details.del_status = 0 AND t_bill_header.del_status = 0\n" + 
				"    GROUP BY\n" + 
				"         t_credit_note_details.crn_id\n" + 
				") t2\n" + 
				"ON\n" + 
				"    t1.crn_id = t2.crn_id",nativeQuery=true)
		List<CrNoteRegItem> getAllCrNoteRegItemDone(@Param("fromDate") String fromDate, @Param("toDate") String toDate);
}
