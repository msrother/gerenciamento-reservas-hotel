import java.time.LocalDate;

public class Reserva {
    private int codigo;
    private String cliente;
    private LocalDate dataEntrada;
    private LocalDate dataSaida;
    private String quarto;

    public Reserva(int codigo, String cliente, LocalDate dataEntrada, LocalDate dataSaida, String quarto) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.quarto = quarto;
    }

    public int diasReservados() {
        return (int) dataEntrada.until(dataSaida, java.time.temporal.ChronoUnit.DAYS);
    }

    @Override
    public String toString() {
        return "Reserva |codigo = " + codigo + ", cliente = " + cliente + ", dataEntrada = " + dataEntrada +
                ", dataSaida = " + dataSaida + ", quarto = " + quarto + "|";
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public LocalDate getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(LocalDate dataSaida) {
        this.dataSaida = dataSaida;
    }

    public String getQuarto() {
        return quarto;
    }

    public void setQuarto(String quarto) {
        this.quarto = quarto;
    }
}
