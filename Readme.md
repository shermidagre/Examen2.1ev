# Texto de el examen

## Examen de Test Unitarios

### Enunciado


Con el código de este repositorio realiza lo siguiente:


1. **Test Unitarios (4 puntos)**

   Implementa los test unitarios de los dos métodos, utilizando test parametrizados. Suponiendo que la cadena `DNI` siempre es un DNI válido.


2. **Identificación de Errores (2 puntos)**

   En el código, hay un error. ¿Pudiste comprobarlo en los test? Plantea la solución.


3. **Comprobación de Longitud de DNI (3 puntos)**

   Si no hubiera una comprobación previa en cuanto a la longitud de la cadena del DNI, ¿qué hay que cambiar en los tests para que comprueben estos casos?


### Entrega


Entrega tu repositorio con el código y los test. Además, incluye un README explicando y justificando cada apartado.


### Formato del README (1 punto)

# Comienzo del examen

## 1. Test Unitarios


Para los test unitarios, decidí primero pensar en cómo distribuirlos y de qué manera. En principio, consideré que solo había dos métodos, por lo cual debía hacer dos tests. Sin embargo, al final opté por realizar cuatro tests sencillos e intuitivos, que le pedí a una IA que me ayudara a generar para así conseguir una mayor eficiencia en ellos. Los tests en cuestión son los siguientes:


### Test de DNI Válido


public void testDNIValido() {

    // Test con un DNI válido

    assertTrue(Main.comprobarDNI("00000000", 'T'), "El DNI debería ser correcto");

}


### Test de DNI Inválido


@Test

public void testDNInvalido() {

    // Test con un DNI válido pero letra incorrecta

    assertFalse(Main.comprobarDNI("00000000", 'R'), "El DNI debería ser incorrecto");

}


### Test para Calcular la Letra del DNI


@Test

public void testCalcularLetraDNI() {

    // Test para calcular la letra del DNI

    assertEquals('T', Main.calcularLetraDNI("00000000"), "La letra calculada debería ser 'T'");

    assertEquals('R', Main.calcularLetraDNI("12345678"), "La letra calculada debería ser 'R'");

    assertEquals('W', Main.calcularLetraDNI("12345679"), "La letra calculada debería ser 'W'");

}


### Test para Letra de DNI Inválido


@Test

public void testLetraDNIInvalido() {

    // Test para un DNI inválido (no numérico)

    assertThrows(NumberFormatException.class, () -> {

        Main.calcularLetraDNI("abcdefgh");

    }, "Debería lanzar una excepción por formato de número inválido");

}


Gracias a estos tests, decidí ejecutar los dos más importantes para este apartado, que eran el test de DNI válido (aclarando que siempre será válido, por lo cual solo debe hacerse con una opción) y quise agregar un poco de complejidad al de la comprobación de letra, ya que sospechaba que ahí podría estar el fallo. Efectivamente, el test dio error.


## 2. Identificación de Errores


Como mencioné, el test que falla es el de comprobación de la letra, ya que no se realiza correctamente la misma.


![Detección de errores](testfallido.png)