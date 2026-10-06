public class Orden{

    private int id;
    private Cliente cliente;
    private Cocina cocina;
    private Pizzas tipo;
    private Bases base;
    private Salsas salsa;
    private Orillas orilla;
    private int jamon;
    private int pepperoni;
    private int pimientos;
    private int champiñones;
    private int piña;
    private static int contador = 1;

    public Orden(Cliente cliente, Cocina cocina, Pizzas tipo){
        this.id = contador;
        contador++;
        this.cliente = cliente;
        this.cocina = cocina;
        this.tipo = tipo;
    }

    public Orden(Cliente cliente, Cocina cocina, Bases base, Salsas salsa, Orillas orilla, int jamon, int pepperoni, int pimientos, int champiñones, int piña){
        this.id = contador;
        contador++;
        this.cliente = cliente;
        this.cocina = cocina;

        this.base = base;
        this.salsa = salsa;
        this.orilla = orilla;

        this.jamon = jamon;
        this.pepperoni = pepperoni;
        this.pimientos = pimientos;
        this.champiñones = champiñones;
        this.piña = piña;
    }

    public void validarOrden(){
        if (cocina.preguntarPorOrdenes()) {
            cocina.agregarOrden(this);
            System.out.println("Orden aceptada");
        } else {
            rechazarOrden();
        }
    }

    public void rechazarOrden(){
        System.out.println("Orden rechazada. La cocina está llena.");
    }

    public Pizzas getTipo(){
        return tipo;
    }

    public Bases getBase(){
        return base;
    }

    public Salsas getSalsa(){
        return salsa;
    }

    public Orillas getOrilla(){
        return orilla;
    }

    public int getJamon(){
        return jamon;
    }

    public int getPepperoni(){
        return pepperoni;
    }

    public int getPimientos(){
        return pimientos;
    }

    public int getChampiñones(){
        return champiñones;
    }

    public int getPiña(){
        return piña;
    }
}