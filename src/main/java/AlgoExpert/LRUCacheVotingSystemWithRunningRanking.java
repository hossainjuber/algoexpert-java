package AlgoExpert;

import java.util.*;


/*
* write code in java for a system that takes in incoming votes for candidates,
* as new votes come it your system should always keep track of top 3 candidates
* in any given point in time
*
* Every time a votes comes in the following is happening:
* 1. map is updated
* 2. immediately we recreate the hep, by the way its a min heap
*       i. the if condition in the updateTopCandidates method ensures that only 3 condidates remain all the time
*       ii. when the 4th candidate comes in the else clause of updateTopCandidates method is execute, it basically
*           deletes the root (the min value) and adds the current value if the current value is > than min value
* 3. so the heap is kept up to date all the time
* 4. when getTop3Candidates method is called, all we have to do is take the heap and put it in a list and pass
* in a comparator to sort it and return that list.
* */


public class LRUCacheVotingSystemWithRunningRanking {
    private final Map<String, Integer> voteMap;
    private final PriorityQueue<Map.Entry<String, Integer>> topCandidatesPQ;

    public LRUCacheVotingSystemWithRunningRanking() {
        voteMap = new HashMap<>();

        // Min-heap based on vote count
        topCandidatesPQ = new PriorityQueue<>(Map.Entry.comparingByValue());
    }

    public void addVote(String candidate) {
        // Update vote count
        voteMap.put(candidate, voteMap.getOrDefault(candidate, 0) + 1);

        // Rebuild top 3 after every vote
        updateTopCandidates();
    }

    private void updateTopCandidates() {
        // Clear and rebuild top-3 heap
        topCandidatesPQ.clear();

        for (Map.Entry<String, Integer> entry : voteMap.entrySet()) {
            if (topCandidatesPQ.size() < 3) {
                topCandidatesPQ.offer(entry);
            } else if (entry.getValue() > Objects.requireNonNull(topCandidatesPQ.peek()).getValue()) {
                topCandidatesPQ.poll();
                topCandidatesPQ.offer(entry);
            }
        }
    }

    public List<String> getTop3Candidates() {
        List<Map.Entry<String, Integer>> list = new ArrayList<>(topCandidatesPQ);
        list.sort((a, b) -> b.getValue().compareTo(a.getValue())); // Sort descending

        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : list) {
            result.add(entry.getKey() + " (" + entry.getValue() + " votes)");
        }
        return result;
    }

    public static void main(String[] args) {
        LRUCacheVotingSystemWithRunningRanking votingSystem = new LRUCacheVotingSystemWithRunningRanking();

        String[] incomingVotes = {
                "Alice", "Bob", "Alice", "Charlie", "Bob", "David", "Charlie", "Alice", "Bob", "Charlie", "David", "David","jason","jason","jason","jason","Charlie","Charlie"
        };

        for (String vote : incomingVotes) {
            votingSystem.addVote(vote);
            System.out.println("Top 3 Candidates: " + votingSystem.getTop3Candidates());
        }
    }
}