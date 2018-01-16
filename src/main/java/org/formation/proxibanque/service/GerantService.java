package org.formation.proxibanque.service;

import java.util.List;

import org.formation.proxibanque.config.Config;
import org.formation.proxibanque.dao.DaoException;
import org.formation.proxibanque.dao.IDaoConseiller;
import org.formation.proxibanque.dao.IDaoEmployee;
import org.formation.proxibanque.entity.Agence;
import org.formation.proxibanque.entity.Client;
import org.formation.proxibanque.entity.ClientEntreprise;
import org.formation.proxibanque.entity.ClientParticulier;
import org.formation.proxibanque.entity.CompteCourant;
import org.formation.proxibanque.entity.Conseiller;
import org.formation.proxibanque.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Classe qui regroupe tous les traitements concernant un Gerant courrant. -
 * Ajouter un conseiller Audit
 * 
 * mDaoAgence est utilise ici pour Chercher ou Modifier l'information dans
 * persistance *
 * 
 * @author JW
 *
 */

@Service
public class GerantService implements IGerantService {

	@Autowired
    private PasswordEncoder passwordEncoder;
	
	@Autowired
	private IDaoConseiller daoConseiller;
	
	@Autowired
	private IDaoEmployee daoEmployee;

	public GerantService() {
		super();
	}

	@Override
	public Conseiller chercherConseiller(Long idConseiller) throws DaoException {
		return daoConseiller.findOne(idConseiller);
	}

	@Override
	public void ajouterConseiller(Conseiller conseiller) throws DaoException {
		
		conseiller.setPassword(passwordEncoder.encode(conseiller.getPassword()));
		
		
		daoConseiller.save(conseiller);

		// Strategy local de generer reference conseiller automatique
		if (conseiller.getRefEmployee().isEmpty())
			conseiller.setRefEmployee(Config.PREFIX_CONS_REF + conseiller.getId());

		daoConseiller.save(conseiller);
	}

	@Override
	public void modifierConseiller(Conseiller conseiller) throws DaoException {
		daoConseiller.save(conseiller);
	}

	@Override
	public void supprimerConseiller(Conseiller conseiller) throws DaoException {
		daoConseiller.delete(conseiller);
	}

	@Override
	public List<Conseiller> listerTousClientsDuGerant(Long idGerent) throws DaoException {
		
		return daoConseiller.findByGerantId(idGerent);      
	}

	/**
	 * Methode d'audit sur un agence selon les regle,
	 * 
	 * @param a
	 *            : l'agence a auditer
	 * @param listDebiteurs
	 *            : liste de debiteurs
	 * @return : si audit est reussi (pas de debiteur) ou pas
	 */
	@Override
	public boolean faireAudite(Agence a, List<Client> listDebiteurs) {

		boolean hasDebiteurs = false;

		for (Conseiller con : a.getGerant().getConseillerList()) {
			for (Client clt : con.getClientsList()) {

				if (clt instanceof ClientParticulier
						&& clt.getCompteCourant().getSolde() < CompteCourant.MAXI_DECOUVERT_PARTICULIER) {
					listDebiteurs.add(clt);
					hasDebiteurs = true;
				}
				if (clt instanceof ClientEntreprise
						&& clt.getCompteCourant().getSolde() < CompteCourant.MAXI_DECOUVERT_ENTREPRISE) {
					listDebiteurs.add(clt);
					hasDebiteurs = true;
				}

			}
		}

		return !hasDebiteurs;
	}

}
