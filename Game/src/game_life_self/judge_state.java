package game_life_self;

import java.awt.Color;

import javax.swing.JPanel;

public class judge_state {
    static boolean [][] state_one;
    JPanel[][] jPanel;
    //��ʼ����
    public judge_state(boolean [][] state,JPanel[][] jpanel_one)
    {
        state_one = state;
        jPanel = jpanel_one;
    }

    //�ж�����������״̬������
    public void judge() {
    int life = 0;
        for (int i = 1; i < state_one.length - 1; i++) {
            for (int j = 1; j < state_one[i].length - 1; j++) {
                //ѭ���ж�����������Χ�ĸ������״̬���ҿ���״̬Ϊ������ʣ���
                int nCount = 0;
                if (jPanel[i - 1][j - 1].getBackground() == Color.black) {
                    nCount++;
                }
                if (jPanel[i - 1][j].getBackground() == Color.black) {
                    nCount++;
                }
                if (jPanel[i - 1][j + 1].getBackground() == Color.black) {
                    nCount++;
                }
                if (jPanel[i][j - 1].getBackground() == Color.black) {
                    nCount++;
                }
                if (jPanel[i][j + 1].getBackground() == Color.black) {
                    nCount++;
                }
                if (jPanel[i + 1][j - 1].getBackground() == Color.black) {
                    nCount++;
                }
                if (jPanel[i + 1][j].getBackground() == Color.black) {
                    nCount++;
                }
                if (jPanel[i + 1][j + 1].getBackground() == Color.black) {
                    nCount++;
                }
                if (nCount==3) {
                    state_one[i][j] = true;
                }
                else if (nCount == 2) {
                    state_one[i][j] = state_one[i][j];
                }
                else
                    state_one[i][j] = false;

        }
    }
    }
}
