public class GameOfLife_NO289{
    public void gameOfLife(int[][] board)    {
        boolean goOn = true;
        int[][] temp = new int[board.length][board[0].length];
        while (goOn) {
            goOn = false;
            for (int i = 0; i < board.length; ++i) {
                for (int j = 0; j < board[0].length; ++j) { // 需要使用board[0]来获取列的长度
                    temp[i][j] = board[i][j];
                }
            }

            for (int i = 0; i < board.length; ++i) {
                for (int j = 0; j < board[0].length; ++j) {
                    int x = 0 , y = 0,liveCount = 0;  //局部变量一定要赋初值
                    for ( x = i < 1 ? 0 : i - 1; x < board.length && x <= i + 1; ++x) {
                        for (y = j < 1 ? 0 : j - 1; y < board[0].length && y <= j + 1; ++y) {
                            if (x == i && y == j)
                                continue;
                            liveCount += temp[x][y];
                        }
                    }
                    if (liveCount < 2) {
                        board[i][j] = 0;
                    } else if (liveCount == 3) {
                        board[i][j] = 1;
                    } else if (liveCount > 3) {
                        board[i][j] = 0;
                    }
                    if (board[i][j] != temp[i][j])
                        goOn = true;

                }
            }
        }
    }
    public void gameOfLife2(int[][] board)
    {
        //变量的最小单位bit,不要忘了位操作

        int n = board.length, m = n > 0 ? board[0].length : 0;
        for(int i =  0 ; i < n; ++i ){
            for (int j = 0 ; j < m ; ++j){
                //若循环中有if操作用来判断某个特殊条件进行特殊处理，想办法把处理动作放在循环前或循环后
                int lives = -board[i][j];
                for (int x = Math.max(0,i-1); x < Math.min(i+2,n) ; ++x ){
                    for (int y = Math.max(0,j-1); y < Math.min(j+2,m) ;++y){
                        lives +=( board[x][y] & 0x01);
                    }
                }
                //尝试用位操作来解决问题
                if ((lives|(board[i][j]& 0x01)) == 0x03)
                    board[i][j] |= 0x02;
            }
        }
        for(int i =  0 ; i < n; ++i )
            for (int j = 0; j < m; ++j)
                board[i][j] >>= 1;
    }
}