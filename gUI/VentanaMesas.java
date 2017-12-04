package gUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;

import iciresto.Administrador;
import iciresto.Mesa;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

/**
 * Clase Ventana con mesas, de tipo JFrame, destinada al manejo de mesas.
 * 
 * @author C.Garay,H.SepÃºlveda,B.Lebrecht
 * @version December 3nd 2017
 */
public class VentanaMesas extends javax.swing.JFrame implements ActionListener {
	private DefaultTableModel modelo;
	private javax.swing.JButton botonAgregarMesas;
	private javax.swing.JButton botonEliminarMesas;
	private javax.swing.JButton botonGuardarCambios;
	private javax.swing.JButton botonSalir;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable tabla;

	/**
	 * 
	 * @param x
	 *            Posicion en eje x
	 * @param y
	 *            Posicion en eje y
	 */
	public VentanaMesas(int x, int y) {
		setResizable(false);
		setUndecorated(true);
		initComponents();
		setBounds(x, y, 1024, 730);
		configurarTabla();
	}

	public void configurarTabla() {
		modelo = new DefaultTableModel();
		modelo.addColumn("Nro de Mesa");
		modelo.addColumn("Capacidad");
		modelo.addColumn("Estado");
		modelo.addColumn("Consumo");
		this.tabla.setModel(modelo);
		TableColumn columnaEstado = tabla.getColumnModel().getColumn(2);
		String[] estados = { "LIBRE", "ASIGNADA", "ATENDIDA", "RESERVADA", "NO HABILITADA" };
		JComboBox comboBoxEstados = new JComboBox(estados);
		TableCellEditor tce = new DefaultCellEditor(comboBoxEstados);
		columnaEstado.setCellEditor(tce);
		addDatos();
	}

	public void addDatos() {
		Administrador administrador = new Administrador();
		ArrayList<Mesa> listaMesas = administrador.getListaMesas();
		for (int i = 0; i < listaMesas.size(); i++) {
			int capacidad = listaMesas.get(i).getCapacidad();
			String estado = listaMesas.get(i).getEstado();
			int consumo = listaMesas.get(i).getConsumo();
			addDatosFila(capacidad, estado, consumo);
		}
                
                
	}

	public void recargarTabla() {
                //Se usa para reorganizar el numero de cada mesa
                for (int f = 0; f < modelo.getRowCount(); f++) {
                    modelo.setValueAt(""+(f+1), f, 0);
                }

	}

	/**
	 * 
	 * @param capacidad
	 *            Capacidad de la mesa descrita en la fila
	 * @param estado
	 *            Estado de la mesa descrita en la fila
	 * @param consumo
	 *            Consumo de la mesa descrita en la fila
	 */
	public void addDatosFila(int capacidad, String estado, int consumo) {
		String[] datos = new String[4];
		datos[0] = modelo.getRowCount() + 1 + "";
		datos[1] = capacidad + "";
		datos[2] = estado;
		datos[3] = consumo + "";
		modelo.addRow(datos);
	}

	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		tabla = new javax.swing.JTable();
		botonAgregarMesas = new javax.swing.JButton();
		botonSalir = new javax.swing.JButton();
		botonGuardarCambios = new javax.swing.JButton();
		botonEliminarMesas = new javax.swing.JButton();
		setBackground(new java.awt.Color(204, 0, 0));

		jPanel1.setBackground(new java.awt.Color(153, 0, 0));

		tabla = new javax.swing.JTable() {
			public boolean isCellEditable(int rowIndex, int colIndex) {
				if (colIndex == 0) {
					return false;
				} else {
					return true;
				}
			}
		};
		tabla.setModel(new javax.swing.table.DefaultTableModel(new Object[][] { {}, {}, {}, {} }, new String[] {

		}));
		tabla.setFocusable(false);
		tabla.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		tabla.getTableHeader().setResizingAllowed(false);
		tabla.getTableHeader().setReorderingAllowed(false);

		jScrollPane1.setViewportView(tabla);

		botonAgregarMesas.setBackground(new java.awt.Color(255, 153, 0));
		botonAgregarMesas.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
		botonAgregarMesas.setForeground(new java.awt.Color(153, 0, 0));
		botonAgregarMesas.setText("Agregar Mesa");
		botonAgregarMesas.addActionListener(this);

		botonSalir.setBackground(new java.awt.Color(255, 153, 0));
		botonSalir.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
		botonSalir.setForeground(new java.awt.Color(153, 0, 0));
		botonSalir.setText("Salir");
		botonSalir.addActionListener(this);
                

		botonGuardarCambios.setBackground(new java.awt.Color(255, 153, 0));
		botonGuardarCambios.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
		botonGuardarCambios.setForeground(new java.awt.Color(153, 0, 0));
		botonGuardarCambios.setText("Guardar Cambios");
		botonGuardarCambios.addActionListener(this);

		botonEliminarMesas.setBackground(new java.awt.Color(255, 153, 0));
		botonEliminarMesas.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
		botonEliminarMesas.setForeground(new java.awt.Color(153, 0, 0));
		botonEliminarMesas.setText("Eliminar Mesa");
		botonEliminarMesas.addActionListener(this);
               

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap(55, Short.MAX_VALUE)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 638,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGroup(jPanel1Layout.createSequentialGroup().addComponent(botonAgregarMesas)
										.addGap(18, 18, 18).addComponent(botonEliminarMesas).addGap(18, 18, 18)
										.addComponent(botonGuardarCambios).addGap(18, 18, 18).addComponent(botonSalir,
												javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(35, Short.MAX_VALUE)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addGap(29, 29, 29)
						.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 514,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(botonAgregarMesas).addComponent(botonSalir)
								.addComponent(botonGuardarCambios).addComponent(botonEliminarMesas))
						.addContainerGap(47, Short.MAX_VALUE)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		pack();
	}
     
	  /**
	   * Aqui se obtienen todas las mesas y las almacena en la lista de mesas del Administrador
	   */
        public void guardarCambios(){
         
			Administrador administrador = new Administrador();
                        
                        //Se eliminan las mesas de la clase Administrador para comenzar a agregarlas nuevamente
                        //una vez se clickea el boton de guardar mesas
                        administrador.eliminarMesas();
                
			for (int f = 0; f < modelo.getRowCount(); f++) {
				int numeroMesa = f + 1;
				// c1=capacidad, c2=estado, c3=
                                int capacidad = 0;
                                String estado = "";
                                int consumo = 0;
				for (int c = 1; c < 4; c++) {
					String valor = modelo.getValueAt(f, c).toString();
                                        
					if (c == 1) {
                                            //Capacidad
						try {
							if (Integer.valueOf(valor) >= 0) {
                                                                capacidad = Integer.valueOf(valor);
							} else {
								JOptionPane.showMessageDialog(this,
										"La Capacidad de la Mesa " + numeroMesa
												+ " contiene caracteres ilegales. Recuerde usar solo numeros positivos.",
										"Error al Guardar", JOptionPane.ERROR_MESSAGE);
								return;
							}
						} catch (NumberFormatException e) {
							JOptionPane.showMessageDialog(this,
									"La Capacidad de la Mesa " + numeroMesa
											+ " contiene caracteres ilegales. Recuerde usar solo numeros positivos.",
									"Error al Guardar", JOptionPane.ERROR_MESSAGE);
							return;
						}

					} else if (c == 2) {
                                            //Estado
						if (capacidad == 0
								&& !valor.equals("NO HABILITADA")) {
							JOptionPane.showMessageDialog(this,
									"La mesa " + numeroMesa
											+ " no tiene capacidad, debe encontrarse necesariamente no habilitada",
									"Error al Guardar", JOptionPane.ERROR_MESSAGE);
							return;
						}
						estado = valor;
					} else {
                                            //Consumo
						try {
							if (!estado.equals("ATENDIDA")
									&& Integer.valueOf(valor) > 0) {
								JOptionPane.showMessageDialog(this,
										"La mesa " + numeroMesa + " aun no es atendida, no puede registrarse consumo.",
										"Error al Guardar", JOptionPane.ERROR_MESSAGE);
								return;
							}
							if (estado.equals("ATENDIDA")
									&& Integer.valueOf(valor) == 0) {
								JOptionPane.showMessageDialog(this,
										"La mesa " + numeroMesa
												+ " se encuentra atendida, debe registrarse un consumo diferente de 0.",
										"Error al Guardar", JOptionPane.ERROR_MESSAGE);
								return;
							}
							if (Integer.valueOf(valor) >= 0) {
								consumo = Integer.valueOf(valor);
							} else {
								JOptionPane.showMessageDialog(this,
										"El Consumo de la Mesa " + numeroMesa
												+ " contiene caracteres ilegales. Recuerde usar solo numeros positivos.",
										"Error al Guardar", JOptionPane.ERROR_MESSAGE);
								return;
							}

						} catch (NumberFormatException e) {
							JOptionPane.showMessageDialog(this,
									"El Consumo de la Mesa " + numeroMesa
											+ " contiene caracteres ilegales. Recuerde usar solo numeros.",
									"Error al Guardar", JOptionPane.ERROR_MESSAGE);
							return;
						}

					}
				}
                                Mesa mesa = new Mesa(numeroMesa,capacidad,estado,consumo);
                                administrador.agregarMesa(mesa);
			}
                        administrador.guardarContenido();
                        JOptionPane.showMessageDialog(this, "Las Mesas han sido guardadas correctamente.", "Cambios Guardados", JOptionPane.INFORMATION_MESSAGE);
        }

	@Override
	public void actionPerformed(ActionEvent ae) {
                
		if (ae.getSource() == botonAgregarMesas) {
			addDatosFila(1, "LIBRE", 0);
		}

		if (ae.getSource() == botonEliminarMesas) {
                        
                        // Si el metodo tabla.getSelectedRow() da -1 quiere decir que no hay
			// fila seleccionada
			if (tabla.getRowCount() == 0 || tabla.getSelectedRow() == -1) {
				JOptionPane.showMessageDialog(this, "No hay ninguna fila seleccionada.", "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			} else {
				int fila = tabla.getSelectedRow();
				modelo.removeRow(fila);

				// Para ordenar nuevamente las filas (Poner sus numeros
				// correspondientes) hay que recargar la tabla
				recargarTabla();
			}
		}

		if (ae.getSource() == botonGuardarCambios) {
                    guardarCambios();
		}

		if (ae.getSource() == botonSalir) {
			int reply = JOptionPane.showConfirmDialog(this,
					"Los datos no guardados se perderan Â¿Desea salir de todas formas?", "Precaucion",
					JOptionPane.YES_NO_OPTION);
			if (reply == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		}
	}

}
