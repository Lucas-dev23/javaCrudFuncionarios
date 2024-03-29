package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import entities.Funcionario;
import factories.ConnectionFactory;

public class FuncionarioRepository {

	public void create(Funcionario funcionario) throws Exception {

		// Obtendo uma conex�o com o banco de dados
		Connection connection = ConnectionFactory.getConnection();

		// escrever o comando SQL para realizar o cadastro de funcionario
		PreparedStatement statement = connection
				.prepareStatement("insert into funcionario(id, nome, cpf, matricula, salario) values(?, ?, ?, ?, ?)");

		statement.setObject(1, funcionario.getId());
		statement.setString(2, funcionario.getNome());
		statement.setString(3, funcionario.getCpf());
		statement.setString(4, funcionario.getMatricula());
		statement.setDouble(5, funcionario.getSalario());
		statement.execute();

		// fechando a conex�o do banco de dados
		connection.close();
	}

	public void update(Funcionario funcionario) throws Exception {

		// Obtendo uma conex�o com o banco de dados
		Connection connection = ConnectionFactory.getConnection();
		// escrever o comando SQL para realizar a atualiza��o de Funcion�rio
		PreparedStatement statement = connection
				.prepareStatement("update funcionario set nome=?, cpf=?, matricula=?, salario=? where id=?");

		statement.setString(1, funcionario.getNome());
		statement.setString(2, funcionario.getCpf());
		statement.setString(3, funcionario.getMatricula());
		statement.setDouble(4, funcionario.getSalario());
		statement.setObject(5, funcionario.getId());
		statement.execute();

		connection.close();
	}

	public void delete(Funcionario funcionario) throws Exception {

		// Obtendo uma conex�o com o banco de dados
		Connection connection = ConnectionFactory.getConnection();

		// escrever o comando SQL para realizar a exclus�o de funcionario
		PreparedStatement statement = connection.prepareStatement("delete from funcionario where id=?");

		statement.setObject(1, funcionario.getId());
		statement.execute();

		connection.close();
	}

	public List<Funcionario> findAll() throws Exception {

		Connection connection = ConnectionFactory.getConnection();

		// Escrevendo uma instru��o SQL para consultar todos os funcionario
		PreparedStatement statement = connection.prepareStatement
				("select * from funcionario order by nome");

		// executando e lendo os dados obtidos na consulta
		ResultSet resultSet = statement.executeQuery();

		// declarando uma lista da classe funcioanrio
		List<Funcionario> lista = new ArrayList<Funcionario>();

		// percorrendo cada registro obtido no ResultSet
		while (resultSet.next()) {

			// lendo cada campo do registro do banco de dados
			Funcionario funcionario = new Funcionario();

			funcionario.setId(UUID.fromString(resultSet.getString("id")));
			funcionario.setNome(resultSet.getString("nome"));
			funcionario.setCpf(resultSet.getString("cpf"));
			funcionario.setMatricula(resultSet.getString("matricula"));
			funcionario.setSalario(resultSet.getDouble("salario"));

			lista.add(funcionario); // adicionando o objeto na lista
		}

		connection.close(); // fechando a conex�o do banco de dados
		return lista; // retornar o conte�do da lista
	}

	// Busca um funcion�rio no banco de dados pelo ID.
	public Funcionario findById(UUID id) throws Exception {

		Connection connection = ConnectionFactory.getConnection();

		// Escrevendo uma instru��o SQL para consultar 1 funcionario atrav�s do id
		PreparedStatement statement = connection.prepareStatement("select * from funcionario where id=?");

		statement.setObject(1, id);
		ResultSet resultSet = statement.executeQuery();

		Funcionario funcionario = null;

		if (resultSet.next()) {

			funcionario = new Funcionario();

			funcionario.setId(UUID.fromString(resultSet.getString("id")));
			funcionario.setNome(resultSet.getString("nome"));
			funcionario.setCpf(resultSet.getString("cpf"));
			funcionario.setMatricula(resultSet.getString("matricula"));
			funcionario.setSalario(resultSet.getDouble("salario"));
		}

		connection.close();
		return funcionario;
	}

}
