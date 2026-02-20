/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import domain.AbstractCar;
import domain.Chevrolet;
import domain.Honda;
import domain.Vw;
import java.util.HashMap;
import java.util.List;
import java.lang.String;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Caio
 */
//Here is the code that get data from users 
public class CarMapDAO<ID, T> extends AbstractCarMapDAO<ID, T>{

    public void ImplementCar(){
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
        scan.nextLine();
        
        System.out.println("\n╔═══════════════════════════════════════════╗");
        System.out.println("║  DIGITE A PLACA                        ║");
        System.out.println("╚═════════════════════════════════════════════╝");
        System.out.print("Placa: ");
        String licensePlate = scan.nextLine();
        
        System.out.println("\n╔═══════════════════════════════════════════╗");
        System.out.println("║  DIGITE O MODELO                       ║");
        System.out.println("╚══════════════════════════════════════════════╝");
        System.out.print("Modelo: ");
        String model = scan.nextLine();
        
        System.out.println("\n╔═══════════════════════════════════════════╗");
        System.out.println("║  DIGITE O ANO                          ║");
        System.out.println("╚══════════════════════════════════════════════╝");
        System.out.print("Ano: ");
        int year = scan.nextInt();
        
        System.out.println("\n╔═══════════════════════════════════════════╗");
        System.out.println("║  DIGITE OS KMS                       ║");
        System.out.println("╚═══════════════════════════════════════════╝");
        float km = scan.nextInt();
       
        
        AbstractCar car = switch(brand){
            case 1 -> new Chevrolet(licensePlate, model, year, km);
            case 2 -> new Honda(licensePlate, model, year, km);
            case 3 -> new Vw(licensePlate, model, year, km);
            default -> throw new IllegalArgumentException("Marca inválida");
  
        };
        
        createCar((ID) licensePlate, (T) car );
    }
    
 
    public void removeCar() {
        ID id = getID();
        deleteCar(id);
    }

    public void updateCar(){
        ID id = getID();
        AbstractCar current = (AbstractCar) getCar(id);
        
        System.out.println("""
                          ╔═══════════════════════════════════════════╗
                          ║  SELECIONE O QUE QUER ATUALIZAR      ║
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
                    System.out.println("Novo modelo:");
                    current.setModel(scan.nextLine());
                case 2:
                    System.out.println("Digite o ano: (YYYY)");
                    current.setYear(scan.nextInt());
                case 3:
                    System.out.println("Digite o Km: ");
                    current.setKm(scan.nextInt());
        }
                
        
        updateCar(id, (T) current);
    }

    public T searchCar() {
        ID id = getID();
        return getCar(id);
    }
    
}
