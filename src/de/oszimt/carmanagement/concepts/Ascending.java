package de.oszimt.carmanagement.concepts;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import de.oszimt.carmanagement.interfaces.ISort;
import de.oszimt.carmanagement.xml.Car;

public class Ascending implements ISort{

	@Override
	public void sort(List<Car> cars) {
		Collections.sort(cars, new Comparator<Car>() {
			@Override
			public int compare(Car a, Car b) {
				return a.getId().compareTo(b.getId());
			}
		});
	}

}
