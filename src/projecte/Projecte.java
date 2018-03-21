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
                System.out.println("babai");
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
        } else {
            System.out.println("No caben més vaporitzador, borra'n un primer");
        }
    }

    public static void modificarVaporitzador() {

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

    }
}
