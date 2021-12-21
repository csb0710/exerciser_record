package exercise_record;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class exercise_Swing extends JFrame {
	Exit_Button EB = new Exit_Button();
	Close_Button CB = new Close_Button();
	JTextArea ta = new JTextArea(7, 20); 
	//Exerciser_add Ea = new Exerciser_add();
	
	public exercise_Swing() {
		super("운동 기록");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container Main_Container = getContentPane();
		Main_Container.setLayout(null);
		JButton exerciser_button = new JButton("운동 입력");
		exerciser_button.setBounds(110, 200, 180, 130);
		
		JButton file_button = new JButton("파일 처리");
		file_button.setBounds(400, 200, 180, 130);
		
		JButton close_button = new JButton("종료");
		close_button.setBounds(690, 200, 180, 130);
		close_button.addActionListener(CB);
		Main_Container.add(exerciser_button);
		Main_Container.add(file_button);
		Main_Container.add(close_button);
		
		Exerciser_Button EB = new Exerciser_Button();
		File_Button FB = new File_Button();
		
		exerciser_button.addActionListener(EB);
		file_button.addActionListener(FB);
		
		setSize(980, 600);
		setVisible(true);
	}
	
	class input_exerciser extends JFrame {
		public input_exerciser() {
			Container exerciser_container = getContentPane();
			exerciser_container.setLayout(null);
			Exerciser_add Ea = new Exerciser_add();
			Ea.setLocation(0, 200);
			exerciser_container.add(Ea);
			JButton back_button = new JButton("back");
			JButton insert = new JButton("운동 입력");
			back_button.setBounds(0, 0, 70, 30);
			back_button.addActionListener(EB);
			insert_Action iA = new insert_Action();
			insert.addActionListener(iA);
			insert.setBounds(40, 40, 140, 70);
			exerciser_container.add(back_button);
			exerciser_container.add(insert);
			
			setSize(980, 600);
			setVisible(true);
		}
	}
	
	class file_management extends JFrame {
		public file_management() {
			Container file_container = getContentPane();
			file_container.setLayout(null);
			JButton back_button = new JButton("back");
			back_button.setBounds(0, 0, 70, 30);
			back_button.addActionListener(EB);
			file_container.add(back_button);
			setSize(980, 600);
			setVisible(true);
		}
	}
	
	class Exerciser_Button implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			new input_exerciser();
            setVisible(false);
		}
	}
	
	class File_Button implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			new file_management();
            setVisible(false);
		}
	}
	
	class Exit_Button implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			new exercise_Swing();
            setVisible(false);
            ta.setText("");
		}
	}
	
	class Close_Button implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
	
	class insert_Action implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//Ea.setVisible(true);
		}
	}
	
	class Exerciser_add extends JPanel {
		public Exerciser_add() {
			setLayout(null);
			JTextField tf = new JTextField(20);
			tf.setBounds(40, 40, 450, 60);
			ta.setBounds(40, 140, 900, 220);
			
			setSize(980, 400);
			setVisible(true);
		}
	}
	
	class TextField_Input implements ActionListener	{
		public void actionPerformed(ActionEvent e) {
			JTextField t = (JTextField)e.getSource();
			ta.append(t.getText() + "\n"); 
			t.setText("");
		}
	}
	
	public static void main(String[] args) {
		new exercise_Swing();
	}

}
