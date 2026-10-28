package AlgoExpert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TournamentWinner2 {

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

  public static String tournamentWinner(ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
	Map<String, Integer> map = new HashMap<>();
	int home_current_score = 0;
	int away_current_score = 0;
	String winner = "";
	for(int i=0; i<competitions.size(); i++){
			ArrayList<String> homeTeam_awayTeam = competitions.get(i);
			String homeTeam = homeTeam_awayTeam.get(0);
			String awayTeam = homeTeam_awayTeam.get(1);
			home_current_score = results.get(i);
			away_current_score = home_current_score==1 ? 0:1;

			if(!map.containsKey(homeTeam)){
				map.put(homeTeam, results.get(i)==1?1:0);
			}else{
				map.put(homeTeam, map.get(homeTeam) + home_current_score);
			}

			if(!map.containsKey(awayTeam)){
				map.put(awayTeam, results.get(i)==1?0:1);
			}else{
				map.put(awayTeam, map.get(awayTeam) + away_current_score);
			}

			if(map.get(homeTeam)>map.get(awayTeam)){
				winner = homeTeam;
			}else{
				winner = awayTeam;
			}
	}//for
	return winner;
  }//tournamentWinner


}//TournamentWinner2
