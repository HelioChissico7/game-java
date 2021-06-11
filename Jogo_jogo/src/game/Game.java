/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Helio Chissico
 */

 
/**
 *
 * @author Helio Chissico
 */
@SuppressWarnings("serial")
public class Game extends Canvas implements Runnable, MouseListener{
    public static final int WIDTH =1500, HEIGHT =880;
    public static int contador=100;
    public static int pontuacao =0;
    public static int mx, my;
    public static boolean clicado=false;
    
        

    
    public Spanner spanner;
    public boolean gameOver=false; 
    public Game(){
        Dimension dimension = new Dimension (WIDTH, HEIGHT);
        this.setPreferredSize(dimension);
        this.addMouseListener(this);
        spanner =new Spanner();
     

    }
    
    public void update(){
        if(gameOver  == false){
        spanner.update();
        if(contador<=0){
            contador=100;
            
            gameOver=true;
        }  
        }
     
    }
      public void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.darkGray);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        if(gameOver==false){
        /*
        g.setColor(Color.white);
        g.setFont(new Font("Arial", Font.BOLD, 23));
        g.drawString("Pontos: "+contador, WIDTH/2, 20);
                */
        
        g.setColor(Color.green);
        g.fillRect(Game.WIDTH/2-100, 20, contador*2, 20);
         g.setColor(Color.white);
         
        g.drawRect(Game.WIDTH/2-100, 20, 200,20);
        spanner.render(g);
        }else{
            g.setColor(Color.white);
        g.setFont(new Font("Arial", Font.BOLD, 25));
        g.drawString("VOCE PERDEU!",WIDTH/2-100, HEIGHT/2);
        g.drawString("PONTOS: "+this.pontuacao,WIDTH/2-70,HEIGHT/2+55);
        g.drawString("PRECIONE ENTER PARA VOLTAR AO JOGO", WIDTH/2-250,HEIGHT/2+99);
        }
         bs.show();
        
         
    }
    public static void main(String[] args) {
        Game game = new Game();
        JFrame jframe = new JFrame("Heliote");
        jframe.add(game);
        jframe.setLocationRelativeTo(null);
        jframe.pack();
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setVisible(true);
        
        new Thread(game).start();
        
    }

    @Override
    public void run() {
        
        while(true){
          update();
          render();
            
            try {
                Thread.sleep(1000/60);
            } catch (InterruptedException ex) {
                
            }
           
        }
        
        
    }

  

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        clicado=true;
      mx = e.getX();
      my= e.getY();
          
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
}

    

