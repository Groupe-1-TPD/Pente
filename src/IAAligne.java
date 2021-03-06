/**
 * Classe IAAligne
 * @author Étienne OGEZ, Valentin MANTEZ
 * Niveau supérieur d'IA
 * 1) Analyse le plateau et cherche des alignements
 * de pions à réaliser
 */
public class IAAligne extends IA{
    private static boolean fini;
    public IAAligne(Couleur couleur, Jeu jeu){
        super(couleur, jeu);
    }

    /**
     * Nouvelle version de la méthode
     */
    @Override
    public Position calculerCoup(){
        Position position;
        Position positioninit;
        IAAligne.fini = false;
        position = new Position(0,0);
        forBreak:
        for (int x=0; x<19;x++){
            for (int y=0; y<19;y++){
                positioninit = new Position(x,y);
                if(this.getJeu().getPlateau().estLibre(positioninit) == false && this.getJeu().getPlateau().getIntersection(positioninit) == this.getCouleur()){
                    for (int a=-1; a<=1; a++){
                        for (int b=-1; b<=1; b++){
                            position = TestGagne(positioninit, a , b);
                            if(IAAligne.fini == true){
                                break forBreak;
                            }
                        }
                    }       
                }
            }   
        }
        if(IAAligne.fini == false){
            position = super.calculerCoup();
        }
        return position;
    }

    /**
     * Interprète l'état du jeu pour chercher un endroit
     * où faire un alignement de pions
     */
    public Position TestGagne(Position positioninit, Integer dirX , Integer dirY){
        Position position = new Position(0, 0);
        if(positioninit.getX() > 0 && positioninit.getX() < Plateau.DIMENSION && positioninit.getY() > 0 && positioninit.getY() < Plateau.DIMENSION){
            position = new Position(
                positioninit.getX() + dirX,
                positioninit.getY() + dirY
            );
            if(this.getJeu().getPlateau().estLibre(position) == false && this.getJeu().getPlateau().getIntersection(position) == this.getCouleur()){
                if(position.getX() > 0 && position.getX() < Plateau.DIMENSION && position.getY() > 0 && position.getY() < Plateau.DIMENSION){
                    position = new Position(
                        position.getX() + dirX,
                        position.getY() + dirY
                    );
                    if(this.getJeu().getPlateau().estLibre(position) == true){
                        IAAligne.fini = true;
                    }
                }
            }
        }
        return position;
    }
}