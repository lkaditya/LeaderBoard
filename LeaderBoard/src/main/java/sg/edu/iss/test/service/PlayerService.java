package sg.edu.iss.test.service;

import java.util.List;

import sg.edu.iss.test.model.Player;

public interface PlayerService {
	
	public List<Player> findBest5Player();
	
	public void save(Player p);
	

}
