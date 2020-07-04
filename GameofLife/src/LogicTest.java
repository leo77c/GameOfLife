import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LogicTest {

  @Before
  public void setUp() throws Exception {
    int[][] a = new int[40][40];
    a[0][0] = 1;
    Logic.setState(a);     //对Logic设置一个初始状态
  }

  @After
  public void tearDown() throws Exception {
  
  }

  @Test
  public void testJudgeEnvironment() {
    Logic.judgeEnvironment();
    int[][] b = new int[40][40];
    b[1][0] = 1;
    b[0][1] = 1;
    b[1][1] = 1;      
    //判断environment是否和预期一样
    assertEquals(true, Logic.environmentIsright(b)); 
  }

  @Test
  public void testNextStep() {
    Logic.nextStep();
    int[][] b = new int[40][40];
    //判断currentstate是否和预期一样
    assertEquals(true, Logic.currentstateIsright(b)); 
  }

}