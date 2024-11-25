package com.p2.biblioteca.model;

import java.util.Map;

public class Tool {

    // Método para converter um registro de Map em um objeto Livro
    public static Livro converterLivro(Map<String, Object> registro) {
        // Convertendo os valores do Map para os tipos apropriados e criando uma nova instância de Tarefa
        return new Livro(
            (Integer) registro.get("id"), 
            (String) registro.get("titulo"), 
            (String) registro.get("sinopse"), 
            (String) registro.get("autor"), 
            (String) registro.get("editora"), 
            (String) registro.get("ano"));
    }
}