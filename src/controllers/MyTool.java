/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class MyTool {
    public static Scanner sc = new Scanner(System.in);
    public static String getString(String msg,String err){
       String input;
       while(true){
           System.out.print(msg);
           input = sc.nextLine();
           if(input.isEmpty()){
               System.out.print(err);
           }else{
               return input.trim();
           }
       }
    }
    
    public static String getUpdateString(String msg,String old){
       String input;
       while(true){
           System.out.print(msg);
           input = sc.nextLine();   
           if(input.isEmpty()){
               return old;
           }else{
               return input.trim();     
           }
                 
       }
    }
public static String regexString(String inputMsg, String errorMsg, String format) {
        String id;
        boolean match;
        while (true) {
            System.out.print(inputMsg);
            id = sc.nextLine().trim();
            match = id.matches(format);
            if (id.length() == 0 || id.isEmpty() || match == false)
                System.out.println(errorMsg);
            else
                return id;            
        }
    }
    
    public static boolean getYesNo(String message){
        String option = regexString(message, "Invalid input!!Enter again.", "^[Y|y|n|N]$");
        if(option.equalsIgnoreCase("Y")){
            return true;
        } return false;
    }
    
    public static String getCollectionName(String msg,String err,String err1){
        String input;
        while(true){
            System.out.print(msg);
            input = sc.nextLine().trim();
            if(input.equalsIgnoreCase("game")||input.equalsIgnoreCase("music")||input.equalsIgnoreCase("movie")){
                return input;
            }else if(input.isEmpty()){
                System.out.print(err);
            }else{
                System.out.print(err1);
            }
        }
    }
    
    public static String getTypeName(String msg,String err,String err1){
        String input;
        while(true){
            System.out.print(msg);
            input = sc.nextLine().trim();
            if(input.equalsIgnoreCase("audio")||input.equalsIgnoreCase("video")){
                return input;
            }else if(input.isEmpty()){
                System.out.println(err);
            }else{
                 System.out.println(err1);
            }
        }
    }

   
    
}
        

