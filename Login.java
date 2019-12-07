package select;

import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.io.*;
public class Login extends JFrame{
	private static final long serialVersionUID = 1L;
	Student ming = new Student("ming","1001","male","none");
	Teacher wang = new Teacher("wang","2001","male","java");
	Course java =new Course("java","0001","2","class1","2019","wang");
	Course python =new Course("python","0002","2","class2","2019","li");
	public Login(){
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("��¼����");
		setBounds(700, 300, 250, 125);
		Container cp=getContentPane();
		cp.setLayout(new BorderLayout());
		JPanel p1=new JPanel();
		JPanel p2=new JPanel();
		p1.setLayout(new FlowLayout());
		p2.setLayout(new FlowLayout());
		cp.add(p1,BorderLayout.CENTER);
		cp.add(p2,BorderLayout.SOUTH);
		JLabel jl1=new JLabel("������");
		p1.add(jl1);
		final JTextField jl2=new JTextField(15);
		p1.add(jl2);
		JLabel jl3=new JLabel("ѧ�ţ�");
		p1.add(jl3);
		final JTextField jl4=new JTextField(15);
		p1.add(jl4);
		JButton jb1=new JButton("��¼");
		p2.add(jb1);
		JButton jb2=new JButton("ע��");
		p2.add(jb2);
		JButton jb3=new JButton("��ӡ��Ϣ");
		p2.add(jb3);
		jb1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				try{
					if(jl2.getText().trim().length()!=0&&jl4.getText().trim().length()!=0) {
						FileReader f1 = new FileReader("name.txt");
						BufferedReader in1 = new BufferedReader(f1);
						String name=in1.readLine();
						FileReader f2 = new FileReader("id.txt");
						BufferedReader in2 = new BufferedReader(f2);
						String id=in2.readLine();
						in1.close();
						in2.close();
						if(name.indexOf(jl2.getText().trim())!=-1&&id.indexOf(jl4.getText().trim())!=-1) {
							File file4 = new File("student.txt");
							Writer o1 = new FileWriter(file4);
						    String c1=ming.tostring();
						    o1.write(c1);
						    o1.close();
							JFrame signin = new JFrame("ѧ������");
							signin.setVisible(true);
							signin.setBounds(750,350,425,175);
							signin.setLayout(new BorderLayout());
							JPanel p21=new JPanel();
							JPanel p22=new JPanel();
							JPanel p23=new JPanel();
							p21.setLayout(new FlowLayout());
							p22.setLayout(new FlowLayout());
							p23.setLayout(new FlowLayout());
							signin.add(p21,BorderLayout.NORTH);
							signin.add(p22,BorderLayout.CENTER);
							signin.add(p23,BorderLayout.SOUTH);
							JLabel jl21=new JLabel("Ŀ��γ̣�");
							jl21.setBounds(0, 0, 20, 18);
							p21.add(jl21);
							final JTextField course=new JTextField(25);
							p21.add(course);
							JButton jb21=new JButton("ѡ��");
							jb21.setBounds(80, 80, 60, 18);
							jb21.addActionListener(new ActionListener(){
								public void actionPerformed(ActionEvent arg0) {
								    if(!ming.course.equals("none")){
								    	JOptionPane.showMessageDialog(null, "�Ѵ���һ�ſγ�");
								    }
									else if(course.getText().trim().equals("java")) {
										ming.SetCourse("java");
										try {
											File file4 = new File("student.txt");
										    Writer o1= new FileWriter(file4);
										    String c1=ming.tostring();
									        o1.write(c1);
									        o1.close();
										} catch (IOException e) {
											e.printStackTrace();
										}
										JOptionPane.showMessageDialog(null, "ѡ�γɹ�");
									}
									else if(course.getText().trim().equals("python")) {
										ming.SetCourse("python");
										try {
											File file4 = new File("student.txt");
										    Writer o1= new FileWriter(file4);
										    String c1=ming.tostring();
									        o1.write(c1);
									        o1.close();
										} catch (IOException e) {
											e.printStackTrace();
										}
										JOptionPane.showMessageDialog(null, "ѡ�γɹ�");
									}
									else{
										JOptionPane.showMessageDialog(null, "ѡ��ʧ��");
									}
								}
							});
							JButton jb22=new JButton("�˿�");
							jb22.setBounds(80, 80, 60, 18);
							jb22.addActionListener(new ActionListener(){
								public void actionPerformed(ActionEvent arg0) {
									if(!ming.course.equals("none")){
										ming.QuitCourse();
										try {
											File file4 = new File("student.txt");
										    Writer o1= new FileWriter(file4);
										    String c1=ming.tostring();
									        o1.write(c1);
									        o1.close();
										} catch (IOException e) {
											e.printStackTrace();
										}
										JOptionPane.showMessageDialog(null, "�˿γɹ�");
								    }
									else {
										JOptionPane.showMessageDialog(null, "��ǰ��ѡ��");
									}
								}
							});
							JButton jb23=new JButton("��ӡ�б�");
							jb23.setBounds(80, 80, 60, 18);
							jb23.addActionListener(new ActionListener(){
								public void actionPerformed(ActionEvent arg0) {
									try {
										FileReader f3= new FileReader("student.txt");
										BufferedReader in3 = new BufferedReader(f3);
										String stu=in3.readLine();
										in3.close();
										JOptionPane.showMessageDialog(null, stu);
									} catch (IOException e) {
										e.printStackTrace();
									}
									
								}
							});
							p23.add(jb21);
							p23.add(jb22);
							p23.add(jb23);
							JLabel jl5=new JLabel("��ǰ�γ̣�");
							File file3 = new File("course.txt");
							Writer o = new FileWriter(file3);
						    String c=java.tostring()+"-"+python.tostring();
						    o.write(c);
						    o.close();
							JLabel jl6=new JLabel(java.tostring());
							JLabel jl7=new JLabel(python.tostring());
							p22.add(jl5);
							p22.add(jl6);
							p22.add(jl7);
							JOptionPane.showMessageDialog(null, "��½�ɹ�");
						}
						else {
							JOptionPane.showMessageDialog(null, "������ѧ�Ŵ���");
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "������ѧ�Ų�����Ϊ��");
					}
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		});
		jb2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				JFrame signup = new JFrame("ע�ᴰ��");
				signup.setVisible(true);
				signup.setBounds(750,350,250,140);
				signup.setLayout(new BorderLayout());
				JPanel p11=new JPanel();
				JPanel p12=new JPanel();
				p11.setLayout(new FlowLayout());
				p12.setLayout(new FlowLayout());
				signup.add(p11,BorderLayout.CENTER);
				signup.add(p12,BorderLayout.SOUTH);
				JLabel jl11=new JLabel("������");
				p11.add(jl11);
				final JTextField jl12=new JTextField(15);
				p11.add(jl12);
				JLabel jl13=new JLabel("ѧ�ţ�");
				p11.add(jl13);
				final JTextField jl14=new JTextField(15);
				p11.add(jl14);
				JButton jb11=new JButton("ע��");
				p12.add(jb11);
				jb11.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent arg0){
						try {
							if(jl12.getText().trim().length()!=0&&jl14.getText().trim().length()!=0){
								String s1=jl12.getText().trim();
								String s2=jl14.getText().trim();
								FileWriter file1 = new FileWriter("name.txt",true);
					            BufferedWriter out1 = new BufferedWriter(file1);
							    out1.write(s1+"-");
							    FileWriter file2 = new FileWriter("id.txt",true);
					            BufferedWriter out2 = new BufferedWriter(file2);
							    out2.write(s2+"-");
							    out1.close();
							    out2.close();
							    JOptionPane.showMessageDialog(null, "ע��ɹ�");
							    signup.setVisible(false);
							}
							else {
								JOptionPane.showMessageDialog(null, "������ѧ�Ų�����Ϊ��");
							}
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		jb3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				try {
					File file31 = new File("teacher.txt");
					Writer o31 = new FileWriter(file31);
					String t=wang.tostring();
				    o31.write(t);
				    o31.close();
				    File file32 = new File("course.txt");
					Writer o32 = new FileWriter(file32);
				    String c32=java.tostring()+"-"+python.tostring();
				    o32.write(c32);
				    o32.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				JFrame inf = new JFrame("��Ϣ����");
				inf.setVisible(true);
				inf.setBounds(750,350,250,140);
				inf.setLayout(new BorderLayout());
				JPanel p31=new JPanel();
				p31.setLayout(new FlowLayout());
				inf.add(p31,BorderLayout.CENTER);
				JButton jb31=new JButton("��ʦ��Ϣ��");
				p31.add(jb31);
				JButton jb32=new JButton("�γ���Ϣ��");
				p31.add(jb32);
				jb31.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent arg0){
						try {
							FileReader f31= new FileReader("teacher.txt");
							BufferedReader in31 = new BufferedReader(f31);
							String teach=in31.readLine();
							in31.close();
							JOptionPane.showMessageDialog(null, teach);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				});
				jb32.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent arg0){
						try {
							FileReader f32= new FileReader("course.txt");
							BufferedReader in32 = new BufferedReader(f32);
							String cour=in32.readLine();
							cour=cour.substring(0,cour.indexOf("-"))+"\n"+cour.substring(cour.indexOf("-")+1);
							in32.close();
							JOptionPane.showMessageDialog(null, cour);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
	}
	public static void main(String[] args) {
		Login l = new Login ();
		l.setSize(250, 140);
		l.setVisible(true);
	}
}