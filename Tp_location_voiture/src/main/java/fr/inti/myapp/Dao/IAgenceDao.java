package fr.inti.myapp.Dao;

import java.util.List;

import fr.inti.myapp.entities.Agence;

public interface IAgenceDao{
	
	public Agence add(Agence agence);
	
	public List<Agence> getAll();
	
	public Agence update(Agence agence);
	
	public Agence delete(Agence agence);

	public Agence getAgenceById(Long id);
	
	public Agence getAgenceByName(String nom);
	 
}
