package com.ats.webapi.repository.prod;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.prod.mixing.GetSFPlanDetailForMixing;

//New Repo Sachin

public interface GetSFPlanDetailForMixingRepo extends JpaRepository<GetSFPlanDetailForMixing, Integer> {

	

	/*@Query(value=" SELECT m_item_detail.item_detail_id, m_item_detail.rm_id,m_item_detail.rm_qty,m_item_detail.no_pieces_per_item,"
			+ "m_item_detail.item_id,m_item_detail.rm_name,"
			+ "m_item_detail.rm_type,m_rm_uom.uom ,t_production_plan_detail.plan_qty,t_production_plan_detail.order_qty," + 
			"CASE WHEN t_production_plan_header.is_planned=1 THEN \n" + 
			"sum((t_production_plan_detail.plan_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item) "
			+ "ELSE " + 
			"sum((t_production_plan_detail.order_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item) "
			+ "END " + 
			" AS total,m_item_sf_detail.sf_id, m_item_sf_header.mul_factor  from m_item_detail,t_production_plan_header,m_rm_uom,t_production_plan_detail,m_item_sf_header,m_item_sf_detail "
			+ " where  m_rm_uom.uom_id=m_item_detail.rm_uom_id AND m_item_sf_header.sf_id=m_item_sf_detail.sf_id AND  "
			+ "t_production_plan_detail.item_id=m_item_detail.item_id AND m_item_detail.rm_type=2 AND "
			+ "t_production_plan_header.production_header_id=t_production_plan_detail.production_header_id AND "
			+ "t_production_plan_header.production_header_id=:headerId GROUP BY rm_id" + 
			"",nativeQuery=true)
	
	List<GetSFPlanDetailForMixing> getSFAndPlanDetailForMixing(@Param("headerId") int headerId);
	
	
	//  moved to other repo: ProdMixingReqP1Repo repository.prod
	*/
	// 2nd Query by Sumit Sir 30  JAn 2018 for Prod to mixing req
	/*@Query(value=" SELECT m_item_detail.item_detail_id, m_item_detail.item_id, m_item_detail.rm_name, "
			+ "m_item_detail.rm_type, t_production_plan_detail.plan_qty, t_production_plan_detail.order_qty,"
			+ "m_item_detail.rm_id, m_item_detail.no_pieces_per_item, m_item_detail.rm_qty,"
			+ "SUM((t_production_plan_detail.plan_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item)as total,m_rm_uom.uom, "
			+ "coalesce((Select m_item_sf_header.mul_factor From m_item_sf_header where m_item_sf_header.sf_id=m_item_detail.rm_id),0) "
			+ "FROM m_item_detail, t_production_plan_header, t_production_plan_detail,m_rm_uom "
			+ "WHERE t_production_plan_detail.item_id=m_item_detail.item_id AND "
			+ "t_production_plan_header.production_header_id=t_production_plan_detail.production_header_id AND "
			+ "t_production_plan_header.production_header_id=:headerId AND m_rm_uom.uom_id=m_item_detail.rm_uom_id and m_item_detail.rm_type=2"
			+ " GROUP BY m_item_detail.rm_id " + 
			"",nativeQuery=true)
	
	List<GetSFPlanDetailForMixing> getSFAndPlanDetailForMixing(@Param("headerId") int headerId);
	*/
	
	

	//same Bean Used for Bom and Mixing
	
	
	
	
	/*@Query(value=" SELECT m_item_detail.item_detail_id, m_item_detail.rm_id,m_item_detail.rm_qty,m_item_detail.no_pieces_per_item,"
			+ "m_item_detail.item_id,m_item_detail.rm_name,"
			+ "m_item_detail.rm_type,m_rm_uom.uom ,t_production_plan_detail.plan_qty,t_production_plan_detail.order_qty," + 
			"CASE WHEN t_production_plan_header.is_planned=1 THEN \n" + 
			"sum((t_production_plan_detail.plan_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item) "
			+ "ELSE " + 
			"sum((t_production_plan_detail.order_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item) "
			+ "END " + 
			" AS total,m_item_sf_detail.sf_id, m_item_sf_header.mul_factor  FROM m_item_detail,t_production_plan_header,m_rm_uom,t_production_plan_detail,m_item_sf_detail,m_item_sf_header "
			+ "WHERE  m_rm_uom.uom_id=m_item_detail.rm_uom_id AND m_item_sf_header.sf_id=m_item_sf_detail.sf_id AND "
			+ "t_production_plan_detail.item_id=m_item_detail.item_id AND "
			+ "t_production_plan_header.production_header_id=t_production_plan_detail.production_header_id AND "
			+ "t_production_plan_header.production_header_id=:headerId GROUP BY rm_id" + 
			"",nativeQuery=true)
	
	List<GetSFPlanDetailForMixing> getSfPlanDetailForBom(@Param("headerId") int headerId);
	16 Sept 19 --comment QueryPrev
	SELECT m_item_detail.item_detail_id, m_item_detail.item_id, m_item_detail.rm_name, m_item_detail.rm_type,"
			+ " t_production_plan_detail.plan_qty, t_production_plan_detail.order_qty,"
			+ "m_item_detail.rm_id, m_item_detail.no_pieces_per_item, m_item_detail.rm_qty,"
			+ "CASE WHEN t_production_plan_header.is_planned=0 THEN SUM((t_production_plan_detail.order_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item)"
			+ "ELSE  SUM((t_production_plan_detail.plan_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item) END as total,"
			+ "m_rm_uom.uom FROM m_item_detail, t_production_plan_header, t_production_plan_detail,m_rm_uom "
			+ "WHERE t_production_plan_detail.item_id=m_item_detail.item_id AND "
			+ "t_production_plan_header.production_header_id=t_production_plan_detail.production_header_id AND "
			+ "t_production_plan_header.production_header_id =:headerId AND m_rm_uom.uom_id=m_item_detail.rm_uom_id GROUP by m_item_detail.rm_id\n" + 
			"\n" + 
			"" + 
			"*/
	// NEW query FOR bom fROM pROD SUMIT sIR 30 jan 2018
	@Query(value="\n" + 
			"SELECT \n" + 
			"m_item_detail.item_detail_id,\n" + 
			"m_item_detail.item_id,\n" + 
			"m_item_detail.rm_name,\n" + 
			"m_item_detail.rm_type,\n" + 
			"t_production_plan_detail.plan_qty,\n" + 
			"t_production_plan_detail.order_qty,\n" + 
			"m_item_detail.rm_id,\n" + 
			"m_item_detail.no_pieces_per_item,\n" + 
			"m_item_detail.rm_qty,CASE WHEN m_item_sup.cut_section=1 THEN  (CASE WHEN t_production_plan_header.is_planned=0 THEN SUM(CEIL((t_production_plan_detail.order_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item))\n" + 
			"			ELSE  SUM(CEIL((t_production_plan_detail.plan_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item)) END) ELSE 0\n" + 
			"			 END as single_cut,\n" + 
			"			CASE WHEN m_item_sup.cut_section=2 THEN  (CASE WHEN t_production_plan_header.is_planned=0 THEN SUM(CEIL((t_production_plan_detail.order_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item))\n" + 
			"			ELSE  SUM(CEIL((t_production_plan_detail.plan_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item)) END) ELSE 0\n" + 
			" END as  double_cut,\n" + 
			"			CASE WHEN t_production_plan_header.is_planned=0 THEN SUM(CEIL((t_production_plan_detail.order_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item))\n" + 
			"			ELSE  SUM(CEIL((t_production_plan_detail.plan_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item)) END as total,\n" + 
			"m_rm_uom.uom \n" + 
			"FROM m_item_detail, t_production_plan_header, t_production_plan_detail,m_rm_uom,m_rm,m_item_sup \n" + 
			"			WHERE t_production_plan_detail.item_id=m_item_detail.item_id AND m_rm.rm_id=m_item_detail.rm_id and  m_item_sup.item_id=m_item_detail.item_id and \n" + 
			"			t_production_plan_header.production_header_id=t_production_plan_detail.production_header_id AND  m_rm.rm_op_rate=:deptId  and\n" + 
			"			m_item_detail.rm_type=1	and\n" + 
			"			t_production_plan_header.production_header_id =:headerId  AND m_rm_uom.uom_id=m_item_detail.rm_uom_id GROUP by m_item_detail.rm_id\n" + 
			"			\n" + 
			"UNION ALL			\n" + 
			"\n" + 
			"\n" + 
			"SELECT m_item_detail.item_detail_id, m_item_detail.item_id, m_item_detail.rm_name, m_item_detail.rm_type,\n" + 
			"			 t_production_plan_detail.plan_qty, t_production_plan_detail.order_qty,\n" + 
			"\n" + 
			"			m_item_detail.rm_id, m_item_detail.no_pieces_per_item, m_item_detail.rm_qty,\n" + 
			"			CASE WHEN m_item_sup.cut_section=1 THEN  (CASE WHEN t_production_plan_header.is_planned=0 THEN SUM(CEIL((t_production_plan_detail.order_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item))\n" + 
			"			ELSE  SUM(CEIL((t_production_plan_detail.plan_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item)) END) ELSE 0\n" + 
			"			 END as single_cut,\n" + 
			"			CASE WHEN m_item_sup.cut_section=2 THEN  (CASE WHEN t_production_plan_header.is_planned=0 THEN SUM(CEIL((t_production_plan_detail.order_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item))\n" + 
			"			ELSE  SUM(CEIL((t_production_plan_detail.plan_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item)) END) ELSE 0\n" + 
			" END as  double_cut,\n" + 
			"			CASE WHEN t_production_plan_header.is_planned=0 THEN SUM(CEIL((t_production_plan_detail.order_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item))\n" + 
			"			ELSE  SUM(CEIL((t_production_plan_detail.plan_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item)) END as total,\n" + 
			"			m_rm_uom.uom \n" + 
			"FROM m_item_detail, t_production_plan_header, t_production_plan_detail,m_rm_uom,m_item_sf_header,m_item_sup\n" + 
			"			WHERE t_production_plan_detail.item_id=m_item_detail.item_id AND m_item_sf_header.sf_id=m_item_detail.rm_id and m_item_sup.item_id=m_item_detail.item_id and\n" + 
			"			t_production_plan_header.production_header_id=t_production_plan_detail.production_header_id AND  m_item_sf_header.int_1=:deptId and m_item_detail.rm_type=2 and\n" + 
			"			t_production_plan_header.production_header_id =:headerId AND m_rm_uom.uom_id=m_item_detail.rm_uom_id GROUP by m_item_detail.rm_id",nativeQuery=true)
	
	List<GetSFPlanDetailForMixing> getSfPlanDetailForBom(@Param("headerId") int headerId,@Param("deptId") int deptId);

	@Query(value=" SELECT\n" + 
			"        m_item_detail.item_detail_id,\n" + 
			"        m_item_detail.item_id,\n" + 
			"        m_item_detail.rm_name,\n" + 
			"        m_item_detail.rm_type,\n" + 
			"        t_production_plan_detail.plan_qty,\n" + 
			"        t_production_plan_detail.order_qty,\n" + 
			"        m_item_detail.rm_id,\n" + 
			"        m_item_detail.no_pieces_per_item,\n" + 
			"        m_item_detail.rm_qty,\n" + 
			"       CASE \n" + 
			"            WHEN m_item_sup.cut_section=1 THEN  (CASE \n" + 
			"                WHEN t_production_plan_header.is_planned=0 THEN SUM(CEIL((t_production_plan_detail.order_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item))    \n" + 
			"                ELSE  SUM(CEIL((t_production_plan_detail.plan_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item)) \n" + 
			"            END) \n" + 
			"            ELSE 0     \n" + 
			"        END as single_cut,\n" + 
			"        CASE \n" + 
			"            WHEN m_item_sup.cut_section=2 THEN  (CASE \n" + 
			"                WHEN t_production_plan_header.is_planned=0 THEN SUM(CEIL((t_production_plan_detail.order_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item))    \n" + 
			"                ELSE  SUM(CEIL((t_production_plan_detail.plan_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item)) \n" + 
			"            END) \n" + 
			"            ELSE 0  \n" + 
			"        END as  double_cut,\n" + 
			"        CASE \n" + 
			"            WHEN t_production_plan_header.is_planned=0 THEN SUM(CEIL((t_production_plan_detail.order_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item))    \n" + 
			"            ELSE  SUM(CEIL((t_production_plan_detail.plan_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item)) \n" + 
			"        END as total,\n" + 
			"        m_rm_uom.uom  \n" + 
			"    FROM\n" + 
			"        m_item_detail,\n" + 
			"        t_production_plan_header,\n" + 
			"        t_production_plan_detail,\n" + 
			"        m_rm_uom,\n" + 
			"        m_rm,\n" + 
			"        m_item_sup\n" + 
			"    WHERE\n" + 
			"        t_production_plan_detail.item_id=m_item_detail.item_id  and FIND_IN_SET(m_item_detail.rm_id,(select setting_value1 from t_setting_new where setting_key='rm_cream_item' and del_status=0))\n" + 
			"        AND m_rm.rm_id=m_item_detail.rm_id \n" + 
			"        and  m_item_sup.item_id=m_item_detail.item_id \n" + 
			"        and     t_production_plan_header.production_header_id=t_production_plan_detail.production_header_id \n" + 
			"        AND  m_rm.rm_op_rate=:deptId" + 
			"        and    m_item_detail.rm_type=1 \n" + 
			"        and    t_production_plan_header.production_header_id =:headerId" + 
			"        AND m_rm_uom.uom_id=m_item_detail.rm_uom_id \n" + 
			"    GROUP by\n" + 
			"        m_item_detail.rm_id     \n" + 
			"    UNION\n" + 
			"    ALL      SELECT\n" + 
			"        m_item_detail.item_detail_id,\n" + 
			"        m_item_detail.item_id,\n" + 
			"        m_item_detail.rm_name,\n" + 
			"        m_item_detail.rm_type,\n" + 
			"        t_production_plan_detail.plan_qty,\n" + 
			"        t_production_plan_detail.order_qty,\n" + 
			"        m_item_detail.rm_id,\n" + 
			"        m_item_detail.no_pieces_per_item,\n" + 
			"        m_item_detail.rm_qty,\n" + 
			"       CASE \n" + 
			"            WHEN m_item_sup.cut_section=1 THEN  (CASE \n" + 
			"                WHEN t_production_plan_header.is_planned=0 THEN SUM(CEIL((t_production_plan_detail.order_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item))    \n" + 
			"                ELSE  SUM(CEIL((t_production_plan_detail.plan_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item)) \n" + 
			"            END) \n" + 
			"            ELSE 0     \n" + 
			"        END as single_cut,\n" + 
			"        CASE \n" + 
			"            WHEN m_item_sup.cut_section=2 THEN  (CASE \n" + 
			"                WHEN t_production_plan_header.is_planned=0 THEN SUM(CEIL((t_production_plan_detail.order_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item))    \n" + 
			"                ELSE  SUM(CEIL((t_production_plan_detail.plan_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item)) \n" + 
			"            END) \n" + 
			"            ELSE 0  \n" + 
			"        END as  double_cut,\n" + 
			"        CASE \n" + 
			"            WHEN t_production_plan_header.is_planned=0 THEN SUM(CEIL((t_production_plan_detail.order_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item))    \n" + 
			"            ELSE  SUM(CEIL((t_production_plan_detail.plan_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item)) \n" + 
			"        END as total,\n" + 
			"        m_rm_uom.uom  \n" + 
			"    FROM\n" + 
			"        m_item_detail,\n" + 
			"        t_production_plan_header,\n" + 
			"        t_production_plan_detail,\n" + 
			"        m_rm_uom,\n" + 
			"        m_item_sf_header,\n" + 
			"        m_item_sup    \n" + 
			"    WHERE\n" + 
			"        t_production_plan_detail.item_id=m_item_detail.item_id  and FIND_IN_SET(m_item_detail.rm_id,(select setting_value1 from t_setting_new where setting_key='sf_cream_item' and del_status=0))\n" + 
			"        AND m_item_sf_header.sf_id=m_item_detail.rm_id \n" + 
			"        and m_item_sup.item_id=m_item_detail.item_id \n" + 
			"        and    t_production_plan_header.production_header_id=t_production_plan_detail.production_header_id \n" + 
			"        AND  m_item_sf_header.int_1=:deptId" + 
			"        and m_item_detail.rm_type=2 \n" + 
			"        and    t_production_plan_header.production_header_id =:headerId" + 
			"        AND m_rm_uom.uom_id=m_item_detail.rm_uom_id \n" + 
			"    GROUP by\n" + 
			"        m_item_detail.rm_id",nativeQuery=true)
	List<GetSFPlanDetailForMixing> getBomDataForLayering(@Param("headerId") int headerId,@Param("deptId") int deptId);
	
}
