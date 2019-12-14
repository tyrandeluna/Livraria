package Main;

import java.util.Map;
import java.util.Scanner;

import Controle.ControleCaixa;
import Controle.ControleEstoque;
import Controle.ControleVendas;
import Entidades.LAventura;
import Entidades.LComedia;
import Entidades.LDrama;
import Entidades.Livro;
import Entidades.Venda;

public class Livraria {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ControleEstoque control1 = new ControleEstoque();
		ControleVendas  control2 = new ControleVendas();
		ControleCaixa   control3 = new ControleCaixa();
		
		Scanner op = new Scanner(System.in);
	    int operacao;
		int opcao;
		do {
	System.out.println("+-----------------------------------------------------+\n" +
			"|       ..  .-~~~-. ..                                |\n"+
			"|    .--.'  `'       '  ;.                            |\n"+
			"|  .'                     `,                          |\n"+
			"|  `. ,.'`.__'~-.           :                         |\n"+
			"|     ~ /~  / ~\\  `-       .,'                        |\n"+
			"|      |___|____| :          `.         LIVRARIA      |\n"+
			"|      |  *| *  |  `-.        ;            DO         |\n"+
			"|       \\__/\\__/      ~;     |'           JOÃO        |\n"+
			"|      /  `.           `-...;'                        |\n"+
			"|      |   |                ;                         |\n"+
			"|      |   ;                |                         |\n"+
			"|      `.  `._              |                         |\n"+
			"|        \\   ~~~           .'                         |\n"+
			"|         `.__________.'   :                          |\n"+
			"+-----------------------------------------------------+");
	System.out.println("-- Selecione uma operação --\n"
						+ "1- Venda \n"
						+ "2- Lista de Estoque\n"
						+ "3- Histórico de vendas\n"
						+ "4- Gerenciar Caixa\n"
						+ "5- Repor estoque\n"
						+ "6- Sair");
	operacao = op.nextInt();
		switch(operacao) {
		case 1:
			while(operacao == 1) {
			System.out.println("*A lista de livros é esta. Qual destes livros será vendido?*");
			control1.listaEstoque();
			opcao = op.nextInt();
			control2.realizarVenda(opcao);
			System.out.println("*Gostaria de finalizar a venda?*\n"
							 + "1-Não \n2-Sim");
			operacao = op.nextInt();
			if(operacao == 2) {
				Venda v = new Venda(control2.ValorVenda(), control2.getMap());
				control2.addHistorico(v);
				control3.receberPagto(v.getValorTotal());
				break;
			}
			}
			break;
		case 2:
			System.out.println("\n*O estoque de livros é este.*");
			control1.listaEstoque();
			break;
		case 3:
			System.out.println("\n*O registro de todas as vendas é este.*");
			control2.historico();
			break;
		case 4:
			System.out.println("\n*Vamos ver como anda o caixa.*");
			control3.totalCaixa();
			break;
		case 5:
			System.out.println("\n*O estoque precisa ser reposto.*");
			control1.reporEstoque();
			break;
		case 6:
			System.exit(1);
		default: 
			System.out.println("*Escolha uma opção válida.*");
			break;
		}
		}while(operacao != 6);
	}
	
}