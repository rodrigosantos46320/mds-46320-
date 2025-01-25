package com.beingsecured.maventest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {
    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    public void setUp() {
        // Redireciona a saída para ficar com o valor á saída da consola
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    public void tearDown() {
        // Restaura a entrada e saída originais
        System.setIn(originalIn);
        System.setOut(originalOut);
    }

    @Test
    public void testManageRoomsCreate() {
        String input = "1\n1\n4\n"; // Simula a entrada do utilizador a criar quarto e depois sai
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Main.main(new String[0]);

        String output = outputStream.toString();
        assertTrue(output.contains("Criar quarto"));
    }

    @Test
    public void testManageRoomsWrongNumber() {
        String input = "1\n5\n4\n"; // Simula a entrada do utilizador a criar quarto e depois sai
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Main.main(new String[0]);

        String output = outputStream.toString();
        assertTrue(output.contains("Opção inválida."));
    }

    @Test
    public void testManageRoomsInputMismatch() {
        String input = "1\na\n4\n"; // Simula a entrada do utilizador a criar quarto e depois sai
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Main.main(new String[0]);

        String output = outputStream.toString();
        assertTrue(output.contains("Escolha um número que corresponda à opção."));
    }

    @Test
    public void testManageRoomsEdit() {
        String input = "1\n2\n4\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Main.main(new String[0]);

        String output = outputStream.toString();
        assertTrue(output.contains("Editar quarto"));
    }

    @Test
    public void testManageRoomsRemove() {
        String input = "1\n3\n4\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Main.main(new String[0]);

        String output = outputStream.toString();
        assertTrue(output.contains("Remover quarto"));
    }

    @Test
    public void testManageMaintenanceRegister() {
        String input = "2\n1\n4\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Main.main(new String[0]);

        String output = outputStream.toString();
        assertTrue(output.contains("Registar manutenção"));
    }

    @Test
    public void testManageMaintenanceCheck() {
        String input = "2\n2\n4\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Main.main(new String[0]);

        String output = outputStream.toString();
        assertTrue(output.contains("Verificar manutenção"));
    }

    @Test
    public void testReservation() {
        String input = "2\n3\n4\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Main.main(new String[0]);

        String output = outputStream.toString();
        assertTrue(output.contains("Reservar"));
    }

    @Test
    public void testInvalidOption() {
        String input = "5\n4\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Main.main(new String[0]);

        String output = outputStream.toString();
        assertTrue(output.contains("Opção inválida."));
    }

    @Test
    public void testExitOption() {
        String input = "4\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Main.main(new String[0]);

        String output = outputStream.toString();
        assertTrue(output.contains("Sair"));
    }
}