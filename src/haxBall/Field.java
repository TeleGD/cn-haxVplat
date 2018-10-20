package haxBall;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

public class Field {
	private int height;
	private int width;
	private int pos_x;
	private int pos_y;
	private Color color;
	private Player player0;
	private Player player1;
	
	public Field(int world_height , int world_width){
		// normalement ca marche (pas)...
		this.height = (int)(0.6 * world_height);
		this.width = (int)(0.6 * world_width);
		this.pos_x = (int)(0.2 * world_width);
		this.pos_y = (int)(0.2 * world_height);
		
		// creation des joueurs ...
		player0 = new Player(this.height,this.width, 0);
		player1 = new Player(this.height,this.width, 1);
	}
	
	public void setColor(Color c) {
		this.color = c;
		
	}
	
	public void update (GameContainer container, StateBasedGame game, int delta) {
		/* Méthode exécutée environ 60 fois par seconde */
	}
	
	public void render (GameContainer container, StateBasedGame game, Graphics context) {
		/* Méthode exécutée environ 60 fois par seconde on espère !  */
		context.setColor(new Color(200,10,10));
		context.fillRect(this.pos_x,this.pos_y,this.width,this.height);
		player0.render(container, game, context);
		player1.render(container, game, context);
	}
}
