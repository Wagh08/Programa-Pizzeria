import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Cocina cocina = new Cocina(5, 2);

        System.out.print("Ingrese su nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese su edad: ");
        int edad = scanner.nextInt();

        Cliente cliente = new Cliente(nombre, edad);

        int opcion = 0;

        while (opcion != 3) {

            System.out.println("\n===== PIZZERIA =====");
            System.out.println("1. Hacer pedido");
            System.out.println("2. Recibir una orden");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opcion: ");

            opcion = scanner.nextInt();

            switch (opcion) {

                case 1:

                    System.out.println("\n===== TIPO DE PIZZA =====");
                    System.out.println("1. Pepperoni");
                    System.out.println("2. Hawayana");
                    System.out.println("3. Jamon");
                    System.out.println("4. Deluxe");
                    System.out.println("5. Personalizada");
                    System.out.print("Seleccione una opcion: ");

                    int tipoPizza = scanner.nextInt();

                    switch (tipoPizza) {

                        case 1:
                            cliente.hacerPedido(Pizzas.PEPPERONI, cocina);
                            break;

                        case 2:
                            cliente.hacerPedido(Pizzas.HAWAYANA, cocina);
                            break;

                        case 3:
                            cliente.hacerPedido(Pizzas.JAMON, cocina);
                            break;

                        case 4:
                            cliente.hacerPedido(Pizzas.DELUXE, cocina);
                            break;

                        case 5:

                            System.out.println("\n===== BASE =====");
                            System.out.println("1. Masa");
                            System.out.println("2. Queso");
                            System.out.println("3. Masa y queso");
                            System.out.print("Seleccione una opcion: ");

                            int opcionBase = scanner.nextInt();
                            Bases base;

                            switch (opcionBase) {

                                case 1:
                                    base = Bases.MASA;
                                    break;

                                case 2:
                                    base = Bases.QUESO;
                                    break;

                                case 3:
                                    base = Bases.MASA_Y_QUESO;
                                    break;

                                default:
                                    System.out.println("Base no valida.");
                                    continue;
                            }

                            System.out.println("\n===== SALSA =====");
                            System.out.println("1. Dulce");
                            System.out.println("2. Salada");
                            System.out.println("3. Picante");
                            System.out.print("Seleccione una opcion: ");

                            int opcionSalsa = scanner.nextInt();
                            Salsas salsa;

                            switch (opcionSalsa) {

                                case 1:
                                    salsa = Salsas.DULCE;
                                    break;

                                case 2:
                                    salsa = Salsas.SALADA;
                                    break;

                                case 3:
                                    salsa = Salsas.PICANTE;
                                    break;

                                default:
                                    System.out.println("Salsa no valida.");
                                    continue;
                            }

                            System.out.println("\n===== ORILLA =====");
                            System.out.println("1. Normal");
                            System.out.println("2. Rellena de queso");
                            System.out.print("Seleccione una opcion: ");

                            int opcionOrilla = scanner.nextInt();
                            Orillas orilla;

                            switch (opcionOrilla) {

                                case 1:
                                    orilla = Orillas.NORMAL;
                                    break;

                                case 2:
                                    orilla = Orillas.RELLENA_QUESO;
                                    break;

                                default:
                                    System.out.println("Orilla no valida.");
                                    continue;
                            }

                            System.out.print("Cantidad de jamon: ");
                            int jamon = scanner.nextInt();

                            System.out.print("Cantidad de pepperoni: ");
                            int pepperoni = scanner.nextInt();

                            System.out.print("Cantidad de pimientos: ");
                            int pimientos = scanner.nextInt();

                            System.out.print("Cantidad de champiñones: ");
                            int champiñones = scanner.nextInt();

                            System.out.print("Cantidad de piña: ");
                            int piña = scanner.nextInt();

                            cliente.hacerPedido(
                                base,
                                salsa,
                                orilla,
                                jamon,
                                pepperoni,
                                pimientos,
                                champiñones,
                                piña,
                                cocina
                            );

                            break;

                        default:
                            System.out.println("Tipo de pizza no valido.");
                            break;
                    }

                    break;

                case 2:

                    cocina.realizarOrden();
                    cocina.entregarOrden();

                    break;

                case 3:

                    System.out.println("Gracias por su visita.");

                    break;

                default:

                    System.out.println("Opcion no valida.");

                    break;
            }
        }

        scanner.close();
    }
}