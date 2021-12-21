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
		return "[ � ���� : " + this.exercise + " , ��Ʈ �� : " + this.set + " , ��Ʈ �� �ð� : " + this.duration + " ]";
	}

	public String toString() {
		String output = "[ � ���� : " + this.exercise + " , ��Ʈ �� : " + this.set + " , ��Ʈ �� �ð� : " + this.duration + " ]";
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
			System.out.println("=================���� �޴�==================");
			System.out.println(" 1. � �߰��ϱ�  2. � �����ϱ�  3. � ��Ȳ����");
			System.out.println(" 4. ��� ��ü����  5. � ��������  6. � ��Ͽ���");
			System.out.println(" 7. � ��� �޸������� ���� 0. ����");
			System.out.println("==========================================");
			System.out.println("���ϴ� ����� �Է��ϼ��� : ");
			try {
				int select = scan.nextInt();
				switch (select) {
				case 1:
					System.out.println("� ������ �Է��ϼ��� : ");
					exercise = scan.next();
					System.out.println("��� ��Ʈ ���� �Է��ϼ��� : ");
					set = scan.nextInt();
					System.out.println("��Ʈ�� ��ð�(��) �Ǵ� Ƚ���� �Է��ϼ��� : ");
					duration = scan.nextInt();
					Exercise exercise_inform = new Exercise(exercise, set, duration);
					exercise_list.add(exercise_inform);
					System.out.println("��� �Ǿ����ϴ�");

					break;

				case 2:
					if (exercise_list.size() == 0) {
						System.out.println("���� ��ϵ� � ������ �����ϴ�");
						break;
					}
					System.out.println("������ ���ϴ� � ������ �Է��ϼ��� : ");
					removing_exercise = scan.next();
					for (int i = 0; i < exercise_list.size(); i++) {
						if (exercise_list.get(i).exercise.equals(removing_exercise)) {
							exercise_list.remove(i);
							System.out.println("�����Ǿ����ϴ�");

							break;
						} else {
							System.out.println("���ϴ� � ������ ã�� �� �����ϴ�");
						}
					}
					break;

				case 3:
					System.out.println("----------------------� ��Ȳ----------------------");
					for (int i = 0; i < exercise_list.size(); i++) {
						System.out.println(exercise_list.get(i));
					}
					System.out.println("--------------------------------------------------");

					break;

				case 4:
					System.out.println("������ �����Ͻðڽ��ϱ�?");
					String check = scan.next();
					if (check.equals("y")) {
						exercise_list.clear();
						System.out.println("��� ������ �����Ǿ����ϴ�");
					} else {
						System.out.println("������ ��ҵǾ����ϴ�");
					}

					break;

				case 5:
					System.out.println("������ ��� �Է��ϼ��� : ");
					String change_exerciser = scan.next();
					System.out.println("��Ʈ �� : ");
					String change_set = scan.next();
					System.out.println("��Ʈ �� �ð� : ");
					String change_duration = scan.next();

					for (int i = 0; i < exercise_list.size(); i++) {
						if (exercise_list.get(i).exercise.equals(change_exerciser)) {
							exercise_list.get(i).set = change_set;
							exercise_list.get(i).duration = change_duration;
							System.out.println("���� �Ǿ����ϴ�");
							System.out.println(exercise_list.get(i));

							break;
						} else {
							System.out.println("���ϴ� � ������ ã�� �� �����ϴ�");
						}
					}

					break;

				case 6:
					System.out.println("������ ���� �̸��� �Է��ϼ��� : ");
					String read_file_name = scan.next();
					try {
						File file = new File(read_file_name + ".txt");
						FileReader filereader = new FileReader(file);
						BufferedReader bufReader = new BufferedReader(filereader);
						String line = "";
						System.out.println("���� \"" + read_file_name + "\"�� ���������� �о� �Խ��ϴ�");
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
					System.out.println("��¥�� �Է��ϼ��� : ");
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
					System.out.println("�ؽ�Ʈ ���� \"" + file_name + "\"�� ����Ǿ����ϴ�");

					break;

				case 0:
					System.out.println("�����մϴ�");
					current = false;
					break;

				}
			} catch (InputMismatchException ime) {
				System.out.println("����� �� ���� �Է��� �ּ���");
				scan = new Scanner(System.in);
			}
		}

	}

}
