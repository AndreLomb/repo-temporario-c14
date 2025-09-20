package br.c14lab.biblioteca;

import br.c14lab.biblioteca.exceptions.LivroNaoEncontradoException;
import br.c14lab.biblioteca.implementacao.LivroIMPL;
import br.c14lab.biblioteca.model.Livro;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


public class TestLivroIMPL {

    //Teste com Mock
    @Test
    public void testBuscarPorIsbnComMock() {

        LivroIMPL mockLivro = Mockito.mock(LivroIMPL.class);

        Livro livroMockado = new Livro("12345", "Livro Mockado", "Autor Mock", "Editora", 2024, 5, "Ficção");

        when(mockLivro.buscarPorIsbn("12345")).thenReturn(livroMockado);

        Livro resultado = mockLivro.buscarPorIsbn("12345");

        assertEquals("Livro Mockado", resultado.getTitulo());
    }


    @Test
    public void TesteCadastrarLivro() {
        Livro livro = new Livro("12345", "Livro Top", "Rick", "Editora Exemplo", 2024, 10, "Ficção");
        LivroIMPL livroService = new LivroIMPL();

        livroService.adicionarLivro(livro);

        assertEquals(1, livroService.getLivros().size());
    }



    @Test
    public void TesteBuscarLivroPorIsbn() {
        Livro livro = new Livro("12345", "Livro Top", "Rick", "Editora Exemplo", 2024, 10, "Ficção");
        Livro livroteste = new Livro();

        LivroIMPL livroService = new LivroIMPL();

        livroService.adicionarLivro(livro);
        livroteste = livroService.buscarPorIsbn("12345");

       assertEquals(livro,livroteste);
    }



    @Test
    public void TesteBuscarTodosOsLivros() {
        Livro livro1 = new Livro("12345", "Livro Top", "Rick", "Editora Exemplo", 2024, 10, "Ficção");
        Livro livro2 = new Livro("67890", "A Jornada do Código", "Alice", "TechBooks", 2021, 5, "Tecnologia");
        Livro livro3 = new Livro("11223", "Histórias da Meia-Noite", "Machado", "Literarte", 1894, 3, "Literatura");
        Livro livro4 = new Livro("44556", "O Segredo das Estrelas", "Clara Luz", "Cosmos Editora", 2018, 7, "Ficção Científica");
        Livro livro5 = new Livro("77889", "Matemática Divertida", "Prof. João", "EducaMais", 2020, 12, "Educação");
        Livro livro6 = new Livro("99001", "Receitas do Futuro", "Chef Ana", "Gastronomia Global", 2022, 4, "Culinária");

        LivroIMPL livroteste = new LivroIMPL();

        livroteste.adicionarLivro(livro1);
        livroteste.adicionarLivro(livro2);
        livroteste.adicionarLivro(livro3);
        livroteste.adicionarLivro(livro4);
        livroteste.adicionarLivro(livro5);
        livroteste.adicionarLivro(livro6);

        List<Livro> resultado = livroteste.buscarTodosOsLivros();

        assertEquals(6,resultado.size());
    }



    @Test
    public void TesteAtualizarLivro(){
        Livro livro1 = new Livro("12345", "Livro Top", "Rick", "Editora Exemplo", 2024, 10, "Ficção");
        Livro livroAtualizado = new Livro("12345", "Livro Atualizado", "Rick", "Editora Exemplo", 2024, 10, "Ficção");


        LivroIMPL livroteste = new LivroIMPL();

        livroteste.adicionarLivro(livro1);
        livroteste.atualizarLivro(livroAtualizado);

        Livro resultado = livroteste.buscarPorIsbn("12345");
        assertEquals(livroAtualizado,resultado);
    }



    @Test
    public void TestarLivroASerRemovido(){
        Livro livro1 = new Livro("12345", "Livro Top", "Rick", "Editora Exemplo", 2024, 10, "Ficção");
        Livro livro2 = new Livro("67890", "A Jornada do Código", "Alice", "TechBooks", 2021, 5, "Tecnologia");
        Livro livro3 = new Livro("11223", "Histórias da Meia-Noite", "Machado", "Literarte", 1894, 3, "Literatura");
        Livro livro4 = new Livro("44556", "O Segredo das Estrelas", "Clara Luz", "Cosmos Editora", 2018, 7, "Ficção Científica");
        Livro livro5 = new Livro("77889", "Matemática Divertida", "Prof. João", "EducaMais", 2020, 12, "Educação");
        Livro livro6 = new Livro("99001", "Receitas do Futuro", "Chef Ana", "Gastronomia Global", 2022, 4, "Culinária");

        LivroIMPL livroteste = new LivroIMPL();

        livroteste.adicionarLivro(livro1);
        livroteste.adicionarLivro(livro2);
        livroteste.adicionarLivro(livro3);
        livroteste.adicionarLivro(livro4);
        livroteste.adicionarLivro(livro5);
        livroteste.adicionarLivro(livro6);

        livroteste.removerLivro(livro1);

        assertEquals(5, livroteste.buscarTodosOsLivros().size());
    }



    @Test
    public void TesteBuscarPorAutor(){
        Livro livro1 = new Livro("12345", "Livro Top", "Rick", "Editora Exemplo", 2024, 10, "Ficção");
        Livro livro2 = new Livro("67890", "A Jornada do Código", "Rick", "TechBooks", 2021, 5, "Tecnologia");
        Livro livro3 = new Livro("11223", "Histórias da Meia-Noite", "Rick", "Literarte", 1894, 3, "Literatura");
        Livro livro4 = new Livro("44556", "O Segredo das Estrelas", "Clara Luz", "Cosmos Editora", 2018, 7, "Ficção Científica");
        Livro livro5 = new Livro("77889", "Matemática Divertida", "Prof. João", "EducaMais", 2020, 12, "Educação");
        Livro livro6 = new Livro("99001", "Receitas do Futuro", "Chef Ana", "Gastronomia Global", 2022, 4, "Culinária");

        LivroIMPL livroteste = new LivroIMPL();

        livroteste.adicionarLivro(livro1);
        livroteste.adicionarLivro(livro2);
        livroteste.adicionarLivro(livro3);
        livroteste.adicionarLivro(livro4);
        livroteste.adicionarLivro(livro5);
        livroteste.adicionarLivro(livro6);

       List<Livro> resultado = livroteste.buscarPorTituloOuAutor("Não sei", "Rick");

        System.out.println(resultado);
       assertEquals(3, resultado.size());
    }



    @Test
    public void TesteBuscarPorTitulo(){
        Livro livro1 = new Livro("12345", "Livro Top", "Rick", "Editora Exemplo", 2024, 10, "Ficção");
        Livro livro2 = new Livro("67890", "A Jornada do Código", "Rick", "TechBooks", 2021, 5, "Tecnologia");
        Livro livro3 = new Livro("11223", "Histórias da Meia-Noite", "Rick", "Literarte", 1894, 3, "Literatura");
        Livro livro4 = new Livro("44556", "O Segredo das Estrelas", "Clara Luz", "Cosmos Editora", 2018, 7, "Ficção Científica");
        Livro livro5 = new Livro("77889", "Matemática Divertida", "Prof. João", "EducaMais", 2020, 12, "Educação");
        Livro livro6 = new Livro("99001", "Receitas do Futuro", "Chef Ana", "Gastronomia Global", 2022, 4, "Culinária");

        LivroIMPL livroteste = new LivroIMPL();

        livroteste.adicionarLivro(livro1);
        livroteste.adicionarLivro(livro2);
        livroteste.adicionarLivro(livro3);
        livroteste.adicionarLivro(livro4);
        livroteste.adicionarLivro(livro5);
        livroteste.adicionarLivro(livro6);

        List<Livro> resultado = livroteste.buscarPorTituloOuAutor("a jornada do código", "Não sei");

        System.out.println(resultado);
        assertEquals(1, resultado.size());
    }

    @Test
    public void testException(){
        Livro livro1 = new Livro("12345", "Livro Top", "Rick", "Editora Exemplo", 2024, 10, "Ficção");
        LivroIMPL livroteste = new LivroIMPL();

        assertThrows(LivroNaoEncontradoException.class, () -> {
            livroteste.removerLivro(livro1);
        });

    }

     @Test
    public void testLivroUpdate() {
        Livro livro = new Livro("12345", "Livro Top", "Rick", "Editora Exemplo", 2024, 10, "Ficção");
        LivroIMPL livroService = new LivroIMPL();
        livroService.adicionarLivro(livro);

        Livro livroAtualizado = new Livro("12345", "Livro Atualizado", "Rick", "Editora Exemplo", 2024, 10, "Ficção");
        livroService.atualizarLivro(livroAtualizado);

        Livro resultado = livroService.buscarPorIsbn("12345");
        assertEquals("Livro Atualizado", resultado.getTitulo());
        assertEquals(livroAtualizado, resultado);
    }

    @Test
    public void testLivroUpdateException() {
        Livro livroNaoExistente = new Livro("99999", "Livro Inexistente", "Autor", "Editora", 2024, 1, "Gênero");
        LivroIMPL livroService = new LivroIMPL();

        assertThrows(LivroNaoEncontradoException.class, () -> {
            livroService.atualizarLivro(livroNaoExistente);
        });
    }

}
