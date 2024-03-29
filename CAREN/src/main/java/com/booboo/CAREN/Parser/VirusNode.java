package com.booboo.CAREN.Parser;

import java.util.List;

import com.booboo.CAREN.Model.Field;
import com.booboo.CAREN.Model.Gamecharacter;
import com.booboo.CAREN.Model.Virus;

public class VirusNode implements Node{
    
    private Gamecharacter host;
    private List<Virus> listVirus;
    private Field field = Field.getInstance();
    
    VirusNode(Gamecharacter host){
        this.host = host;
        this.listVirus = field.getListVirus();
        this.field = field;
    }

    @Override
    public int evaluate() throws SyntaxError {
        int min = Integer.MAX_VALUE;
        for(Virus v : listVirus){
            int newmin = findLocation(host.getPos().PosX(), host.getPos().PosY(), v.getPos().PosX(), v.getPos().PosY());
            if(newmin < min)
                min = newmin;
        }
        if(min == Integer.MAX_VALUE)
            return 0;
        return min;
    }

    public int findLocation(int hostX,int hostY,int targetX, int targetY){
        int diffY = hostY - targetY;
        // locate 6-7-8
        if(diffY > 0){
            // locate 6
            if( hostX < targetX && targetX - hostX == hostY - targetY )
                return ( targetX - hostX )*10 + 6;
            // locate 8
            if(  hostX > targetX && hostX - targetX == hostY - targetY )
                return ( hostX - targetX )*10 + 8;
            // locate 7
            if( hostX == targetX )
                return ( hostY - targetY )*10 + 7;
        }
        // locate 2,3,4
        else if(diffY < 0){
            // local 4
            if( hostX < targetX && targetX - hostX == targetY - hostY )
                return ( targetX - hostX )*10 + 4;
            // locate 2
            if(  hostX > targetX && hostX - targetX == targetY - hostY)
                return ( hostX - targetX )*10 + 2;
            // locate 3
            if( hostX == targetX )
                return ( targetY - hostY ) * 10 + 3;
        }
        // locate 1,5
        else{
            if( hostX > targetX )
                return ( hostX - targetX )*10 + 1;
            if( hostX < targetX )
                return ( targetX - hostX )*10 + 5;

        }
        return Integer.MAX_VALUE;
    }
    
}
