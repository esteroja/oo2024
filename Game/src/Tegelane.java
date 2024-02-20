// abstract klasse ei saa luua
// ei saa teha: new Tegelane();
public abstract class Tegelane {
    int xCoord; // deklareerin muutuja (loon + mälukoht)
    int yCoord;
    char symbol;

    //need väärtused lähevad nii draakoni, orki kui ka mängija sisse. võib eraldi klassidest need ära kustutada
}
