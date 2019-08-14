package syndicate;

public final class Singleton {
	private static SyndicateCG synd;
	
	public static SyndicateCG getInstance() {
		if(synd == null) {
			synd = new SyndicateCG();
		}		
		return synd;
	}
}
