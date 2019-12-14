package Entidades;

public class Livro {
	private Integer id;
	private String nome;
	private double valor;
	private int qtd;
	
	public Livro(int id, String nome, double valor, Integer qtd) {
		this.id = id;
		this.nome = nome;
		this.valor = valor;
		this.qtd = qtd;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}
	
	public Livro rmQuantidade(Livro livro, int qtd) {
		Livro livroAux = new Livro(livro.getId(), livro.getNome(), livro.getValor(), livro.getQtd()-qtd);
		return livroAux;
	}
	
	public Livro atQuantidade(Livro livro, int qtd) {
		Livro livroAux = new Livro(livro.getId(), livro.getNome(), livro.getValor(), livro.getQtd()+qtd);
		return livroAux;
	}
	
	public String toString() {
		return "|-ID: " + getId() + " |-Nome: " + getNome() + " |-Valor: " + getValor() + " |-Qtd: " + getQtd() +"\n";
	}
}
