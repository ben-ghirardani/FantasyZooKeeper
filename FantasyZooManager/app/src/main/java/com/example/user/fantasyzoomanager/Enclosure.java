package com.example.user.fantasyzoomanager;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by user on 10/08/2017.
 */



public class Enclosure {

    private String name;
    private int price;
    private ArrayList<Enclosable> creatureEnclosure;
    private ArrayList<Visitor> visitorSeating;
    private ArrayList<Vegetable> foodTrough;

    public Enclosure(String name, int price) {
        this.name = name;
        this.price = price;
        this.creatureEnclosure = new ArrayList<Enclosable>();
        this.visitorSeating = new ArrayList<Visitor>();
        this.foodTrough = new ArrayList<Vegetable>();
    }

    public String getName() {
        return this.name;
    }

    public int getPrice() {
        return this.price;
    }

    public int countCreatures() {
        int count = 0;
        for (Enclosable enclosable : creatureEnclosure) {
            if (enclosable != null) {
                count++;
            }
        }
        return count;
    }

    public int countVisitors() {
        int count = 0;
        for (Enclosable enclosable : visitorSeating) {
            if (enclosable != null) {
                count++;
            }
        }
        return count;
    }

    public int countVegetables() {
        int count = 0;
        for (Vegetable veg : foodTrough) {
            if(veg != null) {
                count++;
            }
        }
        return count;
    }

//    Standard add and remove methods.

    public void addToCreatureEnclosure(Enclosable entity) {
        creatureEnclosure.add(entity);
    }

    public void removeFromCreatureEnclosure(Enclosable entity) {
        creatureEnclosure.remove(entity);
    }

    public void addToVisitorSeating(Visitor visitor) {
        visitorSeating.add(visitor);
    }

    public void removeVisitorFromSeating(Visitor visitor) {
        visitorSeating.remove(visitor);
    }

    public void addVegetableToFoodTrough(Vegetable veg) {
        foodTrough.add(veg);
    }

    public void removeVegetableFromFoodTrough(Vegetable veg) {
        foodTrough.remove(veg);
    }

//    Method to add a Visitor and remove funds from them based on Enclosure price.

    public String addVisitorToSeatingAndPay(Visitor visitor) {
        if (visitor.visitorFunds() < this.price) {
            return visitor.getName() + " cannot afford to visit this enclosure.";
        } else {
            visitor.money = visitor.money - this.price;
            visitorSeating.add(visitor);
        }
        return visitor.getName() + " has paid and taken a seat.";
    }

//    Count Number of predators.

    public int countPredatorsInCreatureEnclosure() {
        int predatorCount = 0;
        for (Enclosable currentOccupant : creatureEnclosure) {
            if (currentOccupant.isPredator() == true)
                predatorCount++;
        }
        return predatorCount;
    }

//        Method to make sure only one predator can be added to an enclosure.


    public String addCreatureToEnclosureCheckPredator(Creature creature) {
        if (this.countPredatorsInCreatureEnclosure() > 0 && creature.predator == true) {
            return creature.getName() + " cannot be added to this enclosure as there is " +
                    "already one predator here. That would be dangerous.";
        } else {
            creatureEnclosure.add(creature);
            return creature.getName() + " has been added to " + "the " + this.getName();
        }
    }

//    Method to check visitor funds on leaving an enclosure, release them if they have enough money,
//    transfer them to the creature enclosure if not.

    public String removeVisitorIfTheyHaveMoney(Visitor visitor) {
        if (visitor.visitorFunds() <= 0) {
            visitorSeating.remove(visitor);
            addToCreatureEnclosure(visitor);
            return "A visitor has entered the creature enclosure.";
        } else {
            visitorSeating.remove(visitor);
            return visitor.getName() + " has left the enclosure and still has money to spend.";
        }
    }



//    This is a test method to check the functionality of the 'instance of' operator.

    public int findDragonInArrayOfItems() {
        int numberOfDragons = 0;
        for (Enclosable entity : creatureEnclosure) {
            if (entity instanceof Dragon) {
                numberOfDragons++;
            }
        }
        return numberOfDragons;
    }

    //    Check for instances of a predator. Cast them into their original form and record their
    //    agility. Check for instances of Visitors. If their agility is less than the predator
    //    agility put them in it's belly ArrayList.


    //    Test method to loop through an arraylist, check for 'instances of' the Dragon class,
    //    cast the object as a Dragon and run a method available only to Dragons.

    public int comparePredatorAgilityToVisitors() {
        int predatorAgility = 0;
        for (Enclosable entity : creatureEnclosure) {
            if (entity instanceof Dragon) {
                Dragon originalDragon = (Dragon) entity;
                predatorAgility = originalDragon.getAgility();
            }
        }
        return predatorAgility;
    }


    // To remove Visitors based on comparison to Creature agility.

    // While loop. While there is 1 predator and more than one entity in the enclosure,
    // loop through and compare the visitor agility to the predator agility. Remove them from the
    // arraylist if they win, add them to the belly.


    public void resolveVisitorsInDragonEnclosure() {
        int currentOccupants = countCreatures();
        int predatorAgility = 0;
        Dragon originalDragon = null;
        Visitor originalVisitor = null;
        for (Enclosable beast : creatureEnclosure) {
            if (beast instanceof Dragon) {
                originalDragon = (Dragon) beast;
                predatorAgility = originalDragon.getAgility();
            }
        }
        while (currentOccupants > 1) {
            for (Enclosable person : creatureEnclosure) {
                if (person instanceof Visitor) {
                    originalVisitor = (Visitor) person;
                }
            }
            if (originalVisitor.visitorAgility() <= predatorAgility && originalVisitor != null) {
            removeFromCreatureEnclosure(originalVisitor);
            originalDragon.addToBelly(originalVisitor);
            currentOccupants = countCreatures();
            } else {
                creatureEnclosure.remove(originalVisitor);
            }
        }
    }

    //  Create a loop similar to the one above for the Unicorn enclosure. Unicorns are nice so
    //  they will assist visitors instead of eating them.

    //  Create a method to loop through arraylist and count visitors for use in unicorn enclosure
    //  method.

    public int countVisitorsInCreatureEnclosure() {
        int numVisitors = 0;
        for (Enclosable person : creatureEnclosure) {
            if (person instanceof Visitor) {
                numVisitors++;
            }
        }
        return numVisitors;
    }

    public int countUnicornsInCreatureEnclosure() {
        int numUnicorns = 0;
        for (Enclosable creature : creatureEnclosure) {
            if (creature instanceof Unicorn) {
                numUnicorns++;
            }
        }
        return numUnicorns;
    }

    public int countDragonsInCreatureEnclosure() {
        int numDragons = 0;
        for (Enclosable creature : creatureEnclosure) {
            if (creature instanceof Dragon) {
                numDragons++;
            }
        }
        return numDragons;
    }

    // Unicorns provide people with money and send them on their way if they get placed
    // in the creatureEnclosure arraylist.

    public void resolveVisitorsInUnicornEnclosure() {
        int currentNumVisitors = countVisitorsInCreatureEnclosure();
        int currentNumUnicorns = countUnicornsInCreatureEnclosure();
        Visitor originalVisitor = null;
        while (currentNumVisitors > 0 &&  currentNumUnicorns > 0) {
            for (Enclosable person : creatureEnclosure) {
                if (person instanceof Visitor) {
                    originalVisitor = (Visitor) person;
                }
            }
            originalVisitor.money = originalVisitor.money + 10;
            removeFromCreatureEnclosure(originalVisitor);
            currentNumVisitors = countVisitorsInCreatureEnclosure();
            currentNumUnicorns = countUnicornsInCreatureEnclosure();
        }
    }

    // Write a unifying method that takes in a dragon and a few unicorns, and compares agility
    // to see whether visitors are eaten or provided with money. First attempt, hacked together
    // from several other methods, could be more concise.

    public void resolveVisitorsInMixedEnclosure() {
        int currentNumVisitors = countVisitorsInCreatureEnclosure();
        int dragonAgility = 0;
        ArrayList<Integer> unicornAgilityList = new ArrayList<>();
        int unicornAgility = 0;
        Dragon originalDragon = null;
        Visitor originalVisitor = null;
            for (Enclosable dragon : creatureEnclosure) {
                if (dragon instanceof Dragon) {
                    originalDragon = (Dragon) dragon;
                    dragonAgility = ((Dragon) dragon).getAgility();
                }
            }
            for (Enclosable unicorn : creatureEnclosure) {
                if(unicorn instanceof Unicorn) {
                    unicornAgilityList.add(((Unicorn) unicorn).getAgility());
                    unicornAgility = Collections.max(unicornAgilityList);

                }
            }
            if (dragonAgility > unicornAgility) {
                for (Enclosable beast : creatureEnclosure) {
                    if (beast instanceof Dragon) {
                        originalDragon = (Dragon) beast;
                    }
                }
                while (currentNumVisitors > 0) {
                    for (Enclosable person : creatureEnclosure) {
                        if (person instanceof Visitor) {
                            originalVisitor = (Visitor) person;
                        }
                    }
                    removeFromCreatureEnclosure(originalVisitor);
                    originalDragon.addToBelly(originalVisitor);
                    currentNumVisitors = countVisitorsInCreatureEnclosure();
                }
            }
            else if (unicornAgility > dragonAgility) {
                while (currentNumVisitors > 0) {
                for (Enclosable person : creatureEnclosure) {
                    if (person instanceof Visitor) {
                        originalVisitor = (Visitor) person;
                    }
                }
                originalVisitor.money = originalVisitor.money + 10;
                removeFromCreatureEnclosure(originalVisitor);
                currentNumVisitors = countVisitorsInCreatureEnclosure();
                }
            }
    }

    //  Re-write of the method above to be a little DRY-er.

    public void resolveVisitorsInMixedEnclosureV2() {
//       Initialize variables.
        int currentNumVisitors = countVisitorsInCreatureEnclosure();
        int dragonAgility = 0;
        ArrayList<Integer> unicornAgilityList = new ArrayList<>();
        Dragon originalDragon = null;
        Visitor originalVisitor = null;

//        Determine who the dragon is.
        for (Enclosable dragon : creatureEnclosure) {
            if (dragon instanceof Dragon) {
                originalDragon = (Dragon) dragon;
                dragonAgility = ((Dragon) dragon).getAgility();
            }
        }
//        Add the agility of all the unicorns to the arraylist.
        for (Enclosable unicorn : creatureEnclosure) {
            if(unicorn instanceof Unicorn) {
                unicornAgilityList.add(((Unicorn) unicorn).getAgility());
            }
        }

//        If dragon agility is higher than highest unicorn, run a loop.
        if (dragonAgility > Collections.max(unicornAgilityList)) {
            while (currentNumVisitors > 0) {
                for (Enclosable person : creatureEnclosure) {
                    if (person instanceof Visitor) {
                        originalVisitor = (Visitor) person;
                    }
                }
                removeFromCreatureEnclosure(originalVisitor);
                originalDragon.addToBelly(originalVisitor);
                currentNumVisitors = countVisitorsInCreatureEnclosure();
            }
        }
//        If highest unicorn agility is higher than dragon agility, run a loop.
        else if (Collections.max(unicornAgilityList) > dragonAgility) {
            while (currentNumVisitors > 0) {
                for (Enclosable person : creatureEnclosure) {
                    if (person instanceof Visitor) {
                        originalVisitor = (Visitor) person;
                    }
                }
                originalVisitor.money = originalVisitor.money + 10;
                removeFromCreatureEnclosure(originalVisitor);
                currentNumVisitors = countVisitorsInCreatureEnclosure();
            }
        }
    }


    //    While feeding trough is full and unicorn belly is less than 1 (while there's food && only 1
//    food per unicorn).

//    public void unicornFeedingTime() {
//        Unicorn originalUnicorn = null;
//        Vegetable originalVegetable = null;
//        for (Enclosable creature : creatureEnclosure) {
//            if (creature instanceof Unicorn) {
//                Unicorn originalUnicorn = (Unicorn) creature;
//            }
//            for (Vegetable veg : foodTrough) {
//                if (veg.toString() instanceof originalUnicorn.vegChoice()) {
//
//                }
//            }
//        }
//
//    }


}






