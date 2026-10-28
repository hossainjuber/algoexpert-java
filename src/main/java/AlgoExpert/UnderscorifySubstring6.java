package AlgoExpert;

import java.util.ArrayList;
import java.util.List;

//https://www.algoexpert.io/questions/Underscorify%20Substring
public class UnderscorifySubstring6 {

    public static void main(String[] str){
        String s1 = "testest bla blah";
        //String s1 = "testbesttest testthis is a testtest to see if testestest it works";
        // testthis is a testtest to see if testestest it works"

        //String s1 = "testestest testtest is a testtest to see if testestest it works";
        String s2 = "test";
        //_test_this is a _testtest_ to see if _testestest_ it works_
        underscorifySubstring(s1, s2);
    }

    public static String underscorify(String str, List<int[]> locations) {
        StringBuffer sb = new StringBuffer();
        //this has to be done like stitching at two different speeds
        

        return sb.toString();
    }

    public static String underscorify2(String str, List<int[]> locations) {
        int locationIdx = 0;
        int stringIdx = 0;
        boolean inBetweenUnderscores = false;
        StringBuilder result = new StringBuilder();

        while (stringIdx < str.length() && locationIdx < locations.size()) {
            if (stringIdx == locations.get(locationIdx)[inBetweenUnderscores ? 1 : 0]) {
                result.append("_");
                inBetweenUnderscores = !inBetweenUnderscores;

                if (!inBetweenUnderscores) {
                    locationIdx++;
                }
            }

            result.append(str.charAt(stringIdx));
            stringIdx++;
        }

        if (locationIdx < locations.size()) {
            result.append("_");
        }

        while (stringIdx < str.length()) {
            result.append(str.charAt(stringIdx));
            stringIdx++;
        }

        return result.toString();
    }


    public static String underscorifySubstring(String str, String substring) {
        List<int[]> locations = getLocations(str, substring);
        List<int[]> collapsedLocations = collapse(locations);

        return underscorify(str, collapsedLocations);
    }

    public static List<int[]> collapse(List<int[]> locations) {
        if (locations.size() == 0) return locations;

        List<int[]> collapsed = new ArrayList<>();
        int[] previous = locations.get(0);
        collapsed.add(previous);

        for (int i = 1; i < locations.size(); i++) {
            int[] current = locations.get(i);

            if (current[0] <= previous[1]) {
                previous[1] = current[1];
            } else {
                collapsed.add(current);
                previous = current;
            }
        }

        return collapsed;
    }

    public static List<int[]> getLocations(String str, String substring) {
        List<int[]> locations = new ArrayList<>();
        int startIdx = 0;

        while (startIdx < str.length()) {
            int nextIdx = str.indexOf(substring, startIdx);

            if (nextIdx != -1) {
                locations.add(new int[] {nextIdx, nextIdx + substring.length()});
                startIdx = nextIdx + 1; // allows overlapping matches
            } else {
                break;
            }
        }

        return locations;
    }



}
