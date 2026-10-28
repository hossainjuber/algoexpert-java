package AlgoExpert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//https://www.algoexpert.io/questions/Calendar%20Matching

/*
 1. Write a function that takes in a calendar and returns all free time intervals.  The
 method should also take in the boudns and augment it in the beginnign and end.
 2. From calendarMatching calll that function and generate two list for the two calendars
 3. Iterate over the two list using pointers and generate a new list that compares each intervals
 from both list and takes in the later starting time and earlier end time from both in order
 to generate an interval.
*/

public class CalendarMatching {

   public static void main(String[] args) {



        //calendarMatching();

   }

    public static List<StringMeeting> calendarMatching(
            List<StringMeeting> calendar1,
            StringMeeting dailyBounds1,
            List<StringMeeting> calendar2,
            StringMeeting dailyBounds2,
            int meetingDuration
    ) {
        List<StringMeeting> availableTimeSlots = new ArrayList<>();
        List<StringMeeting> cal1Gaps = getGapTimes(calendar1, dailyBounds1);
        print(cal1Gaps);
        List<StringMeeting> cal2Gaps = getGapTimes(calendar2, dailyBounds2);
        print(cal2Gaps);

        for(int i=0; i<cal1Gaps.size(); i++){
            for(int j=0; j<cal2Gaps.size(); j++){
                StringMeeting sm1 = cal1Gaps.get(i);
                StringMeeting sm2 = cal2Gaps.get(j);

                if(getMins(sm1.start) <= getMins(sm2.start) && getMins(sm1.end) >= getMins(sm2.start)){
                    int startMins = Math.max(getMins(sm1.start), getMins(sm2.start));
                    int endMins = Math.min(getMins(sm1.end), getMins(sm2.end));
                    if(endMins - startMins <= meetingDuration){
                        availableTimeSlots.add(new StringMeeting(getTime(startMins), getTime(endMins)));
                    }
                }else if(getMins(sm1.start) >= getMins(sm2.start) && getMins(sm1.start) < getMins(sm2.end)){
                    int startMins = Math.max(getMins(sm1.start), getMins(sm2.start));
                    int endMins = Math.min(getMins(sm1.end), getMins(sm2.end));
                    if(endMins - startMins <= meetingDuration){
                        availableTimeSlots.add(new StringMeeting(getTime(startMins), getTime(endMins)));
                    }
                }

            }
        }

        return availableTimeSlots;
    }

    public static void print(List<StringMeeting> gapTimes){
        for(StringMeeting sm : gapTimes){
            System.out.println(sm.start +" - "+ sm.end);
        }
        System.out.println("______________");
    }

    public static List<StringMeeting> getGapTimes(List<StringMeeting> cal, StringMeeting bounds){
        List<StringMeeting> result = new ArrayList<>();
        //handle upper bound first
        if(getMins(bounds.start)<getMins(cal.get(0).start)){
            StringMeeting upperBoundGap = new StringMeeting(bounds.start,
                    cal.get(0).start);
            result.add(upperBoundGap);
        }
        for(int i=1; i<cal.size(); i++){
            StringMeeting prev = cal.get(i-1);
            StringMeeting curr = cal.get(i);
            if(getMins(prev.end) < getMins(curr.start)){
                StringMeeting sm = new StringMeeting(prev.end, curr.start);
                result.add(sm);
            }
        }
        if(getMins(bounds.end) > getMins(cal.get(0).end)){
            StringMeeting lowerBoundGap = new StringMeeting(cal.get(cal.size()-1).end, bounds.end);
            result.add(lowerBoundGap);
        }
        return result;
    }

    public static int getMins(String time){
        String[] array = time.split(":");
        int hour_part = Integer.valueOf(array[0]);
        int min_part = Integer.valueOf(array[1]);
        return (hour_part * 60) + min_part;
    }

    public static String getTime(int minutes){
        int hour = minutes / 60;
        int minutes2 = minutes % 60;

        return String.valueOf(hour)+":"+String.valueOf(minutes2==0?"00":minutes2);
    }

    static class StringMeeting {
        public String start;
        public String end;

        public StringMeeting(String start, String end) {
            this.start = start;
            this.end = end;
        }
    }
}
