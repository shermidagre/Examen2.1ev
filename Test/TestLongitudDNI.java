import org.junit.jupiter.api.Test;


public class TestLongitudDNI {
    @Test
    public void testLongitudDNIsinLetras() {


        String dni = "1234567890";
        assert dni.length() == 8 : "Longitud correcta de DNI";

        String dniInvalido = "123456789";
        assert dniInvalido.length() != 8 : "Longitud incorrecta de DNI";

    }
    public void testLongitudDniconLetras(){
        testLongitudDNIsinLetras();
        String dni = "12345678X";
        assert dni.length() == 9 : "Longitud correcta de DNI con letra";

        String dniInvalido = "12345678";
        assert dniInvalido.length() != 9 : "Longitud incorrecta de DNI con letra";

    }
}
