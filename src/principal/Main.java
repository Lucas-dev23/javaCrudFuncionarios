package principal;

import java.util.Scanner;

import controllers.FuncionarioController;

public class Main {

	public static void main(String[] args) {

		System.out.println("\nSISTEMA PARA CONTROLE DE FUNCIONARIO:\n");
		Scanner scanner = new Scanner(System.in);

		try {
			
			System.out.println("(1) CADASTRAR FUNCIONARIO");
			System.out.println("(2) ATUALIZAR FUNCIONARIO");
			System.out.println("(3) EXCLUIR FUNCIONARIO");
			System.out.println("(4) CONSULTAR FUNCIONARIO");

			System.out.print("\nINFORME A OPÇÃO DESEJADA: ");
			Integer opcao = Integer.parseInt(scanner.nextLine());

			FuncionarioController funcionarioController = new FuncionarioController();

			switch (opcao) {
			case 1:
				funcionarioController.cadastrarFuncionario();
				break;
			case 2:
				funcionarioController.atualizarFuncionario();
				break;
			case 3:
				funcionarioController.excluirFuncionario();
				break;
			case 4:
				funcionarioController.consultarFuncionario();
				break;
			default:
				System.out.println("\nOPÇÃO INVÁLIDA!");
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("\nOCORREU UM ERRO: " + e.getMessage());
		} finally {
			scanner.close();
		}

	}

}
