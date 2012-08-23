Workshop Camel
==============

Pré requisitos
---------------

* JDK 1.6+
* Eclipse com plugin m2e

Preparação
---------------
Abra o Eclipse, vá até Window -> Preferences -> Maven -> Archetypes. Clique em Add Remote Catalog e adicione o arquivo https://repository.apache.org/content/groups/snapshots-group , com qualquer descrição. Clique em OK duas vezes (uma para fechar a caixa de adição de diálogos e outra para fechar o menu Window). 


Criando o projeto
---------------
Crie um novo projeto, no Eclipse, utilizando o wizard de projeto Maven (Maven Project). Na caixa de criação de projetos, certifique-se de NÃO marcar a caixa "Create a simple project (skip archetype selection)". Clique em next. Na caixa de filtragem de arquétipos, digite "Camel" e aguarde o Eclipse realizar a filtragem. Assim que ele terminar, selecione o arquétipo camel-archetype-war. Coloque o group Id e o artifact Id como for de sua preferência e clique em Finish. 


Rodando o projeto
---------------
Abra o arquivo pom.xml, na raiz do projeto, e localize a tag camel-version. Atualize o conteúdo para 2.10.0. Clique com o botão direito em cima do projeto recém-criado e selecione Run As -> Maven Build... . Na caixa que abrir, coloque como goals clean jetty:run. Na aba JRE, adicione a seguinte diretiva: "-XX:MaxPermSize=256M" (sem as aspas) e clique em Run. O Camel será inicializado utilizando um contêiner Jetty embutido.

Entendendo o que está sendo feito
---------------
Esse projeto está configurado para inicializar duas rotas do Camel: uma, que lê arquivos de uma pasta (que está, a partir da raiz do projeto, em src/data) e imprime o conteúdo na saída padrão do sistema, ao mesmo tempo que manda para uma fila do ActiveMQ (a saber, personnel.records). A segunda rota consome essas mensagens e faz um teste, baseado em XPath, para descobrir em que pasta deve salvar o registro consumido. Se a cidade for London, salva (a partir da raiz do projeto) em target/messages/uk. Caso contrário, salva em target/messages/others. 

Além disso, tudo isso é publicado em um console web (acessado em http://localhost:8080/) e por uma API Rest, cuja documentação pode ser encontrada em http://localhost:8080/api. 
