package exercise_record;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.io.*;

class Exercise {
	String exercise = null;
	String duration = null;
	String set = null;

	public Exercise(String exercise, int set, int duration) {
		this.exercise = exercise;
		this.duration = String.valueOf(duration);
		this.set = String.valueOf(set);
	}

	public String get_exercise() {
		return "[ 운동 종류 : " + this.exercise + " , 세트 수 : " + this.set + " , 세트 당 시간 : " + this.duration + " ]";
	}

	public String toString() {
		String output = "[ 운동 종류 : " + this.exercise + " , 세트 수 : " + this.set + " , 세트 당 시간 : " + this.duration + " ]";
		return output;
	}
}

public class Main {
	public static boolean check(String a, String b) {
		return a == b;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean current = true;

		ArrayList<Exercise> exercise_list = new ArrayList<>();
		String exercise = null;
		String removing_exercise = null;
		int duration = 0;
		int set = 0;

		while (current) {
			System.out.println("=================메인 메뉴==================");
			System.out.println(" 1. 운동 추가하기  2. 운동 삭제하기  3. 운동 현황보기");
			System.out.println(" 4. 목록 전체삭제  5. 운동 정보수정  6. 운동 기록열람");
			System.out.println(" 7. 운동 목록 메모장으로 저장 0. 종료");
			System.out.println("==========================================");
			System.out.println("원하는 기능을 입력하세요 : ");
			try {
				int select = scan.nextInt();
				switch (select) {
				case 1:
					System.out.println("운동 종류를 입력하세요 : ");
					exercise = scan.next();
					System.out.println("운동한 세트 수를 입력하세요 : ");
					set = scan.nextInt();
					System.out.println("세트당 운동시간(분) 또는 횟수를 입력하세요 : ");
					duration = scan.nextInt();
					Exercise exercise_inform = new Exercise(exercise, set, duration);
					exercise_list.add(exercise_inform);
					System.out.println("기록 되었습니다");

					break;

				case 2:
					if (exercise_list.size() == 0) {
						System.out.println("현재 기록된 운동 정보가 없습니다");
						break;
					}
					System.out.println("삭제를 원하는 운동 종류를 입력하세요 : ");
					removing_exercise = scan.next();
					for (int i = 0; i < exercise_list.size(); i++) {
						if (exercise_list.get(i).exercise.equals(removing_exercise)) {
							exercise_list.remove(i);
							System.out.println("삭제되었습니다");

							break;
						} else {
							System.out.println("원하는 운동 정보를 찾을 수 없습니다");
						}
					}
					break;

				case 3:
					System.out.println("----------------------운동 현황----------------------");
					for (int i = 0; i < exercise_list.size(); i++) {
						System.out.println(exercise_list.get(i));
					}
					System.out.println("--------------------------------------------------");

					break;

				case 4:
					System.out.println("정말로 삭제하시겠습니까?");
					String check = scan.next();
					if (check.equals("y")) {
						exercise_list.clear();
						System.out.println("모든 정보가 삭제되었습니다");
					} else {
						System.out.println("삭제가 취소되었습니다");
					}

					break;

				case 5:
					System.out.println("변경할 운동을 입력하세요 : ");
					String change_exerciser = scan.next();
					System.out.println("세트 수 : ");
					String change_set = scan.next();
					System.out.println("세트 당 시간 : ");
					String change_duration = scan.next();

					for (int i = 0; i < exercise_list.size(); i++) {
						if (exercise_list.get(i).exercise.equals(change_exerciser)) {
							exercise_list.get(i).set = change_set;
							exercise_list.get(i).duration = change_duration;
							System.out.println("변경 되었습니다");
							System.out.println(exercise_list.get(i));

							break;
						} else {
							System.out.println("원하는 운동 정보를 찾을 수 없습니다");
						}
					}

					break;

				case 6:
					System.out.println("열람할 파일 이름을 입력하세요 : ");
					String read_file_name = scan.next();
					try {
						File file = new File(read_file_name + ".txt");
						FileReader filereader = new FileReader(file);
						BufferedReader bufReader = new BufferedReader(filereader);
						String line = "";
						System.out.println("파일 \"" + read_file_name + "\"을 성공적으로 읽어 왔습니다");
						while ((line = bufReader.readLine()) != null) {
							System.out.println(line);
						}
						bufReader.close();
					} catch (FileNotFoundException e) {
						System.out.println(e);
					} catch (IOException e) {
						System.out.println(e);
					}

					break;

				case 7:
					System.out.println("날짜를 입력하세요 : ");
					String file_name = scan.next();
					try {
						File file = new File(file_name + ".txt");
						FileWriter writer = new FileWriter(file);
						for (Exercise str : exercise_list) {
							String temp = str.get_exercise();
							writer.write(temp + System.lineSeparator());
						}
						writer.close();
					} catch (Exception e) {
						e.printStackTrace();
						System.out.println("No such file exists.");
					}
					System.out.println("텍스트 파일 \"" + file_name + "\"이 저장되었습니다");

					break;

				case 0:
					System.out.println("종료합니다");
					current = false;
					break;

				}
			} catch (InputMismatchException ime) {
				System.out.println("제대로 된 값을 입력해 주세요");
				scan = new Scanner(System.in);
			}
		}

	}

}
