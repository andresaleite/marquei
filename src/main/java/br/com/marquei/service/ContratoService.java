package br.com.marquei.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.marquei.model.Contrato;
import br.com.marquei.model.EnumSituacaoRegistro;
import br.com.marquei.model.Contrato;
import br.com.marquei.repository.ContratoRepository;
import br.com.marquei.repository.ContratoRepository;


@Service
public class ContratoService {

	@Autowired
	private ContratoRepository bd;
	
	public Contrato salvar(Contrato contrato) throws Exception {
		Contrato salvaContrato = bd.save(contrato);
		return salvaContrato;
	}
	
	public Contrato atualizar(Long codigo, Contrato contrato) {
		Contrato contratoSalva = buscarContratoPorCodigo(codigo);
		
		BeanUtils.copyProperties(contrato, contratoSalva, "codigo");
		
		return bd.save(contratoSalva);
	}


	public void atualizarPropriedadeAtivo(Long codigo) {
		Contrato contratoSalva = buscarContratoPorCodigo(codigo);
	//	contratoSalva.setSituacaoRegistro(situacao);
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
