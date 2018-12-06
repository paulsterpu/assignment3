package visualiser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;

import com.google.common.annotations.VisibleForTesting;

public final class Task {
	// TODO(2): Adaugati campurile, constructorii necesari si metodele care lipsesc.
	
	private final List<UserEvent> userEvents;
	
	public Task(){
		this.userEvents = new ArrayList<UserEvent>();
	} 	//constructorul fara argumente
	
	public Task( String logs) {
		this.userEvents = parseLogs(logs);
	}
	
	public List<UserEvent> getUserEvents() {
		return userEvents;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	public Double meanFrequencyPerTenSeconds() {
		// TODO(2): Implementati metoda care va calcula frecventa medie pe intervale de 10 secunde.
		
		double start,k2=0;
		double s2=0,s3=0;
		
		int [] v = new int[100];
		int j = 0;
		int indice =  0;
		
		for ( int i = 0 ; i < 100 ; i++ ){
			v[i] = 0;
		}
		
		start = userEvents.get(0).getTimpestamp();		//aflu inceputul pentru primul interval de 10 sec
		
		for ( int i = 0 ; i < userEvents.size() ; i++ ) {
			
			if ( userEvents.get(i).getTimpestamp() < start + 10 ) {
				v[indice] = v[indice] + 1;
			
			} else {
				indice = indice + 1;
				v[indice] = v[indice] + 1;			
				start = start + 10;
			}	
		}
		
		while ( v[j] != 0 ) {
			s2 = s2 + (double)v[j]/10;
			j = j + 1;
		}
		
		k2 = j;
		s3 = (double)s2/k2;
		
		return s3;
	}
	
	public Map<String, Double> computeClicksPerArea() {
		// TODO(2): Calculati numarul de click-uri date pe fiecare zona a editorului.
		
		double Canvas=0,Menu=0,Dialog=0,UnknownArea=0;
		
		for ( int i = 0 ; i < userEvents.size() ; i++ ) {
	
			if ( userEvents.get(i).getArea().getPathInEditor().get(0).getType().contains("card") ){
				Canvas = Canvas + 1;
			}
			
			else if ( userEvents.get(i).getArea().getPathInEditor().get(0).getType().contains("input") ) {
				Canvas = Canvas + 1;
			}
			
			else if ( userEvents.get(i).getArea().getPathInEditor().get(0).getType().contains("page") ){
				Canvas = Canvas + 1;
			}
			
			else if ( userEvents.get(i).getArea().getPathInEditor().get(0).getType().contains("menu") ){
				Menu = Menu + 1;
			}
			
			else if ( userEvents.get(i).getArea().getPathInEditor().get(0).getType().contains("menu-button") ){
				Menu = Menu + 1;
			}
			
			else if ( userEvents.get(i).getArea().getPathInEditor().get(0).getType().contains("icon") ){
				Menu = Menu + 1;
			}
			
			else if ( userEvents.get(i).getArea().getPathInEditor().get(0).getType().contains("dialog") ){
				Dialog = Dialog + 1;
			}
			else {
				UnknownArea = UnknownArea + 1;
			}
		}
		
		Map<String, Double> m = new HashMap<String, Double>();
		
			if( Canvas > 0 ){
				m.put("visualiser.Canvas", Canvas);		
			}
			if ( Menu > 0 ) {
				m.put("visualiser.Menu", Menu);
			}
			if ( UnknownArea > 0 ){
				m.put("visualiser.UnknownArea", UnknownArea);
			}
			if (Dialog > 0 ){
				m.put("visualiser.DialogBox", Dialog);
			}

		return m;
	}

	
	//@VisibleForTesting
	List<UserEvent> parseLogs(String logs) {
		// TODO(2): Implementati metoda care va parsa log-urile primite in constructor. Unde
		// trebuie apelata aceasta metoda ?		//in constructor
		
		List<UserEvent> events = new ArrayList<UserEvent>();
		
		String[] aux1;
		String aux2;
		int timestamp = -1,index = 0;
		
		ArrayList<EditorElement>[] elemente = (ArrayList<EditorElement>[])new ArrayList[100];
		
		for ( int i = 0 ; i < 100 ; i++ ){
			elemente[i] = new ArrayList<EditorElement>();
		}
		
		String[]lines = logs.split("\n");
		for(String event : lines){			//parcurg linie cu linie logurile
			
			if ( event.toLowerCase().contains("element".toLowerCase()) ) {
				
				aux1 = event.replaceAll("\\s+", "").split(":");
				aux2 = aux1[1];
				
				elemente[index].add(new EditorElement(aux2));
			}
			
			else if ( event.toLowerCase().contains("timestamp".toLowerCase()) ) {
				
				aux1 = event.replaceAll("\\s+", "").split(":");
				timestamp = Integer.parseInt(aux1[1]);
			}
			
			else if (  event.toLowerCase().contains("} user_event".toLowerCase()) ) {		
				
				events.add(new UserEvent(new Canvas(elemente[index]) , timestamp));
				index = index + 1;
				timestamp = -1;			
			}
		}
			
		return events;
	}

	//@VisibleForTesting
	EditorArea determineAreaForElements(List<EditorElement> elements) {
		// TODO(2): Implementati metoda care determina zona din editor unde s-a dat click, in
		// functie de lista de elemente ce identifica in mod unic zona respectiva.
	
		return Factory.createArea(elements);

	}	
}
