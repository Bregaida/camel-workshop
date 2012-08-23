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
Crie um novo projeto, no Eclipse, utilizando o wizard de projeto Maven (Maven Project). Na caixa de criação de projetos, certifique-se de NÃO marcar a caixa "Create a simple project (skip archetype selection)". Clique em next. Na caixa de filtragem de arquétipos, digite "Camel" e aguarde o Eclipse realizar a filtragem. Assim que ele terminar, selecione o arquétipo camel-archetype-webconsole. Coloque o group Id e o artifact Id como for de sua preferência e clique em Finish. 