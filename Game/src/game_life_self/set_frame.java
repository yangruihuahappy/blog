package game_life_self;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.FlowLayout;
	 
	 public class set_frame {
		 //�Ը������ݽ��г�ʼ��
	     JFrame iFrame;
	     //��Ϸ�����ٶ�
	     static int speed = 1000;
	     //ʣ����������
	     static int life = 0;
	     //�ݻ�����
	     static int step_one = 0;
	     myThread thread = null;
	     static start_frame start_frame;
	     //��ʾϸ��״̬���
	     static JPanel[][] jPanel;
	     //��ʾ�����������
	     static JPanel panel_1;
	     static JLabel number;
	     static JLabel step;
	     static boolean end = true;
	     public set_frame (int row ,int col) {
	         //��������
	         iFrame = new JFrame("������Ϸ");
	         //��ʼ���߽�
	         jPanel = new JPanel[row][col];
	         iFrame.getContentPane().setLayout(new BorderLayout(0, 0));
	 
	         JPanel panel = new JPanel();
	         iFrame.getContentPane().add(panel, BorderLayout.NORTH);
	         panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
	 
	         number = new JLabel("��ʣ����ϸ��: "+life+"               ");
	         panel.add(number);
	 
	         step = new JLabel("�����Ŀ: "+step_one);
	         panel.add(step);
	 
	         panel.setBackground(Color.red);
	         panel_1 = new JPanel();
	         iFrame.getContentPane().add(panel_1, BorderLayout.CENTER);
	         panel_1.setLayout(new GridLayout(30, 30, 2, 2));
	         //��ʼ�����н���Ϊ��ɫ
	         for(int i=0;i<row;i++)
	         {
	             for(int j=0;j<col;j++)
	             {
	                 jPanel[i][j] = new JPanel();
	                 jPanel[i][j].setBackground(Color.white);
	                 panel_1.add(jPanel[i][j]);
	             }
	         }
	 
	         //����ͼ�ν����С
	         iFrame.setLocation(400, 100);
	         iFrame.setSize(600, 600);        
	         //���ò˵�����ģʽ��ѡ�񣬲��Ҷ���ѡ���¼��İ�
	         JMenuBar menuBar = new JMenuBar();
	         iFrame.setJMenuBar(menuBar);
	         
	         JMenu choice = new JMenu("ģʽ");
	         menuBar.add(choice);
	 
	         JMenuItem start = new JMenuItem("��ʼ��Ϸ");
	         choice.add(start);
	         start.addActionListener(new start());
	 
	         JMenuItem continue_one = new JMenuItem("������Ϸ");
	         choice.add(continue_one);
	         continue_one.addActionListener(new continue_one());
	 
	         JMenuItem stop = new JMenuItem("ֹͣ��Ϸ");
	         choice.add(stop);
	         stop.addActionListener(new stop());
	 
	         JMenu speed = new JMenu("�����ٶ�");
	         menuBar.add(speed);
	 
	         JMenuItem speed_fast = new JMenuItem("����");
	         speed.add(speed_fast);
	         speed_fast.addActionListener(new speed_fast());
	 
	         JMenuItem speed_middle = new JMenuItem("����");
	         speed.add(speed_middle);
	         speed_middle.addActionListener(new speed_middle());
	 
	         JMenuItem speed_low = new JMenuItem("����");
	         speed.add(speed_low);
	         speed_low.addActionListener(new speed_low());
	         
	         JMenu help = new JMenu("����");
	         menuBar.add(help);
	         
	         JMenuItem author = new JMenuItem("��Ϸ����");
	         help.add(author);
	         author.addActionListener(new author());
	         
	         
	         iFrame.setVisible(true);
	 
	     }
	 
	     //���ö��߳�
	     class myThread extends Thread{
	         public myThread()    {
	         }
	         @SuppressWarnings("static-access")
			public void run(){
	             while(end)
	             {
	                 life = 0;
	                 start_frame.judge.judge();
	                 try {
	                     sleep(speed);
	                 } catch (InterruptedException e) {
	                     // TODO Auto-generated catch block
	                     e.printStackTrace();
	                 }
	 
	                 for (int m = 1; m < start_frame.state_one.length - 1; m++)
	                 {
	                     for (int n = 1; n < start_frame.state_one[m].length - 1; n++)
	                     {
	                         if (start_frame.state_one[m][n]==true) {
	                             life ++;
	                         }
	                     }
	                 }
	                 step_one++;
	                 number.setText("��ʣ����ϸ��: "+life+"               ");
	                 step.setText("����: "+step_one);
	 
	                 start_frame.set_color.paint();
	 
	                 if (life==0) {
	                     end = false;
	                     JOptionPane.showMessageDialog(null, "�����ݻ�������\n");
	                 }
	 
	             }
	         }
	     }
	 
	         //������Ϸ�Ŀ�ʼ
	         class start implements ActionListener
	         {
	             @SuppressWarnings("static-access")
				@Override
	             public void actionPerformed(ActionEvent e) {
	               
	                 //��ʼ���߼���ͼ
	               start_frame.init_data.random_init();
	              
	                 //���µ�ͼ��ɫ
	                 start_frame.set_color.paint();
	                 //��ʼ��������ʣ����������
	                 life = 0;
	                 step_one = 0;
	                 end = true;
	                 //�����̵߳Ŀ���
	                 if (thread != null)
	                     thread.stop();
	                 thread = new myThread();
	                 thread.start();
	             }
	         }
	         //������Ϸ�ļ���
	         class continue_one implements ActionListener
	         {
				@Override
	             public void actionPerformed(ActionEvent e) {
	                 // TODO Auto-generated method stub
	                 if(thread!=null)
	                     thread.stop();
	                 thread = new myThread();
	                 thread.start();
	             }
	 
	         }
	         //������Ϸ��ֹͣ
	         class stop implements ActionListener
	         {
	             @Override
	             public void actionPerformed(ActionEvent e) {
	                 // TODO Auto-generated method stub
	                 //�����̵߳Ŀ���
	                 if (thread != null)
	                     thread.stop();
	                 thread = null;
	             }
	 
	         }
	         //����������Ϸ�ٶȣ����٣�
	         class speed_fast implements ActionListener
	         {
	             @Override
	             public void actionPerformed(ActionEvent e) {
	                 // TODO Auto-generated method stub
	                 speed = 100;
	             }
	         }
	         //���������ٶ���Ϸ�����٣�
	         class speed_middle implements ActionListener
	         {
	             @Override
	             public void actionPerformed(ActionEvent e) {
	                 // TODO Auto-generated method stub
	                 speed = 1000;
	             }
	         }
	         //����������Ϸ�ٶȣ����٣�
	         class speed_low implements ActionListener
	         {
	             @Override
	             public void actionPerformed(ActionEvent e) {
	                 // TODO Auto-generated method stub
	                 speed = 5000;
	             }
	         }
	         class author implements ActionListener
	         {
	 
	             @Override
	             public void actionPerformed(ActionEvent e) {
	                
	                 JOptionPane.showMessageDialog(null, "��Ϸ����:\n"
	                         + "       ���sy1601��  ����  ���� \n");
	             }
	         }
	 }

