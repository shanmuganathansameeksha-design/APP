class Marks
{
    int m1,m2,m3;

    Marks(int a,int b,int c)
    {
        m1=a;
        m2=b;
        m3=c;
    }

    void calculate()
    {
        int total=m1+m2+m3;
        double avg=total/3.0;

        System.out.println("Total = " + total);
        System.out.println("Average = " + avg);
    }
}

public class MarksDemo
{
    public static void main(String args[])
    {
        Marks m=new Marks(85,90,80);

        m.calculate();
    }
}