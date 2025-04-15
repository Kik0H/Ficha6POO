**Ficha6POO**<br />
Neste projeto pretende-se desenvolver um sistema para a gestão de uma empresa que possui carros para alugar, onde até ao momento existem dois tipos de carros, elétricos e a combustão.<br />
A informação que se guarda para cada carro é a seguinte:<br />
• um código de identificação (que poderá ser a matrícula). <br />
• marca do carro. <br />
• modelo. <br />
• ano de construção. <br />
• velocidade média por km. <br />
• consumo por km a uma velocidade de 100 km/h. (serve de referência para cálculos lineares do consumo) <br />
• uma autonomia, que corresponde ao número de kms que o carro pode andar com o combustível que actualmente possui. <br />
• kms totais realizados. <br />

Os carros a combustão acrescentam informação sobre o tamanho em litros do seu depósito, o consumo em litros aos 100km e o preço por litro do combustível. <br />
Os carros eléctricos acrescentam informação sobre a dimensão da sua bateria (em kWh), o consumo em KWh aos 100km e o preço do KW. <br />
Não confundir o consumo a uma velocidade de 100km/h (Classe carro) com o consumo em litros/Kwh a cada 100KM (Carros Eletricos e a combustão). <br />

**Função de cada método:**
1) existeCarro(String cod) -> Verifica a existência de um carro no registo do stand.
2) quantos() -> Devolve a quantidade de carros existentes no registo.
3) quantos(String marca) -> Devolve a quantidade de carros de uma dada marca.
4) getCarro(String cod) -> Devolve a informação de um dado carro.
5) adiciona(Carro v) -> Adiciona um carro ao registo.
6) getCars() -> Devolve uma lista que contém a cópia de todos os carros no sistema.
7) adiciona(Set<Carro> vs) -> Adiciona um conjunto de carros ao sistema.
8) registarViagem(String codCarro, int numKms) -> Regista uma viagem efetuada por um carro com o número de KMs que foram feitos.
9) obterCarroMaisEconomico() -> Devolve o carro com o menor custo por km.
10) obterMediaCustoPorKm() -> Devolve a média de custo por KM de todos os carros.
11) custoRealKm(String cod) -> Calcula o custo real por km de um carro.
12) carrosComAlcance(int kms) -> Devolve o conjunto de carros que conseguem efetuar uma viagem de x kms.
13) comBateriaDe(int nivelMinimo) -> Devolve o conjunto de carros elétricos cujo nível de bateria é pelo menos uma percentagem.

**Por implementar:**<br />
• Classe CarRentalList, com os mesmos requisitos da CarRental, mas que utiliza uma estrutura de dados List<Carro> <br />
• CLasse CarRentalSet, com os mesmo requisitos da CarRental, mas que utiliza uma estrutura de dados TreeSet<Carro> <br />

