package fr.inti.myapp.Dao;

import fr.inti.myapp.entities.Agence;

public interface IAgenceDao extends IgenericDao<Agence>{

	public Agence getAgenceById(Long id);
	
	public Agence getAgenceByName(String nom);
	
	
}
