package fr.inti.myapp.Dao;

import java.util.List;

import fr.inti.myapp.entities.Voiture;

public interface IVoitureDao{

	public Voiture add(Voiture v, Long idAgence);
	
	public List<Voiture> getAll();
	
	public Voiture update(Voiture v);
	
	public Voiture delete(Voiture v);
	
	public Voiture getVoitureById(Long id);
}
