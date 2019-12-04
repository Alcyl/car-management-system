package de.oszimt.carmanagement.concepts;

import de.oszimt.carmanagement.interfaces.ISort;

public class Descending implements ISort{

	@Override
	public void sort() {
		System.out.println("Descending");
		
	}

}
