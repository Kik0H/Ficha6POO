public class CarroCombustao extends Carro{
    private double tamDep;
    private double consumoLitros100Km;      //QUANTOS LITROS SAO CONSUMIDOS PARA FAZER 100KM (!= CONSUMO)
    private double precoLitro;

    public double getTamDep(){
        return this.tamDep;
    }

    public double getConsumoLitros(){
        return this.consumoLitros100Km;
    }

    public double getPrecoLitro(){
        return this.precoLitro;
    }

    public void setTamDep(double t){
        this.tamDep = t;
    }

    public void setConsumoLitros(double c){
        this.consumoLitros100Km = c;
    }

    public void setPrecoLitro (double p){
        this.precoLitro = p;
    }

    public CarroCombustao(){
        super();
        this.tamDep = 0;
        this.consumoLitros100Km = 0;
        this.precoLitro = 0;
    }

    public CarroCombustao(String mat, String mar, String mod, int a, double v_m,double c, double auto, double kmt, double td, double cl, double pl){
        super(mat,mar,mod,a,v_m,c,auto,kmt);
        this.tamDep = td;
        this.consumoLitros100Km = cl;
        this.precoLitro = pl;
    }

    public CarroCombustao (CarroCombustao other){
        super(other);
        this.tamDep = other.getTamDep();
        this.consumoLitros100Km = other.getConsumoLitros();
        this.precoLitro = other.getPrecoLitro();
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Tamanho Depósito: ").append(this.tamDep).append("\n");
        sb.append("Consumo Litros/100KM: ").append(this.consumoLitros100Km).append("\n");
        sb.append("Preço Litro: ").append(this.precoLitro).append("\n");

        return sb.toString();
    }

    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;

        CarroCombustao c = (CarroCombustao) o;

        return  super.equals(o)&&
                c.getTamDep() == this.tamDep &&
                c.getConsumoLitros() == this.consumoLitros100Km &&
                c.getPrecoLitro() == this.precoLitro;
    }

    public CarroCombustao clone(){          //Questionar sobre este clone acerca do polimorfismo
        return new CarroCombustao(this);
    }

    public double custoPorKm(){
        double custo = (this.getConsumoLitros()/100) * this.getPrecoLitro();
        return custo;
    }
}
    

