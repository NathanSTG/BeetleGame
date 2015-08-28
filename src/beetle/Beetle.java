package beetle;

public class Beetle {
	private boolean body;
	private int eyes;
	private int feelers;
	private boolean head;
	private int legs;
	private boolean tail;
	
	public Beetle(){
		body = false;
	}
	
	public boolean addBody(){
		if(body){
			return false;
		}
		body = true;
		return true;
	}
	
	public boolean addEye(){
		if(head && (eyes < 2)){
			eyes++;
			return true;
		}
		return false;
	}
	
	public boolean addHead(){
		if(body && !head){
			head = true;
			return true;
		}
		return false;
	}
	
	public boolean addFeeler(){
		if(head && (feelers < 2)){
			feelers++;
			return true;
		}
		return false;
	}
	
	public boolean addLeg(){
		if(body && (legs < 6)){
			legs++;
			return true;
		}
		return false;
	}
	
	public boolean addTail(){
		if(body && !tail){
			tail = true;
			return true;
		}
		return false;
	}
	
	public boolean isComplete(){
		return body && head && (eyes == 2) && (feelers == 2) && (legs == 6) && tail;
	}
	
	public String toString(){
		if(!body){
			return "(no parts yet)";
		}
		StringBuilder sb = new StringBuilder();
		
		
		//Head
		if(head){
			//Feelers
			if(feelers >= 1) { sb.append("\\"); }
			if(feelers == 2) { sb.append(feelers == 1 ? " /" : "  /"); }
			sb.append("\n");
			
			//eyes
			sb.append(eyes >= 1 ? "o" : " ");
			sb.append("0");
			sb.append(eyes == 2 ? "o" : " ");
			sb.append("\n");
		}
		
		//body
		if(body){
			//segment 1
			sb.append(legs >= 1 ? "-" : " ");
			sb.append("#");
			sb.append(legs >= 2 ? "-" : " ");
			sb.append("\n");
			
			//segment 2
			sb.append(legs >= 3 ? "-" : " ");
			sb.append("#");
			sb.append(legs >= 4 ? "-" : " ");
			sb.append("\n");

			//segment 3
			sb.append(legs >= 5 ? "-" : " ");
			sb.append("#");
			sb.append(legs >= 6 ? "-" : " ");
		}
		
		//tail
		if(tail) {
			sb.append("\n v");
		}
		
		return sb.toString();
	}
}
