public class Cliente {
    private final String nombre;
    private final int edad;

    public Cliente(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }

    public Orden hacerPedido(Pizzas tipo, Cocina cocina) {
        Orden orden = new Orden(this, cocina, tipo);
        return orden.validarOrden() ? orden : null;
    }

    public Orden hacerPedido(Bases base, Salsas salsa, Orillas orilla,
            int jamon, int pepperoni, int pimientos, int champiñones, int piña, Cocina cocina) {
        Orden orden = new Orden(this, cocina, base, salsa, orilla,
                jamon, pepperoni, pimientos, champiñones, piña);
        return orden.validarOrden() ? orden : null;
    }
}
