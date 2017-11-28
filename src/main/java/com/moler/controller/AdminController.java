package com.moler.controller;

import com.moler.entity.Book;
import com.moler.entity.Client;
import com.moler.service.BookService;
import com.moler.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    ClientService clientService;

    @Autowired
    BookService bookService;

    @GetMapping("")
    public String adminPanel(){
        return "admin";
    }

    @GetMapping("/addClient")
    public String addNewClient(Model model){
        Client client = new Client();
        model.addAttribute("client", client);
        return "client-form";
    }

    @PostMapping("/saveClient")
    public String saveClient(@ModelAttribute("client") Client client){
        clientService.saveClient(client);
        return "redirect:/admin/clientList";
    }

    @GetMapping("/addNewBook")
    public String addNewBook(Model model){
        Book book = new Book();
        model.addAttribute("book", book);
        return "book-form";
    }

    @PostMapping("/saveBook")
    public String saveBook(@ModelAttribute("book") Book book){
        bookService.saveBook(book);
        return "redirect:/admin/bookList";
    }

    @GetMapping("/bookList")
    public String listBooks(Model model){
        List<Book> books = bookService.getBooks();
        model.addAttribute("books", books);
        return "list-books";
    }

    @GetMapping("/deleteBook")
    public String deleteBook(@RequestParam("bookId") int id){
        bookService.deleteBook(id);
        return "redirect:/admin/bookList";
    }

    @GetMapping("/updateBook")
    public String updateBook(@RequestParam("bookId") int id, Model model){
        Book book = bookService.getBook(id);
        model.addAttribute(book);
        return "book-form";
    }

    @GetMapping("/deleteClient")
    public String deleteClient(@RequestParam("clientId") int id){
        clientService.deleteClient(id);
        return "redirect:/admin/clientList";
    }

    @GetMapping("/updateClient")
    public String updateClient(@RequestParam("clientId") int id, Model model){
        Client client = clientService.getClientById(id);
        model.addAttribute(client);
        return "client-form";
    }

    @GetMapping("/clientList")
    public String listClients(Model model){
        List<Client> clients = clientService.getClients();
        model.addAttribute("clients", clients);
        return "list-clients";
    }


}
