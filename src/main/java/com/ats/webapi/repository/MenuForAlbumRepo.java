package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.album.MenuForAlbum;

public interface MenuForAlbumRepo extends JpaRepository<MenuForAlbum, Integer> {

	@Query(value = "SELECT UUID() as id,(fc.item_show) FROM m_fr_configure fc\r\n" + 
			"WHERE fc.fr_id = :frId AND fc.menu_id IN(SELECT menu_id from m_fr_menu_show WHERE cat_id=5 AND is_same_day_applicable=4)\r\n" + 
			"", nativeQuery = true)
	List<MenuForAlbum> getData(@Param("frId")int frId);
}
