package br.com.desafio.cep.conteudo;

import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.desafio.cep.modelo.Endereco;

public class GeradorDeArquivo {

	public void salvaJson (Endereco endereco) throws IOException {
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		FileWriter escrita = new FileWriter(endereco.cep().replace("-", "") + "_arquivo.json");
		escrita.write(gson.toJson(endereco));
		escrita.close();
	}
}
