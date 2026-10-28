package AlgoExpert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TournamentWinner3 {

   public static void main(String[] args){
		ArrayList<ArrayList<String>> tournament_list = new ArrayList<>();
		ArrayList<String> HTML_C = new ArrayList<>();
		HTML_C.add("HTML");
		HTML_C.add("Java");
		tournament_list.add(HTML_C);

		ArrayList<String> C_PYTHON = new ArrayList<>();
		C_PYTHON.add("Java");
		C_PYTHON.add("Python");
		tournament_list.add(C_PYTHON);

		ArrayList<String> PYTHON_HTML = new ArrayList<>();
	    PYTHON_HTML.add("Python");
	    PYTHON_HTML.add("HTML");
		tournament_list.add(PYTHON_HTML);

		ArrayList<Integer> score_list = new ArrayList<>();
		score_list.add(0);
		score_list.add(1);
		score_list.add(1);

		tournamentWinner(tournament_list, score_list);


	}

	public static String tournamentWinner(
			ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {

		Map<String, Integer> map = new HashMap<>();

		for(int i=0; i<competitions.size(); i++){
			String home_team = competitions.get(i).get(0);
			String away_team = competitions.get(i).get(1);
			int score = results.get(i);
			if(score==1){
				map.put(home_team, map.getOrDefault(home_team, 0)+3);
				map.put(away_team, map.getOrDefault(away_team, 0));

			} else if(score==0){
				map.put(away_team, map.getOrDefault(away_team, 0)+3);
				map.put(home_team, map.getOrDefault(home_team, 0));
			}
		}//for

		int score1=Integer.MIN_VALUE;
		int score2=0;
		String winner1 = "";
		String winner2 = "";
		int winner_score = Integer.MIN_VALUE;
		for (Map.Entry<String,Integer> entry : map.entrySet()){
			if(entry.getValue()>score1){
				score1 = entry.getValue();
				winner1 = entry.getKey();
			}else{

			}
		}

		return winner1;
	}


}//TournamentWinner2
