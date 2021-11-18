import java.util.ArrayList;

public class Spell {
	String spellName;
	ArrayList<Element> elements;
	
	public Spell(String spellName) {
		super();
		this.spellName = spellName;
		elements = new ArrayList<Element>();
	}
	
	public void addElement(Element element){
		elements.add(element);
	}
	
	public void cast() {
		System.out.println("Casteando " + spellName);
		for (Element element : elements) {
			element.cast();
		}
	}
}
