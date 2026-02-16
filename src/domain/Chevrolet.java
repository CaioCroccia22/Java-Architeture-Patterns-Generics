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

✅ Uma única tabela e um único DAO
✅ Fácil consultar todos os carros
✅ Flexível para adicionar novos tipos
✅ Mantém princípios OO (polimorfismo)
 */
public class Chevrolet extends AbstractCar {
       
    public Chevrolet(Long licensePlate, String model, int Year, float km) {
        super(licensePlate, model, Year, km);
    }
    
    protected getCar()
       
       
    
}
