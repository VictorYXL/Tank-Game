package com.TankGame;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.event.*;
import java.awt.*;

import javax.swing.*;

import java.io.*;
import java.net.MalformedURLException;
import java.util.*;
//���泣��
class Data
{
	public static int panelSizeX=800;
	public static int panelSizeY=720;
	public static int frameSizeX=800;
	public static int frameSizeY=750;	
	public static int frameLocationX=240;
	public static int frameLocationY=0;
	public static int TankSizeX=25;
	public static int TankSizeY=25;
	public static int TankSpeed=5;
	public static int BulletSpeed=5;
	public static int MyTankLife=3;
	public static int EnemyTankLife=5;
	public static int enemyTankSpeed=5;//˼��ʱ��
	public static int enemyTankThink=50;//˼��ʱ��
}
//������
public class TankGame extends JFrame implements ActionListener
{
	BattleGround bg=null;
	BeginningPanel sp=null;
	MapPanel mp=null; 
	static JMenuBar jmb=null;
	JMenu jm1=null;
	JMenu jm2=null;
	JMenu jm3=null;
	JMenu jm4=null;
	JMenuItem jmi1=null;
	JMenuItem jmi2=null;
	JMenuItem jmi3=null;
	JMenuItem jmi4=null;
	JMenuItem jmi5=null;
	JMenuItem jmi6=null;
	JMenuItem jmi7=null;
	JMenuItem jmi8=null;
	JMenuItem jmi9=null;
	JMenuItem jmi10=null;
	JMenuItem jmi11=null;
	JMenuItem jmi12=null;
	JMenuItem jmi13=null;
	JMenuItem jmi14=null;
	JMenuItem jmi15=null;
	String Map=null;
	public TankGame()
	{
		

		
		//���ò˵��ͳ�ʼ����
		sp=new BeginningPanel();
		sp.setSize(Data.panelSizeX,Data.panelSizeY);
		sp.setLocation(0, 50);
		sp.setBackground(Color.black);
		jmb=new JMenuBar();
		jmb.setSize(500,50);
		jmb.setBorder(null);
		this.add(sp);
		this.add(jmb);
		
		jmb.setVisible(true);
		jmb.setLayout(new FlowLayout(FlowLayout.LEFT));
		jm1=new JMenu("��Ϸ");
		jm2=new JMenu("����");
		jm3=new JMenu("��ͼ");
		jm4=new JMenu("����");
		jmb.add(jm1);
		jmb.add(jm2);
		jmb.add(jm3);
		jmb.add(jm4);
		jmi1=new JMenuItem("��ʼ��Ϸ");
		jmi2=new JMenuItem("��ͣ��Ϸ");
		jmi14=new JMenuItem("������Ϸ");
		jmi3=new JMenuItem("������Ϸ");
		jmi13=new JMenuItem("������Ϸ");
		jmi4=new JMenuItem("�˳���Ϸ");
		jm1.add(jmi1);
		jm1.add(jmi2);
		jm1.add(jmi14);
		jm1.add(jmi3);
		jm1.add(jmi13);
		jm1.add(jmi4);
		jm1.insertSeparator(1);
		jm1.insertSeparator(4);
		jm1.insertSeparator(7);
		jmi5=new JMenuItem("������Ϸ");
		jmi6=new JMenuItem("˫����Ϸ");
		jmi15=new JMenuItem("˫�˶�ս");
		jmi7=new JMenuItem("��");
		jmi8=new JMenuItem("�е�");
		jmi9=new JMenuItem("����");
		jm2.add(jmi5);
		jm2.add(jmi6);
		jm2.add(jmi15);
		jm2.add(jmi7);
		jm2.add(jmi8);
		jm2.add(jmi9);
		jm2.insertSeparator(3);
		jmi10=new JMenuItem("������ͼ(S)");
		jmi11=new JMenuItem("�򿪵�ͼ(O)");
		jm3.add(jmi10);
		jm3.add(jmi11);
		jmi12=new JMenuItem("�����ĵ�(H)");
		jm4.add(jmi12);
		
		//���ü���
		jmi1.addActionListener(this);
		jmi2.addActionListener(this);
		jmi3.addActionListener(this);
		jmi4.addActionListener(this);
		jmi5.addActionListener(this);
		jmi6.addActionListener(this);
		jmi7.addActionListener(this);
		jmi8.addActionListener(this);
		jmi9.addActionListener(this);
		jmi10.addActionListener(this);
		jmi11.addActionListener(this);
		jmi12.addActionListener(this);
		jmi13.addActionListener(this);
		jmi14.addActionListener(this);
		jmi15.addActionListener(this);
		jmi1.setActionCommand("Begin");
		jmi2.setActionCommand("Suspend");
		jmi3.setActionCommand("Save");
		jmi4.setActionCommand("Exit");
		jmi5.setActionCommand("Single");
		jmi6.setActionCommand("Double");
		jmi7.setActionCommand("Easy");
		jmi8.setActionCommand("Middle");
		jmi9.setActionCommand("Difficult");
		jmi10.setActionCommand("SetMap");
		jmi11.setActionCommand("OpenMap");
		jmi12.setActionCommand("Help");
		jmi13.setActionCommand("Import");
		jmi14.setActionCommand("Continue");
		jmi15.setActionCommand("OneOnOne");
		jmi2.setEnabled(false);
		jmi3.setEnabled(false);
		jmi14.setEnabled(false);
		jmi15.setEnabled(false);
		jmi5.setEnabled(false);
		jmi6.setEnabled(false);
		jmi7.setEnabled(false);
		jmi8.setEnabled(false);
		jmi9.setEnabled(false);
		//����JFrame
		this.setSize(Data.frameSizeX,Data.frameSizeY);
		this.setLocation(Data.frameLocationX, Data.frameLocationY);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
		this.setTitle("TankGame------����������л֧��");
		this.repaint();
		}
	public static void main(String[] args) {
		TankGame tankgame=new TankGame();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand()=="Begin")
			this.Begin(null);
		else if (e.getActionCommand()=="Suspend")
			this.Suspend();
		else if (e.getActionCommand()=="Continue")
			this.Continue();
		else if (e.getActionCommand()=="Save")
			this.Save();
		else if (e.getActionCommand()=="Import")
			this.Import();
		else if (e.getActionCommand()=="Exit")
			this.Exit();
		else if (e.getActionCommand()=="SetMap")
				this.SetMap();
		else if (e.getActionCommand()=="OpenMap")
				this.OpenMap();
		else if (e.getActionCommand()=="Help")
				this.Help();
	}
	//��ʼ��ť
	public void Begin(File map)
	{
		//������һ������
		if (bg!=null)
			bg.delete();
		//���������
		if (mp!=null)
			this.remove(mp);
		this.remove(sp);
		if (map==null)
			{
				int Judge=JOptionPane.showConfirmDialog(null, "�Ƿ�򿪵�ͼ","�򿪵�ͼ",JOptionPane.YES_NO_OPTION);
				if (Judge==JOptionPane.YES_OPTION)
				{
					FileDialog fd=new FileDialog(this,"�򿪵�ͼ");
					//fd.setFilenameFilter(new Filter());
					fd.setVisible(true);
					if (fd.getFile()==null)
						map=null;
					else map=new File ("Map/"+fd.getFile());
					this.Map=fd.getFile();
				}
			}
		//���������
		bg=new BattleGround(map);
		bg.setSize(Data.panelSizeX, Data.panelSizeY);
		bg.setLocation(0,0);
		jmb.setVisible(true);
		this.add(bg);
		Data.BulletSpeed=5;
		//��������߳�
		Thread t=new Thread(bg);
		t.start();
		this.setVisible(true);
		this.addKeyListener(bg.mytank);
		//�ָ���ť
		jmi2.setEnabled(true);
		jmi3.setEnabled(true);
		jmi14.setEnabled(true);
	}
	//��ͣ��ť
	public void Suspend()
	{
		//�Ա���̹����ͣ����
		if (bg!=null)
			bg.mytank.goon=false;
		//�Եз�̹��ֹͣ�ж�
		for (int i=0;i<=3;i++)
			if (bg!=null)
				bg.etank.get(i).goon=false;
		//��ͣ�ӵ�
		Data.BulletSpeed=0;
		this.setVisible(true);
	}
	//������ť
	public void Continue()
	{
		//�ָ��������ƶ�
		bg.mytank.goon=true;
		for (int i=0;i<=3;i++)
			bg.etank.get(i).goon=true;
		Data.BulletSpeed=5;
	}
	//���水ť
	public void Save()
	{
		int etankNum = 0;
		//��ͣ��Ϸ
		this.Suspend();
		//��¼����̹����
		for (int i=0;i<=3;i++)
			if (bg.etank.get(i).alive==true)
				etankNum=i+1;
		//�������ĵ�
		String filename=JOptionPane.showInputDialog(null,"�浵����","��Ϸ�浵",JOptionPane.QUESTION_MESSAGE);
		File file=new File ("Save/"+filename+".sav");
		try {
			PrintWriter Output=new PrintWriter(file);
			Output.println(this.Map);
			Output.println(bg.mytank.x+" "+bg.mytank.y+" "+bg.mytank.dir+" "+bg.mytank.Life);
			Output.println(etankNum);
			for (int i=0;i<etankNum;i++)
				Output.println(bg.etank.get(i).x+" "+bg.etank.get(i).y+" "+bg.etank.get(i).dir+" "+bg.etank.get(i).Life);
			Output.close(); 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//������Ϸ
		this.Continue();
	}
	//���밴ť
	public void Import()
	{
		int etankNum;
		this.Suspend();
		//�򿪴浵
        FileDialog fd=new FileDialog(this,"���ļ�");    
        fd.setVisible(true);                
		File file=new File ("Save/"+fd.getFile());
		if (fd.getFile()==null)
		{
			if (bg!=null)
				this.Continue();
			return;
		}
		try {
			if (JOptionPane.showConfirmDialog(null, "ȷ������", "����ȷ��", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
			{
				Scanner Input=new Scanner (file);
				Map=Input.nextLine();
				File map=new File ("Map/"+Map);
				if (bg==null)
				{
					this.Begin(map);
				}
				bg.mytank.x=Input.nextInt();
				bg.mytank.y=Input.nextInt();
				bg.mytank.dir=Input.nextInt();
				bg.mytank.Life=Input.nextInt();
				etankNum=Input.nextInt();
				for (int i=0;i<=3;i++)
				{
					bg.etank.get(i).x=Input.nextInt();
					bg.etank.get(i).y=Input.nextInt();
					bg.etank.get(i).dir=Input.nextInt();
					bg.etank.get(i).Life=Input.nextInt();
					if (bg.etank.get(i).Life<=0)
						bg.etank.get(i).alive=false;
					else bg.etank.get(i).alive=true;
				}
			//this.Continue();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			this.Continue();
			//e.printStackTrace();
		}
	}
	//�˳���ť
	public void Exit()
	{
		if (bg==null && mp==null)
			System.exit(0);
		this.Suspend();
		int Judge;
		if (mp!=null)
		{
			Judge=JOptionPane.showConfirmDialog(null, "�Ƿ񱣴�", "����ȷ��", JOptionPane.YES_NO_CANCEL_OPTION);
			if (Judge==JOptionPane.YES_OPTION)
			{
				mp.Save();
				System.exit(0);
			}
		else if (Judge==JOptionPane.NO_OPTION)
			System.exit(0);
		else if (Judge==JOptionPane.CANCEL_OPTION)
			return;
		}
		if (bg==null)
			System.exit(0);
		//�˳�ȷ��
		Judge=JOptionPane.showConfirmDialog(null, "�Ƿ񱣴�", "����ȷ��", JOptionPane.YES_NO_CANCEL_OPTION);
		if (Judge==JOptionPane.YES_OPTION)
			{
				this.Save();
				System.exit(0);
			}
		else if (Judge==JOptionPane.NO_OPTION)
			System.exit(0);
		else if (Judge==JOptionPane.CANCEL_OPTION)
			this.Continue();
		
	}
	//������ͼ��ť
	public void SetMap()
	{
		//��������Ϸ�ı�����ʾ
		if (bg!=null)
		{
			//System.out.print("1");
			this.Suspend();
			int Judge=JOptionPane.showConfirmDialog(null, "�Ƿ񱣴�", "����ȷ��", JOptionPane.YES_NO_CANCEL_OPTION);
			if (Judge==JOptionPane.CANCEL_OPTION)
				{
					this.Continue();
					return;
				}
			if (Judge==JOptionPane.YES_OPTION)
			{
				this.Save();
			}
			bg.delete();
			this.remove(bg);
			this.add(jmb);
			//bg=null;
			//this.removeAll();
		}
		if (sp!=null)
			this.remove(sp);
		this.setLayout(null);
		if (mp!=null)
			{
				int Judge=JOptionPane.showConfirmDialog(null, "�Ƿ񱣴�","����ȷ��",JOptionPane.YES_NO_CANCEL_OPTION);
				if (Judge==JOptionPane.YES_OPTION)
					mp.Save();
				else if (Judge==JOptionPane.CANCEL_OPTION)
					return;
				mp.steel.removeAllElements();
				mp.wall.removeAllElements();
				mp.river.removeAllElements();
				mp.ice.removeAllElements();
				mp.lawn.removeAllElements();
				mp.BI=null;
				mp.Pic=null;
				this.remove(mp);
			}
		mp=new MapPanel();
		mp.setSize(Data.panelSizeX, Data.panelSizeY);
		mp.setLocation(0,30);
		this.add(mp);
		this.setVisible(true);
		jmb.setVisible(true);
		this.repaint();
	}
	//�򿪵�ͼ
	public void OpenMap()
	{
		this.SetMap();
		//�򿪴浵
            FileDialog fd=new FileDialog(this,"�򿪵�ͼ");    
            fd.setVisible(true);                
            if (fd.getFile()==null)
            	return;
            this.Map=fd.getFile();
            File file=new File ("Map/"+fd.getFile());
			Scanner Input = null;
			try {
				Input = new Scanner (file);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (Input==null)
				return;
			mp.readFile(Input);
	}
	public void Help()
	{
		try {
			Runtime.getRuntime().exec("cmd /c \"ReadMe.txt\"");
			Runtime.getRuntime().exec("cmd /c \"BackMusic.mp3\"");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
class BeginningPanel extends JPanel 
{
	Draw draw=null;
	public BeginningPanel()
	{
		draw=new Draw();
	}
		
	public void paint(Graphics g)
	{
		super.paint(g);
		draw.drawTankGame(Data.panelSizeY/2, g);
	}
}
//��Ƶ�ͼ
class MapPanel extends JPanel implements ActionListener,MouseMotionListener,MouseListener
{
	JButton JB1=null;
	JButton JB2=null;
	JButton JB3=null;
	JButton JB4=null;
	JButton JB5=null;
	JButton JB6=null;
	JButton JB7=null;
	JButton JB8=null;
	JButton JB9=null;
	JButton JB10=null;
	ButtonGroup bgp=null;
	JRadioButton []JRB=null;
	Image BI=null;
	Draw draw=null;
	int Traverse;
	int Mx;
	int My;
	String Pic;
	Image im2=null;
	Vector<Steel> steel;
	Vector <Wall> wall;
	Vector <River> river;
	Vector <Ice> ice;
	Vector <Lawn> lawn;
	Vector <Boom> boom;
	public MapPanel ()
	{
		Pic=null;
		im2=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/Picture/BC.jpg"));
		this.addMouseMotionListener(this);
		this.addMouseListener(this);
		Traverse=0;
		draw=new Draw();
		//��ť��ʼ��
		JB1=new JButton("����");
		JB1.addActionListener(this);
		JB1.setActionCommand("Steel");
		JB2=new JButton("שǽ");
		JB2.addActionListener(this);
		JB2.setActionCommand("Wall");
		JB3=new JButton("����");
		JB3.addActionListener(this);
		JB3.setActionCommand("River");
		JB4=new JButton("����");
		JB4.addActionListener(this);
		JB4.setActionCommand("Wipe");
		JB5=new JButton("���");
		JB5.addActionListener(this);
		JB5.setActionCommand("Clean");
		JB6=new JButton("����");
		JB6.addActionListener(this);
		JB6.setActionCommand("Save");
		JB7=new JButton("�˳�");
		JB7.addActionListener(this);
		JB7.setActionCommand("Exit");
		JB8=new JButton("ѩ��");
		JB8.addActionListener(this);
		JB8.setActionCommand("Ice");
		JB9=new JButton("�ݵ�");
		JB9.addActionListener(this);
		JB9.setActionCommand("Lawn");
		JB10=new JButton("ը��");
		JB10.addActionListener(this);
		JB10.setActionCommand("Boom");		
		JRB=new JRadioButton[6];
		bgp=new ButtonGroup();
		//�ϰ��Ｏ�ϳ�ʼ��
		steel=new Vector<Steel>();
		wall=new Vector<Wall>();
		river=new Vector<River>();
		ice=new Vector<Ice>();
		lawn=new Vector<Lawn>();
		boom=new Vector<Boom>();
		Mx=-1;
		My=-1;
		for (int i=0;i<=5;i++)
			{
				JRB[i]=new JRadioButton("����"+(i+1),false);
				JRB[i].addActionListener(this);
				JRB[i].setActionCommand("Pic"+(i+1));
				this.add(JRB[i]);
				bgp.add(JRB[i]);
			}
		this.add(JB1);
		this.add(JB2);
		this.add(JB3);
		this.add(JB4);
		this.add(JB5);
		this.add(JB6);
		this.add(JB7);
		this.add(JB8);
		this.add(JB9);
		this.add(JB10);
		this.repaint();
	}
	public void paint(Graphics g)
	{
		super.paint(g);
		//���ø��ť��
		JB1.setLocation(50,50);
		JB2.setLocation(170,50);
		JB3.setLocation(290,50);
		JB8.setLocation(410,50);
		JB9.setLocation(530,50);
		JB10.setLocation(650,50);
		JB4.setLocation(50,10);
		JB5.setLocation(250,10);
		JB6.setLocation(450,10);
		JB7.setLocation(650,10);
		JRB[0].setLocation(120,620);
		JRB[1].setLocation(280,620);
		JRB[2].setLocation(440,620);
		JRB[3].setLocation(600,620);
		JRB[4].setLocation(120,660);
		JRB[5].setLocation(600,660);
		this.add(JB1);
		this.add(JB2);
		this.add(JB3);
		this.add(JB4);
		this.add(JB5);
		this.add(JB6);
		this.add(JB7);
		this.add(JB8);
		//�����ϰ���������ƶ���Ч��
		if (Traverse!=0 && Mx>0 && My>0)
		{
			switch(Traverse)
			{
			case 1:
				draw.drawSteel(g, this.Mx-20, this.My-20);
				break;				
			case 2:
				draw.drawWall(g, this.Mx-25, this.My-25,new boolean []{true,true,true,true,true});
				break;
			case 3:
				draw.drawRiver(g, this.Mx-32, this.My-16);
				break;
			case 4:
				draw.drawIce(g, this.Mx-40, this.My-40);
				break;
			case 5:
				draw.drawLawn(g, this.Mx-24, this.My-24);
				break;
			case 6:
				draw.drawCrossing(g, this.Mx-10, this.My-10);
				break;		
			case 7:
				draw.drawBoom(g, this.Mx-12, this.My-12);
				break;					
			}
		}
//		//���Ѿ���ƶ���ϰ���
		draw.drawMap(g, steel, wall, river, ice, lawn,boom);
	}
	//���ñ���
	public void paintComponent(Graphics g) 
	{    
		super.paintComponent(g);   		
		g.drawImage(BI, 0, 0, Data.panelSizeX, Data.panelSizeY,this);
		g.drawImage(im2, Data.panelSizeX/2-25, Data.panelSizeY-75, 50, 50,this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		//��Ӧ��ת���ϰ���
		//System.out.print(e.getActionCommand());
		if (e.getActionCommand().contains("Pic"))
			{
				BI=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/Picture/"+e.getActionCommand()+".jpg"));
				Pic=e.getActionCommand();
			}
		if (e.getActionCommand()=="Steel")
			Traverse=1;
		else if (e.getActionCommand()=="Wall")
			Traverse=2;
		else if (e.getActionCommand()=="River")
			Traverse=3;
		else if (e.getActionCommand()=="Ice")
			Traverse=4;
		else if (e.getActionCommand()=="Lawn")
			Traverse=5;
		else if (e.getActionCommand()=="Clean")
		{
			this.Clean();
		}
		else if (e.getActionCommand()=="Wipe")
			Traverse=6;
		else if (e.getActionCommand()=="Boom")
			Traverse=7;
		else if (e.getActionCommand()=="Save")
			this.Save();
		else if (e.getActionCommand()=="Exit")
			this.Exit();
		this.repaint();
	}
	public void readFile(Scanner Input)
	{
		//System.out.print(Input.next());
		this.Pic=Input.next();
		if (Pic!="null")
			BI=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/Picture/"+Pic+".jpg"));
		int Num=Input.nextInt();
		for (int i=0;i<Num;i++)
		{
			Steel s=new Steel(Input.nextInt(),Input.nextInt());
			steel.add(s);
		}
		Num=Input.nextInt();
		for (int i=0;i<Num;i++)
		{
			Wall s=new Wall(Input.nextInt(),Input.nextInt());
			wall.add(s);
		}
		Num=Input.nextInt();
		for (int i=0;i<Num;i++)
		{
			River s=new River(Input.nextInt(),Input.nextInt());
			river.add(s);
		}
		Num=Input.nextInt();
		for (int i=0;i<Num;i++)
		{
			Ice s=new Ice(Input.nextInt(),Input.nextInt());
			ice.add(s);
		}
		Num=Input.nextInt();
		for (int i=0;i<Num;i++)
		{
			Lawn s=new Lawn(Input.nextInt(),Input.nextInt());
			lawn.add(s);
		}
		Num=Input.nextInt();
		for (int i=0;i<Num;i++)
		{
			Boom b=new Boom(Input.nextInt(),Input.nextInt());
			boom.add(b);
		}
	}
	public void Clean()
	{
		//System.out.print("Clean");
		int Judge=JOptionPane.showConfirmDialog(null, "�Ƿ����","���ȷ��",JOptionPane.YES_NO_OPTION);
		if (Judge==JOptionPane.YES_OPTION)
			{
			BI=null;
			steel.removeAllElements();
			wall.removeAllElements();
			river.removeAllElements();
			ice.removeAllElements();
			lawn.removeAllElements();
			}
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		if (Traverse!=0)
		{
			this.Mx=e.getX();
			this.My=e.getY();
		}
		this.repaint();
		
	}
	@Override
	public void mouseDragged(MouseEvent e) {
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		this.Mx=e.getX();
		this.My=e.getY();
		int k;
		switch(Traverse)
		{
		case 1:
			//if (Judge.judgeReclosing(Mx-20,My-20,40,40,steel,wall,river,ice,lawn,boom)==0)
				{
					Steel s=new Steel(Mx-20,My-20);
					steel.add(s);
				}
			break;
		case 2:
			//if (Judge.judgeReclosing(Mx-25,My-25,50,50,steel,wall,river,ice,lawn,boom)==0)
			{
				Wall w=new Wall(Mx-25,My-25);
				wall.add(w);
			}
			break;
		case 3:
			//if (Judge.judgeReclosing(Mx-32,My-16,32,16,steel,wall,river,ice,lawn,boom)==0)
			{
				River r=new River(Mx-32,My-16);
				river.add(r);
			}
			break;
		case 4:
			//if (Judge.judgeReclosing(Mx-40,My-40,30,30,steel,wall,river,ice,lawn,boom)==0)
			{
				Ice i=new Ice(Mx-40,My-40);
				ice.add(i);
			}
			break;
		case 5:
			//if (Judge.judgeReclosing(Mx-24,My-24,48,48,steel,wall,river,ice,lawn,boom)==0)
			{
				Lawn l=new Lawn(Mx-24,My-24);
				lawn.add(l);
			}
			break;
		case 6:
			if ((k=Judge.judgeReclosing(Mx-10,My-10,20,20,steel,wall,river,ice,lawn,boom))!=0)
			{
				switch ((int)(k/1000))
				{
				case 1:
					steel.remove(k%1000);
					break;
				case 2:
					wall.remove(k%1000);
					break;
				case 3:
					//System.out.print("SB");
					river.remove(k%1000);
					break;
				case 4:
					ice.remove(k%1000);
					break;
				case 5:
					lawn.remove(k%1000);
					break;
				case 7:
					boom.remove(k%1000);
					break;
				}
				break;
			}
		case 7:
			//if (Judge.judgeReclosing(Mx-14,My-14,25,28,steel,wall,river,ice,lawn,boom)==0)
			{
				Boom b=new Boom(Mx-14,My-14);
				boom.add(b);
			}
			break;
		}
		this.repaint();
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	public void Save ()
	{
		String filename=JOptionPane.showInputDialog(null,"��ͼ����","�����ͼ",JOptionPane.QUESTION_MESSAGE);
		File file=new File ("Map/"+filename+".map");
		try {
			if (filename==null)
				return;
			PrintWriter Output=new PrintWriter (file);
			Output.println(this.Pic);
			Output.println(steel.size());
			for (int i=0;i<steel.size();i++)
				Output.println(steel.get(i).x+" "+steel.get(i).y);
			Output.println(wall.size());
			for (int i=0;i<wall.size();i++)
				Output.println(wall.get(i).x+" "+wall.get(i).y);
			Output.println(river.size());
			for (int i=0;i<river.size();i++)
				Output.println(river.get(i).x+" "+river.get(i).y);
			Output.println(ice.size());
			for (int i=0;i<ice.size();i++)
				Output.println(ice.get(i).x+" "+ice.get(i).y);
			Output.println(lawn.size());
			for (int i=0;i<lawn.size();i++)
				Output.println(lawn.get(i).x+" "+lawn.get(i).y);
			Output.println(boom.size());
			for (int i=0;i<boom.size();i++)
				Output.println(boom.get(i).x+" "+boom.get(i).y);			
			Output.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void Exit ()
	{
		int Judge=JOptionPane.showConfirmDialog(null, "�Ƿ񱣴�", "����ȷ��", JOptionPane.YES_NO_CANCEL_OPTION);
		if (Judge==JOptionPane.YES_OPTION)
		{
			this.Save();
			this.Clean();
		}
		else if (Judge==JOptionPane.NO_OPTION)
			this.Clean();
		else if (Judge==JOptionPane.CANCEL_OPTION)
			return;
	}
}

//ս�����
class BattleGround extends JPanel implements Runnable
{	
	//��������
	Music music=null;
	Draw draw=null;
	MyTank mytank=null;
	boolean con=true;
	Vector <EnemyTank> etank=new Vector<EnemyTank>();
	static Vector <Steel>steel=new Vector<Steel>();
	static Vector <Wall>wall=new Vector<Wall>();
	static Vector <River>river=new Vector<River>();
	static Vector <Ice>ice=new Vector<Ice>();
	static Vector <Lawn>lawn=new Vector<Lawn>();
	static Vector <Boom>boom=new Vector<Boom>();
	Thread Te=null;
	Image im1=null;
	Image im2=null;
	Image tankDead=null;
	int []deathTankX=null;
	int []deathTankY=null;
	int k;
	int []deathData=new int[4];{
	for (int i=0;i<=3;i++)
		deathData[i]=0;}
	public BattleGround(File map)
	{
		this.addMap(map);
		this.con=true;
		deathTankX=new int [5];
		deathTankY=new int [5];
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.add(TankGame.jmb);
		im2=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/Picture/BC.jpg"));
		tankDead=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/Picture/KO.jpg"));
		//�����ҷ�̹��
		mytank=new MyTank();
		//�����з�̹��
		for (int i=0;i<=3;i++)
		{
			EnemyTank et=new EnemyTank (i);
			etank.add(et);
		}
		//������ͼ����
		draw=new Draw();
		for (int i=0;i<=3;i++)
			{
			//�����з�̹���߳�
			Te=new Thread(etank.get(i));
			Te.start();
			}
		music=new Music();
		music.backMusic();
	}
	public void addMap(File map)
	{
		if (map!=null)
		{
			Scanner Input;
			try {
				Input = new Scanner(map);
				String Pic=Input.nextLine();
				if (!Pic.equals("null"))
					im1=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/Picture/"+Pic+".jpg"));
				else im1=null;
				int Num=Input.nextInt();
				for (int i=0;i<Num;i++)
				{
					Steel s=new Steel(Input.nextInt(),Input.nextInt());
					steel.add(s);
				}
				Num=Input.nextInt();
				for (int i=0;i<Num;i++)
				{
					Wall s=new Wall(Input.nextInt(),Input.nextInt());
					wall.add(s);
				}
				Num=Input.nextInt();
				for (int i=0;i<Num;i++)
				{
					River s=new River(Input.nextInt(),Input.nextInt());
					river.add(s);
				}
				Num=Input.nextInt();
				for (int i=0;i<Num;i++)
				{
					Ice s=new Ice(Input.nextInt(),Input.nextInt());
					ice.add(s);
				}
				Num=Input.nextInt();
				for (int i=0;i<Num;i++)
				{
					Lawn s=new Lawn(Input.nextInt(),Input.nextInt());
					lawn.add(s);
				}
				Num=Input.nextInt();
				for (int i=0;i<Num;i++)
				{
					Boom b=new Boom(Input.nextInt(),Input.nextInt());
					boom.add(b);
				}	
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void paint(Graphics g)
	{
		super.paint(g);
		draw.drawLive(etank.get(0).Life,etank.get(1).Life,etank.get(2).Life,etank.get(3).Life,mytank.Life,g);
		//���Ƶз�̹��
		for (int i=0;i<=3;i++)
			if (etank!=null)
			if (etank.get(i).alive==true)
				switch(etank.get(i).dir)
				{
				case 1:
					draw.drawTankUp(etank.get(i).x,etank.get(i).y,g,etank.get(i).color);
					break;
				case 2:
					draw.drawTankRight(etank.get(i).x,etank.get(i).y,g,etank.get(i).color);
					break;
				case 3:
					draw.drawTankDown(etank.get(i).x,etank.get(i).y,g,etank.get(i).color);
					break;
				case 4:	
					draw.drawTankLeft(etank.get(i).x,etank.get(i).y,g,etank.get(i).color);
					break; 
				}
			else {
				deathData[i]++;
				//etank.get(i).Life--;
				deathTankX[i]=etank.get(i).x;
				deathTankY[i]=etank.get(i).y;
			}
		//�����ҷ�̹��
		if (this.con==true && mytank.alive==true)
			switch (mytank.dir)
			{
			case 1:
				draw.drawTankUp(mytank.x,mytank.y,g,mytank.color);
				break;
			case 2:
				draw.drawTankRight(mytank.x,mytank.y,g,mytank.color);
				break;
			case 3:
				draw.drawTankDown(mytank.x,mytank.y,g,mytank.color);
				break;
			case 4:
				draw.drawTankLeft(mytank.x,mytank.y,g,mytank.color);
				break;
			}
		//���Ƶ�ͼ
		if (this.con==true)
			draw.drawMap(g, steel, wall, river, ice, lawn,boom);
		//�����ӵ����ж�����
		for (int i=0;i<Tank.bullet.size();i++)
			{
				draw.drawBullet(Tank.bullet.get(i).x, Tank.bullet.get(i).y, g);
				k=-4;
				k=Tank.bullet.get(i).judgeHit(etank,mytank,steel,wall);
				if (k==4 || k==5)
				{
					Tank.bullet.remove(i);
					continue;
				}
				if (k>=0 && k<=3)
				{
					etank.get(k).alive=false;
					deathData[k]++;
					etank.get(k).Life--;
					deathTankX[k]=etank.get(k).x;
					deathTankY[k]=etank.get(k).y;
					Tank.bullet.get(i).alive=false;
				}
				//�ҷ�̹�˱�����
				if (k==-1 || mytank.alive==false)
				{
					mytank.Life--;
					if (mytank.Life>0)
						mytank.reLive();
					if (mytank.Life<=0)
					{
						for (int j=0;j<=3;j++)
							etank.get(j).alive=false;
						for (int j=0;j<Tank.bullet.size();j++)
							Tank.bullet.get(j).alive=false;
						this.con=false;					
						g.drawImage(tankDead,mytank.x-12, mytank.y-12, Data.TankSizeX*2, Data.TankSizeY*2,this);
						draw.drawGameOver(1,g);
					}
					break;
				}
				//�з�̹�˱�ȫ������
				else if (this.con==true && etank.get(0).Life<=0 && etank.get(1).Life<=0 && etank.get(2).Life<=0 && etank.get(3).Life<=0)
					{
						for (int j=0;j<=3;j++)
							etank.get(j).alive=false;
						for (int j=0;j<Tank.bullet.size();j++)
							Tank.bullet.get(j).alive=false;
						this.con=false;	
						draw.drawWin(g);
						mytank.alive=false;
						break;
					}
				//���ӱ�����
				else if (k==-3)
				{
					for (int j=0;j<=3;j++)
						etank.get(j).alive=false;
					g.drawImage(tankDead,Data.panelSizeX/2-25, Data.panelSizeY,50, 50,this);
					for (int j=0;j<Tank.bullet.size();j++)
						Tank.bullet.get(j).alive=false;
					this.con=false;	
					draw.drawGameOver(2,g);
					break;
				}
				if (Tank.bullet.get(i).alive==false)
					Tank.bullet.remove(i);
			}
		//���Ƶ�������Ч�����жϸ���
		for (int i=0;i<=3;i++)
		{
			if (deathData[i]!=0)
			{
				//System.out.println(x[i]+" "+y[i]);
				g.drawImage(tankDead,deathTankX[i]-12, deathTankY[i]-12, Data.TankSizeX*2, Data.TankSizeY*2,this);
				deathData[i]++;
				if (deathData[i]>=90)
					{
						deathData[i]=0;
						if (etank.get(i).Life<=0)
							continue;
						etank.get(i).reLive(i);
						Thread t=new Thread(etank.get(i));
						t.start();
					}
			}
		}
	}
	//ɾ��
	public void delete()
	{
		mytank.alive=false;
		etank.get(0).alive=false;
		etank.get(1).alive=false;
		etank.get(2).alive=false;
		etank.get(3).alive=false;
		this.con=false;
		BattleGround.steel.removeAllElements();
		BattleGround.wall.removeAllElements();
		BattleGround.river.removeAllElements();
		BattleGround.ice.removeAllElements();
		BattleGround.lawn.removeAllElements();
		BattleGround.boom.removeAllElements();
	}
	//�̵߳����ݣ�ˢ��
	public void run() {
		while (this.con)
		{
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (this.con==true)
				repaint();
		}
		
	}
	public void paintComponent(Graphics g) 
	{    
		super.paintComponent(g);
		if (im1!=null)
			g.drawImage(im1, 0, 50, Data.panelSizeX, Data.panelSizeY,this);
		g.drawImage(im2, Data.panelSizeX/2-25, Data.panelSizeY-50, 50, 50,this);
	}
}
//̹����
class Tank                                                             
{
	//̹�˵ĸ�������
	int x;
	int y;
	int Life;
	int dir;
	int speed;
	int size;
	int color;
	boolean alive;
	boolean goon;
	//�����ӵ�����
	static Vector <Bullet> bullet=new Vector <Bullet>();
	Bullet bu=null;
	//̹�˵����������ƶ���Ϊ
	public void goUp()
	{
		this.dir=1;
		int k=Judge.judgeReclosing(this.x, this.y-this.speed, Data.TankSizeX, Data.TankSizeX, BattleGround.steel, BattleGround.wall, BattleGround.river, BattleGround.ice, BattleGround.lawn, BattleGround.boom);
		if ((int)(k/1000)<=3 && (int)(k/1000)>=1)
			return;
		if ((int)(k/1000)==4)
			this.speed=Data.TankSpeed*3;
		else this.speed=Data.TankSpeed;
		if ((int)(k/1000)==7)
			
		{
			this.Life--;
			this.alive=false;
		}
		this.y-=this.speed;
		if (this.y<50)
			this.y=50;
	}
	public void goRight()
	{
		this.dir=2;
		int k=Judge.judgeReclosing(this.x+this.speed, this.y, Data.TankSizeX, Data.TankSizeX, BattleGround.steel, BattleGround.wall, BattleGround.river, BattleGround.ice, BattleGround.lawn, BattleGround.boom);
		if ((int)(k/1000)<=3 && (int)(k/1000)>=1)
			return;
		if ((int)(k/1000)==4)
			this.speed=Data.TankSpeed*3;
		else this.speed=Data.TankSpeed;
		if ((int)(k/1000)==7)
		{
			this.Life--;
			this.alive=false;
		}
		this.x+=this.speed;
		if (this.x>Data.panelSizeX-Data.TankSizeX-20)
			this.x=Data.panelSizeX-Data.TankSizeX-20;
	}
	public void goDown()
	{
		this.dir=3;
		int k=Judge.judgeReclosing(this.x, this.y+this.speed, Data.TankSizeX, Data.TankSizeX, BattleGround.steel, BattleGround.wall, BattleGround.river, BattleGround.ice, BattleGround.lawn, BattleGround.boom);
		if ((int)(k/1000)<=3 && (int)(k/1000)>=1)
			return;
		if ((int)(k/1000)==4)
			this.speed=Data.TankSpeed*3;
		else this.speed=Data.TankSpeed;
		if ((int)(k/1000)==7)
			{
			
				this.Life--;
				this.alive=false;
			}
		this.y+=this.speed;
		if (this.y>Data.panelSizeY-Data.TankSizeY-20)
			this.y=Data.panelSizeY-Data.TankSizeY-20;
	}
	public void goLeft()
	{
		this.dir=4;
		int k=Judge.judgeReclosing(this.x-this.speed, this.y, Data.TankSizeX, Data.TankSizeX, BattleGround.steel, BattleGround.wall, BattleGround.river, BattleGround.ice, BattleGround.lawn, BattleGround.boom);
		if ((int)(k/1000)<=3 && (int)(k/1000)>=1)
			return;
		if ((int)(k/1000)==4)
			this.speed=Data.TankSpeed*3;
		else this.speed=Data.TankSpeed;
		if ((int)(k/1000)==7)
		{
			this.Life--;
			this.alive=false;
		}
		this.x-=this.speed;
		if (this.x<0)
			this.x=0;
	}
	public void goAsDir()
	{
		switch (this.dir)
		{
		case 1:
			this.goUp();
			break;
		case 2:
			this.goRight();
			break;
		case 3:
			this.goDown();
			break;
		case 4:
			this.goLeft();
			break;			
		}
	}
	//����ӵ�����Ϊ
	public void Shoot(boolean from)
	{
		//Music.Bullet();
		bu=new Bullet(this.x,this.y,this.dir,from);
		bullet.add(bu);
		Thread t=new Thread(bu);
		t.start();
	//	Tank.bulletNum++;
	}
}
//�ҷ�̹���࣬�̳�̹���ಢ���ü���
class MyTank extends Tank implements KeyListener
{
	//�ҷ�̹�˳�ʼ��
	public MyTank ()
	{
		this.Life=Data.MyTankLife;
		this.goon=true;
		this.alive=true;
		this.x=240;
		this.y=650;
		this.dir=1;
		this.speed=Data.TankSpeed;
		this.color=0;
	}

	public void reLive()
	{
		this.alive=true;
		this.dir=1;
		this.speed=5;
		this.color=0;
		this.x=240;
		this.y=650;;
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	//�Լ��̰����ķ�Ӧ
	public void keyPressed(KeyEvent e) {
			if (this.alive==false)
				return;
			if (this.goon=false)
				return;
			switch (e.getKeyCode())
			{
			case KeyEvent.VK_W: 
				this.goUp();
				break;
			case KeyEvent.VK_D: 
				this.goRight();
				break;
			case KeyEvent.VK_S: 
				this.goDown();
				break;
			case KeyEvent.VK_A: 
				this.goLeft();
				break;
			case KeyEvent.VK_J:
				this.Shoot(true);
				break;
			case KeyEvent.VK_K:
				System.out.println(this.x+" "+this.y);
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
//�з�̹���࣬�̳�̹���ಢ�����߳�
class EnemyTank extends Tank implements Runnable
{
	//�з�̹�˳�ʼ��
	public EnemyTank(int Num)
	{
		this.goon=true;
		this.Life=Data.EnemyTankLife;
		this.alive=true;
		this.dir=3;
		this.speed=Data.enemyTankSpeed;
		this.color=1;
		switch (Num)
		{
		case 0:
			this.x=75;
			this.y=20;
			break;
		case 1:
			this.x=275;
			this.y=20;
			break;
		case 2:
			this.x=475;
			this.y=20;
			break;
		case 3:
			this.x=675;
			this.y=20;
			break;		
		}
	}
	public void reLive(int Num)
	{
		this.alive=true;
		this.dir=3;
		this.speed=5;
		this.color=1;
		switch (Num)
		{
		case 0:
			this.x=75;
			this.y=70;
			break;
		case 1:
			this.x=275;
			this.y=70;
			break;
		case 2:
			this.x=475;
			this.y=70;
			break;
		case 3:
			this.x=675;
			this.y=70;
			break;		
		}
	}
	//�߳����ݣ���������������з�̹����Ϊ
	public void run()
	{
		int move;
		while (this.alive)
			{
				if (this.goon==false)
					try {
						Thread.sleep(Data.enemyTankThink);
						continue;
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					};
				synchronized(this){
					try {
						Thread.sleep(Data.enemyTankThink);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				move=(int) (Math.random()*30);
				if (move<=20)
					this.goAsDir();
				else if (move<=21)
						if (this.speed!=0)	
							this.Shoot(false);
				switch (move)
				{
				case 26:
					this.goUp();
					this.dir=1;
					break;
				case 27:
					this.goRight();
					this.dir=2;
					break;
				case 28:
					this.goDown();
					this.dir=3;
					break;
				case 29:
					this.goLeft();
					this.dir=4;
					break;
				}
			}
		}
	}
}
//�ӵ��࣬�����߳�
class Bullet implements Runnable 
{
	int x;
	int y;
	int dir;
	boolean from;
	boolean alive;
	//��ʼ����������
	public Bullet(int x,int y,int dir,boolean from)
	{
		this.alive=true;
		this.from=from;
		this.dir=dir;
		switch (dir)
		{
		case 1:
			this.x=x+15;
			this.y=y-5;
			break;
		case 2:
			this.x=x+35;
			this.y=y+17;
			break;
		case 3:
			this.x=x+15;
			this.y=y+35;
			break;
		case 4:
			this.x=x-5;
			this.y=y+17;
			break;
		}
	}
	//���ݷ������ǰ��
	public void go()
	{
		switch (this.dir)
		{
		case 1:
			this.y-=Data.BulletSpeed;
			break;
		case 2:
			this.x+=Data.BulletSpeed;
			break;
		case 3:
			this.y+=Data.BulletSpeed;
			break;
		case 4:
			this.x-=Data.BulletSpeed;
			break;
		}
	}
	/*
	 �ж��Ƿ�����
	 0,1,2,3��ʾ����̹��
	 -1(-2)��ʾ�Լ�̹��
	 -3��ʾ����
	 -4��ʾδ����
	 4���ϱ�ʾǽ��δд��
	 */
	public int judgeHit(Vector <EnemyTank> etank,MyTank mytank,Vector <Steel> steel,Vector <Wall> wall)
	{
		if (this.from==true)
			//�ж��ҷ��Ƿ���ез�
			for (int i=0;i<=3;i++)
			{
				if (etank.get(i).alive==false)
					continue;
				int tx,ty;
				tx=etank.get(i).x;
				ty=etank.get(i).y;
				if (this.x>=tx && this.x<=tx+Data.TankSizeX && this.y>=ty && this.y<=ty+Data.TankSizeY)
					return i;
				if (this.x>=tx && this.x<=tx+Data.TankSizeX && this.y>=ty && this.y<=ty-Data.TankSizeY)
					return i;
				if (this.x>=tx && this.x<=tx-Data.TankSizeX && this.y>=ty && this.y<=ty+Data.TankSizeY)
					return i;
				if (this.x>=tx && this.x<=tx-Data.TankSizeX && this.y>=ty && this.y<=ty-Data.TankSizeY)
					return i;			
			}
		else {
			int tx,ty;
			if (mytank==null)
				return -4;
			tx=mytank.x;
			ty=mytank.y;
			if (this.x>=tx && this.x<=tx+Data.TankSizeX && this.y>=ty && this.y<=ty+Data.TankSizeY)
				return -1;
			if (this.x>=tx && this.x<=tx+Data.TankSizeX && this.y>=ty && this.y<=ty-Data.TankSizeY)
				return -1;
			if (this.x>=tx && this.x<=tx-Data.TankSizeX && this.y>=ty && this.y<=ty+Data.TankSizeY)
				return -1;
			if (this.x>=tx && this.x<=tx-Data.TankSizeX && this.y>=ty && this.y<=ty-Data.TankSizeY)
				return -1;
			if (this.x>=Data.panelSizeX/2-25 && this.x<=Data.panelSizeX/2+25 && this.y>=Data.panelSizeY && this.y<=Data.panelSizeY)
				return -3;
		}
		for (int i=0;i<steel.size();i++)
		{
			int tx,ty;
			tx=steel.get(i).x;
			ty=steel.get(i).y;
			if (this.x>=tx && this.x<=tx+46 && this.y>=ty && this.y<=ty+46)
				return 4;
			if (this.x>=tx && this.x<=tx+46 && this.y>=ty && this.y<=ty-46)
				return 4;
			if (this.x>=tx && this.x<=tx-46 && this.y>=ty && this.y<=ty+46)
				return 4;
			if (this.x>=tx && this.x<=tx-46 && this.y>=ty && this.y<=ty-46)
				return 4;	
		}
		for (int i=0;i<wall.size();i++)
		{
			int tx,ty;
			tx=wall.get(i).x;
			ty=wall.get(i).y;
			if (this.x>=tx && this.x<=tx+50 && this.y>=ty && this.y<=ty+50)
				{
					int j;
					for (j=0;j<=4;j++)
						if (wall.get(i).alive[j]==true)
						{
							wall.get(i).alive[j]=false;
							break;
						}
					if (j>=5)
						wall.remove(i);
					return 5;
				}
			if (this.x>=tx && this.x<=tx+50 && this.y>=ty && this.y<=ty-50)
			{
				int j;
				for (j=4;j>=0;j--)
					if (wall.get(i).alive[j]==true)
					{
						wall.get(i).alive[j]=false;
						break;
					}
				if (j<0)
					wall.remove(i);
				return 5;
			}
			if (this.x>=tx && this.x<=tx-50 && this.y>=ty && this.y<=ty+50)
			{
				int j;
				for (j=4;j>=0;j--)
					if (wall.get(i).alive[j]==true)
					{
						wall.get(i).alive[j]=false;
						break;
					}
				if (j<0)
					wall.remove(i);
				return 5;
			}
			if (this.x>=tx && this.x<=tx-50 && this.y>=ty && this.y<=ty-50)
				{
					int j;
					for (j=0;j<=4;j++)
						if (wall.get(i).alive[j]==true)
						{
							wall.get(i).alive[j]=false;
							break;
						}
					if (j>=5)
						wall.remove(i);
					return 5;
				}
		}
		return -4;
	}
	@Override
	public void run() {
		
		while (this.alive)
		{
			synchronized(this)
				{
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					go();
					if (x<0 || y<50 || x>Data.panelSizeX || y>Data.panelSizeY)
					{
						alive=false;
						break;
					}
				}
		}
	}
}
//��ͼ��
class Draw 
{
	//��̹����������
	public void drawTankUp(int x,int y,Graphics g,int c)
	{
		SetColor(g,c);
		g.fill3DRect(x, y+7, 5, 25,false);
		g.fill3DRect(x+5, y+12, 15, 15,false);
		g.fill3DRect(x+20, y+7, 5, 25,false);
		g.fillOval(x+5, y+13, 12, 12);
		g.fillRect(x+10,y,4,25);
	}
	public void drawTankRight(int x,int y,Graphics g,int c)
	{
		SetColor(g,c);
		g.fill3DRect(x, y+7, 25, 5,false);
		g.fill3DRect(x+5, y+12, 15, 15,false);
		g.fill3DRect(x, y+27, 25, 5,false);
		g.fillOval(x+5, y+13, 12, 12);
		g.fillRect(x+6,y+18,25,4);
	}	
	public void drawTankDown(int x,int y,Graphics g,int c)
	{
		SetColor(g,c);
		g.fill3DRect(x, y+7, 5, 25,false);
		g.fill3DRect(x+5, y+12, 15, 15,false);
		g.fill3DRect(x+20, y+7, 5, 25,false);
		g.fillOval(x+5, y+13, 12, 12);
		g.fillRect(x+10,y+14,4,25);
	}
	public void drawTankLeft(int x,int y,Graphics g,int c)
	{
		SetColor(g,c);
		g.fill3DRect(x, y+7, 25, 5,false);
		g.fill3DRect(x+5, y+12, 15, 15,false);
		g.fill3DRect(x, y+27, 25, 5,false);
		g.fillOval(x+5, y+13, 12, 12);
		g.fillRect(x-6,y+18,25,4);
	}
	//���ӵ�
	public void drawBullet(int x,int y,Graphics g)
	{
		g.setColor(Color.RED);
		g.fillOval(x, y, 5, 5);
	}
	//��Ϸ����
	public void drawGameOver(int c,Graphics g)
	{
		g.setColor(Color.RED);
		Font myFont=new Font("�л�κ��",Font.BOLD,30);
		g.setFont(myFont);
		if (c==1)
			g.drawString("�ҷ�̹��ȫ����������", Data.panelSizeX/2-120, Data.panelSizeY/2-80);
		else g.drawString("�ҷ�Ӫ�ر��٣���", Data.panelSizeX/2-110, Data.panelSizeY/2-80);
		g.drawString("GameOver!!!", Data.panelSizeX/2-80, Data.panelSizeY/2-20);
	}
	public void drawWin(Graphics g)
	{
		g.setColor(Color.RED);
		g.setFont(new Font("�л�κ��",Font.BOLD,30));
		g.drawString("You Win!!!", Data.panelSizeX/2-80, Data.panelSizeY/2-20);
	}
	public void drawTankGame(int y,Graphics g)
	{
		g.setColor(Color.RED);
		g.setFont(new Font("�л�κ��",Font.BOLD,60));
		g.drawString("TankGame", Data.panelSizeX/2-150, y);
	}
	//��ǵ�ǰս��
	public void drawLive (int a,int b,int c,int d,int e,Graphics g)
	{
		g.setColor(Color.BLACK);
		g.setFont(new Font("�л�κ��",Font.BOLD,20));
		g.drawString("ʣ��о�����:"+a+"/5   "+b+"/5   "+c+"/5   "+d+"/5   ", 300, 20);
		g.drawString("�ҷ�����̹��:"+e+"/3", 340, 40);
	}
	//������ɫ
	public void SetColor (Graphics g ,int c)
	{
		switch (c)
		{
		case 0:
			g.setColor(Color.BLACK);
			break;
		case 1:
			g.setColor(Color.YELLOW);
			break;
		case 2:
			g.setColor(Color.GREEN);
			break;
		case 3:
			g.setColor(Color.BLUE);
			break;
		}
	}
	//���ϰ���
	public void drawSteel(Graphics g,int x,int y)
	{
		g.setColor(Color.BLACK);
		g.fill3DRect(x, y, 46, 46, true);
		g.setColor(Color.white);
		g.fill3DRect(x+2, y+2, 20, 20, true);
		g.fill3DRect(x+25, y+2, 20, 20, true);
		g.fill3DRect(x+2, y+25, 20, 20, true);
		g.fill3DRect(x+25, y+25, 20, 20, true);
	}
	public void drawWall(Graphics g,int x,int y,boolean []alive)
	{
		for (int i=0;i<=4;i++)
			if (alive[i])
				if (i%2==1)
				{
					g.setColor(Color.yellow);
					g.fillRect(x, y+10*i, 50, 10);
					g.setColor(Color.black);
					g.draw3DRect(x, y+10*i, 35, 10,true);
					g.draw3DRect(x+35, y+10*i, 15, 10,true);
				}
				else {
					g.setColor(Color.yellow);
					g.fillRect(x, y+10*i, 50, 10);
					g.setColor(Color.black);
					g.draw3DRect(x, y+10*i, 15, 10,true);
					g.draw3DRect(x+15, y+10*i, 35, 10,true);
				}
	}
	public void drawRiver(Graphics g,int x,int y)
	{
		g.setColor(Color.blue);
		g.drawArc(x+3, y+6, 32, 16, 0, 180);
		g.drawArc(x+35, y+6, 32, 16, 0, 180);
		g.drawArc(x+3, y+14, 32, 16, 0, 180);
		g.drawArc(x+35, y+14, 32, 16, 0, 180);
		g.drawArc(x+3, y+22, 32, 16, 0, 180);
		g.drawArc(x+35, y+22, 32, 16, 0, 180);
	}
	public void drawIce(Graphics g,int x,int y)
	{
		g.setColor(Color.gray);
		
		g.draw3DRect(x, y, 80, 80, true);
		g.setColor(Color.BLACK);
		g.drawLine(x, y+40, x+40, y);
		g.drawLine(x, y+80, x+80, y);
		g.drawLine(x+40, y+80, x+80, y+40);
	}
	public void drawLawn(Graphics g,int x,int y)
	{
		g.setColor(Color.green);
		g.fillRect(x+12, y+12, 24, 24);
		g.fillArc(x+12, y, 24, 24, 0, 180);
		g.fillArc(x+24, y+12, 24, 24, 90,-180);
		g.fillArc(x+12, y+24, 24, 24, -180, 180);
		g.fillArc(x, y+12, 24, 24, -270,180);	
	}
	public void drawCrossing(Graphics g,int x,int y)
	{
		g.setColor(Color.red);
		g.drawLine(x, y, x+20, y+20);
		g.drawLine(x+20, y, x, y+20);
	}
	public void drawBoom(Graphics g,int x,int y)
	{
		g.setColor(Color.black);
		g.fillOval(x, y, 25, 25);
		g.drawArc(x+22, y+5, 20, 10, 90, 90);
		g.setColor(Color.red);
		g.fillOval(x+32, y+2, 5, 5);
	}	
	//����ͼ
	public void drawMap(Graphics g,Vector<Steel> steel,Vector <Wall> wall,Vector <River> river,Vector <Ice> ice,Vector <Lawn> lawn,Vector <Boom> boom)
	{
		//���Ѿ���ƶ���ϰ���
		for (int i=0;i<steel.size();i++)
			this.drawSteel(g, steel.get(i).x, steel.get(i).y);
		for (int i=0;i<wall.size();i++)
			this.drawWall(g, wall.get(i).x, wall.get(i).y,new boolean []{true,true,true,true,true});
		for (int i=0;i<river.size();i++)
			this.drawRiver(g, river.get(i).x, river.get(i).y);
		for (int i=0;i<ice.size();i++)
			this.drawIce(g, ice.get(i).x, ice.get(i).y);
		for (int i=0;i<lawn.size();i++)
			this.drawLawn(g, lawn.get(i).x, lawn.get(i).y);
		for (int i=0;i<boom.size();i++)
			this.drawBoom(g, boom.get(i).x, boom.get(i).y);
	}
}
class Steel
{
	int x;
	int y;
	public Steel(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
}
class Wall
{
	int x;
	int y;
	boolean []alive=null;
	public Wall(int x,int y)
	{
		this.x=x;
		this.y=y;
		alive=new boolean [5];
		for (int i=0;i<=4;i++)
			alive[i]=true;
	}
}
class River
{
	int x;
	int y;
	public River(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
}
class Ice
{
	int x;
	int y;
	public Ice(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
}
class Lawn
{
	int x;
	int y;
	public Lawn(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
}
class Boom
{
	int x;
	int y;
	public Boom(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
}
class Judge
{
	public static int judgeReclosing(int x,int y,int size,int size2,Vector<Steel> steel,Vector<Wall> wall,Vector<River> river,Vector<Ice> ice,Vector<Lawn> lawn,Vector<Boom> boom)
	{
		for (int i=0;i<steel.size();i++)
		{
			if (x>steel.get(i).x && x<steel.get(i).x+40 && y>steel.get(i).y && y<steel.get(i).y+40)
				return 1000+i;
			if (x>steel.get(i).x && x<steel.get(i).x+40 && y+size2>steel.get(i).y && y+size2<steel.get(i).y+40)
				return 1000+i;
			if (x+size>steel.get(i).x && x+size<steel.get(i).x+40 && y>steel.get(i).y && y<steel.get(i).y+40)
				return 1000+i;
			if (x+size>steel.get(i).x && x+size<steel.get(i).x+40 && y+size2>steel.get(i).y && y+size2<steel.get(i).y+40)
				return 1000+i;
		}
		for (int i=0;i<wall.size();i++)
		{
			if (x>wall.get(i).x && x<wall.get(i).x+50 && y>wall.get(i).y && y<wall.get(i).y+50)
				return 2000+i;
			if (x>wall.get(i).x && x<wall.get(i).x+50 && y+size2>wall.get(i).y && y+size2<wall.get(i).y+50)
				return 2000+i;
			if (x+size>wall.get(i).x && x+size<wall.get(i).x+50 && y>wall.get(i).y && y<wall.get(i).y+50)
				return 2000+i;
			if (x+size>wall.get(i).x && x+size<wall.get(i).x+50 && y+size2>wall.get(i).y && y+size2<wall.get(i).y+50)
				return 2000+i;
		}
		for (int i=0;i<river.size();i++)
		{
			if (x>river.get(i).x && x<river.get(i).x+64 && y>river.get(i).y && y<river.get(i).y+32)
				return 3000+i;
			if (x>river.get(i).x && x<river.get(i).x+64 && y+size2>river.get(i).y && y+size2<river.get(i).y+32)
				return 3000+i;
			if (x+size>river.get(i).x && x+size<river.get(i).x+64 && y>river.get(i).y && y<river.get(i).y+32)
				return 3000+i;
			if (x+size>river.get(i).x && x+size<river.get(i).x+64 && y+size2>river.get(i).y && y+size2<river.get(i).y+32)
				return 3000+i;
		}
		for (int i=0;i<boom.size();i++)
		{
			if (x>boom.get(i).x && x<boom.get(i).x+28 && y>boom.get(i).y && y<boom.get(i).y+28)
				return 7000+i;
			if (x>boom.get(i).x && x<boom.get(i).x+28 && y+size2>boom.get(i).y && y+size2<boom.get(i).y+28)
				return 7000+i;
			if (x+size>boom.get(i).x && x+size<boom.get(i).x+28 && y>boom.get(i).y && y<boom.get(i).y+28)
				return 7000+i;
			if (x+size>boom.get(i).x && x+size<boom.get(i).x+28 && y+size2>boom.get(i).y && y+size2<boom.get(i).y+28)
				return 7000+i;
		}
		for (int i=0;i<ice.size();i++)
		{
			if (x>ice.get(i).x && x<ice.get(i).x+80 && y>ice.get(i).y && y<ice.get(i).y+80)
				return 4000+i;
			if (x>ice.get(i).x && x<ice.get(i).x+80 && y+size2>ice.get(i).y && y+size2<ice.get(i).y+80)
				return 4000+i;
			if (x+size>ice.get(i).x && x+size<ice.get(i).x+80 && y>ice.get(i).y && y<ice.get(i).y+80)
				return 4000+i;
			if (x+size>ice.get(i).x && x+size<ice.get(i).x+80 && y+size2>ice.get(i).y && y+size2<ice.get(i).y+80)
				return 4000+i;
		}
		for (int i=0;i<lawn.size();i++)
		{
			if (x>lawn.get(i).x && x<lawn.get(i).x+48 && y>lawn.get(i).y && y<lawn.get(i).y+48)
				return 5000+i;
			if (x>lawn.get(i).x && x<lawn.get(i).x+48 && y+size2>lawn.get(i).y && y+size2<lawn.get(i).y+48)
				return 5000+i;
			if (x+size>lawn.get(i).x && x+size<lawn.get(i).x+48 && y>lawn.get(i).y && y<lawn.get(i).y+48)
				return 5000+i;
			if (x+size>lawn.get(i).x && x+size<lawn.get(i).x+48 && y+size2>lawn.get(i).y && y+size2<lawn.get(i).y+48)
				return 5000+i;
		}
		return 0;
	}
}
class Music 
{
	File fp1=new File("Music\\Bullet.wav");
	File fp=new File("Music\\BackMusic.mp3");
	//AudioClip music;
	public void Bullet()
	{
		try {
			AudioClip music1=Applet.newAudioClip(fp1.toURI().toURL());
			//music1.play();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	public void backMusic() {
			
			try {
				AudioClip music = Applet.newAudioClip(fp.toURI().toURL());
				//System.out.print("1212");
				music.play();
			} catch (MalformedURLException e) {
				
				// TODO Auto-generated catch block	
				e.printStackTrace();
			}
	}
}