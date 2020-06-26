# language: pt
# charset: UTF-8

Funcionalidade: Conta

  Cenario: CT001 - Conta - Criar conta com sucesso

    Dado eu esteja logado e tenha acessado a página de contas
    Quando eu criar uma nova conta com dados válidos
    Entao eu devo ver uma mensagem indicando que a conta foi cadastrada com sucesso


  Cenario: CT002 - Conta - Excluir conta com sucesso

    Dado eu esteja logado e tenha acessado a página de contas
    Quando eu selecionar e excluir uma conta
    Entao eu devo ver uma mensagem indicando que a conta foi excluida com sucesso













