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
[Program](https://github.com/ruaanc/attribute-validator-api/blob/add_expression/src/main/java/com/plp/attributevalidatorapi/dsl/Program.java) ::= [Expression](https://github.com/ruaanc/attribute-validator-api/blob/add_expression/src/main/java/com/plp/attributevalidatorapi/dsl/expression/Expression.java)

Expression ::= [Value](https://github.com/ruaanc/attribute-validator-api/blob/add_expression/src/main/java/com/plp/attributevalidatorapi/dsl/expression/Value.java) | [UnaryExpression](https://github.com/ruaanc/attribute-validator-api/blob/add_expression/src/main/java/com/plp/attributevalidatorapi/dsl/expression/UnaryExpression.java)

Value ::= [ConcreteValue](https://github.com/ruaanc/attribute-validator-api/blob/add_expression/src/main/java/com/plp/attributevalidatorapi/dsl/expression/ConcreteValue.java)

ConcreteValue ::= [StringValue](https://github.com/ruaanc/attribute-validator-api/blob/add_expression/src/main/java/com/plp/attributevalidatorapi/dsl/expression/StringValue.java)

UnaryExpression ::= [ValidateZipCode](https://github.com/ruaanc/attribute-validator-api/blob/add_expression/src/main/java/com/plp/attributevalidatorapi/dsl/expression/ValidateZipCode.java) | [ValidateCnpj](https://github.com/ruaanc/attribute-validator-api/blob/add_expression/src/main/java/com/plp/attributevalidatorapi/dsl/expression/ValidateCnpj.java) | [ValidateCpf](https://github.com/ruaanc/attribute-validator-api/blob/add_expression/src/main/java/com/plp/attributevalidatorapi/dsl/expression/ValidateCpf.java) | [ValidateName](https://github.com/ruaanc/attribute-validator-api/blob/add_expression/src/main/java/com/plp/attributevalidatorapi/dsl/expression/ValidateName.java) | [ValidateEmail](https://github.com/ruaanc/attribute-validator-api/blob/add_expression/src/main/java/com/plp/attributevalidatorapi/dsl/expression/ValidateEmail.java)

#### Classes Auxiliares
[Type](https://github.com/ruaanc/attribute-validator-api/blob/add_expression/src/main/java/com/plp/attributevalidatorapi/dsl/util/Type.java)

[PrimitiveType](https://github.com/ruaanc/attribute-validator-api/blob/add_expression/src/main/java/com/plp/attributevalidatorapi/dsl/util/PrimitiveType.java)

[NonPrimitiveType](https://github.com/ruaanc/attribute-validator-api/blob/add_expression/src/main/java/com/plp/attributevalidatorapi/dsl/util/NonPrimitiveType.java)

#### Parser
[ValidationDSL.jj](https://github.com/ruaanc/attribute-validator-api/blob/add_expression/src/main/java/com/plp/attributevalidatorapi/dsl/parser/ValidationDSL.jj)

[JavaCharStream](https://github.com/ruaanc/attribute-validator-api/blob/add_expression/src/main/java/com/plp/attributevalidatorapi/dsl/parser/JavaCharStream.java)

[ParseException](https://github.com/ruaanc/attribute-validator-api/blob/add_expression/src/main/java/com/plp/attributevalidatorapi/dsl/parser/ParseException.java)

[Token](https://github.com/ruaanc/attribute-validator-api/blob/add_expression/src/main/java/com/plp/attributevalidatorapi/dsl/parser/Token.java)

[TokenMgrError](https://github.com/ruaanc/attribute-validator-api/blob/add_expression/src/main/java/com/plp/attributevalidatorapi/dsl/parser/TokenMgrError.java)

[ValidationDSL](https://github.com/ruaanc/attribute-validator-api/blob/add_expression/src/main/java/com/plp/attributevalidatorapi/dsl/parser/TokenMgrError.java)

[ValidationDSLConstants](https://github.com/ruaanc/attribute-validator-api/blob/add_expression/src/main/java/com/plp/attributevalidatorapi/dsl/parser/ValidationDSLConstants.java)

[ValidationDSLTokenManager](https://github.com/ruaanc/attribute-validator-api/blob/add_expression/src/main/java/com/plp/attributevalidatorapi/dsl/parser/ValidationDSLTokenManager.java)


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

Obs: Também é possível compilar através da IDE utilizada.

## Exemplo de funcionamento:
``` shell
cep "55940-000"
```