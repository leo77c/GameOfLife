
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;


public class UI {
  private JFrame jframe;
  private static JButton[][] buttons = new JButton[40][40];
  private static int[][] cell = new int[40][40];
  private JPanel jpanel1;
  private JPanel jpanel2;
  private JButton button1;
  private JButton button2;
  private JButton button3;
  private JTextArea jtextarea;
  
  /**
   * ����UI����.
  */
  public UI() {        
    jframe = new JFrame("������Ϸ");
    jframe.setLocation(450, 180);
    jframe.setSize(500, 500);
    jframe.getContentPane().setLayout(new BorderLayout());

    jpanel1 = new JPanel();
    jpanel1.setLayout(new FlowLayout());
    jtextarea = new JTextArea();
    jtextarea.setEnabled(false);
    jtextarea.setOpaque(false);
    jtextarea.setText("����������ó�ʼ�㣡");
    jtextarea.setForeground(Color.black);
    button1 = new JButton("����");
    button1.addMouseListener(new MouseAdapter() {
        @Override
            public void mouseClicked(MouseEvent e) {
            Controler.start();
        }
        });       
    button2 = new JButton("ֹͣ");
    button2.addMouseListener(new MouseAdapter() {
        @Override
            public void mouseClicked(MouseEvent e) {
            Controler.stop();
        }
        });
    button3 = new JButton("���");
    button3.addMouseListener(new MouseAdapter() {
        @Override
            public void mouseClicked(MouseEvent e) {
            Controler.clear();
        }
        });
    
    jpanel1.add(jtextarea);
    jpanel1.add(button1);
    jpanel1.add(button2);
    jpanel1.add(button3);
    jframe.getContentPane().add(jpanel1, BorderLayout.NORTH);

    jpanel2 = new JPanel();
    jpanel2.setLayout(new GridLayout(40, 40, 1, 1));
    for (int i = 0; i < 40; i++) {
      for (int j = 0; j < 40; j++) {
        buttons[i][j] = new JButton();
        buttons[i][j].setBackground(Color.white);
        buttons[i][j].addActionListener(new ButtonActionListener());
        jpanel2.add(buttons[i][j]);
      }
    }
    jframe.getContentPane().add(jpanel2, BorderLayout.CENTER);

    jframe.setVisible(true);
  }

  class ButtonActionListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
            
      //2.��ȡ��ť����
      JButton btn = (JButton) e.getSource();
      if (btn.getBackground() == Color.white) {
        btn.setBackground(Color.black);
      } else {
        btn.setBackground(Color.white);
      }
    }
  }
  
  /**
   * �õ�ϸ��״̬.
   */
  
  public static int[][] getCellstate() {
    for (int i = 0; i < 40; i++) {
      for (int j = 0; j < 40; j++) {
        if (buttons[i][j].getBackground() == Color.white) {
          cell[i][j] = 0;
        } else {
          cell[i][j] = 1;
        }
      }
    }
    return cell;
  }
  
  /**
   * ����ϸ��״̬.
   * @param cell ����һ������ϸ��״̬�Ķ�άint����
   */
  
  public static void setCellstate(int[][] cell) {
    for (int i = 0; i < 40; i++) {
      for (int j = 0; j < 40; j++) {

        if (Logic.isChanged[i][j] == 1) {
          if (cell[i][j] == 0) {
            buttons[i][j].setBackground(Color.white);
          } else {
            buttons[i][j].setBackground(Color.black);
          }
        }
        
      }
    }
    
  }
    
  public static void main(String[] args) {
    new UI();

  }
}
