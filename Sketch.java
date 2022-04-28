import processing.core.PApplet;
import processing.core.PImage;

/** 
 * Description: ant running around in grass and a yellow circle moving in a circular motion
 * @author Wang J.
 * 
 */

public class Sketch extends PApplet {
	
	PImage imgBackground;
  PImage imgAnt;

  public void settings() {
	// put your size call here
    size(700, 700);
  }

    // declare variables
    float fltX = 100;
    float fltY = 575;
    float fltXSpeed = 5;
    float fltYSpeed = 4;
  
    float fltAntX = 350;
    float fltAntY = 45;
    float fltAntXSpeed = 4;
    float fltAntYSpeed = 4;

    float fltCircle;
    float fltRadius = 275;

  public void setup() {
    // load images from files 
    imgBackground = loadImage("grass.jpeg");
    imgBackground.resize(1000,1000);
    imgAnt = loadImage("ant.png");
    imgAnt.resize(50, 100);
  }

  public void draw() {

    // declare background and relocate it
    image(imgBackground, 0, -100);

    // animate ant   
    fltAntX += fltAntXSpeed;
    fltAntY += fltAntYSpeed;

    // set boundries 
    if (fltAntX <= 0 || fltAntX > 625) {
      fltAntXSpeed *= -1;
    }

    if (fltAntY <= 0 || fltAntY > 625) {
      fltAntYSpeed *= -1;
    }


    // draw the circle and animate it
    fill(165,42,42); 
    ellipse(fltX, fltY, 50, 50);
    
    fltCircle += (Math.PI / 100);
    fltX = (float) (300 + Math.sin(fltCircle) * fltRadius);
    fltY = (float) (300 + Math.cos(fltCircle) * fltRadius);


    image(imgAnt, fltAntX, fltAntY);
    }
  }
