# Projetos

  - programaservice --> contem os programas de tv
  - programareserva --> contem o controle de reserva verificando a existencia do programa de tv no servico programaservice
  - api-gateway --> gateway para unificar os micros servicos na porta 8080
  - servermicroservico --> Spring Eureka http://localhost:8761/


## questao 8
  Resposta, branch da master. Bug deve ser corrigido mais rapido possivel e nao se misturar a desenvolvimentos não liberados para produção.
  
## questao 9
   Select id_programa, Count(*) from RESERVA_PROGRAMA group by id_programa order by 1 desc; 
