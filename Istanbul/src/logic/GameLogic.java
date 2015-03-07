package logic;

import java.util.ArrayList;
import java.util.List;

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
import pawns.Pawn;

public class GameLogic {
	
	// 0 = bottom, size = top
	private List<Location> locations = new ArrayList<Location>();
	private List<String> takenSpot = new ArrayList<String>();
	private List<Pawn> pieces = new ArrayList<Pawn>();

	public GameLogic(){
			Location brunnen = new Brunnen();
			Location teestube = new Teestube();
			Location schwarzmarkt = new Schwarzmarkt();
			Location kleinerMarkt = new KleinerMarkt();
			Location grosserMarkt = new GrosserMarkt();
			Location kleineMoschee = new KleineMoschee();
			Location grosseMoschee = new GrosseMoschee();
			Location wagnerei = new Wagnerei();
			Location obstlager = new Obstlager();
			Location gewuerzlager = new Gewuerzlager();
			Location tuchlager = new Tuchlager();
			Location postamt = new Postamt();
			Location polizeiwache = new Polizeiwache();
			Location sultanspalast = new Sultanspalast();
			Location edelsteinhaendler = new Edelsteinhaendler();
			Location karawanserei = new Karawanserei();
			
			this.locations.add(brunnen);
			this.locations.add(teestube);
			this.locations.add(schwarzmarkt);
			this.locations.add(kleinerMarkt);
			this.locations.add(grosserMarkt);
			this.locations.add(kleineMoschee);
			this.locations.add(grosseMoschee);
			this.locations.add(wagnerei);
			this.locations.add(obstlager);
			this.locations.add(gewuerzlager);
			this.locations.add(tuchlager);
			this.locations.add(postamt);
			this.locations.add(polizeiwache);
			this.locations.add(sultanspalast);
			this.locations.add(edelsteinhaendler);
			this.locations.add(karawanserei);
			
			int locationCounter = 0;
			do{				
				int randColumn = (int)(Math.random() * 4);
				int randRow = (int)(Math.random() * 4);
				if(!takenSpot.contains(Location.getLocationCoordinates(randRow, randColumn))){				
					takenSpot.add(Location.getLocationCoordinates(randRow, randColumn));
					System.out.println(Location.getLocationCoordinates(randRow, randColumn));
					locations.get(locationCounter).setColumn(randColumn);
					locations.get(locationCounter).setRow(randRow);
					locations.get(locationCounter).resetLocationPosition();
					locationCounter++;
				}else{
					continue;
				}
				
			}while(locationCounter<locations.size());
			
			int currentColumn = Location.COLUMN_A;
			for (int i = 0; i < 8; i++) {
				createAndAddPawn(Location.ROW_1, currentColumn);
				currentColumn++;
			}

	}
	private void createAndAddPawn(int row, int column) {
		Pawn pawn = new Pawn(row, column);
		this.pieces.add(pawn);
	}

	public List<Location> getLocations() {
		return this.locations;
	}
	
	public List<Pawn> getPieces() {
		return this.pieces;
	}

}
