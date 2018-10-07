package game_life_self;

/*随机的初始化*/
public class Init_data{
    static boolean[][] state;
    static int rand;
    public Init_data(boolean[][] state_one)
    {
        state = state_one;
    }
    public void random_init()
    {
        for(int i=1;i<state.length;i++)
        {
            for(int j=1;j<state[i].length-1;j++)
            {   /*设置随机函数来使界面初始化*/
                rand = (int) (Math.random()*100);  
                if (rand<50) {
                    state[i][j] = false;
                }
                else
                    state[i][j] = true;
            }
        }
    }
   
}