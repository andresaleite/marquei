package br.com.marquei.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.marquei.model.Endereco;
import br.com.marquei.model.EnumSituacaoRegistro;
import br.com.marquei.repository.EnderecoRepository;


@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository bd;
	
	public List<Endereco> criarListaEnderecoDeUmaPessoa(List<Endereco> enderecos, Long idPessoa) {
		for(Endereco e: enderecos) {
			e.getPessoa().setId(idPessoa);
			e.setSituacaoRegistro(EnumSituacaoRegistro.PENDENTE);
			bd.save(e);
		}
		return enderecos;
	}
	
	

}
