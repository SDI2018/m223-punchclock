package ch.zli.m223.punchclock.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ch.zli.m223.punchclock.domain.Kategorie;
import ch.zli.m223.punchclock.repository.KategorieRepository;

@Service
public class KategorieService {
	
	private KategorieRepository kategorieRepository;
	
	public KategorieService (KategorieRepository kategorieRepository) {
		this.kategorieRepository = kategorieRepository;
	}
	
	
	public Kategorie createKategorie(Kategorie kategorie) {
		return kategorieRepository.saveAndFlush(kategorie);
	}

	
	public List<Kategorie> findAll(){
		return kategorieRepository.findAll();
	}
	
}
