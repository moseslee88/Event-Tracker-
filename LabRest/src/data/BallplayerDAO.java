package data;

import java.util.List;

import entities.Ballplayer;

public interface BallplayerDAO {

	
	public List<Ballplayer> index();
	public Ballplayer show(int id);
	public Ballplayer create(Ballplayer player);
	public Ballplayer update(int id, Ballplayer player);
	public boolean destroy(int id);
}
