import java.awt.*;
import java.awt.image.BufferedImage;

public class Background{

    int x1 = 0, x2 = 1920;
    float speed;
    BufferedImage image;

    public Background(float speed, BufferedImage image) {
        this.speed = speed;
        this.image = image;
    }

    public void move() {
        x1 -= speed;
        x2 -= speed;
        if(x1 <= -1920) {
            x1 = 0;
            x2 = 1920;
        }
    }

    public void draw(Graphics g) {
        g.drawImage(image, x1, 0, null);
        g.drawImage(image, x2, 0, null);
    }

    public int getX1() {
        return x1;
    }

    public int getX2() {
        return x2;
    }
}
