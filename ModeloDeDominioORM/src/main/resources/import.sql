INSERT INTO tb_categoria(descricao) VALUES ('Curso');
INSERT INTO tb_categoria(descricao) VALUES ('Oficina');


INSERT INTO tb_participante(email, nome) VALUES ('jose@gmail.com','José Silva');
INSERT INTO tb_participante(email, nome) VALUES ('tiago@gmail.com','Tiago Faria');
INSERT INTO tb_participante(email, nome) VALUES ('maria@gmail.com','Maria do Rosario');
INSERT INTO tb_participante(email, nome) VALUES ('teresa@gmail.com','Teresa Silva');


INSERT INTO tb_atividade(categoria_id, preco, descricao, nome) VALUES (1,80.0,'Aprenda HTML de forma prática','Curso de HTML');
INSERT INTO tb_atividade(categoria_id, preco, descricao, nome) VALUES (2,50.0,'Controle de versoes de seus projetos','Oficina de Github');

INSERT INTO tb_bloco(inicio,fim,atividade_id) VALUES ('2017-09-25T08:00:00Z', '2017-09-25T11:00:00Z', 1);
INSERT INTO tb_bloco(inicio,fim,atividade_id) VALUES ('2017-09-25T14:00:00Z', '2017-09-25T18:00:00Z', 2);
INSERT INTO tb_bloco(inicio,fim,atividade_id) VALUES ('2017-09-26T08:00:00Z', '2017-09-26T11:00:00Z', 2);

INSERT INTO tb_participante_atividade(atividade_id, participante_id) VALUES (1, 1);
INSERT INTO tb_participante_atividade(atividade_id, participante_id) VALUES (2, 1);
INSERT INTO tb_participante_atividade(atividade_id, participante_id) VALUES (1, 2);
INSERT INTO tb_participante_atividade(atividade_id, participante_id) VALUES (1, 3);
INSERT INTO tb_participante_atividade(atividade_id, participante_id) VALUES (2, 3);
INSERT INTO tb_participante_atividade(atividade_id, participante_id) VALUES (1, 4);




