package interfaces.kobolde;

public class Friend implements Behaviour{

	private final Kobold friend;
	
	public Friend(Kobold friend) {
		if(friend == null){
			throw new NullPointerException("den hast du dir doch blo� ausgedacht...");
		}
		
		this.friend = friend;
	}

	@Override
	public int modify(int i) {
		return friend.messUp(i);
	}

}
