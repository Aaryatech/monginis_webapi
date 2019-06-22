package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.AllMenus;
import com.ats.webapi.model.SubCategory;
@Repository
public interface MainMenuConfigurationRepository extends JpaRepository<AllMenus, Integer> {
	
	public AllMenus save(AllMenus  allMenus);

	public List<AllMenus> findByDelStatusOrderByMenuTitleAsc(int i);
	
	@Query(value="SELECT m_fr_menu_show.* from m_fr_menu_show WHERE m_fr_menu_show.cat_id=:catId AND m_fr_menu_show.del_status=:i",nativeQuery=true)
	public List<AllMenus> findByMainCatId(@Param("catId") int catId, @Param("i")int i);

	
	@Query(value="select menu_id from m_fr_menu_show where cat_id=:catId",nativeQuery=true)
	public List<Integer> findMenuIdByMainCatId(@Param("catId")int catId);

	
	@Query(value="SELECT m_fr_menu_show.* from m_fr_menu_show WHERE m_fr_menu_show.cat_id=:catId AND m_fr_menu_show.is_same_day_applicable=:isSameDayAppl",nativeQuery=true)
	public List<AllMenus> findByCatIdAndIsSameDayApp(@Param("catId") int catId, @Param("isSameDayAppl")int isSameDayAppl);

	@Query(value="SELECT m_fr_menu_show.* from m_fr_menu_show WHERE m_fr_menu_show.cat_id=:catId AND m_fr_menu_show.is_same_day_applicable=:isSameDayAppl and m_fr_menu_show.del_status=:delStatus",nativeQuery=true)
	public List<AllMenus> findByCatIdAndIsSameDayAppAndDelStatus(@Param("catId") int catId, @Param("isSameDayAppl")int isSameDayAppl,@Param("delStatus")int delStatus);

}
