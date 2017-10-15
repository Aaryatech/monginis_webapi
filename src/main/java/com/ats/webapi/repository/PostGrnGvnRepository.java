package com.ats.webapi.repository
;import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.webapi.model.GrnGvn;

public interface PostGrnGvnRepository extends JpaRepository<GrnGvn, Integer> {
	
	public List<GrnGvn> save(List<GrnGvn> grnGvn);
	

}
