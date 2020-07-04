

public class Logic {
  private static int[][] currentState = new int[40][40];  //1是存活，0是死亡
  private static int[][] environment = new int[40][40];  //周围有几个存活细胞
  public static int[][] isChanged = new int[40][40];   //判读细胞状态是否变化，1为变化，0为不变
  
  Logic(int[][] cell) {
    currentState = cell;
  }
  
  /**
   * 判断环境细胞数.
   */
  
  public static void judgeEnvironment() {
   
    //四个角上的点
    environment[0][0] = currentState[0][1] + currentState[1][1] + currentState[1][0];
    environment[0][39] = currentState[0][38] + currentState[1][38] + currentState[1][39];
    environment[39][0] = currentState[39][1] + currentState[38][1] + currentState[38][0];
    environment[39][39] = currentState[39][38] + currentState[38][38] + currentState[38][39];
    //四条边上的点
    int i;
    for (i = 1; i < 39; i++) {
      environment[i][0] = currentState[i - 1][0] + currentState[i - 1][1] + currentState[i][1] 
                    + currentState[i + 1][1] + currentState[i + 1][0];
      environment[i][39] = currentState[i - 1][39] + currentState[i - 1][38] + currentState[i][38]
                    + currentState[i + 1][38] + currentState[i + 1][39];
    } 
    int j;
    for (j = 1; j < 39; j++) {
      environment[0][j] = currentState[0][j - 1] + currentState[1][j - 1] + currentState[1][j]
                    + currentState[1][j + 1] + currentState[0][j + 1];
      environment[39][i] = currentState[39][j - 1] + currentState[38][j - 1] + currentState[38][j]
                    + currentState[38][j + 1] + currentState[39][j + 1];
    }
    //中间的点
    for (i = 1; i < 39; i++) {
      for (j = 1; j < 39; j++) {
        environment[i][j] = currentState[i - 1][j - 1] + currentState[i - 1][j] 
                      + currentState[i - 1][j + 1] + currentState[i][j - 1] 
                      + currentState[i][j + 1] + currentState[i + 1][j - 1]
                      + currentState[i + 1][j] + currentState[i + 1][j + 1];
      }
    }
  }
  
  /**.
   * 判断下一步细胞的状态
   */
  
  public static void nextStep() {
    judgeEnvironment();
    int i;
    int j;
    for (i = 0; i < 40; i++) {
      for (j = 0; j < 40; j++) {
        if (currentState[i][j] == 0) {
          if (environment[i][j] == 3) {
            currentState[i][j] = 1;
            isChanged[i][j] = 1;
          }
        } else {
          if (environment[i][j] <= 1 || environment[i][j] >= 4) {
            currentState[i][j] = 0;
            isChanged[i][j] = 1;
          }
        }
      }
    }
  }
  
    
  public static int[][] getState() {
    return currentState;
  }
    
    
  public static void setState(int[][] cellstate) {
    // TODO 自动生成的方法存根
    currentState = cellstate;
  }
  
  /**
   * 判断环境是否正确.
   * @param a 传入二维int数组
   * @return 得到boolean值
   */
  
  public static boolean environmentIsright(int[][] a) {
    for (int i = 0; i < 40; i++) {
      for (int j = 0; j < 40; j++) {
        if (a[i][j] != environment[i][j]) {
          return false;
        }
      }
    }
    return true; 
  }
  
  /**
   * 判断当前状态是否正确.
   * @param a 传入二维int数组
   * @return 得到boolean值
   */
  public static boolean currentstateIsright(int[][] a) {
    for (int i = 0; i < 40; i++) {
      for (int j = 0; j < 40; j++) {
        if (a[i][j] != currentState[i][j]) {
          return false;
        }
      }
    }
    return true;
  }
}

