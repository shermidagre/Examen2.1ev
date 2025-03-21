
import org.junit.jupiter.params.*;

import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
public class TestLongitud {


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


        @ParameterizedTest

        @CsvSource({

                "00000000, T",

                "12345678, R",

                "12345679, W",

                "12345670, A",

                "12345671, G",

                "12345672, M",

                "12345673, Y",

                "12345674, F",

                "12345675, P",

                "12345676, D",

                "12345677, X",

                "12345680, J",

                "12345681, Z",

                "12345682, Q",

                "12345683, S",

                "12345684, V",

                "12345685, H",

                "12345686, L",

                "12345687, C",

                "12345688, K",

                "12345689, E"

        })

        public void testCalcularLetraDNI(String dni, char letraEsperada) {

            // Test para calcular la letra del DNI

            assertEquals(letraEsperada, Main.calcularLetraDNI(dni), "La letra calculada debería ser '" + letraEsperada + "'");

        }


        @Test

        public void testLetraDNIInvalido() {

            // Test para un DNI inválido (no numérico)

            assertThrows(NumberFormatException.class, () -> {

                Main.calcularLetraDNI("abcdefgh");

            }, "Debería lanzar una excepción por formato de número inválido");

        }

        @ParameterizedTest

        @CsvSource({

                "000000000, T", // Demasiado largo

                "1234567, R",   // Demasiado corto


        })

        public void testDNILongitudIncorrecta(String dni, char letraEsperada) {

            // Test para DNIs con longitud incorrecta

            if (dni.length() != 7) {

                assertFalse(Main.comprobarDNI(dni, letraEsperada), "El DNI no debería ser válido debido a longitud incorrecta");

            } else {

                // Si la longitud es correcta, puedes verificar la letra

                assertTrue(Main.comprobarDNI(dni, letraEsperada), "El DNI debería ser válido con la letra correcta");

            }

        }


        @ParameterizedTest

        @CsvSource({

                "0000000, I",

                "0000000, O",

                "0000000, Ñ",

                "0000000, U"

        })

        public void testDNICaracteresProhibidos(String dni, char letraProhibida) {

            // Test para DNIs que contienen letras prohibidas

            assertFalse(Main.comprobarDNI(dni, letraProhibida), "El DNI no debería ser válido porque contiene '" + letraProhibida + "'");

        }

    }

}