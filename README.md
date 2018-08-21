# Projeto​: meta-fabiano
## Descrião: 
Sistema de pedidos por cliente com autenticação

# Avaliação WEB II
A empresa Stling equipamentos possui um ecossistema de software que foi desenvolvido
ao longo do tempo para suprir as necessidades da empresa.
Você foi contratado para desenvolver um novo módulo para que os vendedores possam
lançar os pedidos via web conforme visitam os clientes. O sistema deve utilizar o banco de
dados legado da empresa como base para todas operações e deverá ser construído
pensando que poderão haver integrações futuras com outros serviços, dispositivos e
tecnologias externas.
Esse sistema deve permitir as seguintes funcionalidades:

## Clientes
- Cadastro - Permitir cadastrar o cliente, onde deve-se verificar se o cpf ou cnpj
já existe na base a alertar ao vendedor que o cliente já existe.
- Consulta - Permitir consultar o cliente por nome.
- Atualização Cadastral - Atualização dos dados cadastrais do cliente.

## Produtos
- Consulta - A consulta dos produtos pode ser pelo código ou descrição. Os
vendedores normalmente preferem pelo código.

## Pedidos
- Lançamento - Deve ser possível criar um pedido onde possa ser vinculado
um cliente existente e o lançamento dos produtos. O valor total dos itens
assim como o total do pedido devem ser atualizados em automaticamente na
tela.
- Alteração - Permite inserir e/ou excluir novos itens e alterar quantidade de
itens já lançados.
- Finalização do pedido - Deve permitir a finalização do pedido de forma que o
mesmo não poderá mais ser atualizado após a emissão.

## Acesso
- Login - Somente usuários do tipo vendedor podem acessar o sistema.

### OBS.: O desenvolvimento deve ser feito utilizando tecnologia Java (1.8+), onde:

> Backend 
- Deve ser baseado em API REST onde poderá utilizar JAX-RS ou mesmo spring boot. Seria desejável​ que a API desenvolvida deve ter segurança, seja via
JWT, OAUTH2.

> Frontend:
- Utilizar algum framework baseado em javascript como (angular, react, etc)
- Fazer uso de bootstrap para a concepção das telas.
- Como diferencial​, utilizar um gestor de dependências javascript como por
exemplo o yarn.

> Outros
- Empregar para a persistência de dados, banco Mysql.
- Utilizar boas práticas de Orientação à Objetos, estruturando os pacotes e criando
das camadas de sistema adequadamente.
- Como sistema de versionamento deverá utilizar Git utilizando também de boas
práticas de versionamento. Crie um branch para cada features desenvolvida. 
- Utilizar Git Flow será um diferencial.

O software deverá ser disponibilizado via github e será avaliado pela estruturação e
atendimento dos requisitos.
