/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;


import controllers.MyTool;
import data.CDList;
import mng.Menu;

/**
 *
 * @author Admin
 */
public class Main {
    public static void main(String args[]){
        int choice;
        CDList li = new CDList();
        Menu menu = new Menu();
        boolean confirm = true;
        do{
            menu.getMenu();
            choice = menu.getChoice();
        switch(choice){
            case 1:
                li.addCD();
                break;
            case 2:
                li.searchByTitle();
                break;
            case 3:
                li.display();
                break;
            case 4:
                int option;
                option = menu.getChoice();
                switch(option){
                    case 1:
                        li.updateInfo();     
                        confirm = MyTool.getYesNo("Go back to menu(Y/N): ");
                        break;
                    case 2:
                        li.deleteCD();          
                        confirm = MyTool.getYesNo("Go back to menu(Y/N): ");
                        break;
                }               
                break;
            case 5:
                    li.writeCDToFile();
                    confirm = MyTool.getYesNo("Go back to menu(Y/N): ");
                break;
            case 6:
                    li.displayByFirstName();
                    confirm = MyTool.getYesNo("Go back to menu(Y/N): ");
                break;
            default:
                break;
               
        }
         
        }while(confirm && choice <=6);
         
    }
}
