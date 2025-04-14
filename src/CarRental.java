import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class CarRental {
    private Map<String, Carro> carros;

    public Map<String, Carro> getCarros(){
        Map<String, Carro> copia = new HashMap<>();

        for (Map.Entry<String, Carro> entry: this.carros.entrySet()){
            String matricula = entry.getKey();
            Carro o = entry.getValue();
            Carro novo = o.clone();

            copia.put(matricula,novo);
        }
        return copia;
    }

    public void setCarros(Map<String, Carro> c){
        this.carros = new HashMap<>();

        for (Map.Entry<String, Carro> entry: c.entrySet()){
            String matricula = entry.getKey();
            Carro o = entry.getValue();
            Carro novo = o.clone();

            this.carros.put(matricula,novo);
        }
    }

    public CarRental(){
        this.carros = new HashMap<>();
    }

    public CarRental (Map<String, Carro> carros){
        this.carros = new HashMap<>();
        for (Map.Entry<String, Carro> entry : carros.entrySet()){           //Percorre os conjuntos <matricula,carros> (<Key,Value>)
            String matricula = entry.getKey();
            Carro o = entry.getValue();
            Carro novo = o.clone();

            this.carros.put(matricula,novo);
        }
    }

    public CarRental (CarRental o){
        this.carros = o.getCarros();
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Carros no Stand:\n");

        for (Carro c : this.carros.values()){
            sb.append(c.toString()).append("\n");
        }

        return sb.toString();
    }

    public boolean equals (Object o){
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;

        CarRental c = (CarRental) o;

        return c.carros.equals(this.carros);
    }

    public CarRental clone(){
        return new CarRental(this);
    }

    public boolean existeCarro (String cod){
        return this.carros.containsKey(cod);
    }

    public int quantos(){
        return this.carros.size();
    }

    public int quantos(String marca){
        int count = 0;

        for (Map.Entry<String,Carro> entry: this.carros.entrySet()){
            Carro carro = entry.getValue();
            if (carro.getMarca().equals(marca)){
                count++;
            }
        }

        return count;
    }

    public Carro getCarro (String cod){
        if (existeCarro(cod)){
            Carro c = this.carros.get(cod).clone();
            return c;
        } else{
            System.out.println ("Carro não encontrado\n");
            return null;
        }
    }

    public void adiciona (Carro v){
        String matricula = v.getMatricula();
        this.carros.put(matricula,v.clone());
    }

    public List<Carro> getCars(){
        List<Carro> cars = new ArrayList<>();
        
        for (Carro c : this.carros.values()){
            cars.add(c.clone());
        }

        return cars;
    }

    public void adiciona_conj (Set<Carro> vs){
        for (Carro c: vs){
            adiciona(c);
        }
    }

    public void registarViagem (String codCarro, int numKms){
        if (existeCarro(codCarro)){
            Carro c = this.carros.get(codCarro);
            c.setKmTotais(c.getKmTotais() + numKms);
        }
        else {
            System.out.println ("Esse carro não existe no sistema\n");
        }
    }

    public Carro obterCarroMaisEconomico(){
        if (this.carros.isEmpty()){
            System.out.println("A empresa não tem carros no sistema");
            return null;
        }

        Carro maisEconomico = null;
        double menorCusto = Double.MAX_VALUE;

        for (Carro c : this.carros.values()){
            double custo = c.custoPorKm();
            if (custo < menorCusto){
                menorCusto = custo;
                maisEconomico = c;
            }
        }

        return maisEconomico.clone();
    }

    public double obterMediaCustoPorKm(){
        if (this.carros.isEmpty()){
            System.out.println("A empresa não tem carros no sistema");
            return 0;
        }
        double total = 0;

        for (Carro c : this.carros.values()){
            total = total + c.custoPorKm();
        }

        double media = total/this.quantos();

        return media;
    }

    public double custoRealKm (String cod){                    //A função é suposto dar um int, mas o custoPorKm é um double??? 
        if (existeCarro(cod)){                                 //Por agora altero o tipo para double, perguntar o que fazer depois
            Carro c = this.carros.get(cod);
            double custoReal = c.custoPorKm() * 1.15;
            return custoReal;
        }
        else {
            System.out.println ("Esse carro não existe no sistema\n");
            return 0;
        }
    }

    public Set<Carro> carrosComAlcance (int kms){
        Set<Carro> s = new HashSet<>();

        for (Carro c : this.carros.values()){
            if (c.getAutonomia() >= kms){
                s.add(c.clone());
            }
        }
        
        return s;
    }

    public Set<CarroEletrico> comBateriaDe (int nivelMinimo){
        Set<CarroEletrico> s = new HashSet<>();

        for (Carro c : this.carros.values()){
            if (c instanceof CarroEletrico){
                double bat = ((CarroEletrico) c).getTamBat();                   //TAMANHO TOTAL DA BATERIA
                double consumoP100km = ((CarroEletrico) c).getConsumoKW();      //QUANTOS KW USA A CADA 100KM
                double alcanceKM = (bat/consumoP100km)*100;                     //KM TOTAIS QUE ESTE CARRO CONSEGUE ANDAR COM BATERIA CHEIA (100%)
                double aut = c.getAutonomia();                                  //QUANTOS KM AINDA PODE ANDAR 
                double perBatAtual = (aut/alcanceKM) * 100;

                if (perBatAtual >= nivelMinimo){
                    s.add((CarroEletrico) c.clone());
                }
            }
        }
        return s;
    }

}
