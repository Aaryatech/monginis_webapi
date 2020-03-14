package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.album.AlbumCodeAndName;

public interface AlbumCodeAndNameRepo extends JpaRepository<AlbumCodeAndName, Integer> {

	/*@Query(value="SELECT a.album_id,a.album_code,a.album_name FROM t_sp_cake_album a, m_fr_configure f WHERE a.album_id IN(:items) AND a.del_status = 0 AND f.menu_id = :menuId AND f.fr_id = :frId ",nativeQuery=true)
	List<AlbumCodeAndName> findAlbumCodeAndName(@Param ("items") List<Integer>items,@Param("frId")int frId,@Param("menuId")int menuId);
*/
	
	@Query(value="SELECT a.album_id, a.album_code, a.album_name, m.sp_code FROM t_sp_cake_album a, m_fr_configure f, m_sp_cake_category m WHERE a.sp_id=m.sp_id AND m.del_status=0 AND a.album_id IN(:items) AND a.del_status = 0 AND a.is_active=1 AND f.menu_id = :menuId AND f.fr_id = :frId  ",nativeQuery=true)
	List<AlbumCodeAndName> findAlbumCodeAndName(@Param ("items") List<Integer>items,@Param("frId")int frId,@Param("menuId")int menuId);

}
