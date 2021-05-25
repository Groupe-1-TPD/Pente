import javax.swing.*;
import java.awt.*;

/**
 * Classe InterfaceGraphique
 * Représente l'interface graphique du jeu
 * par laquelle toutes les interactions entre
 * le joueur et le jeu passeront
 */
public class InterfaceGraphique extends JFrame{

    private Canvas canvas;
    private CadreInformation cadreInformationBlanc;
    private CadreInformation cadreInformationNoir;
    
    /**
     * Constructeur
     */
    public InterfaceGraphique(){
        this.setTitle("Jeu de pente");
        this.setSize(new Dimension(1300, 800));
        this.setLayout(null);
        this.setResizable(false);

        Canvas canvas = new Canvas();
        this.setCanvas(canvas);
        this.getCanvas().setSize(690, 690);
        this.getCanvas().setLocation(30, 30);
        this.add(this.getCanvas());

        CadreInformation cadreInformationBlanc = new CadreInformation();
        this.setCadreInformationBlanc(cadreInformationBlanc);
        this.add(this.getCadreInformationBlanc());
        this.getCadreInformationBlanc().setLocation(780, 30);
        this.getCadreInformationBlanc().repaint();

        CadreInformation cadreInformationNoir = new CadreInformation();
        this.setCadreInformationNoir(cadreInformationNoir);
        this.add(this.getCadreInformationNoir());
        this.getCadreInformationNoir().setLocation(780, 400);
        this.getCadreInformationNoir().repaint();

        /*
        this.setLabelNom1(new JLabel());
        this.getLabelNom1().setText("Joueur 1");
        this.getLabelNom1().setLocation(1025, 30);
        this.getLabelNom1().setSize(500, 50);
        this.add(this.getLabelNom1());
        */

        BordureInterface bordure1 = new BordureInterface();
        bordure1.setSize(1, 690);
        bordure1.setLocation(750, 30);
        bordure1.repaint();
        this.add(bordure1);

        BordureInterface bordure2 = new BordureInterface();
        bordure2.setSize(490, 1);
        bordure2.setLocation(780, 370);
        bordure2.repaint();
        this.add(bordure2);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setAlwaysOnTop(true);
    }

    public CadreInformation getCadreInformationBlanc() {
        return this.cadreInformationBlanc;
    }

    public void setCadreInformationBlanc(CadreInformation cadre) {
        this.cadreInformationBlanc = cadre;
    }

    public CadreInformation getCadreInformationNoir() {
        return this.cadreInformationNoir;
    }

    public void setCadreInformationNoir(CadreInformation cadre) {
        this.cadreInformationNoir = cadre;
    }

    /**
     * Obtenir le canvas de l'interface graphique
     * @param canvas
     */
    public void setCanvas(Canvas canvas){
        this.canvas = canvas;
    }

    /**
     * Définir le canvas de l'interface graphique
     * @return
     */
    public Canvas getCanvas(){
        return this.canvas;
    }
}