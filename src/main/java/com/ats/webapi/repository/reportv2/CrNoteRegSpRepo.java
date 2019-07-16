package com.ats.webapi.repository.reportv2;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.reportv2.CrNoteRegSp;

public interface CrNoteRegSpRepo extends JpaRepository<CrNoteRegSp, Integer> {

	@Query(value = "   SELECT\n" + "        t_credit_note_header.crn_id,\n" + "        t_credit_note_header.crn_date,\n"
			+ "         t_credit_note_header.crn_date AS bill_date,\n"
			+ "          t_credit_note_header.crn_no AS invoice_no,\n" + "        \n"
			+ "        t_credit_note_details.crnd_id ,\n" + "        \n" + "        m_franchisee.fr_name,\n"
			+ "        t_credit_note_header.crn_no as fr_code,\n" + "        m_franchisee.fr_gst_no,\n"
			+ "        SUM(t_credit_note_details.grn_gvn_qty)crn_qty,\n"
			+ "        SUM(t_credit_note_details.taxable_amt)crn_taxable,\n"
			+ "        t_credit_note_details.cgst_per,\n" + "        t_credit_note_details.sgst_per,\n"
			+ "        t_credit_note_details.igst_per,\n"
			+ "        SUM(t_credit_note_details.sgst_rs)  AS sgst_amt ,\n"
			+ "        SUM(t_credit_note_details.cgst_rs) as cgst_amt,\n"
			+ "        SUM(t_credit_note_details.igst_rs) as igst_amt,\n"
			+ "        SUM(t_credit_note_details.grn_gvn_amt) as crn_amt \n" + "    FROM\n"
			+ "        t_credit_note_header,\n" + "        t_credit_note_details,\n" + "      \n"
			+ "        m_franchisee,\n" + "        m_item \n" + "    WHERE\n"
			+ "        t_credit_note_header.crn_id=t_credit_note_details.crn_id \n"
			+ "        AND t_credit_note_header.crn_date BETWEEN :fromDate  AND  :toDate \n"
			+ "        AND t_credit_note_header.fr_id=m_franchisee.fr_id \n"
			+ "        AND t_credit_note_details.item_id=m_item.id \n" + "        AND m_franchisee.fr_id=:frId  \n"
			+ "        \n" + "    GROUP BY\n"
			+ "        (t_credit_note_details.cgst_per+t_credit_note_details.sgst_per),\n"
			+ "        t_credit_note_details.crn_id   \n" + "    order by\n"
			+ "        t_credit_note_header.crn_no ", nativeQuery = true)

	List<CrNoteRegSp> getCrNoteRegSpDoneByFrId(@Param("frId") int frId, @Param("fromDate") String fromDate,
			@Param("toDate") String toDate);

}
