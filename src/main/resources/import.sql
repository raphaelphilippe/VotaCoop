insert into Usuario (id, nome, cpf, email) values (1, 'Raphael', '96887565048', 'raphael@gmail.com');
insert into Usuario (id, nome, cpf, email) values (2, 'Andrea', '21518556000', 'andrea@gmail.com');
insert into Usuario (id, nome, cpf, email) values (3, 'Virginia', '90067359060', 'virginia@gmail.com');
insert into Usuario (id, nome, cpf, email) values (4, 'Batista', '88260001071', 'batista@gmail.com');
insert into Usuario (id, nome, cpf, email) values (5, 'Bruno', '46942410012', 'bruno@gmail.com');

insert into Pauta (id, data_Criacao_Pauta, descricao, status_Pauta) values (1, '2021-07-26T01:07:00.000', 'PAUTA 1 #########################', 1)
insert into Sessao_Votacao (pauta_id, data_hora_inicio_sessao, tempo_prazo) values (1, '2021-07-26T01:11:00.000', '01:02')

insert into voto (id, data_hora_voto, voto, id_sessao, id_usuario) values (1, '2021-07-26T01:16:00.000', 1, 1, 1)
insert into voto (id, data_hora_voto, voto, id_sessao, id_usuario) values (2, '2021-07-26T01:17:00.000', 1, 1, 2)
insert into voto (id, data_hora_voto, voto, id_sessao, id_usuario) values (3, '2021-07-26T01:18:00.000', 0, 1, 3)
insert into voto (id, data_hora_voto, voto, id_sessao, id_usuario) values (4, '2021-07-26T01:19:00.000', 0, 1, 4)

insert into Pauta (id, data_Criacao_Pauta, descricao, status_Pauta) values (2, '2021-07-26T01:07:00.000', 'PAUTA 2 #########################', 1)
insert into Sessao_Votacao (pauta_id, data_hora_inicio_sessao, tempo_prazo) values (2, '2021-07-26T01:11:00.000', '01:02')

insert into voto (id, data_hora_voto, voto, id_sessao, id_usuario) values (5, '2021-07-26T01:16:00.000', 1, 2, 1)
insert into voto (id, data_hora_voto, voto, id_sessao, id_usuario) values (6, '2021-07-26T01:17:00.000', 1, 2, 2)
insert into voto (id, data_hora_voto, voto, id_sessao, id_usuario) values (7, '2021-07-26T01:18:00.000', 0, 2, 3)
insert into voto (id, data_hora_voto, voto, id_sessao, id_usuario) values (8, '2021-07-26T01:19:00.000', 0, 2, 4)