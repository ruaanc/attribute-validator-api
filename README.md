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

#### Fontes
[Program](https://github.com/ruaanc/attribute-validator-api/blob/add_expression/src/main/java/dsl/Program.java) ::= [Expression](https://github.com/ruaanc/attribute-validator-api/blob/add_expression/src/main/java/dsl/expression/Expression.java)

Expression ::= [Value](https://github.com/ruaanc/attribute-validator-api/blob/add_expression/src/main/java/dsl/expression/Value.java) | [UnaryExpression](https://github.com/ruaanc/attribute-validator-api/blob/add_expression/src/main/java/dsl/expression/UnaryExpression.java)

Value ::= [ConcreteValue](https://github.com/ruaanc/attribute-validator-api/blob/add_expression/src/main/java/dsl/expression/ConcreteValue.java)

ConcreteValue ::= [StringValue](https://github.com/ruaanc/attribute-validator-api/blob/add_expression/src/main/java/dsl/expression/StringValue.java)

UnaryExpression ::= [ZipCodeExpression](https://github.com/ruaanc/attribute-validator-api/blob/add_expression/src/main/java/dsl/expression/ZipCodeExpression.java) | [CnpjExpression](https://github.com/ruaanc/attribute-validator-api/blob/add_expression/src/main/java/dsl/expression/CnpjExpression.java) | [CpfExpression](https://github.com/ruaanc/attribute-validator-api/blob/add_expression/src/main/java/dsl/expression/CpfExpression.java) | [NameExpression](https://github.com/ruaanc/attribute-validator-api/blob/add_expression/src/main/java/dsl/expression/NameExpression.java) | [EmailExpression](https://github.com/ruaanc/attribute-validator-api/blob/add_expression/src/main/java/dsl/expression/EmailExpression.java)

#### Classes Auxiliares
[Type](https://github.com/ruaanc/attribute-validator-api/blob/add_expression/src/main/java/dsl/util/Type.java)

[PrimitiveType](https://github.com/ruaanc/attribute-validator-api/blob/add_expression/src/main/java/dsl/util/PrimitiveType.java)

#### Parser

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