package gestionhotel.Metier;

import gestionhotel.entities.Client;

import java.util.List;

public interface InterClientMetier {
	
	public void addClient(Client c);
	public void deleteClient(Long idClient);
	public void updateClient(Client c);
	public Client getClient(Long idClient);
	public List<Client> getListClient();
	public List<Client> getListCliMc(String mc);

}
