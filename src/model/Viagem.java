package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Viagem {
    private int id;
    private Passageiro passageiro;
    private Destino destino;
    private LocalDate ida;
    private LocalDate volta;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

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

    public String getIda() {
        return formatter.format(ida);
    }

    public void setIda(String ida) {
        this.ida = LocalDate.parse(ida, formatter);
    }

    public String getVolta() {
        return formatter.format(volta);
    }

    public void setVolta(String volta) {
        this.volta = LocalDate.parse(volta, formatter);
    }
}


