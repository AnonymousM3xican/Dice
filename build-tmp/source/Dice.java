import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Dice extends PApplet {

public void setup()
{
	noLoop();
	size(500,600);
}
public void draw()
{
	background(250,250,250);
	int count=0;
	for(int y = 0;y<=500;y+=50)
	{
		for(int x = 0;x<=500;x+=50)	
		{
		Die joe = new Die(x,y);
		joe.roll();
		count+=joe.numDot;
		
		joe.show();
		}
	}	
	fill(250,0,0);
	text("Total Number of Rolls: " + count,180,580);
	


}

public void mousePressed()
{
	redraw();
}
class Die //models one single dice cube
{
 	int myX;
 	int myY;
 	int numDot;
	Die(int x, int y) //constructor
	{
		myX=x;
		myY=y;
		numDot=0;
	}
	public void roll()
	{
		numDot=(int)(Math.random()*6)+1;
	}
	public void show()
	{
		stroke(0,0,0);
		fill(250,250,250);
		rect(myX,myY,30,30);
		if(numDot==1)
		{
		ellipse(myX+15,myY+15,5,5);
		}
		if(numDot==2)
		{
		ellipse(myX+5,myY+5,5,5);
		ellipse(myX+25,myY+25,5,5);
		}
		if(numDot==3)
		{
		ellipse(myX+5,myY+5,5,5);
		ellipse(myX+15,myY+15,5,5);
		ellipse(myX+25,myY+25,5,5);
		}
		if(numDot==4)
		{
		ellipse(myX+5,myY+5,5,5);
		ellipse(myX+5,myY+25,5,5);
		ellipse(myX+25,myY+5,5,5);
		ellipse(myX+25,myY+25,5,5);
		}
		if(numDot==5)
		{
		ellipse(myX+5,myY+5,5,5);
		ellipse(myX+5,myY+25,5,5);
		ellipse(myX+25,myY+5,5,5);
		ellipse(myX+25,myY+25,5,5);
		ellipse(myX+15,myY+15,5,5);
		}
		if(numDot==6)
		{
		ellipse(myX+5,myY+5,5,5);
		ellipse(myX+5,myY+25,5,5);
		ellipse(myX+25,myY+5,5,5);
		ellipse(myX+25,myY+25,5,5);
		ellipse(myX+5,myY+15,5,5);
		ellipse(myX+25,myY+15,5,5);
		}
	}
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Dice" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
