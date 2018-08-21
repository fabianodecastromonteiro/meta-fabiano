-- TIPO DE USUÀRIO
insert into TipoUsuario (id, descricao) values (1, 'Administrador');
insert into TipoUsuario (id, descricao) values (2, 'Vendedor');
insert into TipoUsuario (id, descricao) values (3, 'Operador');

-- USUÀRIO
insert into Usuario (id, nome, email, senha, tipo) values (1, 'admin', 'admin@stling.com', '123', 1);
insert into Usuario (id, nome, email, senha, tipo) values (1, 'vende', 'vendde@stling.com', '123', 2);
insert into Usuario (id, nome, email, senha, tipo) values (1, 'oper', 'oper@stling.com', '123', 3);

-- CLIENTE
insert into Cliente (id, nome, cpfcnpj, endereco) values (1, 'Efigenia Daughtfier', '11111111111', 'Rua inexistente, S/N');
insert into Cliente (id, nome, cpfcnpj, endereco) values (2, 'Marechal Floriano Peixoto', '22222222222', 'Rua Rendeiras, S/N');
insert into Cliente (id, nome, cpfcnpj, endereco) values (3, 'Petter Pan', '33333333333', 'Rua Encantada, S/N');

-- PRODUTO
insert into Produto (id, descricao, valor) values (1, 'Coxinha de frango', 3.90);
insert into Produto (id, descricao, valor) values (1, 'Coxinha de frango', 3.90);
insert into Produto (id, descricao, valor) values (1, 'Coxinha de frango', 3.90);


insert into Ficha (id, dtCadastro, observacao, status) values (1, '2018-08-05 00:00:00', 'Observando meus animais de estimação', true);
insert into Ficha (id, dtCadastro, observacao, status) values (2, '2018-08-10 00:00:00', 'Observando as formigas da minha casa', true);
insert into Ficha (id, dtCadastro, observacao, status) values (3, '2018-08-15 00:00:00', 'Observando animais no zoológico', true);

insert into Animal (id, nome, idFicha) values (1, 'Marco', 1);
insert into Animal (id, nome, idFicha) values (2, 'Meguie', 1);
insert into Animal (id, nome, idFicha) values (3, 'Formigas', 2);
insert into Animal (id, nome, idFicha) values (4, 'Simba', 3);
insert into Animal (id, nome, idFicha) values (5, 'Alex', 3);
