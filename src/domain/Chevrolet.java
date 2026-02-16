/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author Caio
 * Aqui vou deixar o carro como objeto
 * Vantagens:


 */
public class Chevrolet extends AbstractCar {
       
    public Chevrolet(Long licensePlate, String model, int Year, float km) {
        super(licensePlate, model, Year, km);
    }
    
    @Override
    public String getBrand(){
        String brand = "Chevrolet";
        return brand;
    }
       
       
    
}
