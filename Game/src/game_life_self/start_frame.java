package game_life_self;

import javax.swing.JPanel;

public class start_frame extends Thread{
    static start_frame start;
    static Init_data init_data;
    static judge_state judge;
    static set_color set_color;
    static set_frame frame;
    //���ϸ��״̬
    static boolean[][] state_one;
    static JPanel[][] jPanel;
    //��ʼ��GUI����
    public start_frame(int row,int col)
    {
        state_one = new boolean[row][col];
        frame = new set_frame(row,col);
        jPanel = frame.jPanel;
    }

    //������
    public static void main(String[] args)
    {
        //������Ϸ����
            start = new start_frame(30,30);
            init_data = new Init_data(state_one);
            judge = new judge_state(state_one, jPanel);
            set_color = new set_color(state_one, jPanel);
    }
}
