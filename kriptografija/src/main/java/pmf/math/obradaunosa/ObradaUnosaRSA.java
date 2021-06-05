package pmf.math.obradaunosa;

import pmf.math.algoritmi.TeorijaBrojeva;

public class ObradaUnosaRSA {
  public static boolean provjeriD(int _p, int _q, int _d) {
    int fi = TeorijaBrojeva.posebnaEulerovaFunkcija(_p, _q);
    return TeorijaBrojeva.relativnoProsti(_d, fi);
  }

  public static boolean provjeriDiE(int _p, int _q, int _d, int _e) {
    return (_d*_e) % TeorijaBrojeva.posebnaEulerovaFunkcija(_p, _q) == 1;
  }

  public static boolean provjeriNUmnozakProstih(int n) {
    for (int i = 2; i < n; i++) {
      if (TeorijaBrojeva.prost(i) && n % i == 0) {
        if (TeorijaBrojeva.prost(n / i)) return true;
      }
    }
    return false;
  }
}