package haxBall;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

import haxBall.bonus.*;

public class Field {
	private int height;
	private int width;
	private int pos_x;
	private int pos_y;
	private Color color;
	private Player player0;
	private Player player1;
	private Ball ball;
	private int world_height;
	private int world_width;
	
	public Field(int world_height , int world_width){
		// normalement ca marche (pas)...
		this.height = (int)(0.7 * world_height);
		this.width = (int)(0.7 * world_width);
		this.pos_x = (int)(0.15 * world_width);
		this.pos_y = (int)(0.15 * world_height);
		this.color = new Color(102, 148, 68);
		this.world_width = world_width;
		this.world_height = world_height; 
		
		
		// creation des joueurs ...
		player0 = new Player(this.height,this.width,this.pos_x , this.pos_y, 0);
		player1 = new Player(this.height,this.width,this.pos_x , this.pos_y, 1);
		ball = new Ball(this.height,this.width,this.pos_x,this.pos_y);
	}
	
	public void setColor(Color c) {
		this.color = c;
		
	}
	
	public Color getColor() {
		return color;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getPosX() {
		return pos_x;
	}
	
	public int getPosY() {
		return pos_y;
	}
	
	public void update (GameContainer container, StateBasedGame game, int delta) {
		/* Méthode exécutée environ 60 fois par seconde */
		player0.update(container, game, delta);
		player1.update(container, game, delta);
		ball.update(container, game, delta);
	}
	
	public void render (GameContainer container, StateBasedGame game, Graphics context) {
		/* Méthode exécutée environ 60 fois par seconde on espère !  */

		context.setColor(new Color(102, 111, 69));
		context.setColor(new Color(102, 111, 69));
		context.fillRect(0, 0, this.world_width, this.world_height);
		context.setColor(new Color(102, 148, 68));
		context.fillRect(this.pos_x,this.pos_y,this.width,this.height);

		context.setColor(new Color(155, 177, 181));// Buts
		context.fillRect(this.pos_x - this.width/16 , this.pos_y+ this.height / 3, this.width / 16, this.height / 3);// but 1
		context.fillRect(this.pos_x + this.width  , this.pos_y + this.height / 3, this.width / 16, this.height / 3); // but 2

		context.setColor(new Color(243, 241, 255)); // traits inutiles
		context.drawRect(this.pos_x ,  this.pos_y+ this.height/4,  this.width / 8, this.height / 2); // zone 1
		context.drawRect(this.pos_x +  7 *this.width /8 ,  this.pos_y+ this.height/4,  this.width / 8, this.height / 2); // zone 2
		context.drawLine(this.pos_x + this.width/2, this.pos_y, this.pos_x + this.width/2, this.pos_y + this.height); // ligne milieu
		context.drawRect(this.pos_x, this.pos_y, this.width, this.height); // touche
		context.drawOval(this.pos_x + this.width/2 - this.height/8 , this.pos_y + this.height/2 - this.height/8, height/4, height/4); // cercle

		player0.render(container, game, context);
		player1.render(container, game, context);
		ball.render(container, game, context);}
	
	public void keyPressed(int key, char c) {
		player0.keyPressed(key,c);
		player1.keyPressed(key,c);
		ball.keyPressed(key,c);
	}
	
	public void keyReleased(int key, char c) {
		player0.keyReleased(key,c);
		player1.keyReleased(key,c);
		ball.keyReleased(key,c);
	}
}
