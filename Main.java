import javax.swing.*;
import java.awt.*;

public class Main {
    private final Cocina cocina = new Cocina(5, 2);
    private final JFrame ventana = new JFrame("Pizzería - Hacer pedido");
    private final JTextField nombre = new JTextField(16);
    private final JSpinner edad = new JSpinner(new SpinnerNumberModel(18, 1, 120, 1));
    private final JRadioButton predeterminada = new JRadioButton("Del menú", true);
    private final JRadioButton personalizada = new JRadioButton("Personalizada");
    private final JComboBox<Pizzas> tipo = new JComboBox<>(Pizzas.values());
    private final JComboBox<Bases> base = new JComboBox<>(Bases.values());
    private final JComboBox<Salsas> salsa = new JComboBox<>(Salsas.values());
    private final JComboBox<Orillas> orilla = new JComboBox<>(Orillas.values());
    private final JSpinner[] cantidades = new JSpinner[5];
    private final JPanel opcionesMenu = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private final JPanel opcionesPersonalizadas = new JPanel(new GridLayout(0, 2, 8, 8));
    private final JLabel estado = new JLabel("Órdenes pendientes: 0/5");
    private Orden ultimaOrden;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main().mostrar());
    }

    private void mostrar() {
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(new BorderLayout(10, 10));
        JPanel contenido = new JPanel();
        contenido.setLayout(new BoxLayout(contenido, BoxLayout.Y_AXIS));
        contenido.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));

        JPanel cliente = new JPanel(new FlowLayout(FlowLayout.LEFT));
        cliente.setBorder(BorderFactory.createTitledBorder("Cliente"));
        cliente.add(new JLabel("Nombre:")); cliente.add(nombre);
        cliente.add(new JLabel("Edad:")); cliente.add(edad);
        contenido.add(cliente);

        JPanel eleccion = new JPanel(new FlowLayout(FlowLayout.LEFT));
        eleccion.setBorder(BorderFactory.createTitledBorder("Tipo de pizza"));
        ButtonGroup grupo = new ButtonGroup();
        grupo.add(predeterminada); grupo.add(personalizada);
        eleccion.add(predeterminada); eleccion.add(personalizada);
        contenido.add(eleccion);

        opcionesMenu.setBorder(BorderFactory.createTitledBorder("Pizza del menú"));
        opcionesMenu.add(new JLabel("Elige una:")); opcionesMenu.add(tipo);
        contenido.add(opcionesMenu);

        opcionesPersonalizadas.setBorder(BorderFactory.createTitledBorder("Personaliza tu pizza"));
        opcionesPersonalizadas.add(new JLabel("Base:")); opcionesPersonalizadas.add(base);
        opcionesPersonalizadas.add(new JLabel("Salsa:")); opcionesPersonalizadas.add(salsa);
        opcionesPersonalizadas.add(new JLabel("Orilla:")); opcionesPersonalizadas.add(orilla);
        String[] ingredientes = {"Jamón", "Pepperoni", "Pimientos", "Champiñones", "Piña"};
        for (int i = 0; i < ingredientes.length; i++) {
            opcionesPersonalizadas.add(new JLabel(ingredientes[i] + ":"));
            cantidades[i] = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
            opcionesPersonalizadas.add(cantidades[i]);
        }
        contenido.add(opcionesPersonalizadas);
        predeterminada.addActionListener(e -> cambiarModo());
        personalizada.addActionListener(e -> cambiarModo());
        cambiarModo();
        ventana.add(contenido, BorderLayout.CENTER);

        JPanel acciones = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton pedir = new JButton("Confirmar pedido");
        JButton ver = new JButton("Ver última orden");
        JButton pendientes = new JButton("Ver pendientes");
        JButton entregar = new JButton("Preparar y entregar");
        pedir.addActionListener(e -> confirmar());
        ver.addActionListener(e -> dialogo("Última orden", ultimaOrden == null ? "Aún no hay una orden confirmada." : ultimaOrden.descripcion()));
        pendientes.addActionListener(e -> dialogo("Órdenes pendientes", cocina.listarOrdenes()));
        entregar.addActionListener(e -> {
            if (!cocina.realizarOrden()) {
                dialogo("Cocina", "No hay órdenes pendientes.");
                return;
            }
            Orden lista = cocina.entregarOrden();
            actualizarEstado();
            dialogo("Orden entregada", lista.descripcion());
        });
        acciones.add(pedir); acciones.add(ver); acciones.add(pendientes); acciones.add(entregar);
        JPanel pie = new JPanel(new BorderLayout());
        pie.add(acciones, BorderLayout.CENTER); pie.add(estado, BorderLayout.SOUTH);
        ventana.add(pie, BorderLayout.SOUTH);
        ventana.pack();
        ventana.setMinimumSize(new Dimension(610, ventana.getHeight()));
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }

    private void cambiarModo() {
        opcionesMenu.setVisible(predeterminada.isSelected());
        opcionesPersonalizadas.setVisible(personalizada.isSelected());
        ventana.pack();
    }

    private void confirmar() {
        String texto = nombre.getText().trim();
        if (texto.isEmpty()) {
            JOptionPane.showMessageDialog(ventana, "Escribe el nombre del cliente.", "Dato faltante", JOptionPane.WARNING_MESSAGE);
            nombre.requestFocusInWindow();
            return;
        }
        if (!cocina.preguntarPorOrdenes()) {
            dialogo("Cocina llena", "Hay 5 órdenes pendientes. Prepara y entrega una antes de continuar.");
            return;
        }
        Cliente cliente = new Cliente(texto, (Integer) edad.getValue());
        if (predeterminada.isSelected()) {
            ultimaOrden = cliente.hacerPedido((Pizzas) tipo.getSelectedItem(), cocina);
        } else {
            ultimaOrden = cliente.hacerPedido((Bases) base.getSelectedItem(), (Salsas) salsa.getSelectedItem(),
                (Orillas) orilla.getSelectedItem(), (Integer) cantidades[0].getValue(),
                (Integer) cantidades[1].getValue(), (Integer) cantidades[2].getValue(),
                (Integer) cantidades[3].getValue(), (Integer) cantidades[4].getValue(), cocina);
        }
        if (ultimaOrden != null) {
            actualizarEstado();
            dialogo("Pedido confirmado", ultimaOrden.descripcion());
        }
    }

    private void actualizarEstado() {
        estado.setText("Órdenes pendientes: " + cocina.pendientes() + "/5");
    }

    private void dialogo(String titulo, String descripcion) {
        JTextArea texto = new JTextArea(descripcion, 12, 34);
        texto.setEditable(false);
        texto.setLineWrap(true);
        texto.setWrapStyleWord(true);
        JOptionPane.showMessageDialog(ventana, new JScrollPane(texto), titulo, JOptionPane.INFORMATION_MESSAGE);
    }
}
