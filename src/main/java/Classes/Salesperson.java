/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;


import Classes.User;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author johnp
 */
public class Salesperson extends User {

    public Salesperson(String id, String name, String password, String role, String contactNo, String email, String status) {
        super(id, name, password, role, contactNo, email, status);
    }
    public Salesperson(){}
    
    @Override
    public void setName(String name) {
        super.setName(name);
    }
    
    @Override
    public ArrayList<Salesperson> Import(){
        BufferedReader br = null;
        ArrayList<Salesperson> salesperson = new ArrayList<>();
            try {

                ArrayList<String> lines = new ArrayList<>();
                String file = "user.txt";
                br = new BufferedReader(new FileReader(file));
                String line;
                while((line=br.readLine())!=null){
                    lines.add(line);

                }
                for(String str:lines){
                    String[] data = str.split(", ");
                    salesperson.add(new Salesperson(data[0],data[1],data[2],data[3],data[4],data[5],data[6]));

                    br.close();

                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Salesperson.class.getName()).log(Level.SEVERE, null, ex);
            }  catch (IOException ex) {
                    Logger.getLogger(Salesperson.class.getName()).log(Level.SEVERE, null, ex);
                }
            return salesperson;
            } 

}
