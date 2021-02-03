package com.chase.main.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.chase.main.models.Tv;
import com.chase.main.repos.TvRepo;

@Service
public class TvService {
	//adding the language repository as a dependency
	private final TvRepo tvRepo;
	
	public TvService(TvRepo tvRepo) {
		this.tvRepo = tvRepo;
	}
	
	//return all languages
	public List<Tv> allShows(){
		return tvRepo.findAll();
	}
	
	//create a language
	public Tv createShow(Tv tv) {
		return tvRepo.save(tv);
	}
	
	//find a language
	public Tv findShow(Long id) {
		Optional<Tv> lang = tvRepo.findById(id);
		if(lang.isPresent()) {
			return lang.get();
		}else {
			return null;
		}
	}
	
	//delete a language
	public void destroyLanguage(Long id) {
		Optional<Tv> lang = tvRepo.findById(id);
		if(lang.isPresent()) {
			tvRepo.deleteById(id);
		}
	}

	public List<Tv> showsContainingNetwork(String network) {
		return tvRepo.findByNetworkContaining(network);
	}
	
	public List<Tv> topTenSongs(){
		return tvRepo.findTop10ByOrderByRatingDesc();
	}
}