public class Main
{
  public static void main(String[] args)
  {
    GemDeposit gemDeposit = new GemDeposit(30);

    Thread miner1Thread = new Thread(new GemMineWorker(gemDeposit));
    miner1Thread.start();

    Thread miner2Thread = new Thread(new GemMineWorker(gemDeposit));
    miner2Thread.start();

    Thread gemTransThread1 = new Thread(new GemTransporter(gemDeposit));
    gemTransThread1.start();

    Thread gemTransThread2 = new Thread(new GemTransporter(gemDeposit));
    gemTransThread2.start();
  }
}
