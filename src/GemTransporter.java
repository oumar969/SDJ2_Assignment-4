import gem.Gem;
import kingdom.Catalogue;

import java.util.Random;

public class GemTransporter implements Runnable {
  private final GemDeposit gemDeposit;

  public GemTransporter(GemDeposit gemDeposit) {
    this.gemDeposit = gemDeposit;
  }

  @Override
  public void run() {
    while (true) {
      while (!gemDeposit.isFull()) {
        Gem gem = null;
        try
        {
          gem = (Gem) gemDeposit.take();
          gemDeposit.put(gem);
        }
        catch (InterruptedException e)
        {
          throw new RuntimeException(e);
        }
        System.out.println(gemDeposit.size());
      }

      Catalogue.getInstance().transferGemsToTreasureRoom(gemDeposit.size());

      // For now, just clear the gems
//      gemDeposit.clearGems();

      // Sleep for a little while
      sleep(1000);
    }
  }

  private int getRandomTarget() {
    Random rand = new Random();
    return rand.nextInt(151) + 50; // Generates random number between 50 and 200 inclusive
  }

  private void sleep(long millis) {
    try {
      Thread.sleep(millis);
    } catch (InterruptedException e) {
      // Ignore the exception
    }
  }
}
