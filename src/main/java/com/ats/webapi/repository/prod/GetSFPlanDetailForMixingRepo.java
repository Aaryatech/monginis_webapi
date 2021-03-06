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
	@Query(value="          select   \n" + 
			"          a.item_detail_id,\n" + 
			"          a.item_id,\n" + 
			"          a.rm_name,\n" + 
			"          a.rm_type,\n" + 
			"          a.plan_qty,\n" + 
			"          a.order_qty,\n" + 
			"          a.rm_id,\n" + 
			"          a.no_pieces_per_item,\n" + 
			"          a.rm_qty,\n" + 
			"          a.uom,\n" + 
			"        coalesce((b.single_cut),0) as single_cut,\n" + 
			"        coalesce((c.double_cut),0) as double_cut,  coalesce((a.total),0) as total" + 
			"        from(\n" + 
			"       SELECT\n" + 
			"         m_item_detail.item_detail_id,\n" + 
			"        m_item_detail.item_id,\n" + 
			"        m_item_detail.rm_name,\n" + 
			"        m_item_detail.rm_type,\n" + 
			"        SUM(t_production_plan_detail.plan_qty) as plan_qty,\n" + 
			"        SUM(t_production_plan_detail.order_qty) as order_qty,\n" + 
			"        m_item_detail.rm_id,\n" + 
			"        m_item_detail.no_pieces_per_item,\n" + 
			"        m_item_detail.rm_qty,\n" + 
			"        m_rm_uom.uom  ,"
			+ " CASE \n" + 
			"            WHEN t_production_plan_header.is_planned=0 THEN SUM(CEIL((t_production_plan_detail.order_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item))    \n" + 
			"            ELSE  SUM(CEIL((t_production_plan_detail.plan_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item)) \n" + 
			"        END as total" + 
			"    FROM\n" + 
			"        m_item_detail,\n" + 
			"        t_production_plan_header,\n" + 
			"        t_production_plan_detail,\n" + 
			"        m_rm_uom,\n" + 
			"        m_item_sf_header,\n" + 
			"        m_item_sup    \n" + 
			"    WHERE\n" + 
			"        m_item_detail.del_status=0 \n" + 
			"        and  t_production_plan_detail.item_id=m_item_detail.item_id \n" + 
			"        AND m_item_sf_header.sf_id=m_item_detail.rm_id \n" + 
			"        and m_item_sup.item_id=m_item_detail.item_id \n" + 
			"        and    t_production_plan_header.production_header_id=t_production_plan_detail.production_header_id \n" + 
			"        AND  m_item_sf_header.int_1=:deptId\n" + 
			"        and m_item_detail.rm_type=2 \n" + 
			"        and    t_production_plan_header.production_header_id =:headerId\n" + 
			"        AND m_rm_uom.uom_id=m_item_detail.rm_uom_id \n" + 
			"    GROUP by\n" + 
			"        m_item_detail.rm_id) a LEFT JOIN \n" + 
			"        \n" + 
			"        (\n" + 
			"      SELECT\n" + 
			"               m_item_detail.rm_id,\n" + 
			"            CASE \n" + 
			"                WHEN t_production_plan_header.is_planned=0 THEN SUM(CEIL((t_production_plan_detail.order_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item))    \n" + 
			"                ELSE  SUM(CEIL((t_production_plan_detail.plan_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item)) \n" + 
			"            END     \n" + 
			"         as single_cut\n" + 
			"      \n" + 
			"      \n" + 
			"    FROM\n" + 
			"        m_item_detail,\n" + 
			"        t_production_plan_header,\n" + 
			"        t_production_plan_detail,\n" + 
			"        m_rm_uom,\n" + 
			"        m_item_sf_header,\n" + 
			"        m_item_sup    \n" + 
			"    WHERE\n" + 
			"        m_item_detail.del_status=0 \n" + 
			"        and  t_production_plan_detail.item_id=m_item_detail.item_id \n" + 
			"        AND m_item_sf_header.sf_id=m_item_detail.rm_id \n" + 
			"        and m_item_sup.item_id=m_item_detail.item_id \n" + 
			"        and    t_production_plan_header.production_header_id=t_production_plan_detail.production_header_id \n" + 
			"        AND  m_item_sf_header.int_1=:deptId\n" + 
			"        and m_item_detail.rm_type=2  and m_item_sup.cut_section=1\n" + 
			"        and    t_production_plan_header.production_header_id =:headerId\n" + 
			"        AND m_rm_uom.uom_id=m_item_detail.rm_uom_id \n" + 
			"    GROUP by\n" + 
			"        m_item_detail.rm_id) b ON b.rm_id=a.rm_id \n" + 
			"        LEFT JOIN\n" + 
			"        (\n" + 
			"        \n" + 
			"      SELECT\n" + 
			"               m_item_detail.rm_id,\n" + 
			"            CASE \n" + 
			"                WHEN t_production_plan_header.is_planned=0 THEN SUM(CEIL((t_production_plan_detail.order_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item))    \n" + 
			"                ELSE  SUM(CEIL((t_production_plan_detail.plan_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item)) \n" + 
			"            END     \n" + 
			"         as double_cut\n" + 
			"      \n" + 
			"      \n" + 
			"    FROM\n" + 
			"        m_item_detail,\n" + 
			"        t_production_plan_header,\n" + 
			"        t_production_plan_detail,\n" + 
			"        m_rm_uom,\n" + 
			"        m_item_sf_header,\n" + 
			"        m_item_sup    \n" + 
			"    WHERE\n" + 
			"        m_item_detail.del_status=0 \n" + 
			"        and  t_production_plan_detail.item_id=m_item_detail.item_id \n" + 
			"        AND m_item_sf_header.sf_id=m_item_detail.rm_id \n" + 
			"        and m_item_sup.item_id=m_item_detail.item_id \n" + 
			"        and    t_production_plan_header.production_header_id=t_production_plan_detail.production_header_id \n" + 
			"        AND  m_item_sf_header.int_1=:deptId\n" + 
			"        and m_item_detail.rm_type=2  and m_item_sup.cut_section=2\n" + 
			"        and    t_production_plan_header.production_header_id=:headerId\n" + 
			"        AND m_rm_uom.uom_id=m_item_detail.rm_uom_id \n" + 
			"    GROUP by\n" + 
			"        m_item_detail.rm_id  ) c on c.rm_id=a.rm_id",nativeQuery=true)
	
	List<GetSFPlanDetailForMixing> getSfPlanDetailForBom(@Param("headerId") int headerId,@Param("deptId") int deptId);

	@Query(value=" select  s.item_detail_id,\n" + 
			"  s.item_id,\n" + 
			"  s.rm_id,\n" + 
			"  s.rm_name,\n" + 
			"  s.rm_type,\n" + 
			"  s.rm_qty,\n" + 
			"  s.single_cut,\n" + 
			"    coalesce(c.double_cut,0)as double_cut,\n" + 
			"  s.total,\n" + 
			"  s.uom,\n" + 
			"  s.plan_qty,\n" + 
			"  s.order_qty,\n" + 
			"  s.no_pieces_per_item\n" + 
			"  from ( SELECT\n" + 
			"        m_item_detail.item_detail_id,\n" + 
			"        m_item_detail.item_id,\n" + 
			"        m_item_detail.rm_id,\n" + 
			"        m_item_detail.rm_name,\n" + 
			"        m_item_detail.rm_type,\n" + 
			"        m_item_detail.rm_qty,\n" + 
			"        m_item_sf_header.mul_factor as single_cut,\n" + 
			"        0 as double_cut,\n" + 
			"        CASE              \n" + 
			"            WHEN t_production_plan_header.is_planned=0 THEN SUM(CEIL((t_production_plan_detail.order_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item)*m_item_detail.varchar_1*m_item_sf_header.sf_weight)                 \n" + 
			"            ELSE  SUM(CEIL((t_production_plan_detail.plan_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item)*m_item_detail.varchar_1*m_item_sf_header.sf_weight)          \n" + 
			"        END as total,\n" + 
			"        m_rm_uom.uom,\n" + 
			"          SUM(t_production_plan_detail.plan_qty) as plan_qty,\n" + 
			"        SUM(t_production_plan_detail.order_qty) as order_qty,\n" + 
			"        m_item_detail.no_pieces_per_item\n" + 
			"    FROM\n" + 
			"        m_item_detail,\n" + 
			"        t_production_plan_header,\n" + 
			"        t_production_plan_detail,\n" + 
			"        m_rm_uom,\n" + 
			"        m_item_sf_header,\n" + 
			"        m_item_sup         \n" + 
			"    WHERE\n" + 
			"        m_item_detail.del_status=0 \n" + 
			"        and          t_production_plan_detail.item_id=m_item_detail.item_id  \n" + 
			"        and m_item_sf_header.sf_id=m_item_detail.rm_id          \n" + 
			"        and m_item_sup.item_id=m_item_detail.item_id          \n" + 
			"        and    t_production_plan_header.production_header_id=t_production_plan_detail.production_header_id          \n" + 
			"        AND  m_item_sf_header.int_1=:deptId    \n" + 
			"        and m_item_detail.rm_type=2          \n" + 
			"        and    t_production_plan_header.production_header_id =:headerId       \n" + 
			"        AND m_rm_uom.uom_id=m_item_detail.rm_uom_id      \n" + 
			"    GROUP by\n" + 
			"        m_item_detail.rm_id\n" + 
			"        \n" + 
			"        UNION ALL\n" + 
			"    select l.sf_did as item_detail_id,l.sf_id as item_id,l.rm_id,l.rm_name,l.rm_type,SUM(l.rm_qty) as rm_qty,1 as single_cut,SUM(l.rm_weight) as double_cut,SUM(round(((m.total*l.rm_weight_per)/100),0)) as total,l.rm_unit,0 as plan_qty,0 as order_qty,0 as no_pieces_per_item\n" + 
			" from  (\n" + 
			"        select a.sf_did,a.sf_id,a.rm_id,a.rm_name,a.rm_type,a.rm_qty,a.rm_weight,a.del_status,a.rm_unit,round((a.rm_weight/b.rm_weight),2) as rm_weight_per\n" + 
			"from\n" + 
			"(SELECT       m_item_sf_detail.sf_did,\n" + 
			"    m_item_sf_detail.sf_id,\n" + 
			"       m_item_sf_detail.rm_id,\n" + 
			"  concat(m_item_sf_detail.rm_name) as rm_name,\n" + 
			"       m_item_sf_detail.rm_type,\n" + 
			"       m_item_sf_detail.rm_qty,\n" + 
			"       m_item_sf_detail.rm_weight,\n" + 
			"       m_item_sf_detail.del_status,\n" + 
			"       m_rm_uom.uom as rm_unit\n" + 
			"   FROM\n" + 
			"       m_item_sf_detail,m_rm_uom\n" + 
			"   WHERE\n" + 
			"       m_item_sf_detail.sf_id in (SELECT\n" + 
			"        m_item_detail.rm_id\n" + 
			"          FROM\n" + 
			"        m_item_detail,\n" + 
			"        t_production_plan_header,\n" + 
			"        t_production_plan_detail,\n" + 
			"        m_item_sf_header    WHERE\n" + 
			"        m_item_detail.del_status=0\n" + 
			"        and  t_production_plan_detail.item_id=m_item_detail.item_id  \n" + 
			"        and m_item_sf_header.sf_id=m_item_detail.rm_id          \n" + 
			"        and    t_production_plan_header.production_header_id=t_production_plan_detail.production_header_id          \n" + 
			"        AND  m_item_sf_header.int_1=:deptId    \n" + 
			"        and m_item_detail.rm_type=2          \n" + 
			"        and    t_production_plan_header.production_header_id =:headerId      \n" + 
			"    group by rm_id\n" + 
			"    ) and m_item_sf_detail.del_status=0  and m_item_sf_detail.rm_type=2 and m_rm_uom.uom_id=m_item_sf_detail.rm_unit) a\n" + 
			"       LEFT JOIN\n" + 
			"       (\n" + 
			"       \n" + 
			"SELECT      \n" + 
			"    m_item_sf_detail.sf_id,\n" + 
			"     \n" + 
			"       SUM(m_item_sf_detail.rm_weight)/100 as rm_weight\n" + 
			"   FROM\n" + 
			"       m_item_sf_detail\n" + 
			"   WHERE\n" + 
			"       m_item_sf_detail.sf_id in (SELECT\n" + 
			"        m_item_detail.rm_id\n" + 
			"          FROM\n" + 
			"        m_item_detail,\n" + 
			"        t_production_plan_header,\n" + 
			"        t_production_plan_detail,\n" + 
			"        m_item_sf_header    WHERE\n" + 
			"        m_item_detail.del_status=0\n" + 
			"        and  t_production_plan_detail.item_id=m_item_detail.item_id  \n" + 
			"        and m_item_sf_header.sf_id=m_item_detail.rm_id          \n" + 
			"        and    t_production_plan_header.production_header_id=t_production_plan_detail.production_header_id          \n" + 
			"        AND  m_item_sf_header.int_1=:deptId    \n" + 
			"        and m_item_detail.rm_type=2          \n" + 
			"        and    t_production_plan_header.production_header_id =:headerId      \n" + 
			"    group by rm_id\n" + 
			"    ) and m_item_sf_detail.del_status=0  group by  m_item_sf_detail.sf_id\n" + 
			"       ) b ON b.sf_id=a.sf_id\n" + 
			"        ) l\n" + 
			"        LEFT JOIN\n" + 
			"       \n" + 
			"        (SELECT\n" + 
			"        m_item_detail.item_detail_id,\n" + 
			"        m_item_detail.item_id,\n" + 
			"        m_item_detail.rm_type,\n" + 
			"        m_item_detail.rm_id,\n" + 
			"        CASE              \n" + 
			"            WHEN t_production_plan_header.is_planned=0 THEN SUM(CEIL((t_production_plan_detail.order_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item)*m_item_detail.varchar_1*m_item_sf_header.sf_weight)                \n" + 
			"            ELSE  SUM(CEIL((t_production_plan_detail.plan_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item)*m_item_detail.varchar_1*m_item_sf_header.sf_weight)          \n" + 
			"        END as total    FROM\n" + 
			"        m_item_detail,\n" + 
			"        t_production_plan_header,\n" + 
			"        t_production_plan_detail,\n" + 
			"        m_item_sf_header    WHERE\n" + 
			"        m_item_detail.del_status=0\n" + 
			"        and          t_production_plan_detail.item_id=m_item_detail.item_id  \n" + 
			"        and m_item_sf_header.sf_id=m_item_detail.rm_id          \n" + 
			"        and    t_production_plan_header.production_header_id=t_production_plan_detail.production_header_id          \n" + 
			"        AND  m_item_sf_header.int_1=:deptId    \n" + 
			"        and m_item_detail.rm_type=2          \n" + 
			"        and    t_production_plan_header.production_header_id =:headerId      \n" + 
			"    GROUP by\n" + 
			"        m_item_detail.rm_id) m on l.sf_id=m.rm_id group by l.rm_id ) s LEFT JOIN\n" + 
			"                (  select DISTINCT d.sf_id,1 as double_cut from t_mixing_detail d where   d.mixing_id IN( select  h.mix_id from t_mixing_header h where  h.Production_id=:headerId  order by h.mix_id DESC) ) c  ON s.rm_id=c.sf_id where FIND_IN_SET(s.rm_id,(select setting_value1 from t_setting_new where setting_key='sf_cream_item' and del_status=0))",nativeQuery=true)
	List<GetSFPlanDetailForMixing> showDetailsForCp(@Param("headerId") int headerId,@Param("deptId") int deptId);

	@Query(value=" select  s.item_detail_id,\n" + 
			"  s.item_id,\n" + 
			"  s.rm_id,\n" + 
			"  s.rm_name,\n" + 
			"  s.rm_type,\n" + 
			"  s.rm_qty,\n" + 
			"  s.single_cut,\n" + 
			"  s.double_cut,\n" + 
			"  s.total,\n" + 
			"  s.uom,\n" + 
			"  s.plan_qty,\n" + 
			"  s.order_qty,\n" + 
			"  s.no_pieces_per_item\n" + 
			"  from ( SELECT\n" + 
			"        m_item_detail.item_detail_id,\n" + 
			"        m_item_detail.item_id,\n" + 
			"        m_item_detail.rm_id,\n" + 
			"        m_item_detail.rm_name,\n" + 
			"        m_item_detail.rm_type,\n" + 
			"        m_item_detail.rm_qty,\n" + 
			"        m_item_sf_header.mul_factor as single_cut,\n" + 
			"        0 as double_cut,\n" + 
			"        CASE              \n" + 
			"            WHEN t_production_plan_header.is_planned=0 THEN SUM(CEIL((t_production_plan_detail.order_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item)*m_item_detail.varchar_1*m_item_sf_header.sf_weight)                 \n" + 
			"            ELSE  SUM(CEIL((t_production_plan_detail.plan_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item)*m_item_detail.varchar_1*m_item_sf_header.sf_weight)          \n" + 
			"        END as total,\n" + 
			"        m_rm_uom.uom,\n" + 
			"          SUM(t_production_plan_detail.plan_qty) as plan_qty,\n" + 
			"        SUM(t_production_plan_detail.order_qty) as order_qty,\n" + 
			"        m_item_detail.no_pieces_per_item\n" + 
			"    FROM\n" + 
			"        m_item_detail,\n" + 
			"        t_production_plan_header,\n" + 
			"        t_production_plan_detail,\n" + 
			"        m_rm_uom,\n" + 
			"        m_item_sf_header,\n" + 
			"        m_item_sup         \n" + 
			"    WHERE\n" + 
			"        m_item_detail.del_status=0 \n" + 
			"        and          t_production_plan_detail.item_id=m_item_detail.item_id  \n" + 
			"        and m_item_sf_header.sf_id=m_item_detail.rm_id          \n" + 
			"        and m_item_sup.item_id=m_item_detail.item_id          \n" + 
			"        and    t_production_plan_header.production_header_id=t_production_plan_detail.production_header_id          \n" + 
			"        AND  m_item_sf_header.int_1=:deptId    \n" + 
			"        and m_item_detail.rm_type=2          \n" + 
			"        and    t_production_plan_header.production_header_id =:headerId       \n" + 
			"        AND m_rm_uom.uom_id=m_item_detail.rm_uom_id      \n" + 
			"    GROUP by\n" + 
			"        m_item_detail.rm_id\n" + 
			"        \n" + 
			"        UNION ALL\n" + 
			"    select l.sf_did as item_detail_id,l.sf_id as item_id,l.rm_id,l.rm_name,l.rm_type,SUM(l.rm_qty) as rm_qty,1 as single_cut,SUM(l.rm_weight) as double_cut,SUM(round(((m.total*l.rm_weight_per)/100),0)) as total,l.rm_unit,0 as plan_qty,0 as order_qty,0 as no_pieces_per_item\n" + 
			" from  (\n" + 
			"        select a.sf_did,a.sf_id,a.rm_id,a.rm_name,a.rm_type,a.rm_qty,a.rm_weight,a.del_status,a.rm_unit,round((a.rm_weight/b.rm_weight),2) as rm_weight_per\n" + 
			"from\n" + 
			"(SELECT       m_item_sf_detail.sf_did,\n" + 
			"    m_item_sf_detail.sf_id,\n" + 
			"       m_item_sf_detail.rm_id,\n" + 
			"  concat(m_item_sf_detail.rm_name) as rm_name,\n" + 
			"       m_item_sf_detail.rm_type,\n" + 
			"       m_item_sf_detail.rm_qty,\n" + 
			"       m_item_sf_detail.rm_weight,\n" + 
			"       m_item_sf_detail.del_status,\n" + 
			"       m_rm_uom.uom as rm_unit\n" + 
			"   FROM\n" + 
			"       m_item_sf_detail,m_rm_uom\n" + 
			"   WHERE\n" + 
			"       m_item_sf_detail.sf_id in (SELECT\n" + 
			"        m_item_detail.rm_id\n" + 
			"          FROM\n" + 
			"        m_item_detail,\n" + 
			"        t_production_plan_header,\n" + 
			"        t_production_plan_detail,\n" + 
			"        m_item_sf_header    WHERE\n" + 
			"        m_item_detail.del_status=0\n" + 
			"        and  t_production_plan_detail.item_id=m_item_detail.item_id  \n" + 
			"        and m_item_sf_header.sf_id=m_item_detail.rm_id          \n" + 
			"        and    t_production_plan_header.production_header_id=t_production_plan_detail.production_header_id          \n" + 
			"        AND  m_item_sf_header.int_1=:deptId    \n" + 
			"        and m_item_detail.rm_type=2          \n" + 
			"        and    t_production_plan_header.production_header_id =:headerId      \n" + 
			"    group by rm_id\n" + 
			"    ) and m_item_sf_detail.del_status=0  and m_item_sf_detail.rm_type=2 and m_rm_uom.uom_id=m_item_sf_detail.rm_unit) a\n" + 
			"       LEFT JOIN\n" + 
			"       (\n" + 
			"       \n" + 
			"SELECT      \n" + 
			"    m_item_sf_detail.sf_id,\n" + 
			"     \n" + 
			"       SUM(m_item_sf_detail.rm_weight)/100 as rm_weight\n" + 
			"   FROM\n" + 
			"       m_item_sf_detail\n" + 
			"   WHERE\n" + 
			"       m_item_sf_detail.sf_id in (SELECT\n" + 
			"        m_item_detail.rm_id\n" + 
			"          FROM\n" + 
			"        m_item_detail,\n" + 
			"        t_production_plan_header,\n" + 
			"        t_production_plan_detail,\n" + 
			"        m_item_sf_header    WHERE\n" + 
			"        m_item_detail.del_status=0\n" + 
			"        and  t_production_plan_detail.item_id=m_item_detail.item_id  \n" + 
			"        and m_item_sf_header.sf_id=m_item_detail.rm_id          \n" + 
			"        and    t_production_plan_header.production_header_id=t_production_plan_detail.production_header_id          \n" + 
			"        AND  m_item_sf_header.int_1=:deptId    \n" + 
			"        and m_item_detail.rm_type=2          \n" + 
			"        and    t_production_plan_header.production_header_id =:headerId      \n" + 
			"    group by rm_id\n" + 
			"    ) and m_item_sf_detail.del_status=0  group by  m_item_sf_detail.sf_id\n" + 
			"       ) b ON b.sf_id=a.sf_id\n" + 
			"        ) l\n" + 
			"        LEFT JOIN\n" + 
			"       \n" + 
			"        (SELECT\n" + 
			"        m_item_detail.item_detail_id,\n" + 
			"        m_item_detail.item_id,\n" + 
			"        m_item_detail.rm_type,\n" + 
			"        m_item_detail.rm_id,\n" + 
			"        CASE              \n" + 
			"            WHEN t_production_plan_header.is_planned=0 THEN SUM(CEIL((t_production_plan_detail.order_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item)*m_item_detail.varchar_1*m_item_sf_header.sf_weight)                \n" + 
			"            ELSE  SUM(CEIL((t_production_plan_detail.plan_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item)*m_item_detail.varchar_1*m_item_sf_header.sf_weight)          \n" + 
			"        END as total    FROM\n" + 
			"        m_item_detail,\n" + 
			"        t_production_plan_header,\n" + 
			"        t_production_plan_detail,\n" + 
			"        m_item_sf_header    WHERE\n" + 
			"        m_item_detail.del_status=0\n" + 
			"        and          t_production_plan_detail.item_id=m_item_detail.item_id  \n" + 
			"        and m_item_sf_header.sf_id=m_item_detail.rm_id          \n" + 
			"        and    t_production_plan_header.production_header_id=t_production_plan_detail.production_header_id          \n" + 
			"        AND  m_item_sf_header.int_1=:deptId    \n" + 
			"        and m_item_detail.rm_type=2          \n" + 
			"        and    t_production_plan_header.production_header_id =:headerId      \n" + 
			"    GROUP by\n" + 
			"        m_item_detail.rm_id) m on l.sf_id=m.rm_id group by l.rm_id ) s where !FIND_IN_SET(s.rm_id,(select setting_value1 from t_setting_new where setting_key='sf_cream_item' and del_status=0)) and !FIND_IN_SET(s.rm_id,(select setting_value1 from t_setting_new where setting_key='rm_cream_item' and del_status=0))",nativeQuery=true)
	List<GetSFPlanDetailForMixing> showDetailsForLayering(@Param("headerId") int headerId,@Param("deptId") int deptId);

	@Query(value="  select  s.item_detail_id,\n" + 
			"  s.item_id,\n" + 
			"  s.rm_id,\n" + 
			"  s.rm_name,\n" + 
			"  s.rm_type,\n" + 
			"  s.rm_qty,\n" + 
			"  s.single_cut,\n" + 
			"  coalesce(c.double_cut,0)as double_cut,\n" + 
			"  s.total,\n" + 
			"  s.uom,\n" + 
			"  s.plan_qty,\n" + 
			"  s.order_qty,\n" + 
			"  s.no_pieces_per_item\n" + 
			"  from ( SELECT\n" + 
			"        m_item_detail.item_detail_id,\n" + 
			"        m_item_detail.item_id,\n" + 
			"        m_item_detail.rm_id,\n" + 
			"        m_item_detail.rm_name,\n" + 
			"        m_item_detail.rm_type,\n" + 
			"        m_item_detail.rm_qty,\n" + 
			"        m_item_sf_header.mul_factor as single_cut,\n" + 
			"        0 as double_cut,\n" + 
			"        CASE              \n" + 
			"            WHEN t_production_plan_header.is_planned=0 THEN SUM(CEIL((t_production_plan_detail.order_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item)*m_item_detail.varchar_1*m_item_sf_header.sf_weight)                 \n" + 
			"            ELSE  SUM(CEIL((t_production_plan_detail.plan_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item)*m_item_detail.varchar_1*m_item_sf_header.sf_weight)          \n" + 
			"        END as total,\n" + 
			"        m_rm_uom.uom,\n" + 
			"          SUM(t_production_plan_detail.plan_qty) as plan_qty,\n" + 
			"        SUM(t_production_plan_detail.order_qty) as order_qty,\n" + 
			"        m_item_detail.no_pieces_per_item\n" + 
			"    FROM\n" + 
			"        m_item_detail,\n" + 
			"        t_production_plan_header,\n" + 
			"        t_production_plan_detail,\n" + 
			"        m_rm_uom,\n" + 
			"        m_item_sf_header,\n" + 
			"        m_item_sup         \n" + 
			"    WHERE\n" + 
			"        m_item_detail.del_status=0 \n" + 
			"        and          t_production_plan_detail.item_id=m_item_detail.item_id  \n" + 
			"        and m_item_sf_header.sf_id=m_item_detail.rm_id          \n" + 
			"        and m_item_sup.item_id=m_item_detail.item_id          \n" + 
			"        and    t_production_plan_header.production_header_id=t_production_plan_detail.production_header_id          \n" + 
			"        AND  m_item_sf_header.int_1=:deptId    \n" + 
			"        and m_item_detail.rm_type=2          \n" + 
			"        and    t_production_plan_header.production_header_id =:headerId       \n" + 
			"        AND m_rm_uom.uom_id=m_item_detail.rm_uom_id      \n" + 
			"    GROUP by\n" + 
			"        m_item_detail.rm_id\n" + 
			"        \n" + 
			"        UNION ALL\n" + 
			"    select l.sf_did as item_detail_id,l.sf_id as item_id,l.rm_id,l.rm_name,l.rm_type,SUM(l.rm_qty) as rm_qty,1 as single_cut,SUM(l.rm_weight) as double_cut,SUM(round(((m.total*l.rm_weight_per)/100),0)) as total,l.rm_unit,0 as plan_qty,0 as order_qty,0 as no_pieces_per_item\n" + 
			" from  (\n" + 
			"        select a.sf_did,a.sf_id,a.rm_id,a.rm_name,a.rm_type,a.rm_qty,a.rm_weight,a.del_status,a.rm_unit,round((a.rm_weight/b.rm_weight),2) as rm_weight_per\n" + 
			"from\n" + 
			"(SELECT       m_item_sf_detail.sf_did,\n" + 
			"    m_item_sf_detail.sf_id,\n" + 
			"       m_item_sf_detail.rm_id,\n" + 
			"  concat(m_item_sf_detail.rm_name) as rm_name,\n" + 
			"       m_item_sf_detail.rm_type,\n" + 
			"       m_item_sf_detail.rm_qty,\n" + 
			"       m_item_sf_detail.rm_weight,\n" + 
			"       m_item_sf_detail.del_status,\n" + 
			"       m_rm_uom.uom as rm_unit\n" + 
			"   FROM\n" + 
			"       m_item_sf_detail,m_rm_uom\n" + 
			"   WHERE\n" + 
			"       m_item_sf_detail.sf_id in (SELECT\n" + 
			"        m_item_detail.rm_id\n" + 
			"          FROM\n" + 
			"        m_item_detail,\n" + 
			"        t_production_plan_header,\n" + 
			"        t_production_plan_detail,\n" + 
			"        m_item_sf_header    WHERE\n" + 
			"        m_item_detail.del_status=0\n" + 
			"        and  t_production_plan_detail.item_id=m_item_detail.item_id  \n" + 
			"        and m_item_sf_header.sf_id=m_item_detail.rm_id          \n" + 
			"        and    t_production_plan_header.production_header_id=t_production_plan_detail.production_header_id          \n" + 
			"        AND  m_item_sf_header.int_1=:deptId    \n" + 
			"        and m_item_detail.rm_type=2          \n" + 
			"        and    t_production_plan_header.production_header_id =:headerId      \n" + 
			"    group by rm_id\n" + 
			"    ) and m_item_sf_detail.del_status=0  and m_item_sf_detail.rm_type=2 and m_rm_uom.uom_id=m_item_sf_detail.rm_unit) a\n" + 
			"       LEFT JOIN\n" + 
			"       (\n" + 
			"       \n" + 
			"SELECT      \n" + 
			"    m_item_sf_detail.sf_id,\n" + 
			"     \n" + 
			"       SUM(m_item_sf_detail.rm_weight)/100 as rm_weight\n" + 
			"   FROM\n" + 
			"       m_item_sf_detail\n" + 
			"   WHERE\n" + 
			"       m_item_sf_detail.sf_id in (SELECT\n" + 
			"        m_item_detail.rm_id\n" + 
			"          FROM\n" + 
			"        m_item_detail,\n" + 
			"        t_production_plan_header,\n" + 
			"        t_production_plan_detail,\n" + 
			"        m_item_sf_header    WHERE\n" + 
			"        m_item_detail.del_status=0\n" + 
			"        and  t_production_plan_detail.item_id=m_item_detail.item_id  \n" + 
			"        and m_item_sf_header.sf_id=m_item_detail.rm_id          \n" + 
			"        and    t_production_plan_header.production_header_id=t_production_plan_detail.production_header_id          \n" + 
			"        AND  m_item_sf_header.int_1=:deptId    \n" + 
			"        and m_item_detail.rm_type=2          \n" + 
			"        and    t_production_plan_header.production_header_id =:headerId      \n" + 
			"    group by rm_id\n" + 
			"    ) and m_item_sf_detail.del_status=0  group by  m_item_sf_detail.sf_id\n" + 
			"       ) b ON b.sf_id=a.sf_id\n" + 
			"        ) l\n" + 
			"        LEFT JOIN\n" + 
			"       \n" + 
			"        (SELECT\n" + 
			"        m_item_detail.item_detail_id,\n" + 
			"        m_item_detail.item_id,\n" + 
			"        m_item_detail.rm_type,\n" + 
			"        m_item_detail.rm_id,\n" + 
			"        CASE              \n" + 
			"            WHEN t_production_plan_header.is_planned=0 THEN SUM(CEIL((t_production_plan_detail.order_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item)*m_item_detail.varchar_1*m_item_sf_header.sf_weight)                \n" + 
			"            ELSE  SUM(CEIL((t_production_plan_detail.plan_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item)*m_item_detail.varchar_1*m_item_sf_header.sf_weight)          \n" + 
			"        END as total    FROM\n" + 
			"        m_item_detail,\n" + 
			"        t_production_plan_header,\n" + 
			"        t_production_plan_detail,\n" + 
			"        m_item_sf_header    WHERE\n" + 
			"        m_item_detail.del_status=0\n" + 
			"        and          t_production_plan_detail.item_id=m_item_detail.item_id  \n" + 
			"        and m_item_sf_header.sf_id=m_item_detail.rm_id          \n" + 
			"        and    t_production_plan_header.production_header_id=t_production_plan_detail.production_header_id          \n" + 
			"        AND  m_item_sf_header.int_1=:deptId    \n" + 
			"        and m_item_detail.rm_type=2          \n" + 
			"        and    t_production_plan_header.production_header_id =:headerId      \n" + 
			"    GROUP by\n" + 
			"        m_item_detail.rm_id) m on l.sf_id=m.rm_id group by l.rm_id ) s   LEFT JOIN " + 
			"			               (  select DISTINCT d.sf_id,1 as double_cut from t_mixing_detail d where   d.mixing_id IN( select  h.mix_id from t_mixing_header h where  h.Production_id=:headerId  order by h.mix_id DESC) ) c  ON s.rm_id=c.sf_id    where FIND_IN_SET(s.rm_id,(select setting_value1 from t_setting_new where setting_key='rm_cream_item' and del_status=0))",nativeQuery=true)
	List<GetSFPlanDetailForMixing> showDetailsForCoating(@Param("headerId") int headerId,@Param("deptId") int deptId);

	/* Commented on 27-08-2020 Sachin By INFO Sumit Sir
	 * @Query(value=" SELECT\n" + "        m_item_detail.item_detail_id,\n" +
	 * "        m_item_detail.item_id,\n" + "        m_item_detail.rm_name,\n" +
	 * "        m_item_detail.rm_type,\n" +
	 * "        SUM(t_production_plan_detail.plan_qty) plan_qty,\n" +
	 * "        SUM(t_production_plan_detail.order_qty) order_qty,\n" +
	 * "        m_item_detail.rm_id,\n" +
	 * "        m_item_detail.no_pieces_per_item,\n" +
	 * "        m_item_detail.rm_qty,\n" +
	 * "        m_item_sf_header.mul_factor as single_cut,\n" +
	 * "        CASE              \n" +
	 * "            WHEN m_item_sup.cut_section=2 THEN  (CASE                  \n" +
	 * "                WHEN t_production_plan_header.is_planned=0 THEN SUM(CEIL((t_production_plan_detail.order_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item)*m_item_detail.varchar_1*m_item_sf_header.sf_weight)                     \n"
	 * +
	 * "                ELSE  SUM(CEIL((t_production_plan_detail.plan_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item)*m_item_detail.varchar_1*m_item_sf_header.sf_weight)              \n"
	 * + "            END)              \n" + "            ELSE 0           \n" +
	 * "        END as  double_cut,\n" + "        CASE              \n" +
	 * "            WHEN t_production_plan_header.is_planned=0 THEN SUM(CEIL((t_production_plan_detail.order_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item)*m_item_detail.varchar_1*m_item_sf_header.sf_weight)                 \n"
	 * +
	 * "            ELSE  SUM(CEIL((t_production_plan_detail.plan_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item)*m_item_detail.varchar_1*m_item_sf_header.sf_weight)          \n"
	 * + "        END as total,\n" + "        m_rm_uom.uom       \n" + "    FROM\n"
	 * + "        m_item_detail,\n" + "        t_production_plan_header,\n" +
	 * "        t_production_plan_detail,\n" + "        m_rm_uom,\n" +
	 * "        m_item_sf_header,\n" + "        m_item_sup         \n" +
	 * "    WHERE\n" + "        m_item_detail.del_status=0 \n" +
	 * "        and          t_production_plan_detail.item_id=m_item_detail.item_id  \n"
	 * + "        and m_item_sf_header.sf_id=m_item_detail.rm_id          \n" +
	 * "        and m_item_sup.item_id=m_item_detail.item_id          \n" +
	 * "        and    t_production_plan_header.production_header_id=t_production_plan_detail.production_header_id          \n"
	 * + "        AND  m_item_sf_header.int_1=:deptId\n" +
	 * "        and    t_production_plan_header.production_header_id =:headerId       \n"
	 * +
	 * "        AND m_rm_uom.uom_id=m_item_detail.rm_uom_id  and m_item_detail.item_id IN(:itemId)  \n"
	 * + "    GROUP by\n" + "        m_item_detail.rm_id\n" + " ",nativeQuery=true)
	 * List<GetSFPlanDetailForMixing> getSfDetailsForIssue(@Param("headerId") int
	 * headerId,@Param("deptId") int deptId,@Param("itemId") List<String> itemId);
	 */
	
	//New for above commented on 27-08-2020 Sachin By INFO Sumit Sir
	@Query(value=" SELECT " + 
			"        m_item_detail.item_detail_id, " + 
			"        m_item_detail.item_id,\n" + 
			"        m_item_detail.rm_name,\n" + 
			"        m_item_detail.rm_type,\n" + 
			"        SUM(t_production_plan_detail.plan_qty) plan_qty,\n " + 
			"        SUM(t_production_plan_detail.order_qty) order_qty,\n" + 
			"        m_item_detail.rm_id,\n" + 
			"        m_item_detail.no_pieces_per_item,\n " + 
			"        m_item_detail.rm_qty,\n" + 
			"        m_item_sf_header.mul_factor as single_cut,\n " + 
			"        CASE                          \n" + 
			"            WHEN m_item_sup.cut_section=2 THEN \n" + 
			"            (CASE WHEN m_item_detail.rm_type=1 THEN \n" + 
			"             (CASE                                  \n" + 
			"                WHEN t_production_plan_header.is_planned=0 THEN SUM(CEIL((t_production_plan_detail.order_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item)*m_item_detail.varchar_1)                                      \n" + 
			"                ELSE  SUM(CEIL((t_production_plan_detail.plan_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item)*m_item_detail.varchar_1)                          \n" + 
			"            END) " + 
			"             " + 
			"            ELSE " + 
			"            (CASE                          \n" + 
			"            WHEN t_production_plan_header.is_planned=0 THEN SUM(CEIL((t_production_plan_detail.order_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item)*m_item_detail.varchar_1*m_item_sf_header.sf_weight)                              \n" + 
			"            ELSE  SUM(CEIL((t_production_plan_detail.plan_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item)*m_item_detail.varchar_1*m_item_sf_header.sf_weight)                  \n" + 
			"        END)END)\n" + 
			"        \n" + 
			"            ELSE 0                    \n" + 
			"        END as  double_cut,\n" + 
			"        \n" + 
			"            (CASE WHEN m_item_detail.rm_type=1 THEN \n" + 
			"             (CASE                                  \n" + 
			"                WHEN t_production_plan_header.is_planned=0 THEN SUM(CEIL((t_production_plan_detail.order_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item)*m_item_detail.varchar_1)                                      \n" + 
			"                ELSE  SUM(CEIL((t_production_plan_detail.plan_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item)*m_item_detail.varchar_1)                          \n" + 
			"            END)\n" + 
			"            \n" + 
			"            ELSE\n" + 
			"            (CASE                          \n" + 
			"            WHEN t_production_plan_header.is_planned=0 THEN SUM(CEIL((t_production_plan_detail.order_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item)*m_item_detail.varchar_1*m_item_sf_header.sf_weight)                              \n" + 
			"            ELSE  SUM(CEIL((t_production_plan_detail.plan_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item)*m_item_detail.varchar_1*m_item_sf_header.sf_weight)                  \n" + 
			"        END)END)\n" + 
			"        \n" + 
			"        \n" + 
			"        \n" + 
			"        total,\n" + 
			"        m_rm_uom.uom            \n" + 
			"    FROM\n" + 
			"        m_item_detail,\n" + 
			"        t_production_plan_header,\n" + 
			"        t_production_plan_detail,\n" + 
			"        m_rm_uom,\n" + 
			"        m_item_sf_header,\n" + 
			"        m_item_sup              \n" + 
			"    WHERE\n" + 
			"        m_item_detail.del_status=0          \n" + 
			"        and          t_production_plan_detail.item_id=m_item_detail.item_id          \n" + 
			"        and m_item_sf_header.sf_id=m_item_detail.rm_id                  \n" + 
			"        and m_item_sup.item_id=m_item_detail.item_id                  \n" + 
			"        and    t_production_plan_header.production_header_id=t_production_plan_detail.production_header_id                  \n" + 
			"        AND  m_item_sf_header.int_1=:deptId        \n" + 
			"        and    t_production_plan_header.production_header_id =:headerId               \n" + 
			"        AND m_rm_uom.uom_id=m_item_detail.rm_uom_id  \n" + 
			"        and m_item_detail.item_id IN(\n " + 
			"           :itemId  " + 
			"        )      \n" + 
			"    GROUP by " + 
			"        m_item_detail.rm_id " + 
			" ",nativeQuery=true)
	List<GetSFPlanDetailForMixing> getSfDetailsForIssue(@Param("headerId") int headerId,@Param("deptId") int deptId,@Param("itemId") List<String> itemId);
	
	
	@Query(value="select\n" + 
			"        n.item_detail_id,\n" + 
			"        n.item_id,\n" + 
			"        n.rm_id,\n" + 
			"        n.rm_name,\n" + 
			"        n.rm_type,\n" + 
			"        n.rm_qty,\n" + 
			"        n.single_cut,\n" + 
			"        n.total,\n" + 
			"        n.uom,\n" + 
			"        n.plan_qty,\n" + 
			"        n.order_qty,\n" + 
			"        n.no_pieces_per_item,\n" + 
			"        coalesce(m.double_cut,0) as double_cut\n" + 
			"    from (select\n" + 
			"        s.item_detail_id,\n" + 
			"        s.item_id,\n" + 
			"        s.rm_id,\n" + 
			"       i.item_name as rm_name,\n" + 
			"        s.rm_type,\n" + 
			"        s.rm_qty,\n" + 
			"        s.single_cut,\n" + 
			"        s.total,\n" + 
			"        s.uom,\n" + 
			"        s.plan_qty,\n" + 
			"        s.order_qty,\n" + 
			"        s.no_pieces_per_item    from\n" + 
			"        ( SELECT\n" + 
			"            m_item_detail.item_detail_id,\n" + 
			"            m_item_detail.item_id,\n" + 
			"            m_item_detail.rm_id,\n" + 
			"            m_item_detail.rm_name,\n" + 
			"            m_item_detail.rm_type,\n" + 
			"            m_item_detail.rm_qty,\n" + 
			"            m_item_sf_header.mul_factor as single_cut,\n" + 
			"            0 as double_cut,\n" + 
			"            CASE                           \n" + 
			"                WHEN t_production_plan_header.is_planned=0 THEN SUM(CEIL((t_production_plan_detail.order_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item)*m_item_detail.varchar_1*m_item_sf_header.sf_weight)                              \n" + 
			"                ELSE  SUM(CEIL((t_production_plan_detail.plan_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item)*m_item_detail.varchar_1*m_item_sf_header.sf_weight)                   \n" + 
			"            END as total,\n" + 
			"            m_rm_uom.uom,\n" + 
			"            SUM(t_production_plan_detail.plan_qty) as plan_qty,\n" + 
			"            SUM(t_production_plan_detail.order_qty) as order_qty,\n" + 
			"            m_item_detail.no_pieces_per_item     \n" + 
			"        FROM\n" + 
			"            m_item_detail,\n" + 
			"            t_production_plan_header,\n" + 
			"            t_production_plan_detail,\n" + 
			"            m_rm_uom,\n" + 
			"            m_item_sf_header,\n" + 
			"            m_item_sup              \n" + 
			"        WHERE\n" + 
			"            m_item_detail.del_status=0          \n" + 
			"            and          t_production_plan_detail.item_id=m_item_detail.item_id           \n" + 
			"            and m_item_sf_header.sf_id=m_item_detail.rm_id                   \n" + 
			"            and m_item_sup.item_id=m_item_detail.item_id                   \n" + 
			"            and    t_production_plan_header.production_header_id=t_production_plan_detail.production_header_id                   \n" + 
			"            AND  m_item_sf_header.int_1=:deptId            \n" + 
			"            and m_item_detail.rm_type=2                   \n" + 
			"            and    t_production_plan_header.production_header_id =:headerId              \n" + 
			"            AND m_rm_uom.uom_id=m_item_detail.rm_uom_id           \n" + 
			"        GROUP by\n" + 
			"            m_item_detail.rm_id, m_item_detail.item_id                   \n" + 
			"        UNION\n" + 
			"        ALL     select\n" + 
			"            l.sf_did as item_detail_id,\n" + 
			"            l.sf_id as item_id,\n" + 
			"            l.rm_id,\n" + 
			"            l.rm_name,\n" + 
			"            l.rm_type,\n" + 
			"            SUM(l.rm_qty) as rm_qty,\n" + 
			"            1 as single_cut,\n" + 
			"            SUM(l.rm_weight) as double_cut,\n" + 
			"            SUM(round(((m.total*l.rm_weight_per)/100),\n" + 
			"            0)) as total,\n" + 
			"            l.rm_unit,\n" + 
			"            0 as plan_qty,\n" + 
			"            0 as order_qty,\n" + 
			"            0 as no_pieces_per_item  \n" + 
			"        from\n" + 
			"            (         select\n" + 
			"                a.sf_did,\n" + 
			"                a.sf_id,\n" + 
			"                a.rm_id,\n" + 
			"                a.rm_name,\n" + 
			"                a.rm_type,\n" + 
			"                a.rm_qty,\n" + 
			"                a.rm_weight,\n" + 
			"                a.del_status,\n" + 
			"                a.rm_unit,\n" + 
			"                round((a.rm_weight/b.rm_weight),\n" + 
			"                2) as rm_weight_per \n" + 
			"            from\n" + 
			"                (SELECT\n" + 
			"                    m_item_sf_detail.sf_did,\n" + 
			"                    m_item_sf_detail.sf_id,\n" + 
			"                    m_item_sf_detail.rm_id,\n" + 
			"                    concat(m_item_sf_detail.rm_name) as rm_name,\n" + 
			"                    m_item_sf_detail.rm_type,\n" + 
			"                    m_item_sf_detail.rm_qty,\n" + 
			"                    m_item_sf_detail.rm_weight,\n" + 
			"                    m_item_sf_detail.del_status,\n" + 
			"                    m_rm_uom.uom as rm_unit    \n" + 
			"                FROM\n" + 
			"                    m_item_sf_detail,\n" + 
			"                    m_rm_uom    \n" + 
			"                WHERE\n" + 
			"                    m_item_sf_detail.sf_id in (\n" + 
			"                        SELECT\n" + 
			"                            m_item_detail.rm_id           \n" + 
			"                        FROM\n" + 
			"                            m_item_detail,\n" + 
			"                            t_production_plan_header,\n" + 
			"                            t_production_plan_detail,\n" + 
			"                            m_item_sf_header    \n" + 
			"                        WHERE\n" + 
			"                            m_item_detail.del_status=0         \n" + 
			"                            and  t_production_plan_detail.item_id=m_item_detail.item_id           \n" + 
			"                            and m_item_sf_header.sf_id=m_item_detail.rm_id                   \n" + 
			"                            and    t_production_plan_header.production_header_id=t_production_plan_detail.production_header_id                   \n" + 
			"                            AND  m_item_sf_header.int_1=:deptId            \n" + 
			"                            and m_item_detail.rm_type=2                   \n" + 
			"                            and    t_production_plan_header.production_header_id =:headerId         \n" + 
			"                        group by\n" + 
			"                            rm_id     \n" + 
			"                    ) \n" + 
			"                    and m_item_sf_detail.del_status=0  \n" + 
			"                    and m_item_sf_detail.rm_type=2 \n" + 
			"                    and m_rm_uom.uom_id=m_item_sf_detail.rm_unit\n" + 
			"                ) a        \n" + 
			"            LEFT JOIN\n" + 
			"                (\n" + 
			"                    SELECT\n" + 
			"                        m_item_sf_detail.sf_id,\n" + 
			"                        SUM(m_item_sf_detail.rm_weight)/100 as rm_weight    \n" + 
			"                    FROM\n" + 
			"                        m_item_sf_detail    \n" + 
			"                    WHERE\n" + 
			"                        m_item_sf_detail.sf_id in (\n" + 
			"                            SELECT\n" + 
			"                                m_item_detail.rm_id           \n" + 
			"                            FROM\n" + 
			"                                m_item_detail,\n" + 
			"                                t_production_plan_header,\n" + 
			"                                t_production_plan_detail,\n" + 
			"                                m_item_sf_header    \n" + 
			"                            WHERE\n" + 
			"                                m_item_detail.del_status=0         \n" + 
			"                                and  t_production_plan_detail.item_id=m_item_detail.item_id           \n" + 
			"                                and m_item_sf_header.sf_id=m_item_detail.rm_id                   \n" + 
			"                                and    t_production_plan_header.production_header_id=t_production_plan_detail.production_header_id                   \n" + 
			"                                AND  m_item_sf_header.int_1=:deptId            \n" + 
			"                                and m_item_detail.rm_type=2                   \n" + 
			"                                and    t_production_plan_header.production_header_id =:headerId         \n" + 
			"                            group by\n" + 
			"                                rm_id     \n" + 
			"                        ) \n" + 
			"                        and m_item_sf_detail.del_status=0  \n" + 
			"                    group by\n" + 
			"                        m_item_sf_detail.sf_id        ) b \n" + 
			"                            ON b.sf_id=a.sf_id         \n" + 
			"                    ) l         \n" + 
			"            LEFT JOIN\n" + 
			"                (\n" + 
			"                    SELECT\n" + 
			"                        m_item_detail.item_detail_id,\n" + 
			"                        m_item_detail.item_id,\n" + 
			"                        m_item_detail.rm_type,\n" + 
			"                        m_item_detail.rm_id,\n" + 
			"                        CASE                           \n" + 
			"                            WHEN t_production_plan_header.is_planned=0 THEN SUM(CEIL((t_production_plan_detail.order_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item)*m_item_detail.varchar_1*m_item_sf_header.sf_weight)                             \n" + 
			"                            ELSE  SUM(CEIL((t_production_plan_detail.plan_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item)*m_item_detail.varchar_1*m_item_sf_header.sf_weight)                   \n" + 
			"                        END as total    \n" + 
			"                    FROM\n" + 
			"                        m_item_detail,\n" + 
			"                        t_production_plan_header,\n" + 
			"                        t_production_plan_detail,\n" + 
			"                        m_item_sf_header    \n" + 
			"                    WHERE\n" + 
			"                        m_item_detail.del_status=0         \n" + 
			"                        and          t_production_plan_detail.item_id=m_item_detail.item_id           \n" + 
			"                        and m_item_sf_header.sf_id=m_item_detail.rm_id                   \n" + 
			"                        and    t_production_plan_header.production_header_id=t_production_plan_detail.production_header_id                   \n" + 
			"                        AND  m_item_sf_header.int_1=:deptId            \n" + 
			"                        and m_item_detail.rm_type=2                   \n" + 
			"                        and    t_production_plan_header.production_header_id =:headerId         \n" + 
			"                    GROUP by\n" + 
			"                        m_item_detail.rm_id\n" + 
			"                ) m \n" + 
			"                    on l.sf_id=m.rm_id \n" + 
			"            group by\n" + 
			"                l.rm_id ) s ,m_item i\n" + 
			"            where\n" + 
			"                !FIND_IN_SET(\n" + 
			"                    s.rm_id,(\n" + 
			"                        select\n" + 
			"                            setting_value1 \n" + 
			"                        from\n" + 
			"                            t_setting_new \n" + 
			"                        where\n" + 
			"                            setting_key='sf_cream_item' \n" + 
			"                            and del_status=0\n" + 
			"                    )\n" + 
			"                ) \n" + 
			"                and !FIND_IN_SET(\n" + 
			"                    s.rm_id,(\n" + 
			"                        select\n" + 
			"                            setting_value1 \n" + 
			"                        from\n" + 
			"                            t_setting_new \n" + 
			"                        where\n" + 
			"                            setting_key='rm_cream_item' \n" + 
			"                            and del_status=0\n" + 
			"                    )\n" + 
			"                ) and i.id=s.item_id and  s.rm_id=:rmId) n\n" + 
			"LEFT JOIN\n" + 
			"(select id,1 as double_cut from m_item where m_item.del_status=0 and FIND_IN_SET(m_item.id,(\n" + 
			"select group_concat(ex_varchar1) as item_ids  from t_mixing_header where production_id=:headerId and del_status=0 and ex_int1=:deptId and ex_varchar1 !=\"\"))) m on m.id=n.item_id",nativeQuery=true)
	List<GetSFPlanDetailForMixing> showDetailItemLayering(@Param("headerId")int headerId,@Param("rmId") int rmId,@Param("deptId") int deptId);

	@Query(value="select\n" + 
			"        s.item_detail_id,\n" + 
			"        s.item_id,\n" + 
			"        s.rm_id,\n" + 
			"        s.rm_name,\n" + 
			"        s.rm_type,\n" + 
			"        s.rm_qty,\n" + 
			"        s.single_cut,\n" + 
			"        s.double_cut,\n" + 
			"        s.total,\n" + 
			"        s.uom,\n" + 
			"        s.plan_qty,\n" + 
			"        s.order_qty,\n" + 
			"        s.no_pieces_per_item  \n" + 
			"    from\n" + 
			"        ( SELECT\n" + 
			"            m_item_detail.item_detail_id,\n" + 
			"            m_item_detail.item_id,\n" + 
			"            m_item_detail.rm_id,\n" + 
			"            m_item_detail.rm_name,\n" + 
			"            m_item_detail.rm_type,\n" + 
			"            m_item_detail.rm_qty,\n" + 
			"            m_item_sf_header.mul_factor as single_cut,\n" + 
			"            0 as double_cut,\n" + 
			"            SUM(CEIL((t_temp_prod.rm_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item)*m_item_detail.varchar_1*m_item_sf_header.sf_weight)                              \n" + 
			"             as total,\n" + 
			"            m_rm_uom.uom,\n" + 
			"            SUM(t_temp_prod.rm_qty) as plan_qty,\n" + 
			"            SUM(t_temp_prod.rm_qty) as order_qty,\n" + 
			"            m_item_detail.no_pieces_per_item    \n" + 
			"        FROM\n" + 
			"            m_item_detail,\n" + 
			"\n" + 
			"           t_temp_prod,\n" + 
			"            m_rm_uom,\n" + 
			"            m_item_sf_header,\n" + 
			"            m_item_sup              \n" + 
			"        WHERE\n" + 
			"            m_item_detail.del_status=0          \n" + 
			"            and          t_temp_prod.sf_id=m_item_detail.item_id          \n" + 
			"            and m_item_sf_header.sf_id=m_item_detail.rm_id                  \n" + 
			"            and m_item_sup.item_id=m_item_detail.item_id                  \n" + 
			"\n" + 
			"            AND  m_item_sf_header.int_1=:deptId\n" + 
			"            and m_item_detail.rm_type=2                  \n" + 
			"\n" + 
			"            AND m_rm_uom.uom_id=m_item_detail.rm_uom_id          \n" + 
			"        GROUP by\n" + 
			"            m_item_detail.rm_id                  \n" + 
			"        UNION\n" + 
			"        ALL     select\n" + 
			"            l.sf_did as item_detail_id,\n" + 
			"            l.sf_id as item_id,\n" + 
			"            l.rm_id,\n" + 
			"            l.rm_name,\n" + 
			"            l.rm_type,\n" + 
			"            SUM(l.rm_qty) as rm_qty,\n" + 
			"            1 as single_cut,\n" + 
			"            SUM(l.rm_weight) as double_cut,\n" + 
			"            SUM(round(((m.total*l.rm_weight_per)/100),\n" + 
			"            0)) as total,\n" + 
			"            l.rm_unit,\n" + 
			"            0 as plan_qty,\n" + 
			"            0 as order_qty,\n" + 
			"            0 as no_pieces_per_item  \n" + 
			"        from\n" + 
			"            (         select\n" + 
			"                a.sf_did,\n" + 
			"                a.sf_id,\n" + 
			"                a.rm_id,\n" + 
			"                a.rm_name,\n" + 
			"                a.rm_type,\n" + 
			"                a.rm_qty,\n" + 
			"                a.rm_weight,\n" + 
			"                a.del_status,\n" + 
			"                a.rm_unit,\n" + 
			"                round((a.rm_weight/b.rm_weight),\n" + 
			"                2) as rm_weight_per\n" + 
			"            from\n" + 
			"                (SELECT\n" + 
			"                    m_item_sf_detail.sf_did,\n" + 
			"                    m_item_sf_detail.sf_id,\n" + 
			"                    m_item_sf_detail.rm_id,\n" + 
			"                    concat(m_item_sf_detail.rm_name) as rm_name,\n" + 
			"                    m_item_sf_detail.rm_type,\n" + 
			"                    m_item_sf_detail.rm_qty,\n" + 
			"                    m_item_sf_detail.rm_weight,\n" + 
			"                    m_item_sf_detail.del_status,\n" + 
			"                    m_rm_uom.uom as rm_unit    \n" + 
			"                FROM\n" + 
			"                    m_item_sf_detail,\n" + 
			"                    m_rm_uom    \n" + 
			"                WHERE\n" + 
			"                    m_item_sf_detail.sf_id in (\n" + 
			"                        SELECT\n" + 
			"                            m_item_detail.rm_id          \n" + 
			"                        FROM\n" + 
			"                            m_item_detail,\n" + 
			"\n" + 
			"                          t_temp_prod," + 
			"                            m_item_sf_header    \n" + 
			"                        WHERE\n" + 
			"                            m_item_detail.del_status=0        \n" + 
			"                            and  t_temp_prod.sf_id=m_item_detail.item_id          \n" + 
			"                            and m_item_sf_header.sf_id=m_item_detail.rm_id                  \n" + 
			"\n" + 
			"                            AND  m_item_sf_header.int_1=:deptId          \n" + 
			"                            and m_item_detail.rm_type=2                  \n" + 
			"\n" + 
			"                        group by\n" + 
			"                            rm_id    \n" + 
			"                    )\n" + 
			"                    and m_item_sf_detail.del_status=0  \n" + 
			"                    and m_item_sf_detail.rm_type=2\n" + 
			"                    and m_rm_uom.uom_id=m_item_sf_detail.rm_unit\n" + 
			"                ) a        \n" + 
			"            LEFT JOIN\n" + 
			"                (\n" + 
			"                    SELECT\n" + 
			"                        m_item_sf_detail.sf_id,\n" + 
			"                        SUM(m_item_sf_detail.rm_weight)/100 as rm_weight    \n" + 
			"                    FROM\n" + 
			"                        m_item_sf_detail    \n" + 
			"                    WHERE\n" + 
			"                        m_item_sf_detail.sf_id in (\n" + 
			"                            SELECT\n" + 
			"                                m_item_detail.rm_id          \n" + 
			"                            FROM\n" + 
			"                                m_item_detail,\n" + 
			"\n" + 
			"                               t_temp_prod,\n" + 
			"                                m_item_sf_header    \n" + 
			"                            WHERE\n" + 
			"                                m_item_detail.del_status=0        \n" + 
			"                                and  t_temp_prod.sf_id=m_item_detail.item_id          \n" + 
			"                                and m_item_sf_header.sf_id=m_item_detail.rm_id                  \n" + 
			"\n" + 
			"                                AND  m_item_sf_header.int_1=:deptId           \n" + 
			"                                and m_item_detail.rm_type=2                  \n" + 
			"\n" + 
			"                            group by\n" + 
			"                                rm_id    \n" + 
			"                        )\n" + 
			"                        and m_item_sf_detail.del_status=0  \n" + 
			"                    group by\n" + 
			"                        m_item_sf_detail.sf_id        ) b\n" + 
			"                            ON b.sf_id=a.sf_id        \n" + 
			"                    ) l        \n" + 
			"            LEFT JOIN\n" + 
			"                (\n" + 
			"                    SELECT\n" + 
			"                        m_item_detail.item_detail_id,\n" + 
			"                        m_item_detail.item_id,\n" + 
			"                        m_item_detail.rm_type,\n" + 
			"                        m_item_detail.rm_id,\n" + 
			"                       SUM(CEIL((t_temp_prod.rm_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item)*m_item_detail.varchar_1*m_item_sf_header.sf_weight)                            \n" + 
			"                             as total    \n" + 
			"                    FROM\n" + 
			"                        m_item_detail,\n" + 
			"\n" + 
			"                     t_temp_prod, " + 
			"                        m_item_sf_header    \n" + 
			"                    WHERE\n" + 
			"                        m_item_detail.del_status=0        \n" + 
			"                        and t_temp_prod.sf_id=m_item_detail.item_id          \n" + 
			"                        and m_item_sf_header.sf_id=m_item_detail.rm_id                  \n" + 
			"\n" + 
			"                        AND  m_item_sf_header.int_1=:deptId         \n" + 
			"                        and m_item_detail.rm_type=2                  \n" + 
			"\n" + 
			"                    GROUP by\n" + 
			"                        m_item_detail.rm_id\n" + 
			"                ) m\n" + 
			"                    on l.sf_id=m.rm_id\n" + 
			"            group by\n" + 
			"                l.rm_id ) s\n" + 
			"            where\n" + 
			"                !FIND_IN_SET(\n" + 
			"                    s.rm_id,(\n" + 
			"                        select\n" + 
			"                            setting_value1\n" + 
			"                        from\n" + 
			"                            t_setting_new\n" + 
			"                        where\n" + 
			"                            setting_key='sf_cream_item'\n" + 
			"                            and del_status=0\n" + 
			"                    )\n" + 
			"                )\n" + 
			"                and !FIND_IN_SET(\n" + 
			"                    s.rm_id,(\n" + 
			"                        select\n" + 
			"                            setting_value1\n" + 
			"                        from\n" + 
			"                            t_setting_new\n" + 
			"                        where\n" + 
			"                            setting_key='rm_cream_item'\n" + 
			"                            and del_status=0\n" + 
			"                    )\n" + 
			"                )  ",nativeQuery=true)
	List<GetSFPlanDetailForMixing> showDetailsForManualProduction1(@Param("deptId")  int deptId);

	@Query(value="select\n" + 
			"        s.item_detail_id,\n" + 
			"        s.item_id,\n" + 
			"        s.rm_id,\n" + 
			"        s.rm_name,\n" + 
			"        s.rm_type,\n" + 
			"        s.rm_qty,\n" + 
			"        s.single_cut,\n" + 
			"        s.double_cut,\n" + 
			"        s.total,\n" + 
			"        s.uom,\n" + 
			"        s.plan_qty,\n" + 
			"        s.order_qty,\n" + 
			"        s.no_pieces_per_item  \n" + 
			"    from\n" + 
			"        ( SELECT\n" + 
			"            m_item_detail.item_detail_id,\n" + 
			"            m_item_detail.item_id,\n" + 
			"            m_item_detail.rm_id,\n" + 
			"            m_item_detail.rm_name,\n" + 
			"            m_item_detail.rm_type,\n" + 
			"            m_item_detail.rm_qty,\n" + 
			"            m_item_sf_header.mul_factor as single_cut,\n" + 
			"            0 as double_cut,\n" + 
			"            SUM(CEIL((t_temp_prod.rm_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item)*m_item_detail.varchar_1*m_item_sf_header.sf_weight)                              \n" + 
			"             as total,\n" + 
			"            m_rm_uom.uom,\n" + 
			"            SUM(t_temp_prod.rm_qty) as plan_qty,\n" + 
			"            SUM(t_temp_prod.rm_qty) as order_qty,\n" + 
			"            m_item_detail.no_pieces_per_item    \n" + 
			"        FROM\n" + 
			"            m_item_detail,\n" + 
			"\n" + 
			"           t_temp_prod,\n" + 
			"            m_rm_uom,\n" + 
			"            m_item_sf_header,\n" + 
			"            m_item_sup              \n" + 
			"        WHERE\n" + 
			"            m_item_detail.del_status=0          \n" + 
			"            and          t_temp_prod.sf_id=m_item_detail.item_id          \n" + 
			"            and m_item_sf_header.sf_id=m_item_detail.rm_id                  \n" + 
			"            and m_item_sup.item_id=m_item_detail.item_id                  \n" + 
			"\n" + 
			"            AND  m_item_sf_header.int_1=:deptId\n" + 
			"            and m_item_detail.rm_type=2                  \n" + 
			"\n" + 
			"            AND m_rm_uom.uom_id=m_item_detail.rm_uom_id          \n" + 
			"        GROUP by\n" + 
			"            m_item_detail.rm_id                  \n" + 
			"        UNION\n" + 
			"        ALL     select\n" + 
			"            l.sf_did as item_detail_id,\n" + 
			"            l.sf_id as item_id,\n" + 
			"            l.rm_id,\n" + 
			"            l.rm_name,\n" + 
			"            l.rm_type,\n" + 
			"            SUM(l.rm_qty) as rm_qty,\n" + 
			"            1 as single_cut,\n" + 
			"            SUM(l.rm_weight) as double_cut,\n" + 
			"            SUM(round(((m.total*l.rm_weight_per)/100),\n" + 
			"            0)) as total,\n" + 
			"            l.rm_unit,\n" + 
			"            0 as plan_qty,\n" + 
			"            0 as order_qty,\n" + 
			"            0 as no_pieces_per_item  \n" + 
			"        from\n" + 
			"            (         select\n" + 
			"                a.sf_did,\n" + 
			"                a.sf_id,\n" + 
			"                a.rm_id,\n" + 
			"                a.rm_name,\n" + 
			"                a.rm_type,\n" + 
			"                a.rm_qty,\n" + 
			"                a.rm_weight,\n" + 
			"                a.del_status,\n" + 
			"                a.rm_unit,\n" + 
			"                round((a.rm_weight/b.rm_weight),\n" + 
			"                2) as rm_weight_per\n" + 
			"            from\n" + 
			"                (SELECT\n" + 
			"                    m_item_sf_detail.sf_did,\n" + 
			"                    m_item_sf_detail.sf_id,\n" + 
			"                    m_item_sf_detail.rm_id,\n" + 
			"                    concat(m_item_sf_detail.rm_name) as rm_name,\n" + 
			"                    m_item_sf_detail.rm_type,\n" + 
			"                    m_item_sf_detail.rm_qty,\n" + 
			"                    m_item_sf_detail.rm_weight,\n" + 
			"                    m_item_sf_detail.del_status,\n" + 
			"                    m_rm_uom.uom as rm_unit    \n" + 
			"                FROM\n" + 
			"                    m_item_sf_detail,\n" + 
			"                    m_rm_uom    \n" + 
			"                WHERE\n" + 
			"                    m_item_sf_detail.sf_id in (\n" + 
			"                        SELECT\n" + 
			"                            m_item_detail.rm_id          \n" + 
			"                        FROM\n" + 
			"                            m_item_detail,\n" + 
			"\n" + 
			"                          t_temp_prod," + 
			"                            m_item_sf_header    \n" + 
			"                        WHERE\n" + 
			"                            m_item_detail.del_status=0        \n" + 
			"                            and  t_temp_prod.sf_id=m_item_detail.item_id          \n" + 
			"                            and m_item_sf_header.sf_id=m_item_detail.rm_id                  \n" + 
			"\n" + 
			"                            AND  m_item_sf_header.int_1=:deptId          \n" + 
			"                            and m_item_detail.rm_type=2                  \n" + 
			"\n" + 
			"                        group by\n" + 
			"                            rm_id    \n" + 
			"                    )\n" + 
			"                    and m_item_sf_detail.del_status=0  \n" + 
			"                    and m_item_sf_detail.rm_type=2\n" + 
			"                    and m_rm_uom.uom_id=m_item_sf_detail.rm_unit\n" + 
			"                ) a        \n" + 
			"            LEFT JOIN\n" + 
			"                (\n" + 
			"                    SELECT\n" + 
			"                        m_item_sf_detail.sf_id,\n" + 
			"                        SUM(m_item_sf_detail.rm_weight)/100 as rm_weight    \n" + 
			"                    FROM\n" + 
			"                        m_item_sf_detail    \n" + 
			"                    WHERE\n" + 
			"                        m_item_sf_detail.sf_id in (\n" + 
			"                            SELECT\n" + 
			"                                m_item_detail.rm_id          \n" + 
			"                            FROM\n" + 
			"                                m_item_detail,\n" + 
			"\n" + 
			"                               t_temp_prod,\n" + 
			"                                m_item_sf_header    \n" + 
			"                            WHERE\n" + 
			"                                m_item_detail.del_status=0        \n" + 
			"                                and  t_temp_prod.sf_id=m_item_detail.item_id          \n" + 
			"                                and m_item_sf_header.sf_id=m_item_detail.rm_id                  \n" + 
			"\n" + 
			"                                AND  m_item_sf_header.int_1=:deptId           \n" + 
			"                                and m_item_detail.rm_type=2                  \n" + 
			"\n" + 
			"                            group by\n" + 
			"                                rm_id    \n" + 
			"                        )\n" + 
			"                        and m_item_sf_detail.del_status=0  \n" + 
			"                    group by\n" + 
			"                        m_item_sf_detail.sf_id        ) b\n" + 
			"                            ON b.sf_id=a.sf_id        \n" + 
			"                    ) l        \n" + 
			"            LEFT JOIN\n" + 
			"                (\n" + 
			"                    SELECT\n" + 
			"                        m_item_detail.item_detail_id,\n" + 
			"                        m_item_detail.item_id,\n" + 
			"                        m_item_detail.rm_type,\n" + 
			"                        m_item_detail.rm_id,\n" + 
			"                       SUM(CEIL((t_temp_prod.rm_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item)*m_item_detail.varchar_1*m_item_sf_header.sf_weight)                            \n" + 
			"                             as total    \n" + 
			"                    FROM\n" + 
			"                        m_item_detail,\n" + 
			"\n" + 
			"                     t_temp_prod, " + 
			"                        m_item_sf_header    \n" + 
			"                    WHERE\n" + 
			"                        m_item_detail.del_status=0        \n" + 
			"                        and t_temp_prod.sf_id=m_item_detail.item_id          \n" + 
			"                        and m_item_sf_header.sf_id=m_item_detail.rm_id                  \n" + 
			"\n" + 
			"                        AND  m_item_sf_header.int_1=:deptId         \n" + 
			"                        and m_item_detail.rm_type=2                  \n" + 
			"\n" + 
			"                    GROUP by\n" + 
			"                        m_item_detail.rm_id\n" + 
			"                ) m\n" + 
			"                    on l.sf_id=m.rm_id\n" + 
			"            group by\n" + 
			"                l.rm_id ) s\n" + 
			"            where\n" + 
			"                !FIND_IN_SET(\n" + 
			"                    s.rm_id,(\n" + 
			"                        select\n" + 
			"                            setting_value1\n" + 
			"                        from\n" + 
			"                            t_setting_new\n" + 
			"                        where\n" + 
			"                            setting_key='sf_cream_item'\n" + 
			"                            and del_status=0\n" + 
			"                    )\n" + 
			"                )\n" + 
			"                and FIND_IN_SET(\n" + 
			"                    s.rm_id,(\n" + 
			"                        select\n" + 
			"                            setting_value1\n" + 
			"                        from\n" + 
			"                            t_setting_new\n" + 
			"                        where\n" + 
			"                            setting_key='rm_cream_item'\n" + 
			"                            and del_status=0\n" + 
			"                    )\n" + 
			"                )  ",nativeQuery=true)
	List<GetSFPlanDetailForMixing> showDetailsForManualProduction2(@Param("deptId")  int deptId);
	@Query(value="   select\n" + 
			"        a.item_detail_id,\n" + 
			"        a.item_id,\n" + 
			"        a.rm_name,\n" + 
			"        a.rm_type,\n" + 
			"        a.plan_qty,\n" + 
			"        a.order_qty,\n" + 
			"        a.rm_id,\n" + 
			"        a.no_pieces_per_item,\n" + 
			"        a.rm_qty,\n" + 
			"        a.uom,\n" + 
			"        coalesce((b.single_cut),\n" + 
			"        0) as single_cut,\n" + 
			"        coalesce((c.double_cut),\n" + 
			"        0) as double_cut,\n" + 
			"        coalesce((a.total),\n" + 
			"        0) as total        \n" + 
			"    from\n" + 
			"        (        SELECT\n" + 
			"            m_item_detail.item_detail_id,\n" + 
			"            m_item_detail.item_id,\n" + 
			"            m_item_detail.rm_name,\n" + 
			"            m_item_detail.rm_type,\n" + 
			"            SUM(t_production_plan_detail.plan_qty) as plan_qty,\n" + 
			"            SUM(t_production_plan_detail.order_qty) as order_qty,\n" + 
			"            m_item_detail.rm_id,\n" + 
			"            m_item_detail.no_pieces_per_item,\n" + 
			"            m_item_detail.rm_qty,\n" + 
			"            m_rm_uom.uom  ,\n" + 
			"            CASE              \n" + 
			"                WHEN t_production_plan_header.is_planned=0 THEN SUM(CEIL((t_production_plan_detail.order_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item))                 \n" + 
			"                ELSE  SUM(CEIL((t_production_plan_detail.plan_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item))          \n" + 
			"            END as total    \n" + 
			"        FROM\n" + 
			"            m_item_detail,\n" + 
			"            t_production_plan_header,\n" + 
			"            t_production_plan_detail,\n" + 
			"            m_rm_uom,\n" + 
			"            m_rm,\n" + 
			"            m_item_sup         \n" + 
			"        WHERE\n" + 
			"            m_item_detail.del_status=0          \n" + 
			"            and  t_production_plan_detail.item_id=m_item_detail.item_id          \n" + 
			"            AND ( m_rm.rm_id=m_item_detail.rm_id)  \n" + 
			"            and m_item_sup.item_id=m_item_detail.item_id          \n" + 
			"            and    t_production_plan_header.production_header_id=t_production_plan_detail.production_header_id          \n" + 
			"            AND  (m_rm.rm_op_rate=:deptId)       \n" + 
			"            and m_item_detail.rm_type=1          \n" + 
			"            and    t_production_plan_header.production_header_id=:headerId     \n" + 
			"            AND m_rm_uom.uom_id=m_item_detail.rm_uom_id      \n" + 
			"        GROUP by\n" + 
			"            m_item_detail.rm_id) a \n" + 
			"    LEFT JOIN\n" + 
			"        (\n" + 
			"            SELECT\n" + 
			"                m_item_detail.rm_id,\n" + 
			"                CASE                  \n" + 
			"                    WHEN t_production_plan_header.is_planned=0 THEN SUM(CEIL((t_production_plan_detail.order_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item))                     \n" + 
			"                    ELSE  SUM(CEIL((t_production_plan_detail.plan_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item))              \n" + 
			"                END               as single_cut                   \n" + 
			"            FROM\n" + 
			"                m_item_detail,\n" + 
			"                t_production_plan_header,\n" + 
			"                t_production_plan_detail,\n" + 
			"                m_rm_uom,\n" + 
			"                 m_rm,\n" + 
			"                m_item_sup         \n" + 
			"            WHERE\n" + 
			"                m_item_detail.del_status=0          \n" + 
			"                and  t_production_plan_detail.item_id=m_item_detail.item_id          \n" + 
			"                AND ( m_rm.rm_id=m_item_detail.rm_id)         \n" + 
			"                and m_item_sup.item_id=m_item_detail.item_id          \n" + 
			"                and    t_production_plan_header.production_header_id=t_production_plan_detail.production_header_id          \n" + 
			"                AND  ( m_rm.rm_op_rate=:deptId)        \n" + 
			"                and m_item_detail.rm_type=1  \n" + 
			"                and m_item_sup.cut_section=1         \n" + 
			"                and    t_production_plan_header.production_header_id=:headerId     \n" + 
			"                AND m_rm_uom.uom_id=m_item_detail.rm_uom_id      \n" + 
			"            GROUP by\n" + 
			"                m_item_detail.rm_id\n" + 
			"        ) b \n" + 
			"            ON b.rm_id=a.rm_id          \n" + 
			"    LEFT JOIN\n" + 
			"        (\n" + 
			"            SELECT\n" + 
			"                m_item_detail.rm_id,\n" + 
			"                CASE                  \n" + 
			"                    WHEN t_production_plan_header.is_planned=0 THEN SUM(CEIL((t_production_plan_detail.order_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item))                     \n" + 
			"                    ELSE  SUM(CEIL((t_production_plan_detail.plan_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item))              \n" + 
			"                END               as double_cut                   \n" + 
			"            FROM\n" + 
			"                m_item_detail,\n" + 
			"                t_production_plan_header,\n" + 
			"                t_production_plan_detail,\n" + 
			"                m_rm_uom,\n" + 
			"                m_rm,\n" + 
			"                m_item_sup         \n" + 
			"            WHERE\n" + 
			"                m_item_detail.del_status=0          \n" + 
			"                and  t_production_plan_detail.item_id=m_item_detail.item_id          \n" + 
			"                AND (m_rm.rm_id=m_item_detail.rm_id)                \n" + 
			"                and m_item_sup.item_id=m_item_detail.item_id          \n" + 
			"                and    t_production_plan_header.production_header_id=t_production_plan_detail.production_header_id          \n" + 
			"                AND (  m_rm.rm_op_rate=:deptId)             \n" + 
			"                and m_item_detail.rm_type=1  \n" + 
			"                and m_item_sup.cut_section=2         \n" + 
			"                and    t_production_plan_header.production_header_id=:headerId     \n" + 
			"                AND m_rm_uom.uom_id=m_item_detail.rm_uom_id      \n" + 
			"            GROUP by\n" + 
			"                m_item_detail.rm_id  \n" + 
			"        ) c \n" + 
			"            on c.rm_id=a.rm_id\n" + 
			"",nativeQuery=true)
	List<GetSFPlanDetailForMixing> getSfPlanDetailForStoreBom(@Param("headerId") int headerId,@Param("deptId") int deptId);

	
	/*"       CASE \n" + 
	"            WHEN m_item_sup.cut_section=1 THEN  (CASE \n" + 
	"                WHEN t_production_plan_header.is_planned=0 THEN SUM(CEIL((t_production_plan_detail.order_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item))    \n" + 
	"                ELSE  SUM(CEIL((t_production_plan_detail.plan_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item)) \n" + 
	"            END) \n" + 
	"            ELSE 0     \n" + 
	"        END as single_cut,\n" + */
}
