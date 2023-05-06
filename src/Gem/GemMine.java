package Gem;

import Gem.Gem;

import java.util.HashMap;
import java.util.Map;

/*
Vi opretter en GemMine-klasse, der implementerer Multiton-mønsteret.
GemMine gemmer et kort over forskellige typer ædelstene.
Nøglen på kortet vil være navnet på ædelstenen, og værdien vil være en forekomst af ædelstenen.

*/
public class GemMine
{
  private static Map<String, Gem> allInstances = new HashMap<>();


  private GemMine(String key)
  {

  }

  public static Gem getInstance(String key)
  {
    Gem instance = allInstances.get(key);
    if (instance == null)
    {
      synchronized (allInstances)
      {
        instance = allInstances.get(key);
        if (instance == null)
        {
          switch (key)
          {
            case "Gem.Diamond":
              instance = new Diamond();
              break;
            case "Gem.GoldNugget":
              instance = new GoldNugget();
              break;
            case "Gem.Jewel":
              instance = new Jewel();
              break;
            case "Gem.Ruby":
              instance = new Ruby();
              break;
            case "Gem.WoodenCoin":
              instance = new WoodenCoin();
              break;
            default:
              throw new IllegalArgumentException("No such valuable exists, trash!");
          }
          allInstances.put(key, instance);
          instance = allInstances.get(key);
        }
      }
    }
    return instance;
  }
}
