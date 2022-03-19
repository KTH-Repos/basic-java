import java.awt.geom.*;
import java.awt.*;

public class BoxBall
{
  private static final int GRAVITY = 3;  // effect of gravity

    private int ballDegradation = 2;
    private Ellipse2D.Double circle;
    private Color color;
    private int diameter;
    private int xPosition;
    private int yPosition;
    private final int groundPosition;      // y position of ground
    private final int topPosition;
    private final int leftSide;
    private final int rightSide;
    private Canvas canvas;
    private int ySpeed;             // initial downward speed
    private int xSpeed;

    /**
     * Constructor for objects of class BouncingBall
     *
     * @param xPos  the horizontal coordinate of the ball
     * @param yPos  the vertical coordinate of the ball
     * @param ballDiameter  the diameter (in pixels) of the ball
     * @param ballColor  the color of the ball
     * @param groundPos  the position of the ground (where the wall will bounce)
     * @param drawingCanvas  the canvas to draw this ball on
     */
    public BoxBall(int xPos, int yPos, int ballDiameter, Color ballColor,
                        int groundPos,int groundPos2, int leftS, int rightS, Canvas drawingCanvas, int ysped, int xsped)
    {
        xPosition = xPos;
        yPosition = yPos;
        color = ballColor;
        diameter = ballDiameter;
        groundPosition = groundPos;
        topPosition = groundPos2;
        leftSide = leftS;
        rightSide = rightS;
        canvas = drawingCanvas;
        ySpeed = ysped;
        xSpeed = xsped;
    }

    /**
     * Draw this ball at its current position onto the canvas.
     **/
    public void draw()
    {
        canvas.setForegroundColor(color);
        canvas.fillCircle(xPosition, yPosition, diameter);
    }

    /**
     * Erase this ball at its current position.
     **/
    public void erase()
    {
        canvas.eraseCircle(xPosition, yPosition, diameter);
    }

    /**
     * Move this ball according to its position and speed and redraw.
     **/
    public void move()
    {
        // remove from canvas at the current position
        erase();

        // compute new position
        yPosition += ySpeed;
        xPosition += xSpeed;

        // check if it has hit the ground
        if ( yPosition > groundPosition - diameter) {
            yPosition = groundPosition - diameter;
            ySpeed = -ySpeed;
        }
        if ( yPosition < topPosition) {
            yPosition = topPosition;
            ySpeed = -ySpeed;
        }
        if ( xPosition < leftSide ) {
            xPosition = leftSide;
            xSpeed = -xSpeed;
        }
        if (xPosition > rightSide - diameter){
            xPosition = rightSide - diameter;
            xSpeed = -xSpeed;
        }

        // draw again at new position
        draw();
    }

    /**
     * return the horizontal position of this ball
     */
    public int getXPosition()
    {
        return xPosition;
    }

    /**
     * return the vertical position of this ball
     */
    public int getYPosition()
    {
        return yPosition;
    }
}
