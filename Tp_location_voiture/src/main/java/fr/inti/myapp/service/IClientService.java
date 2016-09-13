package fr.inti.myapp.service;

import java.util.List;

import fr.inti.myapp.entities.Client;

public interface IClientService {

	public Client add(Client c, Long idAgence);

	public List<Client> getAll();

	public Client update(Client c);

	public Client delete(Client c);

	public Client getClientById(Long id);

}
