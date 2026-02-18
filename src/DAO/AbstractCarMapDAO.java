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
 */
public abstract class AbstractCarMapDAO<ID, T> implements ICarDAO<ID, T> {
    
    Map<ID, T> database = new HashMap();
    Scanner scan = new Scanner(System.in);

    @Override
    public void createCar(ID id, T entity) {
        if(database.containsKey(id)){
            System.out.print("Não é possível cadastrar uma placa já existente");
        }
        
        database.put(id, entity);
        
    }

    @Override
    public void deleteCar(ID id) {
        if(validateId(id)){
            database.remove(id);
        }
    }

    @Override
    public void updateCar(ID id, T entity) {
        if(validateId(id)){
            database.replace(id, database.get(id), entity);
        }
    }

    @Override
    public List<T> getAllCars() { 
        if(database.isEmpty()){
            System.out.println("Nenhum carro cadastrado");
            return new ArrayList<>();  
        }
        return new ArrayList<>(database.values());
    }

    @Override
    public T getCar(ID id) {
        if(validateId(id)){
            database.get(id);
        }
        System.out.println("❌ Carro não encontrado: " + id);
        return null;
    }
    
    public boolean validateId(ID id){
        while(!database.containsKey(id)){
            System.out.println("❌ Placa inválida! Use formato ABC1234 ou ABC1D23");
            System.out.print("Placa: ");
            id = (ID) scan.nextLine().toUpperCase();
            return false;
        }
        return true;
    }
    
    public ID getID(Object entity){
        if(entity.getClass() == AbstractCar.class){
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
        return null;
    }
        
}
