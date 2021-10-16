package aggregation.team;

import java.util.ArrayList;
import java.util.List;

public class Team { 
    
    public Team () { 
        this.players = new ArrayList<>();  
    }     
    
    public void addPlayer(Player p) throws PlayerDuplicateException {  
        if (players.contains(p))
            throw new PlayerDuplicateException();
        players.add(p);   
    }
    
     public void removePlayer(Player p) throws PlayerDoesNotExistException {   
         if (!players.contains(p))
             throw new PlayerDoesNotExistException();
         players.remove(p);   
    } 
     
    @Override
    public String toString() {
        return "Team [\n\tplayers=" + players + "\n]";
    }
    
     private List<Player> players; 
} 


