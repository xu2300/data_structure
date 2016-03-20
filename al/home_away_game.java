

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class home_away_game {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public Map<String, Game> findBestWins(List<Game> games){
		Map<String, Game> map = new HashMap<String, Game>();
		for(Game game : games){
			int score = game.homeScore-game.awayScore;
			if(score >0){
				String teamname = game.homeTeam;
				if(map.containsKey(teamname)){ 
					Game pregame = map.get(teamname);
					int prescore = Math.abs(pregame.homeScore - pregame.awayScore );
					if(score > prescore) map.put(teamname, game);
				}	
				else map.put(teamname, game);
			}
			else if(score < 0){
				String teamname = game.awayTeam;
				if(map.containsKey(teamname)){ 
					Game pregame = map.get(teamname);
					int prescore = Math.abs(pregame.homeScore - pregame.awayScore );
					if(score > prescore) map.put(teamname, game);
				}
				else map.put(teamname, game);
			}
		}
		return map;
	}

	public Map<String, List<Game>> findBestNWins(List<Game> games, int n){
		Map<String, List<Game>> re = new HashMap<String, List<Game>>();
		Map<String, PriorityQueue<Game>> map = new HashMap<String, PriorityQueue<Game>>();
		String teamname;
		for(Game game : games){
			int score = game.homeScore-game.awayScore;
			if(score >0){
				teamname = game.homeTeam;
			}
			else teamname = game.awayTeam;
			
			if(map.containsKey(teamname)){ 
				map.get(teamname).add(game);
				if(map.get(teamname).size()>n){
				PriorityQueue<Game> p = map.get(teamname);
						p.remove(p.size()-1);
					}
				}	
			else{
					PriorityQueue<Game> pq = new PriorityQueue<Game>(n+1, new Comparator<Game>(){
						public int compare(Game g1, Game g2){
							return Math.abs(g1.awayScore-g1.homeScore) -Math.abs(g1.awayScore-g1.homeScore);
						}
					});
					pq.offer(game);
					map.put(teamname, pq);
			}
			

		}
		return re;
	}
	

}

class Game {
    String homeTeam;
    String awayTeam;
    int homeScore;
    int awayScore;
}
