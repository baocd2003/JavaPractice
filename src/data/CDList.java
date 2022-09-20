/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;
import controllers.MyTool;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.Collections;
/**
 *
 * @author Admin
 */
public class CDList extends ArrayList<CD> implements Prop{
    public CDList(){
        loadFromFile();
    }
    int cdCounter = 0;
@Override
    public void addCD(){
        if(cdCounter < 700){
         String name = MyTool.getCollectionName("Enter name of collection(game/music/movie): ","Empty!! Please Enter!\n","Enter game/music/video\n");
         String type = MyTool.getTypeName("Enter type of CD(audio/video): ","Empty!! Please Enter!\n","Enter audio/video");
         String title = MyTool.getString("Enter title of CD: ","Empty!! Please Enter!\n");
         String ID = MyTool.getString("Enter ID: ","Empty!!Please Enter!\n");
         String year = MyTool.getString("Enter year: ","Empty!!Please Enter!\n");
         String price = MyTool.getString("Enter price: ","Empty!!Please Enter!\n");
         if(checkID(ID) == -1){
          this.add(new CD(name, type, title ,ID ,price ,year)); 
          System.out.print("Added sucessfully\n");
          cdCounter++;
         }else{
            System.out.println("This book exists");
        }       
        }else{
            System.out.println("Unable to add CD");
        }       
    }
    
    public void display(){
        System.out.println("There are " + cdCounter + "CD in the catalog" );
        for (int i = 0; i < this.size(); i++) {
            this.get(i).showInfo();
        }
    }
    
    public void searchByTitle(){
        System.out.println("There are " + cdCounter + "CD in the catalog" );
        String proTitle = MyTool.getString("Enter title of CD want to find: ", "Empty!!Please Enter\n");
        int count = 0;
        for(int i = 0;i < this.size();i++){
            if(this.get(i).getTitle().contains(proTitle)){
                count++;
                this.get(i).showInfo();
            }
        }
        System.out.println("There are "+count+"match the title");
        
    }
    
    public void updateInfo(){
        String id = MyTool.getString("Enter id of CD want to update: ", "Empty!!Please Enter\n").trim();
        int posi = checkID(id);
        if(posi >=0){
            String newName = MyTool.getUpdateString("Enter new name of CD: ", this.get(posi).getName());
            this.get(posi).setName(newName);
            String newType = MyTool.getUpdateString("Enter new type of CD: ", this.get(posi).getType());
            this.get(posi).setType(newType);
            String newTitle = MyTool.getUpdateString("Enter new title of CD: ",this.get(posi).getTitle());
            this.get(posi).setTitle(newTitle);
            String newID = MyTool.getUpdateString("Enter new ID: ",this.get(posi).getID());
            this.get(posi).setID(newID);
            String newYear = MyTool.getUpdateString("Enter new year: ",this.get(posi).getYear());
            this.get(posi).setYear(newYear);
            String newPrice = MyTool.getUpdateString("Enter new price: ",this.get(posi).getPrice());
            this.get(posi).setPrice(newPrice);
            System.out.println("Update sucessful\n");
        }else{
            System.out.println("Cannot find the ID\n");
            System.out.println("Update failed\n");
        }
    }
    
    public void deleteCD(){
        String id = MyTool.getString("Enter id of CD want to update: ", "Empty!!Please Enter!\n").trim();
        int posi = checkID(id);
        if(posi >=0){
            this.remove(posi);
            System.out.println("Delete sucessful!\n");

        }else{
            System.out.println("Cannot find the ID!\n");
            System.out.println("Delete failed!\n");
        }
    }
    
    public int checkID(String id) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getID().equalsIgnoreCase(id)) {
                return i;
            }
        }
        return -1;
    }
    
    public void loadFromFile(){
        try{
            FileReader fr = new FileReader("CD.txt");
            BufferedReader br = new BufferedReader(fr);
            String lines;
            while((lines =  br.readLine()) != null){
                StringTokenizer stk = new StringTokenizer(lines,",");
                String name = stk.nextToken();
                String type = stk.nextToken();
                String title = stk.nextToken();
                String ID = stk.nextToken();
                String price = stk.nextToken();
                String year = stk.nextToken();
                this.add(new CD(name,type,title,ID,price,year));
            }
            br.close();
            fr.close();
            
        }catch(Exception e){
            System.out.println(e);
        }    
    }
    
    public void writeCDToFile(){
        try{
            File f = new File("CD.txt");
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
            for(int i = 0 ; i < this.size();i++){
                pw.println(this.get(i).toString());
            }
            fw.close();
            pw.close();
        }catch(Exception e){
            System.out.println(e);
        }
       System.out.println("Save sucessfully!\n");
    }
    
    public void displayByFirstName(){
        ArrayList<String> titleList = new ArrayList<String>();
        for(int i = 0 ; i < this.size();i++){
            titleList.add(this.get(i).getTitle());
        }
        Collections.sort(titleList);
        for (int i = 0; i < titleList.size(); i++) {
            for(int j = 0 ;j <this.size();j++){
                if(titleList.get(i).equals(this.get(j).getTitle())){
                    this.get(j).setTitle(titleList.get(i));
                    this.get(j).showInfo();
                }
            }
              
        }
    }
}




