package fr.inti.myapp.service;

import fr.inti.myapp.entities.Facture;

public interface IFactureService extends IGenericService<Facture>{
	
	public Facture getFactureById(Long id);

}
