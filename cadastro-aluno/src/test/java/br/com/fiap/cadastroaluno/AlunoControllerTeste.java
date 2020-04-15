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
import br.com.fiap.cadastroaluno.pojo.AlunoPojo;
import br.com.fiap.cadastroaluno.pojo.CreateAlunoPojo;
import br.com.fiap.cadastroaluno.service.AlunoService;

import java.util.Arrays;
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
public class AlunoControllerTeste {
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired 
	private ObjectMapper mapper;

	@MockBean
	private AlunoService alunoService;

	//listagem de alunos
	@Test
	public void getAllTeste() throws Exception {
		
		// given
		Aluno aluno1 = new Aluno();
		AlunoPojo alunoP1 = new AlunoPojo(aluno1);
		alunoP1.setId(1L);
		alunoP1.setCpf("12345678911");
		alunoP1.setNome("Nome1");
		alunoP1.setSobrenome("Sobrenome1");

		Aluno aluno2 = new Aluno();
		AlunoPojo alunoP2 = new AlunoPojo(aluno2);
		alunoP2.setId(2L);
		alunoP2.setCpf("12345678922");
		alunoP2.setNome("Nome2");
		alunoP2.setSobrenome("Sobrenome2");
		

		List<AlunoPojo> alunos = Arrays.asList(alunoP1,alunoP2);
		given(alunoService.getAll()).willReturn(alunos);

		// when + then
		this.mockMvc.perform(get("/alunos"))
		.andExpect(status().isOk())
		.andExpect(content().json("[{'id': 1,'nome': 'Nome1','sobrenome': 'Sobrenome1','cpf': '12345678911'},{'id': 2,'nome': 'Nome2','sobrenome': 'Sobrenome2','cpf': '12345678922'}]"));
	}

	//busca por Id
	@Test
	public void getByIdTeste() throws Exception {
		
		// given
		Aluno aluno1 = new Aluno();
		AlunoPojo alunoP1 = new AlunoPojo(aluno1);
		alunoP1.setId(1L);
		alunoP1.setCpf("12345678911");
		alunoP1.setNome("Nome1");
		alunoP1.setSobrenome("Sobrenome1");

		given(alunoService.findById(1L)).willReturn(alunoP1);

		// when + then
		this.mockMvc.perform(get("/alunos/1"))
		.andExpect(status().isOk())
		.andExpect(content().json("{'id': 1,'nome': 'Nome1','sobrenome': 'Sobrenome1','cpf': '12345678911'}"));
	}

	//criação de aluno
	  @Test
	  public void createTeste() throws Exception {
		    CreateAlunoPojo cAlunoP = new CreateAlunoPojo();
			cAlunoP.setNome("Nome1");
			cAlunoP.setSobrenome("Sobrenome1");
			cAlunoP.setCpf("12345678911");
		  
			String json;
			try {
				json = mapper.writeValueAsString(cAlunoP);
				mockMvc.perform(post("/alunos")
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
		    CreateAlunoPojo cAlunoP = new CreateAlunoPojo();
			cAlunoP.setNome("Nome1");
			cAlunoP.setSobrenome("Sobrenome1");
			cAlunoP.setCpf("12345678911");
		  
			String json;
			try {
				json = mapper.writeValueAsString(cAlunoP);
				mockMvc.perform(put("/alunos/1")
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
		    CreateAlunoPojo cAlunoP = new CreateAlunoPojo();
			cAlunoP.setNome("Nome1");
			cAlunoP.setSobrenome("Sobrenome1");
			cAlunoP.setCpf("12345678911");
		  

			try {
				mockMvc.perform(delete("/alunos/1"))
					      .andExpect(status().isOk());
		
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
	  }
}
	
