package miagem1;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class QuestionAChoixMultipleTest {
    private QuestionAChoixMultiple unQCM;
    private List<Integer> reponses;
    private int nbChoix;

    @Before
    public void setUp() throws Exception {
        reponses = new ArrayList<Integer>();
        reponses.add(3);
        reponses.add(5);
        reponses.add(7);
        nbChoix = 5;
        unQCM = new QuestionAChoixMultiple("test énoncé", reponses, nbChoix);
    }

    @Test
    public void getEnonceTest() {
        // when: on demande l'énoncé à la question
        String resEnonce = unQCM.getEnonce();
        // then: l'énoncé est non null
        assertNotNull(resEnonce);
        // and: l'énoncé est bien celui fourni à la construction
        assertEquals(resEnonce, "test énoncé");
    }

    @Test
    public void getScoreForIndiceTest() {
        Float resScore = new Float(0f);
        // when: un etudiant fourni l'indice correspondant à la bonne réponse
        for (Integer indiceEtudiant : reponses) {
            //and : on demande le calcul du score
            resScore += unQCM.getScoreForIndice(indiceEtudiant);
        }
        //then : le socre obtenu est 100
        assertEquals(new Float(100f), resScore);
        // when : un étudiant fourni l'indice correspondant à une mauvaise réponse
        int indiceEtudiant = 4;
        //and : on demande le calcul du score
        resScore = unQCM.getScoreForIndice(indiceEtudiant);
        //then : le score obtenu est 0
        assertEquals(new Float(0f), resScore);
    }
}