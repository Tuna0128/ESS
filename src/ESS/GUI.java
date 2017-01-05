package ESS;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.GridBagLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JList;
import java.awt.FlowLayout;
import java.awt.Font;

public class GUI extends JFrame {
	static Map<Integer, String> timeMap = new HashMap<Integer, String>();

	JPanel controlPan = new JPanel();
	JPanel dataPan = new JPanel();
	JButton scheduleBtn = new JButton("排賽程");
	JButton changeBtn = new JButton("更改賽程");
	JButton searchBtn = new JButton("查詢賽程");
	JButton cleanBtn = new JButton("清除");
	JRadioButton buttonSin = new JRadioButton("sin");
	JRadioButton buttonCos = new JRadioButton("cos");
	JRadioButton buttonTan = new JRadioButton("tan");
	JRadioButton buttonCsc = new JRadioButton("csc");
	JRadioButton buttonSec = new JRadioButton("sec");
	JRadioButton buttonCot = new JRadioButton("cot");
	JScrollPane scrollPane = new JScrollPane();
	JLabel curseLab = new JLabel("箭頭(<=100)");
	JTextField curseTF = new JTextField(10);
	ButtonGroup controlGroup;
	DefaultListModel venueModel = new DefaultListModel();
	DefaultListModel teamModel = new DefaultListModel();
	DefaultListModel typeModel = new DefaultListModel();
	DefaultListModel timeModel = new DefaultListModel();

	JTable list = new JTable();
	private final JList venueJList = new JList(venueModel);
	private final JList teamJList = new JList(teamModel);
	private final JList typeJList = new JList(typeModel);
	private final JList timeJList = new JList(timeModel);
	private final JScrollPane scrollPane_1 = new JScrollPane();
	private final JPanel scrollPanel = new JPanel();

	/**
	 * @throws IOException
	 * 
	 */
	GUI() throws IOException {
		
		

		// TODO Auto-generated method stub
		Scanner inputScanner = new Scanner(System.in);
		Random ran = new Random();
		String testTeam = "台灣 韓國 俄羅斯 塞爾維亞 泰國 土耳其 義大利 美國 日本 西班牙 羅馬尼亞 墨西哥 巴西 法國 瑞士 哈薩克 奧地利 斯洛伐克 波蘭 捷克";
		String testType = "棒球 羽球 籃球";
		timeMap.put(0, "上午");
		timeMap.put(1, "下午");

		Venues[] venueList = new Venues[100];
		int venueCounter = 0;
		// Venues
		FileReader fr = new FileReader("Venues.txt");
		// BufferedReader br = new BufferedReader(fr);
		File f = new File("Venues.txt");
		Scanner sc = new Scanner(f);
		sc.nextLine();
		while (sc.hasNext()) {
			String[] buff = sc.nextLine().split(" ");
			// System.out.println(buff[0]+buff[1]+buff[2]+buff[3]);
			venueList[venueCounter] = new Venues(buff[0], buff[1], buff[2], Integer.parseInt(buff[3]));
			venueCounter++;
		}
		int[] venueSelect = new int[venueCounter];
		fr.close();
		// Team
		String[] teamList = testTeam.split(" ");
		int[] teamSelect = new int[teamList.length];
		String[] typeList = testType.split(" ");
		int[] typeSelect = new int[typeList.length];

		// list1.setSize(100);
		// list1.addElement("hello");

		getContentPane().setForeground(Color.WHITE);
		getContentPane().setBackground(Color.DARK_GRAY);
		controlPan.setForeground(Color.WHITE);
		controlPan.setBackground(Color.DARK_GRAY);
		// controlPan.setSize(600, 200);
		controlPan.setLayout(new GridLayout(8, 1));
		int C = venueCounter;
		scheduleBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// JOptionPane.showMessageDialog(dataPan, "a", "b",
				// JFrame.EXIT_ON_CLOSE);
				/*
				 * Object[][] data = { { "Kelly", "Female", new Integer(16),
				 * false, "kelly@gmail.com" }, { "Peter", "Male", new
				 * Integer(14), false, "peter@gmail.com" }, { "Amy", "Female",
				 * new Integer(12), false, "amy@gmail.com" }, { "Tony", "Male",
				 * new Integer(49), true, "tony@gmail.com" } }; String[] columns
				 * = { "Name", "Gender", "Age", "Vegetarian", "E-mail" }; list =
				 * new JTable(data, columns);
				 * list.setPreferredScrollableViewportSize(new Dimension(400,
				 * 300)); dataPan.add(list); //dataPan.setVisible(true);
				 */
				timeModel.clear();
				typeModel.clear();
				teamModel.clear();
				venueModel.clear();
				for (String type : typeList) {
					for (int i = 0; i < 5; i++) {
						for (int j = 0; j < 2; j++) {
							// String type = "棒球";
							Venues Venue;
							String Team1;
							String Team2;
							int buff;
							System.out.println(type);
							System.out.println(1);
							// select venue
							do {
								buff = ran.nextInt(C);
							} while (!venueList[buff].getSportType().equals(type) || venueSelect[buff] == 1);
							Venue = venueList[buff];
							venueSelect[buff] = 1;
							System.out.println(2);
							// select team
							do {
								buff = ran.nextInt(teamList.length);
							} while (teamSelect[buff] == 1);
							System.out.print(buff + " ");
							Team1 = teamList[buff];
							teamSelect[buff] = 1;
							do {
								buff = ran.nextInt(teamList.length);
							} while (teamSelect[buff] == 1);
							System.out.println(buff);
							Team2 = teamList[buff];
							teamSelect[buff] = 1;
							timeModel.addElement("08/" + (19 + i) + " " + timeMap.get(j));
							typeModel.addElement(type);
							teamModel.addElement(Team1 + " vs. " + Team2);
							venueModel.addElement(Venue.getName());

							System.out.println("08/" + (19 + i) + " " + timeMap.get(j) + " " + Venue.getName() + " "
									+ type + " " + Team1 + " vs. " + Team2);
						}
						for (int k = 0; k < venueSelect.length; k++)
							venueSelect[k] = 0;
						for (int k = 0; k < teamSelect.length; k++)
							teamSelect[k] = 0;
						// venueSelect = new int[venueCounter];
					}
				}
			}
		});
		scheduleBtn.setForeground(Color.WHITE);
		scheduleBtn.setBackground(Color.DARK_GRAY);

		controlPan.add(scheduleBtn);
		changeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (venueJList.getSelectedIndex()==-1)
					JOptionPane.showMessageDialog(dataPan, "請先選取賽程", "Message", JFrame.EXIT_ON_CLOSE);
				else {
					new ChangeOptionPane(timeModel,typeModel,teamModel,venueModel,venueJList.getSelectedIndex());
				}
			}
		});
		
		changeBtn.setForeground(Color.WHITE);
		changeBtn.setBackground(Color.DARK_GRAY);
		controlPan.add(changeBtn);
		searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int mType = JOptionPane.INFORMATION_MESSAGE;
				String resultStr = "";
				String searchStr = JOptionPane.showInputDialog(dataPan, "請輸入查詢項目", "輸入", mType );
				for (int i = 0;i<teamModel.getSize();i++){
					if (((String) teamModel.getElementAt(i)).indexOf(searchStr) != -1) 
			            resultStr += timeModel.getElementAt(i)+" "+typeModel.getElementAt(i)+" "+
			            		teamModel.getElementAt(i)+" "+venueModel.getElementAt(i)+"\n";
					if (((String) typeModel.getElementAt(i)).indexOf(searchStr) != -1) 
			            resultStr += timeModel.getElementAt(i)+" "+typeModel.getElementAt(i)+" "+
			            		teamModel.getElementAt(i)+" "+venueModel.getElementAt(i)+"\n";
					if (((String) venueModel.getElementAt(i)).indexOf(searchStr) != -1) 
			            resultStr += timeModel.getElementAt(i)+" "+typeModel.getElementAt(i)+" "+
			            		teamModel.getElementAt(i)+" "+venueModel.getElementAt(i)+"\n";
				}
				System.out.print(resultStr);
			}
		});
		searchBtn.setBackground(Color.DARK_GRAY);
		searchBtn.setForeground(Color.WHITE);
		
		controlPan.add(searchBtn);
		
		cleanBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				timeModel.clear();
				typeModel.clear();
				teamModel.clear();
				venueModel.clear();
			}
		});
		cleanBtn.setForeground(Color.WHITE);
		cleanBtn.setBackground(Color.DARK_GRAY);

		controlPan.add(cleanBtn);
		/*
		 * controlPan.add(new JPanel()); controlPan.add(new JPanel());
		 * controlPan.add(new JPanel()); controlPan.add(new JPanel());
		 * controlPan.add(new JPanel());
		 */

		/*
		 * controlGroup = new ButtonGroup(); controlGroup.add(buttonCos);
		 * controlGroup.add(buttonCot); controlGroup.add(buttonCsc);
		 * controlGroup.add(buttonSec); controlGroup.add(buttonSin);
		 * controlGroup.add(buttonTan);
		 */

		// dataPan.add(list);

		dataPan.setLayout(new GridLayout(1, 4));
		getContentPane().add(controlPan, BorderLayout.WEST);
		dataPan.setBackground(Color.DARK_GRAY);
		dataPan.setForeground(Color.WHITE);
		getContentPane().add(dataPan, BorderLayout.CENTER);

		dataPan.add(scrollPane_1);
		scrollPanel.setBackground(Color.DARK_GRAY);

		teamJList.addMouseListener(new sync());
		timeJList.addMouseListener(new sync());
		venueJList.addMouseListener(new sync());
		typeJList.addMouseListener(new sync());
		
		scrollPane_1.setViewportView(scrollPanel);
		scrollPanel.setLayout(new GridLayout(1, 4));
		timeJList.setForeground(Color.WHITE);
		timeJList.setBackground(Color.DARK_GRAY);
		scrollPanel.add(timeJList);
		typeJList.setForeground(Color.WHITE);
		typeJList.setBackground(Color.DARK_GRAY);
		scrollPanel.add(typeJList);
		teamJList.setForeground(Color.WHITE);
		teamJList.setBackground(Color.DARK_GRAY);
		scrollPanel.add(teamJList);
		venueJList.setForeground(Color.WHITE);
		venueJList.setBackground(Color.DARK_GRAY);
		scrollPanel.add(venueJList);
		
		
	}

	public static void main(String[] args) throws IOException {
		setUIFont (new javax.swing.plaf.FontUIResource("Microsoft JhengHei UI",1,16));
		GUI s = new GUI();
		s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		s.setSize(1024, 768);
		s.setTitle("ESS");
		s.setVisible(true);
	}
	
	public static void setUIFont(javax.swing.plaf.FontUIResource f) {
		java.util.Enumeration keys = UIManager.getDefaults().keys();
		while (keys.hasMoreElements()) {
			Object key = keys.nextElement();
			Object value = UIManager.get(key);
			if (value != null && value instanceof javax.swing.plaf.FontUIResource)
				UIManager.put(key, f);
		}
	}

	class sync implements MouseListener {
		public void mouseClicked(MouseEvent evt) {
			JList list = (JList) evt.getSource();
			switch(evt.getClickCount()){
			case 1:
				int index = list.locationToIndex(evt.getPoint());
				venueJList.setSelectedIndex(index);
				teamJList.setSelectedIndex(index);
				typeJList.setSelectedIndex(index);
				timeJList.setSelectedIndex(index);
				break;
			case 2:
				JOptionPane.showMessageDialog(dataPan, "Hello", "Message", JFrame.EXIT_ON_CLOSE);
				break;
			case 3:
				JOptionPane.showMessageDialog(dataPan, "World", "Message", JFrame.EXIT_ON_CLOSE);
			}
			/*else if (evt.getClickCount() == 2) {

				// Double-click detected
				JOptionPane.showMessageDialog(dataPan, "Hello", "Message", JFrame.EXIT_ON_CLOSE);
			} 
			else if (evt.getClickCount() == 3) {

				// Triple-click detected
				int index = list.locationToIndex(evt.getPoint());
			}*/
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}
	}
}
