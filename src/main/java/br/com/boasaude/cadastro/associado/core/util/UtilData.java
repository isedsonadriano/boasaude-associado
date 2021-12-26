package br.com.boasaude.cadastro.associado.core.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UtilData {

	public static LocalDateTime converterStringParaLocalDateTime(String str) {
		try {
			if(str == null) {
				return null;
			}
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
			return dateTime;
		} catch (Exception e) {
			return null;
		}
	}
}
