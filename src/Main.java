import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Reserva reserva1 = new Reserva(1, "Tadeu", LocalDate.now(), LocalDate.now().plusDays(2), "101");
        Reserva reserva2 = new Reserva(2, "Marta", LocalDate.now().plusDays(7), LocalDate.now().plusDays(5),  "202");
        Reserva reserva3 = new Reserva(3, "Cathy", LocalDate.now().plusDays(5), LocalDate.now().plusDays(8), "303");

        GerenciadorReservas gerenciador = new GerenciadorReservas();

        try {
            gerenciador.adicionar(reserva1);
            gerenciador.adicionar(reserva2);
            gerenciador.adicionar(reserva3);
        } catch (ReservaConflitanteException e) {
            throw new RuntimeException(e);
        }

        try {
            gerenciador.adicionar(new Reserva(4, "Jonas", LocalDate.now().plusDays(4), LocalDate.now().plusDays(6), "303"));
        } catch (ReservaConflitanteException e) {
            System.out.println(e.getMessage());

        } catch (Exception e) {
            System.out.println("Erro inesperado: " + e.getMessage());
        }

        Reserva busca1 = gerenciador.buscar(1);
        Reserva busca2 = gerenciador.buscar(2);
        Reserva busca3 = gerenciador.buscar(3);

        System.out.println("Reservas encontradas");
        System.out.println("Busca 1: " + busca1);
        System.out.println("Busca 2: " + busca2);
        System.out.println("Busca 3: " + busca3);
    }



}