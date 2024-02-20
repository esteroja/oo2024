public class Animal {

    String animalName;
    boolean estonianAnimal;

    public Animal(String animalName, boolean estonianAnimal) {
        this.animalName = animalName;
        this.estonianAnimal = estonianAnimal;
    }

    public void animalType(String animalName) {
        if (animalName.equals("ilves") || animalName.equals("hunt") || animalName.equals("gepard")) {
            System.out.println("metsloom");
        } else if (animalName.equals("koer") || animalName.equals("kass") || animalName.equals("hamster")) {
            System.out.println("koduloom");
        } else {
            System.out.println("info puudub");
        }
    }

    public void animalLoc() {
        if (estonianAnimal) {
            System.out.println("Eestis elav loom");
        } else {
            System.out.println("Loom ei ela Eestis");
        }
    }
}
