package com.ats.webapi.model.album;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AlbumNewRepo extends JpaRepository<AlbumNew, Integer> {

	@Query(value="SELECT t1.*,COALESCE(t2.sp_name,'') as category,COALESCE(t2.mrp_rate1,0) as mrp FROM ( SELECT * FROM t_sp_cake_album WHERE del_status = 0 AND is_active = 1 ) t1 LEFT JOIN ( SELECT c.sp_id,c.sp_code,c.sp_name,c.mrp_rate1 FROM m_sp_cake_category c WHERE c.del_status=0 ) t2 ON t1.sp_id=t2.sp_id",nativeQuery=true)
	List<AlbumNew> getAlbumCakeForOPS();
	
}
