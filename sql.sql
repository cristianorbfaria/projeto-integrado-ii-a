create table if not exists perguntas(
    id_pergunta int not null auto_increment,
    numero_pergunta int not null,
    enunciado varchar(255) not null,
    primary key (id_pergunta)
);

create table if not exists tipos(
    id_tipo int not null auto_increment,
    tipo varchar(255),
    fk_id_pergunta int not null,
    foreign key (fk_id_pergunta) references perguntas(id_pergunta),
    primary key (id_tipo)
);

create table if not exists resposta_padrao(
    id_resposta_padrao int not null auto_increment,
    valor_v_ou_f char(5),
    valor_x char(1),
    fk_id_pergunta int not null,
    fk_id_tipo int not null,
    foreign key (fk_id_pergunta) references perguntas(id_pergunta),
    foreign key (fk_id_tipo) references tipos(id_tipo),
    primary key (id_resposta_padrao)
);

create table if not exists alternativas(
    id_alternativas int not null auto_increment,
    opcoes varchar(255),
    descricao varchar(255),
    fk_id_pergunta int not null,
    fk_id_tipo int not null,
    foreign key (fk_id_pergunta) references perguntas(id_pergunta),
    foreign key (fk_id_tipo) references tipos(id_tipo),
    primary key (id_alternativas)
);

drop table alternativas, resposta_padrao, tipos, perguntas;