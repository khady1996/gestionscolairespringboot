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

@Controller
public class StaticController {

	@Autowired
	IEtudiantService ietudiantservice;

	@Bean
	public EtudiantService ietudiantservice() {
		return new EtudiantService();

	}

	public StaticController() {
		super();
	}

	public StaticController(IEtudiantService iformationService) {
		super();
		this.ietudiantservice = iformationService;
	}

	@RequestMapping("/listeEtudiants")
	public String listeEtudiants(Model model) {
		System.out.println("entree dans la methode listeEtudiants");
		model.addAttribute("listeEtudiants", ietudiantservice.findAll());
		return "listeEtudiants";
	}

	@RequestMapping("/listeCours")
	public String listeCours(Model model) {
		System.out.println("entree dans la methode listeEtudiants");
		model.addAttribute("listeCours", ietudiantservice.findAllCours());
		return "listeCours";
	}	

	@RequestMapping("/accueil")
	public String accueil() {
		System.out.println("entree dans la methode accueil");
//		model.addAttribute("liste", ietudiantservice.findAll());
		return "accueil";
	}

	@RequestMapping("/")
	public String home() {
		System.out.println("entree dans la methode home");
//		model.addAttribute("liste", ietudiantservice.findAll());
		return "index";
	}

	@PostMapping("/lierEtudiantCours")
	public String lierEtudiantCours(Etudiant etudiant, Cours cours) {
		System.out.println("entree dans la methode ajouterEtudiant");
		ietudiantservice.mergeEtudiantCours(etudiant, cours);
		return "messageAjoutEtudiantCours";
	}

	@GetMapping("getFormAjoutEtudiant")
	public String getFormAjoutEtudiant() {
		return "ajouterEtudiant";
	}

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
	
	@GetMapping("/")
	public String getFormLogin() {
		return "index";
	}

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
	
	@GetMapping("getFormLireEtudiant")
	public String getFormLireEtudiant() {
		return "searchEtudiant";
	}

	@PostMapping("/readEtudiant") // it only support port method
	public String readEtudiant(@RequestParam("idEtudiant") int id,
			Model model) {
		model.addAttribute("etudiant", ietudiantservice.lireEtudiant(id));
		return "detailEtudiant"; // welcome is view name. It will call welcome.jsp
	}
	
	
	
	@GetMapping("getFormModifierEtudiant")
	public String getFormModifierEtudiant() {
		return "rechercheModificationEtudiant";
	}

	@PostMapping("/udpateEtudiant") // it only support port method
	public String udpateEtudiant(@RequestParam("nom") String nom, @RequestParam("prenom") String prenom,
			@RequestParam("telephone") int telephone, @RequestParam("adresse") String adresse,
			@RequestParam("mail") String mail, @RequestParam("dateNaissance") String dateNaissance, Etudiant etudiant,
			ModelMap modelMap) {
		etudiant.setNom(nom);
		etudiant.setPrenom(prenom);
		etudiant.setAdresse(adresse);
		etudiant.setTelephone(telephone);
		etudiant.setDateNaissance(dateNaissance);
		ietudiantservice.save(etudiant);
		modelMap.addAttribute("etudiant", ietudiantservice.lireEtudiant(id));
		return "modificationEtudiant"; // welcome is view name. It will call welcome.jsp
	}
	

}
