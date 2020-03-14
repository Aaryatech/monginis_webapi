package com.ats.webapi.model.album;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface AlbumRepo extends JpaRepository<Album, Integer> {

	List<Album> findByDelStatus(int i);
	
	List<Album> findByDelStatusAndIsActive(int i,int j);

	@Transactional
	@Modifying
	@Query("UPDATE Album SET del_status=1  WHERE albumId=:albumId")
	int deleteAlbum(@Param("albumId") int albumId);

	Album findByAlbumIdAndDelStatus(int albumId, int i);

	List<Album> findBySpIdAndDelStatus(int spId, int i);

	Album findByAlbumCodeAndDelStatus(String albumCode, int i);

	@Query(value="select count(t_sp_cake_album.album_id) from t_sp_cake_album WHERE album_code=:code",nativeQuery=true)
	int getCountOfTSPCakeAlbCode(@Param("code") String code);
	
	@Query(value="select count(m_item.item_id) from m_item  WHERE item_id=:code",nativeQuery=true)
	int getCountOfMItemCode(@Param("code") String code);
	
	
	@Query(value="select count(m_sp_cake.sp_code) from m_sp_cake WHERE sp_code=:code",nativeQuery=true)
	int getCountOfMSpcakeCode(@Param("code") String code);
	
	@Query(value="SELECT * FROM t_sp_cake_album WHERE del_status=0 AND is_active=1",nativeQuery=true)
	List<Album> getAlbumCakeForOPS();
	
	
	
}
