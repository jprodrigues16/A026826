# A026826

Trabalho Final Computação Movel

# Objetivo da Aplicação 

Esta Aplicação serve como motor de pesquisa aos jogadores do Diablo 3, ela vai buscar informação sobre os jogadores e guardar na base de dados da aplicação
também tem acesso à página oficial do site da Blizzard

# --Página "Home"-- (Página Principal)

Na primeira página temos um fundo, um logo no topo e 4 botões
Botões:
  1. Botão com acesso ao site Oficial do Diablo 3
  2. Botão da Homepage (Livro)
  3. Botão das Listas (tesouro)
  4. Botão de Account Details

# --Página "Account Details"--
 Aqui temos que inserir uma BattleTag - recolhi 3 para servirem como exemplo
  1. CiscoIvo#2988
  2. pberna#2814
  3. Psasp91#2972
  
  São sensiveis a maiusculas e min
  
  Ao inserir os battleTags temos duas respostas:
    falha na procura da conta -> resultado altera o texto afirmando que não existe conta
    
    
    validação do battletag -> dá a informação dos seguintes pontos:
    
                                          1. battleTag
                                          2. LastUpdate
                                          3. ParagonLevel
                                          4. Paragon Level Hardcore
                                          5. Paragon Level Season
                                          6. Last Hero ID Played
                                          7. Guild
Esta informação toda é disponibilizada pela API da Blizzard -> exemplo de uma conta do Diablo 3 "https://eu.api.battle.net/d3/profile/CiscoIvo%232899/?locale=en_GB&apikey=3fyhs7rjas7gbykdvrydkzcug7ms549x"
Após inserir todos os dados podemos guardar na Base de Dados da APK.

# --Página "Lista"--

Aqui podemos ver a base de dados, editar apartir do ID, adicionar e apagar registos

1. para o registo não é necessário inserir o ID
2. Para eliminar e fazer update é muito importante preencher o ID

