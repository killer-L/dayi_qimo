
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
		super("��½");
		jl1 = new JLabel("�û�����");
		jl2 = new JLabel("    ���룺");
		jtf = new JTextField(15);
		jpf = new JPasswordField(15);
		jb = new JButton("ȷ��");
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
	}

	void init() {

		this.setSize(300, 200);
		this.setLocation(800, 400);
		this.setVisible(true);
		// ����ͼƬ��·���������·�����߾���·��������ͼƬ����"java��Ŀ��"���ļ��£�
		String path = "src/background.jpg";
		// ����ͼƬ
		ImageIcon background = new ImageIcon(path);
		// �ѱ���ͼƬ��ʾ��һ����ǩ����
		JLabel label = new JLabel(background);
		// �ѱ�ǩ�Ĵ�Сλ������ΪͼƬ�պ�����������
		label.setBounds(0, 0, this.getWidth(), this.getHeight());
		// �����ݴ���ת��ΪJPanel���������÷���setOpaque()��ʹ���ݴ���͸��
		JPanel imagePanel = (JPanel) this.getContentPane();
		imagePanel.setOpaque(false);
		// �ѱ���ͼƬ��ӵ��ֲ㴰�����ײ���Ϊ����
		this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
		// �������
		jb.setFont(new java.awt.Font("�����п�", 1, 15));
		jl1.setFont(new java.awt.Font("�����п�", 1, 15));
		jl2.setFont(new java.awt.Font("�����п�", 1, 15));

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
		//������ȷ���û����������¼����Ϸ����
		if (name.equals("������") && password.equals("07160626")) {
			new MyProjectJFrame().init();
			setVisible(false);

		} else {
			JOptionPane.showMessageDialog(Login.this, "�û��������������!");

		}

	}

}
