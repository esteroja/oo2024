public class Main {
    public static void main(String[] args) {

        Animal animal = new Animal("gepard", false);
        Animal animal2 = new Animal("koer", true);
        Animal animal3 = new Animal("rebane", true);

        animal.animalType(animal.animalName);
        animal2.animalType(animal2.animalName);
        animal3.animalType(animal3.animalName);
        
        animal.animalLoc();
        animal2.animalLoc();

        Calculation calculation = new Calculation("auto", 43, "+");
        Calculation calculation2 = new Calculation("kan", 15, "-");

        String getNewWord = calculation.newWord('d');
        System.out.println(getNewWord);
        String getNewWord2 = calculation2.newWord('a');
        System.out.println(getNewWord2);

        int newNumber = calculation.calc(5);
        System.out.println(newNumber);
        int newNumber2 = calculation2.calc(4);
        System.out.println(newNumber2);


    }
}
