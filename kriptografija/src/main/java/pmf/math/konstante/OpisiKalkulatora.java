package pmf.math.konstante;

public class OpisiKalkulatora {

  public static final String CEZAR_OPIS = """
    U kriptografiji, Cezarova šifra jedan je od najjednostavnijih i najrasprostranjenijih načina šifriranja. To je tip šifre zamjene (supstitucije), u kome se svako slovo otvorenog teksta zamjenjuje odgovarajućim slovom abecede, pomaknutim za određeni broj mjesta. 
    
    Na primjer, s pomakom 3, A se zamjenjuje slovom D, B slovom E itd. 
    
    Ova metoda je dobila ime po Juliju Cezaru, koji ju je koristio za razmjenu poruka sa svojim generalima.
      """;

  public static final String SUPSTITUCIJA_OPIS = """
    Opća supstitucijska šifra jedna je od najjednostavnijih šifri, u kojoj se svako slovo otvorenog teksta zamjenjuje odgovarajućim slovom abecede, prema zadanoj permutaciji slova.
    
    Postoje i mnoge podvrste supstitucijskih šifri, kao što su na primjer Cezarova šifra, Cezarova šifra s ključnom riječi ili afina šifra. U njima se također svako slovo zamjenjuje nekim drugim, ali prema posebnim pravilima koja određuju korištenu permutaciju slova.
      """;

  public static final String AFINA_OPIS = """
        
      """;

  public static final String HILL_OPIS = """
      Hill-ova šifra je poligrafska supstitucijska šifra u klasičnoj kriptografiji koja se temelji na linearnoj algebri.
     
      Izumio ju je Lester S. Hill 1929. godine i to je bila prva poligrafska šifra u kojoj je bilo praktično operirati s više od tri simbola odjednom.
      
      Šifriranje odnosno dešifriranje se vrši množenjem vektora induciranim pojedinom m-torkom slova iz teksta sa matricom ključa dimenzije m.
      Rezultirani vektor zatim se preslikava natrag u slova.
      
      Za šifriranje i dešifriranje je potrebno da je matrica ključa K regularna.
      Za dešifriranje je dodatno potrebno da je matrica ključa involuirana odnosno da vrijedi K = K^-1, jer će u protivnom doći do nepoželjnih rezultata.
      """;

  public static final String VIGENERE_OPIS = """
      Vigenèreovu šifra spada u polialfabetske kriptosustave kod kojih se svako slovo otvorenog teksta može preslikati u jedno od m mogućih slova (gdje je m duljina ključa), u ovisnosti o svom položaju unutar otvorenog teksta.
        
      Francuski diplomat Blaise de Vigenère je 1586. godine objavio knjigu "Traicte de Chiffres" u kojoj se nalazilo sve što se u to vrijeme znalo o kriptografiji (ali gotovo ništa o kriptoanalizi).
      U njoj je opisano više originalnih polialfabetskih sustava, među kojima se nalazi i ovaj.
      
      Šifriranje/dešifriranje vrši se pomoću danog ključa KLJUC duljine m.
      
      U slučaju ponavljajućeg ključa otvoreni tekst/sifrat najprije se razbija na riječi duljine m.
      Pojedina razbijena riječ se zatim šifrira/dešifrira uz sljedeće transformacije:
      +/- KLJUCKLJUCKLJUC...
          
      U slučaju Vigenèreovog kvadrata otvoreni tekst/sifrat OTVORENITEKST / SIFRAT šifrira/dešifrira se u riječ REZULTAT uz sljedeće transformacije:
      + KLJUCOTVORENITEKST / - KLJUCREZULTAT
      """;

  public static final String PLAYFAIR_OPIS = """
      Ovu šifru je izumio britanski znanstvenik Charles Wheatstone 1854. godine, a ime je dobila po njegovom prijatelju barunu Playfairu od St. Andrewsa koji ju je popularizirao.
            
      To je bigramska šifra, u smislu da se šifriraju parovi slova LD i to tako da rezultat ovisi i o jednom i o drugom slovu.
            
      Šifriranje(dešifriranje) vrši se za svaki par slova pomoću Playfairove 5x5 tablice na sljedeći način:
      (lijevo slovo: L, desno slovo: D)
          ■ Ako su L i D jednaki, onda se vraća LL.
          ■ Ako su L i D u istom retku, onda se vraćaju znakovi L'D' koji su dobiveni pomicanjem L i D za jedno mjesto udesno(ulijevo).
          ■ Ako su L i D u istom stupcu, onda se vraćaju znakovi L'D' koji su dobiveni pomicanjem L i D za jedno mjesto dolje(gore).
          ■ Preostao je slučaj kada L i D nisu u istom retku ni u istom stupcu. Tada oni čine pravokutnik sa L' i D'. Ako postavimo:
           L' = vrh pravokutnika u istom retku kao L
           D' = vrh pravokutnika u istom retku sa D
       onda se vraća L'D'.
      """;

  public static final String STUPCANA_OPIS = """
        
      """;

  public static final String RSA_OPIS = """
        
      """;

  public static final String EL_GAMAL_OPIS = """

      """;
}
