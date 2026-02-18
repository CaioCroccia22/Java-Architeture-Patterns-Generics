/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import domain.AbstractCar;
import domain.Chevrolet;
import java.util.HashMap;
import java.util.List;
import java.lang.String;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Caio
 * @param <K>
 * @param <V>
 */
//Here Im limiting type to String and AbstractCar to put on the map licensePlate for key
//and car for value, therefore I can insert all type of car using generics
public class CarMapDAO<V extends AbstractCar> implements ICarDAO{

    @Override
    public void createCar(T entity) {
        System.out.println("""
                          ╔═══════════════════════════════════════════╗
                          ║  SELECIONE A MARCA DO CARRO          ║
                          ╠═══════════════════════════════════════════╣
                          ║  1 - Chevrolet                       ║
                          ║  2 - Honda                           ║
                          ║  3 - Volkswagen                      ║
                          ║                                      ║
                          ╚═══════════════════════════════════════════╝
                           """);
        int brand = scan.nextInt();
        
        System.out.println("\n╔═══════════════════════════════════════════╗");
        System.out.println("║  DIGITE O MODELO                         ║");
        System.out.println("╚═══════════════════════════════════════════╝");
        System.out.print("Modelo: ");
        String model = scan.nextLine();
        
        System.out.println("\n╔═══════════════════════════════════════════╗");
        System.out.println("║  DIGITE O ANO                            ║");
        System.out.println("╚═══════════════════════════════════════════╝");
        System.out.print("Ano: ");
        int year = scan.nextInt();
        
        System.out.println("\n╔═══════════════════════════════════════════╗");
        System.out.println("║  DIGITE OS KMS                       ║");
        System.out.println("╚═══════════════════════════════════════════╝");
        float km = scan.nextInt();
        
        String licensePlate = getLicensePlate();
        
        AbstractCar car = null;
        
        
        switch(brand){
            case 1:
                car = new Chevrolet(licensePlate, model, year, km);
                
                break;
            case 2:
                car = new Honda(licensePlate, model, year, km);
                
                break;
        }
        //Here Im made casting because car need to be especific type of brand, like chevrolet and others..
        mapCar.put(licensePlate, (V) car);
        
        
    }

    @Override
    public void deleteCar(String licensePlate) {

        if(!validateLicensePlate(licensePlate)){
            licensePlate = getLicensePlate();
            return;
        }
        
        mapCar.remove(licensePlate);
        System.out.print("Removido o carro de placa: " + licensePlate);
    }

    @Override
    public void updateCar(Object entity) {
        String licensePlate = getLicensePlate();
         System.out.println("""
                          ╔═══════════════════════════════════════════╗
                          ║  SELECIONE A MARCA DO CARRO          ║
                          ╠═══════════════════════════════════════════╣
                          ║  1 - Modelo                          ║
                          ║  2 - Ano                             ║
                          ║  3 - Km                              ║
                          ║                                      ║
                          ╚═══════════════════════════════════════════╝
                           """);
        int option = scan.nextInt();
        switch(option){
            case 1:
                        System.out.println("\n╔═════════════════════════════════════════╗");
                        System.out.println("║  DIGITE O MODELO                     ║");
                        System.out.println("╚═══════════════════════════════════════════╝");
                        System.out.print("Modelo: ");
                        String model = scan.nextLine();
                mapCar.replace(licensePlate, Chevrolet.set, newValue)
        }
        //mapCar.replace(key, oldValue, newValue)
    }

    @Override
    public List getAllCars() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public AbstractCar getCar(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
