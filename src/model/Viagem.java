package model;

import java.time.LocalDateTime;

public class Viagem {
    private int id;
    private Passageiro passageiro;
    private Destino destino;
    private LocalDateTime ida;
    private LocalDateTime volta;

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

    public LocalDateTime getIda() {
        return ida;
    }

    public void setIda(LocalDateTime ida) {
        this.ida = ida;
    }

    public LocalDateTime getVolta() {
        return volta;
    }

    public void setVolta(LocalDateTime volta) {
        this.volta = volta;
    }
}


