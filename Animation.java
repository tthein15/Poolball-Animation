// utility stuff

import java.util.ArrayList;

// graphics stuff
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.Random;

public class Animation extends JPanel {
    private int framesPerSecond = 100;
    private int msPerFrame = 10000 / framesPerSecond;

    private int canvasWidth;
    private int canvasHeight;
    private Color backgroundColor;

    private ArrayList<GraphicsObject> objects;

    /* Constructor for a window/canvas of a specified size
     *
     * @param width  The width of the canvas.
     * @param height The height of the canvas.
     */
    public Animation(int width, int height) {
        this(width, height, Color.WHITE);
    }

    /* Constructor for a window/canvas of a specified size, with a specific background color
     *
     * @param width   The width of the canvas.
     * @param height  The height of the canvas.
     * @param color   The background color of the canvas
     */
    public Animation(int width, int height, Color color) {
        this.canvasWidth = width;
        this.canvasHeight = height;
        this.backgroundColor = color;
        this.objects = new ArrayList<GraphicsObject>();
    }

    /* Creates the window and shows it
     */
    public void showCanvas() {
        JFrame frame = new JFrame("Animation");
        frame.getContentPane().add(this, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension dim = new Dimension(this.canvasWidth, this.canvasHeight);
        frame.getContentPane().setPreferredSize(dim);
        frame.pack();
        frame.setVisible(true);
    }

    /* Convenience function to paint all objects.
     */
    public void paint() {
        this.paint(this.getGraphics());
    }

    /* Paint/Draw the canvas.
     *
     * This function overrides the paint function in JPanel. This function is
     * automatically called when the panel is made visible.
     *
     * @param g The Graphics for the JPanel
     */
    @Override
    public void paint(Graphics g) {
        // clear the canvas before painting
        Color oldColor = g.getColor();
        g.setColor(this.backgroundColor);
        g.fillRect(0, 0, this.canvasWidth, this.canvasHeight);
        g.setColor(oldColor);

        // use a for-each loop to draw each object
        for (GraphicsObject obj : this.objects) {
            obj.draw(g);
        }
    }

    public void update(int frame) {
        for (GraphicsObject obj : this.objects) {
            obj.update(this.canvasWidth, this.canvasHeight, frame);
        }
    }

    /* Add an object to be draw.
     *
     * @param obj The object to draw.
     */
    public void addObject(GraphicsObject obj) {
        this.objects.add(obj);
    }

    /* Start the animation
     */
    public void start()
            throws InterruptedException {
        // show the canvas
        this.showCanvas();
        // pause for 0.5 seconds
        Thread.sleep(500);

        // start the animation
        int frame = 0;
        while (true) {
            // update every object
            this.update(frame);
            // draw every object
            this.paint();
            // pause between frames
            Thread.sleep(this.msPerFrame);
            // increment the frame counter
            frame++;
        }
    }

    public static void main(String[] args)
            throws InterruptedException {
        int PICTURE_WIDTH = 1120;
        int PICTURE_HEIGHT = 1120;


        // make a picture that is 560x560 pixels with a white background
        Animation pic = new Animation(PICTURE_WIDTH, PICTURE_HEIGHT, Color.gray);
        pic.addObject(new Rectangle(125, 55, 305, 475, new Color(209,130,82)));
        pic.addObject(new Rectangle(165, 95, 225, 400, Color.GREEN));
        pic.addObject(new Hole(149, 80, 32, 32, Color.BLACK));
        pic.addObject(new Hole(374, 80, 32, 32, Color.BLACK));
        pic.addObject(new Hole(149, 279, 32, 32, Color.BLACK));
        pic.addObject(new Hole(374, 279, 32, 32, Color.BLACK));
        pic.addObject(new Hole(149, 479, 32, 32, Color.BLACK));
        pic.addObject(new Hole(374, 479, 32, 32, Color.BLACK));


        pic.addObject(new person(50,100, 72, 72, Color.blue));
        //Random people
        Random rand = new Random();
        int j = 0;
        while (j < 5) {
            int x = rand.nextInt(600-450) + 450;
            int y = rand.nextInt(550-5) + 5;

            Random randpeople = new Random();
            float r = rand.nextFloat();
            float g = rand.nextFloat();
            float b = rand.nextFloat();
            Color randomColor = new Color(r, g, b);
            pic.addObject(new person(x, y, 72, 72, randomColor));
            j += 1;
        }
        // this adds a background, but I have since moved it to the paint() function
        //pic.addObject(new Rectangle(0, 0, PICTURE_WIDTH, PICTURE_HEIGHT, Color.WHITE));

        // add poolballs
        poolball solid1 = new poolball(165, 95, 25, 25, Color.BLUE);
        solid1.speed_x = 5;
        solid1.speed_y = 5;
        pic.addObject(solid1);

        // add a second rectangle
        poolball solid2 = new poolball(200, 210, 25, 25, Color.ORANGE);
        solid2.speed_x = 3;
        solid2.speed_y = 1;
        pic.addObject(solid2);

        poolball solid3 = new poolball(190, 300, 25, 25, Color.red);
        solid3.speed_x = 4;
        solid3.speed_y = 5;
        pic.addObject(solid3);

        //Table 2
        pic.addObject(new Rectangle(685, 55, 305, 475, new Color(209,130,82)));
        pic.addObject(new Rectangle(725, 95, 225, 400, Color.GREEN));
        pic.addObject(new Hole(709, 80, 32, 32, Color.BLACK));
        pic.addObject(new Hole(934, 80, 32, 32, Color.BLACK));
        pic.addObject(new Hole(709, 279, 32, 32, Color.BLACK));
        pic.addObject(new Hole(934, 279, 32, 32, Color.BLACK));
        pic.addObject(new Hole(709, 479, 32, 32, Color.BLACK));
        pic.addObject(new Hole(934, 479, 32, 32, Color.BLACK));

        //Pool Cue
        poolcue table1 = new poolcue(50, 172, 150, 8, new Color(245,245,220));
        table1.speed_x = 25;
        table1.speed_y = 0;
        pic.addObject(table1);

       //cueball
        cueball A = new cueball(200, 172, 25, 25, Color.WHITE);
        A.speed_x = 15;
        A.speed_y = 0;
        pic.addObject(A);





        // start the animation
        pic.start();
    }

}