# Projeto Validador de Textos

[github](https://github.com/ruaanc/attribute-validator-api)

## Equipe

- Ruan Carlos Alves da Silva - rcas@cin.ufpe.br

## Projeto

Esse projeto tem como objetivo criar uma DSL para validar textos em java. Para criar 
essa ferramenta é utilizado o compilador para java [Javacc](https://javacc.github.io/javacc/).

## Contexto

Uma DSL que valida texto pode ser utilizada em diversos cenários. Exemplos: 

1. Para validar o email do usuário antes de fazer login.
2. Em um aplicativo de gerenciamento de contatos, pode ser utilizada para validar nome ou email no formulário de cadastro.
3. Em um sistema de envio de emails, a DSL pode ser usada para garantir que os endereços de email fornecidos sejam válidos antes do envio dos emails.

## Gramática

[Gramática no JAVACC]()

### BNF
```
<start> ::= (<name> | <email>)*

<name> ::= <NAME>

<email> ::= <EMAIL>

<NAME> ::= (["a"-"z","A"-"Z"])+

<EMAIL> ::= (["a"-"z","A"-"Z","0"-"9","+","-","_",".","@"])+
```

## Configurações para execução:

1. Baixe e instale o JavaCC: http://javacc.org/;
2. Compile o arquivo .jj;

``` shell
javacc ValidationDSL.jj
``` 
3. Compile o arquivo Java gerado;

``` shell
javac ValidationDSL.java
```
4. Execute o arquivo Java

``` shell
java ValidationDSL
```