import java.awt.Color;
import java.awt.Graphics;

public class Hole extends GraphicsObject {

    int width;
    int height;
    Color color;

    public Hole(int x, int y, int width, int height, Color color) {
        super(x, y);
        this.width = width;
        this.height = height;
        this.color = color;
    }

    /* Draw the ray of sun
     *
     * @param g The Graphics for the JPanel
     */
    @Override
    public void draw(Graphics g) {
        // change the color of the pen
        g.setColor(this.color);
        // draw the sun
        g.drawOval(this.x, this.y, this.width, this.height);
        g.fillOval(this.x, this.y, this.width, this.height);

    }

}