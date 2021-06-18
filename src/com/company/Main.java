package com.company;
import java.io.PrintStream;
import java.nio.channels.InterruptedByTimeoutException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static class AnyDimensions{
        Integer width;
        Integer height;
        Integer length;
        public AnyDimensions(Integer width, Integer height, Integer length) {
            this.width = width;
            this.height = height;
            this.length = length;
        }
    }

    public static class Transport {
        String model;
        String color;
        Integer power;
        AnyDimensions dimensions;

        public void Transporting()
        {
            System.out.printf("Поехали на %s, окрашенной в %s цвет", getModel(), getColor());
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public Integer getPower() {
            return power;
        }

        public void setPower(Integer power) {
            this.power = power;
        }

        public AnyDimensions getDimensions() {
            return dimensions;
        }

        public void setDimensions(Integer width, Integer height, Integer length) {
            this.dimensions = new AnyDimensions(width, height, length);
        }

        public void getDescription()
        {
            System.out.printf("Это класс : %s, модель: %s %n", this.getClass().getName().split("\\$")[1], getModel());
            System.out.printf("Мощность = %d, цвет = %s%n", getPower(), getColor());
            System.out.println("Габариты :");
            System.out.printf("\tДлина  = %d%n", dimensions.length);
            System.out.printf("\tВысота = %d%n", dimensions.height);
            System.out.printf("\tШирина = %d%n%n", dimensions.width);
        }
    }


    public static class LandTransport extends Transport
    {
        Integer numberOfDoors;

        public Integer getNumberOfDoors() {
            return numberOfDoors;
        }

        public void setNumberOfDoors(Integer numberOfDoors) {
            this.numberOfDoors = numberOfDoors;
        }

        @Override
        public void getDescription()
        {
            System.out.printf("Это класс : %s, модель: %s %n", "'Сухопутный транспорт'", getModel());
            System.out.printf("Мощность = %d, цвет = %s%n", getPower(), getColor());
            System.out.println("Габариты :");
            System.out.printf("\tДлина  = %d%n", dimensions.length);
            System.out.printf("\tВысота = %d%n", dimensions.height);
            System.out.printf("\tШирина = %d%n", dimensions.width);
            System.out.printf("Дверей = %d%n%n", getNumberOfDoors());
        }

    }


    public static class SportsCar extends LandTransport
    {
        Float aerodynamicsRating;
        public Float getAerodynamicsRating() {
            return aerodynamicsRating;
        }

        public void setAerodynamicsRating(Float aerodynamicsRating) {
            this.aerodynamicsRating = aerodynamicsRating;
        }

        @Override
        public void getDescription()
        {
            System.out.printf("Это класс : %s, модель: %s %n", "'Спорткар'", getModel());
            System.out.printf("Мощность = %d, цвет = %s%n", getPower(), getColor());
            System.out.println("Габариты :");
            System.out.printf("\tДлина  = %d%n", dimensions.length);
            System.out.printf("\tВысота = %d%n", dimensions.height);
            System.out.printf("\tШирина = %d%n", dimensions.width);
            System.out.printf("Показатель аэродинамики = %f%n%n", getAerodynamicsRating());
        }
    }

    public static class ElectricSportsCar extends  SportsCar
    {
        Integer batteryVolume;
        public Integer getBatteryVolume() {
            return batteryVolume;
        }

        public void setBatteryVolume(Integer batteryVolume) {
            this.batteryVolume = batteryVolume;
        }
        @Override
        public void getDescription()
        {
            System.out.printf("Это класс : %s, модель: %s %n", "'Электроспорткар'", getModel());
            System.out.printf("Мощность = %d, цвет = %s%n", getPower(), getColor());
            System.out.println("Габариты :");
            System.out.printf("\tДлина  = %d%n", dimensions.length);
            System.out.printf("\tВысота = %d%n", dimensions.height);
            System.out.printf("\tШирина = %d%n", dimensions.width);
            System.out.printf("Емкость аккумулятора = %d%n%n", getBatteryVolume());
        }
    }


    public static class SeaTransport extends Transport
    {
        Integer liftingCapacity;

        public Integer getLiftingCapacity() {
            return liftingCapacity;
        }

        public void setLiftingCapacity(Integer liftingCapacity) {
            this.liftingCapacity = liftingCapacity;
        }

        @Override
        public void getDescription()
        {
            System.out.printf("Это класс : %s, модель: %s %n", "'Морской транспорт'", getModel());
            System.out.printf("Мощность = %d, цвет = %s%n", getPower(), getColor());
            System.out.println("Габариты :");
            System.out.printf("\tДлина  = %d%n", dimensions.length);
            System.out.printf("\tВысота = %d%n", dimensions.height);
            System.out.printf("\tШирина = %d%n", dimensions.width);
            System.out.printf("Грузоподъемность = %d%n%n", getLiftingCapacity());
        }
    }


    public static class AirTransport  extends Transport
    {
        Integer liftingCapacity;

        public Integer getLiftingCapacity() {
            return liftingCapacity;
        }

        public void setLiftingCapacity(Integer liftingCapacity) {
            this.liftingCapacity = liftingCapacity;
        }

        @Override
        public void getDescription()
        {
            System.out.printf("Это класс : %s, модель: %s %n", "'Воздушный транспорт'", getModel());
            System.out.printf("Мощность = %d, цвет = %s%n", getPower(), getColor());
            System.out.println("Габариты :");
            System.out.printf("\tДлина  = %d%n", dimensions.length);
            System.out.printf("\tВысота = %d%n", dimensions.height);
            System.out.printf("\tШирина = %d%n", dimensions.width);
            System.out.printf("Грузоподъемность = %d%n%n", getLiftingCapacity());
        }
    }


    public static abstract class Environment
    {
        public void go()
        {
            Transport myTransport = getTransport();
            myTransport.Transporting();
        }

        public abstract Transport getTransport();

    }


    public static class SeaEnvironment extends Environment
    {
        @Override
        public Transport getTransport() {
            Transport trans = new SeaTransport();
            trans.setModel("Princess 59");
            trans.setColor("White");
            trans.setDimensions(3,2,5);
            trans.setPower(1000);
            return  trans;
        }
    }


    public static class LandEnvironment extends Environment
    {
        @Override
        public Transport getTransport() {
            Transport trans = new SportsCar();
            trans.setModel("Lamborghini");
            trans.setColor("Yellow");
            trans.setDimensions(2,1,4);
            trans.setPower(1800);
            return  trans;
        }
    }


    public static class AirEnvironment extends Environment
    {
        @Override
        public Transport getTransport() {
            Transport trans = new AirTransport();
            trans.setModel("AirJet");
            trans.setColor("Silver");
            trans.setDimensions(10,5,10);
            trans.setPower(9000);
            return  trans;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random random = new Random();
        Environment env;
        System.out.println("Где мы сейчас?");
        System.out.println("1 - Море");
        System.out.println("2 - Земля");
        System.out.println("3 - Воздух");
        int N = in.nextInt();
        switch (N){
            case 1 -> {env = new SeaEnvironment();}
            case 2 -> {env = new LandEnvironment();}
            case 3 -> {env = new AirEnvironment();}
            default ->  {env = new LandEnvironment();}
        }
        env.go();

    }
}
