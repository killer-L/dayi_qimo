
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Login extends JFrame implements ActionListener {
	JLabel jl1, jl2;
	JTextField jtf;
	JPasswordField jpf;
	JButton jb;
	JPanel jp1, jp2, jp3;

	Login() {
		super("登陆");
		jl1 = new JLabel("用户名：");
		jl2 = new JLabel("    密码：");
		jtf = new JTextField(15);
		jpf = new JPasswordField(15);
		jb = new JButton("确定");
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
	}

	void init() {

		this.setSize(300, 200);
		this.setLocation(800, 400);
		this.setVisible(true);
		// 背景图片的路径。（相对路径或者绝对路径。本例图片放于"java项目名"的文件下）
		String path = "src/background.jpg";
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
		// 组件美化
		jb.setFont(new java.awt.Font("华文行楷", 1, 15));
		jl1.setFont(new java.awt.Font("华文行楷", 1, 15));
		jl2.setFont(new java.awt.Font("华文行楷", 1, 15));

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(3, 1));
		this.setResizable(false);

		jp1.setLayout(new FlowLayout(FlowLayout.RIGHT));
		jp2.setLayout(new FlowLayout(FlowLayout.RIGHT));
		jp3.setLayout(new FlowLayout(FlowLayout.CENTER));

		jp1.add(jl1);
		jp1.add(jtf);

		jp2.add(jl2);
		jp2.add(jpf);

		jp3.add(jb);

		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		jp1.setOpaque(false);
		jp2.setOpaque(false);
		jp3.setOpaque(false);

		jb.addActionListener(this);

	}

	void background() {
		Icon i = new ImageIcon("background.jpg");
		JLabel background = new JLabel(i);
		background.setBounds(0, 0, 300, 200);
		this.add(background);
	}

	public static void main(String[] args) {
		Login login = new Login();
		login.init();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String name = jtf.getText();
		String password = jpf.getText();
		//输入正确的用户名和密码登录到游戏窗口
		if (name.equals("李梓豪") && password.equals("07160626")) {
			new MyProjectJFrame().init();
			setVisible(false);

		} else {
			JOptionPane.showMessageDialog(Login.this, "用户名或者密码错误!");

		}

	}

}
