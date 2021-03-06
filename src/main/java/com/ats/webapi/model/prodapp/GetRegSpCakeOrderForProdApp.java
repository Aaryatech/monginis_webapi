package com.ats.webapi.model.prodapp;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GetRegSpCakeOrderForProdApp {
/*
 SELECT t_reg_sp_cake_sup.sr_no,t_reg_sp_cake_sup.sup_id,t_reg_sp_cake_sup.t_reg_sup_order_id,t_reg_sp_cake_sup.photo1,t_reg_sp_cake_sup.photo2, t_reg_sp_cake_sup.prod_date,t_reg_sp_cake_sup.status,t_reg_sp_cake_sup.input_kg_prod,t_reg_sp_cake_sup.is_char_used,
m_fr_route.route_name,m_franchise_sup.no_in_route,
m_franchisee.fr_name,m_franchisee.fr_code,m_franchisee.fr_id,m_fr_route.route_id,
m_item.item_name,m_item.id,m_item.item_id,m_item.item_image,
t_regular_sp_cake.rsp_place,t_regular_sp_cake.rsp_delivery_dt,
t_reg_sp_cake_sup.start_time,t_reg_sp_cake_sup.end_time,
m_cat_sub.sub_cat_id,m_cat_sub.sub_cat_name,m_category.cat_name,m_category.cat_id
FROM t_reg_sp_cake_sup,m_fr_route,m_franchise_sup,t_regular_sp_cake,m_franchisee,m_item,m_cat_sub,m_category

WHERE t_reg_sp_cake_sup.prod_date BETWEEN '2018-10-03' AND '2018-10-03' AND t_reg_sp_cake_sup.menu_id IN(42)
AND t_regular_sp_cake.rsp_id=t_reg_sp_cake_sup.t_reg_sup_order_id AND t_reg_sp_cake_sup.fr_id=m_franchisee.fr_id
AND m_franchisee.fr_id=m_franchise_sup.fr_id AND m_franchisee.fr_route_id=m_fr_route.route_id
AND m_item.id=t_reg_sp_cake_sup.item_id AND
m_item.item_grp1=m_category.cat_id AND m_item.item_grp2=m_cat_sub.sub_cat_id

ORDER BY m_fr_route.route_id DESC,m_franchise_sup.no_in_route,t_reg_sp_cake_sup.fr_id
 */
	@Id
	private int supId;
	private int tRegSupOrderId;
	private int srNo;
	private String photo1;
	private String photo2;
	private Date prodDate;
	
	private int status;
	
	private float inputKgProd;
	private String isCharUsed;
	
	private String routeName;
	private int noInRoute;
	
	private String frName;
	private String frCode;
	private int frId;
	private int routeId;
	
	private int id;
	private String itemId;
	private String itemName;
	private String itemImage;
	
	private String rspPlace;
	private Date rspDeliveryDt;
	
	private Long startTime;
	private Long endTime;
	
	private int subCatId;
	private String subCatName;
	private String catName;
	private int catId;
	public int getSupId() {
		return supId;
	}
	public void setSupId(int supId) {
		this.supId = supId;
	}
	public int gettRegSupOrderId() {
		return tRegSupOrderId;
	}
	public void settRegSupOrderId(int tRegSupOrderId) {
		this.tRegSupOrderId = tRegSupOrderId;
	}
	public int getSrNo() {
		return srNo;
	}
	public void setSrNo(int srNo) {
		this.srNo = srNo;
	}
	public String getPhoto1() {
		return photo1;
	}
	public void setPhoto1(String photo1) {
		this.photo1 = photo1;
	}
	public String getPhoto2() {
		return photo2;
	}
	public void setPhoto2(String photo2) {
		this.photo2 = photo2;
	}
	public Date getProdDate() {
		return prodDate;
	}
	public void setProdDate(Date prodDate) {
		this.prodDate = prodDate;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public float getInputKgProd() {
		return inputKgProd;
	}
	public void setInputKgProd(float inputKgProd) {
		this.inputKgProd = inputKgProd;
	}
	public String getIsCharUsed() {
		return isCharUsed;
	}
	public void setIsCharUsed(String isCharUsed) {
		this.isCharUsed = isCharUsed;
	}
	public String getRouteName() {
		return routeName;
	}
	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}
	public int getNoInRoute() {
		return noInRoute;
	}
	public void setNoInRoute(int noInRoute) {
		this.noInRoute = noInRoute;
	}
	public String getFrName() {
		return frName;
	}
	public void setFrName(String frName) {
		this.frName = frName;
	}
	public String getFrCode() {
		return frCode;
	}
	public void setFrCode(String frCode) {
		this.frCode = frCode;
	}
	public int getFrId() {
		return frId;
	}
	public void setFrId(int frId) {
		this.frId = frId;
	}
	public int getRouteId() {
		return routeId;
	}
	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemImage() {
		return itemImage;
	}
	public void setItemImage(String itemImage) {
		this.itemImage = itemImage;
	}
	public String getRspPlace() {
		return rspPlace;
	}
	public void setRspPlace(String rspPlace) {
		this.rspPlace = rspPlace;
	}
	public Date getRspDeliveryDt() {
		return rspDeliveryDt;
	}
	public void setRspDeliveryDt(Date rspDeliveryDt) {
		this.rspDeliveryDt = rspDeliveryDt;
	}
	
	public int getSubCatId() {
		return subCatId;
	}
	public void setSubCatId(int subCatId) {
		this.subCatId = subCatId;
	}
	public String getSubCatName() {
		return subCatName;
	}
	public void setSubCatName(String subCatName) {
		this.subCatName = subCatName;
	}
	public String getCatName() {
		return catName;
	}
	public void setCatName(String catName) {
		this.catName = catName;
	}
	public int getCatId() {
		return catId;
	}
	public void setCatId(int catId) {
		this.catId = catId;
	}
	public Long getStartTime() {
		return startTime;
	}
	public void setStartTime(Long startTime) {
		this.startTime = startTime;
	}
	public Long getEndTime() {
		return endTime;
	}
	public void setEndTime(Long endTime) {
		this.endTime = endTime;
	}
	@Override
	public String toString() {
		return "GetRegSpCakeOrderForProdApp [supId=" + supId + ", tRegSupOrderId=" + tRegSupOrderId + ", srNo=" + srNo
				+ ", photo1=" + photo1 + ", photo2=" + photo2 + ", prodDate=" + prodDate + ", status=" + status
				+ ", inputKgProd=" + inputKgProd + ", isCharUsed=" + isCharUsed + ", routeName=" + routeName
				+ ", noInRoute=" + noInRoute + ", frName=" + frName + ", frCode=" + frCode + ", frId=" + frId
				+ ", routeId=" + routeId + ", id=" + id + ", itemId=" + itemId + ", itemName=" + itemName
				+ ", itemImage=" + itemImage + ", rspPlace=" + rspPlace + ", rspDeliveryDt=" + rspDeliveryDt
				+ ", startTime=" + startTime + ", endTime=" + endTime + ", subCatId=" + subCatId + ", subCatName="
				+ subCatName + ", catName=" + catName + ", catId=" + catId + "]";
	}

	
	
	
	
}
