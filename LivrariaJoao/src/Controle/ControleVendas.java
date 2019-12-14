package Controle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import Entidades.Livro;
import Entidades.Venda;
import Main.Livraria;

public class ControleVendas {
	private Map<Integer,Venda> vendas = new HashMap<Integer,Venda>();
	ControleEstoque control1 = new ControleEstoque();
	Map<Integer,Livro> Livros = new HashMap<Integer,Livro>();
	List<Double> precos = new ArrayList<Double>();
	Map<Integer,Livro> aux = control1.getMap();
	
	public ControleVendas() {
		
	}
	public boolean rVenda(int id) {
		if(aux.containsKey(id)){
			return true;
		}
		return false;
	}
	public void realizarVenda(int id) {
		if (rVenda(id) == false) {
			System.out.println("*O livro ou não está no estoque ou não há o suficiente para a venda.*\n"
					 + "                 *Tente novamente.*");
			System.exit(1);
		}
		Scanner op = new Scanner(System.in);
		double preco;
		int operacao;
		int qtd;
		System.out.println("*Quantos livros vai querer?*");
		qtd = op.nextInt();
		
		Livro l = aux.get(id);
		control1.retiradaEstoque(l, qtd);
		preco = calcPreco(l,l.getValor(), qtd);
		precos.add(preco);
		Livro aux = new Livro(l.getId(), l.getNome(), preco, qtd);
		addMap(aux);
	}
	
	public double calcPreco(Livro l,double preco, int qtd) {
		if(qtd > 1) {
			return preco * qtd;
		}
		else
		return preco;
	}
	public double ValorVenda() {
		double valorTotal = 0;
		for (double k: precos) 
			valorTotal = valorTotal + k;
		precos.clear();
		return valorTotal;
	}
	public boolean addMap(Livro l) {
		if(l != null && !Livros.containsKey(l.getId())){
			Livros.put(l.getId(), l);
			return true;
		}
		return false;
	}
	public void cleanMap() {
		Livros.clear();
	}
	
	public boolean addHistorico(Venda v) {
		if(v != null && !vendas.containsKey(v.getID())){
			vendas.put(v.getID(), v);
			return true;
		}
		return false;
	}
	public Map<Integer, Livro> getMap(){
		Map<Integer,Livro> L = new HashMap<Integer,Livro>(Livros);
		Livros.clear();
		return L;
	}
	public void historico() {
		System.out.println(vendas);
	}
}
