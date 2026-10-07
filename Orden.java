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

    public boolean validarOrden(){
        if (cocina.preguntarPorOrdenes()) {
            cocina.agregarOrden(this);
            return true;
        } else {
            return false;
        }
    }

    public void rechazarOrden(){
        System.out.println("Orden rechazada. La cocina está llena.");
    }

    public int getId(){ return id; }
    public Cliente getCliente(){ return cliente; }

    public String descripcion(){
        String encabezado = "Orden #" + id + "\nCliente: " + cliente.getNombre() + "\n";
        if (tipo != null) return encabezado + "Pizza: " + tipo + "\nBase: MASA_Y_QUESO\nSalsa: SALADA\nOrilla: NORMAL\n" +
            (tipo == Pizzas.HAWAYANA ? "Jamón: 20\nPiña: 40" :
             tipo == Pizzas.PEPPERONI ? "Pepperoni: 40" :
             tipo == Pizzas.JAMON ? "Jamón: 40" : "Jamón: 20\nPepperoni: 20\nPimientos: 20\nChampiñones: 20");
        return encabezado + "Pizza personalizada\nBase: " + base + "\nSalsa: " + salsa +
            "\nOrilla: " + orilla + "\nJamón: " + jamon + "\nPepperoni: " + pepperoni +
            "\nPimientos: " + pimientos + "\nChampiñones: " + champiñones + "\nPiña: " + piña;
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