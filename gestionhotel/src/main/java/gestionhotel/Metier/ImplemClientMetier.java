package gestionhotel.Metier;

import gestionhotel.DAO.InterClientDao;
import gestionhotel.entities.Client;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class ImplemClientMetier implements InterClientMetier {
	
	private final Logger LOG=Logger.getLogger("ImplemClientMetier");
	private InterClientDao daoClient;
	
	
	
	//setters
	public void setDaoClient(InterClientDao daoClient) {
		this.daoClient = daoClient;
		LOG.info("dao client injected");
	}
	
	
	@Override
	public void addClient(Client c) {
		daoClient.addClient(c);
	}

	@Override
	public void deleteClient(Long idClient) {
		daoClient.deleteClient(idClient);
	}

	@Override
	public void updateClient(Client c) {
		daoClient.updateClient(c);
	}

	@Override
	public Client getClient(Long idClient) {
		return daoClient.getClient(idClient);
	}

	@Override
	public List<Client> getListClient() {
		return daoClient.getListClient();
	}

	@Override
	public List<Client> getListCliMc(String mc) {
		return daoClient.getListCliMc(mc);
	}

}
