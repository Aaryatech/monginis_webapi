package com.ats.webapi.model.album;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface AlbumRepo extends JpaRepository<Album, Integer> {

	List<Album> findByDelStatus(int i);

	@Transactional
	@Modifying
	@Query("UPDATE Album SET del_status=1  WHERE albumId=:albumId")
	int deleteAlbum(@Param("albumId") int albumId);

	Album findByAlbumIdAndDelStatus(int albumId, int i);

}
