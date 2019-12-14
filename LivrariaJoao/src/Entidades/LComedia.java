package Entidades;

public class LComedia extends Livro{
	private String tipoCapa;
	public LComedia(int id, String nome, double valor, int qtd) {
		super(id, nome, valor, qtd);
		this.tipoCapa = "Capa Brochura";
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "|-ID: " + getId() + " |-Nome: " + getNome() + " |-Categoria: Comédia"+" |Tipo Capa: "+this.tipoCapa+" |-Valor: " + getValor() + " |-Qtd: " + getQtd() +"\n";
	}
}
