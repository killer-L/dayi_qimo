
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
		super("���ζ���Ӯ");
		jl1 = new JLabel("�������֣�");
		jl2 = new JLabel("���½��");
		jl3 = new JLabel("������һ��0-10֮�������");
		jl4 = new JLabel("���ζ���Ӯ");
		jtf1 = new JTextField(15);
		jb1 = new JButton("�Ҳ�");
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		jp4 = new JPanel();
		jp5 = new JPanel();
		
		
		label2=new JLabel();
		againItem =new JMenuItem("����");
		exitItem =new JMenuItem("�˳�");
		menuBar=new JMenuBar();
		menu=new JMenu("��Ϸ����");

		Random random = new Random();
		number = random.nextInt(10);

	    
	}

	void init() {
		this.setSize(300, 350);
		this.setLocation(400, 300);
		this.setVisible(true);

		// ����ͼƬ��·���������·�����߾���·��������ͼƬ����"java��Ŀ��"���ļ��£�
		String path = "src/background2.jpg";
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
		
		
		add(label2);
		setJMenuBar(menuBar);
		menuBar.add(menu);
		menu.add(againItem);
		menu.add(exitItem);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(6, 1));
		this.setResizable(false);
		
		// ��������
		jb1.setFont(new java.awt.Font("�����п�", 1, 15));
		jl1.setFont(new java.awt.Font("�����п�", 1, 15));
		jl2.setFont(new java.awt.Font("�����п�", 1, 15));
		jl3.setFont(new java.awt.Font("�����п�", 1, 15));
		jl4.setFont(new java.awt.Font("�����п�", 1, 15));
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
		
		//�������͸����
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
			//�жϵ������
			if (counter < 4) {
				try {
					guess = Integer.parseInt(jtf1.getText());
					// ��������ȡ
				} catch (Exception e1) {

					// ��ʾ�Ի������벻�Ϸ�
					jtf1.setText("");
					// ����ı�������
					jtf1.requestFocus();
					return;
				}
				//�Ƚ����������������

				if (guess > 0 && guess < 10) {
					if (guess > number) {
						jl3.setText("�´���");
						jtf1.setText("");
						jtf1.requestFocus();
						return;
					}
					if (guess < number) {
						jl3.setText("̫С��");
						jtf1.setText("");
						jtf1.requestFocus();
						return;
					}
					if (guess == number) {
						jl3.setText("���ܹ�����" + counter + "�δ����ȷ��!");
						JOptionPane.showConfirmDialog(null, "��Ϸʤ��", "������ʾ", JOptionPane.CLOSED_OPTION,
								JOptionPane.INFORMATION_MESSAGE);
					}
				} else if (guess < 0 || guess > 10) {
					JOptionPane.showConfirmDialog(null, "���������0����С��10����", "������ʾ", JOptionPane.CLOSED_OPTION,
							JOptionPane.INFORMATION_MESSAGE);
				}
			} else {
				jl3.setText("���Ѿ�����3����");
				JOptionPane.showConfirmDialog(null, "�����˵����ڵ�����", "������ʾ", JOptionPane.CLOSED_OPTION,
						JOptionPane.INFORMATION_MESSAGE);
			}
		
		}else if (e.getSource() == againItem) {
			//����һ���µ������
			Random random = new Random();
			number = random.nextInt(10);
			jl3.setText("������һ��0-10֮�� ������");
			counter = 0;
		}else if(e.getSource() == exitItem){
			System.exit(0);
		}
	}

}
