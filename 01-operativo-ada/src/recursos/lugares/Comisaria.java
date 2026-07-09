/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recursos.lugares;

import general.Constantes;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import recursos.armas.ArmaCortoAlcance;
import recursos.personajes.Policia;

/**
 *
 * @author recio
 */
public class Comisaria {
    //Atributo de tipo arraylist.
    private ArrayList<Policia> policias;
    
    //Constructores
    public Comisaria() {
        this.policias = new ArrayList<Policia>();
    }

    public Comisaria(ArrayList<Policia> policias) {
        this.policias = policias;
    }

    //Getters y Setters
    public ArrayList<Policia> getPolicias() {
        return policias;
    }

    public void setPolicias(ArrayList<Policia> policias) {
        this.policias = policias;
    }

    //ToString
    @Override
    public String toString() {
        return "Comisaria{" + "policias=" + policias + '}';
    }

    //Métodos auxiliares para pedir los datos del policia.
    public String pedirNombre() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nombre: ");
        String nombre = scanner.next();
        return nombre;
    }

    public String pedirDepartamento() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Departamento (Inteligencia, Operaciones o Investigacion): ");
        String dept = scanner.next();
        return dept;
    }

    public String pedirPermiso() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Permiso de armas (Corto o Largo alcance): ");
        String permiso = scanner.next();
        return permiso;
    }

    public String pedirRango() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Rango (Agente, Inspector o comisario): ");
        String rango = scanner.next();
        return rango;
    }

    //Meetodo para crear policias.
    public void crearPolicia() {
        System.out.println(Constantes.AZUL+"[*][*][*] Creando policia... [*][*][*]"+Constantes.BORRAR);
        String nombre = pedirNombre();
        String departamento = pedirDepartamento();
        String permiso = pedirPermiso();
        String rango = pedirRango();

        char marca = nombre.charAt(0);

        ArmaCortoAlcance arma = new ArmaCortoAlcance();

        Policia policia = new Policia(nombre, marca, Constantes.UBICACION_COMISARIA_FILA, Constantes.UBICACION_COMISARIA_COLUMNA, arma, departamento, permiso, rango);

        policias.add(policia);

        System.out.println(Constantes.FONDO_VERDE+"[v] Policia integrado en la unidad."+Constantes.BORRAR);
    }

    //Metodo para mostrar policias.
    public void mostrarPolicias() {
        Iterator<Policia> it = policias.iterator();
        if (policias.isEmpty()) {
            System.out.println(Constantes.FONDO_ROJO+"[x] No hay policias en la unidad."+Constantes.BORRAR);
        } else {
            while (it.hasNext()) {
                Policia aux = it.next();
                System.out.println(aux.toString());
            }
        }
    }

    //Metodo para buscar policias
    public void buscarPolicia() {
        Scanner scanner = new Scanner(System.in);
        int numPlaca;
        int cont = 0;
        boolean encontrado = false;

        if (policias.isEmpty()) {
            System.out.println(Constantes.FONDO_ROJO+"[x] No hay policias en la unidad."+Constantes.BORRAR);
        }

        System.out.println("Introduzca un numero de placa: ");
        numPlaca = scanner.nextInt();

        while (cont < policias.size() && encontrado == false) {
            Policia aux = policias.get(cont);
            if (aux.getNumeroPlaca() == numPlaca) {
                System.out.println(Constantes.FONDO_VERDE+"[v] Policia encontrado."+Constantes.BORRAR);

                encontrado = true;
            } else {
                cont++;
            }
        }
        if (!encontrado) {
            System.out.println(Constantes.FONDO_ROJO+"[x] Policia no encontrado."+Constantes.BORRAR);
        }
    }

    //Metodo para modificar policias.
    public void modificarPolicia() {
        Scanner scanner = new Scanner(System.in);
        int numPlaca;
        int cont = 0;
        boolean encontrado = false;

        System.out.println("Introduzca un numero de placa: ");
        numPlaca = scanner.nextInt();

        while (cont < policias.size() && encontrado == false) {
            Policia aux = policias.get(cont);
            if (aux.getNumeroPlaca() == numPlaca) {
                System.out.println("Policia encontrado.");
                System.out.println("¿Que atributo quieres modificar?");
                System.out.println("[1] Nombre");
                System.out.println("[2] Departamento");
                System.out.println("[3] Permiso de armas");
                System.out.println("[4] Rango");

                int opt = scanner.nextInt();

                switch (opt) {
                    case 1: {
                        System.out.println("Nombre: ");
                        String nombre = scanner.next();
                        aux.setNombre(nombre);
                        break;
                    }
                    case 2: {
                        System.out.println("Departamento (Inteligencia, Operaciones o Investigacion): ");
                        String dept = scanner.next();
                        aux.setDepartamento(dept);
                        break;
                    }
                    case 3: {
                        System.out.println("Permiso de armas (Corto o Largo alcance): ");
                        String permiso = scanner.next();
                        aux.setPermisoArma(permiso);
                        break;
                    }
                    case 4: {
                        System.out.println("Rango (Agente, Inspector o comisario): ");
                        String rango = scanner.next();
                        aux.setRango(rango);
                        break;
                    }
                }
                System.out.println(Constantes.FONDO_VERDE+"[v] Policia modificado."+Constantes.BORRAR);
                encontrado = true;
            } else {
                cont++;
            }
        }
        if (!encontrado) {
            System.out.println(Constantes.FONDO_ROJO+"[x] Policia no encontrado."+Constantes.BORRAR);
        }

    }

    //Metodo para eliminar policia.
    public void eliminarPolicia(){
        System.out.println(Constantes.FONDO_ROJO+"[*][*][*] Eliminando policia... [*][*][*]"+Constantes.BORRAR);
        Scanner scanner = new Scanner(System.in);
        boolean encuentra = false;
        int numPlaca;
        int cont = 0;
        
        System.out.println("Introduzca un numero de placa: ");
        numPlaca = scanner.nextInt();
        
        while(cont<policias.size() && encuentra == false){
            Policia aux = policias.get(cont);
            if(aux.getNumeroPlaca() == numPlaca){
                policias.remove(cont);
                System.out.println(Constantes.FONDO_VERDE+"[v] Policia encontrado."+Constantes.BORRAR);
                System.out.println(Constantes.FONDO_VERDE+"[v] Policia eliminado."+Constantes.BORRAR);
                encuentra = true;
            }
            else{
                cont++;
            }
        }
        if(!encuentra){
            System.out.println(Constantes.FONDO_ROJO+"[x] Policia no encontrado."+Constantes.BORRAR);
        }
    }
    
    //Metodo para elegir policia.
    public Policia elegirPolicia(){
        System.out.println(Constantes.AZUL+"[*][*][*] Seleccionando policia... [*][*][*]"+Constantes.BORRAR);
        Scanner scanner = new Scanner(System.in);
        Policia poliSelec = new Policia();
        boolean encuentra = false;
        int numPlaca;
        int cont = 0;
        
        System.out.println("Introduzca un numero de placa: ");
        numPlaca = scanner.nextInt();
        
        while(cont<policias.size() && encuentra == false){
            Policia aux = policias.get(cont);
            if(aux.getNumeroPlaca() == numPlaca){
                System.out.println(Constantes.FONDO_VERDE+"[v] Policia encontrado."+Constantes.BORRAR);
                System.out.println(Constantes.FONDO_VERDE+"[v] ¡Hecho! Ahora controlas a "+policias.get(cont).getNombre()+Constantes.BORRAR);
                poliSelec = aux;
                encuentra = true;
            }
            else{
                cont++;
            }
        }
        if(!encuentra){
            System.out.println(Constantes.FONDO_ROJO+"[x] Policia no encontrado."+Constantes.BORRAR);
        }
        
        return poliSelec;
    }
}
