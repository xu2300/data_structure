package train;

import java.util.HashMap;
import java.util.Map;

public class train {
	private int trainID;
    private String trainName;
    private Map<station, Double> trainStationsWithFares;

    public train(int ID, String trainName, station[] stations) {
    trainStationsWithFares = new HashMap<station, Double>();
    for(station s : stations){
    	trainStationsWithFares.put(s, new Double(0.0));
    }
    }

public class station{
	private int id;
	private int name;
	//getter and setter and contructors
}

public class Passenger {
    private String Name;
    private int id;
    private int age;
    private static final enum { Male, Female } gender; 
}

public class TicketDetails {
    private Train t;
    private Station from;
    private Station to;
    private Passenger passenger;
    // Getters and Setters
}
