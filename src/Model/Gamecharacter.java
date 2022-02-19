package Model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


import Parser.Expressionparse;
import Parser.Node;
import Parser.ProgramNode;
import Parser.SyntaxError;

public class Gamecharacter {

    protected double hp;
    protected double atk;
    protected Boolean status;
    protected Position pos;
    protected String filename;
    protected String type;
    protected Map<String,Double> allVariable = new LinkedHashMap<>();

    public double getATK(){
        return atk;
    }

    public double getHP(){
        return hp;
    }

    public Position getPos(){
        return pos;
    }

    public String getType(){
        return type;
    }

    public void attack(Gamecharacter a){
        hp = hp - a.getATK();
    }

    public void move(Double direction){
        switch(direction.toString()){
            case "1.0" : { 
                System.out.println("move -> up");
                pos.movePosition(0, 1);
                break;
            }
            case "2.0" : { 
                System.out.println("move -> upright");
                pos.movePosition(1, 1);
                break;
            }
            case "3.0" : { 
                System.out.println("move -> right");
                pos.movePosition(1, 0);
                break;
            }
            case "4.0" : { 
                System.out.println("move -> downright");                
                pos.movePosition(1, -1);
                break;
            }
            case "5.0" : { 
                System.out.println("move -> down");
                pos.movePosition(0, -1);
                break;
            }
            case "6.0" : { 
                System.out.println("move -> downleft");
                pos.movePosition(-1, -1);
                break;
            }
            case "7.0" : { 
                System.out.println("move -> left");
                pos.movePosition(-1, 0);
                break;
            }
            case "8.0" : { 
                System.out.println("move -> upleft");
                pos.movePosition(-1, 1);
                break;
            }
        }

    }

    public void runGeneticcode(List<Virus> listVirus,List<Antibody> listAntibody) throws SyntaxError, FileNotFoundException{
        FileReader f = new FileReader(filename);
        ProgramNode pro = new ProgramNode();
        Scanner reader = new Scanner(f);
        List<String> liststat = new LinkedList<>();
        StringBuilder statement = new StringBuilder();
        //StringBuilder whilestatement = new StringBuilder();
        do {
            String l = reader.nextLine();
            String[] splitLine =  l.split(" ");
            if(splitLine[0].equals("if") || splitLine[0].equals("") || splitLine[0].equals("else") ){
                statement.append(l);
            }
            else if(splitLine[0].equals("while")){
                if(!statement.toString().equals("")){
                    liststat.add(statement.toString());   
                }
                     
                statement = new StringBuilder();
                statement.append(l);
            }
            else{
                liststat.add(l);
                if(!statement.toString().equals("")){
                    liststat.add(statement.toString());
                    statement = new StringBuilder();
                }  
            } 
            //System.out.println("split : " + splitLine[0]);
            // Expressionparse e = new Expressionparse(l,this,allVariable,listVirus,listAntibody);
            // e.statementParse().evaluate(); 

        } while (reader.hasNextLine());

        if(!statement.toString().equals("")){
            liststat.add(statement.toString());
        }
        
        //pro.addStatement(newStatement);

        for(String s : liststat){
            Expressionparse e = new Expressionparse(s,this,allVariable,listVirus,listAntibody);
            e.statementParse().evaluate();
        }
    }
    
}
