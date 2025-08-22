import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class App extends JPanel{
    private int dirX = 1, dirY = 0;
    private int x = 1, y = 1;
    JFrame frame;
    public App(JFrame frame){
        this.frame = frame;
    }

    public static void main(String[] args) {

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
            if(e.getKeyCode() == KeyEvent.VK_D){

                int[] xAndy = panel.getXandY();
                panel.setDirXandY(1, 0);
                panel.setXandY(xAndy[0]+1,xAndy[1]);
                panel.repaint();

            }else if(e.getKeyCode() == KeyEvent.VK_S){
                int[] xAndy = panel.getXandY();
                panel.setDirXandY(0, 1);                


                panel.setXandY(xAndy[0], xAndy[1]+1);
                panel.repaint();
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            // TODO Auto-generated method stub
            System.out.println("Somekey releases: "+ e.getKeyChar());
        }

        @Override
        public void keyTyped(KeyEvent e) {
            // TODO Auto-generated method stub
                if(e.getKeyCode() == KeyEvent.VK_D){
                System.out.println("d is typed");
            }

        };
    });

    while (true) {
     try {
        Thread.sleep(100);
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

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        int[] xAndy = getXandY();
        
        g.setColor(Color.blue);
        g.fillRect(xAndy[0], xAndy[1], 10, 10);
        g.setColor(Color.magenta);
        g.setFont(new Font("Serif", Font.BOLD, 20));
        g.drawString("Simple Sneak Game", this.frame.getContentPane().getWidth()/2, 20);
        
    }
}