package data;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class CD implements Comparable<CD> {
    private String name;
    private String type;
    private String title;
    private String ID;
    private String price;
    private String year;
//    private int quanity = 0;

    public CD(String name, String type, String title, String ID, String price, String year) {
        this.name = name;
        this.type = type;
        this.title = title;
        this.ID = ID;
        this.price = price;
        this.year = year;
   }
    

//    public int getQuanity() {
//        return quanity;
//    }
//
//    public void setQuanity(int quanity) {
//        this.quanity = quanity;
//    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
    
    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
    
    public void showInfo(){
        System.out.println("Name: "+name + ","+"Type: "+ type+"," + "Title: "+title+ ","+"ID: " + ID +"," +"Price: "+price+","+"Publishing year:"+ year);
    }

    @Override
    public String toString() {
        return  name + "," + type + "," + title + "," + ID + "," + price + "," + year ;
    }

    @Override
    public int compareTo(CD c) {
       return this.getTitle().compareTo(c.getTitle());
    }

    
}
