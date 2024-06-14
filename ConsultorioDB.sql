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