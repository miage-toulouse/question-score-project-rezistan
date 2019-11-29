package miagem1;

import java.util.List;

/**
 * Classe répresentant une question à choix multiple
 */
public class QuestionAChoixMultiple implements QuestionAChoix {

    private String enonce;
    private List<Integer> indicesBonnesReponses;
    private int nbChoix;

    /**
     * Une question à choix multiple est complètement caractérisé par son énoncé et la liste des indices qui forment
     * la bonne réponse
     * @param enonce l'énoncé de la question
     * @param indicesBonnesReponses la liste des indices formant la bonne réponse.
     */
    public QuestionAChoixMultiple(String enonce, List<Integer> indicesBonnesReponses, int nbChoix) {
        this.enonce = enonce;
        this.indicesBonnesReponses = indicesBonnesReponses;
        this.nbChoix = nbChoix;
    }

    /**
     * Récupère l'énoncé de la question
     * @return l'énoncé de la question
     */
    public String getEnonce() {
        return enonce;
    }

    /**
     * Opération permettant de récupérer le score donné par un choix.
     * @param indiceChoix l'indice du choix
     * @return 100/n si indiceChoix appartient à la liste des indices formant la bonne réponse, 0 sinon
     */
    public float getScoreForIndice(int indiceChoix) {
        int nbMauvaiesRep = nbChoix - indicesBonnesReponses.size();

        if (indicesBonnesReponses.contains(indiceChoix)) {
            return 100f/((float)(indicesBonnesReponses.size()));
        }
        return Math.max(0, -100f/((float)(nbMauvaiesRep)));
    }
}
