/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;

/**
 *
 * @author Helio Chissico
 */
public class Spanner {
    public int time=0;
    
    public List<RectObj> rectangles = new ArrayList<RectObj>();
    
    public List<Particula> particula = new ArrayList<Particula>();
    
    public void update(){
        time++;
        if(time%60==0){
            rectangles.add(new RectObj(0, new Random().nextInt(480-40), 40, 40));
        }
        for(int i=0; i<rectangles.size(); i++){
            
            rectangles.get(i).update();
            RectObj current = rectangles.get(i);
            if(current.x> Game.WIDTH){
                rectangles.remove(current);
                Game.contador-=4;
                
            }
            if(Game.clicado){
                if(Game.mx >= current.x && Game.mx < current.x + current.width){
                    
               if(Game.my >= current.y && Game.my < current.y + current.height){
                   rectangles.remove(current);
                   Game.pontuacao++;
                   Game.clicado = true;
                   
                   for(int n=0; n<500; n++){
                       particula.add(new Particula(current.x,current.y ,8, 8, current.color));
                   }
               }  
               } 
            }
        }
        for(int i=0; i<particula.size(); i++){
            particula.get(i).update();
        }
        
    }
    public void render(Graphics g){
        
    
    for(int i=0; i<rectangles.size(); i++){
    
        RectObj current = rectangles.get(i);
            
        Graphics2D g2 =(Graphics2D) g;
       g2.rotate(Math.toRadians(current.rotation), current.x+current.width/2, current.y+current.height/2);
        g2.setColor(current.color);
        g2.fillRect(current.x, current.y, current.width, current.height);
        g2.rotate(Math.toRadians(-current.rotation), current.x+current.width/2, current.y+current.height/2);
    }
     for(int i=0; i<particula.size(); i++){
            particula.get(i).render(g);
        }
}
}
