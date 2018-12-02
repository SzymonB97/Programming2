package core.multithreading.runnableTraining;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.PrintStream;

public class HanselAndGretelTest {

    @Test
    void shouldDoTasks() throws InterruptedException {
        //ustawiamy naszego mock'a jako symulację klasy PrintStream
        PrintStream mock = Mockito.mock(PrintStream.class);

        //ustawiamy metodę wywołania teksu na naszego mock'a
        System.setOut(mock);

        //uruchamiamy main naszej klasy
        HanselAndGretel.main(null);

        //sprawdzamy czy nasz mock wypisał dany tekst
        Mockito.verify(mock).println("Jaś skończył się ubierać");
    }

}
