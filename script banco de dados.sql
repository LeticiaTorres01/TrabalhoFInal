create table if not exists cliente(
    codCliente int primary key,
    rgCliente varchar(9) not null unique,
    enderecoCliente varchar(255) not null,
    bairroCliente varchar(255) not null,
    cidadeCliente varchar(255)not null,
    estadoCliente varchar(255) not null,
    CEPCliente varchar(10) not null,
    nascimentoCliente date not null
);

create table if not exists chale(
    codChale int primary key,
    capacidade int not null,
    localizacao varchar(255) not null,
    valorAltaEstacao double precision not null,
    valorBaixaEstacao double precision not null
);

create table if not exists hospedagem(
    codHospedagem int primary key,
    estado varchar(255) not null,
    dataInicio date not null,
    dataFim date,
    qtdPessoas int not null,
    desconto real not null,
    valorFinal double precision,
    codCliente int references cliente(codCliente),
    codChale int references chale(codChale)
);
