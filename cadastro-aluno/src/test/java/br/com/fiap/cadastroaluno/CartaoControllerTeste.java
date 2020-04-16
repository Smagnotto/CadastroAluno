package br.com.fiap.cadastroaluno;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.fiap.cadastroaluno.domain.Aluno;
import br.com.fiap.cadastroaluno.domain.TransacaoCartao;
import br.com.fiap.cadastroaluno.pojo.AlunoPojo;
import br.com.fiap.cadastroaluno.pojo.CreateAlunoPojo;
import br.com.fiap.cadastroaluno.pojo.CreateTransacaoCartaoPojo;
import br.com.fiap.cadastroaluno.pojo.TransacaoCartaoPojo;
import br.com.fiap.cadastroaluno.service.AlunoService;
import br.com.fiap.cadastroaluno.service.TransacaoCartaoService;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
public class CartaoControllerTeste {
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired 
	private ObjectMapper mapper;

	@MockBean
	private AlunoService alunoService;
	
	@MockBean
	private TransacaoCartaoService transacaoCartaoService;

	//listagem de transacoes de cartões
	@Test
	public void getAllTeste() throws Exception {
		

	
		// given
		@SuppressWarnings("deprecation")
		Date data1 = new Date(120,03,15,15,41);
		TransacaoCartao transacaoCartao1 = new TransacaoCartao();
		TransacaoCartaoPojo transacaoCartaoP1 = new TransacaoCartaoPojo(transacaoCartao1);
		transacaoCartaoP1.setId(1L);
		transacaoCartaoP1.setData(data1);
		transacaoCartaoP1.setDescricao("McDonalds1");
		transacaoCartaoP1.setIdAluno(333111L);
		transacaoCartaoP1.setValor(33.11);

		@SuppressWarnings("deprecation")
		Date data2 = new Date(121,03,15,15,41);
		
		TransacaoCartao transacaoCartao2 = new TransacaoCartao();
		TransacaoCartaoPojo transacaoCartaoP2 = new TransacaoCartaoPojo(transacaoCartao2);
		transacaoCartaoP2.setId(2L);
		transacaoCartaoP2.setData(data2);
		transacaoCartaoP2.setDescricao("McDonalds2");
		transacaoCartaoP2.setIdAluno(333222L);
		transacaoCartaoP2.setValor(33.22);

		
		List<TransacaoCartaoPojo> transacaoCartoes = Arrays.asList(transacaoCartaoP1,transacaoCartaoP2);
		given(transacaoCartaoService.getAll()).willReturn(transacaoCartoes);

		// when + then
		this.mockMvc.perform(get("/transacaocartoes"))
		.andExpect(status().isOk())
	    .andExpect(content().json("[{\"id\":1,\"idAluno\":333111,\"data\":\"2020-04-15T18:41:00.000+0000\",\"descricao\":\"McDonalds1\",\"valor\":33.11},{\"id\":2,\"idAluno\":333222,\"data\":\"2021-04-15T18:41:00.000+0000\",\"descricao\":\"McDonalds2\",\"valor\":33.22}]"));
	}

	
	//busca por Id
	@Test
	public void getByIdTeste() throws Exception {
		
		@SuppressWarnings("deprecation")
		Date data1 = new Date(120,03,15,15,41);
		TransacaoCartao transacaoCartao1 = new TransacaoCartao();
		TransacaoCartaoPojo transacaoCartaoP1 = new TransacaoCartaoPojo(transacaoCartao1);
		transacaoCartaoP1.setId(1L);
		transacaoCartaoP1.setData(data1);
		transacaoCartaoP1.setDescricao("McDonalds1");
		transacaoCartaoP1.setIdAluno(333111L);
		transacaoCartaoP1.setValor(33.11);

		given(transacaoCartaoService.findById(1L)).willReturn(transacaoCartaoP1);

		// when + then
		this.mockMvc.perform(get("/transacaocartoes/1"))
		.andExpect(status().isOk())
		.andExpect(content().json("{\"id\":1,\"idAluno\":333111,\"data\":\"2020-04-15T18:41:00.000+0000\",\"descricao\":\"McDonalds1\",\"valor\":33.11}"));
	}

	
	//criação de aluno
	  @Test
	  public void createTeste() throws Exception {
		    CreateTransacaoCartaoPojo cTransacaoCartaoP = new CreateTransacaoCartaoPojo();
		    @SuppressWarnings("deprecation")
			Date data1 = new Date(120,03,15,15,41);
		    cTransacaoCartaoP.setData(data1);
		    cTransacaoCartaoP.setDescricao("MCDonalds1");
		    cTransacaoCartaoP.setIdAluno(333111L);
		    cTransacaoCartaoP.setValor(33.11);

		  
			String json;
			try {
				json = mapper.writeValueAsString(cTransacaoCartaoP);
				mockMvc.perform(post("/transacaocartoes")
					      .contentType(MediaType.APPLICATION_JSON)
					      .content(json)
					      .accept(MediaType.APPLICATION_JSON))
					      .andExpect(status().isCreated());
		
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
	  }

	  //atualização de aluno
	  @Test
	  public void updateTeste() throws Exception {
		    CreateTransacaoCartaoPojo cTransacaoCartaoP = new CreateTransacaoCartaoPojo();
		    @SuppressWarnings("deprecation")
			Date data1 = new Date(120,03,15,15,41);
		    cTransacaoCartaoP.setData(data1);
		    cTransacaoCartaoP.setDescricao("MCDonalds1");
		    cTransacaoCartaoP.setIdAluno(333111L);
		    cTransacaoCartaoP.setValor(33.11);
		  
			String json;
			try {
				json = mapper.writeValueAsString(cTransacaoCartaoP);
				mockMvc.perform(put("/transacaocartoes/1")
					      .contentType(MediaType.APPLICATION_JSON)
					      .content(json)
					      .accept(MediaType.APPLICATION_JSON))
					      .andExpect(status().isOk());
		
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
	  }

	  //delecao de aluno
	  @Test
	  public void deleteTeste() throws Exception {
		    CreateTransacaoCartaoPojo cTransacaoCartaoP = new CreateTransacaoCartaoPojo();
		    @SuppressWarnings("deprecation")
			Date data1 = new Date(120,03,15,15,41);
		    cTransacaoCartaoP.setData(data1);
		    cTransacaoCartaoP.setDescricao("MCDonalds1");
		    cTransacaoCartaoP.setIdAluno(333111L);
		    cTransacaoCartaoP.setValor(33.11);
		  

			try {
				mockMvc.perform(delete("/transacaocartoes/1"))
					      .andExpect(status().isOk());
		
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
	  }
}
	