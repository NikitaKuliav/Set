package Transport;

public class Mechanic {
    private String nameSurname;
    private String firm;

    public Mechanic(String nameSurname, String firm) {
        this.nameSurname = nameSurname;
        this.firm = firm;
    }

    public void doMaintenance(){
        System.out.println("Механик " + this.nameSurname + " проводит техобслуживание");
    }
    public void carRepair(){
        System.out.println("Механик " + this.nameSurname + " чинит машину");
    }

    public String getNameSurname() {
        return nameSurname;
    }

    public void setNameSurname(String nameSurname) {
        this.nameSurname = nameSurname;
    }

    public String getFirm() {
        return firm;
    }

    public void setFirm(String firm) {
        this.firm = firm;
    }

    @Override
    public String toString() {
        return "Механик - " +
                nameSurname + ", Фирма= " + firm;
    }
}
