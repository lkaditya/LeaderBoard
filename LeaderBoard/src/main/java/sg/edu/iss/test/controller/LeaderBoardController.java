package sg.edu.iss.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sg.edu.iss.test.model.Player;
import sg.edu.iss.test.service.PlayerService;

@CrossOrigin
@RestController
@RequestMapping(path="/api/leaderboard")
public class LeaderBoardController {

	@Autowired
	private PlayerService PService;
	
	@RequestMapping("/player")
	public ResponseEntity<Player>savePlayer(@RequestParam("name")String name,@RequestParam("min")int min,@RequestParam("sec")int sec){
		int time=min*60+sec;
		Player p= new Player(name,time); 
		PService.save(p);
		return new ResponseEntity<> (p,HttpStatus.CREATED);
	}
	
	@RequestMapping("/top")
		public List<Player> getTop5(){
			return PService.findBest5Player();
		}
	
}
