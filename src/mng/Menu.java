/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mng;

import controllers.MyTool;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Menu {
    public static Scanner sc = new Scanner(System.in);
    public void getMenu(){
        System.out.println("----------- CD House Program ------------");
        System.out.println("1.Add CD to catalog");
        System.out.println("2.Search CD by CD title");
        System.out.println("3.Display the catalog");
        System.out.println("4.Update CD");
        System.out.println("    1.Update CD");
        System.out.println("    2.Delete CD");
        System.out.println("5.Save account to file");
        System.out.println("6.Print lists CD from file");
        System.out.println("Others-Quit");
    }
    
    public int getChoice(){
        int choice = 0;
        try{
            System.out.println("Choice: ");
            choice = Integer.parseInt(sc.nextLine());
            
        }catch(NumberFormatException e){
            System.out.println(e);
        }
        return choice;
    }
    
    
    
}
