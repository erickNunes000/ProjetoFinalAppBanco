SELECT *FROM  conta;
insert into usuarios (cpf,nome,cargo,senha)
values
('04694891383','Erico Nunes','Gerente','12345'),
('1234568900','Vanderson','Diretor','159789')
;

insert into usuarios (cpf,nome,cargo,senha)
values
('98555412300','Maria de Loudes','Cli Corrente','156698752');
 
alter table usuarios change cargo vinculo varchar(30) not null;
update usuarios set vinculo = 'Cliente Corrente' where cpf = '98555412300';
describe usuarios;
select *from conta;
select *from usuarios where cpf='04694891383';
describe conta;
alter table conta modify column emprestimo varchar(20) not null;
describe historico;
select *from conta;
select *from usuarios;
alter table conta modify column cpf varchar(30) not null;
alter table conta modify column saldo double not null;
select titular,numConta from conta where cpf='04694891383';
update conta set saldo=saldo+100 where numConta=1096 ;
describe historico;
alter table historico modify column detalhes timestamp default current_timestamp;
select *from conta cross join usuarios on usuarios.cpf=conta.cpf where usuarios.senha=156698752 and usuarios.cpf='98555412300';
select  conta.cpf as id ,titular, numConta, saldo, emprestimo from conta inner join usuarios on usuarios.cpf=conta.cpf;
select operacao, valor as 'valor R$', DATE_FORMAT(detalhes, '%d/%m/%Y') as 'Data' from historico;

select *from conta;










