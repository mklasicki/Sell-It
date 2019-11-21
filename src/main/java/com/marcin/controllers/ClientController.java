package com.marcin.controllers;


import com.marcin.domain.Client;
import com.marcin.service.CllientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;

@Controller
public class ClientController {

    private CllientService cllientService;

    public ClientController(CllientService cllientService){
        this.cllientService = cllientService;
    }

    @GetMapping("/api")
    public String mainPage(){
        return "main";
    }

    @GetMapping("/list")
    public String getClients(Model model){
        List<Client> theClients = cllientService.getClients();
        model.addAttribute("clients",theClients);
        return "client-list";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){
    Client theClient = new Client();
    model.addAttribute("client", theClient);
        return "client-form";
    }

    @PostMapping("/saveClient")
    public String saveClient(@ModelAttribute("client") Client theClient) {
        cllientService.saveClient(theClient);
        return "redirect:/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("clientId") int id, Model model) {
        Client theClient = cllientService.getClient(id);
        model.addAttribute("client", theClient);
        return "client-form";
    }

}
