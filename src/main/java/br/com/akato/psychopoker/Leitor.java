package br.com.akato.psychopoker;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;

public class Leitor {
	public Collection<String> lerEventos() throws Exception {
		String caminho = new File("partida.txt").getCanonicalPath();
		
		InputStream is = new FileInputStream(caminho);
		Collection<String> acoes = new ArrayList<String>();
		String linha;
		try {
			BufferedReader bfr = new BufferedReader(new InputStreamReader(is,
					"UTF-8"));
			while ((linha = bfr.readLine()) != null) {
				acoes.add(linha);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			is.close();
		}
		return acoes;
	}
}
