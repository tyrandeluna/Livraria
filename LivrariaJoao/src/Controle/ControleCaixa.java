package Controle;

import java.util.HashMap;
import java.util.Map;

import Entidades.Venda;

public class ControleCaixa {
	private static double total = 0;
	public ControleCaixa() {
	}
	
	public void receberPagto(double valor) {
		this.total = this.total + valor;
	}
	public double getTotal() {
		return this.total;
	}
	public void totalCaixa() {
		System.out.println("Total: "+getTotal());
	}
	public void pagarCompra(double valor) {
		this.total = this.total - valor;
	}

}
