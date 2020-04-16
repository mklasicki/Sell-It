package com.marcin.controllers;


import com.marcin.domain.Client;
import com.marcin.service.CllientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@Controller
public class ClientController {

    private CllientService cllientService;

    public ClientController(CllientService cllientService) {
        this.cllientService = cllientService;

    }

    @GetMapping("/")
    public String mainPage() {
        return "main";
    }

    @GetMapping("/list")
    public String getClients(Model model) {
        List<Client> theClients = cllientService.getClients();
        model.addAttribute("clients", theClients);
        return "client-list";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        Client theClient = new Client();
        model.addAttribute("client", theClient);
        return "client-form";
    }

    @PostMapping("/saveClient")
    public String saveClient(@Valid @ModelAttribute("client") Client theClient, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "client-form";
        } else {
            cllientService.saveClient(theClient);
            return "redirect:/list";
        }
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("clientId") int id, Model model) {
        Client theClient = cllientService.getClient(id);
        model.addAttribute("client", theClient);
        return "client-form";
    }

    @GetMapping("/deleteClient")
    public String showFormForDelete(@RequestParam("clientId") int id, Model model) {
        cllientService.deleteCustomer(id);
        List<Client> theClients = cllientService.getClients();
        model.addAttribute("clients", theClients);
        return "client-list";
    }

    @GetMapping("/searchClient")
    public String searchClient(@RequestParam("clientId") int id, Model model) {
        Client theClient = cllientService.getClient(id);
        model.addAttribute("client", theClient);
        return "client-form";
    }
}
