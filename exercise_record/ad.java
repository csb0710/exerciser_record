package exercise_record;

import java.util.ArrayList;
import java.util.List;

class Exercise2 {
    String exercise = null;
    String duration = null;
    String set = null;
    
    public Exercise2(String exercise, int set, int duration) {
        this.exercise = exercise;
        this.duration = String.valueOf(duration);
        this.set = String.valueOf(set);
    }
    
    public String toString() {
        String output = "[ � ���� : " + this.exercise + " , ��Ʈ �� : " + this.set + " , ��Ʈ �� �ð� : " + this.duration + " ]";
        return output;
    }
}
public class ad {

	public static void main(String[] args) {
		Exercise2 exercise_inform = new Exercise2("running", 3, 10);
	      List<Exercise2> exercise_list = new ArrayList<>();
	      exercise_list.add(exercise_inform);
	      if(exercise_list.get(0).exercise == "running") {
	    	  System.out.println(exercise_list.get(0).exercise);
	        System.out.print("shit");

	}
	}

}

