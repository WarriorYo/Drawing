package com.company;



import javax.swing.*;

import java.awt.*;





public class Panel extends JPanel {

    //申明一个窗体对象 用来承接传来的参数

    private BackGround backGround;

    //构造函数在传来的窗体上进行操作

    public Panel(BackGround backGround){

        super();

        this.backGround = backGround;

    }

    

    

    //最后被调用到

    @Override

    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        //鼠标点击之后就画图

        

        //画矩形

        DrawRect(g,0,0,100,100,Color.BLUE);

    }

    public void DrawRect(Graphics graphics,int x,int y,int width,int height,Color color){

        graphics.drawRect(x,y,width,height);

        graphics.setColor(color);

        graphics.fillRect(x,y,width,height);

    }

}
