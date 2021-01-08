package sg.edu.iss.test.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.iss.test.model.Player;
import sg.edu.iss.test.repository.PlayerRepository;

@Service
public class PlayerServiceImplementation implements PlayerService {
	
	@Autowired
	PlayerRepository prepo;


	@Override
	public List<Player> findBest5Player() {
		List<Player>all= prepo.findAll();
		List<Player>Best5=all.stream().sorted(Comparator.comparing(Player::getTime)).limit(5).collect(Collectors.toList());
		return Best5;
	}


	@Override
	public void save(Player p) {
		Player e= prepo.findPlayerByName(p.getName());
		if(e!=null) {
			if(e.getTime()>p.getTime()) { //only replace the score if it is better than before
				e.setTime(p.getTime());
				prepo.save(e);
			}
		}else {
			prepo.save(p);
		}
			
	}
	

}
