import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

//Implementação praticamente igual ao CarRentalList
public class CarRentalSet {
    private TreeSet<Carro> carros;

    public TreeSet<Carro> getCarros(){
        TreeSet<Carro> copia = new TreeSet<>();

        for (Carro c : this.carros){
            copia.add(c.clone());
        }

        return copia;
    }

    public void setCarros (TreeSet<Carro> car){
        this.carros = new TreeSet<>();
        for (Carro c : car){
            this.carros.add(c.clone());
        }
    }

    public CarRentalSet(){
        this.carros = new TreeSet<>();
    }

    public CarRentalSet (TreeSet<Carro> car){
        this.carros = new TreeSet<>();
        for (Carro c : car){
            this.carros.add(c.clone());
        }
    }

    public CarRentalSet (CarRentalSet o){
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

        CarRentalSet c = (CarRentalSet) o;

        return c.carros.equals(this.carros);
    }

    public CarRentalSet clone(){
        return new CarRentalSet (this);
    }

    public boolean existeCarroSet (String cod){
        for (Carro c : this.carros){
            if (c.getMatricula().equals(cod)) return true;
        }
        return false;
    }

    public int quantosSet(){
        return this.carros.size();
    }

    public int quantosSet(String marca){
        int count = 0;

        for (Carro c : this.carros){
            if (c.getMarca().equals(marca)){
                count++;
            }
        }

        return count;
    }

    public Carro getCarroSet(String cod){
        for (Carro c : this.carros){
            if (c.getMatricula().equals(cod)) return c.clone();
        }

        System.err.println("Carro não encontrado\n");
        return null;
    }

    public void adicionaSet (Carro v){
        this.carros.add(v.clone());
    }

    public List<Carro> getCarsSet(){
        List<Carro> cars = new ArrayList<>();

        for (Carro c : this.carros){
            cars.add(c.clone());
        }

        return cars;
    }

    public void adiciona_conjSet (Set<Carro> vs){
        for (Carro c : vs){
            adicionaSet(c);
        }
    }

    public void registarViagemSet (String codCarro, int numKms){
        for (Carro c : this.carros){
            if (c.getMatricula().equals(codCarro)){
                c.setKmTotais(c.getKmTotais() + numKms);
                return;  //Para acabar logo com o loop, desnecessário continuar
            }
        }
        System.out.println ("Esse carro não existe no sistema\n");
    }

    public Carro obterCarroMaisEconomicoSet(){
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

    public double obterMediaCustoPorKmSet(){
        if (this.carros.isEmpty()){
            System.out.println("A empresa não tem carros no sistema");
            return 0;
        }
        double total = 0;

        for (Carro c : this.carros){
            total = total + c.custoPorKm();
        }

        double media = total/this.quantosSet();

        return media;
    }

    public double custoRealKmSet (String cod){
        Carro c = getCarroSet(cod);
        if (c != null){
            return c.custoPorKm() * 1.15;
        }
        else{
            System.out.println("Esse carro não existe no sistema\n");
            return 0;
        }
    }

    public Set<Carro> carrosComAlcanceSet (int kms){
        Set<Carro> s = new HashSet<>();

        for (Carro c : this.carros){
            if (c.getAutonomia() >= kms){
                s.add(c.clone());
            }
        }

        return s;
    }

    public Set<CarroEletrico> comBateriaDeSet (int nivelMinimo){
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
