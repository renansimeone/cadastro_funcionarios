create database cadastro;
use cadastro;
create table pessoa(
  id int primary key auto_increment,
  nome char(50) not null,
  email char(50) unique,
  idade int not null,
  telefone char(13) not null,
  ativo bool not null
);
insert into pessoa values(null, 'Renan Simeone Moreira', 'renansimeone@gmail.com', '30', '5521975599081', true);
insert into pessoa values(null, 'Victor Simeone Moreira', 'vcitorsimeone@gmail.com', '26', '5521975599080', true);