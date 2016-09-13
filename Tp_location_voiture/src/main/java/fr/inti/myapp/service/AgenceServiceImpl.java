package fr.inti.myapp.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.transaction.annotation.Transactional;

import fr.inti.myapp.Dao.IAgenceDao;
import fr.inti.myapp.entities.Agence;
import fr.inti.myapp.entities.Client;
import fr.inti.myapp.entities.Facture;
import fr.inti.myapp.entities.Reservation;
import fr.inti.myapp.entities.Voiture;
import fr.inti.myapp.tools.ClientDepComp;
import fr.inti.myapp.tools.FonctionUtil;
import fr.inti.myapp.tools.VoitureNbLocComp;

@Transactional
public class AgenceServiceImpl implements IAgenceService {

	Logger log = Logger.getLogger("AgenceServiceImpl");

	private IAgenceDao dao;

	public void setDao(IAgenceDao dao) {
		this.dao = dao;
		log.info("dao agence injecte");
	}

	@Override
	public Agence add(Agence t) {

		return dao.add(t);
	}

	@Override
	public List<Agence> getAll() {

		return dao.getAll();
	}

	@Override
	public Agence update(Agence t) {

		return dao.update(t);
	}

	@Override
	public Agence delete(Agence t) {

		return dao.delete(t);
	}

	@Override
	public Agence getAgenceById(Long id) {

		return dao.getAgenceById(id);
	}

	@Override
	public Agence getAgenceByName(String nom) {

		return dao.getAgenceByName(nom);
	}

//	public List<Voiture> retourVoitureJour(Long idAgence) {
//
//		// recup de lagence et de la classe outil
//		FonctionUtil fu = new FonctionUtil();
//		Agence agence = getAgenceById(idAgence);
//
//		// recup de la date du jour au format string jj-mm-aaaa
//		String dateJour = fu.dateToString(new Date());
//
//		// recup de la liste des voitures de lagence
//		List<Voiture> listVoitureAgence = new ArrayList<Voiture>();
//		listVoitureAgence = agence.getListVoiture();
//		// instanciation de la liste des voitures retour
//		List<Voiture> listVoitureRetour = new ArrayList<Voiture>();
//
//		// on parcours chaque voiture
//		for (Voiture voiture : listVoitureAgence) {
//			// on recupere la liste de reservation pour chaque voiture
//			List<Reservation> listResa = new ArrayList<Reservation>();
//			listResa = voiture.getListReservation();
//			// on parcours tte les resa
//			if (listResa != null) {
//				for (Reservation resa : listResa) {
//					// on recup la date de retour au format string jj-mm-aaaa
//					String dateRetour = fu.dateToString(resa.getDateFin());
//					// on verifie si cette date correspond a celle du jour
//					if (dateJour.equals(dateRetour)) {
//						// si oui on ajoute la voiture a la listeretour
//						listVoitureRetour.add(voiture);
//					}
//				}// end for resa
//			} else {
//				log.info("la liste de resa est nul");
//			}
//
//		}// end for voiture
//
//		return listVoitureRetour;
//
//	}// end methode
//
//	public List<Voiture> listDispoVoiture(Long idAgence, Date dateD, Date dateF) {
//
//		// recup de lagence
//		Agence agence = getAgenceById(idAgence);
//
//		// recup de la liste des voitures de lagence
//		List<Voiture> listVoitureAgence = new ArrayList<Voiture>();
//		listVoitureAgence = agence.getListVoiture();
//		// instanciation de la liste des voitures dispo et on lui rentre tte les
//		// voiture
//		List<Voiture> listVoitureDispo = new ArrayList<Voiture>();
//		listVoitureDispo = agence.getListVoiture();
//
//		// foreach sur les voiture
//		for (Voiture voiture : listVoitureAgence) {
//			// on recupere la liste de reservation pour chaque voiture
//			List<Reservation> listResa = new ArrayList<Reservation>();
//			listResa = voiture.getListReservation();
//			// on test la list pour voir si elle nest pas nul,
//			// si elle est nul on ne fait rien : la voiture reste ds la liste
//			if (listResa != null) {
//				// si la liste nest pas nul on fait un chek sur chaque resa pour
//				// voir
//				// si elle nest pas dispo au date demande
//				for (Reservation resa : listResa) {
//					// si elle est dispo on fait rien et elle reste dans la
//					// liste
//					if (resa.getDateDebut().before(dateF)
//							&& resa.getDateFin().after(dateD)) {
//						// la voiture nest pas dispo donc on la remove
//						listVoitureDispo.remove(voiture);
//					}
//				}
//			}
//		}
//
//		return listVoitureDispo;
//	}
//
//	public Double chiffreAffaire(Long idAgence, Date dateD, Date dateF) {
//		
//		// recup de lagence
//		Agence agence = getAgenceById(idAgence);
//		//on recup la liste de resa
//		List<Reservation> listResa = new ArrayList<Reservation>();
//		listResa = agence.getListReservation();
//		//on initialise le chiffre daffaire a 0
//		Double CHAffaire = 0D;
//		
//		for (Reservation resa : listResa) {
//			CHAffaire = CHAffaire + resa.getPrixTotal();
//		}
//		
//		return CHAffaire;
//	}
//	
//	public List<Reservation> histroriqueResaClient(Long idAgence, Long idClient) {
//		
//		// recup de lagence
//		Agence agence = getAgenceById(idAgence);
//		
//		//recup du client
//		List<Client> listClient = new ArrayList<Client>();
//		listClient = agence.getListClient();
//		Client c = new Client();
//		for (Client client : listClient) {
//			if (client.getId() == idClient) {
//				c = client;
//			}
//		}
//		
//		return c.getListReservations();
//	}
//	
//	public List<Client> fidelite(Long idAgence) {
//		
//		// recup de lagence
//		Agence agence = getAgenceById(idAgence);
//		//recup de la list de client
//		List<Client> listClient = new ArrayList<Client>();
//		listClient = agence.getListClient();
//		
//		for (Client client : listClient) {
//			List<Reservation> listResa = new ArrayList<Reservation>();
//			listResa = client.getListReservations();
//			Integer depense = new Integer(0);
//			for (Reservation resa : listResa) {
//				depense = (int) (depense + resa.getPrixTotal());
//			}
//			client.setDepenseTotal(depense);		
//		}
//		
//		Collections.sort(listClient, new ClientDepComp());
//		
//		return listClient;
//		
//	}
//	
//	public List<Voiture> rendement(Long idAgence) {
//		
//		// recup de lagence
//		Agence agence = getAgenceById(idAgence);
//		//recup list voiture
//		List<Voiture> listVoiture = new ArrayList<Voiture>();
//		listVoiture = agence.getListVoiture();
//		
//		for (Voiture voiture : listVoiture) {
//			List<Reservation> listResa = new ArrayList<Reservation>();
//			listResa = voiture.getListReservation();
//			int count = 0;
//			for (Reservation resa : listResa) {
//				count = count + 1;
//			}
//			voiture.setNbLocation(count);
//		}
//		
//		Collections.sort(listVoiture, new VoitureNbLocComp());
//		
//		return listVoiture;
//		
//	}
//	
//	public Facture imprimFacture(Long idAgence, Long idResa) {
//		
//		// recup de lagence
//		Agence agence = getAgenceById(idAgence);
//		
//		//recup de la resa
//		List<Reservation> listResa = new ArrayList<Reservation>();
//		listResa = agence.getListReservation();
//		Reservation r = new Reservation();
//		for (Reservation resa : listResa) {
//			if (resa.getId() == idResa) {
//				r = resa;
//			}
//		}
//		
//		return r.getFacture();
//		
//	}
	

}













