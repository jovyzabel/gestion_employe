package Enum.def;

public enum StatutMatrimonial {
    MARIAGED("Marié"),
    ENGAGED("Fiancé"),
    SINGLE("Celibataire"),
    WIDOW("Veuve"),
    WIDOWER("Veuf");

    private String statut;
    StatutMatrimonial(String statut){
        this.statut = statut;
    }
}
