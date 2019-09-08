package com.company;



import com.sun.glass.ui.Size;

import java.lang.*;

import java.awt.*;



public class Shape {

    public enum ElementType

    {

        NOTSET, SQUARE, RECTANGLE, CIRCLE, ELLIPSE, TRIANGLE, TEXT;

        

    }

    

    abstract public class CShape extends Object

    {

        public CShape()

        {

            Type = ElementType.NOTSET;

            OrgX = 0;

            OrgY = 0;

            BorderColor= new Color(255,0,0);

            BorderType=0;

            BorderWidth=2;

            FillColor = new Color(0, 186, 205);

            FillType = 0;

        }

        public void finalize(){

        }

        abstract public void Draw();

        abstract public boolean IsMatched(Point pnt);

        abstract public void Serialize();

        abstract public void SetValue(int x,int y,int w_r,int h,String s);

        abstract public void GetValue(int type,int x,int y,int w_r,int h,String s);

        

        public void SetPen(Color penColor,int penType,int penWidth)

        {

            BorderColor = penColor;

            BorderType = penType;

            BorderWidth = penWidth;

        }

        

        public void SetBrush(Color fillColor ,int fillType)

        {

            FillColor = fillColor;

            FillType = fillType;

        }

        

        public void GetPen(Color penColor,int penType,int penWidth)

        {

            penColor = BorderColor;

            penType = BorderType;

            penWidth = BorderWidth;

        }

        

        public void GetBush(Color fillColor,int fillType)

        {

            fillColor = FillColor;

            fillType = FillType;

        }

        

        protected ElementType Type;

        protected int OrgX;

        protected int OrgY;

        protected Color BorderColor;

        protected int BorderType;

        protected int BorderWidth;

        protected Color FillColor;

        protected int FillType;

        

    }

    

    public class CSqaure extends CShape

    {

        public CSqaure(){}

        public CSqaure(int x,int y,int w)

        {

            Type = ElementType.SQUARE;

            OrgX = x;

            OrgY = y;

            width = w;

        }

        public void Draw(){ }

        public boolean IsMatched(Point pnt){

            if (pnt.x >= (OrgX - width / 2.0) && pnt.y >= (OrgY - width / 2.0) && pnt.y <= (OrgY + width / 2.0) && pnt.x <= (OrgX + width / 2.0))

                return true;

            else

                return false;

        }

        public void Serialize(){ }

    

        public void SetValue(int x,int y,int w_r,int h,String s)

        {

            OrgX = x;

            OrgY = y;

            width = w_r;

        }

        public void GetValue(int type,int x,int y,int w_r,int h,String s)

        {

            type = 0;

            x = OrgX;

            y = OrgY;

            w_r = width;

        }

        

        public void finalizee(){ }

        

        private int width;

    }

    

    public class CRectangle extends CShape

    {

        public CRectangle(){}

        public CRectangle(int x,int y,int w,int h)

        {

            Type = ElementType.RECTANGLE;

            OrgX = x;

            OrgY = y;

            width = w;

            height = h;

        }

        public void Draw(){ }

        public boolean IsMatched(Point pnt){

            if ((pnt.x >= OrgX - width / 2.0) && (pnt.y >= OrgY - height / 2.0) && (pnt.x <= OrgX + width / 2.0) && (pnt.y <= OrgY + height / 2.0))

                return true;

            else

                return false;

        }

        public void Serialize(){ }

        public void SetValue(int x,int y,int w_r,int h,String s)

        {

            OrgX = x;

            OrgY = y;

            width = w_r;

            height = h;

        }

        public void GetValue(int type,int x,int y,int w_r,int h,String s)

        {

            type = 1;

            x = OrgX;

            y = OrgY;

            w_r = width;

            h = height;

        }

        public void finalizee(){ }

        

        private int width;

        private int height;

        

    }

    

    public class CCircle extends CShape

    {

        public CCircle(){}

        public CCircle(int x,int y,int r)

        {

            Type = ElementType.CIRCLE;

            OrgX = x;

            OrgY = y;

            radius = r;

        }

        public void Draw(){ }

        public boolean IsMatched(Point pnt){

            if (Math.sqrt(Math.pow((pnt.x - OrgX), 2) + Math.pow((pnt.y - OrgY), 2)) <= radius)

                return true;

            else

                return false;

        }

        public void Serialize(){ }

        public void SetValue(int x,int y,int w_r,int h,String s)

        {

            OrgX = x;

            OrgY = y;

            radius = w_r;

        }

        public void GetValue(int type,int x,int y,int w_r,int h,String s)

        {   type = 2;

            x = OrgX;

            y = OrgY;

            w_r = radius;

        }

        public void finalizee(){ }

        

        private int radius;

    }

    

    public class CEllipse extends CShape

    {

        public CEllipse(){}

        public CEllipse(int x,int y,int w,int h)

        {

            Type = ElementType.ELLIPSE;

            OrgX = x;

            OrgY = y;

            width = w;

            height = h;

        }

        public void Draw(){ }

        public boolean IsMatched(Point pnt){

            if ((Math.pow((pnt.x - OrgX), 2) / Math.pow((width / 2.0), 2) + Math.pow((pnt.y - OrgY), 2) / Math.pow((height / 2.0), 2)) <= 1)

                return true;

            else

                return false;

        }

        public void Serialize(){ }

        public void SetValue(int x,int y,int w_r,int h,String s)

        {

            OrgX = x;

            OrgY = y;

            width = w_r;

            height = h;

        }

        public void GetValue(int type,int x,int y,int w_r,int h,String s)

        {

            type = 3;

            x = OrgX;

            y = OrgY;

            w_r = width;

            h = height;

        }

        public void finalizee(){ }

        

        private int width;

        private int height;

    }

    

    public class CTriangle extends CShape

    {

        public CTriangle(){}

        public CTriangle(int x,int y,int w)

        {

            Type = ElementType.TRIANGLE;

            OrgX = x;

            OrgY = y;

            width = w;

        }

        public void Draw(){ }

        public boolean IsMatched(Point pnt)

        {

            /*Point point[3];

            point[0].x = OrgX;

            point[0].y = (int)(OrgY - width * 1.0 / Math.sqrt(3));

            point[1].x = (int)(OrgX - width / 2.0);

            point[1].y = (int)(OrgY + width * 0.5 / Math.sqrt(3));

            point[2].x = (int)(OrgX + width / 2.0);

            point[2].y = (int)(OrgY + width * 0.5 / Math.sqrt(3));

    

            int nCross = 0;

            for (int i = 0; i < 3; i++)

            {

                Point p1 = point[i];

                Point p2 = point[(i + 1) % 3];// 最后一个点与第一个点连线

                if (p1.y == p2.y)

                    continue;

                if (pnt.y < Math.min(p1.y, p2.y))

                    continue;

                if (pnt.y >= Math.max(p1.y, p2.y))

                    continue;

                // 求交点的x坐标

                double x = (double)(pnt.y - p1.y) * (double)(p2.x - p1.x) / (double)(p2.y - p1.y) + p1.x;

                // 只统计p1p2与p向右射线的交点

                if (x > pnt.x)

                {

                    nCross++;

                }

            }

    

            // 交点为偶数，点在多边形之外

    

            if (nCross % 2 == 1) {

                return true;

            }

            else {

                return false;

            }*/

            return false;

        }

        public void Serialize(){ }

        public void SetValue(int x,int y,int w_r,int h,String s)

        {

            OrgX = x;

            OrgY = y;

            width = w_r;

        }

        public void GetValue(int type,int x,int y,int w_r,int h,String s)

        {

            type = 4;

            x = OrgX;

            y = OrgY;

            w_r = width;

        }

        public void finalizee(){ }

        

        private int width;

    }

    

    public class CText extends CShape

    {

        public CText(){}

        public CText(int x,int y,int h,int a,String t)

        {

            Type = ElementType.TEXT;

            OrgX = x;

            OrgY = y;

            height = h;

            angle = a;

            text = t;

        }

        public void Draw(){ }

        public boolean IsMatched(Point pnt){

            /*int width, height;

            width = size.x;									// cx、cy分别是宽度和高度

            height = size.y;

            double a = angle * 3.1415926 / 180;

            Point p[4];

            p[0].x = OrgX;

            p[0].y = OrgY;

            p[1].x = (int)(OrgX + height * Math.sin(a));

            p[1].y = (int)(OrgY + height * Math.cos(a));

            p[2].x = (int)(OrgX + height * Math.sin(a) + width * Math.cos(a));

            p[2].y = (int)(OrgY + height * Math.cos(a) - width * Math.sin(a));

            p[3].x = (int)(OrgX + width * Math.cos(a));

            p[3].y = (int)(OrgY - width * Math.sin(a));

    

            int nCross = 0;

            for (int i = 0; i < 4; i++)

            {

                Point p1 = p[i];

                Point p2 = p[(i + 1) % 4];// 最后一个点与第一个点连线

                if (p1.y == p2.y)

                    continue;

                if (pnt.y < Math.min(p1.y, p2.y))

                    continue;

                if (pnt.y >= Math.max(p1.y, p2.y))

                    continue;

                // 求交点的x坐标

                double x = (double)(pnt.y - p1.y) * (double)(p2.x - p1.x) / (double)(p2.y - p1.y) + p1.x;

                // 只统计p1p2与p向右射线的交点

                if (x > pnt.x)

                {

                    nCross++;

                }

            }

    

            // 交点为偶数，点在多边形之外

    

            if (nCross % 2 == 1) {

                return true;

            }

            else {

                return false;

            }

            */

           return false;

        }

        public void Serialize(){ }

        public void SetValue(int x,int y,int w_r,int h,String s){ }

        public void GetValue(int type,int x,int y,int w_r,int h,String s){ }

        public void finalizee(){ }

        

        private int height;

        private int angle;

        private String text;

        private Size size;

    }



    public static void main(String[] args) {

	// write your code here

    }

}
