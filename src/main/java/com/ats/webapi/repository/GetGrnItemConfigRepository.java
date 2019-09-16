package com.ats.webapi.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.GetGrnItemConfig;

public interface GetGrnItemConfigRepository extends JpaRepository<GetGrnItemConfig, Integer> {
	
	
    
	@Query(value = "SELECT t_bill_header.bill_no,t_bill_header.bill_date_time," + 
			"t_bill_header.bill_date,t_bill_detail.item_id,m_item.item_name,t_bill_detail.grn_type," + 
			"t_bill_detail.rate,t_bill_detail.mrp,t_bill_detail.bill_qty,t_bill_detail.bill_detail_no," + 
			"t_bill_detail.bill_no,t_bill_detail.sgst_per,t_bill_detail.cgst_per,t_bill_detail.igst_per,"
			+ "t_bill_detail.cat_id,t_bill_detail.menu_id, " + 
			"t_bill_header.fr_id,t_bill_header.invoice_no FROM t_bill_header ,t_bill_detail,m_item " + 
			" WHERE t_bill_header.fr_id=:frId AND t_bill_detail.bill_no=t_bill_header.bill_no AND t_bill_header.status=2 " + 
			"AND t_bill_detail.item_id=m_item.id AND t_bill_detail.grn_type !=3 AND "
			+ "t_bill_detail.expiry_date=:cDate AND t_bill_detail.is_grngvn_applied=0", nativeQuery = true)
	
	public List<GetGrnItemConfig> getAllGrnItemConfig(@Param("cDate") String cDate,@Param("frId") int frId);

	//21 March Front End Manual GRN
	/*@Query(value = "SELECT t_bill_header.bill_no,t_bill_header.bill_date_time," + 
			"			t_bill_header.bill_date,t_bill_detail.item_id,m_item.item_name,m_item.item_grp2,t_bill_detail.grn_type," + 
			"			t_bill_detail.rate,t_bill_detail.mrp,t_bill_detail.bill_qty,t_bill_detail.bill_detail_no," + 
			"			t_bill_detail.bill_no,t_bill_detail.sgst_per,t_bill_detail.cgst_per,t_bill_detail.igst_per," + 
			"			t_bill_detail.cat_id,t_bill_detail.menu_id, " + 
			"			t_bill_header.fr_id,t_bill_header.invoice_no FROM t_bill_header ,t_bill_detail,m_item " + 
			"			WHERE t_bill_header.fr_id=:frId AND t_bill_detail.bill_no=t_bill_header.bill_no AND t_bill_header.status=2 " + 
			" AND m_item.item_grp2 IN(15,16) " + 
			" AND t_bill_detail.item_id=m_item.id AND t_bill_detail.grn_type !=3 AND " + 
			" t_bill_detail.bill_no=:billNo ", nativeQuery = true)
	
	public List<GetGrnItemConfig> getItemForManGrn(@Param("billNo")int billNo,@Param("frId") int frId);

	*/
	
	@Query(value = "SELECT t_bill_header.bill_no,t_bill_header.bill_date_time," + 
			"			t_bill_header.bill_date,t_bill_detail.item_id,m_item.item_name,m_item.item_grp2,t_bill_detail.grn_type," + 
			"			t_bill_detail.rate,t_bill_detail.mrp,t_bill_detail.bill_qty,t_bill_detail.bill_detail_no," + 
			"			t_bill_detail.bill_no,t_bill_detail.sgst_per,t_bill_detail.cgst_per,t_bill_detail.igst_per," + 
			"			t_bill_detail.cat_id,t_bill_detail.menu_id, " + 
			"			t_bill_header.fr_id,t_bill_header.invoice_no FROM t_bill_header ,t_bill_detail,m_item " + 
			"			WHERE t_bill_header.fr_id=:frId AND t_bill_detail.bill_no=t_bill_header.bill_no AND t_bill_header.status=2 " + 
			" AND t_bill_detail.item_id=m_item.id AND t_bill_detail.grn_type !=3 AND " + 
			" t_bill_detail.bill_no=:billNo ", nativeQuery = true)
	
	public List<GetGrnItemConfig> getItemForManGrn(@Param("billNo")int billNo,@Param("frId") int frId);

	
	
	
	/*@Query(value = "SELECT t_bill_header.bill_no,t_bill_header.bill_no as autoGrnQty,t_bill_header.bill_date,t_bill_header.bill_date_time,t_bill_detail.item_id,"
			+ " CASE WHEN t_bill_detail.cat_id=5 THEN s.sp_name \n" + 
			" ELSE  m_item.item_name END AS item_name,\n" + 
			"			 t_bill_detail.grn_type,t_bill_detail.rate,t_bill_detail.mrp,t_bill_detail.bill_qty,t_bill_detail.bill_detail_no,\n" + 
			"				t_bill_detail.bill_no,t_bill_detail.sgst_per,t_bill_detail.cgst_per,\n" + 
			"			 t_bill_detail.igst_per,t_bill_header.fr_id,t_bill_header.invoice_no,\n" + 
			"			 t_bill_detail.cat_id,t_bill_detail.menu_id \n" + 
			"			FROM t_bill_header ,t_bill_detail,m_item ,m_sp_cake s\n" + 
			"				 WHERE t_bill_detail.bill_no=:billNo AND t_bill_header.bill_no=t_bill_detail.bill_no AND t_bill_header.status=2 \n" + 
			"			AND CASE WHEN t_bill_detail.cat_id=5 THEN t_bill_detail.item_id=s.sp_id ELSE\n" + 
			" t_bill_detail.item_id=m_item.id END  AND t_bill_detail.is_grngvn_applied=0 group by  t_bill_detail.bill_detail_no" + "", nativeQuery = true)
	
	public List<GetGrnItemConfig> getGvnItemConfig(@Param("billNo") int billNo);*/
	
	
	/*@Query(value = "SELECT\n" + 
			"        t_bill_header.bill_no,\n" + 
			"        t_bill_header.bill_no as autoGrnQty,\n" + 
			"        t_bill_header.bill_date,\n" + 
			"        t_bill_header.bill_date_time,\n" + 
			"        t_bill_detail.item_id,\n" + 
			"        CASE \n" + 
			"            WHEN t_bill_detail.cat_id=5 THEN s.sp_name   \n" + 
			"            ELSE  m_item.item_name \n" + 
			"        END AS item_name,\n" + 
			"        t_bill_detail.grn_type,\n" + 
			"        t_bill_detail.rate,\n" + 
			"        t_bill_detail.mrp,\n" + 
			"        t_bill_detail.bill_qty,\n" + 
			"        t_bill_detail.bill_detail_no,\n" + 
			"        t_bill_detail.bill_no,\n" + 
			"        t_bill_detail.sgst_per,\n" + 
			"        t_bill_detail.cgst_per,\n" + 
			"        t_bill_detail.igst_per,\n" + 
			"        t_bill_header.fr_id,\n" + 
			"        t_bill_header.invoice_no,\n" + 
			"        t_bill_detail.cat_id,\n" + 
			"        t_bill_detail.menu_id     \n" + 
			"    FROM\n" + 
			"        t_bill_header ,\n" + 
			"        t_bill_detail,\n" + 
			"        m_item ,\n" + 
			"        m_sp_cake s      \n" + 
			"    WHERE\n" + 
			"        t_bill_detail.bill_no=:billNo \n" + 
			"        AND t_bill_header.bill_no=t_bill_detail.bill_no \n" + 
			"        AND t_bill_header.status=2     \n" + 
			"        AND CASE \n" + 
			"            WHEN t_bill_detail.cat_id=5 THEN t_bill_detail.item_id=s.sp_id \n" + 
			"            ELSE  t_bill_detail.item_id=m_item.id \n" + 
			"        END  \n" + 
			"        AND t_bill_detail.is_grngvn_applied=0 \n" + 
			"        AND t_bill_detail.menu_id NOT IN(SELECT menu_id FROM m_fr_menu_show WHERE del_status=0 AND is_same_day_applicable=4 AND cat_id=5)\n" + 
			"    group by\n" + 
			"        t_bill_detail.bill_detail_no\n" + 
			"        UNION\n" + 
			"        SELECT\n" + 
			"        t_bill_header.bill_no,\n" + 
			"        t_bill_header.bill_no as autoGrnQty,\n" + 
			"        t_bill_header.bill_date,\n" + 
			"        t_bill_header.bill_date_time,\n" + 
			"        t_bill_detail.item_id,\n" + 
			"        a.album_name as item_name, \n" + 
			"        t_bill_detail.grn_type,\n" + 
			"        t_bill_detail.rate,\n" + 
			"        t_bill_detail.mrp,\n" + 
			"        t_bill_detail.bill_qty,\n" + 
			"        t_bill_detail.bill_detail_no,\n" + 
			"        t_bill_detail.bill_no,\n" + 
			"        t_bill_detail.sgst_per,\n" + 
			"        t_bill_detail.cgst_per,\n" + 
			"        t_bill_detail.igst_per,\n" + 
			"        t_bill_header.fr_id,\n" + 
			"        t_bill_header.invoice_no,\n" + 
			"        t_bill_detail.cat_id,\n" + 
			"        t_bill_detail.menu_id     \n" + 
			"    FROM\n" + 
			"        t_bill_header ,\n" + 
			"        t_bill_detail,\n" + 
			"        t_sp_cake_album a     \n" + 
			"    WHERE\n" + 
			"        t_bill_detail.bill_no=:billNo \n" + 
			"        AND t_bill_header.bill_no=t_bill_detail.bill_no \n" + 
			"        AND t_bill_header.status=2     \n" + 
			"        AND t_bill_detail.cat_id=5 AND t_bill_detail.item_id=a.album_id  \n" + 
			"        AND t_bill_detail.is_grngvn_applied=0 \n" + 
			"        AND t_bill_detail.menu_id IN(SELECT menu_id FROM m_fr_menu_show WHERE del_status=0 AND is_same_day_applicable=4 AND cat_id=5)\n" + 
			"    group by\n" + 
			"        t_bill_detail.bill_detail_no", nativeQuery = true)
	
	public List<GetGrnItemConfig> getGvnItemConfig(@Param("billNo") int billNo);*/
	
	
	//Anmol----------16-9-2019
	@Query(value = "SELECT\n" + 
			"    t_bill_header.bill_no,\n" + 
			"    t_bill_header.bill_no AS autoGrnQty,\n" + 
			"    t_bill_header.bill_date,\n" + 
			"    t_bill_header.bill_date_time,\n" + 
			"    t_bill_detail.item_id,\n" + 
			"    CASE WHEN t_bill_detail.menu_id NOT IN(\n" + 
			"    SELECT\n" + 
			"        menu_id\n" + 
			"    FROM\n" + 
			"        m_fr_menu_show\n" + 
			"    WHERE\n" + 
			"        del_status = 0 AND is_same_day_applicable = 4 AND cat_id = 5\n" + 
			") THEN CASE WHEN t_bill_detail.cat_id = 5 THEN s.sp_name ELSE m_item.item_name\n" + 
			"END ELSE(\n" + 
			"    SELECT\n" + 
			"        SUBSTRING_INDEX(t_sp_cake.item_id, '#', -1)\n" + 
			"    FROM\n" + 
			"        t_sp_cake\n" + 
			"    WHERE\n" + 
			"        t_sp_cake.sp_order_no = t_bill_detail.order_id AND t_bill_detail.cat_id = 5\n" + 
			")\n" + 
			"END AS item_name,\n" + 
			"t_bill_detail.grn_type,\n" + 
			"t_bill_detail.rate,\n" + 
			"t_bill_detail.mrp,\n" + 
			"t_bill_detail.bill_qty,\n" + 
			"t_bill_detail.bill_detail_no,\n" + 
			"t_bill_detail.bill_no,\n" + 
			"t_bill_detail.sgst_per,\n" + 
			"t_bill_detail.cgst_per,\n" + 
			"t_bill_detail.igst_per,\n" + 
			"t_bill_header.fr_id,\n" + 
			"t_bill_header.invoice_no,\n" + 
			"t_bill_detail.cat_id,\n" + 
			"t_bill_detail.menu_id\n" + 
			"FROM\n" + 
			"    t_bill_header,\n" + 
			"    t_bill_detail,\n" + 
			"    m_item,\n" + 
			"    m_sp_cake s\n" + 
			"WHERE\n" + 
			"    t_bill_detail.bill_no = :billNo AND t_bill_header.bill_no = t_bill_detail.bill_no AND t_bill_header.status = 2 AND(\n" + 
			"        CASE WHEN t_bill_detail.menu_id NOT IN(\n" + 
			"        SELECT\n" + 
			"            menu_id\n" + 
			"        FROM\n" + 
			"            m_fr_menu_show\n" + 
			"        WHERE\n" + 
			"            del_status = 0 AND is_same_day_applicable = 4 AND cat_id = 5\n" + 
			"    ) THEN CASE WHEN t_bill_detail.cat_id = 5 THEN t_bill_detail.item_id = s.sp_id ELSE t_bill_detail.item_id = m_item.id\n" + 
			"    END ELSE 1\n" + 
			"END\n" + 
			") AND t_bill_detail.is_grngvn_applied = 0\n" + 
			"GROUP BY\n" + 
			"    t_bill_detail.bill_detail_no", nativeQuery = true)
	
	public List<GetGrnItemConfig> getGvnItemConfig(@Param("billNo") int billNo);
	
	
	
}
