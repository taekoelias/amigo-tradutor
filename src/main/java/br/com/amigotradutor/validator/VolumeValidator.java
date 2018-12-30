package br.com.amigotradutor.validator;

import java.util.List;

import br.com.amigotradutor.exception.EntidadeNaoExistenteException;
import br.com.amigotradutor.exception.EntidadeUnicaExistenteException;
import br.com.amigotradutor.exception.ValidacaoNegocioException;
import br.com.amigotradutor.model.Volume;
import br.com.amigotradutor.repository.interfaces.VolumeRepository;
import br.com.amigotradutor.util.ValidatorUtil;

public class VolumeValidator implements BaseValidator<Volume, Long> {

	private VolumeRepository repository;
	
	public VolumeValidator(VolumeRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public void requiredField(Volume obj) throws ValidacaoNegocioException {
		if (ValidatorUtil.isEmpty(obj) || ValidatorUtil.isEmpty(obj.getId()) 
				|| ValidatorUtil.isEmpty(obj.getArtigo()) 
				|| ValidatorUtil.isEmpty(obj.getArtigo().getId()) 
				|| ValidatorUtil.isEmpty(obj.getNumero()) 
				|| ValidatorUtil.isEmpty(obj.getTitulo()))
			throw new ValidacaoNegocioException("Dados obrigatórios do volume não foram informados.");

	}

	@Override
	public void duplicated(Volume obj) throws ValidacaoNegocioException {
		requiredField(obj);
		
		List<Volume> volumesBD = repository.findByNumeroAndArtigoId(obj.getNumero(),obj.getArtigo().getId());
		
		if (ValidatorUtil.isNotEmpty(volumesBD))
			for (Volume v : volumesBD) {
				if (v.getId() != obj.getId())
					throw new EntidadeUnicaExistenteException("Já existe um volume cadastrado para o número e artigo informado.");
			}
	}

	@Override
	public void notExists(Long id) throws ValidacaoNegocioException {
		if (!repository.existsById(id))
			throw new EntidadeNaoExistenteException("Não foi encontrado um volume para o número e artigo informado.");
	}

}
