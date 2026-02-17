/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import domain.AbstractCar;
import domain.Chevrolet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Caio
 */
public class CarMapDAO<K, V> implements ICarDAO{
    Map<K, V> mapCar = new HashMap();
    Scanner scan = new Scanner(System.in);

    @Override
    public void createCar(Object entity) {
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
        
        
        switch(brand){
            case 1:
                AbstractCar car = new Chevrolet(licensePlate, model, year, km);
                break;
        }
        
        
    }

    @Override
    public void deleteCar(Object id) {
        String licensePlate = getLicensePlate();
        
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
        int brand = scan.nextInt();
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
    
    public boolean validateLicensePlate(String licensePlate){

        if(!mapCar.containsKey(licensePlate)){
            return true;
        } else {
            System.out.println("Essa placa já esta cadastrada");
            return false;
        }
          
    }
    
    public String getLicensePlate(){
        System.out.println("\n╔═══════════════════════════════════════════╗");
        System.out.println("║  DIGITE A PLACA                          ║");
        System.out.println("║  Formato antigo: ABC1234                 ║");
        System.out.println("║  Formato Mercosul: ABC1D23               ║");
        System.out.println("╚═══════════════════════════════════════════╝");
        System.out.print("Placa: ");
        String licensePlate = scan.nextLine().toUpperCase();
        
        if(mapCar.isEmpty()){
            System.out.println("❌ Operação não pode ser concluida, não existe carro cadastrado");
            
        }
        
        
        while(!validateLicensePlate(licensePlate)){
            System.out.println("❌ Placa inválida! Use formato ABC1234 ou ABC1D23");
            System.out.print("Placa: ");
            licensePlate = scan.nextLine().toUpperCase();
        }
        
        return licensePlate;
    }
}
