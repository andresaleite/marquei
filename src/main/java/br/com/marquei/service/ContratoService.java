package br.com.marquei.service;

import org.springframework.beans.factory.annotation.Autowired;
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
	private ContratoRepository bdContrato;

	@Autowired
	private ContratoPessoaRepository bdRelacionamento;
	
	public Contrato salvarPessoaCliente(Pessoa pessoa) throws Exception {
		Contrato contrato = new Contrato();
		ContratoPessoa relacionamento = new ContratoPessoa();
		Plano plano = new Plano();
		contrato.setFormaPagamento(EnumFormaPagamento.SEM_PAGAMENTO);
		plano.setId(1L);
		contrato.setIdPlano(plano);
		contrato.setPessoaCadastradora(pessoa);
		contrato.setStatus(EnumStatusContrato.VIGENTE);
		contrato = setEnderecoExitente(pessoa, contrato);
		try {
			bdContrato.save(contrato);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		relacionamento.setContrato(contrato);
		relacionamento.setPessoa(pessoa);
		relacionamento.setSituacaoRegistro(EnumSituacaoRegistro.CONFIRMADO);
		relacionamento.setTipoRelacaoContrato(EnumTipoRelacaoContrato.CLIENTE);
		bdRelacionamento.save(relacionamento);
		
		return contrato;
	}

	private Contrato setEnderecoExitente(Pessoa pessoa, Contrato c) {
		if(pessoa != null) 
			if(pessoa.getEnderecos() != null)
				if(pessoa.getEnderecos().size()>0)
					c.setEndereco(pessoa.getEnderecos().get(0));
		return c;
	}
	
	

}
