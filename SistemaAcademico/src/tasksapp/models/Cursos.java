package tasksapp.models;


public class Cursos {
	private int codigo;
	private int nivel;
	private String nome;
	private int cargaHoraria;
	private String situacao;
	
	public Cursos() {
		this.codigo=0;
	}
	
	public Cursos(int nivel, String nome, int cargaHoraria, String situacao) throws Exception {
		this.codigo = 0;
		this.setNivel(nivel);
		this.setNome(nome);
		this.setCargaHoraria(cargaHoraria);
		this.setSituacao(situacao);
	}
	
	public Cursos(int codigo, int nivel, String nome, int cargaHoraria, String situacao) throws Exception {
		this(nivel, nome, cargaHoraria, situacao);
		this.codigo = codigo;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) throws Exception {
		if(codigo < 0) {
			throw new Exception("O codigo do curso nao pode ser menor que zero");
		}
		if(this.codigo != 0) {
			throw new Exception("Não é possivel ter codigos com mesmos valores");
		}
		this.codigo = codigo;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) throws Exception{
		//if(nivel <= 0 || nivel > 4) {
			//throw new Exception("Nivel de curso Invalido");
		//}
		this.nivel = nivel;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) throws Exception{
		if(nome.length() > 60) {
			throw new Exception("Tamanho maximo de 60 Caracter");
		}
		this.nome = nome;
	}

	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	
	public String getNomeNivel() {
		switch(this.nivel) {
		case 1:
			return "Fundamental";
		case 2:
			return "Medio";
		case 3:
			return "Superior";
		default:
			return null;
		}
	}
	
	public boolean isValid() {
		if(this.nome != null && this.situacao != null) {
			return true;
		}else {
			return false;
		}
		
	}
	
}
