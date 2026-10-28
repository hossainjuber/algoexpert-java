package AlgoExpert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TournamentWinner {

   public static void main(String[] args){
		ArrayList<ArrayList<String>> tournament_list = new ArrayList<>();
		ArrayList<String> HTML_C = new ArrayList<>();
		HTML_C.add("HTML");
		HTML_C.add("C#");
		tournament_list.add(HTML_C);

		ArrayList<String> C_PYTHON = new ArrayList<>();
		C_PYTHON.add("C");
		C_PYTHON.add("PYTHON");
		tournament_list.add(C_PYTHON);

		ArrayList<String> PYTHON_HTML = new ArrayList<>();
	    PYTHON_HTML.add("PYTHON");
	    PYTHON_HTML.add("HTML");
		tournament_list.add(PYTHON_HTML);

		ArrayList<Integer> score_list = new ArrayList<>();
		score_list.add(0);
		score_list.add(0);
		score_list.add(1);


   }

    	public Map<String, Integer> updateMap(Map<String, Integer> scoreMap, String key){
		Map<String, Integer> score_map = scoreMap;
		if(score_map.containsKey(key)){
			int previous_score = score_map.get(key);
			score_map.put(key, previous_score+3);
		}else{
			score_map.put(key, 3);
		}
		return score_map;
	}

  public String tournamentWinner(
          ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {

		Map<String, Integer> score_map = new HashMap<>();
		String key="";
		int score = 3;
		int winner = 0;
		String homeTeam = "";
		String awayTeam = "";
		String bestTeam = "";
		int bestTeamScore = Integer.MIN_VALUE;
		String currentWinner = "";
		int currentWinnerScore = 0;
		for(int i=0; i<competitions.size(); i++){
			//1==home team wone, 0==away team won
			winner = results.get(i);
			key = competitions.get(i).get(1);
			homeTeam = competitions.get(i).get(0);
			awayTeam = competitions.get(i).get(1);

			if(winner==1){
				//home team won
				score_map = updateMap(score_map, homeTeam);
				currentWinner = homeTeam;
			}else{
				//away team won
				score_map = updateMap(score_map, awayTeam);
				currentWinner = awayTeam;
			}
			currentWinnerScore = score_map.get(currentWinner);
			if(currentWinnerScore>bestTeamScore){
				bestTeam = currentWinner;
				bestTeamScore = currentWinnerScore;
			}
		}

		if(bestTeamScore>currentWinnerScore){
			return bestTeam;
		}else{
			return currentWinner;
		}

  }


}
