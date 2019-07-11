package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.GetSpCkSupplementCat;

public interface GetSpCakeSupCatRepository extends JpaRepository<GetSpCkSupplementCat, Integer> {

	@Query(value = "select\n" + "  s.id,sp.sp_code,\n" + "  s.sp_id,\n" + "  sp.sp_name,\n" + "  s.sp_hsncd,\n"
			+ "  s.sp_uom,s.uom_id,s.sp_cess,\n" + "  s.is_tally_sync,\n" + "  s.del_status,\n"
			+ "  s.cut_section from m_spcake_category_sup s,m_sp_cake_category sp where s.del_status=:delStatus And s.sp_id=sp.sp_id", nativeQuery = true)
	List<GetSpCkSupplementCat> findByDelStatus(@Param("delStatus") int delStatus);

}
