package com.ats.webapi.repository.frpurchasereport;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.report.frpurchase.SalesReportBillwise;
//Sales Report No 1
public interface SaleReportBillwiseRepo extends JpaRepository<SalesReportBillwise, Integer> {
	//report 1
	@Query(value=" SELECT MONTHNAME(t_bill_header.bill_date)as month, t_bill_header.bill_no,"
			+ "t_bill_header.bill_date,t_bill_header.invoice_no,t_bill_header.fr_id,t_bill_header.fr_code," + 
			"t_bill_header.tax_applicable,t_bill_header.taxable_amt,t_bill_header.total_tax,"
			+ "t_bill_header.grand_total,t_bill_header.round_off," + 
			"t_bill_header.sgst_sum,t_bill_header.cgst_sum,t_bill_header.igst_sum,m_franchisee.fr_name,"
			+ "m_franchisee.fr_city,m_franchisee.fr_gst_no," + 
			"m_franchisee.is_same_state,m_franchisee.fr_name FROM m_franchisee,t_bill_header "
			+ "WHERE t_bill_header.fr_id=m_franchisee.fr_id AND t_bill_header.fr_id IN(:frIdList) "
			+ "AND t_bill_header.bill_date BETWEEN :fromDate AND :toDate AND t_bill_header.del_status=0 "
			+ "ORDER BY t_bill_header.bill_date",nativeQuery=true)
		
		List<SalesReportBillwise> getSaleReportBillwise(@Param("frIdList") List<String> frIdList,@Param("fromDate") String fromDate,@Param("toDate") String toDate);
//report 1 all Fr
	@Query(value=" SELECT MONTHNAME(t_bill_header.bill_date)as month, t_bill_header.bill_no,"
			+ "t_bill_header.bill_date,t_bill_header.invoice_no,t_bill_header.fr_id,t_bill_header.fr_code," + 
			"t_bill_header.tax_applicable,t_bill_header.taxable_amt,t_bill_header.total_tax,"
			+ "t_bill_header.grand_total,t_bill_header.round_off," + 
			"t_bill_header.sgst_sum,t_bill_header.cgst_sum,t_bill_header.igst_sum,m_franchisee.fr_name,"
			+ "m_franchisee.fr_city,m_franchisee.fr_gst_no," + 
			"m_franchisee.is_same_state,m_franchisee.fr_name FROM m_franchisee,t_bill_header "
			+ "WHERE t_bill_header.fr_id=m_franchisee.fr_id "
			+ "AND t_bill_header.bill_date BETWEEN :fromDate AND :toDate AND t_bill_header.del_status=0 "
			+ "ORDER BY t_bill_header.bill_date",nativeQuery=true)
		
		List<SalesReportBillwise> getSaleReportBillwiseAllFr(@Param("fromDate") String fromDate,@Param("toDate") String toDate);

	
	//report 2 group by fr
	@Query(value=" SELECT MONTHNAME(t_bill_header.bill_date)as month, t_bill_header.bill_no,t_bill_header.bill_date,t_bill_header.invoice_no,t_bill_header.fr_id,t_bill_header.fr_code," + 
			"t_bill_header.tax_applicable,SUM(t_bill_header.taxable_amt) as taxable_amt ,t_bill_header.total_tax,SUM(t_bill_header.grand_total) AS grand_total ,t_bill_header.round_off," + 
			"SUM(t_bill_header.sgst_sum)as sgst_sum ,SUM(t_bill_header.cgst_sum) as cgst_sum ,SUM(t_bill_header.igst_sum) as igst_sum,m_franchisee.fr_name,m_franchisee.fr_city,m_franchisee.fr_gst_no," + 
			"m_franchisee.is_same_state,m_franchisee.fr_name FROM m_franchisee,t_bill_header WHERE t_bill_header.fr_id=m_franchisee.fr_id AND t_bill_header.fr_id IN(:frIdList) "
			+ "AND t_bill_header.bill_date BETWEEN :fromDate AND :toDate AND t_bill_header.del_status=0 GROUP BY t_bill_header.fr_id ORDER BY m_franchisee.fr_name",nativeQuery=true)

		List<SalesReportBillwise> getSaleReportBillwiseByFr(@Param("frIdList") List<String> frIdList,@Param("fromDate") String fromDate,@Param("toDate") String toDate);
	
	//report 2 group by fr all Fr
	@Query(value=" SELECT MONTHNAME(t_bill_header.bill_date)as month, t_bill_header.bill_no,t_bill_header.bill_date,t_bill_header.invoice_no,t_bill_header.fr_id,t_bill_header.fr_code," + 
			"t_bill_header.tax_applicable,SUM(t_bill_header.taxable_amt) as taxable_amt ,t_bill_header.total_tax,SUM(t_bill_header.grand_total) AS grand_total ,t_bill_header.round_off," + 
			"SUM(t_bill_header.sgst_sum)as sgst_sum ,SUM(t_bill_header.cgst_sum) as cgst_sum ,SUM(t_bill_header.igst_sum) as igst_sum,m_franchisee.fr_name,m_franchisee.fr_city,m_franchisee.fr_gst_no," + 
			"m_franchisee.is_same_state,m_franchisee.fr_name FROM m_franchisee,t_bill_header WHERE t_bill_header.fr_id=m_franchisee.fr_id "
			+ "AND t_bill_header.bill_date BETWEEN :fromDate AND :toDate AND t_bill_header.del_status=0 GROUP BY t_bill_header.fr_id",nativeQuery=true)

		List<SalesReportBillwise> getSaleReportBillwiseByFrAllFr(@Param("fromDate") String fromDate,@Param("toDate") String toDate);

	// Report 3 sales report datewise group by date
	@Query(value=" SELECT MONTHNAME(t_bill_header.bill_date)as month, t_bill_header.bill_no,t_bill_header.bill_date,t_bill_header.invoice_no,t_bill_header.fr_id,t_bill_header.fr_code," + 
			"t_bill_header.tax_applicable,SUM(t_bill_header.taxable_amt) as taxable_amt ,t_bill_header.total_tax,SUM(t_bill_header.grand_total) AS grand_total ,t_bill_header.round_off," + 
			"SUM(t_bill_header.sgst_sum)as sgst_sum ,SUM(t_bill_header.cgst_sum) as cgst_sum ,SUM(t_bill_header.igst_sum) as igst_sum,m_franchisee.fr_name,m_franchisee.fr_city,m_franchisee.fr_gst_no," + 
			"m_franchisee.is_same_state,m_franchisee.fr_name FROM m_franchisee,t_bill_header WHERE t_bill_header.fr_id=m_franchisee.fr_id AND t_bill_header.fr_id IN(:frIdList) "
			+ " AND t_bill_header.bill_date BETWEEN :fromDate AND :toDate AND t_bill_header.del_status=0 GROUP BY t_bill_header.bill_date",nativeQuery=true)

		List<SalesReportBillwise> getSaleReportBillwiseByDate(@Param("frIdList") List<String> frIdList,@Param("fromDate") String fromDate,@Param("toDate") String toDate);

	// Report 3 sales report datewise group by date all Fr
		@Query(value=" SELECT MONTHNAME(t_bill_header.bill_date)as month, t_bill_header.bill_no,t_bill_header.bill_date,t_bill_header.invoice_no,t_bill_header.fr_id,t_bill_header.fr_code," + 
				"t_bill_header.tax_applicable,SUM(t_bill_header.taxable_amt) as taxable_amt ,t_bill_header.total_tax,SUM(t_bill_header.grand_total) AS grand_total ,t_bill_header.round_off," + 
				"SUM(t_bill_header.sgst_sum)as sgst_sum ,SUM(t_bill_header.cgst_sum) as cgst_sum ,SUM(t_bill_header.igst_sum) as igst_sum,m_franchisee.fr_name,m_franchisee.fr_city,m_franchisee.fr_gst_no," + 
				"m_franchisee.is_same_state,m_franchisee.fr_name FROM m_franchisee,t_bill_header WHERE t_bill_header.fr_id=m_franchisee.fr_id "
				+ "AND t_bill_header.bill_date BETWEEN :fromDate AND :toDate AND t_bill_header.del_status=0 GROUP BY t_bill_header.bill_date",nativeQuery=true)

			List<SalesReportBillwise> getSaleReportBillwiseByDateAllFr(@Param("fromDate") String fromDate,@Param("toDate") String toDate);

	
/*Sales Report Monthwise report no 4

SELECT MONTHNAME(t_bill_header.bill_date)as month, t_bill_header.bill_no,t_bill_header.bill_date,t_bill_header.invoice_no,t_bill_header.fr_id,t_bill_header.fr_code, 
			t_bill_header.tax_applicable,SUM(t_bill_header.taxable_amt) as taxable_amt ,t_bill_header.total_tax,SUM(t_bill_header.grand_total) AS grand_total ,t_bill_header.round_off,
			SUM(t_bill_header.sgst_sum)as sgst_sum ,SUM(t_bill_header.cgst_sum) as cgst_sum ,SUM(t_bill_header.igst_sum) as igst_sum,m_franchisee.fr_name,m_franchisee.fr_city,m_franchisee.fr_gst_no,
			m_franchisee.is_same_state,m_franchisee.fr_name FROM m_franchisee,t_bill_header WHERE t_bill_header.fr_id=m_franchisee.fr_id AND t_bill_header.fr_id IN(15,20,24) 
			AND t_bill_header.bill_date BETWEEN '2018-01-01' AND '2018-01-12' AND t_bill_header.del_status=0 GROUP BY month
 */
	
	// report 4 Sales Report Monthwise group by month
	@Query(value=" SELECT MONTHNAME(t_bill_header.bill_date)as month, t_bill_header.bill_no,t_bill_header.bill_date,t_bill_header.invoice_no,t_bill_header.fr_id,t_bill_header.fr_code," + 
			"t_bill_header.tax_applicable,SUM(t_bill_header.taxable_amt) as taxable_amt ,sum(t_bill_header.total_tax) as total_tax,SUM(t_bill_header.grand_total) AS grand_total ,t_bill_header.round_off," + 
			"SUM(t_bill_header.sgst_sum)as sgst_sum ,SUM(t_bill_header.cgst_sum) as cgst_sum ,SUM(t_bill_header.igst_sum) as igst_sum,m_franchisee.fr_name,m_franchisee.fr_city,m_franchisee.fr_gst_no," + 
			"m_franchisee.is_same_state,m_franchisee.fr_name FROM m_franchisee,t_bill_header WHERE t_bill_header.fr_id=m_franchisee.fr_id AND t_bill_header.fr_id IN(:frIdList) "
			+ "AND t_bill_header.bill_date BETWEEN :fromDate AND :toDate AND t_bill_header.del_status=0 GROUP BY month order by t_bill_header.bill_date",nativeQuery=true)

		List<SalesReportBillwise> getSaleReportBillwiseByMonth(@Param("frIdList") List<String> frIdList,@Param("fromDate") String fromDate,@Param("toDate") String toDate);

	// report 4 Sales Report Monthwise group by month all Fr
	@Query(value=" SELECT MONTHNAME(t_bill_header.bill_date)as month, t_bill_header.bill_no,t_bill_header.bill_date,t_bill_header.invoice_no,t_bill_header.fr_id,t_bill_header.fr_code," + 
			"t_bill_header.tax_applicable,SUM(t_bill_header.taxable_amt) as taxable_amt ,sum(t_bill_header.total_tax) as total_tax,SUM(t_bill_header.grand_total) AS grand_total ,t_bill_header.round_off," + 
			"SUM(t_bill_header.sgst_sum)as sgst_sum ,SUM(t_bill_header.cgst_sum) as cgst_sum ,SUM(t_bill_header.igst_sum) as igst_sum,m_franchisee.fr_name,m_franchisee.fr_city,m_franchisee.fr_gst_no," + 
			"m_franchisee.is_same_state,m_franchisee.fr_name FROM m_franchisee,t_bill_header WHERE t_bill_header.fr_id=m_franchisee.fr_id "
			+ "AND t_bill_header.bill_date BETWEEN :fromDate AND :toDate AND t_bill_header.del_status=0 GROUP BY month order by t_bill_header.bill_date",nativeQuery=true)

		List<SalesReportBillwise> getSaleReportBillwiseByMonthAllFr(@Param("fromDate") String fromDate,@Param("toDate") String toDate);

	@Query(value="SELECT\n" + 
			"        MONTHNAME(t_bill_header.bill_date)as month,\n" + 
			"        t_bill_header.bill_no,\n" + 
			"        t_bill_header.bill_date,\n" + 
			"        t_bill_header.invoice_no,\n" + 
			"        t_bill_header.fr_id,\n" + 
			"        t_bill_header.fr_code,\n" + 
			"        t_bill_header.tax_applicable,\n" + 
			"        t_bill_header.taxable_amt,\n" + 
			"        t_bill_header.total_tax,\n" + 
			"        t_bill_header.grand_total,\n" + 
			"        t_bill_header.round_off,\n" + 
			"        t_bill_header.sgst_sum,\n" + 
			"        t_bill_header.cgst_sum,\n" + 
			"        t_bill_header.igst_sum,\n" + 
			"        m_franchisee.fr_name,\n" + 
			"        m_franchisee.fr_city,\n" + 
			"        m_franchisee.fr_gst_no,\n" + 
			"        m_franchisee.is_same_state,\n" + 
			"        m_franchisee.fr_name \n" + 
			"    FROM\n" + 
			"        m_franchisee,\n" + 
			"        t_bill_header \n" + 
			"    WHERE\n" + 
			"        t_bill_header.fr_id=m_franchisee.fr_id \n" + 
			"        AND t_bill_header.fr_id IN(:frIdList) \n" + 
			"        AND t_bill_header.bill_date BETWEEN :fromDate AND :toDate \n" + 
			"        AND t_bill_header.del_status=0 \n" + 
			"        AND t_bill_header.round_off>0\n" + 
			"    ORDER BY\n" + 
			"        t_bill_header.bill_date",nativeQuery=true)
	List<SalesReportBillwise> getTcsReport(@Param("frIdList") List<String> frIdList,@Param("fromDate") String fromDate,@Param("toDate") String toDate);

	@Query(value="SELECT\n" + 
			"        MONTHNAME(t_bill_header.bill_date)as month,\n" + 
			"        t_bill_header.bill_no,\n" + 
			"        t_bill_header.bill_date,\n" + 
			"        t_bill_header.invoice_no,\n" + 
			"        t_bill_header.fr_id,\n" + 
			"        t_bill_header.fr_code,\n" + 
			"        t_bill_header.tax_applicable,\n" + 
			"        t_bill_header.taxable_amt,\n" + 
			"        t_bill_header.total_tax,\n" + 
			"        t_bill_header.grand_total,\n" + 
			"        t_bill_header.round_off,\n" + 
			"        t_bill_header.sgst_sum,\n" + 
			"        t_bill_header.cgst_sum,\n" + 
			"        t_bill_header.igst_sum,\n" + 
			"        m_franchisee.fr_name,\n" + 
			"        m_franchisee.fr_city,\n" + 
			"        m_franchisee.fr_gst_no,\n" + 
			"        m_franchisee.is_same_state,\n" + 
			"        m_franchisee.fr_name \n" + 
			"    FROM\n" + 
			"        m_franchisee,\n" + 
			"        t_bill_header \n" + 
			"    WHERE\n" + 
			"        t_bill_header.fr_id=m_franchisee.fr_id \n" + 
			"        AND t_bill_header.bill_date BETWEEN :fromDate AND :toDate \n" + 
			"        AND t_bill_header.del_status=0 \n" + 
			"        AND t_bill_header.round_off>0\n" + 
			"    ORDER BY\n" + 
			"        t_bill_header.bill_date",nativeQuery=true)
	List<SalesReportBillwise> getTcsReportByAllFr(@Param("fromDate") String fromDate,@Param("toDate") String toDate);

}
