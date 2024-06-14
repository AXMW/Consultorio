CREATE DATABASE consultorio;
USE consultorio;

CREATE TABLE Paciente (
	ID_Pac INT NOT NULL AUTO_INCREMENT,
    Nome_Pac VARCHAR(100),
    Endereco_Pac VARCHAR(300),
    Tipo_Sanguineo VARCHAR(3),
    CPF_Pac VARCHAR(11),
    Telefone VARCHAR(15),
    PRIMARY KEY(ID_Pac)
);

CREATE TABLE Funcionario (
	ID_Func INT NOT NULL AUTO_INCREMENT,
    Nome_Func VARCHAR(100),
    Login VARCHAR(20),
    Senha VARCHAR(12),
    Gerente BOOLEAN,
    PRIMARY KEY(ID_Func)
);

CREATE TABLE Dentista (
	ID_Dent INT NOT NULL AUTO_INCREMENT,
    Nome_Dent VARCHAR(100),
    CRM VARCHAR(20),
    Especialidade VARCHAR(50),
    PRIMARY KEY(ID_Dent)
);

CREATE TABLE Consulta (
	ID_Consulta INT NOT NULL AUTO_INCREMENT UNIQUE,
    Tipo_Consulta VARCHAR(50),
    Data_Consulta DATETIME,
    ID_Pac INT,
    ID_Func INT,
    ID_Dent INT,
    FOREIGN KEY(ID_Pac) REFERENCES Paciente(ID_Pac),
    FOREIGN KEY(ID_Func) REFERENCES Funcionario(ID_Func),
    FOREIGN KEY(ID_Dent) REFERENCES Dentista(ID_Dent)
);

INSERT INTO Funcionario(Nome_Func, Login, Senha, Gerente)
VALUES ('Admin', 'Admin', 'Admin', true);

CREATE DATABASE consultorio;
USE consultorio;

CREATE TABLE Paciente (
	ID_Pac INT NOT NULL AUTO_INCREMENT,
    Nome_Pac VARCHAR(100),
    Endereco_Pac VARCHAR(300),
    Tipo_Sanguineo VARCHAR(3),
    CPF_Pac VARCHAR(11),
    Telefone VARCHAR(15),
    PRIMARY KEY(ID_Pac)
);

CREATE TABLE Funcionario (
	ID_Func INT NOT NULL AUTO_INCREMENT,
    Nome_Func VARCHAR(100),
    Login VARCHAR(8),
    Senha VARCHAR(12),
    Gerente BOOLEAN,
    PRIMARY KEY(ID_Func)
);

CREATE TABLE Dentista (
	ID_Dent INT NOT NULL AUTO_INCREMENT,
    Nome_Dent VARCHAR(100),
    CRM VARCHAR(20),
    Especialidade VARCHAR(50),
    PRIMARY KEY(ID_Dent)
);

CREATE TABLE Consulta (
	ID_Consulta INT NOT NULL AUTO_INCREMENT UNIQUE,
    Tipo_Consulta VARCHAR(50),
    Data_Consulta DATETIME,
    ID_Pac INT,
    ID_Func INT,
    ID_Dent INT,
    FOREIGN KEY(ID_Pac) REFERENCES Paciente(ID_Pac),
    FOREIGN KEY(ID_Func) REFERENCES Funcionario(ID_Func),
    FOREIGN KEY(ID_Dent) REFERENCES Dentista(ID_Dent)
);

INSERT INTO Funcionario(Nome_Func, Login, Senha, Gerente)
VALUES ('Admin', 'Admin', 'Admin', true);

INSERT INTO Paciente (Nome_Pac, Endereco_Pac, Tipo_Sanguineo, CPF_Pac, Telefone) VALUES
('João Silva', 'Rua A, 123', 'O+', '12345678901', '11987654321'),
('Maria Oliveira', 'Rua B, 456', 'A-', '23456789012', '11987654322'),
('Pedro Santos', 'Rua C, 789', 'B+', '34567890123', '11987654323'),
('Ana Costa', 'Rua D, 101', 'AB-', '45678901234', '11987654324'),
('Lucas Lima', 'Rua E, 102', 'O-', '56789012345', '11987654325'),
('Mariana Sousa', 'Rua F, 103', 'A+', '67890123456', '11987654326'),
('Felipe Ferreira', 'Rua G, 104', 'B-', '78901234567', '11987654327'),
('Isabela Rocha', 'Rua H, 105', 'AB+', '89012345678', '11987654328'),
('Gustavo Alves', 'Rua I, 106', 'O+', '90123456789', '11987654329'),
('Carolina Mendes', 'Rua J, 107', 'A-', '01234567890', '11987654330');

INSERT INTO Funcionario (Nome_Func, Login, Senha, Gerente) VALUES
('Alice Borges', 'aliceb', 'password1', false),
('Carlos Pereira', 'carlosp', 'password2', false),
('Daniela Martins', 'danielam', 'password3', false),
('Eduardo Nunes', 'eduardon', 'password4', false),
('Fernanda Lima', 'fernandal', 'password5', false),
('Gabriel Souza', 'gabriels', 'password6', false),
('Helena Castro', 'helenac', 'password7', false),
('Igor Almeida', 'igora', 'password8', false),
('Juliana Santos', 'julianas', 'password9', false),
('Lucas Moreira', 'lucasm', 'password10', false);

INSERT INTO Dentista (Nome_Dent, CRM, Especialidade) VALUES
('Dr. Rafael Ribeiro', 'CRM12345', 'Ortodontia'),
('Dr. Mariana Fernandes', 'CRM23456', 'Endodontia'),
('Dr. Thiago Costa', 'CRM34567', 'Periodontia'),
('Dr. Amanda Almeida', 'CRM45678', 'Prótese Dentária'),
('Dr. Bruno Lima', 'CRM56789', 'Odontopediatria'),
('Dr. Camila Silva', 'CRM67890', 'Cirurgia Oral'),
('Dr. Felipe Araújo', 'CRM78901', 'Implantodontia'),
('Dr. Larissa Oliveira', 'CRM89012', 'Estética Dental'),
('Dr. Marcelo Souza', 'CRM90123', 'Odontogeriatria'),
('Dr. Vanessa Rocha', 'CRM01234', 'Radiologia Odontológica');

INSERT INTO Consulta (Tipo_Consulta, Data_Consulta, ID_Pac, ID_Func, ID_Dent) VALUES
('Limpeza', '2024-06-20 09:00:00', 1, 1, 1),
('Check-up', '2024-06-21 10:00:00', 2, 2, 2),
('Clareamento', '2024-06-22 11:00:00', 3, 3, 3),
('Extração', '2024-06-23 12:00:00', 4, 4, 4),
('Aparelho', '2024-06-24 13:00:00', 5, 5, 5),
('Canais', '2024-06-25 14:00:00', 6, 6, 6),
('Prótese', '2024-06-26 15:00:00', 7, 7, 7),
('Ortodontia', '2024-06-27 16:00:00', 8, 8, 8),
('Implante', '2024-06-28 17:00:00', 9, 9, 9),
('Radiografia', '2024-06-29 18:00:00', 10, 10, 10);