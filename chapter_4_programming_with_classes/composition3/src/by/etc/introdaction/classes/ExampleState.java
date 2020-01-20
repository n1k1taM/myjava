package by.etc.introdaction.classes;

//Создать объект класса Государство, используя классы Область, Район, Город. Методы: вывести на консоль
//столицу, количество областей, площадь, областные центры.
public class ExampleState {
    public static void main(String[] args) {

        //create cities
        City mozir = new City("Мозырь",100_000);
        City gomel = new City("Гомель", 400_000);

        City brest = new City("Брест", 350_000);
        City pinsk = new City("Пинск", 50_000);

        City minsk = new City("Минск", 2_000_000);
        City borisov = new City("Борисов", 50_000);

        //create districts
        District mozirDistrinct = new District(mozir, 15000);
        District gomelDistrinct = new District(gomel, 12000);
        District[] gomelArray = new District[]{mozirDistrinct, gomelDistrinct};

        District brestDistrinct = new District(brest, 13000);
        District pinskDistrinct = new District(pinsk, 14000);
        District[] brestArray = new District[]{brestDistrinct, pinskDistrinct};

        District minskDistrinct = new District(minsk, 15000);
        District borisovDistrinct = new District(borisov, 11000);
        District[] minskArray = new District[]{minskDistrinct, borisovDistrinct};

        //create regions
        Region gomelRegion = new Region(gomel, gomelArray);
        Region brestRegion = new Region(brest, brestArray);
        Region minskRegion = new Region(minsk, minskArray);
        Region[] regions = new Region[]{gomelRegion, brestRegion, minskRegion};

        //create State
        State state = new State("Dream country", minsk, regions);

        //check methods
        state.showCapital();
        state.showNumberOfRegions();
        state.showArea();
        state.showRegions();
        state.showPopulationOfState();
    }
}
