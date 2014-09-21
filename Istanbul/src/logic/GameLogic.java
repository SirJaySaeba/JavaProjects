package logic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import locations.Location;

public class GameLogic {
	
	// 0 = bottom, size = top
	private List<Location> locations = new ArrayList<Location>();

	public GameLogic(){
		
		List<String> AllAvailableLocations = new ArrayList<>();
		prepareLocations(AllAvailableLocations);
		Collection<String> setLocations = new ArrayList<>();
		
		for(int i = 0; i<16; i++){			
			int randColumn = (int)(Math.random() * 16)%4;
			int randRow = (int)(Math.random() * 16)%4;
			
			if(!setLocations.contains(Location.getLocationCoordinates(randRow, randColumn))){				
				setLocations.add(Location.getLocationCoordinates(randRow, randColumn));
				addLocationToMap(AllAvailableLocations.get(i), randRow, randColumn);
			}else{
				i--;
				continue;
			}
			
		}
		

	}

	private void addLocationToMap(String type, int row, int column) {
		Location location = new Location(type, row, column);
		
		this.locations.add(location);
	}
	private void prepareLocations(List<String> setOfLocations){

		setOfLocations.add(Location.TEESTUBE);
		setOfLocations.add(Location.BRUNNEN);
		setOfLocations.add(Location.EDELSTEINHAENDLER);
		setOfLocations.add(Location.KARAWANSEREI);
		setOfLocations.add(Location.LAGER_GEWUERZ);
		setOfLocations.add(Location.LAGER_OBST);
		setOfLocations.add(Location.LAGER_TUCH);
		setOfLocations.add(Location.MARKT_GROSS);
		setOfLocations.add(Location.MARKT_KLEIN);
		setOfLocations.add(Location.MOSCHEE_GROSS);
		setOfLocations.add(Location.MOSCHEE_KLEIN);
		setOfLocations.add(Location.POLIZEIWACHE);
		setOfLocations.add(Location.SCHWARZMARKT);
		setOfLocations.add(Location.WAGNEREI);
		setOfLocations.add(Location.POSTAMT);
		setOfLocations.add(Location.SULTANSPALAST);	
	}
	
	private boolean isNonCapturedPieceAtLocation(int row, int column) {
		for (Location piece : this.locations) {
			if( piece.getRow() == row
					&& piece.getColumn() == column
					&& piece.isCaptured() == false){
				return true;
			}
		}
		return false;
	}

	/**
	 * @return the internal list of pieces
	 */
	public List<Location> getPieces() {
		return this.locations;
	}

}
