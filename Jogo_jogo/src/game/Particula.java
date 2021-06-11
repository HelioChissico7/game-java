/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

/**
 *
 * @author Helio Chissico
 */

  
/**
 *
 * @author Helio Chissico
 */
public class Particula extends Rectangle {
    public Color color;
    
    public int sped =0;
    public int rotation=0;
        double dx, dy;
        public double xa, ya;
  public Particula (int x, int y, int width, int height, Color color){
      super(x, y, width, height);
      xa=x;
      ya=y;
      
      this.color=color;
      dx = new Random().nextGaussian();
        dy=new Random().nextGaussian();
        
      sped=8;
    
        
  }
  public void update(){
      xa+=dx * sped;
      ya+=dy * sped;
  }
  public void render(Graphics g){
      g.setColor(this.color);
      g.fillRect((int)xa, (int)ya, width, height);
  }
}
    

