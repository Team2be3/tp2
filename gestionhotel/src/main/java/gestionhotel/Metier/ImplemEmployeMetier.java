package gestionhotel.Metier;

import gestionhotel.DAO.InterEmployeDao;
import gestionhotel.entities.Employe;

import java.util.List;

import org.apache.log4j.Logger;

public class ImplemEmployeMetier implements InterEmployeMetier {
	
	private final Logger LOG=Logger.getLogger("ImplemClientMetier");
	private InterEmployeDao daoEmploye;
	
	
	//setters  
	public void setDaoEmploye(InterEmployeDao daoEmploye) {
		this.daoEmploye = daoEmploye;
		LOG.info("dao employe injected");
	}

	@Override
	public void addEmploye(Employe e) {
		daoEmploye.addEmploye(e);
	}

	@Override
	public void deleteEmploye(Long idEmploye) {
		daoEmploye.deleteEmploye(idEmploye);
	}

	@Override
	public void updateEmploye(Employe e) {
		daoEmploye.updateEmploye(e);
	}

	@Override
	public Employe getEmploye(Long idEmploye) {
		return daoEmploye.getEmploye(idEmploye);
	}

	@Override
	public List<Employe> getListEmploye() {
		return daoEmploye.getListEmploye();
	}

	@Override
	public List<Employe> getListEmpMc(String mc) {
		return daoEmploye.getListEmpMc(mc);
	}

}
