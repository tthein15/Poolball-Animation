import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class cueball extends GraphicsObject {

    int width;
    int height;
    Color color;

    public cueball(int x, int y, int width, int height, Color color) {
        super(x, y);
        this.width = width;
        this.height = height;
        this.color = color;
    }

    /* Draw the rectangle
     *
     * @param g The Graphics for the JPanel
     */
    @Override
    public void draw(Graphics g) {
        // change the color of the ball
        g.setColor(this.color);
        // draw the ball
        g.drawOval(this.x, this.y, this.width, this.height);
        g.fillOval(this.x, this.y, this.width, this.height);
    }

    /* Update the state of the rectangle
     *
     * @param pic_width  The width of the canvas
     * @param pic_height The height of the canvas
     * @param frame      The number of frames since the start of the animation
     */
    @Override
    public void update(int pic_width, int pic_height, int frame) {
        // this will make rectangles bounce off the side of the window
        if (this.x < 165 || this.x + this.width > 390) {
            this.speed_x = -this.speed_x;
        }
        if (this.y < 95 || this.y + this.height > 495) {
            this.speed_y = -this.speed_y;
        }
        if (this.x > 300) {
            this.color = Color.BLACK;
        }





        // let the superclass' update function handle the actual changes to x and y
        super.update(pic_width, pic_height, frame);
    }

}