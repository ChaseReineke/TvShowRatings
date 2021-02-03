package com.chase.main.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chase.main.models.Tv;

@Repository
public interface TvRepo extends CrudRepository<Tv, Long> {
	// this method retrieves all the languages from the database
	List<Tv> findAll();
	
	// find artist based on certain criteria
	List<Tv> findByNetworkContaining(String search); 
	
	// query top 10 by rating
	List<Tv> findTop10ByOrderByRatingDesc(); 
}