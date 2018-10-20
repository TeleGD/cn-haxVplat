package haxBall;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

public class Player {
	private int m_posX;
	private int m_posY;
	private int m_id;
	private Color m_color;
	private int m_radius;

	public Player(int fieldHeight, int fieldWidth, int id) {
		m_id = id;
		m_radius = fieldHeight/15;
		m_posY = fieldHeight/2;
		
		if(m_id == 0) {
			m_posX = fieldWidth/4;
			m_color = new Color(0, 0, 255);
		}
		else {
			m_posX = (3*fieldWidth)/4;
			m_color = new Color(255, 0, 0);
		}
	}
	
	public int getPosX() {
		return m_posX;
	}
	
	public int getPosY() {
		return m_posY;
	}
	
	public int getHeight() {
		return m_height;
	}
	
	public int getWidth() {
		return m_width;
	}
	
	public void render (GameContainer container, StateBasedGame game, Graphics context) {
		context.setColor(color);
		context.fillOval(posX, posY, radius, radius);
	}

}