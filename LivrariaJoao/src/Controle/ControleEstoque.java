package Controle;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import Entidades.LAventura;
import Entidades.LComedia;
import Entidades.LDrama;
import Entidades.Livro;
import Main.Livraria;

public class ControleEstoque {
	ControleCaixa control1 = new ControleCaixa();
	private static Map<Integer,Livro> estoque = new HashMap<Integer,Livro>();
	static Livro livro1 = new LAventura(1,"Coração de Pedra", 30.00, 1, 20);
	static Livro livro2 = new LComedia(2,"Procura-se um Marido", 24.90, 2);
	static Livro livro3 = new LComedia(3,"Perdido em Marte", 35.00, 3);
	static Livro livro4 = new LDrama(4,"A Menina que Roubava Livros", 26.00, 4);
	static Livro livro5 = new LDrama(5,"O Senhor dos Anéis", 50.0, 5);
	static Livro livro6 = new LDrama(6,"Cem Anos de Solidão", 40.0, 6);
	public ControleEstoque() {
		
	}
	static {
		addEstoque(livro1);
		addEstoque(livro2);
		addEstoque(livro3);
		addEstoque(livro4);
		addEstoque(livro5);
		addEstoque(livro6);
	}

	public void retiradaEstoque(Livro l, int qtd) {
		Livro l1 = estoque.get(l.getId());
		Livro novoLivro =  l.rmQuantidade(l1, qtd);
		estoque.computeIfPresent(l.getId(), (k, v) -> novoLivro);
	}
	public void reporEstoque() {
		Scanner op = new Scanner(System.in);
		int opcao;
		System.out.println("*Está faltando livros! Preciso comprar mais livros para o estoque...*"
						 + "         *Livros que precisam de reposição:*");
		Set<Integer> k = estoque.keySet();
		for (int chave : k)
		{
			if(estoque.get(chave).getQtd() >= 0 && estoque.get(chave).getQtd() <= 4)
				System.out.println(estoque.get(chave));
		}
		opcao = op.nextInt();
		atualizarEstoque(opcao);
	}
	public void atualizarEstoque(int id) {
		Scanner op = new Scanner(System.in);
		int qtd;
		System.out.println("*Quantidade*");
		qtd = op.nextInt();
		Livro l1 = estoque.get(id);
		double valor = qtd * l1.getValor();
		if(control1.getTotal() >= valor) {
			control1.pagarCompra(valor);
			Livro novoLivro =  l1.atQuantidade(l1, qtd);
			estoque.computeIfPresent(l1.getId(), (k, v) -> novoLivro);
			System.out.println("*Reposto.*");
		}
		else 
			System.out.println("*Sem dinheiro no caixa disponível.*");
	}
	public static boolean addEstoque(Livro l) {
		if(l != null && !estoque.containsKey(l.getId())){
			estoque.put(l.getId(), l);
			return true;
		}
		return false;
	}
	public static Map<Integer, Livro> getMap(){
		return estoque;
	}
	public void listaEstoque() {
		System.out.println(estoque);
	}
}
