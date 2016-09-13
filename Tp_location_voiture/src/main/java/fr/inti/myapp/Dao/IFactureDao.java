package fr.inti.myapp.Dao;

import java.util.List;

import fr.inti.myapp.entities.Facture;

public interface IFactureDao{

	public Facture add(Facture facture, Long idAgence, Long idResa);
	
	public List<Facture> getAll();
	
	public Facture update(Facture facture);
	
	public Facture delete(Facture facture);
	
	public Facture getFactureById(Long id);
}
