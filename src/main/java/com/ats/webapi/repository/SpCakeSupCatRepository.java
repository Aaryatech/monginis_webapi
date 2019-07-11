package com.ats.webapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.webapi.model.SpCakeSupplement;
import com.ats.webapi.model.SpCakeSupplementCat;

public interface SpCakeSupCatRepository extends JpaRepository<SpCakeSupplementCat, Integer> {

	SpCakeSupplementCat saveAndFlush(SpCakeSupplementCat spCakeSupplementCat);

}
