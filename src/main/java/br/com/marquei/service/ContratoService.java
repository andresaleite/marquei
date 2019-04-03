package br.com.marquei.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.marquei.model.Contrato;
import br.com.marquei.model.ContratoPessoa;
import br.com.marquei.model.EnumFormaPagamento;
import br.com.marquei.model.EnumSituacaoRegistro;
import br.com.marquei.model.EnumStatusContrato;
import br.com.marquei.model.EnumTipoRelacaoContrato;
import br.com.marquei.model.Pessoa;
import br.com.marquei.model.Plano;
import br.com.marquei.repository.ContratoPessoaRepository;
import br.com.marquei.repository.ContratoRepository;


@Service
public class ContratoService {
	
	@Autowired
	private ContratoRepository bd;

	@Autowired
	private ContratoPessoaRepository bdRelacionamento;
	
	@Autowired
	private ContratoPessoa relacionamento;
	
	@Autowired
	private Contrato contrato;
	
	@Autowired
	private Plano plano;
	
	public Contrato salvar(Contrato contrato) throws Exception {
		Contrato salvaContrato = bd.save(contrato);
		return salvaContrato;
	}
	
	public Contrato salvarPessoaCliente(Pessoa pessoa) throws Exception {
		contrato.setFormaPagamento(EnumFormaPagamento.SEM_PAGAMENTO);
		plano.setId(1L);
		contrato.setIdPlano(plano);
		contrato.setPessoaCadastradora(pessoa);
		contrato.setStatus(EnumStatusContrato.VIGENTE);
		bd.save(contrato);
		relacionamento.setContrato(contrato);
		relacionamento.setPessoa(pessoa);
		relacionamento.setSituacaoRegistro(EnumSituacaoRegistro.CONFIRMADO);
		relacionamento.setTipoRelacaoContrato(EnumTipoRelacaoContrato.CLIENTE);
		bdRelacionamento.save(relacionamento);
		
		return contrato;
	}
	
	public Contrato atualizar(Long codigo, Contrato contrato) {
		Contrato contratoSalva = buscarContratoPorCodigo(codigo);
		BeanUtils.copyProperties(contrato, contratoSalva, "codigo");
		return bd.save(contratoSalva);
	}


	public void atualizarPropriedadeAtivo(Long codigo) {
		Contrato contratoSalva = buscarContratoPorCodigo(codigo);
		bd.save(contratoSalva);
		
	}

	public Contrato buscarContratoPorCodigo(Long codigo) {
		Contrato contratoSalva = bd.findOne(codigo);
		if(contratoSalva == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return contratoSalva;
	}
	

}
