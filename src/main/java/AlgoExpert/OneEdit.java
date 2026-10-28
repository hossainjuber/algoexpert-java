package AlgoExpert;

public class OneEdit {
    public static void main(String[] str){
        String stringOne = "ab";
        String stringTwo = "b";
        if(oneEdit(stringOne, stringTwo)){
            System.out.println("The two strings can be made equals with one edit");
        }else{
            System.out.println("Sorry, the two strings can not be made equals with one edit");
        }
    }
    public static boolean oneEdit(String stringOne, String stringTwo) {
        int lefthead = 0;
        int lefttail = stringOne.length()-1;
        int righthead = 0;
        int righttail = stringTwo.length()-1;
        if(Math.abs(lefttail-righttail)>1) return false;
        int matches = 0;
        while(lefthead<lefttail || righthead<righttail){
            if(stringOne.charAt(lefthead)==stringTwo.charAt(righthead)){
                matches++; lefthead++; righthead++;
            }else if(stringOne.charAt(lefttail)==stringTwo.charAt(righttail)){
                matches++; lefttail--; righttail--;
            }else{
                return false;
            }
        }//while
        return matches>=(Math.max(stringOne.length(), stringTwo.length())-1);
    }
}
