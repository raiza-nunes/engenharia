public  class ContaBancaria {

    private double saldo;

    public ContaBancaria() {
        this.saldo = 0.0;
    }

    public double consultarSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor do depósito deve ser positivo.");
        }
        saldo += valor;
    }

    public void sacar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor do saque deve ser positivo.");
        }

        if (valor > saldo) {
            throw new IllegalArgumentException("Saldo insuficiente.");
        }

        saldo -= valor;
    }
}