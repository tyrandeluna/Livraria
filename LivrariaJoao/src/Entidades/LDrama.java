package Entidades;

public class LDrama extends Livro{
	private String tipoCapa;
	public LDrama(int id, String nome, double valor, int qtd) {
		super(id, nome, valor, qtd);
		this.tipoCapa = "Capa Dura";
		// TODO Auto-generated constructor stub
	}
	
@Override
	public String toString() {
		return "|-ID: " + getId() + " |-Nome: " + getNome() + " |-Categoria: Drama"+" |Tipo Capa: "+this.tipoCapa+" |-Valor: " + getValor() + " |-Qtd: " + getQtd() +"\n";
	}
}
