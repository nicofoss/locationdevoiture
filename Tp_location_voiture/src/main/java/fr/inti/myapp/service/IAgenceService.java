package fr.inti.myapp.service;

import fr.inti.myapp.entities.Agence;

public interface IAgenceService extends IGenericService<Agence> {

	public Agence getAgenceById(Long id);

	public Agence getAgenceByName(String nom);
}
