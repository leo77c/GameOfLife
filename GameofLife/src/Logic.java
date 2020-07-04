

public class Logic {
  private static int[][] currentState = new int[40][40];  //1�Ǵ�0������
  private static int[][] environment = new int[40][40];  //��Χ�м������ϸ��
  public static int[][] isChanged = new int[40][40];   //�ж�ϸ��״̬�Ƿ�仯��1Ϊ�仯��0Ϊ����
  
  Logic(int[][] cell) {
    currentState = cell;
  }
  
  /**
   * �жϻ���ϸ����.
   */
  
  public static void judgeEnvironment() {
   
    //�ĸ����ϵĵ�
    environment[0][0] = currentState[0][1] + currentState[1][1] + currentState[1][0];
    environment[0][39] = currentState[0][38] + currentState[1][38] + currentState[1][39];
    environment[39][0] = currentState[39][1] + currentState[38][1] + currentState[38][0];
    environment[39][39] = currentState[39][38] + currentState[38][38] + currentState[38][39];
    //�������ϵĵ�
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
    //�м�ĵ�
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
   * �ж���һ��ϸ����״̬
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
    // TODO �Զ����ɵķ������
    currentState = cellstate;
  }
  
  /**
   * �жϻ����Ƿ���ȷ.
   * @param a �����άint����
   * @return �õ�booleanֵ
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
   * �жϵ�ǰ״̬�Ƿ���ȷ.
   * @param a �����άint����
   * @return �õ�booleanֵ
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

