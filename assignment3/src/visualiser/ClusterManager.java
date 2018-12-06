package visualiser;

import java.util.ArrayList;
import java.util.List;

final class ClusterManager {
	// TODO(4.2): Adaugati clasele, campurile, constructorii necesari si metodele care lipsesc.
	
	private static ClusterManager instance = new ClusterManager();
	
	private final int window = 10;
	
	public static ClusterManager getInstance(){
		return instance;
	}
	
	public List<Cluster> cluster(List<UserEvent> userEvents) {
		// TODO(4.2): Implementati metoda care gaseste secvente repetate ale acelorasi elemente.
		// Folositi o fereastra (window) pentru a gasi aceste secvente.
		
		List<Cluster> clusters = new ArrayList<Cluster>();
		
		int start1 = 0 ,start2 = 0, start3 = 0, start4 = 0 , start5 = 0, start6 = 0, start7 = 0, start8 = 0;
		
		for ( int i = 0 ; i < userEvents.size() ; i++ ){
			if ( userEvents.get(i).getArea().getPathInEditor().get(0).getType().contains("card")){
				start1 = userEvents.get(i).getTimpestamp();
				break;
			}
	
			if ( userEvents.get(i).getArea().getPathInEditor().get(0).getType().contains("input")){
				start2 = userEvents.get(i).getTimpestamp();
				break;
			}
		
			if ( userEvents.get(i).getArea().getPathInEditor().get(0).getType().contains("page")){
				start3 = userEvents.get(i).getTimpestamp();
				break;
			}

			if ( userEvents.get(i).getArea().getPathInEditor().get(0).getType().contains("menu")){
				start4 = userEvents.get(i).getTimpestamp();
				break;
			}

			if ( userEvents.get(i).getArea().getPathInEditor().get(0).getType().contains("menu-button")){
				start5 = userEvents.get(i).getTimpestamp();
				break;
			}

			if ( userEvents.get(i).getArea().getPathInEditor().get(0).getType().contains("icon")){
				start6 = userEvents.get(i).getTimpestamp();
				break;
			}

			if ( userEvents.get(i).getArea().getPathInEditor().get(0).getType().contains("dialog")){
				start7 = userEvents.get(i).getTimpestamp();
				break;
			}

			if ( userEvents.get(i).getArea().getPathInEditor().get(0).getType().contains("card") == false &&
				userEvents.get(i).getArea().getPathInEditor().get(0).getType().contains("input") == false &&
				userEvents.get(i).getArea().getPathInEditor().get(0).getType().contains("page") == false &&
				userEvents.get(i).getArea().getPathInEditor().get(0).getType().contains("menu") == false &&
				userEvents.get(i).getArea().getPathInEditor().get(0).getType().contains("menu-button") == false &&
				userEvents.get(i).getArea().getPathInEditor().get(0).getType().contains("icon") == false &&
				userEvents.get(i).getArea().getPathInEditor().get(0).getType().contains("dialog") == false ){
					
				start8 = userEvents.get(i).getTimpestamp();
				break;
			}
		}
		
		ArrayList<UserEvent>[] u1 = (ArrayList<UserEvent>[])new ArrayList[100];
		ArrayList<UserEvent>[] u2 = (ArrayList<UserEvent>[])new ArrayList[100];
		ArrayList<UserEvent>[] u3 = (ArrayList<UserEvent>[])new ArrayList[100];
		ArrayList<UserEvent>[] u4 = (ArrayList<UserEvent>[])new ArrayList[100];
		ArrayList<UserEvent>[] u5 = (ArrayList<UserEvent>[])new ArrayList[100];
		ArrayList<UserEvent>[] u6 = (ArrayList<UserEvent>[])new ArrayList[100];
		ArrayList<UserEvent>[] u7 = (ArrayList<UserEvent>[])new ArrayList[100];
		ArrayList<UserEvent>[] u8 = (ArrayList<UserEvent>[])new ArrayList[100];
		
		for ( int i = 0 ; i < 100 ; i++ ){
			u1[i] = new ArrayList<UserEvent>();
			u2[i] = new ArrayList<UserEvent>();
			u3[i] = new ArrayList<UserEvent>();
			u4[i] = new ArrayList<UserEvent>();
			u5[i] = new ArrayList<UserEvent>();
			u6[i] = new ArrayList<UserEvent>();
			u7[i] = new ArrayList<UserEvent>();
			u8[i] = new ArrayList<UserEvent>();		
		}
		
		int i1 = 0, i2 = 0, i3 = 0, i4 = 0, i5 = 0, i6 = 0, i7 = 0, i8 = 0;
		
		for ( int i = 0 ; i < userEvents.size() ; i++ ) {
			
			if ( userEvents.get(i).getTimpestamp() <= start1 + 10 ) {
				//daca se incadreaza in fereastra evenimentul curent
				
				if ( userEvents.get(i).getArea().getPathInEditor().get(0).getType().contains("card") ){
					u1[i1].add(userEvents.get(i));
				}
				
				if ( i == userEvents.size() - 1){
					if ( u1[i1].size() > 1 ){
						clusters.add(new Cluster(u1[i1], u1[i1].get(0).getTimpestamp() , u1[i1].get(u1[i1].size() - 1 ).getTimpestamp() + window - 1));
					}
				}
			}
			
			else {
				
				//adaug in lista de clustere ce am contruit pana acum
				if ( u1[i1].size() > 1 ) {
					clusters.add(new Cluster(u1[i1], u1[i1].get(0).getTimpestamp() , u1[i1].get(u1[i1].size() - 1 ).getTimpestamp() + window - 1));
					i1 = i1 + 1;
					if ( userEvents.get(i).getArea().getPathInEditor().get(0).getType().contains("card")){
						u1[i1].add(userEvents.get(i));				
					}
				}
				
				else {
					if ( userEvents.get(i).getArea().getPathInEditor().get(0).getType().contains("card")){
						i1 = i1 + 1;
						u1[i1].add(userEvents.get(i));
					}
				}
				
				while( start1 + 10 < userEvents.get(i).getTimpestamp() ){
					start1 = start1 + 10;
				}
			}
			
			if ( userEvents.get(i).getTimpestamp() <= start2 + 10 ) {
				//daca se incadreaza in fereastra evenimentul curent
				
				if ( userEvents.get(i).getArea().getPathInEditor().get(0).getType().contains("input") ){
					u2[i2].add(userEvents.get(i));
				}
				
				if ( i == userEvents.size() - 1){
					if ( u2[i2].size() > 1 ){
						clusters.add(new Cluster(u2[i2], u2[i2].get(0).getTimpestamp() , u2[i2].get(u2[i2].size() - 1 ).getTimpestamp() + window - 1));
					}
				}
						
			}
			
			else {	
				//adaug in lista de clustere ce am contruit pana acum
				if ( u2[i2].size() > 1 ) {
				
					clusters.add(new Cluster(u2[i2], u2[i2].get(0).getTimpestamp() , u2[i2].get(u2[i2].size() - 1 ).getTimpestamp() + window - 1));
					i2 = i2 + 1;
					if ( userEvents.get(i).getArea().getPathInEditor().get(0).getType().contains("input")){

						u2[i2].add(userEvents.get(i));
						
					}
					

				}		
				else {
						if ( userEvents.get(i).getArea().getPathInEditor().get(0).getType().contains("input")){
							i2 = i2 + 1;
							u2[i2].add(userEvents.get(i));
						}
					}
					
				while( start2 + 10 < userEvents.get(i).getTimpestamp() ){
					start2 = start2 + 10;
				}
								
			}
			
			if ( userEvents.get(i).getTimpestamp() <= start3 + 10 ) {
				//daca se incadreaza in fereastra evenimentul curent
				
				if ( userEvents.get(i).getArea().getPathInEditor().get(0).getType().contains("page") ){
					u3[i3].add(userEvents.get(i));
				}
				
				if ( i == userEvents.size() - 1){
					if ( u3[i3].size() > 1 ){
						clusters.add(new Cluster(u3[i3], u3[i3].get(0).getTimpestamp() , u3[i3].get(u3[i3].size() - 1 ).getTimpestamp() + window - 1));
					}
				}
			}
			
			else {
				
				//adaug in lista de clustere ce am contruit pana acum
				if ( u3[i3].size() > 1 ) {
					clusters.add(new Cluster(u3[i3], u3[i3].get(0).getTimpestamp() , u3[i3].get(u3[i3].size() - 1 ).getTimpestamp() + window - 1));
					i3 = i3 + 1;
					if ( userEvents.get(i).getArea().getPathInEditor().get(0).getType().contains("page")){

						u3[i3].add(userEvents.get(i));
					}
				}
				
				else {
					if ( userEvents.get(i).getArea().getPathInEditor().get(0).getType().contains("page")){
						i3 = i3+ 1;
						u3[i3].add(userEvents.get(i));
					}
				}
				
				
				
				while( start3 + 10 < userEvents.get(i).getTimpestamp() ){
					start3 = start3 + 10;
				}
			}
			
			if ( userEvents.get(i).getTimpestamp() <= start4 + 10 ) {
				//daca se incadreaza in fereastra evenimentul curent
				
				if ( userEvents.get(i).getArea().getPathInEditor().get(0).getType().contains("menu") ){
					u4[i4].add(userEvents.get(i));
				}
				
				if ( i == userEvents.size() - 1){
					if ( u4[i4].size() > 1 ){
						clusters.add(new Cluster(u4[i4], u4[i4].get(0).getTimpestamp() , u4[i4].get(u4[i4].size() - 1 ).getTimpestamp() + window - 1));
					}
				}
			}
			
			else {
				
				//adaug in lista de clustere ce am contruit pana acum
				if ( u4[i4].size() > 1 ) {
					clusters.add(new Cluster(u4[i4], u4[i4].get(0).getTimpestamp() , u4[i4].get(u4[i4].size() - 1 ).getTimpestamp() + window - 1));
					i4 = i4 + 1;
					if ( userEvents.get(i).getArea().getPathInEditor().get(0).getType().contains("menu")){

						u4[i4].add(userEvents.get(i));
					}
				}
				
				else {
					if ( userEvents.get(i).getArea().getPathInEditor().get(0).getType().contains("menu")){
						i4 = i4 + 1;
						u4[i4].add(userEvents.get(i));
					}
				}
				
				while( start4 + 10 < userEvents.get(i).getTimpestamp() ){
					start4 = start4 + 10;
				}
			}
			
			if ( userEvents.get(i).getTimpestamp() <= start5 + 10 ) {
				//daca se incadreaza in fereastra evenimentul curent
				
				if ( userEvents.get(i).getArea().getPathInEditor().get(0).getType().contains("menu-button") ){
					u5[i5].add(userEvents.get(i));
				}
				
				if ( i == userEvents.size() - 1){
					if ( u5[i5].size() > 1 ){
						clusters.add(new Cluster(u5[i5], u5[i5].get(0).getTimpestamp() , u5[i5].get(u5[i5].size() - 1 ).getTimpestamp() + window - 1));
					}
				}
			}
			
			else {
				
				//adaug in lista de clustere ce am contruit pana acum
				if ( u5[i5].size() > 1 ) {
					clusters.add(new Cluster(u5[i5], u5[i5].get(0).getTimpestamp() , u5[i5].get(u5[i5].size() - 1 ).getTimpestamp() + window - 1));
					i5 = i5 + 1;
					if ( userEvents.get(i).getArea().getPathInEditor().get(0).getType().contains("menu-button")){

						u5[i5].add(userEvents.get(i));
					}
				}
				
				else {
					if ( userEvents.get(i).getArea().getPathInEditor().get(0).getType().contains("menu-button")){
						i5 = i5 + 1;
						u5[i5].add(userEvents.get(i));
					}
				}
				
				while( start5 + 10 < userEvents.get(i).getTimpestamp() ){
					start5 = start5 + 10;
				}
			}
			
			if ( userEvents.get(i).getTimpestamp() <= start6 + 10 ) {
				//daca se incadreaza in fereastra evenimentul curent
			
				if ( userEvents.get(i).getArea().getPathInEditor().get(0).getType().contains("icon") ){
					u6[i6].add(userEvents.get(i));
				}
				
				if ( i == userEvents.size() - 1){
					if ( u6[i6].size() > 1 ){
						clusters.add(new Cluster(u6[i6], u6[i6].get(0).getTimpestamp() , u6[i6].get(u6[i6].size() - 1 ).getTimpestamp() + window - 1));
					}
				}
			}
			
			else {
			
				//adaug in lista de clustere ce am contruit pana acum
				if ( u6[i6].size() > 1 ) {
					clusters.add(new Cluster(u6[i6], u6[i6].get(0).getTimpestamp() , u6[i6].get(u6[i6].size() - 1 ).getTimpestamp() + window - 1));
					i6 = i6 + 1;
					if ( userEvents.get(i).getArea().getPathInEditor().get(0).getType().contains("icon")){

						u6[i6].add(userEvents.get(i));
					}
				}
				
				else {
					if ( userEvents.get(i).getArea().getPathInEditor().get(0).getType().contains("icon")){
						i6 = i6 + 1;
						u6[i6].add(userEvents.get(i));
					}
				}
				
				
				
				while( start6 + 10 < userEvents.get(i).getTimpestamp() ){
					start6 = start6 + 10;
				}
			}
			
			if ( userEvents.get(i).getTimpestamp() <= start7 + 10 ) {
				//daca se incadreaza in fereastra evenimentul curent
			
				if ( userEvents.get(i).getArea().getPathInEditor().get(0).getType().contains("dialog") ){
					u7[i7].add(userEvents.get(i));
				}
				
				if ( i == userEvents.size() - 1){
					if ( u7[i7].size() > 1 ){
						clusters.add(new Cluster(u7[i7], u7[i7].get(0).getTimpestamp() , u7[i7].get(u7[i7].size() - 1 ).getTimpestamp() + window - 1));
					}
				}
			}
			
			else {
				
				//adaug in lista de clustere ce am contruit pana acum
				if ( u7[i7].size() > 1 ) {
					clusters.add(new Cluster(u7[i7], u7[i7].get(0).getTimpestamp() , u7[i7].get(u7[i7].size() - 1 ).getTimpestamp() + window - 1));
					i7 = i7 + 1;
					if ( userEvents.get(i).getArea().getPathInEditor().get(0).getType().contains("dialog")){

						u7[i7].add(userEvents.get(i));
					}
				}
				
				else {
					if ( userEvents.get(i).getArea().getPathInEditor().get(0).getType().contains("dialog")){
						i7 = i7 + 1;
						u7[i7].add(userEvents.get(i));
					}
				}
				
				while( start7 + 10 < userEvents.get(i).getTimpestamp() ){
					start7 = start7 + 10;
				}
			}
			
			if ( userEvents.get(i).getTimpestamp() <= start8 + 10 ) {
				//daca se incadreaza in fereastra evenimentul curent
			
				if ( userEvents.get(i).getArea().getPathInEditor().get(0).getType().contains("card") == false &&
						userEvents.get(i).getArea().getPathInEditor().get(0).getType().contains("input") == false &&
						userEvents.get(i).getArea().getPathInEditor().get(0).getType().contains("page") == false &&
						userEvents.get(i).getArea().getPathInEditor().get(0).getType().contains("menu") == false &&
						userEvents.get(i).getArea().getPathInEditor().get(0).getType().contains("menu-button") == false &&
						userEvents.get(i).getArea().getPathInEditor().get(0).getType().contains("icon") == false &&
						userEvents.get(i).getArea().getPathInEditor().get(0).getType().contains("dialog") == false ){
					
					u8[i8].add(userEvents.get(i));
				}
				
				if ( i == userEvents.size() - 1){
					if ( u8[i8].size() > 1 ){
						clusters.add(new Cluster(u8[i8], u8[i8].get(0).getTimpestamp() , u8[i8].get(u8[i8].size() - 1 ).getTimpestamp() + window - 1));
					}
				}
			}
			
			else {
				
				//adaug in lista de clustere ce am contruit pana acum
				if ( u8[i8].size() > 1 ) {
					clusters.add(new Cluster(u8[i8], u8[i8].get(0).getTimpestamp() , u8[i8].get(u8[i8].size() - 1 ).getTimpestamp() + window - 1));
					i8 = i8 + 1;
					if ( userEvents.get(i).getArea().getPathInEditor().get(0).getType().contains("card") == false &&
							userEvents.get(i).getArea().getPathInEditor().get(0).getType().contains("input") == false &&
							userEvents.get(i).getArea().getPathInEditor().get(0).getType().contains("page") == false &&
							userEvents.get(i).getArea().getPathInEditor().get(0).getType().contains("menu") == false &&
							userEvents.get(i).getArea().getPathInEditor().get(0).getType().contains("menu-button") == false &&
							userEvents.get(i).getArea().getPathInEditor().get(0).getType().contains("icon") == false &&
							userEvents.get(i).getArea().getPathInEditor().get(0).getType().contains("dialog") == false ){

						u8[i8].add(userEvents.get(i));
					}
				}
				
				else {
					if ( userEvents.get(i).getArea().getPathInEditor().get(0).getType().contains("card") == false &&
							userEvents.get(i).getArea().getPathInEditor().get(0).getType().contains("input") == false &&
							userEvents.get(i).getArea().getPathInEditor().get(0).getType().contains("page") == false &&
							userEvents.get(i).getArea().getPathInEditor().get(0).getType().contains("menu") == false &&
							userEvents.get(i).getArea().getPathInEditor().get(0).getType().contains("menu-button") == false &&
							userEvents.get(i).getArea().getPathInEditor().get(0).getType().contains("icon") == false &&
							userEvents.get(i).getArea().getPathInEditor().get(0).getType().contains("dialog") == false ){
						i8 = i8 + 1;
						u8[i8].add(userEvents.get(i));
					}
				}
				
				while( start8 + 10 < userEvents.get(i).getTimpestamp() ){
					start8 = start8 + 10;
				}
			}
		
		}
		
		return clusters;	
	}
	
	
		public static class Cluster{
		
			private List<UserEvent> userEvents = new ArrayList<UserEvent>();
		
			private int startTimeStamp;
			private int endTimeStamp;

			public Cluster( List<UserEvent> userEvents , int startTimeStamp , int endTimeStamp){
				this.userEvents = userEvents;
				this.startTimeStamp = startTimeStamp;
				this.endTimeStamp = endTimeStamp ;
			}
		
			public void addUserEvent( UserEvent e){
				userEvents.add(e);
			}
		
			public void setEndTimeStamp(int endTimeStamp) {
				this.endTimeStamp = endTimeStamp;
			}
		
			public void setStartTimeStamp(int startTimeStamp) {
				this.startTimeStamp = startTimeStamp;
			}
		
			public void setUserEvents(List<UserEvent> userEvents) {
				this.userEvents = userEvents;
			}
		
			public int getEndTimeStamp() {
				return endTimeStamp;
			}
		
			public int getStartTimeStamp() {
				return startTimeStamp;
			}
		
			public List<UserEvent> getUserEvents() {
				return userEvents;
			}
			
			@Override
			public String toString() {
				return "Cluster [userEvents=" + userEvents + ", startTimeStamp=" + startTimeStamp + ", endTimeStamp="
						+ endTimeStamp + "]";
			}

			@Override
			public int hashCode() {
				final int prime = 31;
				int result = 1;
				result = prime * result + endTimeStamp;
				result = prime * result + startTimeStamp;
				result = prime * result + ((userEvents == null) ? 0 : userEvents.hashCode());
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
				Cluster other = (Cluster) obj;
				if (endTimeStamp != other.endTimeStamp)
					return false;
				if (startTimeStamp != other.startTimeStamp)
					return false;
				if (userEvents == null) {
					if (other.userEvents != null)
						return false;
				} else if (!userEvents.equals(other.userEvents))
					return false;
				return true;
			}
		}
}
