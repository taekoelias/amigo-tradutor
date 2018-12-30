package br.com.amigotradutor.util;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;

public class ValidatorUtilTest {

	@Test
	public void validaValorNuloIsEmpty() {
		assertTrue(ValidatorUtil.isEmpty(null));
	}
	
	@Test
	public void validaStringVaziaIsEmpty() {
		assertTrue(ValidatorUtil.isEmpty(""));
	}
	
	@Test
	public void validaListaVaziaIsEmpty() {
		assertTrue(ValidatorUtil.isEmpty(new ArrayList<>()));
	}
	
	@Test
	public void validaMapaVazioIsEmpty() {
		assertTrue(ValidatorUtil.isEmpty(new HashMap<>()));
	}
	
	@Test
	public void validaIntZeroIsEmpty() {
		assertTrue(ValidatorUtil.isEmpty(0));
	}
	
	@Test
	public void validaLongZeroIsEmpty() {
		assertTrue(ValidatorUtil.isEmpty(0l));
	}
	
	@Test
	public void validaDoubleZeroIsEmpty() {
		assertTrue(ValidatorUtil.isEmpty(0d));
	}
	
	@Test
	public void validaStringUmCaracterIsNotEmpty() {
		assertTrue(ValidatorUtil.isNotEmpty("a"));
	}
	
	@Test
	public void validaIntDiferenteZeroIsNotEmpty() {
		assertTrue(ValidatorUtil.isNotEmpty(1));
	}
}
