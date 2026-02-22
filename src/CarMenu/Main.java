/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CarMenu;

import DAO.CarMapDAO;
import java.util.Scanner;

/**
 *
 * @author Caio
 */
public class Main {
    public static void main(String[] args){
        CarMapDAO app = new CarMapDAO();
        Scanner scan = new Scanner(System.in);
        while(true){
            System.out.println("\n");
        
            System.out.println("""
            ╔══════════════════════════════════════════════════╗
            ║          🚗  GERENCIADOR DE VEÍCULOS  🚗         ║
            ╠══════════════════════════════════════════════════╣
            ║                                                  ║
            ║   1  ➜  Cadastrar novo veículo                   ║
            ║   2  ➜  Buscar veículo por placa                 ║
            ║   3  ➜  Atualizar veículo                        ║
            ║   4  ➜  Remover veículo                          ║
            ║   5  ➜  Listar todos os veículos                 ║
            ║                                                  ║
            ║   0  ➜  Sair                                     ║
            ║                                                  ║
            ╚══════════════════════════════════════════════════╝
            """);
            
            
            
            //I put this to solve the bug that after entering with numerical, the nextLine() is skipped

            int option = (Integer.parseInt(scan.nextLine()));
            switch(option){
                case 1-> app.ImplementCar();
                case 2-> app.searchCar();
                case 3-> app.updateCar();
                case 4-> app.removeCar();
                case 5->app.getAllCars();
                default->System.exit(0);
            }
        }
        
    }
  }

