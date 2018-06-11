import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Game extends JPanel implements KeyListener, Runnable {

    private JFrame frame;
    private Thread t;
    private boolean gameOn, move;
    private Background[] bGrounds = new Background[8];

    public Game(){
        gameOn = true;
        move = false;
        try{
            bGrounds[0] = new Background(.5f, ImageIO.read(new File("Background/pic0.png")));
            bGrounds[1] = new Background(1f, ImageIO.read(new File("Background/pic1.png")));
            bGrounds[2] = new Background(1.5f, ImageIO.read(new File("Background/pic2.png")));
            bGrounds[3] = new Background(2f, ImageIO.read(new File("Background/pic3.png")));
            bGrounds[4] = new Background(2.5f, ImageIO.read(new File("Background/pic4.png")));
            bGrounds[5] = new Background(3f, ImageIO.read(new File("Background/pic5.png")));
            bGrounds[6] = new Background(3.5f, ImageIO.read(new File("Background/pic6.png")));
            bGrounds[7] = new Background(4f, ImageIO.read(new File("Background/pic7.png")));
        }
        catch(IOException e){}
        frame = new JFrame("Game");
        frame.addKeyListener(this);
        frame.add(this);
        frame.setSize(1000, 700);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        t = new Thread(this);
        t.start();
    }


    @Override
    public void run() {
        while(true){
            if(gameOn){
                if(move){
                    for(Background i : bGrounds) {
                        i.move();
                    }
                }
                repaint();
            }
            try{
                t.sleep(5);
            }
            catch (InterruptedException e){}
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;

        for(Background i : bGrounds) {
            i.draw(g);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == 39) {
            move = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        move = false;
    }

    public static void main(String[] args){
        Game game = new Game();
    }
}
