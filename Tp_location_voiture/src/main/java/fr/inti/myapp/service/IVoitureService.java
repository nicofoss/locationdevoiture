package fr.inti.myapp.service;

import fr.inti.myapp.entities.Voiture;

public interface IVoitureService extends IGenericService<Voiture>{

	public Voiture getVoitureById(Long id);
}
