package controllers;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import entities.Funcionario;
import repositories.FuncionarioRepository;

public class FuncionarioController {

	public void cadastrarFuncionario() throws Exception {

		System.out.println("\nCADASTRO DE FUNCIONARIO:\n");
		Scanner scanner = new Scanner(System.in);

		Funcionario funcionario = new Funcionario();
		funcionario.setId(UUID.randomUUID());

		System.out.print("INFORME O NOME........: ");
		funcionario.setNome(scanner.nextLine());

		System.out.print("INFORME O CPF.........: ");
		funcionario.setCpf(scanner.nextLine());

		System.out.print("INFORME A MATRICULA...: ");
		funcionario.setMatricula(scanner.nextLine());

		System.out.print("INFORME O SALARIO.....: ");
		funcionario.setSalario(Double.parseDouble(scanner.nextLine()));

		FuncionarioRepository funcionarioRepository = new FuncionarioRepository();
		funcionarioRepository.create(funcionario);

		System.out.println("\nFUNCIONARIO CADASTRADO COM SUCESSO!");

		scanner.close();
	}

	public void atualizarFuncionario() throws Exception {

		System.out.println("\nATUALIZÇÃO DE FUNCIONARIO:\n");
		Scanner scanner = new Scanner(System.in);

		System.out.print("INFORME O ID........: ");
		UUID id = UUID.fromString(scanner.nextLine());

		FuncionarioRepository funcionarioRepository = new FuncionarioRepository();
		Funcionario funcionario = funcionarioRepository.findById(id);

		// Verificar se o funcionário foi encontrado

		if (funcionario != null) {

			System.out.print("\nFUNCIONÁRIO ENCONTRADO!\n");

			System.out.print("\nINFORME O NOVO NOME......: ");
			funcionario.setNome(scanner.nextLine());

			System.out.print("INFORME O NOVO CPF.........: ");
			funcionario.setCpf(scanner.nextLine());

			System.out.print("INFORME A NOVA MATRICULA...: ");
			funcionario.setMatricula(scanner.nextLine());

			System.out.print("INFORME O NOVO SALARIO.....: ");
			funcionario.setSalario(Double.parseDouble(scanner.nextLine()));

			funcionarioRepository.update(funcionario);

			System.out.print("\nFUNCIOÁRIO ATUALIZADO COM SUCESSO!");

		} else {
			System.out.println("\nFUNCIONÁRIO NÃO ENCONTRADO. VERIFIQUE O ID.");
		}

		scanner.close();
	}

	public void excluirFuncionario() throws Exception {

		System.out.println("\nEXCLUSÃO DE FUNCIONARIO:\n");
		Scanner scanner = new Scanner(System.in);

		System.out.print("INFORME O ID........: ");
		UUID id = UUID.fromString(scanner.nextLine());

		FuncionarioRepository funcionarioRepository = new FuncionarioRepository();
		Funcionario funcionario = funcionarioRepository.findById(id);

		if (funcionario != null) {

			funcionarioRepository.delete(funcionario);
			
			System.out.println("\nFUNCIONARIO EXCLUÍDO COM SUCESSO!");
		} else {
			System.out.println("\nFUNCIONARIO NÃO ENCONTRADO. VERIFIQUE O ID.");
		}

	scanner.close();

	}

	public void consultarFuncionario() throws Exception{
		
		System.out.print("\nCONSULTA DE FUNCIONARIO:\n");

		FuncionarioRepository funcionarioRepository = new FuncionarioRepository();
		List<Funcionario> lista = funcionarioRepository.findAll();
		
		for (Funcionario funcionario : lista) {

			System.out.println("ID DO FUNCIONARIO...: " + funcionario.getId());
			System.out.println("NOME................: " + funcionario.getNome());
			System.out.println("CPF.................: " + funcionario.getCpf());
			System.out.println("MATRICULA...........: " + funcionario.getMatricula());
			System.out.println("SALARIO.............: " + funcionario.getSalario());
			System.out.println("...");
		}

	}
}
