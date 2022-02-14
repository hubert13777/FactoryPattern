package AbstractFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Client {
    private static boolean solid;
    private static SolidFactory sf;
    private static HollowFactory hf;
    private static Brush draw;  //画笔，在圆、三角形、矩形三者中切换
    private static Brush circle,rect,triangle;
    private static Graphics g;

    public static void main(String[] args) {
        JFrame jf = new JFrame("抽象工厂绘图工具");
        jf.setBounds(100, 100, 600, 400);
        jf.setLayout(new BorderLayout());
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel buttonArea = new JPanel();
        buttonArea.setBounds(0, 0, 600, 100);
        buttonArea.setLayout(new GridLayout(1, 4, 3, 3));
        JButton b1=new JButton("圆");
        JButton b2=new JButton("矩形");
        JButton b3=new JButton("三角形");
        JButton b4=new JButton("橡皮擦");
        buttonArea.add(b1);
        buttonArea.add(b2);
        buttonArea.add(b3);
        buttonArea.add(b4);

        if(getXML()==false) System.out.println("获取xml配置信息失败！");
        draw=rect;  //默认画圆

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("选择圆");
                jf.remove(draw);
                draw=circle;

                jf.add(draw,BorderLayout.CENTER);
                jf.setVisible(true);
                draw.setGraphics(g);
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("选择矩形");
                jf.remove(draw);
                draw=rect;
                jf.add(draw,BorderLayout.CENTER);
                jf.setVisible(true);
                draw.setGraphics(g);
            }
        });
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("选择三角形");
                jf.remove(draw);
                draw=triangle;
                jf.add(draw,BorderLayout.CENTER);
                jf.setVisible(true);
                draw.setGraphics(g);
            }
        });
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                draw.setDrawOrEraser();
            }
        });


        jf.add(buttonArea, BorderLayout.NORTH);
        jf.add(draw,BorderLayout.CENTER);
        jf.setVisible(true);
        draw.setGraphics();
        g=draw.graphics;
    }
    public static boolean getXML(){
        try{
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File("src/AbstractFactory/shape.xml"));
            NodeList nl = doc.getElementsByTagName("className");
            Node classNode = nl.item(0).getFirstChild();
            String className = classNode.getNodeValue();

            System.out.println(className);

            if(className.equals("AbstractFactory.HollowFactory")){
                System.out.println("hollow");
                hf=new HollowFactory();
                circle=hf.getCircle();
                rect=hf.getRect();
                triangle=hf.getTriangle();
                solid=false;
            }else if(className.equals("AbstractFactory.SolidFactory")){
                System.out.println("solid");
                sf=new SolidFactory();
                circle=sf.getCircle();
                rect=sf.getRect();
                triangle=sf.getTriangle();
                solid=true;
            }

            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
