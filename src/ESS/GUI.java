package ESS;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
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
import javax.swing.plaf.ColorUIResource;

import java.awt.GridBagLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
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
import java.awt.SystemColor;

public class GUI extends JFrame {
	static Map<Integer, String> timeMap = new HashMap<Integer, String>();

	JPanel controlPan = new JPanel();
	JPanel dataPan = new JPanel();
	JButton scheduleBtn = new JButton("排賽程");
	JButton changeBtn = new JButton("更改賽程");
	JButton searchBtn = new JButton("查詢賽程");
	JButton cleanBtn = new JButton("清除");
	JButton addBtn = new JButton("新增");
	JButton deleteBtn = new JButton("刪除");
	JScrollPane scrollPane = new JScrollPane();
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

	private JButton okButton;

	private JButton cancelBotton;

	/**
	 * @throws IOException
	 * 
	 */
	GUI() throws IOException {
		/*
		okButton = new JButton("確定");
		okButton.setForeground(Color.white);//所設置字體顏色為藍色
		okButton.setBackground(Color.GRAY);
		okButton.addActionListener(new ActionListener() {
			   @Override
			   public void actionPerformed(ActionEvent actionEvent) {
			       JOptionPane.getRootFrame().dispose();
			   }
			});//對這個按鈕進行監聽
	
		cancelBotton = new JButton("取消");
		cancelBotton.setBackground(Color.DARK_GRAY);
		cancelBotton.setForeground(Color.white);
		cancelBotton.addActionListener(new ActionListener() {
		   @Override
		   public void actionPerformed(ActionEvent actionEvent) {
		       JOptionPane.getRootFrame().dispose();
		   }
		});//對這個按鈕進行監聽
		
		JButton[] buttons = { okButton };
		*/
		// TODO Auto-generated method stub
		Scanner inputScanner = new Scanner(System.in);
		Random ran = new Random();
		String testTeam = "台灣 韓國 俄羅斯 塞爾維亞 泰國 土耳其 義大利 美國 日本 西班牙 羅馬尼亞 墨西哥 巴西 法國 瑞士 哈薩克 奧地利 斯洛伐克 波蘭 捷克 保加利亞 匈牙利 加拿大 德國 英國 中國";
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
		controlPan.setLayout(new GridLayout(9, 1));
		int C = venueCounter;
		scheduleBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// JOptionPane.showMessageDialog(dataPan, "a", "b", JFrame.EXIT_ON_CLOSE);
				timeModel.clear();
				typeModel.clear();
				teamModel.clear();
				venueModel.clear();
				for (String type : typeList) {
					for (int i = 0; i < 5; i++) {
						// control date
						for (int j = 0; j < 2; j++) {
							// control time
							Venues Venue;
							String Team1;
							String Team2;
							int buff;
							System.out.println(type);

							// select venue
							do {
								buff = ran.nextInt(C);
							} while (!venueList[buff].getSportType().equals(type) || venueSelect[buff] == 1);
							Venue = venueList[buff];
							venueSelect[buff] = 1;

							// select team
							do {
								buff = ran.nextInt(teamList.length);
								//System.out.println(1);
							} while (teamSelect[buff] == 1);
							System.out.print(buff + " "+teamSelect[buff]+" ");
							Team1 = teamList[buff];
							teamSelect[buff] = 1;
							do {
								buff = ran.nextInt(teamList.length);
								//System.out.println(2);
							} while (teamSelect[buff] == 1);
							System.out.println(buff+ " "+teamSelect[buff]);
							Team2 = teamList[buff];
							teamSelect[buff] = 1;
							
							//add data to list
							timeModel.addElement("08/" + (19 + i) + " " + timeMap.get(j));
							typeModel.addElement(type);
							teamModel.addElement(Team1 + " vs. " + Team2);
							venueModel.addElement(Venue.getName());

							System.out.println("08/" + (19 + i) + " " + timeMap.get(j) + " "
									+ type + " " + Team1 + " vs. " + Team2 + " " + Venue.getName());
						}
						for (int k = 0; k < venueSelect.length; k++)
							venueSelect[k] = 0;
					}
					for (int k = 0; k < teamSelect.length; k++)
						teamSelect[k] = 0;
				}
			}
		});
		scheduleBtn.setForeground(new Color(51, 153, 255));
		scheduleBtn.setBackground(new Color(51, 51, 51));
		//scheduleBtn.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		controlPan.add(scheduleBtn);
		//Change
		changeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (venueJList.getSelectedIndex() == -1)
					//JOptionPane.showOptionDialog(null, "<html><font color=white>請先選取賽程</font><p></html>", "Dialog", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon(), buttons, buttons[0]);
					JOptionPane.showMessageDialog(dataPan, "<html><font color=white>請先選取賽程</font><p></html>", "Message", JOptionPane.ERROR_MESSAGE);
				else {
					new ChangeOptionPane(timeModel, typeModel, teamModel, venueModel, venueJList.getSelectedIndex(),
							venueList,C);
				}
			}
		});
		changeBtn.setForeground(new Color(51, 153, 255));
		changeBtn.setBackground(new Color(51, 51, 51));
		controlPan.add(changeBtn);
		//Search
		searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int mType = JOptionPane.INFORMATION_MESSAGE;
				String resultStr = "";
				String searchStr = JOptionPane.showInputDialog(dataPan, "<html><font color=white>請輸入查詢項目</font><p></html>", "輸入", mType);
				for (int i = 0; i < teamModel.getSize(); i++) {
					if (searchStr == "" || searchStr == "0" || searchStr == "-1")
						break;
					else {
						if (((String) teamModel.getElementAt(i)).indexOf(searchStr) != -1)
							resultStr += timeModel.getElementAt(i) + " " + typeModel.getElementAt(i) + " "
									+ teamModel.getElementAt(i) + " " + venueModel.getElementAt(i) + "\n";
						if (((String) typeModel.getElementAt(i)).indexOf(searchStr) != -1)
							resultStr += timeModel.getElementAt(i) + " " + typeModel.getElementAt(i) + " "
									+ teamModel.getElementAt(i) + " " + venueModel.getElementAt(i) + "\n";
						if (((String) venueModel.getElementAt(i)).indexOf(searchStr) != -1)
							resultStr += timeModel.getElementAt(i) + " " + typeModel.getElementAt(i) + " "
									+ teamModel.getElementAt(i) + " " + venueModel.getElementAt(i) + "\n";
					}
				}
				System.out.print(resultStr);
			}
		});
		searchBtn.setBackground(new Color(51, 51, 51));
		searchBtn.setForeground(new Color(51, 153, 255));
		controlPan.add(searchBtn);
		
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int mType = JOptionPane.QUESTION_MESSAGE;
				
				String[] selectType = { "未選取", "更換隊伍", "更換場地", "更換日期" };
				String getSelect = (String) JOptionPane.showInputDialog(null, "<html><font color=white>請選擇更換項目</font><p></html>", 
						"選取", mType, null, selectType, "未選取");
				
				String resultStr = "";
				String searchStr = JOptionPane.showInputDialog(dataPan, "<html><font color=white>請輸入查詢項目</font><p></html>", "輸入", mType);
				
			}
		});
		addBtn.setForeground(new Color(51, 153, 255));
		addBtn.setBackground(new Color(51, 51, 51));
		controlPan.add(addBtn);
		
		deleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		deleteBtn.setForeground(new Color(51, 153, 255));
		deleteBtn.setBackground(new Color(51, 51, 51));
		controlPan.add(deleteBtn);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setBackground(new Color(51, 51, 51));
		controlPan.add(panel);
		
		JPanel panel2 = new JPanel();
		panel2.setForeground(Color.WHITE);
		panel2.setBackground(new Color(51, 51, 51));
		controlPan.add(panel2);
		
		JPanel panel3 = new JPanel();
		panel3.setForeground(Color.WHITE);
		panel3.setBackground(new Color(51, 51, 51));
		controlPan.add(panel3);
		
		JPanel panel4 = new JPanel();
		panel4.setForeground(Color.WHITE);
		panel4.setBackground(Color.DARK_GRAY);
		//controlPan.add(panel4);

		cleanBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				timeModel.clear();
				typeModel.clear();
				teamModel.clear();
				venueModel.clear();
			}
		});
		cleanBtn.setForeground(Color.WHITE);
		cleanBtn.setBackground(new Color(51, 51, 51));

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
		//data panel
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
		UIManager.put("OptionPane.background",new Color(51, 51, 51));
		UIManager.put("Panel.background",new Color(51, 51, 51));
		UIManager.put("OptionPane.okButtonbackground",Color.BLUE);
		UIManager.put("Panel.Text",Color.WHITE);
		setUIFont(new javax.swing.plaf.FontUIResource("Microsoft JhengHei UI", 4, 18));
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
			switch (evt.getClickCount()) {
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
			/*
			 * else if (evt.getClickCount() == 2) {
			 * 
			 * // Double-click detected JOptionPane.showMessageDialog(dataPan,
			 * "Hello", "Message", JFrame.EXIT_ON_CLOSE); } else if
			 * (evt.getClickCount() == 3) {
			 * 
			 * // Triple-click detected int index =
			 * list.locationToIndex(evt.getPoint()); }
			 */
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
