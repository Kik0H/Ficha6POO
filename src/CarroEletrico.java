public class CarroEletrico extends Carro{
    private double tamBat;
    private double consumoKwh100km;
    private double precoKW;

    public double getTamBat(){
        return this.tamBat;
    }

    public double getConsumoKW(){
        return this.consumoKwh100km;
    }

    public double getPrecoKW(){
        return this.precoKW;
    }

    public void setTamBat(double t){
        this.tamBat = t;
    }

    public void setConsumoKW (double kw){
        this.consumoKwh100km = kw;
    }

    public void setPrecoKW (double p){
        this.precoKW = p;
    }

    public CarroEletrico(){
        super();
        this.tamBat = 0;
        this.consumoKwh100km = 0;
        this.precoKW = 0;
    }

    public CarroEletrico(String mat, String mar, String mod, int a, double v_m, double c, double auto, double kmt, double tb, double ckw, double pkw){
        super(mat,mar,mod,a,v_m,c,auto,kmt);
        this.tamBat = tb;
        this.consumoKwh100km = ckw;
        this.precoKW = pkw;
    }

    public CarroEletrico (CarroEletrico other){
        super(other);
        this.tamBat = other.getTamBat();
        this.consumoKwh100km = other.getConsumoKW();
        this.precoKW = other.getPrecoKW();
    }

    public String toString(){
        return "Matricula: " + this.matricula + "\n" + "Marca: " + this.marca + "\n" + "Modelo: " + this.modelo + "\n" + "Ano: " + this.ano + "\n" + "Velocidade Média: " + this.velocidade_media + "\n" + "Consumo/KM a 100KM/H: " + this.consumo + "\n" + "Autonomia: " + this.autonomia + "\n" + "Km Totais: " + this.kmtotais + "\n" + "Tamanho Bateria: " + this.tamBat + "\n" + "Consumo KW/100KM: " + this.consumoKwh100km + "\n" + "Preço KW: " + this.precoKW + "\n";
    }

    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;

        CarroEletrico c = (CarroEletrico) o;

        return  c.getMatricula().equals(this.matricula) &&
                c.getMarca().equals(this.marca) &&
                c.getModelo().equals(this.modelo) &&
                c.getAno() == this.ano &&
                c.getVelocidadeMedia() == this.velocidade_media &&
                c.getConsumo() == this.consumo &&
                c.getAutonomia() == this.autonomia &&
                c.getKmTotais() == this.kmtotais &&
                c.getTamBat() == this.tamBat &&
                c.getConsumoKW() == this.consumoKwh100km &&
                c.getPrecoKW() == this.precoKW;
    }

    public CarroEletrico clone(){
        return new CarroEletrico(this);
    }

    public double custoPorKm(){
        double custo = (this.consumoKwh100km/100) * this.precoKW;
        return custo;
    }
}