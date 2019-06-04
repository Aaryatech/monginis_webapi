package com.ats.webapi.repository.dashboard;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.dashboard.FrPurchaseDash;

public interface FrPurchaseDashRepo extends JpaRepository<FrPurchaseDash, Integer> {

	@Query(value = "   SELECT \n"
			+ "coalesce((SELECT SUM( h.grand_total)  FROM t_bill_header h WHERE  h.del_status=0 AND  DATE_FORMAT(h.bill_date,'%Y-%m')=:preMonth AND h.fr_id=:frId),0) as prev_purchase_total,\n"
			+ "coalesce((SELECT SUM( h.grand_total)  FROM t_bill_header h WHERE h.del_status=0 AND  DATE_FORMAT(h.bill_date,'%Y-%m')=:curMonth  AND h.fr_id=:frId),0) as cur_purchase_total,\n"
			+ "\n"
			+ "coalesce((SELECT SUM( h.grn_gvn_amt)  FROM t_grn_gvn h WHERE h.del_status=0 AND DATE_FORMAT(h.grn_gvn_date,'%Y-%m')=:preMonth  AND h.fr_id=:frId AND h.is_grn=1 AND h.grn_gvn_status=6),0) as prev_grn_total,\n"
			+ "coalesce((SELECT SUM( h.grn_gvn_amt)  FROM t_grn_gvn h WHERE h.del_status=0 AND DATE_FORMAT(h.grn_gvn_date,'%Y-%m')=:curMonth  AND h.fr_id=:frId AND h.is_grn=1 AND h.grn_gvn_status=6),0) as cur_grn_total,\n"
			+ "\n"
			+ "coalesce((SELECT SUM( h.grn_gvn_amt)  FROM t_grn_gvn h WHERE h.del_status=0 AND DATE_FORMAT(h.grn_gvn_date,'%Y-%m')=:preMonth AND h.fr_id=:frId AND h.is_grn!=1 AND h.grn_gvn_status=6 ),0) as prev_gvn_total,\n"
			+ "coalesce((SELECT SUM( h.grn_gvn_amt)  FROM t_grn_gvn h WHERE h.del_status=0 AND DATE_FORMAT(h.grn_gvn_date,'%Y-%m')=:curMonth AND h.fr_id=:frId AND h.is_grn!=1 AND h.grn_gvn_status=6 ),0) as cur_gvn_total,\n"
			+ "\n" + "\n"
			+ "coalesce((SELECT SUM( h.grand_total)  FROM t_sell_bill_header h WHERE h.del_status=0 AND  DATE_FORMAT(h.bill_date,'%Y-%m')=:preMonth AND h.fr_id=:frId),0) as prev_actual_total,\n"
			+ "coalesce((SELECT SUM( h.grand_total)  FROM t_sell_bill_header h WHERE h.del_status=0 AND DATE_FORMAT(h.bill_date,'%Y-%m')=:curMonth AND h.fr_id=:frId),0) as cur_actual_total"
			+ "", nativeQuery = true)
	FrPurchaseDash getFrPurCount(@Param("preMonth") String preMonth, @Param("curMonth") String curMonth,
			@Param("frId") int frId);

}
