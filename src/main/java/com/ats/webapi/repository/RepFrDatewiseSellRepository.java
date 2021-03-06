package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.report.GetRepFrDatewiseSell;
 

public interface RepFrDatewiseSellRepository extends JpaRepository<GetRepFrDatewiseSell, Integer>{
	
/*@Query(value="SELECT DAYNAME(t_sell_bill_header.bill_date) as day,t_sell_bill_header.bill_date ,t_sell_bill_header.sell_bill_no ,t_sell_bill_header.fr_id,"
+" sum(CASE WHEN t_sell_bill_header.payment_mode = 1 THEN t_sell_bill_header.payable_amt ELSE 0 END) as cash,"
		+" sum(CASE WHEN t_sell_bill_header.payment_mode = 2 THEN t_sell_bill_header.payable_amt ELSE 0 END) as card ,"
+ " sum(CASE WHEN t_sell_bill_header.payment_mode = 3 THEN t_sell_bill_header.payable_amt ELSE 0 END) as other,"
		+" m_franchisee.fr_name FROM t_sell_bill_header, m_franchisee WHERE t_sell_bill_header.bill_date BETWEEN :fromDate "
+" AND :toDate AND t_sell_bill_header.fr_id IN(:frId) AND m_franchisee.fr_id=t_sell_bill_header.fr_id GROUP BY"
		+" t_sell_bill_header.bill_date,t_sell_bill_header.fr_id ",nativeQuery=true)*/
	
@Query(value="SELECT day,bill_date,sell_bill_no,fr_id,cash,card,other,fr_name\r\n" + 
		"       from\r\n" + 
		"        (SELECT DAYNAME(t_sell_bill_header.bill_date) as day,\r\n" + 
		"        t_sell_bill_header.bill_date ,\r\n" + 
		"        t_sell_bill_header.sell_bill_no ,\r\n" + 
		"        t_sell_bill_header.fr_id,\r\n" + 
		"        sum(CASE \r\n" + 
		"            WHEN t_sell_bill_header.payment_mode = 1 THEN t_sell_bill_header.payable_amt \r\n" + 
		"            ELSE 0 \r\n" + 
		"        END) as cash,\r\n" + 
		"        sum(CASE \r\n" + 
		"            WHEN t_sell_bill_header.payment_mode = 2 THEN t_sell_bill_header.payable_amt \r\n" + 
		"            ELSE 0 \r\n" + 
		"        END) as card ,\r\n" + 
		"        sum(CASE \r\n" + 
		"            WHEN t_sell_bill_header.payment_mode = 3 THEN t_sell_bill_header.payable_amt \r\n" + 
		"            ELSE 0 \r\n" + 
		"        END) as other,\r\n" + 
		"        m_franchisee.fr_name \r\n" + 
		"    FROM\r\n" + 
		"        t_sell_bill_header,\r\n" + 
		"        m_franchisee \r\n" + 
		"    WHERE\r\n" + 
		"        t_sell_bill_header.bill_date BETWEEN  :fromDate AND  :toDate  \r\n" + 
		"        AND t_sell_bill_header.fr_id IN(\r\n" + 
		"        :frId  \r\n" + 
		"        ) \r\n" + 
		"        AND m_franchisee.fr_id=t_sell_bill_header.fr_id \r\n" + 
		"    GROUP BY\r\n" + 
		"        t_sell_bill_header.bill_date,\r\n" + 
		"        t_sell_bill_header.fr_id  \r\n" + 
		"    UNION\r\n" + 
		"    ALL       SELECT\r\n" + 
		"        concat(DAYNAME(t_sp_cake.sp_delivery_date),\r\n" + 
		"        '-',\r\n" + 
		"        'SP') as day,\r\n" + 
		"        t_sp_cake.sp_delivery_date as bill_date,\r\n" + 
		"        t_sp_cake.sp_order_no as bill_no,\r\n" + 
		"        t_sp_cake.fr_id,\r\n" + 
		"        sum(t_sp_cake.sp_grand_total) as cash,\r\n" + 
		"        0 as card,\r\n" + 
		"        0 as other,\r\n" + 
		"        m_franchisee.fr_name       \r\n" + 
		"    from\r\n" + 
		"        t_sp_cake,\r\n" + 
		"        m_franchisee        \r\n" + 
		"    WHERE\r\n" + 
		"        t_sp_cake.sp_delivery_date BETWEEN :fromDate AND  :toDate       \r\n" + 
		"        AND t_sp_cake.fr_id IN(\r\n" + 
		"       :frId  \r\n" + 
		"        )         \r\n" + 
		"        AND m_franchisee.fr_id=t_sp_cake.fr_id     \r\n" + 
		"    GROUP BY\r\n" + 
		"        t_sp_cake.sp_delivery_date,\r\n" + 
		"        t_sp_cake.fr_id) a order by bill_date",nativeQuery=true)
List<GetRepFrDatewiseSell> getRepFrDatewiseSell(@Param("fromDate") String fromDate,@Param("toDate") String toDate, @Param("frId") List<String> frId);


}
