# JavaSistemaAcademico

### 📋Sobre
Sistema de cadastro, edição, exclusão e listagem de cursos utilizando java com padrão DAO.
Conexão no banco de dados atraves do JDBC com Banco de dados MySQL.

### 💻 Pré-requisitos

Antes de começar, verifique se você atendeu aos seguintes requisitos:

* Você instalou: `<JRE: 14 / MySql-Conector8.0 / MySQLDB`
* Você tem uma máquina `<Windows / Linux / Mac>`.

## 🚀 Usando Java Sistema Academico

Para instalar siga estas etapas:

```
Git clone https://github.com/Igorsouza1/Java-Sistema-Cursos.git
```
- Adicione a JRE 11
- Adicione a dependecia MySQL-Conector-8.0.25 Disponivel em :
` https://downloads.mysql.com/archives/c-j/`

- Crie um banco de dados com o nome "academicodb" e conecte com seu Login e senha
- Crie uma tabela chamad Cursos com os seguintes atributos
`
   create table Cursos(
	  codigo PRIMARY KEY AUTO_INCREMENT,
	  nivel INTEGER,
    nome CHAR(50),
    cargahoraria INTEGER,
    situacao CHAR(50)
);`
- De o start na aplicação



## Cadastro
O sistema solicita os dados necessários para a cadastro do curso, insere o novo curso no banco de dados
e emite aviso informando se a operação foi bem sucedida.

![image](https://user-images.githubusercontent.com/71149968/123691078-2cae2f80-d823-11eb-8576-d976853c4213.png)

## Editar
O sistema solicita o código do curso a ser editado, busca o curso e possibilita que o usuario faça a edição desejada e por fim salva a versão atualizada do curso no banco de dados.

![image](https://user-images.githubusercontent.com/71149968/123691232-5a937400-d823-11eb-9095-cb17a1585551.png)

## Excluir
O sistema solicita o código do curso a ser exlcuido, emite aviso se a operação foi bem sucedida ou se o código nao for encontrado.

![image](https://user-images.githubusercontent.com/71149968/123691311-75fe7f00-d823-11eb-8464-cb6b72fe5e85.png)

## Listar
O sistema busca os cursos cadastrados e então lista todas as informações de todos os cursos. ou caso não tenha cadastros emite o aviso "Não há cursos cadastrados".

![image](https://user-images.githubusercontent.com/71149968/123691449-a3e3c380-d823-11eb-9e96-9c1645bb8d2e.png)
