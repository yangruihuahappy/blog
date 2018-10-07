package game_life_self;

import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

public class Init_dataTest {
	 static Init_data data;
	 static boolean[][] state;
  
	@Before
	public void setUp() throws Exception {
		
	}
	
	@Test
	public void testInit_data() {
		
		data = new Init_data(state);
	}

	@Test
	public void testRandom_init() {
		Scanner input=new Scanner(System.in);
		 System.out.print(" ‰»Î≥§∫ÕøÌ");
		int row=input.nextInt();
		int column=input.nextInt();
		state = new boolean[row][column];
		 testInit_data();
		 data.random_init();
		 
		 for(int i=1;i<state.length;i++)
	        {
	            for(int j=1;j<state[i].length-1;j++)
	            {   
		        System.out.print(state[i][j]+"\t");
	            }
	            System.out.print("\n");
	        }
	}

}

