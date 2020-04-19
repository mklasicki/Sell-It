package com.marcin.controllers;


import com.marcin.domain.Category;
import com.marcin.domain.Client;
import com.marcin.facades.CategoryFacade;
import com.marcin.service.ClientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@Controller
public class ClientController {

    private final ClientService clientService;

    private final CategoryFacade categoryFacade;

    public ClientController(ClientService clientService, CategoryFacade categoryFacade) {
        this.clientService = clientService;
        this.categoryFacade = categoryFacade;
    }

    @GetMapping("/")
    public String mainPage(Model model) {
        List<Category> categories = categoryFacade.getAllCategories();
        model.addAttribute("categories", categories);
        return "main";
    }

    @GetMapping("/list")
    public String getClients(Model model) {
        List<Client> theClients = clientService.getClients();
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
            clientService.saveClient(theClient);
            return "redirect:/list";
        }
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("clientId") int id, Model model) {
        Client theClient = clientService.getClient(id);
        model.addAttribute("client", theClient);
        return "client-form";
    }

    @GetMapping("/deleteClient")
    public String showFormForDelete(@RequestParam("clientId") int id, Model model) {
        clientService.deleteCustomer(id);
        List<Client> theClients = clientService.getClients();
        model.addAttribute("clients", theClients);
        return "client-list";
    }

    @GetMapping("/searchClient")
    public String searchClient(@RequestParam("clientId") int id, Model model) {
        Client theClient = clientService.getClient(id);
        model.addAttribute("client", theClient);
        return "client-form";
    }
}
