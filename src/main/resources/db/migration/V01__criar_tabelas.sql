CREATE TABLE public.pessoa (
	id_pessoa serial PRIMARY KEY,
	nome character varying(255)  NOT NULL ,
	data_nascimento date,
	email character varying(255)  NOT NULL ,
	cpf_cnpj BIGINT ,
	tipo_pessoa character varying(50),
	nome_estabelecimento character varying(255)  ,
	senha character varying(150),
	descricao_p character varying(255),
	descricao_m character varying(400),
	descricao_g character varying(1024),
	situacao_registro character varying(50), --'novo editado excluido'
	timestamp TIMESTAMP
);

CREATE TABLE public.endereco (
	id_endereco serial,
	id_pessoa BIGINT,
	logradouro character varying(255) ,
	numero int,
	complemento character varying(255),
	bairro character varying(100) ,
	cep BIGINT,
	cidade character varying(50),
	uf character varying(50),
	situacao_registro character varying(50), --'novo editado excluido'
	timestamp TIMESTAMP,
	PRIMARY KEY (id_endereco) 
);

CREATE TABLE public.contrato(
	id_contrato serial,
	id_plano BIGINT,
	id_pessoa_cadastradora BIGINT,
	id_endereco BIGINT,
	forma_pagamento character varying(100),
	valor decimal(10,02),
	data_assinatura date,
	data_fim date,
	status character varying(100),
	timestamp TIMESTAMP,
	PRIMARY KEY (id_contrato)
);

CREATE TABLE public.contrato_pessoa(
	id_contrato_pessoa serial,
	id_pessoa	BIGINT,
	id_contrato BIGINT,
	tipo_relacao_contrato character varying(50),
	situacao_registro character varying(50), --'novo editado excluido'
	timestamp TIMESTAMP,
	PRIMARY KEY (id_contrato_pessoa)
);

CREATE TABLE public.plano(
	id_plano serial,
	id_pessoa BIGINT,
	valor decimal(10,02),
	data_inicio date,
	data_fim date,
	status character varying(100),
	titulo character varying(255),
	descricao character varying(400),
	termos_contrato character varying(1024),
	timestamp TIMESTAMP,
	PRIMARY KEY (id_plano)
);

CREATE TABLE public.usuario (
	codigo  SERIAL PRIMARY KEY,
	nome character varying(50) NOT NULL,
	email character varying(50) NOT NULL,
	senha character varying(150) NOT NULL
);

CREATE TABLE public.permissao (
	codigo  SERIAL PRIMARY KEY,
	descricao character varying(50) NOT NULL
);

CREATE TABLE public.usuario_permissao (
	codigo_usuario BIGINT NOT NULL,
	codigo_permissao BIGINT NOT NULL,
	PRIMARY KEY (codigo_usuario, codigo_permissao),
	FOREIGN KEY (codigo_usuario) REFERENCES usuario(codigo),
	FOREIGN KEY (codigo_permissao) REFERENCES permissao(codigo)
);

INSERT INTO public.usuario (codigo, nome, email, senha) values (1, 'Administrador', 'admin@marquei.com.br', '$2a$10$X607ZPhQ4EgGNaYKt3n4SONjIv9zc.VMWdEuhCuba7oLAL5IvcL5.');
INSERT INTO public.usuario (codigo, nome, email, senha) values (2, 'Maria Silva', 'maria@marquei.com.br', '$2a$10$Zc3w6HyuPOPXamaMhh.PQOXvDnEsadztbfi6/RyZWJDzimE8WQjaq');

INSERT INTO public.permissao (codigo, descricao) values (1, 'ROLE_CADASTRAR_PERMISSAO');
INSERT INTO public.permissao (codigo, descricao) values (2, 'ROLE_PESQUISAR_PERMISSAO');

INSERT INTO public.permissao (codigo, descricao) values (3, 'ROLE_CADASTRAR_PESSOA');
INSERT INTO public.permissao (codigo, descricao) values (4, 'ROLE_REMOVER_PESSOA');
INSERT INTO public.permissao (codigo, descricao) values (5, 'ROLE_PESQUISAR_PESSOA');

INSERT INTO public.permissao (codigo, descricao) values (6, 'ROLE_CADASTRAR_PLANO');
INSERT INTO public.permissao (codigo, descricao) values (7, 'ROLE_REMOVER_PLANO');
INSERT INTO public.permissao (codigo, descricao) values (8, 'ROLE_PESQUISAR_PLANO');
INSERT INTO public.permissao (codigo, descricao) values (9, 'ROLE_ALTERAR_PLANO');

-- admin
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 1);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 2);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 3);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 4);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 5);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 6);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 7);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 8);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 9);

-- maria
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (2, 2);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (2, 5);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (2, 8);


insert into public.pessoa (nome, data_nascimento, email, cpf_cnpj, tipo_pessoa, nome_estabelecimento, senha, situacao_registro,timestamp) values ( 'Andresa', '1980-04-15', 'andresaleite@gmail.com', 90765788187, 'FISICA','','deesa','CONFIRMADO',now());
insert into public.endereco (id_pessoa, numero, complemento, bairro, cep, cidade, uf, situacao_registro,timestamp) values (1, 210, 'Edifício Estrela', 'Sudoeste', 70673409, 'Cruzeiro', 'DISTRITO_FEDERAL','CONFIRMADO',now());
insert into public.plano (id_pessoa, valor, data_inicio, data_fim, status, titulo, descricao, termos_contrato,timestamp) values ( 1, 0.0, now(), '2500-04-15','VIGENTE','Cliente dos serviços oferecidos pelo marquei.','Cliente blá blá blá', 'termos do contrato...',now());
insert into public.contrato (id_plano, id_pessoa_cadastradora, id_endereco, forma_pagamento, valor, data_assinatura, data_fim, status,timestamp) values ( 1, 1, 1, 'SEM_PAGAMENTO', 0.0, now(), '2500-04-15', 'VIGENTE',now());
insert into public.contrato_pessoa ( id_pessoa,id_contrato, tipo_relacao_contrato, situacao_registro,timestamp) values ( 1, 1, 'CLIENTE', 'CONFIRMADO',now());

insert into public.plano (id_pessoa, valor, data_inicio, data_fim, status, titulo, descricao, termos_contrato,timestamp) values ( 1, 0.0, now(), '2500-04-15','VIGENTE','Cadastrador de clientes','Cadastrador blá blá blá', 'termos do contrato cadastrador sem vinculo empregatício...',now());
insert into public.contrato (id_plano, id_pessoa_cadastradora, id_endereco, forma_pagamento, valor, data_assinatura, data_fim, status,timestamp) values ( 2, 1, 1, 'SEM_PAGAMENTO', 0.0, now(), '2500-04-15', 'VIGENTE',now());
insert into public.contrato_pessoa ( id_pessoa,id_contrato, tipo_relacao_contrato, situacao_registro,timestamp) values ( 1, 2, 'CADASTRADOR', 'CONFIRMADO',now());

ALTER TABLE public.pessoa ALTER COLUMN id_pessoa SET DEFAULT nextval('public.pessoa_id_pessoa_seq'::regclass);

/*
insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (1, 'vigencia_plano', 'Mensal', 1);
insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (2, 'vigencia_plano', 'Bimestral', 1);
insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (3, 'vigencia_plano', 'Trimestral', 1);
insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (4, 'vigencia_plano', 'Semestral', 1);
insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (5, 'vigencia_plano', 'Anual', 1);

insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (1, 'tipo_relacao_pessoa', 'Cliente', 1);
insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (2, 'tipo_relacao_pessoa', 'Fornecedor de serviço Administrador', 1);
insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (3, 'tipo_relacao_pessoa', 'Fornecedor de serviço Colaborador', 1);
insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (4, 'tipo_relacao_pessoa', 'Marcador de serviço', 1);
insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (5, 'tipo_relacao_pessoa', 'Empresa', 1);

insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (1, 'grupo_servico', 'Salão', 1);
insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (2, 'grupo_servico', 'Personal Trainer', 1);
insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (3, 'grupo_servico', 'Psicólogo', 1);
insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (4, 'grupo_servico', 'Dentista', 1);

insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (1, 'grupo_servico_1', 'Manicure', 1);
insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (2, 'grupo_servico_1', 'Corte de cabelo', 1);
insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (3, 'grupo_servico_1', 'Tintura de cabelo', 1);
insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (4, 'grupo_servico_1', 'Sobrancelha', 1);

insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (1, 'grupo_servico_1_1', 'Esmalte', 1);--material
insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (2, 'grupo_servico_1_1', 'Kit descartável', 1);--material

insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (1, 'grupo_servico_1_1_1', 'Colorama', 1);--marca esmalte
insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (2, 'grupo_servico_1_1_1', 'Risqué', 1);

insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (1, 'grupo_servico_1_1_1', 'Colorama', 1);--marca esmalte
insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (2, 'grupo_servico_1_1_1', 'Risqué', 1);

insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (1, 'grupo_servico_1_1_1_1', 'Gabriele', 1);--cor
insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (1, 'grupo_servico_1_1_1_1', 'França', 1);--cor

insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (1, 'convenio_medico', 'AFFEGO SAÚDE', 1);
insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (2, 'convenio_medico', 'AGMP – SAMP', 1);
insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (3, 'convenio_medico', 'ALLIANZ SAÚDE', 1);
insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (4, 'convenio_medico', 'ALLIANZ WORLDWIDE CARE', 1);
insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (5, 'convenio_medico', 'AMIL', 1);
insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (6, 'convenio_medico', 'APRIL BRASIL', 1);
insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (7, 'convenio_medico', 'ASSEFAZ', 1);
insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (8, 'convenio_medico', 'ASSIST-CARD', 1);
insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (9, 'convenio_medico', 'AXA ASSISTANCE', 1);
insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (10, 'convenio_medico', 'BACEN', 1);
insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (11, 'convenio_medico', 'BNDES – FAPES', 1);
insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (12, 'convenio_medico', 'BRADESCO', 1);
insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (13, 'convenio_medico', 'BRB SAÚDE', 1);
insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (14, 'convenio_medico', 'CAIXA', 1);
insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (15, 'convenio_medico', 'CASEMBRAPA', 1);
insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (16, 'convenio_medico', 'CASSI', 1);
insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (17, 'convenio_medico', 'CODEVASF – CASEC', 1);
insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (18, 'convenio_medico', 'EMBAIXADA COSTA DO MARFIM', 1);
insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (19, 'convenio_medico', 'EMBAIXADA REAL DA DINAMARCA', 1);
insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (20, 'convenio_medico', 'EMBAIXADA DA FINLÂNDIA', 1);
insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (21, 'convenio_medico', 'EMBAIXADA DA NIGÉRIA', 1);
insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (22, 'convenio_medico', 'EMBAIXADA DA INDIA', 1);
insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (23, 'convenio_medico', 'EMBAIXADA DOS EUA', 1);
insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (24, 'convenio_medico', 'EMBAIXADA DO CANADÁ', 1);
insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (25, 'convenio_medico', 'E-VIDA', 1);
insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (26, 'convenio_medico', 'FASCAL', 1);
insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (27, 'convenio_medico', 'FUNSA', 1);
insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (28, 'convenio_medico', 'GAMA SAÚDE', 1);
insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (29, 'convenio_medico', 'GEAP SAÚDE', 1);
insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (30, 'convenio_medico', 'GOLDEN CROSS', 1);
insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (31, 'convenio_medico', 'INFRAERO', 1);
insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (32, 'convenio_medico', 'INTERMEDICA', 1);
insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (33, 'convenio_medico', 'INTERNACIONAL SOS', 1);
insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (34, 'convenio_medico', 'LIFE EMPRESARIAL', 1);
insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (35, 'convenio_medico', 'MEDSERVICE', 1);
insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (36, 'convenio_medico', 'NOTREDAME', 1);
insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (37, 'convenio_medico', 'OMINT', 1);
insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (38, 'convenio_medico', 'PETROBRAS', 1);
insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (39, 'convenio_medico', 'MPM', 1);
insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (40, 'convenio_medico', 'MPT', 1);
insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (41, 'convenio_medico', 'MPF', 1);
insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (42, 'convenio_medico', 'POSTAL SAÚDE', 1);
insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (53, 'convenio_medico', 'PROASA', 1);
insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (44, 'convenio_medico', 'SEGUROS UNIMED', 1);
insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (45, 'convenio_medico', 'SERPRO', 1);
insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (46, 'convenio_medico', 'STF', 1);
insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (47, 'convenio_medico', 'STJ', 1);
insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (48, 'convenio_medico', 'STM', 1);
insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (49, 'convenio_medico', 'SULAMÉRCIA', 1);
insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (50, 'convenio_medico', 'T.R.E', 1);
insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (51, 'convenio_medico', 'TJDFT', 1);
insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (52, 'convenio_medico', 'TRF 1ª Região', 1);
insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (53, 'convenio_medico', 'TRT 10ª Região', 1);
insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (54, 'convenio_medico', 'TST SAÚDE', 1);
insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (55, 'convenio_medico', 'UNAFISCO SAÚDE', 1);
insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (56, 'convenio_medico', 'UNIMED CENTRAL NACIONAL – CNU', 1);

insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (1, 'status_horario', 'disponivel', 1);
insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (2, 'status_horario', 'indisponivel', 1);
insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (3, 'status_horario', 'talvez disponível', 1);
insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (4, 'status_horario', 'talvez indisponível', 1);

insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (1, 'status_horario', 'disponivel', 1);
insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (2, 'status_horario', 'indisponivel', 1);
insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (3, 'status_horario', 'talvez disponível', 1);
insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (4, 'status_horario', 'talvez indisponível', 1);

insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (1, 'confirmacao_horario', 'a confirmar', 1);
insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (2, 'confirmacao_horario', 'confirmado', 1);
insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (3, 'confirmacao_horario', 'atendido', 1);
insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (4, 'confirmacao_horario', 'faltou', 1);


insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (1, 'dia_semana', 'Segunda', 1);
insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (2, 'dia_semana', 'Terça', 1);
insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (3, 'dia_semana', 'Quarta', 1);
insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (4, 'dia_semana', 'Quinta', 1);
insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (5, 'dia_semana', 'Sexta', 1);
insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (6, 'dia_semana', 'Sábado', 1);
insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (7, 'dia_semana', 'Domingo', 1);

insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (1, 'relacao_imagem', 'pessoa', 1);
insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (2, 'relacao_imagem', 'serviço', 1);

insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (1, 'formato_imagem', 'gif', 1);
insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (2, 'formato_imagem', 'png', 1);
insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (3, 'formato_imagem', 'jpg', 1);
insert into public.controle (id_grupo_controle, nome_grupo_controle, nome_controle, situacao) values (4, 'formato_imagem', 'tiff', 1);




CREATE TABLE "baixa_bancaria" (

id_baixa_bancaria serial,

"id_contrato" int  NOT NULL,

"data_pagamento" date NOT NULL,

"valor_pagamento" numeric NOT NULL ,

"timestamp" timestamp default current_timestamp,

CONSTRAINT "baixa_bancaria_pk" PRIMARY KEY ("id_baixa_bancaria") 

)

WITHOUT OIDS;



ALTER TABLE "baixa_bancaria" OWNER TO "postgres";



CREATE TABLE "calendario" (

"id_calendario" serial,

"id_vl_tempo_servico" int4 NOT NULL,

"data" date ,

"hora" time(6) ,

"id_pessoa_cliente" int4 NOT NULL,

"id_grupo_controle_status_horario" int4 NOT NULL,

"id_grupo_controle_confirmacao" int4 NOT NULL,

"timestamp" timestamp default current_timestamp ,

CONSTRAINT "calendario_pk" PRIMARY KEY ("id_calendario") 

)

WITHOUT OIDS;



ALTER TABLE "calendario" OWNER TO "postgres";









CREATE TABLE "convenio_pessoa" (

"id_convenio_pessoa" serial ,

"id_relacao_pessoa" int4 NOT NULL,

"id_grupo_controle_convenio_medico" int4 NOT NULL,

"timestamp" timestamp default current_timestamp,

CONSTRAINT "convenio_pessoa_pk" PRIMARY KEY ("id_convenio_pessoa") 

)

WITHOUT OIDS;



ALTER TABLE "convenio_pessoa" OWNER TO "postgres";



CREATE TABLE "disponibilidade" (

"id_disponibilidade" serial,

"id_vl_tempo_servico" int4 NOT NULL ,

"hora_inicio" int4 NOT NULL ,

"hora_fim" int4 NOT NULL ,

"feriados" bool NOT NULL ,

"id_grupo_controle_dia_semana" varchar(12) NOT NULL,

"id_relacao_pessoa_atendimento" int4 NOT NULL,

"id_relacao_pessoa_criacao" int4 NOT NULL,--pessoa que cadastrou no sistema

"timestamp" timestamp default current_timestamp,

CONSTRAINT "disponibilidade_pk" PRIMARY KEY ("id_disponibilidade") 

)

WITHOUT OIDS;



ALTER TABLE "disponibilidade" OWNER TO "postgres";



CREATE TABLE "arquivo" (

"id_arquivo" serial,

"id_relacao_pessoa" int4 NOT NULL ,

"id_grupo_controle_relacao_arquivo" int4 NOT NULL,

"id_grupo_controle_formato_arquivo" int4 NOT NULL,

"arquivo" bytea not null,

"timestamp" timestamp default current_timestamp,

CONSTRAINT "arquivo_pk" PRIMARY KEY ("id_arquivo") 

)

WITHOUT OIDS;



ALTER TABLE "arquivo" OWNER TO "postgres";






CREATE TABLE "plano" (

"id_plano" int4 NOT NULL,

"valor" numeric NOT NULL ,

"nome" varchar(50) COLLATE "default" NOT NULL ,

"descricao" varchar(255) COLLATE "default" NOT NULL ,

"id_grupo_controle_vigencia" int4 NOT NULL ,

"timestamp" timestamp default current_timestamp,

CONSTRAINT "plano_pk" PRIMARY KEY ("id_plano") 

)

WITHOUT OIDS;



ALTER TABLE "plano" OWNER TO "postgres";




CREATE TABLE valor_tempo_service (

id_vl_tempo_servico int4 NOT NULL ,

grupo_controle_servico varchar NOT NULL ,

id_relacao_pessoa int4 NOT NULL ,

valor numeric NOT NULL ,

tempo_minuto int4 NOT NULL ,

timestamp timestamp default current_timestamp,

CONSTRAINT "valor_tempo_servico_pk" PRIMARY KEY (id_vl_tempo_servico) 

)

WITHOUT OIDS;



ALTER TABLE "valor_tempo_servico" OWNER TO "postgres";





ALTER TABLE "baixa_bancaria" ADD CONSTRAINT "baixa_bancaria_fk0" FOREIGN KEY ("id_contrato") REFERENCES "contrato" ("id_contrato") ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE "contrato" ADD CONSTRAINT "contrato_fk0" FOREIGN KEY ("id_relacao_pessoa") REFERENCES "relacao_pessoa" ("id_relacao_pessoa") ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE "contrato" ADD CONSTRAINT "contrato_fk1" FOREIGN KEY ("id_plano") REFERENCES "plano" ("id_plano") ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE "arquivo" ADD CONSTRAINT "arquivo_fk0" FOREIGN KEY ("id_relacao_pessoa") REFERENCES "relacao_pessoa" ("id_relacao_pessoa") ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE "relacao_pessoa" ADD CONSTRAINT "relacao_pessoa_fk0" FOREIGN KEY ("id_pessoa") REFERENCES "pessoa" ("id_pessoa") ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE "calendario" ADD CONSTRAINT "fk_tempo_serv_cal" FOREIGN KEY ("id_vl_tempo_servico") REFERENCES "valor_tempo_servico" ("id_vl_tempo_servico");

ALTER TABLE "calendario" ADD CONSTRAINT "fk_pessoa_cliente" FOREIGN KEY ("id_pessoa_cliente") REFERENCES "pessoa" ("id_pessoa");

ALTER TABLE "convenio_pessoa" ADD CONSTRAINT "fk_conv_pessoa" FOREIGN KEY ("id_relacao_pessoa") REFERENCES "relacao_pessoa" ("id_relacao_pessoa");

ALTER TABLE "disponibilidade" ADD CONSTRAINT "fk_tempo_disp" FOREIGN KEY ("id_vl_tempo_servico") REFERENCES "valor_tempo_servico" ("id_vl_tempo_servico");




*/
