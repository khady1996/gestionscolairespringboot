package eu.ensup.gestionscolairespringboot.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import eu.ensup.gestionscolairespringboot.domaine.Cours;
import eu.ensup.gestionscolairespringboot.domaine.Direction;
import eu.ensup.gestionscolairespringboot.domaine.Etudiant;

/**
 * @author Khady, Benjamin and David
 *
 */
@Controller
public class StaticController {

	@Autowired
	IEtudiantService ietudiantservice;

	/**
	 * @return
	 */
	@Bean
	public EtudiantService ietudiantservice() {
		return new EtudiantService();

	}

	/**
	 * 
	 */
	public StaticController() {
		super();
	}

	/**
	 * @param iformationService
	 */
	public StaticController(IEtudiantService iformationService) {
		super();
		this.ietudiantservice = iformationService;
	}

	/**
	 * @param model
	 * @return
	 */
	@RequestMapping("/listeEtudiants")
	public String listeEtudiants(Model model) {
		System.out.println("entree dans la methode listeEtudiants");
		model.addAttribute("listeEtudiants", ietudiantservice.findAll());
		return "listeEtudiants";
	}

	/**
	 * @param model
	 * @return
	 */
	@RequestMapping("/listeCours")
	public String listeCours(Model model) {
		System.out.println("entree dans la methode listeEtudiants");
		model.addAttribute("listeCours", ietudiantservice.findAllCours());
		return "listeCours";
	}	

	/**
	 * @return
	 */
	@RequestMapping("/accueil")
	public String accueil() {
		System.out.println("entree dans la methode accueil");
//		model.addAttribute("liste", ietudiantservice.findAll());
		return "accueil";
	}

	/**
	 * @return
	 */
	@RequestMapping("/")
	public String home() {
		System.out.println("entree dans la methode home");
//		model.addAttribute("liste", ietudiantservice.findAll());
		return "index";
	}

	/**
	 * @param etudiant
	 * @param cours
	 * @return
	 */
	@PostMapping("/lierEtudiantCours")
	public String lierEtudiantCours(Etudiant etudiant, Cours cours) {
		System.out.println("entree dans la methode ajouterEtudiant");
		ietudiantservice.mergeEtudiantCours(etudiant, cours);
		return "messageAjoutEtudiantCours";
	}

	/**
	 * @return
	 */
	@GetMapping("getFormAjoutEtudiant")
	public String getFormAjoutEtudiant() {
		return "ajouterEtudiant";
	}

	/**
	 * @param nom
	 * @param prenom
	 * @param telephone
	 * @param adresse
	 * @param mail
	 * @param dateNaissance
	 * @param etudiant
	 * @param modelMap
	 * @return
	 */
	@PostMapping("/saveEtudiant") // it only support port method
	public String saveEtudiant(@RequestParam("nom") String nom, @RequestParam("prenom") String prenom,
			@RequestParam("telephone") int telephone, @RequestParam("adresse") String adresse,
			@RequestParam("mail") String mail, @RequestParam("dateNaissance") String dateNaissance, Etudiant etudiant,
			ModelMap modelMap) {
		etudiant.setNom(nom);
		etudiant.setPrenom(prenom);
		etudiant.setAdresse(adresse);
		etudiant.setTelephone(telephone);
		etudiant.setDateNaissance(dateNaissance);
		ietudiantservice.save(etudiant);
		// write your code to save details
		// modelMap.put("employeeName", employeeName);
		// modelMap.put("employeeEmail", employeeEmail);
		return "listeEtudiants"; // welcome is view name. It will call welcome.jsp
	}
	
	/**
	 * @return
	 */
	@GetMapping("/")
	public String getFormLogin() {
		return "index";
	}

	/**
	 * @param password
	 * @param login
	 * @param direction
	 * @param modelMap
	 * @return
	 */
	@PostMapping("/login") // it only support port method
	public String login(
			@RequestParam("password") String password, 
			@RequestParam("login") String login,
			Direction direction,
			ModelMap modelMap) {
		direction.setPassword(password);
		direction.setLogin(login);
		ietudiantservice.connexion(direction);
		// write your code to save details
		// modelMap.put("employeeName", employeeName);
		// modelMap.put("employeeEmail", employeeEmail);
		return "accueil"; // welcome is view name. It will call welcome.jsp
	}
	
	/**
	 * @return
	 */
	@GetMapping("getFormLireEtudiant")
	public String getFormLireEtudiant() {
		return "searchEtudiant";
	}

	/**
	 * @param id
	 * @param model
	 * @return
	 */
	@PostMapping("/readEtudiant") // it only support port method
	public String readEtudiant(@RequestParam("idEtudiant") int id,
			Model model) {
		model.addAttribute("etudiant", ietudiantservice.lireEtudiant(id));
		return "detailEtudiant"; // welcome is view name. It will call welcome.jsp
	}
	
	
	
	/**
	 * @return
	 */
	@GetMapping("getFormModifierEtudiant")
	public String getFormModifierEtudiant() {
		return "rechercheModificationEtudiant";
	}

	/**
	 * @param id
	 * @param model
	 * @return
	 */
	@PostMapping("/readUpdateEtudiant") // it only support port method
	public String readUpdateEtudiant(@RequestParam("idEtudiant") int id,
			Model model) {
		model.addAttribute("etudiant", ietudiantservice.lireEtudiant(id));
		return "modificationEtudiant"; // welcome is view name. It will call welcome.jsp
	}
	
	/**
	 * @param idEtudiant
	 * @param nom
	 * @param prenom
	 * @param telephone
	 * @param adresse
	 * @param mail
	 * @param dateNaissance
	 * @param etudiant
	 * @param modelMap
	 * @return
	 */
	@PostMapping("/udpateEtudiant") // it only support port method
	public String udpateEtudiant(@RequestParam("idEtudiant") int idEtudiant, @RequestParam("nom") String nom, @RequestParam("prenom") String prenom,
			@RequestParam("telephone") int telephone, @RequestParam("adresse") String adresse,
			@RequestParam("mail") String mail, @RequestParam("dateNaissance") String dateNaissance, Etudiant etudiant,
			ModelMap modelMap) {
		etudiant.setId(idEtudiant);
		etudiant.setNom(nom);
		etudiant.setPrenom(prenom);
		etudiant.setAdresse(adresse);
		etudiant.setTelephone(telephone);
		etudiant.setDateNaissance(dateNaissance);
		ietudiantservice.update(etudiant);
		return "listeEtudiants"; // welcome is view name. It will call welcome.jsp
	}
	

	/**
	 * @return
	 */
	@GetMapping("getFormSupprimerEtudiant")
	public String getFormSupprimerEtudiant() {
		return "suppressionEtudiant";
	}
	/**
	 * @param idEtudiant
	 * @param etudiant
	 * @param modelMap
	 * @return
	 */
	@PostMapping("/deleteEtudiant") // it only support port method
	public String deleteEtudiant(@RequestParam("idEtudiant") int idEtudiant, Etudiant etudiant,
			ModelMap modelMap) {
		etudiant.setId(idEtudiant);		
		ietudiantservice.delete(etudiant);
		return "messageSuppression"; // welcome is view name. It will call welcome.jsp
	}
}
