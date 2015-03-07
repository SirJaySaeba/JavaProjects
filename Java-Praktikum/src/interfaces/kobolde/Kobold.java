package interfaces.kobolde;

public class Kobold {

	private String name;
	public Behaviour[] behaviour;

	public Kobold(String name, Behaviour... behaviour) {
		this.name = name;
		this.behaviour = behaviour.clone();
	}
	
	public String getName() {
		return name;
	}

	
	public int messUp(int i){
		for(Behaviour b : behaviour){
			i = b.modify(i);
		}
		return i;
	}
	
}
