//package com.booboo.CAREN.Controller;
//
//import com.booboo.CAREN.Model.Shop;
//import com.booboo.CAREN.Model.Time;
//
//
//public class Button{
//
//  private boolean state;
//  private boolean pauseState = false;
//  private String type;
//
//
////  public Button(String type) {
////    this.type = type;
////  }
//  public Button(boolean state){
//    this.state = state;
//  }
////
////  public void setPauseState(boolean pauseState){
////    System.out.println(pauseState);
////    this.pauseState = pauseState;
////  }
////
////  public boolean getPauseState(){
////    System.out.println("get pause" + pauseState);
////    return pauseState;
////  }
////  public boolean pauseBtn(boolean pauseState) {
////    if (pauseState == false || !type.equals("pause")) {
////      System.out.println("Button type isn't pause");
////    } else {
////
////      Time t = new Time();
////      t.pause();
////      pauseState = false;
////      return true;
////    }
////    return false;
////  }
////
////  public boolean speedUpBtn() {
////    if (state == false || !type.equals("speedUp")) {
////      System.out.println("Button type isn't speedUp");
////    } else {
////      Time t = new Time();
////      t.speedUP();
////      return true;
////    }
////    return false;
////  }
////
////  public boolean speedDownBtn() {
////    if (state == false || !type.equals("speedDown")) {
////      System.out.println("Button type isn't speedDown");
////    } else {
////      Time t = new Time();
////      t.speedDown();
////      return true;
////    }
////    return false;
////  }
////
////  public void zoomInBtn(boolean state) {
////    if (state == false || !type.equals("zoomIn")) {
////      System.out.println("Button type isn't zoomIn");
////    } else {
////      //Wait for zoom design
////
////    }
////  }
////
////  public void zoomOutBtn(boolean state) {
////    if (state == false || !type.equals("zoomOut")) {
////      System.out.println("Button type isn't zoomOut");
////    } else {
////      //Wait for zoom design
////
////    }
////  }
////
////  public int buyAntiA_btn() {
////    if (type==("Buy Antibody A")) {
////      //press this btn
////      return 1;
////    } else {
////      System.out.println("You don't have enough money.");
////    }
////    return 0;
////  }
////
////  public int buyAntiB_btn() {
////    if (type.equals("Buy Antibody B")) {
////      //press this btn
////      return 1;
////    } else {
////      System.out.println("You don't have enough money.");
////    }
////    return 0;
////  }
////
////  public int buyAntiC_btn() {
////    if (type.equals("Buy Antibody C")) {
////      //press this btn
////      return 1;
////    } else {
////        System.out.println("You don't have enough money.");
////    }
////    return 0;
////  }
//}
