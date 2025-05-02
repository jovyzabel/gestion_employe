import Enum.def.Categorie;
import Enum.def.Role;
import Enum.def.StatutMatrimonial;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Employe employe1 = new Employe("Mohamed", "Hassan", StatutMatrimonial.SINGLE,"DEVINFO20", "21/02/2022", Role.DESIGNER, Categorie.AB);
        Employe employe2 = new Employe("Boubakar", "Ben Saïd", StatutMatrimonial.SINGLE,"DEVINFO20", "21/02/2022", Role.DESIGNER,Categorie.AB);
        Employe employe3 = new Employe("Serge", "Anani", StatutMatrimonial.SINGLE,"DEV3.0", "21/02/2023", Role.FRONTEND,Categorie.AB);
        Employe employe4 = new Employe("Nicodeme", "Vodonou", StatutMatrimonial.SINGLE,"DEV3.0", "21/02/2023", Role.BACKEND,Categorie.AB);
        Employe employe5 = new Employe("Sidonie", "F", StatutMatrimonial.SINGLE,"DEV3.0", "21/02/2023" , Role.CHEF_PROJET,Categorie.AB);
        Directeur directeur1 = new Directeur("David", "Koné", StatutMatrimonial.ENGAGED, "DGN2","15/01/2020",Role.DIRECTEUR, Categorie.C, 4 );

        List<Employe> employeList = Arrays.asList(employe1, employe3, employe4, employe5);

//        directeur1.ajouterEmployes(employeList).forEach(System.out::println);

        for(Employe employe : directeur1.ajouterEmployes(employeList))
            System.out.println(employe);





    }
}