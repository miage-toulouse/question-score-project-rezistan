package miagem1;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ScoreCalculateurTest {
    private QuestionAChoixMultiple questionAChoixMultiple;
    private ScoreCalculateur sc;

    @Before
    public void setUp() throws Exception {
        sc = new ScoreCalculateur();
        // given : une question à choix multiple
        questionAChoixMultiple = new QuestionAChoixMultiple("q1", new ArrayList<Integer>(Arrays.asList(2, 3, 5)), 5);
    }

    @Test
    public void calculeScoreTest() {
        /*
         * Cas [1, 4]
         */
        // when: un etudiant fourni les indices suivant
        List<Integer> indicesEtudiant = new ArrayList<Integer>(Arrays.asList(1, 4));

        //and : on demande le calcul du score
        Float resScore = sc.calculeScore(indicesEtudiant, questionAChoixMultiple);

        //then : le score obtenu est 0
        assertEquals(new Float(0f), resScore, 0.01f);

        /*
         * Cas [2, 3]
         */
        // when: un etudiant fourni les indices suivant
        indicesEtudiant = new ArrayList<Integer>(Arrays.asList(2, 3));

        //and : on demande le calcul du score
        resScore = sc.calculeScore(indicesEtudiant, questionAChoixMultiple);

        //then : le score obtenu est 2/3 de 100
        assertEquals(new Float(2 * 100f / 3f), resScore, 0.01f);

        /*
         * Cas [2, 3, 5]
         */
        // when: un etudiant fourni les indices suivant
        indicesEtudiant = new ArrayList<Integer>(Arrays.asList(2, 3, 5));

        //and : on demande le calcul du score
        resScore = sc.calculeScore(indicesEtudiant, questionAChoixMultiple);

        //then : le score obtenu est 100
        assertEquals(new Float(100f), resScore, 0.01f);

        /*
         * Cas [1, 2, 3, 4, 5]
         */
        // when: un etudiant fourni les indices suivant
        indicesEtudiant = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));

        //and : on demande le calcul du score
        resScore = sc.calculeScore(indicesEtudiant, questionAChoixMultiple);

        //then : le score obtenu est 0
        assertEquals(new Float(0f), resScore, 0.01f);

        /*
         * Cas [1, 2, 3]
         */
        // when: un etudiant fourni les indices suivant
        indicesEtudiant = new ArrayList<Integer>(Arrays.asList(1, 2, 3));

        //and : on demande le calcul du score
        resScore = sc.calculeScore(indicesEtudiant, questionAChoixMultiple);

        //then : le score obtenu est 16.66
        assertEquals(new Float(16.66f), resScore, 0.01f);

    }
}
