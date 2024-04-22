package ee.tlu.kodutoo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Harrypotter {
    public String id;
    public String name;
    public ArrayList<String> alternate_names;
    public String species;
    public String gender;
    public String house;
    public String dateOfBirth;
    public int yearOfBirth;
    public boolean wizard;
    public String ancestry;
    public String eyeColour;
    public String hairColour;
    public String patronus;
    public boolean hogwartsStudent;
    public boolean hogwartsStaff;
    public String actor;
    public ArrayList<String> alternate_actors;
    public boolean alive;
    public String image;
}
