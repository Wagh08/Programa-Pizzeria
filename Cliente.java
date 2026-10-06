public class Cliente {
    
    private String nombre;
    private int edad;

    public Cliente(String nombre, int edad){
        this.nombre = nombre;
        this.edad = edad;
    }

    public void hacerPedido(Pizzas tipo, Cocina cocina){
        Orden orden = new Orden(this, cocina, tipo);

        orden.validarOrden();
    }

    public void hacerPedido(Bases base, Salsas salsa, Orillas orilla, int jamon, int pepperoni, int pimientos, int champiñones, int piña, Cocina cocina){
        Orden orden = new Orden(this, cocina, base, salsa, orilla, jamon, pepperoni, pimientos, champiñones, piña);

        orden.validarOrden();
    }

}
