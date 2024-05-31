package br.com.desafio.cep.principal;

import java.io.IOException;
import java.util.Scanner;

import br.com.desafio.cep.conteudo.GeradorDeArquivo;
import br.com.desafio.cep.http.ConsultaCep;
import br.com.desafio.cep.modelo.Endereco;

public class Principal {

	public static void main(String[] args) {
		Scanner leitura = new Scanner(System.in);

		ConsultaCep consultaCep = new ConsultaCep();

		String cep = "";

		while (!cep.equalsIgnoreCase("Sair")) {
			
			System.out.println("Digite o CEP para pesquisar ou 'Sair' para terminar!");
			cep = leitura.nextLine();
			
			if (cep.equalsIgnoreCase("sair")) {
				break;
			}

			Endereco novoEndereco = consultaCep.buscaEndereco(cep);

			if (!novoEndereco.erro()) {
				try {

					System.out.println(novoEndereco);
					GeradorDeArquivo gerador = new GeradorDeArquivo();
					gerador.salvaJson(novoEndereco);

				} catch (RuntimeException | IOException e) {
					System.out.println("ERRO: " + e.getMessage());
					System.out.println("Programa finalizado no catch da Principal!");
				}
			} else {
				System.out.println("O CEP digitado não existe no banco de dados!");
			}
		}

		System.out.println("Programa finalizado na Principal");

		leitura.close();
	}

}
