package model;

public class Viagem {
    private int id;
    private Passageiro passageiro;
    private Destino destino;
    private int dia;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Passageiro getPassageiro() {
        return passageiro;
    }

    public void setPassageiro(Passageiro passageiro) {
        this.passageiro = passageiro;
    }

    public Destino getDestino() {
        return destino;
    }

    public void setDestino(Destino destino) {
        this.destino = destino;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }
}


