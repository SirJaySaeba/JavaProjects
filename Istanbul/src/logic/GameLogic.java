package logic;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import locations.Location;
import locations.places.Brunnen;
import locations.places.Edelsteinhaendler;
import locations.places.Gewuerzlager;
import locations.places.GrosseMoschee;
import locations.places.GrosserMarkt;
import locations.places.Karawanserei;
import locations.places.KleineMoschee;
import locations.places.KleinerMarkt;
import locations.places.Obstlager;
import locations.places.Polizeiwache;
import locations.places.Postamt;
import locations.places.Schwarzmarkt;
import locations.places.Sultanspalast;
import locations.places.Teestube;
import locations.places.Tuchlager;
import locations.places.Wagnerei;

public class GameLogic {
	
	// 0 = bottom, size = top
	private List<Location> locations = new ArrayList<Location>();
	private List<String> takenSpot = new ArrayList<String>();
	public GameLogic(){
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		Location brunnen = (Brunnen) context.getBean("brunnen");
		
			this.locations.add(new Karawanserei());
			this.locations.add(new Teestube());
			this.locations.add(new Schwarzmarkt());
			this.locations.add(new KleinerMarkt());
			this.locations.add(new GrosserMarkt());
			this.locations.add(new KleineMoschee());
			this.locations.add(new GrosseMoschee());
			this.locations.add(new Wagnerei());
			this.locations.add(new Obstlager());
			this.locations.add(new Gewuerzlager());
			this.locations.add(new Tuchlager());
			this.locations.add(new Postamt());
			this.locations.add(new Polizeiwache());
			this.locations.add(new Sultanspalast());
			this.locations.add(new Edelsteinhaendler());
			this.locations.add(brunnen);
			
			int i = 0;
			do{				
				int randColumn = (int)(Math.random() * 4);
				int randRow = (int)(Math.random() * 4);
				if(!takenSpot.contains(Location.getLocationCoordinates(randRow, randColumn))){				
					takenSpot.add(Location.getLocationCoordinates(randRow, randColumn));
					System.out.println(Location.getLocationCoordinates(randRow, randColumn));

					i++;
				}else{
					continue;
				}
				
			}while(i<locations.size());
			

	}

	public List<Location> getLocations() {
		return this.locations;
	}

}
