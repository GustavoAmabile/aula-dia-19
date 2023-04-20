package com.ada.testes.model;

import com.ada.testes.repository.ProdutoRepository;
import com.ada.testes.service.ProdutoService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.MockMvcAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.JsonPath;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;

@SpringBootTest
@AutoConfigureMockMvc
public class ProdutoTest {
    @Autowired
    ProdutoService produtoService;
    @Autowired
    ProdutoRepository produtoRepository;

    private Produto produto;

    @Autowired
    private MockMvc mockMvc;

    public Produto criarProdutoTeste() throws Exception {

        String id = "1";
        String nome = "teste";
        String descricao = "teste";
        String preco = "1.0";
        Produto produto1 = new Produto(Long.parseLong(id), nome, descricao, Double.parseDouble(preco));
        return produtoRepository.save(produto1);

    }

    @Test
    public void testeListagemProdutos() throws Exception {
        Produto produto1 = criarProdutoTeste();
        String rota = "/produtos/lista";
        mockMvc.perform(MockMvcRequestBuilders.get(rota))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers
                        .jsonPath("$[0].id").value(produto1.getId()));

    }






}
