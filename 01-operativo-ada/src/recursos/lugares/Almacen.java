/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recursos.lugares;

import general.Constantes;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import recursos.armas.Arma;
import recursos.armas.ArmaCortoAlcance;
import recursos.armas.ArmaLargoAlcance;
import recursos.armas.Bala;
import recursos.personajes.Personaje;

/**
 *
 * @author recio
 */
public class Almacen {
    //Atributo tipo mapa.
    private Map<String, Arma> armas;

    //Constructores
    public Almacen() {
        this.armas = new HashMap<String, Arma>();
    }

    public Almacen(Map<String, Arma> armas) {
        this.armas = armas;
    }

    //Getters y Setters
    public Map<String, Arma> getArmas() {
        return armas;
    }

    public void setArmas(Map<String, Arma> armas) {
        this.armas = armas;
    }

    //ToString;
    @Override
    public String toString() {
        return "Almacen{" + "armas=" + armas + '}';
    }

    //Métodos auxiliares para pedir los datos de las armas.
    public int pedirDiametro() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Diametro de bala: ");
        int diametro = scanner.nextInt();
        return diametro;
    }

    public int pedirAlcance() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Alcance: ");
        int alcance = scanner.nextInt();
        return alcance;
    }

    public int pedirVelocidad() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Velocidad: ");
        int velocidad = scanner.nextInt();
        return velocidad;
    }

    //Metodo para crear arma.
    public void crearArma() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(Constantes.CELESTE + "[*][*][*] Creando Arma [*][*][*]" + Constantes.BORRAR);
        System.out.println("¿Que tipo de arma quieres crear?");
        System.out.println("[1] Arma Corto Alcance");
        System.out.println("[2] Arma Largo Alcance");

        int opt = scanner.nextInt();

        switch (opt) {
            case 1: {
                ArmaCortoAlcance arma = new ArmaCortoAlcance();
                int diametro = pedirDiametro();
                int alcance = pedirAlcance();
                arma.setAlcance(alcance);
                arma.setDiametroBala(diametro);

                String clave = arma.getIdentificador();

                armas.put(clave, arma);
                System.out.println("[v] Arma creada en el almacen.");
                break;
            }
            case 2: {
                ArmaLargoAlcance arma = new ArmaLargoAlcance();
                int diametro = pedirDiametro();
                int velocidad = pedirVelocidad();
                arma.setVelocidad(velocidad);
                arma.setDiametroBala(diametro);

                String clave = arma.getIdentificador();

                armas.put(clave, arma);
                System.out.println(Constantes.FONDO_VERDE + "[v] Arma creada en el almacen." + Constantes.BORRAR);
                break;
            }
            default:
                System.out.println("No se pueden crear armas del tipo seleccionado.");
        }
    }

    //Metodo para mostrar armas.
    public void mostrarArmas() {
        if (armas.isEmpty()) {
            System.out.println(Constantes.FONDO_ROJO + "[x] No hay armas en el almacen." + Constantes.BORRAR);
        } else {
            System.out.println(Constantes.CELESTE + "[*][*][*] Mostrando armas... [*][*][*]" + Constantes.BORRAR);
            Iterator<String> it = armas.keySet().iterator();
            String clave;
            while (it.hasNext()) {
                clave = it.next();
                System.out.println(armas.get(clave).toString());
            }
        }
    }
    
    //Metodo para modificación de armas de corto alcance.
    private void modificarArmaCortoAlcance(ArmaCortoAlcance arma) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("¿Que atributo quieres modificar?");
        System.out.println("[1] Número de balas del cartucho");
        System.out.println("[2] Diámetro de bala");
        System.out.println("[3] Alcance");

        int opcion = scanner.nextInt();
        

        switch (opcion) {
            case 1:
                System.out.print("Numero de balas: ");
                int nuevoNumeroBalas = scanner.nextInt();
                arma.setCargador(new Bala[nuevoNumeroBalas]); 
                System.out.println(Constantes.FONDO_VERDE+"[v] Arma modificada"+Constantes.BORRAR);
                break;

            case 2:
                System.out.print("Diametro: ");
                int nuevoDiametroBala = scanner.nextInt();
                arma.setDiametroBala(nuevoDiametroBala);
                System.out.println(Constantes.FONDO_VERDE+"[v] Arma modificada"+Constantes.BORRAR);
                break;

            case 3:
                System.out.print("Nuevo alcance: ");
                int nuevoAlcance = scanner.nextInt();
                ((ArmaCortoAlcance) arma).setAlcance(nuevoAlcance); 
                System.out.println(Constantes.FONDO_VERDE+"[v] Arma modificada"+Constantes.BORRAR);
                break;

            default:
                System.out.println("Opción inválida. No se realizó ninguna modificación.");
        }
    }
   
    //Metodo para modificación de armas de largo alcance.
    private void modificarArmaLargoAlcance(ArmaLargoAlcance arma) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("¿Que atributo quieres modificar?");
        System.out.println("[1] Numero de balas del cartucho");
        System.out.println("[2] Diametro de bala");
        System.out.println("[3] Velocidad");

        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                System.out.print("Nuevo número de balas del cargador: ");
                int nuevoNumeroBalas = scanner.nextInt();
                arma.setCargador(new Bala[nuevoNumeroBalas]); 
                System.out.println("Número de balas actualizado.");
                break;

            case 2:
                System.out.print("Nuevo diámetro de bala: ");
                int nuevoDiametroBala = scanner.nextInt();
                arma.setDiametroBala(nuevoDiametroBala);
                System.out.println("Diámetro de bala actualizado.");
                break;

            case 3:
                System.out.print("Nueva velocidad: ");
                int nuevaVelocidad = scanner.nextInt();
                ((ArmaLargoAlcance) arma).setVelocidad(nuevaVelocidad); 
                System.out.println("Velocidad actualizada.");
                break;

            default:
                System.out.println("Opción inválida. No se realizó ninguna modificación.");
        }
    }
   
    //Metodo principal de modificar armas.
    public void modificarArma() {
        if (armas.isEmpty()) { 
            System.out.println(Constantes.FONDO_ROJO + "[x] No hay armas en el almacén" + Constantes.BORRAR);
        } 
        else {
            System.out.println(Constantes.CELESTE + "[*][*][*] Modificando armas... [*][*][*]" + Constantes.BORRAR);
           
            Scanner scanner = new Scanner(System.in);
           
            System.out.print("Escribe el identificador del arma: ");
            String identificador = scanner.nextLine();

            Arma arma = armas.get(identificador);

            if (arma == null) {
                System.out.println(Constantes.FONDO_ROJO + "[x] No se encontró ninguna arma con ese identificador." + Constantes.BORRAR);
            } 
            else {
                if (arma instanceof ArmaCortoAlcance) {
                    modificarArmaCortoAlcance((ArmaCortoAlcance) arma);
                } 
                else if (arma instanceof ArmaLargoAlcance) {
                    modificarArmaLargoAlcance((ArmaLargoAlcance) arma);
                } 
                else {
                    System.out.println(Constantes.FONDO_ROJO + "[x] Tipo de arma no encontrado." + Constantes.BORRAR);
                }
                System.out.println(Constantes.FONDO_VERDE + "[v] Arma modificada." + Constantes.BORRAR);
            }
        }
    }
    
    //Metodo para eliminar el arma.
    public void eliminarArma(){
        System.out.println(Constantes.FONDO_CELESTE+"[*][*][*] Eliminando Arma... [*][*][*]"+Constantes.BORRAR);
        
        Iterator <String> it = armas.keySet().iterator();
        Scanner scanner = new Scanner(System.in);
        boolean encuentra = false;
        String id;
        
        System.out.println("Escribe el identificador del arma: ");
        id = scanner.next();
        
        while(it.hasNext() && encuentra == false){
            String clave = it.next();
            if(armas.get(clave).getIdentificador().equalsIgnoreCase(id)){
                armas.remove(clave);
                System.out.println(Constantes.FONDO_VERDE + "[v] Arma encontrada." + Constantes.BORRAR);
                System.out.println(Constantes.FONDO_VERDE + "[v] Arma eliminada." + Constantes.BORRAR);
                encuentra = true;
            }
        }
        if(!encuentra){
            System.out.println(Constantes.FONDO_ROJO+"[x] Arma no encontrada."+Constantes.BORRAR);
        }
    }
    
    //Metodo para elegir arma.
    public Arma elegirArma(){
        System.out.println(Constantes.FONDO_CELESTE+"[*][*][*] Seleccionando Arma... [*][*][*]"+Constantes.BORRAR);
        
        Iterator <String> it = armas.keySet().iterator();
        Scanner scanner = new Scanner(System.in);
        boolean encuentra = false;
        String id;
        
        Arma armaSelec = new Arma() {
            @Override
            public void disparar(Personaje enemigo) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        };
        
        System.out.println("Escribe el identificador del arma: ");
        id = scanner.next();
        
        while(it.hasNext() && encuentra == false){
            String clave = it.next();
            if(armas.get(clave).getIdentificador().equalsIgnoreCase(id)){
                System.out.println(Constantes.FONDO_VERDE + "[v] Arma encontrada." + Constantes.BORRAR);
                System.out.println(Constantes.FONDO_VERDE + "[v] ¡Hecho! tu jugador lleva el arma con identificador "+armas.get(clave).getIdentificador()+ Constantes.BORRAR);
                armaSelec = armas.get(clave);
                encuentra = true;
            }
        }
        if(!encuentra){
            System.out.println(Constantes.FONDO_ROJO+"[x] Arma no encontrada."+Constantes.BORRAR);
        }
        
        return armaSelec;
    }

}
