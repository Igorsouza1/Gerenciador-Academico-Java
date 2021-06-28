# JavaSistemaAcademico

Sistema de cadastro, edição, exclusão e listagem de cursos utilizando java com padrão DAO.
Conexão no banco de dados atraves da API JDBC com Banco de dados MySQL.

## Cadastro
O sistema solicita os dados necessários para a cadastro do curso, insere o novo curso no banco de dados
e emite aviso informando se a operação foi bem sucedida.

## Editar
O sistema solicita o código do curso a ser editado, busca o curso e possibilita que o usuario faça a edição desejada e por fim salva a versão atualizada do curso no banco de dados.

## Ecluir
O sistema solicita o código do curso a ser exlcuido, emite aviso se a operação foi bem sucedida ou se o código nao for encontrado.

## Listar
O sistema busca os cursos cadastrados e então lista todas as informações de todos os cursos. ou caso não tenha cadastros emite o aviso "Não há cursos cadastrados".

