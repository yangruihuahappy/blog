package game_life_self;

import java.awt.Color;

import javax.swing.JPanel;
 /*设置细胞的颜色 存活为黑色，死亡为白色*/
public class set_color {
    static boolean [][] state_one;
    static JPanel[][] jPanel;
    //初始化类
    public set_color(boolean [][] state,JPanel[][] jpanel_one)
    {
        state_one = state;
        jPanel = jpanel_one;
    }
    //设置颜色
    public static void paint()
    {

        //循环判断状态设置颜色
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
