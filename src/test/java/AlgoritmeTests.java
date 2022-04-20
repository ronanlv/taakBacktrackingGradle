import be.domino.Algoritme;
import be.domino.Steen;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class AlgoritmeTests {

    int N;

    public static Steen parseStone(String txt) {
        try {
            int ogen1 = Integer.valueOf(txt.substring(0,1));
            int ogen2 = Integer.valueOf(txt.substring(1,2));
            char kleur = txt.charAt(2);
            return new Steen(ogen1, ogen2, kleur);
        }
        catch (Exception e) {
            return new Steen(9);
        }
    }

    public static ArrayList<Steen> readStones(String txt) {
        ArrayList<Steen> stenen = new ArrayList<>();
        for (int i=0; i < txt.length(); i=i+4) {
            stenen.add(parseStone(txt.substring(i, i+3)));
        }
        return stenen;
    }

    @Test
    public void test_CheckKettingFunctie2() {
        // Arrange
        var goedeKetting = "12R 21G";
        Algoritme alg = new Algoritme();
        // Act
        var oplossing = alg.checkKetting(readStones(goedeKetting));
        // Assert
        Assertions.assertTrue(oplossing);
    }

    @Test
    public void test_CheckKettingFunctie5() {
        // Arrange
        var goedeKetting = "12R 21G 13P 34Y 41B";
        Algoritme alg = new Algoritme();
        // Act
        var oplossing = alg.checkKetting(readStones(goedeKetting));
        // Assert
        Assertions.assertTrue(oplossing);
    }

    @Test
    public void test_CheckKettingFunctie5_Fout() {
        // Arrange
        var goedeKetting = "12R 21G 13P 34Y 45B";
        Algoritme alg = new Algoritme();
        // Act
        var oplossing = alg.checkKetting(readStones(goedeKetting));
        // Assert
        Assertions.assertFalse(oplossing);
    }

    @Test
    public void test_Stenen2GeeftOplossing() {
        // Arrange
        var stenen2 = "12R 12G";
        Algoritme alg = new Algoritme();
        // Act
        var oplossing = alg.maakKettingZonderOptional(readStones(stenen2));
        // Assert
        Assertions.assertTrue(alg.checkKetting((ArrayList<Steen>)oplossing));
    }

    @Test
    public void test_Stenen3GeeftOplossing() {
        // Arrange
        var stenen2 = "12R 13P 32G";
        Algoritme alg = new Algoritme();
        // Act
        var oplossing = alg.maakKettingZonderOptional(readStones(stenen2));
        // Assert
        Assertions.assertTrue(alg.checkKetting((ArrayList<Steen>)oplossing));
    }

    @Test
    public void test_Stenen4GeeftGeenOplossing() {
        // Arrange
        var stenen2 = "12R 16R 23G 34B";
        Algoritme alg = new Algoritme();
        // Act
        var oplossing = alg.maakKettingZonderOptional(readStones(stenen2));
        // Assert
        Assertions.assertFalse(alg.checkKetting((ArrayList<Steen>)oplossing));
    }
    @Test
    public void test_Stenen8GeeftOplossing() {
        // Arrange
        var stenen2 = "25P 42R 12R 41P 12Y 42Y 25P 11G";
        Algoritme alg = new Algoritme();
        // Act
        var oplossing = alg.maakKettingZonderOptional(readStones(stenen2));
        // Assert
        Assertions.assertFalse(alg.checkKetting((ArrayList<Steen>)oplossing));
    }
    @Test
    public void test_Stenen9GeeftOplossing() {
        // Arrange
        var stenen2 = "12R 45R 54G 41P 12Y 24R 42Y 25P 51G";
        Algoritme alg = new Algoritme();
        // Act
        var oplossing = alg.maakKettingZonderOptional(readStones(stenen2));
        // Assert
        Assertions.assertFalse(alg.checkKetting((ArrayList<Steen>)oplossing));
    }

    @Test
    public void test_Stenen11GeeftOplossing() {
        // Arrange
        var stenen2 = "12R 24Y 51G 21Y 54G 23G 34B 45R 41P 24R 52P";
        Algoritme alg = new Algoritme();
        // Act
        var oplossing = alg.maakKettingZonderOptional(readStones(stenen2));
        // Assert
        Assertions.assertTrue(alg.checkKetting((ArrayList<Steen>)oplossing));
    }

    @Test
    public void test_Stenen12GeeftOplossing() {
        // Arrange
        var stenen2 = "12R 11P 23G 34B 45R 54G 41P 12Y 24R 42Y 25P 51G";
        Algoritme alg = new Algoritme();
        // Act
        var oplossing = alg.maakKettingZonderOptional(readStones(stenen2));
        // Assert
        Assertions.assertTrue(alg.checkKetting((ArrayList<Steen>)oplossing));
    }
}
