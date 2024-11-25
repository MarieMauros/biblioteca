package com.p2.biblioteca.model;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class LivroDAO {
    @Autowired
    DataSource dataSource;

    @Autowired 
    JdbcTemplate jdbc;
    
    @PostConstruct
    private void initialize() {
        jdbc = new JdbcTemplate(dataSource);
    }

    public void inserir(Livro liv){
        String sql = "INSERT INTO livro(titulo, sinopse, autor, editora, ano) VALUES (?,?,?,?,?);";
        Object[] parametros = new Object[5];
        parametros[0] = liv.getTitulo();
        parametros[1] = liv.getSinopse();
        parametros[2] = liv.getAutor();
        parametros[3] = liv.getEditora();
        parametros[4] = liv.getAno();
        jdbc.update(sql, parametros);
    }

    public List<Map<String, Object>> obterTodosLivros(){
        String sql = "SELECT * from livro ORDER BY id ASC;";
        return jdbc.queryForList(sql);
    }

    public void atualizarLivro(int id, Livro liv){
        String sql = "UPDATE livro SET ";
        sql += "titulo = ?, sinopse = ?, autor = ?, editora = ?, ano = ? WHERE id = ?";
        jdbc.update(sql, liv.getTitulo(), liv.getSinopse(), liv.getAutor(), liv.getEditora(), liv.getAno(), id);
    }

    public Livro obterLivro(int id){
        String sql = "SELECT * FROM livro WHERE id = ?";
        return Tool.converterLivro(jdbc.queryForMap(sql, id));
    }

    public void deletarLivro(int id){
        String sql = "DELETE FROM livro WHERE id = ?";
        jdbc.update(sql, id);
    }

    public void save(Livro livro) {
        if (livro.getId() == 0) {
            // Se o livro não tiver id (novo livro), insere
            inserir(livro);
        } else {
            // Se o livro já tiver id (livro existente), atualiza
            atualizarLivro(livro.getId(), livro);
        }
    }
}

