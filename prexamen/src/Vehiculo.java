import java.util.Scanner;
import java.util.InputMismatchException;

public class Vehiculo {

    public static String marca;
    public static String numerodeplaca;
    public static double nivelactualcombustible = 0.00;
    public static double capacidadtotaldeltanque;
    public static double rendimiento = 2.00;

    public static Scanner leer = new Scanner(System.in);

    public Vehiculo(String marca, String numerodeplaca, double nivelactualcombustible, double capacidadtotaldeltanque) {
        this.marca = marca;
        this.numerodeplaca = numerodeplaca;
        this.nivelactualcombustible = nivelactualcombustible;
        this.capacidadtotaldeltanque = capacidadtotaldeltanque;
    }

    public static void lee() {
        System.out.println("Bienvenido! ¿Qué marca será su coche?");
        marca = leer.nextLine();

        System.out.println("Muy bien! La marca " + marca + " suena muy original! Ahora ingrese el numero de placa de su vehiculo");
        numerodeplaca = leer.nextLine();

        System.out.println("Genial! La placa de su vehiculo será: " + numerodeplaca);

        do {
            try {
                System.out.println("Ingrese la capacidad maxima de gasolina (En galones) que podrá retener su carro ");
                capacidadtotaldeltanque = leer.nextDouble();
                break;
            } catch (Exception e) {
                System.out.println("Ups, parece que ingreso un dato invalido");
                leer.nextLine();
            }
        } while (true);
    }

    public static void opciones() {
        lee();

        boolean salir = false;
        do {
            System.out.println("------------------------------------------------------------------------------------------------");
            System.out.println("Hoy es un día perfecto para viajar! ¿Qué te gustaría hacer como primer paso?");
            System.out.println("1. Conducir");
            System.out.println("2. Rellenar el tanque");
            System.out.println("3. Salir");
            System.out.println("Elija una opción:");

            try {
                int opcion = leer.nextInt();
                switch (opcion) {
                    case 1:
                        System.out.println("Muy bien! ¿Cuántos Kilómetros vamos a recorrer en nuestro bonito viaje?");
                        double distancia = leer.nextDouble();
                        double verificar = conducir(distancia);
                        if (verificar == -1) {
                            System.out.println("Oye! un momento, parece que no podrás conducir el día de hoy, ve a revisar si tienes la gasolina suficiente para realizar el viaje");
                        } else {
                            System.out.println("Perfecto! Podrás conducir sin ningún problema, incluso te sobrarán " + verificar + " galones de gasolina.");
                            System.out.println("¡Suerte en tu futuro viaje!");
                        }
                        break;
                    case 2:
                        System.out.println("Perfecto! Ingrese la cantidad de gasolina a rellenar:");
                        double cantidad = leer.nextDouble();
                        double cant = rellenar(cantidad);
                        if (cant == -1) {
                            System.out.println("Ups, parece que has ingresado un valor fuera del rango de tu capacidad total.");
                        } else {
                            System.out.println("La gasolina fue agregada correctamente. ¡Felicidades! Pasa un bonito viaje.");
                        }
                        break;
                    
                    case 3:
                        System.out.println("¡Hasta luego!");
                        salir = true;
                        break;
                    default:
                        System.out.println("¡Ups! Ingresaste un valor no válido, por favor vuelve a revisar las opciones.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Valor inválido. Intente de nuevo.");
                leer.nextLine(); // Limpia el buffer del teclado
            }
        } while (!salir);
    }

    public static double rellenar(double galonesaingresar) {
        if (galonesaingresar <= 0 || galonesaingresar + nivelactualcombustible > capacidadtotaldeltanque) {
            return -1;
        }
        nivelactualcombustible += galonesaingresar;
        return nivelactualcombustible;
    }

    public static double conducir(double distancia) {
        double totalagastar = distancia * rendimiento;
        double gasolinarestante = nivelactualcombustible - totalagastar;
        if (gasolinarestante < 0) {
            return -1;
        }
        nivelactualcombustible = gasolinarestante;
        return nivelactualcombustible;
    }

    
}
