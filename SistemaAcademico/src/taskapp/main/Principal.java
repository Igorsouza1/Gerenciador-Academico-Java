package taskapp.main;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import taskapp.dao.CursosDAO;
import tasksapp.models.Cursos;

public class Principal {
	public static void main(String[] args) throws SQLException {

		int opcao;
		Scanner leitorOpcao = new Scanner(System.in);

		do {
			System.out.println("Digite o numero da opção desejada");
			System.out.println("1 - Cadastrar tarefa");
			System.out.println("2 - Editar tarefa");
			System.out.println("3 - Excluir tarefa");
			System.out.println("4 - Listar tarefas");
			System.out.println("0 - Finalizar programa");

			opcao = leitorOpcao.nextInt();
			leitorOpcao.nextLine(); // Limpar buffer

			switch (opcao) {
			case 0:
				break;
			case 1:
				CadastrarCursos(leitorOpcao);
				break;
			case 2:
				EditarCursos(leitorOpcao);
				break;
			case 3:
				excluirCursos(leitorOpcao);
				break;
			case 4:
				listarCursos();
				break;
			}

		} while (opcao != 0);
	}

	public static void CadastrarCursos(Scanner leitor) throws SQLException {
		System.out.println("***CADASTRAR CURSO***");
		System.out.println("Informe o nome do Curso");
		String nome = leitor.nextLine();
		System.out.println("Informe o nivel do Curso");
		System.out.println("1 - Para Fundamental");
		System.out.println("2 - Para Medio");
		System.out.println("3 - Para Superior");
		int nivel = leitor.nextInt();
		leitor.nextLine();
		System.out.println("Informe a carga horaria");
		int cargaHoraria = leitor.nextInt();
		leitor.nextLine();
		System.out.println("Informe a situação");
		String situacao = leitor.nextLine();

		try {
			Cursos curso = new Cursos(nivel, nome, cargaHoraria, situacao);
			CursosDAO cursoDao = new CursosDAO();
			cursoDao.cadastrar(curso);
		} catch (Exception e) {
			System.out.println("Erro ao atualizar tarefa" + e.getMessage());
		}
	}

	public static void EditarCursos(Scanner leitor) {
		System.out.println("***Editar Curso***");
		System.out.println("Informe o Código da tarefa que deseja editar");
		int codigo = leitor.nextInt();
		leitor.nextLine();
		try {
			CursosDAO cursoDao = new CursosDAO();
			Cursos curso = cursoDao.buscar(codigo);

			if (curso != null) {
				System.out.println("Nome do Curso: " + curso.getNome() + "\nDigite o novo Nome: ");
				String tempNome = leitor.nextLine();
				 if(!tempNome.equals("")) {
				curso.setNome(tempNome);
				 }
				System.out.println("Nivel atual: " + curso.getNivel() + "\nDigite o novo nivel: ");
				curso.setNivel(leitor.nextInt());
				leitor.nextLine();

				System.out.println("Carga Horaria Atual: " + curso.getCargaHoraria() + "\nDigite a nova carga horaria: ");
				curso.setCargaHoraria(leitor.nextInt());
				leitor.nextLine();

				System.out.println("situação Atual: " + curso.getSituacao() + "\nDigite a nova situação: ");
				curso.setSituacao(leitor.nextLine());

				cursoDao.atualizar(curso);
				System.out.println("Tarefa Atualizada com SUCESSO.");
			} else {
				System.out.println("Não foi encontrado um curso com o Codigo informado");
			}
		} catch (Exception e) {
			System.out.println("Erro ao atualizar cursos " + e.getMessage());
		}
	}
	
	public static void listarCursos() {
		System.out.println("***Listar Cursos***");
		CursosDAO cursoDao = new CursosDAO();
		List<Cursos> curso;
		
		try {
			curso = cursoDao.buscarTodos();
			
			if(curso!=null && curso.size()>0) {
				System.err.println("CODIGO\t\t NIVEL\t\t NOME\t\t\t CARGAHORARIA\t\t SITUAÇAO");
				for(Cursos cursos : curso) {
					//System.out.println(cursos.getCodigo());
					System.out.println(cursos.getCodigo() +"\t\t "+ cursos.getNivel() +"\t\t "+ cursos.getNome() +"\t\t\t "+ cursos.getCargaHoraria()
					+ "\t\t "+ cursos.getSituacao());
					//System.out.println("\t\t\t "+ cursos.getNome());
					//System.out.println("\t\t\t\t "+ cursos.getCargaHoraria());
					//System.out.println("\t\t\t\t\t "+ cursos.getSituacao());
				}
				System.out.println("\n");
			}else {
				System.out.println("Lista de Cursos nao encontrada");
			}
		}catch(Exception e) {
			System.out.println("Erro ao bucar Cursos" + e.getMessage());
		}
	}
	
	public static void excluirCursos(Scanner leitor) {
		System.out.println("***Excluir Cursos***");
		System.out.println("Digite o codigo do Curso que deseja Excluir:");
		int codigoCursoExcluir = leitor.nextInt();
		leitor.nextLine();
		CursosDAO cursoDao = new CursosDAO();
		try{
			cursoDao.exluir(codigoCursoExcluir);
			System.out.println("Curso exlcuida com SUCESSO");
		}catch(Exception e){
			System.out.println("Erro ao excluir Curso " +e.getMessage());	
		}
	}

}
