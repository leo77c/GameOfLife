

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ControlerTest {
  @Before
  public void setUp() throws Exception {
    new UI();
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testStart() {
    Controler.start();
    assertEquals(1, Controler.getstate());
  }

  @Test
  public void testStop() {
    Controler.stop();
    assertEquals(0, Controler.getstate());
  }

  @Test
  public void testClear() {
    Controler.clear();
    assertEquals(0, Controler.getstate());
  }

}