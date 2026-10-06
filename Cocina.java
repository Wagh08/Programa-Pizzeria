public class Cocina {
    
    private int empleados;
    private int hornos;
    private Orden[] ordenesPendientes = new Orden[5];
    private int ordenesRealizadas = 0;

    public Cocina(int empleados, int hornos){
        this.empleados = empleados;
        this.hornos = hornos;
    }

    public boolean preguntarPorOrdenes(){
        for (int i = 0; i < ordenesPendientes.length; i++) {

            if (ordenesPendientes[i] == null) {
                return true;
            }
        }

        return false;
    }

    public void realizarOrden(){
            
            for (int i = 0; i < ordenesPendientes.length; i++){

            if (ordenesPendientes[i] != null){

                Orden orden = ordenesPendientes[i];

                Pizza pizza = new Pizza();

                // PIZZA PREDETERMINADA
                if (orden.getTipo() != null){

                    if (orden.getTipo() == Pizzas.HAWAYANA){

                        pizza.setBase(Bases.MASA_Y_QUESO);
                        pizza.setSalsa(Salsas.SALADA);
                        pizza.setOrilla(Orillas.NORMAL);
                        pizza.ingredientes(20, 0, 0, 0, 40);

                    }
                    else if (orden.getTipo() == Pizzas.PEPPERONI){

                        pizza.setBase(Bases.MASA_Y_QUESO);
                        pizza.setSalsa(Salsas.SALADA);
                        pizza.setOrilla(Orillas.NORMAL);
                        pizza.ingredientes(0, 40, 0, 0, 0);

                    }
                    else if (orden.getTipo() == Pizzas.JAMON){

                        pizza.setBase(Bases.MASA_Y_QUESO);
                        pizza.setSalsa(Salsas.SALADA);
                        pizza.setOrilla(Orillas.NORMAL);
                        pizza.ingredientes(40, 0, 0, 0, 0);

                    }
                    else if (orden.getTipo() == Pizzas.DELUXE){

                        pizza.setBase(Bases.MASA_Y_QUESO);
                        pizza.setSalsa(Salsas.SALADA);
                        pizza.setOrilla(Orillas.NORMAL);
                        pizza.ingredientes(20, 20, 20, 20, 0);
                    }
                }

                // PIZZA PERSONALIZADA
                else {

                    pizza.setBase(orden.getBase());
                    pizza.setSalsa(orden.getSalsa());
                    pizza.setOrilla(orden.getOrilla());

                    pizza.ingredientes(
                        orden.getJamon(),
                        orden.getPepperoni(),
                        orden.getPimientos(),
                        orden.getChampiñones(),
                        orden.getPiña()
                    );
                }

                ordenesRealizadas += 1;
                return;
            }
        }

        System.out.println("No hay órdenes pendientes.");
    }

    public void entregarOrden(){
        for (int i = 0; i < ordenesPendientes.length; i++){

            if (ordenesPendientes[i] != null){

                Orden orden = ordenesPendientes[i];

                System.out.println("Pizza entregada.");

                if (orden.getTipo() != null){

                    System.out.println("Pizza: " + orden.getTipo());

                } else {

                    System.out.println("Base: " + orden.getBase());
                    System.out.println("Salsa: " + orden.getSalsa());
                    System.out.println("Orilla: " + orden.getOrilla());
                    System.out.println("Jamón: " + orden.getJamon());
                    System.out.println("Pepperoni: " + orden.getPepperoni());
                    System.out.println("Pimientos: " + orden.getPimientos());
                    System.out.println("Champiñones: " + orden.getChampiñones());
                    System.out.println("Piña: " + orden.getPiña());
                }

                ordenesPendientes[i] = null;

                return;
            }
        }
    }
    

    public void setEmpleados(int empleados){
        this.empleados = empleados;
    }

    public void setHornos(int hornos){
        this.hornos = hornos;
    }

    public void agregarOrden(Orden orden){

        for (int i = 0; i < ordenesPendientes.length; i++){

            if (ordenesPendientes[i] == null){
                ordenesPendientes[i] = orden;
                return;
            }
        }
    }

}
