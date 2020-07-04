import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LogicTest {

  @Before
  public void setUp() throws Exception {
    int[][] a = new int[40][40];
    a[0][0] = 1;
    Logic.setState(a);     //��Logic����һ����ʼ״̬
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
    //�ж�environment�Ƿ��Ԥ��һ��
    assertEquals(true, Logic.environmentIsright(b)); 
  }

  @Test
  public void testNextStep() {
    Logic.nextStep();
    int[][] b = new int[40][40];
    //�ж�currentstate�Ƿ��Ԥ��һ��
    assertEquals(true, Logic.currentstateIsright(b)); 
  }

}