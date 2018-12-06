package graphics;

import java.util.List;

public class RendererBuilder {
	
	private Renderer renderer;
	
	public RendererBuilder(){
		renderer = new Renderer();
	}
	
	public RendererBuilder points( List<Point> points ){
		renderer.setPoints(points);
		return this;
	}
	
	public RendererBuilder circleSize( float circleSize){
		renderer.setCircleSize(circleSize);
		return this;
	}
	
	public Renderer build(){
		return renderer;
	}

}
