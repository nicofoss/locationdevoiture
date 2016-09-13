package fr.inti.myapp.service;

import java.util.List;

import fr.inti.myapp.entities.Voiture;

public interface IVoitureService {

	public Voiture add(Voiture v, Long idAgence);

	public List<Voiture> getAll();

	public Voiture update(Voiture v);

	public Voiture delete(Voiture v);

	public Voiture getVoitureById(Long id);
}
