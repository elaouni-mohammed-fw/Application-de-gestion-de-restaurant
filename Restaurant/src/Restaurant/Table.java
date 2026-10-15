package Restaurant;

public class Table {

    private int idTable;
    private String etatTable;

    public Table(int idTable, String etatTable) {
        this.idTable = idTable;
        this.etatTable = etatTable;
    }

    public int getIdTable() {
        return idTable;
    }
    public void setIdTable(int idTable) {
        this.idTable = idTable;
    }

    public String getEtatTable() {
        return etatTable;
    }
    public void setEtatTable(String etatTable) {
        this.etatTable = etatTable;
    }

    @Override
    public String toString() {
        return "Table{ id: "+idTable+" , etat: "+etatTable+" }";
    }

}
