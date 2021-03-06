package pmf.math.konstante;

public class UputeKalkulatora {

  public static final String CEZAR_UPUTE = """
      Za (de)šifriranje pomoću Cezarove šifre potrebno je unijeti pomak (broj).
      
      Za (de)šifriranje pomoću Cezarove šifre s ključnom riječi, treba označiti odgovarajuću kućicu te unijeti ključnu riječ i pomak (broj), koji označava mjesto od koje ključna riječ počinje u abecedi šifrata.
      
      Sav uneseni tekst (otvoreni tekst, šifrat i ključna riječ) smije sadržavati isključivo slova engleske abecede.
      
      Za pokretanje postupka, pritisnuti odgovarajuću strelicu ↓ ili ↑.
      """;

  public static final String SUPSTITUCIJA_UPUTE = """
      Za (de)šifriranje pomoću opće supstitucijske šifre, potrebno je unijeti zamjensko slovo za svako od navedenih slova engleske abecede. Ukoliko zamjensko slovo za neko od slova nije upisano, ono će u šifratu ili otvorenom tekstu biti prikazano kao _.
      
      Prilikom unosa zamjenskih slova, potrebno je pripaziti da nikoja dva slova nisu zamijenjena istim slovom (primjerice, slovo A i slovo B ne smiju oba biti zamijenjena slovom Q).
      
      Sav uneseni tekst (otvoreni tekst i šifrat) smije sadržavati isključivo slova engleske abecede.
      
      Za pokretanje postupka, pritisnuti odgovarajuću strelicu ↓ ili ↑.
      """;

  public static final String AFINA_UPUTE = """
      Za (de)šifriranje pomoću afine šifre potrebno je unijeti vrijednosti parametara a i b.
      
      Važno je napomenuti da vrijednost parametra a mora biti broj koji je relativno prost s brojem 26.
           
      Također, sav uneseni tekst (otvoreni tekst, šifrat i ključna riječ) smije sadržavati isključivo slova engleske abecede.
      
      Za pokretanje postupka, pritisnuti odgovarajuću strelicu ↓ ili ↑.
      """;

  public static final String HILL_UPUTE = """
      Za šifriranje/dešifiranje potrebno je postaviti ključ(matricu) te kliknuti pripadni gumb ↓ ↑.
      
      Ćelije matrice mogu biti peteroznamenkasti brojevi sa ili bez predznaka. Dimenzije matrice također se mogu mijenjati (m je od 2 do 5).
      Kljuc je moguće i zaključati kako bi se izbjegao slučajan gubitak podataka.
      
      Ako je unesen otvoreni tekst i šifrat jednakih i ispravnih duljina (length % m == 0), onda je moguće pokušati odgonetnuti ključ.
      OPREZ: vrlo je teško pronaći validan ključ za veći unos. Preporučljivo je unositi maksimalno m m-torki.
      """;

  public static final String VIGENERE_UPUTE = """
      Za šifriranje/dešifiranje potrebno je postaviti ključ(riječ) te kliknuti pripadni gumb ↓ ↑.
      
      Klikom na pripadnu tipku mogu se izmijeniti načini korištenja ključa.
      
      Klikom na tipku "Pronađi duljinu ključa" moguće je procijeniti duljinu ključa ovisno o unesenom šifratu (potrebno da nije prazan tekst).
      """;

  public static final String PLAYFAIR_UPUTE = """
      Za šifriranje/dešifriranje dovoljno je kliknuti pripadni gumb ↓ ↑.
          
      Playfairov pravokutnik može se izmijeniti dodavanjem ključa ili izmjenom abecede.
      """;

  public static final String STUPCANA_UPUTE = """
      Za šifriranje ili dešifriranje je potrebno odabrati broj stupaca s kojima želite raditi (barem dva, najviše 20).
      Potom birate koja je permutacija stupaca, a valjanost odabranih vrijednosti će biti potvrđena ili opovrgnuta bojom ključa.
      Potom unesite tekst koji želite (de)šifrirati i pritisnite odgovarajuću tipku.
      """;

  public static final String RSA_UPUTE = """
      Za šifriranje je potrebno unijeti broj n (ili brojeve p i q), i broj e. Također, u polje 'Broj' je potrebno unijeti proizvoljan prirodan broj. Za pokretanje postupka, pritisnete strelicu ↓.
      Za dešifriranje je potrebno unijeti broj n (ili brojeve p i q), i broj d. U polje za šifrat treba unijeti proizvoljan prirodan broj. Za pokretanje postupka, pritisnete strelicu ↑.     
      Ukoliko želite provjeriti jesu li vaši podatci valjani, tj. međusobno kompatibilni, pritisnite odgovarajuću tipku.     
      Ako podatci nisu u redu, tim postupkom će biti ispravljeni. Da bi to bilo moguće, potrebno je unijeti barem broj n ili brojeve p i q.
      """;

  public static final String EL_GAMAL_UPUTE = """
      Za šifriranje je potrebno unijeti prost broj, alfu, betu i tajni broj. Također, u polje 'Broj' treba unijeti proizvoljan prirodan broj. Za pokretanje postupka, pritisnete strelicu ↓.
      Za dešifriranje je potrebno unijeti prost broj, alfu, betu i tajni ključ. Također, u polje za šifrat treba unijeti par prirodnih brojeva u formatu: '(broj1, broj2)'. Za pokretanje postupka, pritisnete strelicu ↑.
      Ukoliko želite provjeriti jesu li vaši podatci valjani, tj. međusobno kompatibilni, pritisnite odgovarajuću tipku.
      Ako podatci nisu u redu, tim postupkom će biti ispravljeni. Da bi to bilo moguće, potrebno je unijeti barem valjani prost broj i tajni ključ.
      """;

  public static final String ANALIZA_TEKSTA_UPUTE = """
      Kako bi se izvršila analiza teksta potrebno je upisati tekst u pripadnu bijelu kućicu te kliknuti gumb "Analiziraj".
      
      Klikom na gumb "Očisti" brišu se svi podaci sa kalkulatora.
      """;
}
