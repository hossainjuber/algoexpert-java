package AlgoExpert;
import java.util.*;

public class CollidingAstorids {

    public static void main(String[] str){
        int[] array = {1, 2, 3, -4};
		int[] value = collidingAsteroids(array);
    }

	public static int[] collidingAsteroids(int[] asteroids) {
		Stack<Integer> stack = new Stack<>();
		for(int asteroid : asteroids){
			stack.push(asteroid);
			collide(stack);
		}

		return stack.stream().mapToInt(value -> value).toArray();
	}

	public static void collide(Stack<Integer> stack){
		if(stack.isEmpty() || stack.size()<2){
			return;
		}

		int top = stack.pop();
		int secondTop = stack.pop();
		if(top<0 && secondTop>0 && Math.abs(top)==Math.abs(secondTop) && stack.isEmpty()){
			return;
		} else if(top<0 && secondTop>0){
			if(Math.abs(top) > Math.abs(secondTop)){
				stack.push(top);
			}else if(Math.abs(top) < Math.abs(secondTop)){
				stack.push(secondTop);
			}
			collide(stack);
		} else{
			stack.push(secondTop);
			stack.push(top);
		}

	}
}
