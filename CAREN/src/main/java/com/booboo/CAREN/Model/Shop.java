package com.booboo.CAREN.Model;

import javax.sql.rowset.spi.SyncResolver;

import com.booboo.CAREN.Controller.Button;

public class Shop {
    
    protected int balance ;

    public Shop(){
         this.balance = 100;
    }


    public int getBalance(){
        return balance;
    }

    public int getBalance(){
        return balance;
    }

    public void buyAntiA(String type,int btn){
        if(balance>=20 && type.equals("A") && btn == 1){
            Characterfactory facAnti = new Characterfactory();
            facAnti.createAntibody("A");
            this.balance -=20;
            System.out.println("your balance is "+this.balance);
        }else{
            System.out.println("you dont have enough money");
        }
    }

    public void buyAntiB(String type,int btn){
        if(balance>=50 && type.equals("B") && btn == 1){
            Characterfactory facAnti = new Characterfactory();
            facAnti.createAntibody("B");
            this.balance -=50;
            System.out.println("your balance is "+this.balance);
        }else{
            System.out.println("you dont have enough money");
        }
    }

    public void buyAntiC(String type,int btn){
        if(balance>=50 && type.equals("C") && btn == 1){
            Characterfactory facAnti = new Characterfactory();
            facAnti.createAntibody("C");
            this.balance -=50;
            System.out.println("your balance is "+this.balance);
        }else{
            System.out.println("you dont have enough money");
        }
    }
        

}
