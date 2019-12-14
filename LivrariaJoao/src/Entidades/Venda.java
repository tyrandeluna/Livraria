package Entidades;

import java.util.HashMap;
import java.util.Map;

public class Venda {
	private static int contador = 0;
    public final int id;
	private double valorTotal;
	private Map<Integer,Livro> Livros;
	
	public Venda(double valor, Map<Integer,Livro> Livros) {
		 this.id = contador++;
		this.valorTotal = valor;
		this.Livros = Livros;
	}
	
	public int getID() {
		return id;
	}
	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Map<Integer, Livro> getLivros() {
		return Livros;
	}

	public void setLivros(Map<Integer, Livro> livros) {
		Livros = livros;
	}
	
	public String toString() {
		return "|Código: " + getID() + " |Valor Total: " + getValorTotal() + " |Livros: " + getLivros();
	}
	
}
