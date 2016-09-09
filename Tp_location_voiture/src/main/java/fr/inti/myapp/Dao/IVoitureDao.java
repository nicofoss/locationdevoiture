package fr.inti.myapp.Dao;

import fr.inti.myapp.entities.Voiture;

public interface IVoitureDao extends IgenericDao<Voiture>{

	
	public Voiture getVoitureById(Long id);
}
