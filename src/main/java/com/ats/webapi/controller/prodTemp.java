package com.ats.webapi.controller;

public class prodTemp {
/*
 * report 2 on t_sp_cake_sup 
frName,itemName, actWt,prodWt [diff]

SELECT t_sp_cake_sup.t_sp_cake_sup_no,m_franchisee.fr_name,m_franchisee.fr_code,
m_sp_cake.sp_code,m_sp_cake.sp_name,t_sp_cake_sup.input_kg_fr,t_sp_cake_sup.input_kg_prod,
(t_sp_cake_sup.input_kg_prod-t_sp_cake_sup.input_kg_fr) as weight_diff FROM t_sp_cake_sup,m_franchisee,m_sp_cake
WHERE t_sp_cake_sup.date BETWEEN '2018-10-01' AND '2018-10-10' AND t_sp_cake_sup.fr_id=m_franchisee.fr_id
AND t_sp_cake_sup.sp_cake_id=m_sp_cake.sp_id



report 3 group by mist id
mistryName noOfCakes minutesRequired
a] t_sp_cake_sup
SELECT t_sp_cake_sup.mistry_id,m_emp.emp_name,COUNT(t_sp_cake_sup.t_sp_cake_sup_no) AS no_of_cakes,SUM(t_sp_cake_sup.ex_var) AS time_required FROM t_sp_cake_sup,m_emp WHERE t_sp_cake_sup.mistry_id=m_emp.emp_id AND t_sp_cake_sup.date BETWEEN '2018-10-01' AND '2018-10-10' GROUP BY t_sp_cake_sup.mistry_id 

b] t_reg_sp_cake_sup
SELECT t_reg_sp_cake_sup.mistry_id,m_emp.emp_name,COUNT(t_reg_sp_cake_sup.sup_id) AS no_of_cakes,SUM(t_reg_sp_cake_sup.ex_char) AS time_required FROM t_reg_sp_cake_sup,m_emp WHERE t_reg_sp_cake_sup.mistry_id=m_emp.emp_id AND t_reg_sp_cake_sup.prod_date BETWEEN '2018-10-01' AND '2018-10-10' GROUP BY t_reg_sp_cake_sup.mistry_id 


report 4 group by date
mistryName noOfCakes minutesRequired
a] t_sp_cake_sup
SELECT t_sp_cake_sup.mistry_id,m_emp.emp_name,COUNT(t_sp_cake_sup.t_sp_cake_sup_no) AS no_of_cakes,SUM(t_sp_cake_sup.ex_var) AS time_required 
FROM t_sp_cake_sup,m_emp 
WHERE t_sp_cake_sup.mistry_id=m_emp.emp_id AND t_sp_cake_sup.date BETWEEN '2018-10-01' AND '2018-10-10' GROUP BY t_sp_cake_sup.date,t_sp_cake_sup.mistry_id

b] _reg_sp_cake_sup
SELECT t_reg_sp_cake_sup.mistry_id,m_emp.emp_name,COUNT(t_reg_sp_cake_sup.sup_id) AS no_of_cakes,SUM(t_reg_sp_cake_sup.ex_char) AS time_required 
FROM t_reg_sp_cake_sup,m_emp 
WHERE t_reg_sp_cake_sup.mistry_id=m_emp.emp_id AND t_reg_sp_cake_sup.prod_date BETWEEN '2018-10-01' AND '2018-10-10' GROUP BY t_reg_sp_cake_sup.prod_date,t_reg_sp_cake_sup.mistry_id

report 5 no group by

mistryName cakeName i/pkg,op/kg,starttime,endtime,diff
a] t_sp_cake_sup
SELECT t_sp_cake_sup.t_sp_cake_sup_no,m_franchisee.fr_name,m_franchisee.fr_code,m_emp.emp_name,
m_sp_cake.sp_code,m_sp_cake.sp_name,t_sp_cake_sup.input_kg_fr,t_sp_cake_sup.input_kg_prod,
(t_sp_cake_sup.input_kg_prod-t_sp_cake_sup.input_kg_fr) as weight_diff,t_sp_cake_sup.start_time_stamp,t_sp_cake_sup.end_time_stamp FROM t_sp_cake_sup,m_franchisee,m_sp_cake,m_emp
WHERE t_sp_cake_sup.date BETWEEN '2018-10-01' AND '2018-10-10' AND t_sp_cake_sup.fr_id=m_franchisee.fr_id
AND t_sp_cake_sup.sp_cake_id=m_sp_cake.sp_id AND t_sp_cake_sup.mistry_id=m_emp.emp_id
b] _reg_sp_cake_sup
SELECT t_reg_sp_cake_sup.sup_id,m_franchisee.fr_name,m_franchisee.fr_code,m_emp.emp_name, m_item.item_id,m_item.item_name,t_reg_sp_cake_sup.input_kg_prod, t_reg_sp_cake_sup.start_time,t_reg_sp_cake_sup.end_time FROM t_reg_sp_cake_sup,m_franchisee,m_item,m_emp WHERE t_reg_sp_cake_sup.prod_date BETWEEN '2018-10-01' AND '2018-10-10' AND t_reg_sp_cake_sup.fr_id=m_franchisee.fr_id AND t_reg_sp_cake_sup.item_id=m_item.id AND t_reg_sp_cake_sup.mistry_id=m_emp.emp_id 



report 6 fd,td,frIdList/all where exInt=1 on t_sp_cake_sup
frName,spCakename date 
SELECT t_sp_cake_sup.t_sp_cake_sup_no,m_franchisee.fr_name,m_franchisee.fr_code,t_sp_cake_sup.date as prod_date, m_sp_cake.sp_code,m_sp_cake.sp_name FROM t_sp_cake_sup,m_franchisee,m_sp_cake WHERE t_sp_cake_sup.date BETWEEN '2018-10-01' AND '2018-10-10' AND t_sp_cake_sup.fr_id=m_franchisee.fr_id AND t_sp_cake_sup.fr_id IN (76,17) AND t_sp_cake_sup.ex_int=1 AND t_sp_cake_sup.sp_cake_id=m_sp_cake.sp_id 

 */
}
