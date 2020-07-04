
import java.util.Timer;
import java.util.TimerTask;

public class Controler {
  private static Timer timer;
  private static int flag = 0;
    
  Controler() {
    
  }
  
  /**.
    * ������Ϸ
  */
  
  public static void start() {
    Logic.setState(UI.getCellstate());
    timer = new Timer();
    flag = 1;   
    timer.schedule(new Task(), 100, 500);
  }

  public static void stop() {
    timer.cancel();
    flag = 0;
  }
  
  /**.
   * ���״̬
   */
  
  public static void clear() {
    int[][] a = new int[40][40];
        
    if (flag == 1) {
      timer.cancel();
      flag = 0;
    }
        
    UI.setCellstate(a);
    Logic.setState(a);
  }
    
  public static int getstate() {
    return flag;
  }
}

class Task extends TimerTask{

  @Override
    public void run() {
    // TODO �Զ����ɵķ������
        
    Logic.nextStep();
    UI.setCellstate(Logic.getState());

  }
    
}
