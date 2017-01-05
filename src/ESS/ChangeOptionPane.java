package ESS;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class ChangeOptionPane implements ActionListener {
	JFrame f;
	JList list;

	/*
	 * public static void main(String argv[]) { new ChangeOptionPane(); }
	 */

	public ChangeOptionPane(DefaultListModel timeModel, DefaultListModel typeModel, 
			DefaultListModel teamModel, DefaultListModel venueModel, int value) {

		// Build Elements
		int mType = JOptionPane.INFORMATION_MESSAGE;
		/*
		 * String in1 = JOptionPane.showInputDialog(f, "請輸入姓名", "輸入", mType);
		 * JOptionPane.showMessageDialog(f, "您輸入的是 : " + in1);
		 */
		// String[] gender = { "男", "女" };
		String[] team = new String[teamModel.getSize()];
		for (int i = 0; i < teamModel.getSize(); i++) {
			team[i] = (i + 1) + " " + (String) teamModel.getElementAt(i);
		}
		String in2 = (String) JOptionPane.showInputDialog(f, "請選擇賽程", "輸入", mType, null, team, "未選擇");
		JOptionPane.showMessageDialog(f, "您選擇的是 : " + in2.charAt(0));
		int change = Integer.parseInt(in2.charAt(0)+"")-1;
		String buff = (String)teamModel.getElementAt(value);
		teamModel.set(value, teamModel.getElementAt(change));
		teamModel.set(change, buff);
		//in2.charAt(0);
		// Close JFrame
		// f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent e) {
		// if (e.getSource()==id) {}
	}
}