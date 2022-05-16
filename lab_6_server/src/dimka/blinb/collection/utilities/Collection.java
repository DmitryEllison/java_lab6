package dimka.blinb.collection.utilities;

import dimka.blinb.collection.interfaces.CollectionAble;
import dimka.blinb.collection.interfaces.Comparable;
import dimka.blinb.collection.objects.Route;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.Map;

public class Collection implements Comparable, CollectionAble, Serializable {
    /**
     * Basic collection processing methods.
     **/
    protected static LinkedHashMap<Integer, Route> LHM = new LinkedHashMap<>();
    protected static String creationTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    protected String collectionName = "MyCollection";
    public boolean IS_WORKING = true;

    public void printLHM() {
        LHM.values().forEach((v) -> System.out.println(v));
    }

    public LinkedHashMap<Integer, Route> getLHM() {
        return LHM;
    }

    public void setLHM(LinkedHashMap<Integer, Route> LHM){
        this.LHM = LHM;
    }

    /**
     * Closing the program
     **/
    public void turnOff(){
        this.IS_WORKING = false;
    }

    /**
     * Adding new element to collection
     * @param route
     * @return
     */
    public boolean add(Route route){
        assert hasElement(route.getID()) : "The element is in the collection already\nThe element has been updated!";
        LinkedHashMap<Integer, Route> temp = new LinkedHashMap<Integer, Route>();

        /**
         * If the same key is already exist then we just change him
         */
        if (hasElement(route.getID())) {
            System.out.println("An element with the same key already being!");
            changeKey(route);
            add(route);
            // System.out.println("The key has been changed because a element with the same key is already exist");
            // System.out.println("The new key: " + route.getID());
        } else if (LHM.isEmpty()) {
            LHM.put(route.getID(), route);
        } else {
            LHM.put(route.getID(), route);
            LHM.keySet().stream().sorted().forEach(k -> temp.put(k, LHM.get(k)));
            LHM = temp;
        }
        return true;
    }

    public void changeKey(Route route){
        route.setID(route.createID());
    }

    public boolean hasElement(Integer key){
        for(Map.Entry<Integer, Route> element: LHM.entrySet())
            if (element.getKey() == key)
                return true;
        return false;
    }

    /**
     * Change the name of the collection
     * @param name
     **/
    public void setName(String name){
        this.collectionName = name;
    }

    /**
     * Return information about the collection
     * @return
     **/
    public String toString(){
        return "Collection name: " + this.collectionName + "\n" +
                "Collection type: " + LHM.getClass().getName() + '\n' +
                "Creation time: " + this.creationTime + '\n' +
                "Amount of collection: " + LHM.size();
    }

    public String LHMtoString(){
        String toString ="";
        for(Map.Entry<Integer, Route> element: LHM.entrySet()){
            toString += element.toString() + '\n';
        }
        return toString;
    }

    public Integer compareTo(Route r1, Route r2){
        return r2.getID()-r1.getID();
    }
}
