import driver.DriverB;
import driver.DriverC;
import transport.*;

public class Main {
    public static void main(String[] args) {
        Car lada = new Car("Lada", "Vesta", 2.0, TypeOfBody.UNIVERSAL);
        Car kia = new Car("KIA", "Cerato", 2.5, TypeOfBody.SEDAN);
        Car skoda = new Car("Skoda", "Octavia", 3.0, TypeOfBody.SEDAN);
        Car audi = new Car("Audi", "A3", 3.0, TypeOfBody.SEDAN);
        lada.printCar();
        kia.printCar();
        skoda.printCar();
        audi.printCar();


        Bus man = new Bus("MAN", "Lion’s Coach", 5.0, PassengerCapacity.AVERAGE);
        Bus gaz = new Bus("GAZ", "Вектор Next", 3.3,PassengerCapacity.BIG);
        Bus maz = new Bus("MAZ", "232", 3.5, PassengerCapacity.ESPECIALLY_SMALL);
        Bus setra = new Bus("Setra", "Provate", 3.8, PassengerCapacity.ESPECIALLY_BIG);
        man.printBus();
        gaz.printBus();
        maz.printBus();
        setra.printBus();


        Truck iveco = new Truck("Iveco", "MP 260E38 6x6", 12.0, CarriageCapacity.N3);
        Truck mon = new Truck("MON", "41.410 8x4", 10.0, CarriageCapacity.N2);
        Truck volvo = new Truck("VOLVO", "FMX-500-10X4", 13.0, CarriageCapacity.N1);
        Truck mercedes = new Truck("Mercedes-Benz", "Atego 815", 4.2, CarriageCapacity.N2);
        iveco.printTruck();
        mon.printTruck();
        volvo.printTruck();
        mercedes.printTruck();
        mercedes.printType();



        DriverB driverB = new DriverB("Иванов Ивано Иванович", "B", 5, kia);
        System.out.println(driverB);
        kia.printType();
        DriverC driverC = new DriverC("Моисеев Владимир Николаевич", "C", 10, mon);
        System.out.println(driverC);
        mon.printType();

        service(lada,kia,skoda,audi,
                man, gaz, maz, setra,
                iveco, volvo, mon, mercedes);


    }

    private static void service(Transport...transports) {
        for (Transport transport : transports) {
               serviceTransport(transport);
        }
    }

    private static void serviceTransport(Transport transport) {
        try {
            if (!transport.service()) {
                throw new RuntimeException("Автомобиль " +
                        transport.getBrand() + " " + transport.getModel() + " не прошел диагностику");
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());

        }
    }




}