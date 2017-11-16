/**
 * This class represents a Pet with a name, type, and cost.
 *
 * @author Karl McGuire
 * @version 10/20/17
 */
public class Pet {
    private String type;
    private String name;
    private double costToAdopt;

    /**
     * Pet() is the default constructor and sets all fields to be empty and the cost to 0.
     */
    public Pet() {
        type = "";
        name = "";
        costToAdopt = 0.0;
    }

    /**
     * Pet(...) is the constructor with arguments.
     *
     * @param String t is the type of the pet
     * @param Stirng n is the name of the pet
     * @param double c is the cost of the pet
     */
    public Pet(String t, String n, double c) {
        type = t;
        name = n;
        costToAdopt = c;
    }

    /**
     * getType() returns the type of pet.
     *
     * @return type of pet
     */
    public String getType() {
        return type;
    }

    /**
     * getName() returns the name of the pet.
     *
     * @return name of pet
     */
    public String getName() {
        return name;
    }

    /**
     * getCostToAdopt() returns the cost to adopt the pet.
     *
     * @return cost to adopt pet
     */
    public double getCostToAdopt() {
        return costToAdopt;
    }

    /**
     * compareTo() compares the cost to adopt two pets.
     *
     * @return 0 if the costs are equal, 1 if the param pet cost is less than 
     * the parent pet, and -1 if the parent pet is less than the param pet
     */
    public int compareTo(Pet pet) {
        if(costToAdopt == pet.getCostToAdopt())
            return 0;
        else if(costToAdopt > pet.getCostToAdopt())
            return 1;
        else
            return -1;
    }

    /**
     * equals() compares two pets and determines if they're equal.
     *
     * @return if the param pet is equal to the parent pet
     */
    public boolean equals(Pet pet) {
        // compare type, name, and cost to adopt
        if(type == pet.getType() &&
           name == pet.getName() &&
           costToAdopt == pet.getCostToAdopt())
            return true;
    
        // they're not equal
        return false;
    }

    /**
     * toString() represents the pet in String form.
     *
     * @return string representation of the pet
     */
    public String toString() {
        return name + " is a " + type + " and costs $" + costToAdopt + ".";
    }
}
