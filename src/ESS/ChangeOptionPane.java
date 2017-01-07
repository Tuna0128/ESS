package ESS;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class ChangeOptionPane implements ActionListener {
	JFrame f;
	JList list;
	DefaultListModel typeModel;
	int value;
	int mType = JOptionPane.QUESTION_MESSAGE;
	/*
	 * public static void main(String argv[]) { new ChangeOptionPane(); }
	 */

	public ChangeOptionPane(DefaultListModel timeModel, DefaultListModel typeModel, DefaultListModel teamModel,
			DefaultListModel venueModel, int value, Venues[] venueList, int venueCounter) {
		this.typeModel = typeModel;
		this.value = value;
		// Build Elements

		/*
		 * String in1 = JOptionPane.showInputDialog(f, "請輸入姓名", "輸入", mType);
		 * JOptionPane.showMessageDialog(f, "您輸入的是 : " + in1);
		 */
		// String[] gender = { "男", "女" };

		String[] selectType = { "未選取", "更換隊伍", "更換場地", "更換日期" };
		String getSelect = (String) JOptionPane.showInputDialog(f, "<html><font color=white>請選擇更換項目</font><p></html>", 
				"選取", mType, null, selectType, "未選取");
		if (getSelect == "未選取" || getSelect == null)
			return;
		else if (getSelect == "更換隊伍")
			changeOperation(teamModel);
		else if (getSelect == "更換場地")
			changeOperation(venueModel, timeModel, venueList, venueCounter);

		// in2.charAt(0);
		// Close JFrame
		// f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent e) {
		// if (e.getSource()==id) {}
	}

	private void changeOperation(DefaultListModel inputModel) {
		String[] team = new String[inputModel.getSize()];
		for (int i = 0; i < inputModel.getSize(); i++) {
			team[i] = (i + 1) + " " + inputModel.getElementAt(i);
		}
		while (true) {
			String getNum = (String) JOptionPane.showInputDialog(f, "<html><font color=white>請選擇隊伍</font><p></html>", 
					"選取", mType, null, team, "未選擇");
			System.out.println(getNum);
			if (getNum == null)
				break;
			System.out.println(getNum.split(" ")[0]);
			int change = Integer.parseInt(getNum.split(" ")[0]) - 1;
			System.out.println("1:" + typeModel.getElementAt(value) + " " + value + " " + "2:"
					+ typeModel.getElementAt(change) + " " + change + " ");
			// System.out.println(typeModel.toString());
			if (typeModel.getElementAt(value).equals(typeModel.getElementAt(change))) {
				String buff = (String) inputModel.getElementAt(value);
				inputModel.set(value, inputModel.getElementAt(change));
				inputModel.set(change, buff);
				break;
			} else {
				JOptionPane.showMessageDialog(f, "<html><font color=white>更改失敗<br>選取隊伍的賽事型態不符</font><p></html>");
			}
		}
	}

	private void changeOperation(DefaultListModel inputModel, DefaultListModel timeModel,Venues[] venueList,int venueCounter) {
		List<String> venueAL = new ArrayList<String>();
		System.out.println(venueCounter);
		for (int i = 0; i < venueCounter; i++) {
			if (venueList[i].getSportType().equals(typeModel.getElementAt(value)))
				venueAL.add(1+" "+venueList[i].getName());
		}
		
		while (true) {
			String getNum = (String) JOptionPane.showInputDialog(f, "<html><font color=white>請選擇場地</font><p></html>"
					, "選取", mType, null,venueAL.toArray() , "未選擇");
			System.out.println(getNum);
			if (getNum == null)
				break;
			System.out.println(getNum.split(" ")[0]);
			int change = Integer.parseInt(getNum.split(" ")[0]) - 1;
			
			if (typeModel.getElementAt(value).equals(venueList[change].getSportType())) {
				System.out.println("Change Venue");
				for (int i = 0; i < timeModel.getSize(); i++){
					System.out.println("time:"+timeModel.getElementAt(i)+" "+timeModel.getElementAt(value)+
							"venue:"+inputModel.getElementAt(i)+" "+venueList[change].getName());
					/*String buff = (String)timeModel.getElementAt(i);
					String time1 = buff.split(" ")[0];
					buff = (String)timeModel.getElementAt(value);
					String time2 = buff.split(" ")[0];*/
					if (timeModel.getElementAt(i).equals(timeModel.getElementAt(value)) && 
							inputModel.getElementAt(i).equals(venueList[change].getName())){
						System.out.println("inner loop i:"+i);
						String buff = (String) inputModel.getElementAt(value);
						inputModel.set(value, inputModel.getElementAt(i));
						inputModel.set(i, buff);
						break;
					}
				}
				break;
			} else {
				JOptionPane.showMessageDialog(f, "<html><font color=white>更改失敗<br>選取場地的型態不符</font><p></html>");
			}
		}
	}
}
