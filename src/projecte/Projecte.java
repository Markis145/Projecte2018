/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecte;

import java.util.Scanner;

/**
 *
 * @author marcmestre
 */
public class Projecte {

    private static final int MAX_VAPORITZADORS = 5;

    private static Vaporitzador[] array = new Vaporitzador[MAX_VAPORITZADORS];

    private static int opcio;

    private static Scanner ent = new Scanner(System.in);
    
    private static char SiNo;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        inicialitzarVariables();
        do {
            demanarOpcio();
            tractarOpcio();
        } while (!opcioFinal());

    }

    public static void tractamentFinal() {
        ent.close();
    }
    
    public static void demanarOpcio() {
        Scanner ent = new Scanner(System.in);
        System.out.println("--------Men ú---------");
        System.out.println("0. Sortir");
        System.out.println("1. Introduir vaporitzador");
        System.out.println("2. Modificar vaporitzador");
        System.out.println("3. Borrar vaporitzador");
        System.out.println("4. Llistar vaporitzador");
        System.out.println("5. Recuperar vaporitzador borrat");
        opcio = ent.skip("[\r\n]*").nextInt();
    }

    public static void inicialitzarVariables() {
        for (int i = 0; i < array.length; i++) {
            array[i] = new Vaporitzador();
            array[i].setOmplit(false);
        }
    }

    public static void tractarOpcio() {

        switch (opcio) {
            case 0:
                System.out.println("Bye bye");
                break;
            case 1:
                introduirVaporitzador();
                break;
            case 2:
                modificarVaporitzador();
                break;
            case 3:
                borrarVaporitzador();
                break;
            case 4:
                llistarVaporitzador();
                break;
            case 5:
                recuperarVaporitzador();
                break;
            default:
                System.out.println("Opció incorrecta");
        }

    }

    public static boolean opcioFinal() {
        return opcio == 0;
    }

    public static void introduirVaporitzador() {
        Scanner ent = new Scanner(System.in);

        int i;
        for (i = 0; i < array.length && array[i].isOmplit(); i++);

        if (i < array.length) {
            System.out.println("\nModel: ");
            array[i].setModel(ent.skip("[\r\n]*").nextLine());
            System.out.println("\nMarca: ");
            array[i].setMarca(ent.skip("[\r\n]*").nextLine());
            System.out.println("\nNombre de bateríes: ");
            array[i].setNumB(ent.skip("[\r\n]*").nextInt());
            System.out.println("\nWattage màxim: ");
            array[i].setWatts(ent.skip("[\r\n]*").nextInt());

            char esElec;
            do {
                System.out.println("\nEs electrònic (Si/No)");
                esElec = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
            } while (esElec != 'S' && esElec != 'N');
            array[i].setElectronic(esElec == 'S');
            
            System.out.println("\nPreu: ");
            array[i].setPreu(ent.skip("[\r\n]*").nextInt());
            array[i].setOmplit(true);
        } else {
            System.out.println("No caben més vaporitzador, borra'n un primer");
        }
    }

    public static void modificarVaporitzador() {
        Scanner ent = new Scanner(System.in);
        Vaporitzador v = null;
        int cont = 1, i = 0;
        v = array[i];
        
        
        for (; i < array.length && SiNo != 'F'; i++) {
            if (array[i].isOmplit()) {
                System.out.format("\nVaporitzador %d:\n", cont++);
                System.out.println(array[i].toString());
                do {
                    System.out.println("\nVols modificar el vaporitzador(S/N) o finalitzar la cerca (F)?;");
                    SiNo = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
                } while (SiNo != 'S' && SiNo != 'N' && SiNo != 'F');
            }
            if (SiNo == 'S') {
                break;
            }
        }
        
        
        if (SiNo == 'S') {
            System.out.println("\nModel: " + array[i].getModel());
            do {
                System.out.println("\nVols modificar el model? (S/N):");
                SiNo = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
            } while (SiNo != 'S' && SiNo != 'N');
            if (SiNo == 'S') {
                System.out.println("Introdueix el model: ");
                array[i].setModel(ent.skip("[\r\n]*").nextLine());
            }
        }
        
        System.out.println("\nMarca: " + array[i].getMarca());
            do {
                System.out.println("\nVOls modificar la marca?(S/N):");
                SiNo = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
            } while (SiNo != 'S' && SiNo != 'N');
            if (SiNo == 'S') {
                System.out.println("Introdueix la marca: ");
                array[i].setMarca(ent.skip("[\r\n]*").nextLine());
        }
            
        System.out.println("\nNúmero de bateries: " + array[i].getNumbat());
            do {
                System.out.println("\nVols modificar el nombre de bateries?(S/N):");
                SiNo = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
            } while (SiNo != 'S' && SiNo != 'N');
            if (SiNo == 'S') {
                System.out.println("Introdueix el nombre de bateries: ");
                array[i].setNumB(ent.skip("[\r\n]*").nextInt());
        }
            
        System.out.println("\nWattatge màxim: " + array[i].getWatts());
            do {
                System.out.println("\nVols modificar el wattage màxim?(S/N):");
                SiNo = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
            } while (SiNo != 'S' && SiNo != 'N');
            if (SiNo == 'S') {
                System.out.println("Introdueix el wattatge màxim: ");
                array[i].setWatts(ent.skip("[\r\n]*").nextInt());
        }
            
        if (array[i].isElectronic()) {
                System.out.println("\nÉs electrònic");
            } else {
                System.out.println("\nÉs mecànic");
            }
            do {
                System.out.println("\nVols modificar si es electrònic o mecànic?(S/N):");
                SiNo = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
            } while (SiNo != 'S' && SiNo != 'N');
            if (SiNo == 'S') {
                char esElec;
                do {
                    System.out.println("Es electrònic?(S/N) ");
                    esElec = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
                } while (esElec != 'S' && esElec != 'N');
                if (esElec == 's') {
                    v.setElectronic(true);
                } else {
                    v.setElectronic(false);
                }
        }
            
        System.out.println("\nPreu: " + array[i].getPreu());
            do {
                System.out.println("\nVols modificar el preu?(S/N):");
                SiNo = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
            } while (SiNo != 'S' && SiNo != 'N');
            if (SiNo == 'S') {
                System.out.println("Introdueix el preu: ");
                array[i].setPreu(ent.skip("[\r\n]*").nextInt());
        }
    
    }

    public static void borrarVaporitzador() {
        char SiNo = ' ';
        Vaporitzador v = null;
        Scanner ent = new Scanner(System.in);
        int i;
        for (i = 0; i < array.length && SiNo != 'F'; i++) {
            v = array[i];
            if (v.isOmplit()) {
                System.out.println(v);
                do {
                    System.out.println("\nVols borrar el vaporitzador(S/N) o finalitzar la cerca (F)?:");
                    SiNo = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
                } while (SiNo != 'S' && SiNo != 'N' && SiNo != 'F');
            }
            if (SiNo == 'S') {
                break;
            }
        }

        if (SiNo == 'S') {
            v.setOmplit(false);
            System.out.println("Vaporitzador borrat");
        } else {
            System.out.println("No s'ha borrat cap vaporitzador");
        }

    }

    public static void llistarVaporitzador() {
        Scanner ent = new Scanner(System.in);
        
        boolean algun = false;
        char siNo = 'S';
        int i;
        for (i = 0; i < array.length; i++) {
            Vaporitzador v = array[i];
            if (v.isOmplit()) {
                algun = true;
                System.out.println(v);
                do {
                    System.out.println("\nVols veure mes vaporitzadors(S/N)?:");
                    siNo = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
                } while (siNo != 'S' && siNo != 'N');
            }
            if (siNo == 'N') {
                break;
            }
        }
        if (!algun) {
            System.out.println("\nNo hi ha vaporitzadors per mostrar");
        }

    }

    public static void recuperarVaporitzador() {
        Scanner ent = new Scanner(System.in);
        char siNo = 'N';
        int cont = 0, i;
        for (i = 0; i < array.length && siNo != 'S' && siNo != 'F'; i++) {
            if (!array[i].isOmplit()) {
                System.out.format("\nVaporitzador %d:\n", ++cont);
                System.out.println(array[i].toString());
                do {
                    System.out.println("\nVols recuperar el vaporitzador(S/N) o finalitzar la cerca (F)?:");
                    siNo = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
                } while (siNo != 'S' && siNo != 'N' && siNo != 'F');
            }
            if (siNo == 'S') {
                break;
            }
        }
        if (siNo == 'S') {
            array[i].setOmplit(true);
            System.out.println("Vaporitzador recuperat correctament.");
        } else {
            if(cont==0) System.out.println("No hi ha vaporitzadors per recuperar");
            else System.out.println("Vaporitzador no recuperat.");
        }
    }
}
