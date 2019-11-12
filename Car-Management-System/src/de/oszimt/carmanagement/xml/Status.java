package de.oszimt.carmanagement.xml;

/**
 * Defines all possible status
 * @author Michael Eiserbeck
 *
 */
public enum Status {
	
	FACTORYNEW, BROKEN, DAMAGED;
	
	public String toString() {
		switch(this) {
		case FACTORYNEW:
			return "factory-new";
		case BROKEN:
			return "broken";
		case DAMAGED:
			return "damaged";
			default:
				return null;
		}
	}
	
	
}


