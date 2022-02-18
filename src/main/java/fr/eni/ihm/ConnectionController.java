package fr.eni.ihm;

import fr.eni.bll.ConnectionService;

import fr.eni.bo.Membre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ConnectionController {

    @Autowired
    ConnectionService connectionService;

    @GetMapping("/connexion")
    public String goConnexion(Model model) {
        Membre membre = new Membre();
        model.addAttribute("membreForm", membre);

        return "connexion";
    }

    @PostMapping("connexion")
    public String seConnecter(@ModelAttribute("filmForm") Membre membreForm, Model model) {
        model.addAttribute("membreForm", membreForm);
        connectionService.seConnecter(membreForm);

        this.connectionService.seConnecter(membreForm);

        return "index";
    }

    @GetMapping("deconnexion")
    public String seDeconnecter() {
        this.connectionService.seDeconnecter();

        return "index";

    }

    public void getUtilisateurConnecte() {
        System.out.println(this.connectionService.getMembreConnecte());
    }

}
