import java.util.ArrayList;
import java.util.List;

public class GerenciadorReservas implements Repositorio<Reserva>{
    private List<Reserva> reservas;

    public GerenciadorReservas() {
        this.reservas = new ArrayList<>();
    }

    @Override
    public void adicionar(Reserva reserva) throws ReservaConflitanteException {
        for (Reserva r : reservas) {
            if (conflitoReservas(reserva, r)) {
                throw new ReservaConflitanteException("Reserva conflitante.");

            }
        }
        reservas.add(reserva);
    }

    @Override
    public void remover(Reserva reserva) {
        reservas.remove(reserva);
    }

    @Override
    public <R> Reserva buscar(R codigo) {
        for (Reserva reserva : reservas) {
            if (reserva.getCodigo() == (int) codigo) {
                return reserva;
            }
        }
        return null;
    }

    private boolean conflitoReservas(Reserva novaReserva, Reserva reservaExistente) {
        return novaReserva.getDataEntrada().isBefore(reservaExistente.getDataSaida())
                && novaReserva.getDataSaida().isAfter(reservaExistente.getDataEntrada());
    }

}
