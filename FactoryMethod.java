interface Transport {
    void deliver();
}

class Truck implements Transport {

    @Override
    public void deliver() {
        System.out.println("Truck deliver()");
    }
}

class Ship implements Transport {

    @Override
    public void deliver() {
        System.out.println("Ship deliver()");
    }
}

class TransportFactory {

    public Transport createTransport(String transportType) {
        if (transportType == null) {
            return null;
        }
        //equalsIgnoreCase ignores uppercase or lowercase of input
        if (transportType.equalsIgnoreCase("ROAD")) {
            return new Truck();

        } else if (transportType.equalsIgnoreCase("SEA")) {
            return new Ship();

        }

        return null;
    }
}

public class FactoryMethod {

    public static void main(String[] args) {
        TransportFactory transportFactory = new TransportFactory();

        //creating truck transport via transportFactory and giving it transport type;
        Transport transport1 = transportFactory.createTransport("road");
        transport1.deliver();

        Transport transport2 = transportFactory.createTransport("Sea");
        transport2.deliver();

    }
}