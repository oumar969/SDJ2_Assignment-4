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

}
