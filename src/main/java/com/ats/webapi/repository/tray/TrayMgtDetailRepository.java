package com.ats.webapi.repository.tray;

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

    @Query(value="select t.*,f.fr_name from t_tray_mgt_detail t,m_franchisee f where t.fr_id=f.fr_id and t.fr_id=:frId And t.is_same_day=:isSameDay And t.del_status=:delStatus And t.tray_status In(1,2,3)",nativeQuery=true)
	List<TrayMgtDetail> findByFrIdAndIsSameDayAndDelStatusAndTrayStatusIn(@Param("frId")int frId,@Param("isSameDay") int isSameDay,@Param("delStatus") int delStatus);

}
