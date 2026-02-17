/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author Caio
 * Here Im create a abstract class car to define an entity of data base 
 * And all class that extends this will have the same columns 
 */
public abstract class AbstractCar {
    
        protected     String   licensePlate;
        protected     String   model;
        protected     int      year;
        protected     float    km;
        
        //Here I made that because one class of some brand can`t set another brand
        protected abstract String getBrand();
        
        //template method
        public final void CarInfo(){
            printBasicInfo();
        }
        
        public AbstractCar(String licensePlate, String model, int Year, float km){

            this.licensePlate   = licensePlate;
            this.model          = model;
            this.year           = year;
            this.km             = km;
        }
        
        protected void printBasicInfo(){
            System.out.println("Marca: " + getBrand());
            System.out.println("Modelo: " + getModel());
            System.out.println("Ano: " + getYear());
            System.out.println("Placa: " + getLicensePlate());
            System.out.println("Km: " + getKm());
            
        }

        public String getLicensePlate() {
            return licensePlate;
        }

        public String getModel() {
            return model;
        }

        public int getYear() {
            return year;
        }

        public float getKm() {
            return km;
        }

        public void setLicensePlate(String licensePlate) {
            this.licensePlate = licensePlate;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public void setKm(float km) {
            this.km = km;
        }
        
        
}
