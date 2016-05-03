package gestionhotel.DAO;

/*Auteur:Dubuc Jérémy
 *nom Projet:gestionhotel
 *date:03/05/2016
 *Package:gestionhotel.DAO
 *Interface: InterClientDao
 *Implementation : ImplemClientDao
 *version:1.
 * */

import java.util.List;

import gestionhotel.entities.Client;

public interface InterClientDao {
	
	public void addClient(Client c);
	public void deleteClient(Long idClient);
	public void updateClient(Client c);
	public Client getClient(Long idClient);
	public List<Client> getListClient();
	public List<Client> getListCliMc(String mc);
	
}
