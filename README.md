# JavaSistemaAcademico

Sistema de cadastro, edição, exclusão e listagem de cursos utilizando java com padrão DAO.
Conexão no banco de dados atraves da API JDBC com Banco de dados MySQL.

## Cadastro
O sistema solicita os dados necessários para a cadastro do curso, insere o novo curso no banco de dados
e emite aviso informando se a operação foi bem sucedida.

![image](https://user-images.githubusercontent.com/71149968/123691078-2cae2f80-d823-11eb-8576-d976853c4213.png)

## Editar
O sistema solicita o código do curso a ser editado, busca o curso e possibilita que o usuario faça a edição desejada e por fim salva a versão atualizada do curso no banco de dados.

![image](https://user-images.githubusercontent.com/71149968/123691232-5a937400-d823-11eb-9095-cb17a1585551.png)

## Ecluir
O sistema solicita o código do curso a ser exlcuido, emite aviso se a operação foi bem sucedida ou se o código nao for encontrado.

![image](https://user-images.githubusercontent.com/71149968/123691311-75fe7f00-d823-11eb-8464-cb6b72fe5e85.png)

## Listar
O sistema busca os cursos cadastrados e então lista todas as informações de todos os cursos. ou caso não tenha cadastros emite o aviso "Não há cursos cadastrados".

![image](https://user-images.githubusercontent.com/71149968/123691449-a3e3c380-d823-11eb-9e96-9c1645bb8d2e.png)
