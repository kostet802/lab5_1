package sample;

import javafx.collections.ObservableList;

import java.io.*;

public class FileOper {
    private static final String Filename = "D:\\JavaProjects\\phone.txt";
    public void deserialise(Abonents abont){
        try {
            FileInputStream fin = new FileInputStream(Filename);
            ObjectInputStream ois = new ObjectInputStream(fin);
            abont.ab = (ObservableList<Abonent>) ois.readObject();
            ois.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void serialise(Abonents abont){
        try{
            FileOutputStream fout = new FileOutputStream(Filename);
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(abont.ab);
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
