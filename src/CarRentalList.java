import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class CarRentalList {
    private List<Carro> carros;

    public List<Carro> getCarros(){
        List<Carro> copia = new ArrayList<>();

        for (Carro c : this.carros){
            copia.add(c.clone());
        }

        return copia;
    }

    public void setCarros (List<Carro> car){
        this.carros = new ArrayList<>();
        for (Carro c : car){
            this.carros.add(c.clone());
        }
    }

    public CarRentalList(){
        this.carros = new ArrayList<>();
    }

    public CarRentalList (List<Carro> car){
        this.carros = new ArrayList<>();
        for (Carro c : car){
            this.carros.add(c.clone());
        }
    }

    public CarRentalList (CarRentalList o){
        this.carros = o.getCarros();
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append ("Carros no Stand:\n");

        for (Carro c : this.carros){
            sb.append(c.toString()).append("\n");
        }

        return sb.toString();
    }

    public boolean equals (Object o){
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;

        CarRentalList c = (CarRentalList) o;

        return c.carros.equals(this.carros);
    }

    public CarRentalList clone(){
        return new CarRentalList(this);
    }

    public boolean existeCarroList (String cod){
        for (Carro c : this.carros){
            if (c.getMatricula().equals(cod)) return true;
        }
        return false;
    }

    public int quantosList(){
        return this.carros.size();
    }

    public int quantosList(String marca){
        int count = 0;

        for (Carro c : this.carros){
            if (c.getMarca().equals(marca)){
                count++;
            }
        }

        return count;
    }

    public Carro getCarroList(String cod){
        for (Carro c : this.carros){
            if (c.getMatricula().equals(cod)) return c.clone();
        }

        System.err.println("Carro não encontrado\n");
        return null;
    }

    public void adicionaList (Carro v){
        this.carros.add(v.clone());
    }

    public List<Carro> getCarsList(){
        List<Carro> cars = new ArrayList<>();

        for (Carro c : this.carros){
            cars.add(c.clone());
        }

        return cars;
    }

    public void adiciona_conjList (Set<Carro> vs){
        for (Carro c : vs){
            adicionaList(c);
        }
    }

    public void registarViagemList (String codCarro, int numKms){
        for (Carro c : this.carros){
            if (c.getMatricula().equals(codCarro)){
                c.setKmTotais(c.getKmTotais() + numKms);
                return;  //Para acabar logo com o loop, desnecessário continuar
            }
        }
        System.out.println ("Esse carro não existe no sistema\n");
    }

    public Carro obterCarroMaisEconomicoList(){
        if (this.carros.isEmpty()){
            System.out.println("A empresa não tem carros no sistema");
            return null;
        }

        Carro maisEco = null;
        double menorCusto = Double.MAX_VALUE;

        for (Carro c : this.carros){
            double custo = c.custoPorKm();
            if (custo < menorCusto){
                menorCusto = custo;
                maisEco = c;
            }
        }
        return maisEco.clone();
    }

    public double obterMediaCustoPorKmList(){
        if (this.carros.isEmpty()){
            System.out.println("A empresa não tem carros no sistema");
            return 0;
        }
        double total = 0;

        for (Carro c : this.carros){
            total = total + c.custoPorKm();
        }

        double media = total/this.quantosList();

        return media;
    }

    public double custoRealKmList (String cod){
        Carro c = getCarroList(cod);
        if (c != null){
            return c.custoPorKm() * 1.15;
        }
        else{
            System.out.println("Esse carro não existe no sistema\n");
            return 0;
        }
    }

    public Set<Carro> carrosComAlcanceList (int kms){
        Set<Carro> s = new HashSet<>();

        for (Carro c : this.carros){
            if (c.getAutonomia() >= kms){
                s.add(c.clone());
            }
        }

        return s;
    }

    public Set<CarroEletrico> comBateriaDeList (int nivelMinimo){
        Set<CarroEletrico> s = new HashSet<>();

        for (Carro c : this.carros){
            if (c instanceof CarroEletrico){
                double bat = ((CarroEletrico) c).getTamBat();
                double consumoP100km = ((CarroEletrico) c).getConsumoKW();
                double alcanceKM = (bat/consumoP100km)*100;
                double aut = c.getAutonomia();
                double perBatAtual = (aut/alcanceKM) * 100;

                if (perBatAtual >= nivelMinimo){
                    s.add((CarroEletrico) c.clone());
                }
            }
        }

        return s;
    }
}
