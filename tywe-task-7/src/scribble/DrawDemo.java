import java.awt.*;
import java.util.Random;

/**
 * Class DrawDemo - provides some short demonstrations showing how to use the
 * Pen class to create various drawings.
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */

public class DrawDemo
{
    private Canvas myCanvas;
    private Random random;

    /**
     * Prepare the drawing demo. Create a fresh canvas and make it visible.
     */
    public DrawDemo()
    {
        myCanvas = new Canvas("Drawing Demo", 500, 400);
        random = new Random();
    }

    /**
     * Draw a square on the screen.
     */
    public void drawSquare()
    {
        Pen pen = new Pen(320, 260, myCanvas);
        pen.setColor(Color.BLUE);
        square(pen);
    }

    public void drawTriangle()
    {
        Pen pen = new Pen(320, 260, myCanvas);
        pen.setColor(Color.GREEN);
        triangle(pen);
    }

    private void triangle(Pen pen)
    {
        for(int i = 0; i < 3; i++) {
            pen.move(100);
            pen.turn(120);
        }
    }

    public void drawPentagon()
    {
        Pen pen = new Pen (320, 260, myCanvas);
        pen.setColor(Color.RED);
        pentagon(pen);
    }

    private void pentagon (Pen pen)
    {
        for (int i = 0; i < 5; i++){
            pen.move(100);
            pen.turn(72);
        }
    }


    /**
     * Draw a wheel made of many squares.
     */
    public void drawWheel()
    {
        Pen pen = new Pen(250, 200, myCanvas);
        pen.setColor(Color.RED);

        for (int i=0; i<36; i++) {
            square(pen);
            pen.turn(10);
        }
    }

    /**
     * Draw a square in the pen's color at the pen's location.
     */
    private void square(Pen pen)
    {
        for (int i=0; i<4; i++) {
            pen.move(100);
            pen.turn(90);
        }
    }
    public void drawPolygon (int n)
    {
      Pen pen = new Pen(250, 200, myCanvas);
      pen.setColor(Color.BLUE);
      polygon(pen,n);
    }

    private void polygon(Pen pen, int n)
    {
      for (int i = 0; i < n; i++){
          pen.move(50);
          pen.turn(360/n);
        }
    }
    /**
     * Draw some random squiggles on the screen, in random colors.
     */
    public void colorScribble()
    {
        Pen pen = new Pen(250, 200, myCanvas);

        for (int i=0; i<10; i++) {
            // pick a random color
            int red = random.nextInt(256);
            int green = random.nextInt(256);
            int blue = random.nextInt(256);
            pen.setColor(new Color(red, green, blue));

            pen.randomSquiggle();
        }
    }

    private void spiral (Pen pen)
    {
      pen.penUp();
      Dimension canvasSize = myCanvas.getSize();
      pen.moveTo(canvasSize.width/2, canvasSize.height/2);
      pen.turnTo(90);
      pen.penDown();

      int lines = 50;             //the number of lines being drawn
      int linesLength = 4;
      int linesIncrease = 3;      //increase the lines by 3 to make a spiral

      for (int i=0; i < lines; i++){
        pen.move(linesLength);
        pen.turn(90);
        linesLength = linesLength + linesIncrease;
      }

    }

    public void drawSpiral()
    {
        Pen pen = new Pen(320, 260, myCanvas);
        pen.setColor(Color.BLACK);
        spiral(pen);
    }

    /**
     * Clear the screen.
     */
    public void clear()
    {
        myCanvas.erase();
    }
}
