package Restaurant;

import java.time.LocalDateTime;

public class Reservation {
    private int idReservation;
    private int idTable;
    private String nomClient;
    private LocalDateTime dateReservation;

    public Reservation(int idReservation, int idTable, String nomClient, LocalDateTime dateReservation) {
        this.idReservation = idReservation;
        this.idTable = idTable;
        this.nomClient = nomClient;
        this.dateReservation = dateReservation;
    }

    public int getIdReservation() {
        return idReservation;
    }
    public void setIdReservation(int idReservation) {
        this.idReservation = idReservation;
    }

    public int getIdTable() {
        return idTable;
    }
    public void setIdTable(int idTable) {
        this.idTable = idTable;
    }

    public String getNomClient() {
        return nomClient;
    }
    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public LocalDateTime getDateReservation() {
        return dateReservation;
    }
    public void setDateReservation(LocalDateTime dateReservation) {
        this.dateReservation = dateReservation;
    }

    @Override
    public String toString() {
        return "Reservation [ID: " + idReservation + ", Table: " + idTable + ", Client: " + nomClient + ", Date: " + dateReservation + "]";
    }
}

