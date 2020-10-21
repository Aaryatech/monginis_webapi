package com.ats.webapi.repository.tray;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.tray.TrayMgtDetail;

@Repository
public interface TrayMgtDetailRepository extends JpaRepository<TrayMgtDetail, Integer>{

    @Query(value="select t.*,f.fr_name from t_tray_mgt_detail t,m_franchisee f  where t.fr_id=f.fr_id and t.fr_id=:frId  and t.tran_id=:tranId and t.del_status=:delStatus",nativeQuery=true)
	TrayMgtDetail findByFrIdAndTranIdAndDelStatus(@Param("frId")int frId,@Param("tranId") int tranId,@Param("delStatus") int delStatus);

    @Query(value="select t.*,f.fr_name from t_tray_mgt_detail t,m_franchisee f  where t.fr_id=f.fr_id and t.fr_id=:frId and t.tray_status=:trayStatus and t.is_same_day=:isSameDay and t.del_status=:delStatus",nativeQuery=true)
	TrayMgtDetail findByFrIdAndTrayStatusAndIsSameDayAndDelStatus(@Param("frId")int frId,@Param("trayStatus") int trayStatus,@Param("isSameDay")  int isSameDay,@Param("delStatus") int delStatus);

    @Query(value="select t.*,f.fr_name from t_tray_mgt_detail t,m_franchisee f  where t.fr_id=f.fr_id and t.tran_detail_id=:tranDetailId",nativeQuery=true)
	TrayMgtDetail findByTranDetailId(@Param("tranDetailId")int tranStatus3);


    @Query(value="select t.*,f.fr_name from t_tray_mgt_detail t,m_franchisee f where t.fr_id=f.fr_id and t.tran_id=:tranId And t.del_status=0",nativeQuery=true)
	List<TrayMgtDetail> findByTranId(@Param("tranId")int tranId);

    @Query(value="select t.*,f.fr_name from t_tray_mgt_detail t,m_franchisee f where t.fr_id=f.fr_id and t.fr_id=:frId And t.is_same_day=:isSameDay And t.del_status=:delStatus And t.tray_status In(1,2,3,4)",nativeQuery=true)
	List<TrayMgtDetail> findByFrIdAndIsSameDayAndDelStatusAndTrayStatusIn(@Param("frId")int frId,@Param("isSameDay") int isSameDay,@Param("delStatus") int delStatus);

    @Query(value="select t.*,f.fr_name from t_tray_mgt_detail t,m_franchisee f where t.fr_id=f.fr_id And t.tray_status=4 And t.del_status=0",nativeQuery=true)
	List<TrayMgtDetail> getTrayMgtDetailsForBill();

    @Query(value="select t.*,f.fr_name from t_tray_mgt_detail t,m_franchisee f where t.fr_id=f.fr_id And t.tray_status=5 And t.del_status=0 And t.deposit_is_used=1 And t.outtray_date between :fromDate And :toDate",nativeQuery=true)
	List<TrayMgtDetail> findTrayMgtBillDetailsByDate(@Param("fromDate")String fromDate,@Param("toDate") String toDate);

    @Query(value="select t.*,f.fr_name from t_tray_mgt_detail t,m_franchisee f where t.fr_id=f.fr_id And t.tray_status=5 And t.del_status=0 And t.deposit_is_used=1 And t.fr_id In(:frIds) And t.outtray_date between :fromDate And :toDate",nativeQuery=true)
	List<TrayMgtDetail> findTrayMgtBillDetailsByDateAndFr(@Param("fromDate")String fromDate,@Param("toDate") String toDate,@Param("frIds")  List<String> frIds);

    @Query(value="select t.*,f.fr_name from t_tray_mgt_detail t,m_franchisee f where t.fr_id=f.fr_id  And t.del_status=0 And t.deposit_is_used=:isDepositUsed And t.fr_id In(:frId) And t.outtray_date between :fromDate And :toDate",nativeQuery=true)
	List<TrayMgtDetail> findAllTrayMgtBillDetails(@Param("fromDate")String fromDate,@Param("toDate") String toDate,@Param("frId") int frId,@Param("isDepositUsed") int isDepositUsed);

    @Query(value="select t.*,f.fr_name from t_tray_mgt_detail t,m_franchisee f where t.fr_id=f.fr_id  And t.del_status=0  And t.fr_id In(:frId) And t.outtray_date between :fromDate And :toDate",nativeQuery=true)
	List<TrayMgtDetail> findTrayMgtBillDetails(@Param("fromDate")String fromDate,@Param("toDate") String toDate,@Param("frId") int frId);
   
    @Query(value="select t.*,f.fr_name from t_tray_mgt_detail t,m_franchisee f where t.fr_id=f.fr_id  And t.del_status=0  And t.fr_id In(:frId) And (t.intray_date=:traydate OR t.intray_date1=:traydate)",nativeQuery=true)
	List<TrayMgtDetail> findByIntrayDate(@Param("frId")int frId,@Param("traydate")String date);

    @Query(value = " select t.tran_detail_id,t.tran_id,t.fr_id,t.outtray_date,t.outtray_big,t.outtray_small,t.outtray_lead,t.outtray_extra,t.intray_date,t.intray_big,t.intray_small,t.intray_lead,t.intray_extra,t.intray_date1,t.intray_big1,t.intray_small1,t.intray_lead1,t.intray_extra1,SUM(t.balance_big) AS balance_big,SUM(t.balance_small) AS balance_small,SUM(t.balance_lead) AS balance_lead,SUM(t.balance_extra) AS balance_extra,t.intray_big2,t.intray_small2,t.intray_lead2,t.intray_extra2,t.price_big,t.price_small,t.price_lead,t.price_extra,t.grand_total,t.tray_status,t.deposit_is_used,t.del_status,t.intray_date2,t.qty_big,t.qty_small,t.qty_lead,t.qty_extra,t.gst_per,t.gst_rs,t.taxable_amt,t.tax_amt,t.is_same_day,f.fr_name from t_tray_mgt_detail t,m_franchisee f where t.fr_id=f.fr_id and t.fr_id=:frId  And t.del_status=:delStatus GROUP BY t.fr_id", nativeQuery = true)
	List<TrayMgtDetail> findByFrIdAndDelStatus(@Param("frId") int frId, @Param("delStatus") int delStatus);

    
    @Query(value = " SELECT\n" + 
    		"    t.tran_detail_id,\n" + 
    		"    t.tran_id,\n" + 
    		"    t.fr_id,\n" + 
    		"    t.outtray_date,\n" + 
    		"    t.outtray_big,\n" + 
    		"    t.outtray_small,\n" + 
    		"    t.outtray_lead,\n" + 
    		"    t.outtray_extra,\n" + 
    		"    t.intray_date,\n" + 
    		"    t.intray_big,\n" + 
    		"    t.intray_small,\n" + 
    		"    t.intray_lead,\n" + 
    		"    t.intray_extra,\n" + 
    		"    t.intray_date1,\n" + 
    		"    t.intray_big1,\n" + 
    		"    t.intray_small1,\n" + 
    		"    t.intray_lead1,\n" + 
    		"    t.intray_extra1,\n" + 
    		"    COALESCE((t1.out_big - t2.in_big),\n" + 
    		"    0) AS balance_big,\n" + 
    		"    COALESCE((t1.out_small - t2.in_small),\n" + 
    		"    0) AS balance_small,\n" + 
    		"    COALESCE((t1.out_lead - t2.in_lead),\n" + 
    		"    0) AS balance_lead,\n" + 
    		"    0 AS balance_extra,\n" + 
    		"    t.intray_big2,\n" + 
    		"    t.intray_small2,\n" + 
    		"    t.intray_lead2,\n" + 
    		"    t.intray_extra2,\n" + 
    		"    t.price_big,\n" + 
    		"    t.price_small,\n" + 
    		"    t.price_lead,\n" + 
    		"    t.price_extra,\n" + 
    		"    t.grand_total,\n" + 
    		"    t.tray_status,\n" + 
    		"    t.deposit_is_used,\n" + 
    		"    t.del_status,\n" + 
    		"    t.intray_date2,\n" + 
    		"    t.qty_big,\n" + 
    		"    t.qty_small,\n" + 
    		"    t.qty_lead,\n" + 
    		"    t.qty_extra,\n" + 
    		"    t.gst_per,\n" + 
    		"    t.gst_rs,\n" + 
    		"    t.taxable_amt,\n" + 
    		"    t.tax_amt,\n" + 
    		"    t.is_same_day,\n" + 
    		"    t.fr_name\n" + 
    		"FROM\n" + 
    		"    (\n" + 
    		"    SELECT\n" + 
    		"        1 AS flg,\n" + 
    		"        d.*,\n" + 
    		"        f.fr_name\n" + 
    		"    FROM\n" + 
    		"        t_tray_mgt_detail d,\n" + 
    		"        m_franchisee f\n" + 
    		"    WHERE\n" + 
    		"        d.fr_id = f.fr_id AND d.fr_id = :frId AND d.del_status = 0\n" + 
    		"    LIMIT 1\n" + 
    		") t\n" + 
    		"LEFT JOIN(\n" + 
    		"    SELECT 1 AS flg,\n" + 
    		"                COALESCE(SUM(d.outtray_small),0) AS out_small,\n" + 
    		"        COALESCE(SUM(d.outtray_big),0) AS out_big,\n" + 
    		"        COALESCE(SUM(d.outtray_lead),0) AS out_lead\n" + 
    		"    FROM\n" + 
    		"        t_tray_mgt_header h,\n" + 
    		"        t_tray_mgt_detail d\n" + 
    		"    WHERE\n" + 
    		"        h.del_status = 0 AND d.del_status = 0 AND h.tran_id = d.tran_id AND d.fr_id = :frId\n" + 
    		") t1\n" + 
    		"ON\n" + 
    		"    t.flg = t1.flg\n" + 
    		"LEFT JOIN(\n" + 
    		"    SELECT\n" + 
    		"        1 AS flg,\n" + 
    		"         COALESCE(SUM(i.intray_small),0) AS in_small,\n" + 
    		"        COALESCE(SUM(i.intray_big),0) AS in_big,\n" + 
    		"        COALESCE(SUM(i.intray_lead),0) AS in_lead" + 
    		"    FROM\n" + 
    		"        t_tray_mgt_header h,\n" + 
    		"        t_tray_mgt_detail d,\n" + 
    		"        t_tray_mgmt_detail_intray i\n" + 
    		"    WHERE\n" + 
    		"        h.del_status = 0 AND d.del_status = 0 AND i.del_status = 0 AND h.tran_id = i.tran_id AND d.tran_detail_id = i.tran_detail_id AND i.fr_id = :frId\n" + 
    		") t2\n" + 
    		"ON\n" + 
    		"    t1.flg = t2.flg", nativeQuery = true)
   	List<TrayMgtDetail> getBalByFr(@Param("frId") int frId);
    
    
    @Query(value="SELECT\n" + 
    		"    t1.tran_detail_id,\n" + 
    		"    t1.tran_id,\n" + 
    		"    t1.fr_id,\n" + 
    		"    t1.outtray_date,\n" + 
    		"    t1.outtray_big,\n" + 
    		"    t1.outtray_small,\n" + 
    		"    t1.outtray_lead,\n" + 
    		"    t1.outtray_extra,\n" + 
    		"    t1.intray_date,\n" + 
    		"    t1.intray_big,\n" + 
    		"    t1.intray_small,\n" + 
    		"    t1.intray_lead,\n" + 
    		"    t1.intray_extra,\n" + 
    		"    t1.intray_date1,\n" + 
    		"    t1.intray_big1,\n" + 
    		"    t1.intray_small1,\n" + 
    		"    t1.intray_lead1,\n" + 
    		"    t1.intray_extra1,\n" + 
    		"    t2.balance_big,\n" + 
    		"    t2.balance_small,\n" + 
    		"    t2.balance_lead,\n" + 
    		"    t2.balance_extra,\n" + 
    		"    t1.intray_big2,\n" + 
    		"    t1.intray_small2,\n" + 
    		"    t1.intray_lead2,\n" + 
    		"    t1.intray_extra2,\n" + 
    		"    t1.price_big,\n" + 
    		"    t1.price_small,\n" + 
    		"    t1.price_lead,\n" + 
    		"    t1.price_extra,\n" + 
    		"    t1.grand_total,\n" + 
    		"    t1.tray_status,\n" + 
    		"    t1.deposit_is_used,\n" + 
    		"    t1.del_status,\n" + 
    		"    t1.intray_date2,\n" + 
    		"    t1.qty_big,\n" + 
    		"    t1.qty_small,\n" + 
    		"    t1.qty_lead,\n" + 
    		"    t1.qty_extra,\n" + 
    		"    t1.gst_per,\n" + 
    		"    t1.gst_rs,\n" + 
    		"    t1.taxable_amt,\n" + 
    		"    t1.tax_amt,\n" + 
    		"    t1.is_same_day,\n" + 
    		"    t1.fr_name\n" + 
    		"FROM\n" + 
    		"    (\n" + 
    		"    SELECT\n" + 
    		"        t.*,\n" + 
    		"        f.fr_name\n" + 
    		"    FROM\n" + 
    		"        t_tray_mgt_detail t,\n" + 
    		"        m_franchisee f\n" + 
    		"    WHERE\n" + 
    		"        t.fr_id = f.fr_id AND t.tran_id = :tranId AND t.del_status = 0\n" + 
    		") t1\n" + 
    		"LEFT JOIN(\n" + 
    		"    SELECT\n" + 
    		"        t.tran_detail_id,\n" + 
    		"        t.fr_id,\n" + 
    		"        SUM(t.balance_big) AS balance_big,\n" + 
    		"        SUM(t.balance_small) AS balance_small,\n" + 
    		"        SUM(t.balance_lead) AS balance_lead,\n" + 
    		"        SUM(t.balance_extra) AS balance_extra\n" + 
    		"    FROM\n" + 
    		"        t_tray_mgt_detail t\n" + 
    		"    WHERE\n" + 
    		"        t.del_status = 0 AND t.fr_id IN(\n" + 
    		"        SELECT\n" + 
    		"            fr_id\n" + 
    		"        FROM\n" + 
    		"            t_tray_mgt_detail\n" + 
    		"        WHERE\n" + 
    		"            del_status = 0 AND tran_id = :tranId\n" + 
    		"    )\n" + 
    		"GROUP BY\n" + 
    		"    t.fr_id\n" + 
    		") t2\n" + 
    		"ON\n" + 
    		"    t1.fr_id = t2.fr_id",nativeQuery=true)
   	List<TrayMgtDetail> getByTranIdWithBal(@Param("tranId")int tranId);
    
    
    
    //UPDATE
    @Modifying
	@Transactional
	@Query("Update TrayMgtDetail  SET balance_small=:small,balance_big=:big,balance_lead=:lid,tray_status=:status "
			+ " WHERE tran_detail_id=:tranDetailId")
	int updateBalTrayDetail(@Param("tranDetailId") int tranDetailId, @Param("small") int small,
			@Param("big") int big, @Param("lid") int lid, @Param("status") int status);
}
