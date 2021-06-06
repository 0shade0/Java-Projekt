package pmf.math.kriptosustavi;

import junit.framework.TestCase;
import org.junit.Before;

public class ElGamalKriptosustavTest extends TestCase {

  private ElGamalKriptosustav stroj;

  @Before
  public void setUp() throws Exception {
    stroj = new ElGamalKriptosustav(107, 2, 94);
    assertNotNull(stroj);
  }

  public void testSifriraj() {
    stroj.sifriraj(66, 45);
    assertEquals("(28, 9)", stroj.vratiSifrat());
  }

  public void testDesifriraj() {
    stroj.setTajniKljuc(67);
    stroj.pohraniSifrat("(28, 9)");
    assertEquals(66, stroj.desifriraj());
  }

  public void testNoviBeta() {
    assertEquals(94, ElGamalKriptosustav.noviBeta(107, 2, 67));
  }
}