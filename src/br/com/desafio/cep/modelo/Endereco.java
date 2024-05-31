package br.com.desafio.cep.modelo;

public record Endereco(String cep,
					   String logradouro,
					   String complemento, 
					   String bairro,
					   String localidade, 
					   String uf,
					   String ibge,
					   String ddd,
					   boolean erro) {

}
