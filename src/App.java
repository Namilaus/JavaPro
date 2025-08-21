import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;


public class App extends JPanel{

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
    App panel = new App();
    frame.add(panel);
    frame.setSize(400, 400);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);

    System.out.println(frame.getHeight());

    List<String> filterWord = words.stream().filter(word -> word.equals("m")).map(word -> word.toUpperCase()).collect(Collectors.toList());
    System.out.println("Filtered words:");
    for (String word : filterWord) {
        System.out.println(word);
    }


    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.blue);
        g.fillRect(250, 50, 100, 100);
        g.setColor(Color.magenta);
        g.setFont(new Font("Serif", Font.BOLD, 20));
        g.drawString("Coolen Text", 50, 250);

    }
}