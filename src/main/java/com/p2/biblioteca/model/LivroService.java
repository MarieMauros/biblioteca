package com.p2.biblioteca.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class LivroService {

    @Autowired
	LivroDAO cdao;

    public void inserir(Livro liv){
        cdao.inserir(liv);
    }

    public List<Map<String, Object>> obterTodosLivros(){
        return cdao.obterTodosLivros();
    }

    public void atualizarTarefa(int id, Livro liv) {
        cdao.atualizarLivro(id, liv); // Atualiza o livro no DAO
    }

    public Livro obterLivro(int id){   
        return cdao.obterLivro(id);
    }

    public void deletarLivro(int id) {
        cdao.deletarLivro(id); // Chama o DAO para deletar o livro
    }

    public void save(Livro livro){
        cdao.save(livro);
    }
}