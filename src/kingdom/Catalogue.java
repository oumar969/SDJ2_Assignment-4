package kingdom;

import gem.Gem;

public class Catalogue
{
  private static Catalogue instance;

  private Catalogue() {}

  public static Catalogue getInstance() {
    if (instance == null) {
      instance = new Catalogue();
    }
    return instance;
  }

  public void transferGemsToTreasureRoom(int gems) {
    System.out.println("Transfering " + gems + " gems to treasure room");
  }

  public void throwParty(int targetValue) {
    System.out.println("The king is throwing a party");
  }

  public void cancelParty() {
    System.out.println("The king is cancelling the party");
  }
  public void partyOver()
  {
    System.out.println("The party is over");
  }

  public void totalWealth(int gems) {
    System.out.println("The king's total wealth is " + gems + " gems");
  }

  public void currentWealth()
  {
    System.out.println("Accountants calculated: "+ TreasureRoom.getWealth() + " in treasureroom");
  }

  public void waitingToEnterTreasureRoom(String name) {
    System.out.println("The " + name + " is waiting to enter the treasure room");
  }

  public void enteredTreasureRoom() {
    System.out.println("Someone has entered the treasure room");
  }

  public void leftTreasureRoom() {
    System.out.println("Someone has left the treasure room");
  }
  public void addToTreasureRoom(String actorName,Gem gem)
  {
    System.out.println( actorName + " added: " + gem.getGemType() + " Value: " + gem.getValue() + " to treasure room. Treasure room currently has: " + TreasureRoom.getWealth());
  }
  public void removeFromTreasureRoom(String actorName,Gem gem)
  {
    System.out.println( actorName + " removed: " + gem.getGemType() + " Value: " + gem.getValue() + " to treasure room");
  }
  public void partyTime()
  {
    System.out.println("The king has enough gems for the party");
  }
  public void removeFromDeposit(Gem gem)
  {
    System.out.println(gem.getGemType() + " is removed from the deposit. Value: " + gem.getValue());
  }
}
