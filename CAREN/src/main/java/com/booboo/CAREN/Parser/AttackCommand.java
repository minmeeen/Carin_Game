package com.booboo.CAREN.Parser;


import java.util.List;

import com.booboo.CAREN.Model.Antibody;
import com.booboo.CAREN.Model.Field;
import com.booboo.CAREN.Model.Gamecharacter;
import com.booboo.CAREN.Model.Position;
import com.booboo.CAREN.Model.Virus;

public class AttackCommand implements Node{

    protected Node direction;
    protected Gamecharacter host;
    private List<Virus> listVirus;
    private List<Antibody> listAntibody;
    private Field field = Field.getInstance();

    AttackCommand(Node direction, Gamecharacter host){
        this.direction = direction;
        this.host = host;
        this.listAntibody = field.getListAntibody();
        this.listVirus = field.getListVirus();
    }

    @Override
    public int evaluate() throws SyntaxError {
        System.out.println("attack -> " + direction.evaluate());
        Position target = targetLocation(host.getPos(), direction.evaluate());
        System.out.println("Pos Target -> x : " + target.PosX() + "y : " + target.PosY());
        if(host.getType().equals("A") || host.getType().equals("B") || host.getType().equals("C")){

//            for(Virus v : listVirus){
//                if(v.getPos().equalPos(target)){
//                    System.out.println(v.getType() + " attack by " + host.getType());
//                    v.attackedBy(host);
//                }
//            }
            for(int i=0; i<listVirus.size() ; i++){
                Virus v = listVirus.get(i);

                if(v.getPos().equalPos(target)){
                    System.out.println(v.getType() + " attack by " + host.getType());
                    v.attackedBy(host);
                }
            }
        }
        else{
//            for(Antibody a : listAntibody){
//                if(a.getPos().equalPos(target)){
//                    System.out.println(a.getType() + " attack by " + host.getType());
//                     a.attackedBy(host);
//                }
//            }
            for(int i=0; i< listAntibody.size() ; i++){
                Antibody a = listAntibody.get(i);
                if(a.getPos().equalPos(target)){
                    System.out.println(a.getType() + " attack by " + host.getType());
                }
                a.attackedBy(host);

            }
        }

        return 0;
    }

    public Position targetLocation(Position hostPos,int direction){
        
        switch((int) direction){
            case 1 : {
                return new Position(hostPos.PosX()-1, hostPos.PosY());
            }
            case 2 : {
                return new Position(hostPos.PosX()-1, hostPos.PosY()+1);
            }
            case 3 : {
                return new Position(hostPos.PosX(), hostPos.PosY()+1);
            }
            case 4 : {
                return new Position(hostPos.PosX()+1, hostPos.PosY()+1);
            }
            case 5 : {
                return new Position(hostPos.PosX()+1, hostPos.PosY());
            }
            case 6 : {
                return new Position(hostPos.PosX()+1, hostPos.PosY()-1);
            }
            case 7 : {
                return new Position(hostPos.PosX(), hostPos.PosY()-1);
            }
            case 8 : {
                return new Position(hostPos.PosX()-1, hostPos.PosY()-1);
            }
        }   
        return null;     
    }
    
}
