/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author Caio
 */
public class Honda extends AbstractCar{
    
    public Honda(String licensePlate, String model, int year, float km){
        super(licensePlate, model, year, km);
    }

    @Override
    protected String getBrand() {
        return "Honda";
    }
}
