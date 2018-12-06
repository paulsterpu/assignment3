package visualiser;

public final class UserEvent {
	// TODO(3): Adaugati campurile, constructorii necesari si metodele care lipsesc.
	
	private EditorArea area;
	
	private int timestamp;
	
	public UserEvent(){} 	//contructor fara argumente
	
	public UserEvent( EditorArea area , int timpestamp){
		
		this.area = area;
		this.timestamp = timpestamp;
		
	}
	
	public void setPageArea(EditorArea area) {
		this.area = area;
	}
	
	public void setTimestamp(int timpestamp) {
		this.timestamp = timpestamp;
	}
	
	public EditorArea getArea() {
		return area;
	}
	
	public int getTimpestamp() {
		return timestamp;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((area == null) ? 0 : area.hashCode());
		result = prime * result + timestamp;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserEvent other = (UserEvent) obj;
		if (area == null) {
			if (other.area != null)
				return false;
		} else if (!area.equals(other.area))
			return false;
		if (timestamp != other.timestamp)
			return false;
		return true;
	}
	

	@Override
	public String toString() {
		return "UserEvent [area=" + area + ", timestamp=" + timestamp + "]";
	}
	
}
