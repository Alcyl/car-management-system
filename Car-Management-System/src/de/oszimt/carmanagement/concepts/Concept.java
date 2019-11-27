package de.oszimt.carmanagement.concepts;


import de.oszimt.carmanagement.interfaces.Datalayer;
import de.oszimt.carmanagement.interfaces.ISort;
import de.oszimt.carmanagement.interfaces.ITechconcept;

public abstract class Concept implements ITechconcept{
	
	protected ISort sortInstance;
	protected Datalayer db;
	
	public Concept (Datalayer db){
		this.db = db;
	}
	
	public void sort() {
		sortInstance.sort();
	}

	public void setSortInstance(ISort sortInstance) {
		this.sortInstance = sortInstance;
	}

}
