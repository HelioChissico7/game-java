/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Color;

import java.awt.Rectangle;

import java.util.Random;

/**
 *
 * @author Helio Chissico
 */
public class RectObj extends Rectangle {
    public Color color;
    
    public int sped =0;
    public int rotation=0;
  public RectObj(int x, int y, int width, int height){
      super(x, y, width, height);
      
      color= new Color( new Random().nextInt(255), new Random().nextInt(255), new Random().nextInt(255));
      
      sped= new Random().nextInt(6-4)+8;
  }
  public void update(){
      x+=sped;
      rotation+=50;
      if(rotation>=360)
      rotation=0;
  }
}