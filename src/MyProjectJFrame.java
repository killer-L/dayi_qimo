
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class MyProjectJFrame extends JFrame implements ActionListener {
	JLabel jl1, jl2, jl3, jl4,label2;
	JTextField jtf1;
	JButton jb1;
	JPanel jp1, jp2, jp3, jp4, jp5;
	int number = 0;
	int counter = 0;
	JMenuBar menuBar;  
    JMenu menu;  
    JMenuItem exitItem,againItem; 

	MyProjectJFrame() {
		super("三次定输赢");
		jl1 = new JLabel("输入数字：");
		jl2 = new JLabel("所猜结果");
		jl3 = new JLabel("请输入一个0-10之间的整数");
		jl4 = new JLabel("三次定输赢");
		jtf1 = new JTextField(15);
		jb1 = new JButton("我猜");
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		jp4 = new JPanel();
		jp5 = new JPanel();
		
		
		label2=new JLabel();
		againItem =new JMenuItem("重玩");
		exitItem =new JMenuItem("退出");
		menuBar=new JMenuBar();
		menu=new JMenu("游戏操作");

		Random random = new Random();
		number = random.nextInt(10);

	    
	}

	void init() {
		this.setSize(300, 350);
		this.setLocation(400, 300);
		this.setVisible(true);

		// 背景图片的路径。（相对路径或者绝对路径。本例图片放于"java项目名"的文件下）
		String path = "src/background2.jpg";
		// 背景图片
		ImageIcon background = new ImageIcon(path);
		// 把背景图片显示在一个标签里面
		JLabel label = new JLabel(background);
		// 把标签的大小位置设置为图片刚好填充整个面板
		label.setBounds(0, 0, this.getWidth(), this.getHeight());
		// 把内容窗格转化为JPanel，否则不能用方法setOpaque()来使内容窗格透明
		JPanel imagePanel = (JPanel) this.getContentPane();
		imagePanel.setOpaque(false);
		// 把背景图片添加到分层窗格的最底层作为背景
		this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
		
		
		add(label2);
		setJMenuBar(menuBar);
		menuBar.add(menu);
		menu.add(againItem);
		menu.add(exitItem);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(6, 1));
		this.setResizable(false);
		
		// 美化字体
		jb1.setFont(new java.awt.Font("华文行楷", 1, 15));
		jl1.setFont(new java.awt.Font("华文行楷", 1, 15));
		jl2.setFont(new java.awt.Font("华文行楷", 1, 15));
		jl3.setFont(new java.awt.Font("华文行楷", 1, 15));
		jl4.setFont(new java.awt.Font("华文行楷", 1, 15));
		jl4.setForeground(Color.red);

		jp1.setLayout(new FlowLayout(FlowLayout.CENTER));
		jp2.setLayout(new FlowLayout(FlowLayout.CENTER));
		jp3.setLayout(new FlowLayout(FlowLayout.CENTER));
		jp4.setLayout(new FlowLayout(FlowLayout.CENTER));

		jp5.add(jl4);

		jp1.add(jl1);
		jp1.add(jtf1);

		jp2.add(jb1);

		jp3.add(jl2);

		jp4.add(jl3);

		this.add(jp5);
		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		this.add(jp4);
		
		//设置组件透明化
		jp1.setOpaque(false);
		jp2.setOpaque(false);
		jp3.setOpaque(false);
		jp4.setOpaque(false);
		jp5.setOpaque(false);

		jb1.addActionListener(this);
		againItem.addActionListener(this);
		exitItem.addActionListener(this);

	}

	public static void main(String[] args) {
		MyProjectJFrame myProject = new MyProjectJFrame();
		myProject.init();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int guess = 0;
		counter++;
		System.out.println(number);
		
		if (e.getSource() == jb1) {
			//判断点击次数
			if (counter < 4) {
				try {
					guess = Integer.parseInt(jtf1.getText());
					// 玩家输入获取
				} catch (Exception e1) {

					// 显示对话框，输入不合法
					jtf1.setText("");
					// 清空文本框内容
					jtf1.requestFocus();
					return;
				}
				//比较输入数字与随机数

				if (guess > 0 && guess < 10) {
					if (guess > number) {
						jl3.setText("猜大了");
						jtf1.setText("");
						jtf1.requestFocus();
						return;
					}
					if (guess < number) {
						jl3.setText("太小啦");
						jtf1.setText("");
						jtf1.requestFocus();
						return;
					}
					if (guess == number) {
						jl3.setText("您总共猜了" + counter + "次答对正确答案!");
						JOptionPane.showConfirmDialog(null, "游戏胜利", "友情提示", JOptionPane.CLOSED_OPTION,
								JOptionPane.INFORMATION_MESSAGE);
					}
				} else if (guess < 0 || guess > 10) {
					JOptionPane.showConfirmDialog(null, "请输入大于0并且小于10的数", "友情提示", JOptionPane.CLOSED_OPTION,
							JOptionPane.INFORMATION_MESSAGE);
				}
			} else {
				jl3.setText("你已经超过3次了");
				JOptionPane.showConfirmDialog(null, "请点击菜单栏内的重玩", "友情提示", JOptionPane.CLOSED_OPTION,
						JOptionPane.INFORMATION_MESSAGE);
			}
		
		}else if (e.getSource() == againItem) {
			//产生一个新的随机数
			Random random = new Random();
			number = random.nextInt(10);
			jl3.setText("请输入一个0-10之间 的整数");
			counter = 0;
		}else if(e.getSource() == exitItem){
			System.exit(0);
		}
	}

}
