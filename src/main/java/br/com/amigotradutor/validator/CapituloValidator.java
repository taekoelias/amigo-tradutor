package br.com.amigotradutor.validator;

import java.util.List;

import br.com.amigotradutor.exception.EntidadeNaoExistenteException;
import br.com.amigotradutor.exception.EntidadeUnicaExistenteException;
import br.com.amigotradutor.exception.ValidacaoNegocioException;
import br.com.amigotradutor.model.Capitulo;
import br.com.amigotradutor.model.Volume;
import br.com.amigotradutor.repository.interfaces.CapituloRepository;
import br.com.amigotradutor.repository.interfaces.VolumeRepository;
import br.com.amigotradutor.util.ValidatorUtil;

public class CapituloValidator implements BaseValidator<Capitulo, Long> {

    private CapituloRepository repository;
    
    private VolumeRepository volumeRepository;

    public CapituloValidator(CapituloRepository repository, VolumeRepository volumeRepository) {
        this.repository = repository;
        this.volumeRepository = volumeRepository;
    }

    @Override
    public void requiredField(Capitulo obj) throws ValidacaoNegocioException {
        if (ValidatorUtil.isEmpty(obj)
            || ValidatorUtil.isEmpty(obj.getArtigo()) 
            || ValidatorUtil.isEmpty(obj.getArtigo().getId())
            || ValidatorUtil.isEmpty(obj.getVolume()) 
            || ValidatorUtil.isEmpty(obj.getVolume().getId()) 
            || ValidatorUtil.isEmpty(obj.getNumero()) 
            || ValidatorUtil.isEmpty(obj.getTituloOriginal()))
        	throw new ValidacaoNegocioException("Dados obrigatórios do capitulo não foram informados.");

    }

    @Override
    public void duplicated(Capitulo obj) throws ValidacaoNegocioException {
            requiredField(obj);

            List<Capitulo> capitulosBD = repository.findByNumeroAndVolumeId(obj.getNumero(),obj.getVolume().getId());

            if (ValidatorUtil.isNotEmpty(capitulosBD))
                for (Capitulo c : capitulosBD) {
                    if (c.getId() != obj.getId())
                    	throw new EntidadeUnicaExistenteException("Já existe um capitulo cadastrado para o número e volume informado.");
                }
    }

    @Override
    public void notExists(Long id) throws ValidacaoNegocioException {
        if (!repository.existsById(id))
            throw new EntidadeNaoExistenteException("Não foi encontrado um capitulo para o número e artigo informado.");
    }
        
    public void FromTheSameArtigo(Capitulo obj) throws ValidacaoNegocioException{
        requiredField(obj);
        
        Volume volume = volumeRepository.findById(obj.getVolume().getId()).get();
        
        if (volume.getArtigo().getId() != obj.getArtigo().getId())
            throw new ValidacaoNegocioException("O volume selecionado e de um artigo diferente do capitulo.");
        
    }

}
