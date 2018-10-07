package game_life_self;

import java.util.Scanner;

import javax.swing.JPanel;

import org.junit.Before;
import org.junit.Test;

public class judge_stateTest {
	 static Init_data data;
	 static boolean[][] state;
	 static judge_state judge;
	  JPanel[][] jPanel;
   
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testJudge_state() {
		judge = new judge_state(state, jPanel);
	}

	public void show(){
		
		for(int i=1;i<state.length;i++)
        {
            for(int j=1;j<state[i].length-1;j++)
            {   
	        System.out.print(state[i][j]+"\t");
            }
            System.out.print("\n");
        }
		  System.out.print("\n\n\n");
		 
	}
	@Test
	public void testJudge() {
		 set_frame frame;
		 Scanner input=new Scanner(System.in);
		 System.out.print("���볤�Ϳ�");
		int row=input.nextInt();
		int column=input.nextInt();
		state = new boolean[row][column];
		 frame = new set_frame(row,column);
	      jPanel = frame.jPanel;
		data = new Init_data(state);
		data.random_init();
		System.out.print("�����\n");
		show();
		testJudge_state();
		System.out.print("���뷱�ܴ���:");
		System.out.print("\n");
		int number=input.nextInt();
		for(int n=1;n<=number;n++){
		 System.out.print("��"+n+"��\n");
		judge.judge();
		show();
		}
	}

}
