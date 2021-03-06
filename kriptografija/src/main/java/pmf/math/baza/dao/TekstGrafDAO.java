package pmf.math.baza.dao;


import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.table.TableUtils;
import pmf.math.baza.tablice.TekstGrafovi;
import pmf.math.konstante.ImenaKalkulatora;
import pmf.math.kriptosustavi.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

import static pmf.math.baza.BazaPodataka.poveznicaBaze;
import static pmf.math.konstante.DuljineTeksta.DULJINE_TEKSTOVA_ZA_SIMULACIJU;
import static pmf.math.pomagala.StringInteger.intRedUString;

public class TekstGrafDAO {

  public final int brojIteracijaSimulacije = 10;
  private Dao<TekstGrafovi, String> tekstGrafDao;

  public TekstGrafDAO() {
    try {
      tekstGrafDao = DaoManager.createDao(poveznicaBaze, TekstGrafovi.class);
      TableUtils.createTableIfNotExists(poveznicaBaze, TekstGrafovi.class);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public String vrstaSimulacijeToString(VrstaSimulacije vrstaSimulacije) {
    return switch (vrstaSimulacije) {
      case SIFRIRAJ -> "Šifriranje";
      case DESIFRIRAJ -> "Dešifriranje";
    };
  }

  public TekstGrafovi dohvatiElement(ImenaKalkulatora imeKalkulatora,
      VrstaSimulacije vrstaSimulacije, boolean osvjezi) {
    try {
      List<TekstGrafovi> tekstGraf = tekstGrafDao.queryBuilder().where()
          .eq("imeKalkulatora", imeKalkulatora.toString()).and()
          .eq("vrstaSimulacije", vrstaSimulacijeToString(vrstaSimulacije)).query();
      if (tekstGraf.isEmpty()) {
        TekstGrafovi element = noviElement(imeKalkulatora, vrstaSimulacije);
        tekstGrafDao.create(element);
        return element;
      } else if(osvjezi) {
        TekstGrafovi element = noviElement(imeKalkulatora, vrstaSimulacije);
        tekstGraf.get(0).setDuljineTeksta(element.getDuljineTeksta());
        tekstGraf.get(0).setVremenaIzvodenja(element.getVremenaIzvodenja());
        tekstGrafDao.update(tekstGraf.get(0));
        return element;
      } else {
        return tekstGraf.get(0);
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    return null;
  }

  public TekstGrafovi noviElement(ImenaKalkulatora imeKalkulatora,
      VrstaSimulacije vrstaSimulacije) {
    String duljineTekstova = intRedUString(DULJINE_TEKSTOVA_ZA_SIMULACIJU);
    String vremenaIzvodenja = switch (imeKalkulatora) {
      case PLAYFAIROVA_SIFRA -> intRedUString(Objects.requireNonNull(
          PlayfairKriptosustav.simuliraj(DULJINE_TEKSTOVA_ZA_SIMULACIJU, vrstaSimulacije, brojIteracijaSimulacije)));

      case HILLOVA_SIFRA -> intRedUString(Objects.requireNonNull(
          HillKriptosustav.simuliraj(DULJINE_TEKSTOVA_ZA_SIMULACIJU, vrstaSimulacije, brojIteracijaSimulacije)));

      case SUPSTITUCIJSKA_SIFRA -> intRedUString(Objects.requireNonNull(
              SupstitucijskaKriptosustav.simuliraj(DULJINE_TEKSTOVA_ZA_SIMULACIJU, vrstaSimulacije, brojIteracijaSimulacije)));

      case CEZAROVA_SIFRA -> intRedUString(Objects.requireNonNull(
              CezarKljucnaRijecKriptosustav.simuliraj(DULJINE_TEKSTOVA_ZA_SIMULACIJU, vrstaSimulacije, brojIteracijaSimulacije)));

      case STUPCANA_TRANSPOZICIJA -> intRedUString(Objects.requireNonNull(
              StupcanaTranspozicijaSustav.simuliraj(DULJINE_TEKSTOVA_ZA_SIMULACIJU, vrstaSimulacije, brojIteracijaSimulacije)));

      case VIGENEROVA_SIFRA -> intRedUString(Objects.requireNonNull(
          VigenereKriptosustav.simuliraj(
              DULJINE_TEKSTOVA_ZA_SIMULACIJU, vrstaSimulacije, brojIteracijaSimulacije)));

      case AFINA_SIFRA -> intRedUString(Objects.requireNonNull(
              AfiniKriptosustav.simuliraj(DULJINE_TEKSTOVA_ZA_SIMULACIJU, vrstaSimulacije, brojIteracijaSimulacije)));

      default -> throw new IllegalStateException("Neočekivana vrijednost: " + imeKalkulatora);
    };
    return new TekstGrafovi(0, imeKalkulatora.toString(), vrstaSimulacijeToString(vrstaSimulacije),
        duljineTekstova, vremenaIzvodenja);
  }

  public enum VrstaSimulacije {
    SIFRIRAJ,
    DESIFRIRAJ
  }
}
