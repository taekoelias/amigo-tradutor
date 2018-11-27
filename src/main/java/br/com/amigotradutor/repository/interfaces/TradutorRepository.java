package br.com.amigotradutor.repository.interfaces;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.amigotradutor.model.Idioma;
import br.com.amigotradutor.model.Tradutor;

public interface TradutorRepository extends CrudRepository<Tradutor, Long> {
	
	/**
	 * Retorna os {@link Tradutor} ativos
	 * @param usuarioId
	 * @param ativo
	 * @return
	 */
	List<Tradutor> findByAtivo(boolean ativo);
	
	/**
	 * Retorna os {@link Tradutor} associadas a pessoa informada
	 * @param usuarioId
	 * @param ativo
	 * @return
	 */
	List<Tradutor> findByAtivoAndUsuarioPapelUsuarioPapelIdUsuarioId(boolean ativo, long usuarioId);
	
	/**
	 * Retorna os {@link Tradutor} que possuem como {@link Idioma} de origem o informado
	 * @param idiomaOrigemId
	 * @param ativo
	 * @return
	 */
	List<Tradutor> findByAtivoAndOrigemId(boolean ativo, long idiomaOrigemId);
	
	/**
	 * Retorna os {@link Tradutor} que possuem como {@link Idioma} de destino o informado
	 * @param idiomaDestinoId
	 * @param ativo
	 * @return
	 */
	List<Tradutor> findByAtivoAndDestinoId(boolean ativo, long idiomaDestinoId);
	
	/**
	 * Retorna os {@link Tradutor} que possuem como {@link Idioma} de destino e origem o informado
	 * @param usuarioId
	 * @param ativo
	 * @return
	 */
	List<Tradutor> findByAtivoAndDestinoIdAndOrigemId(boolean ativo, long idiomaDestinoId, long idiomaOrigemId);
	
	/**
	 * Retorna os {@link Tradutor} associados ao usuario que possuem como {@link Idioma} de destino e origem o informado
	 * @param usuarioId
	 * @param ativo
	 * @return
	 */
	Tradutor findByUsuarioPapelUsuarioPapelIdUsuarioIdAndDestinoIdAndOrigemId(long usuarioId, long idiomaDestinoId, long idiomaOrigemId);
}
