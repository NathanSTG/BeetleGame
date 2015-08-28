package beetle;

public class Die {
	private int topFace;
	
	public Die(){
		topFace = 1;
	}
	
	public void roll(){
		this.topFace = (int)(Math.random() * 6) + 1;
	}

	public int getTopFace() {
		return topFace;
	}

	public void setTopFace(int topFace) {
		this.topFace = topFace;
	}
	
	
}
