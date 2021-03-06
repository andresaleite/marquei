package br.com.marquei.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.marquei.model.Contrato;
import br.com.marquei.model.EnumSituacaoRegistro;
import br.com.marquei.model.Pessoa;
import br.com.marquei.repository.PessoaRepository;


@Service
public class PessoaService {

	@Autowired
	private PessoaRepository bd;
	@Autowired
	private ContratoService contratoService; 
	
	public Pessoa salvarNovoCliente(Pessoa pessoa) throws Exception {
		Pessoa salvaPessoa = new Pessoa();
		try {
			 salvaPessoa = bd.save(pessoa);
			 contratoService.salvarPessoaCliente(pessoa);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return salvaPessoa;
	}
	
	public Pessoa atualizar(Long codigo, Pessoa pessoa) {
		Pessoa pessoaSalva = buscarPessoaPorCodigo(codigo);
		
		BeanUtils.copyProperties(pessoa, pessoaSalva, "codigo");
		
		return bd.save(pessoaSalva);
	}


	public void atualizarPropriedadeAtivo(Long codigo, EnumSituacaoRegistro situacao) {
		Pessoa pessoaSalva = buscarPessoaPorCodigo(codigo);
		pessoaSalva.setSituacaoRegistro(situacao);
		bd.save(pessoaSalva);
		
	}

	public Pessoa buscarPessoaPorCodigo(Long codigo) {
		Pessoa pessoaSalva = bd.findOne(codigo);
		if(pessoaSalva == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return pessoaSalva;
	}
	

}
