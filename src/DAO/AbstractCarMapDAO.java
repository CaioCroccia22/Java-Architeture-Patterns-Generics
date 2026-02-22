/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import domain.AbstractCar;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


/**
 *
 * @author Caio
 * Here Im creating this abstract class to implement a Map, that simulate a Database, this map will be used 
 * with generics types that are received on methods of generic interface 
 * I have tried to create a map with car types, however it isn´t a good implementetion 
 * 
 * the responsability of this code is defined how my database will persist data
 */
public abstract class AbstractCarMapDAO<ID, T> implements ICarDAO<ID, T> {
    
    Map<ID, T> database = new HashMap();
    Scanner scan = new Scanner(System.in);
    String args[] = {};

    @Override
    public void createCar(ID id, T entity) {
        if(database.containsKey(id)){
            System.out.print("Não é possível cadastrar uma placa já existente");
            return;
        }
        
        database.put(id, entity);
        if(database.containsKey(id)){
            System.out.print("Adicionado com sucesso!!");
            
        }
        
    }

    @Override
    public void deleteCar(ID id) {
        if(validateId(id)){
            database.remove(id);
            System.out.println("Carro removido"  + "garagem atualmente" + database.toString());
        }
    }

    @Override
    public void updateCar(ID id, T entity) {
        if(validateId(id)){
            database.replace(id, database.get(id), entity);
            System.out.println("Carro alterado com sucesso" + entity);
        }
    }

    @Override
    public List<T> getAllCars() { 
        if(database.isEmpty()){
            System.out.println("Nenhum carro cadastrado");
            return new ArrayList<>();  
        }
        ArrayList<T> arr = new ArrayList<>(database.values());
        System.out.println(arr);
        return arr;
        
    }

    @Override
    public T getCar(ID id) {
        if(validateId(id)){
            System.out.println(database.get(id));
           return database.get(id);
        }
        System.out.println("❌ Carro não encontrado: " + id);
        return null;
    }
    
    public boolean validateId(ID id){
        while(!database.containsKey(id)){
            System.out.println("❌ Placa inválida! Use formato ABC1234 ou ABC1D23");
            id = getID();
        }
        return true;
    }
    
    public ID getID(){
            System.out.println("\n╔═══════════════════════════════════════════╗");
            System.out.println("║  DIGITE A PLACA                          ║");
            System.out.println("║  Formato antigo: ABC1234                 ║");
            System.out.println("║  Formato Mercosul: ABC1D23               ║");
            System.out.println("╚═══════════════════════════════════════════╝");

            System.out.print("Placa: ");

            ID id = (ID) scan.nextLine().toUpperCase();
            

            if(database.isEmpty()){
                System.out.println("❌ Operação não pode ser concluida, não existe carro cadastrado");

            }

            return id;
    }
        
}
