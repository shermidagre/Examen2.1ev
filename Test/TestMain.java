import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;



public class TestMain {

    @Nested
    class MainTest {

        @Test

        public void testDNIValido() {

            // Test con un DNI válido

            assertTrue(Main.comprobarDNI("00000000", 'T'), "El DNI debería ser correcto");

        }


        @Test

        public void testDNInvalido() {

            // Test con un DNI válido pero letra incorrecta

            assertFalse(Main.comprobarDNI("00000000", 'R'), "El DNI debería ser incorrecto");

        }


        @Test

        public void testCalcularLetraDNI() {

            // Test para calcular la letra del DNI

            assertEquals('T', Main.calcularLetraDNI("00000000"), "La letra calculada debería ser 'T'");

            assertEquals('R', Main.calcularLetraDNI("12345678"), "La letra calculada debería ser 'R'");

            assertEquals('W', Main.calcularLetraDNI("12345679"), "La letra calculada debería ser 'W'");

        }


        @Test

        public void testLetraDNIInvalido() {

            // Test para un DNI inválido (no numérico)

            assertThrows(NumberFormatException.class, () -> {

                Main.calcularLetraDNI("abcdefgh");

            }, "Debería lanzar una excepción por formato de número inválido");

        }

    }
}

