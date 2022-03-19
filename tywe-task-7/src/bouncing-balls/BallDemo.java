import java.awt.Color;
import java.util.*;
import java.awt.geom.*;
import java.awt.Dimension;
import java.util.Random;
import javax.swing.*;

import static java.awt.Color.*;

/**
 * Class BallDemo - a short demonstration showing animation with the
 * Canvas class.
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */

public class BallDemo
{
    private Canvas myCanvas;
    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
    }

    /**
     * Simulate two bouncing balls
     */


    public void bounce(int createdBalls)
    {
        int ground = 400;   // position of the ground line

        myCanvas.setVisible(true);

        Random random = new Random();

        // draw the ground
        myCanvas.setForegroundColor(BLACK);
        myCanvas.drawLine(50, ground, 550, ground);

        // create and show the balls
        HashSet<BouncingBall> ballSet = new HashSet<BouncingBall>();
        for (int i = 0; i < createdBalls; i++) {
          Dimension canvasSize = myCanvas.getSize();
          int x = random.nextInt((int)canvasSize.getWidth());
          int y = random.nextInt(150);
          BouncingBall ball = new BouncingBall(x, y, 16, Color.BLUE, ground, myCanvas);
          ballSet.add(ball);
          ball.draw();
        }

        /*
        BouncingBall ball2 = new BouncingBall(70, 80, 20, Color.RED, ground, myCanvas);
        ball2.draw();
        */

        // make them bounce
        boolean finished =  false;
        while (!finished) {
            myCanvas.wait(50);           // small delay
            for (BouncingBall ball : ballSet) {
                ball.move();
                // stop once ball has travelled a certain distance on x axis
                if(ball.getXPosition() >= 550) {
                finished = true;
            }


            }
        }
    }

    public void boxBounce(int bollNumber)
    {
        myCanvas.setVisible(true);
        myCanvas.setForegroundColor(BLACK);
        myCanvas.drawLine(50,50,500,50);
        myCanvas.drawLine(500,50,500,400);
        myCanvas.drawLine(500,400,50,400);
        myCanvas.drawLine(50,400,50,50);

        Random random = new Random();
        ArrayList<Color> colors = new ArrayList<>();
        colors.add(BLACK);
        colors.add(BLUE);
        colors.add(RED);
        colors.add(GRAY);
        colors.add(GREEN);
        colors.add(MAGENTA);
        colors.add(ORANGE);
        colors.add(PINK);

        BoxBall[] balls = new BoxBall[bollNumber];
        for( int i = 0; i < bollNumber; i++) {
          balls[i] = new BoxBall(random.nextInt(300), random.nextInt(300), 20, colors.get(random.nextInt(colors.size())) , 400, 50,
                  50, 500, myCanvas, random.nextInt(50), random.nextInt(50));
        }

        boolean finished =  false;
        while (!finished) {
          myCanvas.wait(50);           // small delay
          for(int i = 0; i < balls.length; i++){
              balls[i].draw();
              balls[i].move();

              if(balls[i].getYPosition() == 0){
              finished = true;
                 }
            }
        }

    }
}

