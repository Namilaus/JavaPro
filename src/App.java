import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;


public class App extends JPanel{
    public static final int FPS = 100; // every 100 milliseconds refereshing 1 time also 60 time in a second
    public final int SNAKELENGTH = 15;
    public final int SNAKEWIDTH = 10;
    
    private int dirX = 1, dirY = 0;
    private int x = 0, y = 0;
    JFrame frame;

    public App(JFrame frame){
        this.frame = frame;
        Random rand = new Random();
        // random spawn point
        x = rand.nextInt(100) + 1;
        y = rand.nextInt(100) + 1;
    }

    public static void main(String[] args) {

    // init window
    JFrame frame = new JFrame("Test");
    App panel = new App(frame);
    frame.add(panel);
    frame.setSize(400, 400);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    panel.setFocusable(true);
    frame.setVisible(true);
    panel.requestFocus();


    panel.addKeyListener(new KeyListener() {
       
        @Override
        public void keyPressed(KeyEvent e) {
           switch (e.getKeyCode()) {
            case KeyEvent.VK_D:
                int[] xAndy = panel.getXandY();
                panel.setDirXandY(1, 0);
                panel.setXandY(xAndy[0]+1,xAndy[1]);
                panel.repaint();
                break;
            case KeyEvent.VK_S:
                xAndy = panel.getXandY();
                panel.setDirXandY(0, 1);                
                panel.setXandY(xAndy[0], xAndy[1]+1);
                panel.repaint();
                break;
            case KeyEvent.VK_W:
                xAndy = panel.getXandY();
                panel.setDirXandY(0, -1);                
                panel.setXandY(xAndy[0], xAndy[1]-1);
                panel.repaint();
                break;
            case KeyEvent.VK_A:
                xAndy = panel.getXandY();
                panel.setDirXandY(-1, 0);                
                panel.setXandY(xAndy[0]-1, xAndy[1]);
                panel.repaint();
                break;
            default:
                break;
           }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            System.out.println("Some key releases: "+ e.getKeyChar());
        }

        @Override
        public void keyTyped(KeyEvent e) {
            //TODO
            

        };
    });

    while (true) {
     try {
        Thread.sleep(FPS);
        int[] currXandY = panel.getXandY();
        int[] currDirXandY = panel.getDirXandY();
        panel.setXandY(currXandY[0]+currDirXandY[0], currXandY[1]+currDirXandY[1]);
        panel.repaint();
     } catch (InterruptedException e) {
        e.printStackTrace();
     }
    }
    }
    
    public int[] getDirXandY(){
        return new int[] {this.dirX, dirY};
    }

    public void setDirXandY(int x, int y){
        this.dirX = x;
        this.dirY = y;
    }

    public int[] getXandY(){
        return new int[] {x, y};
    }
    
    public void setXandY(int x,int y){
       this.x =  x;
       this.y = y;
    }


    public void generateFruit(Graphics g){
        g.setColor(Color.red);
        g.fillRect(100, 100, 50, 50);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        int[] xAndy = getXandY();
        
        g.setColor(Color.blue);
        
        // rotate the snake
        if(this.dirX  == 1 || this.dirX == -1){
        g.fillRect(xAndy[0], xAndy[1], SNAKELENGTH, SNAKEWIDTH);
        }else{
        g.fillRect(xAndy[0], xAndy[1], SNAKEWIDTH, SNAKELENGTH);
        }


        g.setColor(Color.magenta);
        g.setFont(new Font("Serif", Font.BOLD, 20));
        g.drawString("Simple Sneak Game", this.frame.getContentPane().getWidth()/2, 20);

        generateFruit(g);
        
    }
}