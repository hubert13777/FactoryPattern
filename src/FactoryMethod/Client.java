package FactoryMethod;

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
    public static void main(String[] args) {
        JFrame jf = new JFrame("工厂方法绘图工具");
        jf.setBounds(100, 100, 600, 400);
        jf.setLayout(new BorderLayout());
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel buttonArea = new JPanel();
        buttonArea.setBounds(0, 0, 600, 100);
        buttonArea.setLayout(new GridLayout(1, 5, 3, 3));
        buttonArea.add(new JButton("圆"));
        buttonArea.add(new JButton("矩形"));
        buttonArea.add(new JButton("线"));
        buttonArea.add(new JButton("点"));
        JButton b5=new JButton("橡皮擦");
        buttonArea.add(b5);

        Brush draw=getXML();

        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                draw.setDrawOrEraser();
            }
        });

        jf.add(buttonArea, BorderLayout.NORTH);
        jf.add(draw,BorderLayout.CENTER);
        jf.setVisible(true);
        draw.setGraphics();
    }
    public static Brush getXML(){
        try{
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File("src/FactoryMethod/shape.xml"));
            NodeList nl = doc.getElementsByTagName("className");
            Node classNode = nl.item(0).getFirstChild();
            String className = classNode.getNodeValue();

            BrushFactory temp=new BrushFactory();
            return temp.getProduct(className);
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
