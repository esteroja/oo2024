public class Main {
    public static void main(String[] args) {

        String partOfDay = getPartOfDay(1);
        System.out.println(partOfDay);
        String partOfDay2 = getPartOfDay(10);
        System.out.println(partOfDay2);
        String partOfDay3 = getPartOfDay(14);
        System.out.println(partOfDay3);
        String partOfDay4 = getPartOfDay(23);
        System.out.println(partOfDay4);
        String partOfDay5 = getPartOfDay(26);
        System.out.println(partOfDay5);
        String partOfDay6 = getPartOfDay(-5);
        System.out.println(partOfDay6);

        double fahrenheit = getFahrenheit(0);
        System.out.println(fahrenheit);
        double fahrenheit2 = getFahrenheit(-6);
        System.out.println(fahrenheit2);
        double fahrenheit3 = getFahrenheit(23);
        System.out.println(fahrenheit3);

        getFirstLetter("Kana");
        getFirstLetter("Muna");
    }
    private static String getPartOfDay(int time) {
        if (time >= 0 && time < 6) {
            return "Öö";
        } if (time >= 6 && time < 11) {
            return "Hommik";
        } if (time >= 11 && time < 17) {
            return "Päev";
        } if (time >= 17 && time < 24) {
            return "Õhtu";
        } else {
            return "Pole kellaaeg";
        }
    }

    private static double getFahrenheit(int celsius) {
        return celsius * 1.8 + 32;
    }

    private static void getFirstLetter(String word) {
        char first = word.charAt(0);
        System.out.println(first);
    }
}