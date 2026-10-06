public class Pizza{

    private Pizzas tipo;
    private String tamaño;
    private Bases base;
    private Salsas salsa;
    private int cantJamon;
    private int cantPepperoni;
    private int cantPimientos;
    private int cantChampiñones;
    private int cantPiña;
    private Orillas orilla;

    public Pizza(){};

    public Pizza(Pizzas tipo, String tamaño){
        this.tipo = tipo;
        this.tamaño = tamaño;
    }

    public void setBase(Bases base){
        this.base = base;
    }

    public void setSalsa(Salsas salsa){
        this.salsa = salsa;
    }

    public void ingredientes(int cantJamon, int cantPepperoni, int cantPimientos, int cantChampiñones, int cantPiña){
        this.cantJamon = cantJamon;
        this.cantPepperoni = cantPepperoni;
        this.cantPimientos = cantPimientos;
        this.cantChampiñones = cantChampiñones;
        this.cantPiña = cantPiña;
    }

    public void ingredientes(int cantPiña){
        this.cantPiña = cantPiña;
    }

    public void setOrilla(Orillas orilla){
        this.orilla = orilla;
    }
}