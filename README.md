# 大数据181 刘显阳 2018310975  
## 一.实验目的  
**&ensp;&ensp;&ensp;&ensp;分析学生选课系统  
&ensp;&ensp;&ensp;&ensp;使用GUI窗体及其组件设计窗体界面  
&ensp;&ensp;&ensp;&ensp;完成学生选课过程业务逻辑编程  
&ensp;&ensp;&ensp;&ensp;基于文件保存并读取数据  
&ensp;&ensp;&ensp;&ensp;处理异常**  
## 二.实验要求  
**一、系统角色分析及类设计：  
&ensp;&ensp;&ensp;&ensp;系统角色：学生，教师，课程，学生选择课程。  
&ensp;&ensp;&ensp;&ensp;属性：学生（姓名、学号、性别、课程）；教师（姓名、编号、性别、所授课程）；课程（名称、编号、学分、地点、时间、授课教师）。  
&ensp;&ensp;&ensp;&ensp;定义每种角色人员的属性，及其操作方法。  
二、要求:  
&ensp;&ensp;&ensp;&ensp;1、 设计GUI窗体，支持学生注册、学生选课、学生退课、打印学生选课、教师信息、课程信息的操作。  
&ensp;&ensp;&ensp;&ensp;2、 基于事件模型对业务逻辑编程，实现在界面上支持上述操作。  
&ensp;&ensp;&ensp;&ensp;3、 针对操作过程中可能会出现的各种异常，做异常处理  
&ensp;&ensp;&ensp;&ensp;4、 基于输入/输出编程，支持学生、课程、教师等数据的读写操作。  
&ensp;&ensp;&ensp;&ensp;5、 基于Github.com提交实验，包括实验SRC源文件夹程序、README.MD实验报告文档。**
## 三.过程  
**&ensp;&ensp;&ensp;&ensp;首先分别创建学生、教师、课程类，并在构造函数中分别给学生的姓名，学号，性别，课程；教师的姓名，编号，性别，所授课程；课程的名称，编号，学分，地点，时间，授课教师赋值，以及创建读取属性，学生选课、退课的方法。**  
**&ensp;&ensp;&ensp;&ensp;然后创建登录窗体类，实例化学生，教师和课程对象，用JFrame前后总共创建4个窗口，分别为登录窗口，注册窗口，学生窗口，信息窗口。
&ensp;&ensp;&ensp;&ensp;登录窗口中用JPanel添加两个面板容器，利用BorderLayout将两个面板容器p1和p2分别放在center和south.p1中用JLable, JTextField创建文本（姓名，学号），输入框（获取姓名，学号）；p2中用JButton创建按钮（登录，注册，打印信息）。并在按钮（登录，注册，打印信息）上添加监听器分别创建新的学生窗口，注册窗口，信息窗口。其中登录按钮的监听器中，在创建学生窗口前先用输入流读取id.txt和name.txt文件中的存在的姓名和学号，并判断登录窗口中输入框内的学号和姓名是否在两个文件中存在，存在则创建学生窗口并提示信息登陆成功，不存在则提示信息姓名和学号错误。  
&ensp;&ensp;&ensp;&ensp;学生窗口中用输出流写入学生和课程的信息到student.txt和course.txt，添加三个面板容器分为north，center，south。north中添加课程名称文本和输入框，center中添加当前存在的课程信息文本，以及south中添加按钮选课，退课和打印列表，并在按钮上添加监听器。选课的监听器中判断学生是否已有选课和输入框中课程是否存在，已有选课则提示信息已有一门课程，课程存在则给学生添加相应课程并更新student.txt文件，不存在则提示信息选课失败。退课监听器中判断学生是否存在课程，不存在则提示信息没有可退课程，存在则给学生退选课程并更新student.txt文件提示退课成功。打印列表监听器中用输出流读取student.txt文件，并输出学生的信息。  
&ensp;&ensp;&ensp;&ensp;注册窗口中同样添加两个面板容器JPanel，分别在center和south。中间的添加姓名和学号的文本和相应的输入框JLable,JTextField；下部的添加注册按钮，并在按钮上添加监听器实现判断输入框中的信息，如果不为空则创建txt文件将要注册的姓名和学号分别写入id.txt和name.txt并提示注册成功；为空则提示信息不能为空。  
&ensp;&ensp;&ensp;&ensp;信息窗口中用输入流将教师和课程的信息写入文件teacher.txt和course.txt。创建按钮教师信息和课程信息，并在按钮上添加监听器用输出流实现分别读取并输出teacher.txt和course.txt文件内的信息。  
&ensp;&ensp;&ensp;&ensp;最后在main函数中实例化一个窗体。**  
## 四.流程图  
![image](https://github.com/1348372749/java5/blob/master/imag/1575730853(1).jpg)  
## 五.核心代码  
```javascript  
public Login(){
    JButton jb1=new JButton("登录");  
    p2.add(jb1);  
    JButton jb2=new JButton("注册");  
    p2.add(jb2);  
    JButton jb3=new JButton("打印信息");  
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
	                JFrame signin = new JFrame("学生界面");
	                signin.setVisible(true);
	                signin.setBounds(750,350,425,175);
	                signin.setLayout(new BorderLayout());  
                        JButton jb21=new JButton("选课");
		        jb21.setBounds(80, 80, 60, 18);
		        jb21.addActionListener(new ActionListener(){
		            public void actionPerformed(ActionEvent arg0) {
			        if(!ming.course.equals("none")){
		                    JOptionPane.showMessageDialog(null, "已存在一门课程");
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
				    JOptionPane.showMessageDialog(null, "选课成功");
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
                                    JOptionPane.showMessageDialog(null, "选课成功");
			        }
			        else{
			            JOptionPane.showMessageDialog(null, "选课失败");
			        }
			    }
		        });
		        JButton jb22=new JButton("退课");
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
				    JOptionPane.showMessageDialog(null, "退课成功");
			        }
			        else {
			            JOptionPane.showMessageDialog(null, "当前无选课");
			        }
			    }
		        });
		        JButton jb23=new JButton("打印列表");
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
                        JOptionPane.showMessageDialog(null, "登陆成功");
		    }
	            else {
		        JOptionPane.showMessageDialog(null, "姓名或学号错误");
		    }
	        }
	        else {
		    JOptionPane.showMessageDialog(null, "姓名和学号不允许为空");
	        }
	    }catch(IOException e) {
	        e.printStackTrace();
	    }
        }
    });  
    jb2.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent arg0) {  
            JButton jb11=new JButton("注册");
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
			    JOptionPane.showMessageDialog(null, "注册成功");
			    signup.setVisible(false);
		        }
			else {
			    JOptionPane.showMessageDialog(null, "姓名和学号不允许为空");
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
	    JButton jb31=new JButton("教师信息：");
	    p31.add(jb31);
	    JButton jb32=new JButton("课程信息：");
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
```  
# 六.运行结果  
![image](https://github.com/1348372749/java5/blob/master/imag/1575719239(1).jpg)  
![image](https://github.com/1348372749/java5/blob/master/imag/1575719148(1).jpg)  
# 七.编程感想  
**&ensp;&ensp;&ensp;&ensp;在本次实验中，涉及了本学期全部的知识，包括字符串的处理，创建窗体，异常处理，文件的输入输出。经过了本次实验，在对字符串进行处理，遍历时，学会了通过判断string.indexOF(str)的值是否是-1来判断str是否在s中存在；用equals（）判断两个字符串是否相同而不是==，==是判断两个字符串的存储位置是否相同的知识。在窗体中，深刻体会了代码的编写顺序会影响程序的执行顺序，先编写创建新的窗口还是提示信息在运行时是窗口和提示信息出现的顺序不同的。用string.length()是否等于0来判断输入是否为空的情况。文件的输入输出用异常处理结构包起来，输入文件路径时使用相对路径使程序在移植的时候更方便。**

