package fr.inti.myapp.Dao;

import fr.inti.myapp.entities.Facture;

public interface IFactureDao extends IgenericDao<Facture>{

	public Facture getFactureById(Long id);
}
