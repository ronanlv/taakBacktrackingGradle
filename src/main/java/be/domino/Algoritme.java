package be.domino;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author u0002531
 */
public class Algoritme {

    int N;
    ArrayList<ArrayList<Steen>> alleKettingen;
    ArrayList<Steen> gKetting;

    public Optional<List<Steen>> maakKetting(ArrayList<Steen> stenen) {
        alleKettingen = new ArrayList<ArrayList<Steen>>();
        ArrayList<Steen> gKetting = new ArrayList<>();
        N = stenen.size();

        solve(stenen);

        try {
//            ketting = alleKettingen.get(0);
            return Optional.of(gKetting);
        } catch (IndexOutOfBoundsException e) {
            return Optional.empty();
        }
    }

    public List<Steen> maakKettingZonderOptional(ArrayList<Steen> stenen) {
        alleKettingen = new ArrayList<ArrayList<Steen>>();
        ArrayList<Steen> gKetting = new ArrayList<>();
        N = stenen.size();

        solve(stenen);

        return gKetting;
    }

    public boolean legalePlaatsing(Steen volgendeSteen, Steen andereSteen) {
        if (andereSteen.getKleur() == volgendeSteen.getKleur())
            return false;

        return andereSteen.getOgen2() == volgendeSteen.getOgen1();
    }

    private void solve(ArrayList<Steen> stenen) {

        for (int i=0; i<stenen.size(); ++i) {
            Steen tijdelijkSteen = stenen.get(i);
            if (legalePlaatsing(tijdelijkSteen, gKetting.get(gKetting.size()-1))) {
                gKetting.add(tijdelijkSteen);

                Steen kopieSteen = stenen.remove(i);
//                    if (ketting.size() == N) {
//                        ArrayList<Steen> k = (ArrayList<Steen>)ketting.clone();
//                        if (!alleKettingen.contains(ketting))
//                            alleKettingen.add(k);
//                    }
                solve(stenen);
                stenen.add(i, kopieSteen);
                gKetting.remove(gKetting.size()-1);
            }
            tijdelijkSteen.flip();
            if (legalePlaatsing(tijdelijkSteen, gKetting.get(gKetting.size()-1))) {
                gKetting.add(tijdelijkSteen);

                Steen kopieSteen = stenen.remove(i);
//                    if (ketting.size() == N) {
//                        ArrayList<Steen> k = (ArrayList<Steen>)ketting.clone();
//                        if (!alleKettingen.contains(ketting))
//                            alleKettingen.add(k);
//                    }
                solve(stenen);
                stenen.add(i, kopieSteen);
                gKetting.remove(gKetting.size() - 1);
            }
        }
    }

    public boolean checkKetting(ArrayList<Steen> ketting) {
        if (ketting.size()>0) {
            for (int i = 0; i < ketting.size() - 1; i++) {
                if (ketting.get(i).getOgen2() != ketting.get(i + 1).getOgen1() ||
                        ketting.get(i).getKleur() == ketting.get(i + 1).getKleur())
                    return false;
            }
            return ketting.get(0).getOgen1() == ketting.get(ketting.size() - 1).getOgen2() &&
                    ketting.get(0).getKleur() != ketting.get(ketting.size() - 1).getKleur();
        }
        return false;
    }
}

