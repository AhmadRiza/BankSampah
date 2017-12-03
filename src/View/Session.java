/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author riza
 */

public class Session {
    
   private static boolean login = false; 
   
   public static boolean isLogIn(){
       return login;
   }
   
   public static void login(){
       login = true;
   }
   
   public static void logOut(){
       login = false;
   }
   
}
