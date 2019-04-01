import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Rectangle extends GraphicsObject {

    int width;
    int height;
    Color color;

    public Rectangle(int x, int y, int width, int height, Color color) {
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
        // change the color of the pen
        g.setColor(this.color);
        // draw the rectangle
        g.fillRect(this.x, this.y, this.width, this.height);
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
        if (this.x < 0 || this.x + this.width > pic_width) {
            this.speed_x = -this.speed_x;
        }
        if (this.y < 0 || this.y + this.height > pic_height) {
            this.speed_y = -this.speed_y;
        }


        if (frame % 20 == 0) {
            this.speed_y = -this.speed_y;
        }


        /*
        // we can also change color
        Random randy = new Random();
        this.color = new Color(
                randy.nextInt(255),
                randy.nextInt(255),
                randy.nextInt(255)
        );*/

        // let the superclass' update function handle the actual changes to x and y
        super.update(pic_width, pic_height, frame);
    }

}