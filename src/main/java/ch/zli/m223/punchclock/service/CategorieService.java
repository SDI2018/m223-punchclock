package ch.zli.m223.punchclock.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ch.zli.m223.punchclock.domain.Categorie;
import ch.zli.m223.punchclock.repository.CategorieRepository;

@Service
public class CategorieService {
	
	private CategorieRepository categorieRepository;
	
	public CategorieService (CategorieRepository categorieRepository) {
		this.categorieRepository = categorieRepository;
	}
	
	
	public Categorie createKategorie(Categorie categorie) {
		return categorieRepository.saveAndFlush(categorie);
	}

	
	public List<Categorie> findAll(){
		return categorieRepository.findAll();
	}
	
}
