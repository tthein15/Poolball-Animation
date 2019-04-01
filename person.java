import java.awt.Color;
import java.awt.Graphics;


public class person extends GraphicsObject {

    int width;
    int height;
    Color color;

    public person(int x, int y, int width, int height, Color color) {
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
        // draw the person
        g.drawOval(this.x, this.y, 72, 72);
        g.fillOval(this.x, this.y, 72, 72);

    }

}