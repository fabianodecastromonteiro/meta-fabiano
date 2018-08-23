-- TIPO DE USUÁRIO
insert into TipoUsuario (id, descricao) values (1, 'Administrador');
insert into TipoUsuario (id, descricao) values (2, 'Vendedor');
insert into TipoUsuario (id, descricao) values (3, 'Operador');

-- USUÁRIO
insert into Usuario (id, nome, email, senha, tipo) values (1, 'admin', 'admin@stling.com', '123', 1);
insert into Usuario (id, nome, email, senha, tipo) values (2, 'vend01', 'vendd01@stling.com', '123', 2);
insert into Usuario (id, nome, email, senha, tipo) values (3, 'vend02', 'vendd02@stling.com', '123', 2);
insert into Usuario (id, nome, email, senha, tipo) values (4, 'vend03', 'vendd03@stling.com', '123', 2);
insert into Usuario (id, nome, email, senha, tipo) values (5, 'oper', 'oper@stling.com', '123', 3);

-- CLIENTE
insert into Cliente (id, nome, cpfcnpj, endereco) values (1, 'Efigenia Daughtfier', '11111111111', 'Rua inexistente, S/N');
insert into Cliente (id, nome, cpfcnpj, endereco) values (2, 'Marechal Floriano Peixoto', '22222222222', 'Rua Rendeiras, S/N');
insert into Cliente (id, nome, cpfcnpj, endereco) values (3, 'Petter Pan', '33333333333', 'Rua Encantada, S/N');

-- PRODUTO
insert into Produto (id, descricao, valor) values (1, 'Coxinha de frango', 3.90);
insert into Produto (id, descricao, valor) values (2, 'Refrigerante 600ml', 3.50);
insert into Produto (id, descricao, valor) values (3, 'AçaÍ em polpa (500g)', 12.25);

-- PEDIDO
insert into Pedido (id, vendedor, cliente, dtCadastro, dtEmissao, dtFaturamento, valorTotal) values (1, 2, 2, '2018-08-01 00:00:00', '2018-08-01 00:00:00', '2018-08-15 00:00:00', 34.90);
insert into Pedido (id, vendedor, cliente, dtCadastro, dtEmissao, dtFaturamento, valorTotal) values (2, 4, 3, '2018-08-01 00:00:00', '2018-08-01 00:00:00', '2018-08-15 00:00:00', 34.90);

-- PEDIDOPRODUTO
insert into PedidoProduto (pedido, produto, quantidade) values (1, 1, 2);
insert into PedidoProduto (pedido, produto, quantidade) values (1, 2, 2);
insert into PedidoProduto (pedido, produto, quantidade) values (2, 3, 1);
