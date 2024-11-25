package com.p2.biblioteca.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.p2.biblioteca.model.Livro;
import com.p2.biblioteca.model.LivroService;
import com.p2.biblioteca.model.Tool;

@Controller
public class CadastroController {

    @Autowired
    private LivroService ls; // Usando o nome correto "ls"
    
    @GetMapping("/")
    public String principal() {
        return "principal";
}

    @GetMapping("/atualizar/{id}")
    public String atualizar(Model model, @PathVariable int id) {
        Livro liv = ls.obterLivro(id);
        model.addAttribute("id", id);
        model.addAttribute("livro", liv);
        return "atualizar";
    }

    @PostMapping("/atualizar/{id}")
    public String atualizar(@PathVariable int id, @ModelAttribute Livro liv) {
        ls.atualizarTarefa(id, liv); // Chama o serviço para atualizar
        return "redirect:/listagem"; // Redireciona para a lista de livros
    }

    @GetMapping("/cadastro")
    public String cadastro(Model model) {
        model.addAttribute("livro", new Livro("", "", "", "", ""));
        return "cadastro";
    }

    @PostMapping("/cadastro")
    public String cadastrar(Model model, @ModelAttribute Livro liv) {
        ls.inserir(liv);
        return "sucesso";  // Certifique-se de que a página "sucesso" exista
    }

    @GetMapping("/listagem")
    public String listagem(Model model) {
        List<Map<String, Object>> lista = ls.obterTodosLivros();
        List<Livro> listaLivros = new ArrayList<>();
        for (Map<String, Object> registro : lista) {
            listaLivros.add(Tool.converterLivro(registro));
        }
        model.addAttribute("livro", listaLivros);
        return "listagem";
    }

    @PostMapping("/deletar/{id}")
    public String deletar(@PathVariable int id) {
        ls.deletarLivro(id);
        return "redirect:/listagem";
    }

    @GetMapping("/sobre")
    public String sobre() {
        return "sobre";
    }

    
}