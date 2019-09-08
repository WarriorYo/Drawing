package com.company;
public class DrawingView
{

    protected DrawingView(){}
    public ShapeDlg shapeDlg;
    public void OnDraw() {}
    public boolean PreCreateWindow()
    {
     return true;
    }

    protected boolean OnPreparePrinting()

    {

        return true;

    }

    protected void OnBeginPrinting(){}

    protected void OnEndPrinting(){}

    public void finalizee(){ }

}
