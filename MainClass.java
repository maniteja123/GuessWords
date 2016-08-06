public class MainClass {
    public static void main(String []args) {
        String charInTest = "ACMO";
        Dictionary d = new Dictionary("");
        System.out.println (d.getNumberOfCharacters(charInTest));
        System.out.println (d.areAllCharactersUnique(charInTest));
        System.out.println (d.getNumberOfCharactersInCommon(charInTest, "XMLO"));
    }
}
