package br.com.fiap.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.connection.ConnectionFactory;
import br.com.fiap.model.Usuario;

/**
 * 
 * @author WillahelmGui
 *
 */
//DAO significa Data Access Object
public class UsuarioDAO {
	private Connection connection;

	// Create a new connection in constructor it's a normal way to make the
	// constructor of "DAO" classes.
	public UsuarioDAO() {
		this.connection = new ConnectionFactory().conect();
	}

	// Insert
	public void insert(Usuario user) {
		String sql = "Insert into usuario (nome, senha, data) values(?,?,?)";// Query
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			// complemento da query
//			stmt.setLong(1,user.getId()); incrementado pela sequence com trigger.
			stmt.setString(1, user.getNome());
			stmt.setString(2, user.getSenha());
			stmt.setDate(3, user.getData());
			// execução da query
			stmt.execute();
			// fechar a operação. Foi fechada a operação e não a conexão com o banco,
			// cuidado pra não confundir-se.
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// SelectByID
	public Usuario selectById(long id) {
		Usuario usuario = null;
		String sql = "select * from usuario where id = ?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();// O que é result set?
			while (rs.next()) {// Se o while é retirado o result set não é usado, por isso vale a pena manter o
								// while mesmo com um único objeto no retorno.
				usuario = new Usuario();
				usuario.setId(rs.getLong("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setData(rs.getDate("data"));
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
		}
		return usuario;
	}

	// SelectAll
	public List<Usuario> selectAll() {// Seleciona todos os membros da tabela
		List<Usuario> usuarios = new ArrayList<Usuario>();
		String sql = "select * from usuario order by nome";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();// O que é result set?

			while (rs.next()) { // Enquanto houver dados é feito um próximo registro.
				Usuario usuario = new Usuario();
				usuario.setId(rs.getLong("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setData(rs.getDate("data"));
				usuarios.add(usuario); // Adiciona um novo usuario para a lista de usuarios, cada vez que passa o laço,
										// usando as características acima.
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
		}
		return usuarios;
	}

	// Update
	public void update(Usuario usuario) {//é passado um objeto para que seja possível sobrescrever os dados se não forem altreados no formulário.
		String sql = "update usuario set nome = ?, senha = ? where id = ?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getSenha());
			stmt.setLong(3, usuario.getId());
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
		
		}
	}

	// Delete
	public void delete(long id) {
		String sql = "delete from usuario where id = ?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, id);
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
