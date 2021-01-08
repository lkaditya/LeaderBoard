package sg.edu.iss.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.edu.iss.test.model.Player;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
	
	@Query("Select p from Player p where p.name=:name")
	public Player findPlayerByName(@Param("name")String name);


}
