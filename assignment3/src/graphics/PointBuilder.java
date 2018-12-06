package graphics;

import visualiser.Color;

public class PointBuilder {
	
	private Point point;
	
			
	public PointBuilder(){
		point = new Point();
	}
			
	public PointBuilder x(float x){
		point.setX(x);
		return this;
	}
			
	public PointBuilder y(float y){
		point.setX(y);
		return this;
	}
			
	public PointBuilder c(Color c){
		point.setC(c);
		return this;
	}
			
	public Point build(){
			return point;
	}

}
