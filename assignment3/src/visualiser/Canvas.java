package visualiser;

import java.util.List;


public final class Canvas extends EditorArea {
	
	// TODO(3): Adaugati campurile, constructorii necesari si metodele care lipsesc.
	
	public Canvas(List<EditorElement> pathInEditor) {
		super(pathInEditor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Color getVisualisationColor() {
		
		return Color.RED;
	}
	
}
