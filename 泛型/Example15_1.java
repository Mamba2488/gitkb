package ·ºÐÍ;
public class Example15_1 {
	public static void main(String[] args) {
		Circle circle=new Circle(10);
		Cone<Circle> coneOne=new Cone<Circle>(circle);
		coneOne.setHeight(16);
		System.out.println(coneOne.computerVolume());
		Rect rect=new Rect(15,23);
		Cone<Rect> coneTwo=new Cone<Rect>(rect);
		coneTwo.setHeight(98);
		System.out.println(coneTwo.computerVolume());

	}

}
class Circle{
	double area,radius;
	Circle(double r){
		radius=r;
	}
	public String toString() {
		area=radius*radius*Math.PI;
		return " "+area;
	}
}
class Cone<E>{
	double height;
	E bottom;
	public Cone(E b) {
		bottom=b;
		
	}
	public void setHeight(double h) {
		height=h;
	}
	public double computerVolume() {
		String a=bottom.toString();
		double area=Double.parseDouble(a);
		return 1.0/3.0*area*height;
	}
}
class Rect{
	double sideA,sideB,area;
	Rect(double a,double b){
		sideA=a;
		sideB=b;
	}
	public String toString(){
		area=sideA*sideB;
		return " "+area;
	}
}
