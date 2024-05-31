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
		
		System.out.println("Digite o CEP para pesquisar");
		var cep = leitura.nextLine();
		
		try {
		
        Endereco novoEndereco = consultaCep.buscaEndereco(cep);
        System.out.println(novoEndereco);
        GeradorDeArquivo gerador = new GeradorDeArquivo();
        gerador.salvaJson(novoEndereco);
        
		}catch (RuntimeException | IOException e) {
			System.out.println("ERRO: " + e.getMessage());
			System.out.println("Programa finalizado no catch da Principal!");
		}
        
        System.out.println("Programa finalizado na Principal");
        
        leitura.close();
	}
	
}
