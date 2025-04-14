public abstract class Carro {
    protected String matricula;
    protected String marca;
    protected String modelo;
    protected int ano;
    protected double velocidade_media;
    protected double consumo; //CONSUMO POR KM A UMA VELOCIDADE DE 100 KM/H
    protected double autonomia;
    protected double kmtotais;

    public String getMatricula(){
        return this.matricula;
    }

    public String getMarca(){
        return this.marca;
    }

    public String getModelo(){
        return this.modelo;
    }

    public int getAno(){
        return this.ano;
    }    

    public double getVelocidadeMedia(){
        return this.velocidade_media;
    }

    public double getConsumo(){
        return this.consumo;
    }

    public double getAutonomia(){
        return this.autonomia;
    }

    public double getKmTotais(){
        return this.kmtotais;
    }

    public void setMatricula(String m){
        this.matricula = m;
    }

    public void setMarca(String m){
        this.marca = m;
    }

    public void setModelo(String m){
        this.modelo = m;
    }

    public void setAno(int a){
        this.ano = a;
    }

    public void setVelocidadeMedia (double v){
        this.velocidade_media = v;
    }

    public void setConsimo (double c){
        this.consumo = c;
    }

    public void setAutonomia(double a){
        this.autonomia = a;
    }

    public void setKmTotais (double k){
        this.kmtotais = k;
    }

    public Carro(){
        this.matricula = "n/a";
        this.marca = "n/a";
        this.modelo = "n/a";
        this.ano = 0;
        this.velocidade_media = 0;
        this.consumo = 0;
        this.autonomia = 0;
        this.kmtotais = 0;
    }

    public Carro(String mat, String mar, String mod, int a, double v_m,double c, double auto, double kmt){
        this.matricula = mat;
        this.marca = mar;
        this.modelo = mod;
        this.ano = a;
        this.velocidade_media = v_m;
        this.consumo = c;
        this.autonomia = auto;
        this.kmtotais = kmt;
    }

    public Carro (Carro other){
        this.matricula = other.getMatricula();
        this.marca = other.getMarca();
        this.modelo = other.getModelo();
        this.ano = other.getAno();
        this.velocidade_media = other.getVelocidadeMedia();
        this.consumo = other.getConsumo();
        this.autonomia = other.getAutonomia();
        this.kmtotais = other.getKmTotais();
    }

    //PERGUNTAR NA AULA SOBRE O ABSTRACT??

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Matricula: ").append(this.matricula).append("\n");
        sb.append("Marca: ").append(this.marca).append("\n");
        sb.append("Modelo: ").append(this.modelo).append("\n");
        sb.append("Ano: ").append(this.ano).append("\n");
        sb.append("Velocidade Média: ").append(this.velocidade_media).append("\n");
        sb.append("Consumo/KM a 100KM/H: ").append(this.consumo).append("\n");
        sb.append("Autonomia: ").append(this.autonomia).append("\n");
        sb.append("Km Totais: ").append(this.kmtotais).append("\n");
        return sb.toString();
    }

    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;

        Carro c = (Carro) o;

        return c.getMatricula().equals(this.matricula) &&
               c.getMarca().equals(this.marca) &&
               c.getModelo().equals(this.modelo) &&
               c.getAno() == this.ano &&
               c.getVelocidadeMedia() == this.velocidade_media &&
               c.getConsumo() == this.consumo &&
               c.getAutonomia() == this.autonomia &&
               c.getKmTotais() == this.kmtotais;
    }

    public abstract double custoPorKm();

    public abstract Carro clone();
    
}
