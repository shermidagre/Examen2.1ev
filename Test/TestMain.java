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

            assertEquals('A', Main.calcularLetraDNI("12345670"), "La letra calculada debería ser 'A'");

            assertEquals('G', Main.calcularLetraDNI("12345671"), "La letra calculada debería ser 'G'");

            assertEquals('M', Main.calcularLetraDNI("12345672"), "La letra calculada debería ser 'M'");

            assertEquals('Y', Main.calcularLetraDNI("12345673"), "La letra calculada debería ser 'Y'");

            assertEquals('F', Main.calcularLetraDNI("12345674"), "La letra calculada debería ser 'F'");

            assertEquals('P', Main.calcularLetraDNI("12345675"), "La letra calculada debería ser 'P'");

            assertEquals('D', Main.calcularLetraDNI("12345676"), "La letra calculada debería ser 'D'");

            assertEquals('X', Main.calcularLetraDNI("12345677"), "La letra calculada debería ser 'X'");

            assertEquals('B', Main.calcularLetraDNI("12345678"), "La letra calculada debería ser 'B'");

            assertEquals('N', Main.calcularLetraDNI("12345679"), "La letra calculada debería ser 'N'");

            assertEquals('J', Main.calcularLetraDNI("12345680"), "La letra calculada debería ser 'J'");

            assertEquals('Z', Main.calcularLetraDNI("12345681"), "La letra calculada debería ser 'Z'");

            assertEquals('Q', Main.calcularLetraDNI("12345682"), "La letra calculada debería ser 'Q'");

            assertEquals('S', Main.calcularLetraDNI("12345683"), "La letra calculada debería ser 'S'");

            assertEquals('V', Main.calcularLetraDNI("12345684"), "La letra calculada debería ser 'V'");

            assertEquals('H', Main.calcularLetraDNI("12345685"), "La letra calculada debería ser 'H'");

            assertEquals('L', Main.calcularLetraDNI("12345686"), "La letra calculada debería ser 'L'");

            assertEquals('C', Main.calcularLetraDNI("12345687"), "La letra calculada debería ser 'C'");

            assertEquals('K', Main.calcularLetraDNI("12345688"), "La letra calculada debería ser 'K'");

            assertEquals('E', Main.calcularLetraDNI("12345689"), "La letra calculada debería ser 'E'");

        }

        @Test

        public void testLetraDNIInvalido() {

            // Test para un DNI inválido (no numérico)

            assertThrows(NumberFormatException.class, () -> {

                Main.calcularLetraDNI("abcdefgh");

            }, "Debería lanzar una excepción por formato de número inválido");

        }

        @Test

        public void testDNICaracteresProhibidos() {

            // Test para DNIs que contienen letras prohibidas

            assertFalse(Main.comprobarDNI("0000000", 'I'), "El DNI no debería ser válido porque contiene 'I'");

            assertFalse(Main.comprobarDNI("0000000", 'O'), "El DNI no debería ser válido porque contiene 'O'");

            assertFalse(Main.comprobarDNI("0000000", 'Ñ'), "El DNI no debería ser válido porque contiene 'Ñ'");

            assertFalse(Main.comprobarDNI("0000000", 'U'), "El DNI no debería ser válido porque contiene 'U'");

        }

    }
}

