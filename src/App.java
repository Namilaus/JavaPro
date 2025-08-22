import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class App extends JPanel{

    private int x = 1, y = 1;
    JFrame frame;
    public App(JFrame frame){
        this.frame = frame;
    }

    public static void main(String[] args) {


    List<String> words = new ArrayList<>();
    words.add("Tree");
    words.add("Hello");
    words.add("World");
    words.add("Race");
    words.add("Game");
    words.add("Numbers");
    words.add("Ride");
    System.out.println(Math.toDegrees(.7));
    System.out.println("Hello, World!");
    
    JFrame frame = new JFrame("Test");
    App panel = new App(frame);
    
    
    frame.add(panel);
    frame.setSize(400, 400);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    panel.setFocusable(true);
    frame.setVisible(true);
    panel.requestFocus();

    System.out.println(frame.getHeight());

    List<String> filterWord = words.stream().filter(word -> word.equals("m")).map(word -> word.toUpperCase()).collect(Collectors.toList());
    System.out.println("Filtered words:");
    for (String word : filterWord) {
        System.out.println(word);
    }
    panel.addKeyListener(new KeyListener() {
        
        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_D){
                System.out.println("d is pressed");
                int[] xAndy = panel.getXandY();

                panel.setXandY(xAndy[0]+1,xAndy[1]);
                panel.repaint();
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            // TODO Auto-generated method stub
            System.out.println("Somekey releases");
        }

        @Override
        public void keyTyped(KeyEvent e) {
            // TODO Auto-generated method stub
                if(e.getKeyCode() == KeyEvent.VK_D){
                System.out.println("d is typed");
            }

        };
    });
    

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
        g.setColor(Color.blue);

        int[] xAndy = getXandY();

        
        g.fillRect(xAndy[0], xAndy[1], 5+xAndy[0], 5);
        g.setColor(Color.magenta);
        System.out.println("Cannot pain");
        g.setFont(new Font("Serif", Font.BOLD, 20));
        g.drawString("Coolen Text", 50, 250);
        
    }
}