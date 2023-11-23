package gui;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
	public MyFrame() {
		setTitle("First Frame");
		setSize(300, 300);
		setVisible(true);
	
	}
	public static void main(String[] args) {
		MyFrame frame = new MyFrame();	
	}
}
