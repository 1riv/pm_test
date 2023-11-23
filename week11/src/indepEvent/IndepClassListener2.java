package indepEvent;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class IndepClassListener2 extends JFrame {
	public IndepClassListener2() {
		setTitle("Indep. Listener 2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setBackground(Color.BLUE);
		c.setLayout(new FlowLayout());
		
		JButton btn = new JButton("기말고사");
		btn.setBackground(Color.BLACK);
		btn.setForeground(Color.WHITE);
		btn.addActionListener(new MyActionListener());
		
		c.add(btn);
		
		setSize(700, 500);
		setVisible(true);
	}
	public static void main(String[] args) {
		new IndepClassListener2();
	}
}
