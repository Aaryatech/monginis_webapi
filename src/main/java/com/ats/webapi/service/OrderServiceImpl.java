package com.ats.webapi.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.commons.Firebase;
import com.ats.webapi.model.AllFrIdName;
import com.ats.webapi.model.ErrorMessage;
import com.ats.webapi.model.ItemOrderHis;
import com.ats.webapi.model.ItemOrderList;
import com.ats.webapi.model.Orders;
import com.ats.webapi.repository.AllFrIdNameRepository;
import com.ats.webapi.repository.FranchiseSupRepository;
import com.ats.webapi.repository.ItemOrderHisRepository;
import com.ats.webapi.repository.OrderRepository;
import com.ats.webapi.repository.OrdersRepository;

@Service
public class OrderServiceImpl implements OrderService {

	String jsonResult;
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	ItemOrderHisRepository itemOrderHisRepository;

	@Autowired
	AllFrIdNameRepository allFrIdNameRepository;
	 
	@Autowired
	FranchiseSupRepository franchiseSupRepository;
	
	@Override
	public List<Orders> placeOrder(List<Orders> list) {
		List<Orders> returnList = new ArrayList();
		boolean flag=false;
		for (Orders o : list) {

			Orders prevOrder = orderRepository.findPreviousOrder(o.getItemId(), o.getFrId(), o.getProductionDate(),
					o.getMenuId());

			try {

				System.out.println("prev order orderId " + prevOrder.getOrderId());

				if (prevOrder.getItemId().equalsIgnoreCase("") || prevOrder.getItemId().equalsIgnoreCase(null)) {

				} else {
					System.out.println("Updating order with qty " + o.getOrderQty());

					Orders updatedOrder = null;
					if (o.getOrderQty() == 0) {

						System.out.println("Deleteing order");

						Long result = orderRepository.deleteByOrderDateAndMenuIdAndItemId(o.getOrderDate(),
								o.getMenuId(), o.getItemId());

						System.out.println("Order Deleted ? = " + result);
					} else {
						prevOrder.setOrderQty(o.getOrderQty());
						updatedOrder = orderRepository.save(prevOrder);
						//-----------------------For Notification-----------------
					
						String frToken="";
						if(flag==false) {
						try {
							
							 frToken=franchiseSupRepository.findTokenByFrId(o.getFrId());
						
							flag=true;
						}
						catch (Exception e) {
							e.printStackTrace();
							
						}
						 try {
					          Firebase.sendPushNotifForCommunication(frToken,"Order Placed Successfully","Your Order has been saved. Total Items Ordered were--. Thank You..Team Monginis","order");
					    	
					         }
					         catch(Exception e)
					         {
						       e.printStackTrace();
					         }
						}
						//---------------------------------------------------------------
					}
					
					returnList.add(updatedOrder);
				}

			} catch (Exception e) {

				System.out.println("Prev Order Exception " + e.getMessage());
				
				if (e.getMessage() == null) {
					System.out.println("Saving new order");

					Orders newOrder = orderRepository.save(o);
				//-----------------------For Notification-----------------
					String frToken="";
					
					if(flag==false) {
					
					try {
						 frToken=franchiseSupRepository.findTokenByFrId(o.getFrId());
						 flag=true;
					}
					catch (Exception e1) {
						e1.printStackTrace();
					}
					 try {
				          Firebase.sendPushNotifForCommunication(frToken,"Order Placed Successfully","Your Order has been saved. Total Items Ordered were--. Thank You..Team Monginis","order");
				    	
				         }
				         catch(Exception e2)
				         {
					       e2.printStackTrace();
				         }
					}
					//-----------------------------------------------------
					returnList.add(newOrder);
				}
			}

			// Orders order=orderRepository.save(o);
			// returnList.add(prevOrder);
		}

		return returnList;
	}

	@Override
	public ItemOrderList searchOrderHistory(int menuId, Date deliveryDate, int frId) {
		List<ItemOrderHis> orderList = null;
		ErrorMessage errorMessage;
		ItemOrderList itemOrderList;
		try {
			orderList = itemOrderHisRepository.findByMenuIdInAndDeliveryDate(menuId, deliveryDate, frId);

			if (orderList == null) {
				errorMessage = new ErrorMessage();
				itemOrderList = new ItemOrderList();

				errorMessage.setError(true);
				errorMessage.setMessage("Orders Not Found");

				itemOrderList.setErrorMessage(errorMessage);
			} else {
				errorMessage = new ErrorMessage();
				itemOrderList = new ItemOrderList();

				errorMessage.setError(false);
				errorMessage.setMessage("Orders found Successfully");

				itemOrderList.setItemOrderList(orderList);
				itemOrderList.setErrorMessage(errorMessage);

			}

		} catch (Exception e) {
			itemOrderList = new ItemOrderList();
			errorMessage = new ErrorMessage();

			errorMessage.setError(true);
			errorMessage.setMessage("Orders Not Found(EXC)");

			itemOrderList.setErrorMessage(errorMessage);
		}
		return itemOrderList;
	}

	// new Update order method for billing
	@Override
	public int  updateBillStatus(int orderId,int status) {
	
	int x=	orderRepository.updateBillStatus(orderId,status);
		
		
		return x;
		
		
	}

	@Override
	public List<Orders> placePustDumpOrder(List<Orders> list) {
	
		
		List<Orders> returnList = new ArrayList();
		for (Orders o : list) {

					System.out.println("Saving new order");

					Orders newOrder = orderRepository.save(o);
					
					returnList.add(newOrder);
				
						 try {
							 
							  String frToken=franchiseSupRepository.findTokenByFrId(o.getFrId());
					          Firebase.sendPushNotifForCommunication(frToken,"Order Pushed","Your savories/ cakes and pastries order not recived. A standing order has been put, against which no GVN-GRN will be given.","push");
							
					         }
					         catch(Exception e2)
					         {
						       e2.printStackTrace();
					         }
					
			}

		return returnList;
	}
}
