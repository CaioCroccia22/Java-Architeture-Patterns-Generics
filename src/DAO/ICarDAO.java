/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import domain.AbstractCar;

import java.util.List;

/**
 *
 * @author Caio
 * Here I will implement an interface to declare methods of data base
 * Here the ideia is any one car model can be this methods 
 * I am pass to generics, because in the future I can use another type to ID
 */
public interface ICarDAO<T, ID> {
    public void createCar(T entity);
    public void deleteCar(ID id);
    public void updateCar(T entity);
    public List<T> getAllCars();
    public AbstractCar getCar(ID id);
}
