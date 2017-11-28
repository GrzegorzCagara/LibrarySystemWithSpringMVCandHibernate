package com.moler.controller;

import com.moler.entity.Book;
import com.moler.entity.Client;
import com.moler.service.BookService;
import com.moler.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping
public class ClientController {

    private Client loggedClient;

    @Autowired
    ClientService clientService;

    @Autowired
    BookService bookService;

    @GetMapping
    public String helloWorld(){
        return "hello";
    }

    @GetMapping("/addClient")
    public String showFormForAddClient(Model model){
        Client clinet = new Client();
        model.addAttribute("client", clinet);
        return "client-form";
    }

    @GetMapping("/login")
    public String loginClient(Model model){
        Client client = new Client();
        model.addAttribute("client", client);
        return "login";
    }

    @PostMapping("/login")
        public String login(@Valid Client client){
        List<Client> clients = clientService.getClients();
        for (Client client1 : clients) {
            if(client.getLogin().equals("admin") && client.getPassword().equals("admin")){
                return "redirect:/admin";
            }
            if(client.getLogin().equals(client1.getLogin()) && client.getPassword().equals(client1.getPassword())){
                loggedClient = client1;
                return "redirect:/clientPanel";
            }
        }
        return "redirect:/login";
    }

    @PostMapping("/saveClient")
    public String saveClient(@ModelAttribute("client") Client client){
        clientService.saveClient(client);
        return "redirect:/clientList";
    }

    @GetMapping("/clientPanel")
    public String clientPanel(@ModelAttribute("client") Client client){
        return "client-panel";
    }

    @GetMapping("/bookList")
    public String listBooks(Model model){
        List<Book> books = bookService.getBooks();
        model.addAttribute("books", books);
        return "books-for-client";
    }

    @GetMapping("/reservation")
    public String bookReservation(@RequestParam("bookId") int id){
        System.out.println("client Id " + loggedClient.getId());
        System.out.println("book Id " + id);
        clientService.reserveBook(id, loggedClient.getId());
        return "redirect:/reservedBooks";
    }

    @GetMapping("/reservedBooks")
    public String reservedBook(){
        return "reserved-book";
    }
}
