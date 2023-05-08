package kingdom;

import gem.GemMine;

public class GemMineWorker implements Runnable
{
  GemDeposit gemDeposit;

  public GemMineWorker(GemDeposit gemDeposit)
  {
    this.gemDeposit = gemDeposit;
  }

  @Override public void run()
  {
      int random;
    while (true)
    {
      random = (int) (Math.random() * 3);

      switch (random)
      {
        case 0:
          mineQuickly();
          break;
        case 1:
          mineSlowly();
          break;
        case 2:
          mineDiamond();
          break;
      }
    }
  }

  private void mineSlowly()
  {
    try
    {
      Thread.sleep(1000);
      for (int i = 0; i < 12; i++)
      {
       gemDeposit.put( GemMine.getInstance("Gem." + randomGem()));
      }
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }
  }

  private void mineQuickly()
  {
    try
    {
      Thread.sleep(100);
      gemDeposit.put( GemMine.getInstance("Gem." + randomGem()));
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }
  }

  private void mineDiamond()
  {
    try
    {
      Thread.sleep(300);
      GemMine.getInstance("Gem.Diamond");
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }
  }

  private String randomGem()
  {
    int random = (int) (Math.random() * 5);

    String[] gems = {"Diamond", "GoldNugget", "Jewel", "Ruby", "WoodenCoin"};

    return gems[random];
  }
}
