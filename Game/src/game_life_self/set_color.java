package game_life_self;

import java.awt.Color;

import javax.swing.JPanel;
 /*����ϸ������ɫ ���Ϊ��ɫ������Ϊ��ɫ*/
public class set_color {
    static boolean [][] state_one;
    static JPanel[][] jPanel;
    //��ʼ����
    public set_color(boolean [][] state,JPanel[][] jpanel_one)
    {
        state_one = state;
        jPanel = jpanel_one;
    }
    //������ɫ
    public static void paint()
    {

        //ѭ���ж�״̬������ɫ
        for(int i=1;i<state_one.length;i++)
        {
            for(int j=1;j<state_one[i].length-1;j++)
            {
                if (state_one[i][j]) {
                jPanel[i][j].setBackground(Color.black);
                }
                else{
                    jPanel[i][j].setBackground(Color.white);
                }
            }
        }
    }
}
