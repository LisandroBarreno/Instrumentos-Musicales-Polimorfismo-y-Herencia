    /*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
     */
    package music;

    /**
     *
     * @author USER
     */
    import java.util.Scanner;

    public class Main {
        /**
         * @param args the command line arguments
         */

        public static void main(String[] args) {
            // TODO code application logic here
            Scanner scan = new Scanner(System.in);

            InstrumentoMusical[] instrumentos = {
                new Piano(), new Guitarra(), new Bateria(), new Ocarina(),
                new Ukulele(), new Kalimba(), new Arpa(), new Voz()
            };

           
           int op;
           int sub_op;
           do{
               show_menu();
               op = scan.nextInt();
               if (op >= 1 && op <= instrumentos.length) {
                   sub_menu();
                   sub_op = scan.nextInt();
                   InstrumentoMusical instrumento = instrumentos[op - 1];
                   if (sub_op == 1) {
                           instrumento.emitir_sonido();
                       } if (sub_op == 2){
                           instrumento.tocar_cancion();         
                       } else {
                           System.out.println("Error. Fuera de rango.");
                       }
               } else if (op != 9) {
                   System.out.println("Error. Opcion fuera de rango.");
               } else {
                   System.out.println("Saliendo del programa...");
               }
           } while (op != 9);
        }

        public static void show_menu() {
            System.out.println("---Bienvenido a la orquesta musical---");
            System.out.println("1. Piano.");
            System.out.println("2. Guitarra.");
            System.out.println("3. Bateria.");
            System.out.println("4. Ocarina.");
            System.out.println("5. Ukulele.");
            System.out.println("6. Kalimba.");
            System.out.println("7. Arpa.");
            System.out.println("8. Voz (cantante).");
            System.out.println("9.Salir del programa.");
            System.out.print("Tu seleccion: ");
        }

        public static void sub_menu(){
            System.out.println("1. Emitir sonido");
            System.out.println("2. Tocar cancion.");
            System.out.print("Tu seleccion: ");
        }
    }
