package Entidades;

public class LAventura extends Livro{
	private int ilustracao;
	public LAventura(int id, String nome, double valor, int qtd, int ilustracao) {
		super(id, nome, valor, qtd);
		this.ilustracao = ilustracao;
		// TODO Auto-generated constructor stub
	}
	
	public int getIlustracao() {
		return ilustracao;
	}
	public void setIlustracao(int ilustracao) {
		this.ilustracao = ilustracao;
	}
	
	@Override
	public String toString() {
		return "|-ID: " + getId() + " |-Nome: " + getNome() + " |Categoria: Aventura" + " |-Qtd Gravuras: "+getIlustracao()+" |-Valor: " + getValor() + " |-Qtd: " + getQtd() +"\n";
	}
}
