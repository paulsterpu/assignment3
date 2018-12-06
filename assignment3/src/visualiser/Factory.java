package visualiser;

import java.util.List;

public class Factory {
	
	public static EditorArea createArea( List<EditorElement> pathInEditor ){
		
		if ( pathInEditor.get(0).getType().contains("card")){
			return new Canvas(pathInEditor);
		}
		
		if ( pathInEditor.get(0).getType().contains("input")){
			return new Canvas(pathInEditor);
		}
		
		if ( pathInEditor.get(0).getType().contains("page")){
			return new Canvas(pathInEditor);
		}
		
		if ( pathInEditor.get(0).getType().contains("menu")){
			return new Menu(pathInEditor);
		}
		
		if ( pathInEditor.get(0).getType().contains("menu-button")){
			return new Menu(pathInEditor);
		}
		
		if ( pathInEditor.get(0).getType().contains("icon")){
			return new Menu(pathInEditor);
		}
		
		if ( pathInEditor.get(0).getType().contains("dialog")){
			return new DialogBox(pathInEditor);
		}
		
		else {
			return new UnknownArea(pathInEditor);
		}
		 
				/*switch( pathInEditor.get(0).getType() ){
				case "card":
					return new Canvas(pathInEditor);
				
				case "input":
					return new Canvas(pathInEditor);
				
				case "page":
					return new Canvas(pathInEditor);
					
				case "menu":
					return new Menu(pathInEditor);
					
				case "menu-buton":
					return new Menu(pathInEditor);
				
				case "icon":
					return new Menu(pathInEditor);
				}
				
				return new UnknownArea(pathInEditor);*/
		
		}
}


