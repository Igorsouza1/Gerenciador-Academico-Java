package taskapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tasksapp.models.Cursos;

public class CursosDAO {

	public void cadastrar(Cursos curso) throws SQLException, Exception {
		if (curso != null && curso.isValid() && curso.getCodigo() == 0) {
			Connection conn = ConnectionUtil.getConnection();
			String sql = "INSERT INTO Cursos (nivel, nome, cargaHoraria, situacao) values (?,?,?,?)";
			PreparedStatement prepStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			prepStatement.setInt(1, curso.getNivel());
			prepStatement.setString(2, curso.getNome());
			prepStatement.setInt(3, curso.getCargaHoraria());
			prepStatement.setString(4, curso.getSituacao());

			prepStatement.executeUpdate();

			ResultSet result = prepStatement.getGeneratedKeys();

			if (result.next()) {
				curso.setCodigo(result.getInt(1));
			}
			result.close();
			prepStatement.close();
			conn.close();
			System.out.println("\nCurso salvo com o Codigo " + curso.getCodigo() + "\n");
		}
	}

	public Cursos buscar(int codigo) throws Exception {
		if (codigo > 0) {
			Connection conn = ConnectionUtil.getConnection();
			if (conn != null) {
				String sql = "SELECT * FROM cursos WHERE codigo = ?";
				PreparedStatement prepStatement = conn.prepareStatement(sql);
				prepStatement.setInt(1, codigo);

				ResultSet result = prepStatement.executeQuery();

				if (result.next()) {
					Cursos curso = new Cursos();
					curso.setCodigo(result.getInt("codigo"));
					curso.setNome(result.getString("nome"));
					curso.setNivel(result.getInt("nivel"));
					curso.setCargaHoraria(result.getInt("cargaHoraria"));
					curso.setSituacao(result.getString("situacao"));
					return curso;
				}
				result.close();
				prepStatement.close();
				conn.close();
			}
			
		}
		return null;
	}
	
	public List<Cursos> buscarTodos() throws Exception{
		Connection conn = ConnectionUtil.getConnection();
		String sql = "SELECT * FROM cursos";
		PreparedStatement prepStatement = conn.prepareStatement(sql);
		ResultSet result = prepStatement.executeQuery();
		List<Cursos> cursoLista = new ArrayList<Cursos>();
		while(result.next()) {
			Cursos curso = new Cursos();
			curso.setCodigo(result.getInt("codigo"));
			curso.setNivel(result.getInt("nivel"));
			curso.setNome(result.getString("nome"));
			curso.setCargaHoraria(result.getInt("cargaHoraria"));
			curso.setSituacao(result.getString("situacao"));	
			cursoLista.add(curso);
		}
		result.close();
		prepStatement.close();
		conn.close();
		return cursoLista;
	}
	
	public void atualizar(Cursos curso) throws SQLException {
		  if(curso!= null) {
			  Connection conn = ConnectionUtil.getConnection();
			  String sqlUpdate = "UPDATE cursos set nivel=?, nome=?, cargaHoraria=?, situacao=? where codigo=?";
			  
			  PreparedStatement prepStatement = conn.prepareStatement(sqlUpdate);
			  prepStatement = conn.prepareStatement(sqlUpdate);
			  prepStatement.setInt(1, curso.getNivel());
			  prepStatement.setString(2, curso.getNome());
			  prepStatement.setInt(3, curso.getCargaHoraria());
			  prepStatement.setString(4, curso.getSituacao());
			  prepStatement.setInt(5, curso.getCodigo());
			  
			  prepStatement.executeUpdate();
			  prepStatement.close();
			  conn.close();
		  }
	}
	
	public void exluir(int codigo) throws SQLException {
		if(codigo > 0) {
			Connection conn = ConnectionUtil.getConnection();
			
			if(conn != null) {
				String sql = "DELETE from cursos where codigo = ?";
				PreparedStatement prepStatement = conn.prepareStatement(sql);
				prepStatement.setInt(1, codigo);
				prepStatement.executeUpdate();
				prepStatement.close();
				conn.close();
			}
		}else {
			System.out.println("O codigo informado não foi Encontrado");
		}
	}
	
	public void excluir(Cursos curso) throws SQLException {
		if(curso != null && curso.getCodigo()> 0) {
			this.exluir(curso.getCodigo());
		}
	}
}
