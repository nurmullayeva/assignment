enum HouseType {
    ROOMS_2, ROOMS_3, ROOMS_4;
}

enum RoofType {
    CHEAP, MEDIUM, EXPERNSIVE;
}

enum GarageType {
    SMALL, MEDIUM, LARGE;
}

class House {
    private HouseType type;
    private int doors;
    private int windows;
    private RoofType rType;
    private GarageType gType;

    public House(HouseType type, int doors, int windows, RoofType rType, GarageType gType) {
        this.type = type;
        this.doors = doors;
        this.windows = windows;
        this.rType = rType;
        this.gType = gType;
    }

    public HouseType getType() {
        return this.type;
    }

    public void setType(HouseType type) {
        this.type = type;
    }

    public int getDoors() {
        return this.doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    public int getWindows() {
        return this.windows;
    }

    public void setWindows(int windows) {
        this.windows = windows;
    }

    public RoofType getRType() {
        return this.rType;
    }

    public void setRType(RoofType rType) {
        this.rType = rType;
    }

    public GarageType getGType() {
        return this.gType;
    }

    public void setGType(GarageType gType) {
        this.gType = gType;
    }

}

interface Builder {
    void buildWalls(HouseType houseType);

    void buildDoors(int doors);

    void buildWindows(int windows);

    void buildRoof(RoofType roofType);

    void buildGarage(GarageType garageType);
}

class HouseBuilder implements Builder {
    private HouseType type;
    private int doors;
    private int windows;
    private RoofType rType;
    private GarageType gType;

    public House getResult() {
        return new House(type, doors, windows, rType, gType);
    }

    @Override
    public void buildWalls(HouseType houseType) {
        this.type = houseType;

    }

    @Override
    public void buildDoors(int doors) {
        this.doors = doors;

    }

    @Override
    public void buildWindows(int windows) {
        this.windows = windows;

    }

    @Override
    public void buildRoof(RoofType roofType) {
        this.rType = roofType;

    }

    @Override
    public void buildGarage(GarageType garageType) {
        this.gType = garageType;

    }
}

class HouseManualBuilder implements Builder {
    private HouseType type;
    private int doors;
    private int windows;
    private RoofType rType;
    private GarageType gType;

    @Override
    public void buildWalls(HouseType houseType) {
        this.type = houseType;

    }

    @Override
    public void buildDoors(int doors) {
        this.doors = doors;

    }

    @Override
    public void buildWindows(int windows) {
        this.windows = windows;

    }

    @Override
    public void buildRoof(RoofType roofType) {
        this.rType = roofType;

    }

    @Override
    public void buildGarage(GarageType garageType) {
        this.gType = garageType;

    }

    public Manual getResult() {
        return new Manual(type, doors, windows, rType, gType);
    }
}

class Manual {
    private HouseType type;
    private int doors;
    private int windows;
    private RoofType rType;
    private GarageType gType;

    public Manual(HouseType type, int doors, int windows, RoofType rType, GarageType gType) {
        this.type = type;
        this.doors = doors;
        this.windows = windows;
        this.rType = rType;
        this.gType = gType;
    }

    public String print() {
        String info = "";
        info += "Rooms: " + type + "\n";
        info += "Count of doors: " + doors + "\n";
        info += "Count of windows: " + windows + "\n";
        info += "Roof type: " + rType + "\n";
        if (this.gType != null) {
            info += "Garage type: " + gType + "\n";
        } else {
            info += "No Garage" + "\n";
        }
        return info;
    }
}

class Director {

    public void constructSimpleHouse(Builder builder) {
        builder.buildWalls(HouseType.ROOMS_2);
        builder.buildWindows(4);
        builder.buildDoors(3);
        builder.buildRoof(RoofType.MEDIUM);
    }

    public void constructRichHouse(Builder builder) {
        builder.buildWalls(HouseType.ROOMS_4);
        builder.buildWindows(7);
        builder.buildDoors(5);
        builder.buildRoof(RoofType.EXPERNSIVE);
        builder.buildGarage(GarageType.LARGE);
    }
}

public class HouseBuilderTest {
    public static void main(String[] args) {
        Director director = new Director();

        // Директор получает объект конкретного строителя от клиента
        // (приложения). Приложение само знает какой строитель использовать,
        // чтобы получить нужный продукт.
        HouseBuilder builder = new HouseBuilder();
        director.constructSimpleHouse(builder);
        // Готовый продукт возвращает строитель, так как Директор чаще всего не
        // знает и не зависит от конкретных классов строителей и продуктов.
        House house = builder.getResult();
        System.out.println("House built:\n" + house.getType());

        HouseManualBuilder manualBuilder = new HouseManualBuilder();

        // Директор может знать больше одного рецепта строительства.
        director.constructSimpleHouse(manualBuilder);
        Manual houseManual1 = manualBuilder.getResult();
        System.out.println("\nHouse manual built:\n" + houseManual1.print());


        HouseBuilder builder2 = new HouseBuilder();
        director.constructRichHouse(builder2);

        House house2 = builder2.getResult();
        System.out.println("\nHouse built:\n" + house2.getType());

        director.constructRichHouse(manualBuilder);
        Manual houseManual2 = manualBuilder.getResult();
        System.out.println("\nHouse manual built:\n" + houseManual2.print());
    }
}
