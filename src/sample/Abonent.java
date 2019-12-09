package sample;

import javafx.collections.ObservableList;

import java.io.Serializable;

public class Abonent implements Serializable {
    private String Fio;
    private int number;
    private String Adress;
    Abonents abont = new Abonents();

    public Abonent(String AbonFio, int number, String Adress) {
        this.Fio = AbonFio;
        this.number = number;
        this.Adress = Adress;
    }

    public Abonent() { }

    public String getFio() {
        return Fio;
    }

    public boolean setFio(String Fio) {
        if(Fio.matches("[a-zA-Z]+") && !Fio.isEmpty()) {
            this.Fio = Fio;
            return true;
        } else {
            System.out.println("Try again");
            return false;
        }
    }

    public int getNumber() {
        return number;
    }

    public boolean setNumber(int number) {
        if(number > 0) {
            this.number = number;
            return true;
        }
        else{
            System.out.println("Try again");
            return false;
        }
    }


    public String getAdress() {
        return Adress;
    }

    public boolean setAdress(String Adress) {
        if(!Adress.isEmpty()) {
            this.Adress = Adress;
            return true;
        } else {
            System.out.println("Try again");
            return false;
        }
    }

    @Override
    public String toString() {
        return
                "FIo = " + getFio() + '\n' +
                "Number = " + getNumber() + '\n'+
                "Adress= " + getAdress() + '\n';
    }
}
