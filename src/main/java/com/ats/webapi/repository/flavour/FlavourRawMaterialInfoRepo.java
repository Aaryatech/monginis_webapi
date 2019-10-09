package com.ats.webapi.repository.flavour;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.flavour.FlavourRawMaterialInfo;

public interface FlavourRawMaterialInfoRepo extends JpaRepository<FlavourRawMaterialInfo, Integer> {

	@Query(value="SELECT\n" + 
			"		a.flavour_detail_id,\n" + 
			"		a.flavour_id,\n" + 
			"        a.rm_name,\n" + 
			"        COALESCE((SUM(a.rm_qty*b.ttl_weight)),0) AS ttl_qty,\n" + 
			"        SUM(a.rm_qty) AS rm_qty,\n" + 
			"        SUM(b.ttl_weight) as weight,\n" + 
			"        a.rm_type\n" + 
			"FROM\n" + 
			"         (\n" + 
			"             SELECT 	\n" + 
			"                    f.flavour_detail_id, \n" + 
			"                    f.flavour_id,\n" + 
			"                    f.rm_name,\n" + 
			"                    f.rm_qty,\n" + 
			"                    f.rm_id, f.rm_type\n" + 
			"         \n" + 
			"            FROM 		\n" + 
			"                    m_flavour_detail f\n" + 
			"            WHERE\n" + 
			"                    f.flavour_id IN(SELECT\n" + 
			"                    m_sp_flavour.spf_id\n" + 
			"\n" + 
			"\n" + 
			"            FROM       \n" + 
			"                    m_sp_flavour,\n" + 
			"                    t_sp_cake \n" + 
			"            WHERE\n" + 
			"                     t_sp_cake.del_status = 0 \n" + 
			"        AND m_sp_flavour.spf_id = t_sp_cake.sp_flavour_id \n" + 
			"        AND t_sp_cake.is_allocated=1\n" + 
			"        AND t_sp_cake.sp_order_no IN(:spOrderNo)\n" + 
			"            GROUP BY\n" + 
			"                      m_sp_flavour.spf_id)\n" + 
			"         ) a \n" + 
			"         LEFT JOIN\n" + 
			"         			(\n" + 
			"                       SELECT\n" + 
			"                                m_sp_flavour.spf_id,\n" + 
			"                                SUM(t_sp_cake.sp_selected_weight) AS  ttl_weight\n" + 
			"\n" + 
			"                        FROM       \n" + 
			"                                m_sp_flavour,\n" + 
			"                                t_sp_cake \n" + 
			"                        WHERE\n" + 
			"                                t_sp_cake.del_status = 0 \n" + 
			"                                AND m_sp_flavour.spf_id = t_sp_cake.sp_flavour_id \n" + 
			"                                AND t_sp_cake.is_allocated=1\n" + 
			"                                AND t_sp_cake.sp_order_no IN(:spOrderNo)\n" + 
			"                        GROUP BY\n" + 
			"                                  m_sp_flavour.spf_id) b ON\n" + 
			"        	b.spf_id=a.flavour_id  \n" + 
			"            GROUP BY a.rm_id, a.rm_type",nativeQuery=true)
	List<FlavourRawMaterialInfo> getFlavourRawMaterialDetails(@Param("spOrderNo") List<String> spOrderNo);
	
}



			/*SELECT
        a.flavour_detail_id,
        a.flavour_id,
        a.rm_name,
        COALESCE((SUM(a.rm_qty*b.ttl_weight)),
        0) AS ttl_qty,
        SUM(a.rm_qty) AS rm_qty,
        SUM(b.ttl_weight) as weight,
        a.rm_id,
        a.rm_type
    FROM
        (              SELECT
            f.flavour_detail_id,
            f.flavour_id,
            f.rm_name,
            f.rm_qty,
            f.rm_id,
         	f.rm_type
        FROM
            m_flavour_detail f             
        WHERE
            f.flavour_id IN(
                SELECT
                    m_sp_flavour.spf_id               
                FROM
                    m_sp_flavour,
                    t_sp_cake              
                WHERE
                    t_sp_cake.del_status = 0          
                    AND m_sp_flavour.spf_id = t_sp_cake.sp_flavour_id          
                    AND t_sp_cake.is_allocated=1         
                    AND t_sp_cake.sp_order_no IN(49059,49188,49252,49288,49289,49290,49291,49292,49293,49294,49295,49296,49297,49298,49299,49300,49302,49303,49304,49305
                    )             
                GROUP BY
                    m_sp_flavour.spf_id
            )          
        ) a           
    LEFT JOIN
        (
            SELECT
                m_sp_flavour.spf_id,
                SUM(t_sp_cake.sp_selected_weight) AS  ttl_weight                          
            FROM
                m_sp_flavour,
                t_sp_cake                          
            WHERE
                t_sp_cake.del_status = 0                                  
                AND m_sp_flavour.spf_id = t_sp_cake.sp_flavour_id                                  
                AND t_sp_cake.is_allocated=1                                 
                AND t_sp_cake.sp_order_no IN(
                  49059,49188,49252,49288,49289,49290,49291,49292,49293,49294,49295,49296,49297,49298,49299,49300,49302,49303,49304,49305
                )                         
            GROUP BY
                m_sp_flavour.spf_id
        ) b 
            ON          b.spf_id=a.flavour_id               
    GROUP BY
        a.rm_id*/
				
