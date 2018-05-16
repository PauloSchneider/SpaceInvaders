package spaceinvaders;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Dimension;
//ttt
//ttt
public class Space extends JPanel{
		
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

int [ ] [ ] game = {   
    { 1,1,1,1,0,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1 },
    { 1,1,1,1,0,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1 },
    { 1,0,0,0,0,1,0,0,0,1,0,1,1,0,0,1,0,0,1,1,0,1,0,0,0,0 },
    { 1,0,1,1,0,1,1,1,1,1,0,1,1,0,0,1,0,0,1,1,0,1,1,1,1,0 },
    { 1,0,0,1,0,1,1,1,1,1,0,1,1,0,0,1,0,0,1,1,0,1,0,0,0,0 },
    { 1,1,1,1,0,1,0,0,0,1,0,1,1,0,0,1,0,0,1,1,0,1,1,1,1,1 },
    { 1,1,1,1,0,1,0,0,0,1,0,1,1,0,0,1,0,0,1,1,0,1,1,1,1,1 }
  };
  
  int [ ] [ ] over = {   
    { 1,1,1,1,1,0,1,0,0,0,1,0,1,1,1,1,1,0,1,1,1,1,1 },
    { 1,1,1,1,1,0,1,0,0,0,1,0,1,1,1,1,1,0,1,1,1,1,1 },
    { 1,0,0,0,1,0,1,0,0,0,1,0,1,0,0,0,0,0,1,0,0,0,1 },
    { 1,0,0,0,1,0,1,0,0,0,1,0,1,1,1,1,0,0,1,1,1,1,0 },
    { 1,0,0,0,1,0,1,1,0,1,1,0,1,0,0,0,0,0,1,1,1,1,1 },
    { 1,1,1,1,1,0,1,1,0,1,1,0,1,1,1,1,1,0,1,0,0,0,1 },
    { 1,1,1,1,1,0,0,1,1,1,0,0,1,1,1,1,1,0,1,0,0,0,1 }
  };
  
  int [ ] [ ] win = {   
		    { 1,1,0,1,1,0,1,1,0,1,1,0,1,1,1,1,0,0,0,1,1 },
		    { 1,1,0,1,1,0,1,1,0,1,1,0,1,1,1,1,0,0,0,1,1 },
		    { 1,1,0,1,1,0,1,1,0,1,1,0,1,1,0,1,1,0,0,1,1 },
		    { 1,1,0,1,1,0,1,1,0,1,1,0,1,1,0,0,1,1,0,1,1 },
		    { 1,1,0,1,1,0,1,1,0,1,1,0,1,1,0,0,0,1,1,1,1 },
		    { 0,1,1,1,1,1,1,0,0,1,1,0,1,1,0,0,0,0,1,1,1 },
		    { 0,0,1,1,1,1,0,0,0,1,1,0,1,1,0,0,0,0,1,1,1 }
		  };

  
  private static Inimigo [] inimigos;
  private static int totalEnem;
  private static Tiro [] tiros;
  private static int totalTiros;
  private static int platX=1;
  
  private static int boardWidth;
  private static int boardHeight;
  
  private static boolean esquerda=false;
  private static boolean direita=false;
  private static boolean espaco=false;
  private static boolean gameOver=false;
  private static boolean ganhou=false;
  
  private final static JFrame frame = new JFrame("Space");
  
  public static int getBoardWidth(){
	  return boardWidth;
  }

  public static int getBoardHeight(){
	  return boardHeight;
  }

    public static int getPlatX() {
        return platX;
    }

    public static void setPlatX(int platX) {
        Space.platX = platX;
    }
  
  
  /*
   * Desenha na tela o jogo. 
   */
  public static void desenha(Inimigo [] enem, int te, Tiro [] tir, int tirT){
	inimigos = enem;
	totalEnem = te;
	
	tiros = tir;
	totalTiros = tirT;
	
    frame.repaint();
    try{
      Thread.sleep(250);
    }catch(java.lang.InterruptedException e){
    }
  }
  
  private static int [][] invader = {	  
	    { 0,0,1,0,0,0,0,0,1,0,0 },
	    { 0,0,0,1,0,0,0,1,0,0,0 },
	    { 0,0,1,1,1,1,1,1,1,0,0 },
	    { 0,1,1,0,1,1,1,0,1,1,0 },
	    { 1,1,1,1,1,1,1,1,1,1,1 },
	    { 1,0,1,1,1,1,1,1,1,0,1 },
	    { 1,0,1,0,0,0,0,0,1,0,1 },
	    { 0,0,0,1,1,0,1,1,0,0,0 },
	    
  };
  
  public static void drawEnemy(int x, int y, Graphics g){

      for(int i=0; i<invader[0].length; i++){
          for(int j=0; j<invader.length; j++){
            if(invader[j][i] == 1){
              g.drawOval((i+x)*5 - 5, (j+y)*5 -5, 5, 5);
              g.fillOval((i+x)*5 - 5, (j+y)*5 -5, 5, 5);
            }
          }
        }
  }
  
  public void paintComponent(Graphics g) {

	int width = getWidth();
    int height = getHeight();
    g.setColor(Color.black);

    for(int i=0; i < totalEnem; i++){
    	drawEnemy(inimigos[i].x, inimigos[i].y, g);
    }
    
    for(int i=0; i < totalTiros; i++){
    	g.drawOval(tiros[i].x*5, tiros[i].y*5, 5, 5);
    	g.fillOval(tiros[i].x*5, tiros[i].y*5, 5, 5);
    }
    
    g.drawRect((platX-1)*5, (boardHeight-2)*5, 6*5, 5);
    g.fillRect((platX-1)*5, (boardHeight-2)*5, 6*5, 5);
    g.drawRect((platX+1)*5, (boardHeight-3)*5, 5, 5);
    g.fillRect((platX+1)*5, (boardHeight-3)*5, 5, 5);
    g.drawRect((platX+2)*5, (boardHeight-3)*5, 5, 5);
    g.fillRect((platX+2)*5, (boardHeight-3)*5, 5, 5);
    
    g.setColor(Color.black);

    if(gameOver){
      for(int i=0; i<game[0].length; i++){
        for(int j=0; j<game.length; j++){
          if(game[j][i] == 1){
            g.drawRect((i+11)*5 - 5, (j+10)*5 -5, 5, 5);
            g.fillRect((i+11)*5 - 5, (j+10)*5 -5, 5, 5);
          }
        }
      }
      
      for(int i=0; i<over[0].length; i++){
        for(int j=0; j<over.length; j++){
          if(over[j][i] == 1){
            g.drawRect((i+26)*5 - 5, (j+20)*5 - 5, 5, 5);
            g.fillRect((i+26)*5 - 5, (j+20)*5 - 5, 5, 5);
          }
        }
      }      
    }
    
    if(ganhou){
        for(int i=0; i<win[0].length; i++){
          for(int j=0; j<win.length; j++){
            if(win[j][i] == 1){
              g.drawOval((i+21)*5 - 5, (j+20)*5 - 5, 5, 5);
              g.fillOval((i+21)*5 - 5, (j+20)*5 - 5, 5, 5);
            }
          }
        }
    }
    
    g.setColor(Color.lightGray);
    for(int i=0; i<height; i++){
      g.drawLine(0, i*5, boardWidth*5, i*5);
    }
    
    for(int i=0; i<width; i++){
      g.drawLine(i*5, 0, i*5, boardHeight*5);
    }
  }
  
  /*
   * Desenha uma mensagem de game over na pr?xima
   * vez que chamar desenha(). 
   */
  public static void gameOver(){
    gameOver = true;
  }
  
  /*
   * Desenha uma mensagem de WIN
   * da proxima vez que chamar desenha(). 
   */
  public static void ganhou(){
    ganhou = true;
  }

  /*
   * Posiciona a plataforma na casa x.
   * 
   * @param x posi??o da coluna onde a plataforma ser? desenhada.
   */
  public static void setPlataforma(int x){
    platX = x;
  }

  /*
   * Retorna verdadeiro se a seta para a esquerda estiver sendo
   * pressionada pelo usu?rio.
   * 
   * @return verdadeiro (true) caso a seta para a esquerda estiver
   * sendo precionada, falso (false) caso contr?rio.
   */
  public static boolean apertouEsquerda(){
    return esquerda;
  }
  
  /*
   * Retorna verdadeiro se a seta para a direita estiver sendo
   * pressionada pelo usu?rio.
   * 
   * @return verdadeiro (true) caso a seta para a direita estiver
   * sendo precionada, falso (false) caso contr?rio.
   */
  public static boolean apertouDireita(){
    return direita;
  }
  
  /*
   * Retorna verdadeiro se a espaco for precionado
   * 
   * @return verdadeiro (true) caso o espaco estiver precionado
   * @return falso (false) caso contr?rio.
   */
  public static boolean apertouEspaco(){
    return espaco;
  }
  
  /*
   * Inicia a janela do jogo. Este m?todo deve ser chamado
   * somente uma vez em todo o programa.
   */
  public static void init(){
    boardWidth = 80;
    boardHeight = 80;
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Space a = new Space();
    a.setPreferredSize(new Dimension(boardWidth*5,boardHeight*5));
    frame.getContentPane().add(a);
    frame.pack();
    frame.setResizable(false);
    frame.setVisible(true);
    frame.setBackground(Color.WHITE);
    frame.addKeyListener(new KeyListener() {    
      public void keyPressed(KeyEvent e) { 
        if (e.getKeyCode() == KeyEvent.VK_RIGHT){
          //seta para a direita
          direita = true;
        }else if (e.getKeyCode() == KeyEvent.VK_LEFT){
          //seta para a esquerda
          esquerda = true;          
        }else if (e.getKeyCode() == KeyEvent.VK_ESCAPE){
          ganhou = true;          
        }else if (e.getKeyCode() == KeyEvent.VK_SPACE){
          espaco = true;          
        }
        
        
      }
      
      public void keyReleased(KeyEvent e) {
          if (e.getKeyCode() == KeyEvent.VK_RIGHT){
              direita = false;
            }else if (e.getKeyCode() == KeyEvent.VK_LEFT){
              esquerda = false;          
            }else if (e.getKeyCode() == KeyEvent.VK_SPACE){
                espaco = false;          
            }
      }
      
      public void keyTyped(KeyEvent e) {
      }
      
    });
    
  }
  
}
