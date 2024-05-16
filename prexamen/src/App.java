public class App {
    public static void main(String[] args) throws Exception {
       

    Vehiculo carro =new Vehiculo(null, null, 0, 0);
carro.opciones();

        System.out.println("La marca de su carro es "+ carro.getMarca());
 System.out.println("------------------------------------------------"); 
 System.out.println("El nivel de gasolina que conserva es de "+ carro.getNivelactualcombustible()); 
 System.out.println("------------------------------------------------"); 
 System.out.println("Su capacidad maxima es de "+ carro.getCapacidadtotaldeltanque()); 
 System.out.println("------------------------------------------------"); 
 System.out.println(" Su numero de placa es de "+ carro.getNumerodeplaca()); 

    }
}
