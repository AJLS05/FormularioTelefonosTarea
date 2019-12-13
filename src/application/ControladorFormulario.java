package application;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import clases.Marca;
import clases.Modelo;
import clases.Telefono;
import clases.SistemaOperativo;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;

public class ControladorFormulario implements Initializable{
	private ObservableList<Marca> marcas;
	private ObservableList<Modelo> modelos;
	private ObservableList<SistemaOperativo> sistemasOperativos;
	private ObservableList<Telefono> telefonos;
	@FXML private ComboBox<Marca> cboMarca;
	@FXML private ComboBox<Modelo> cboModelo;
	@FXML private ComboBox<SistemaOperativo> cboSistemasOperativos;
	@FXML private TextField capacidadMemoria;
	@FXML private TextField capacidadDisco;
	@FXML private TextField resolucion;
	@FXML private TextField tamanioPantalla;
	@FXML private ToggleGroup compania;
	@FXML private RadioButton rdbtigo;
	@FXML private RadioButton rdbclaro;
	@FXML private RadioButton rdbhondutel;
	@FXML private TextField numeroTelefonico;
	@FXML private TextField capacidadCamara;
	@FXML private ArrayList<String> otrosComponentes;
	@FXML private CheckBox ckbLTE;
	@FXML private CheckBox ckbNFC;
	@FXML private CheckBox ckbBT;
	
	@FXML private Button btnNuevo;
	@FXML private Button btnGuardar;
	@FXML private Button btnActualizar;
	@FXML private Button btnEliminar;
	@FXML private Button btnSalir;
	
	@FXML private ListView<Telefono> lstTelefonos;
	private ArrayList<String> errores;
	
	public ControladorFormulario() {
		System.out.println("Se ejecuto el contructor del formulario");
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		marcas = FXCollections.observableArrayList();
		modelos = FXCollections.observableArrayList();
		sistemasOperativos = FXCollections.observableArrayList();
		telefonos = FXCollections.observableArrayList();
		errores = new ArrayList<String>();
		marcas.add(new Marca(01, "GUAGUEI"));
		marcas.add(new Marca(02, "Samsun"));
		marcas.add(new Marca(03, "apel"));
		cboMarca.setItems(marcas);
		
		modelos.add(new Modelo("A1"));
		modelos.add(new Modelo("B2"));
		modelos.add(new Modelo("C3"));
		cboModelo.setItems(modelos);
		
		sistemasOperativos.add(new SistemaOperativo("Marshmelo","1A",2015));
		sistemasOperativos.add(new SistemaOperativo("kitcat","1A",2013));
		sistemasOperativos.add(new SistemaOperativo("Yeli Bin","1A",2012));
		cboSistemasOperativos.setItems(sistemasOperativos);
		
		lstTelefonos.setItems(telefonos);
		lstTelefonos.getSelectionModel().selectedItemProperty().addListener(
				new ChangeListener<Telefono>() {

					@Override
					public void changed(ObservableValue<? extends Telefono> arg0, Telefono valorAnterior, Telefono valorActual) {
						System.out.println("Valor actual: "+valorActual);
						if (valorActual!=null) {
							cboMarca.getSelectionModel().select(valorActual.getMarca());
							cboModelo.getSelectionModel().select(valorActual.getModelo());
							cboSistemasOperativos.getSelectionModel().select(valorActual.getSistemaOperativo());
							capacidadMemoria.setText(String.valueOf(valorActual.getMemoriaInterna()));
							capacidadDisco.setText(String.valueOf(valorActual.getMemoriaInterna()));
							resolucion.setText(String.valueOf(valorActual.getResolucion()));
							tamanioPantalla.setText(String.valueOf(valorActual.getTamanioPantalla()));
							if (valorActual.getCompania().equals("Tigo")) 
								rdbtigo.setSelected(true);
							if (valorActual.getCompania().equals("Claro")) 
								rdbclaro.setSelected(true);
							if (valorActual.getCompania().equals("Hondutel")) 
								rdbhondutel.setSelected(true);
							numeroTelefonico.setText(String.valueOf(valorActual.getNumero()));
							capacidadCamara.setText(String.valueOf(valorActual.getCapacidadDeCamara()));
//							if (valorActual.getOtrosComponentes().equals("LTE"))
//								ckbLTE.setSelected(true);
							for (int i = 0; i < valorActual.getOtrosComponentes().size(); i++) {
								if (valorActual.getOtrosComponentes().equals("LTE")) {
									ckbLTE.setSelected(true);
								}
								if (valorActual.getOtrosComponentes().equals("NFC")) {
									ckbLTE.setSelected(true);
								}
								if (valorActual.getOtrosComponentes().equals("BT")) {
									ckbLTE.setSelected(true);
								}
							}
							btnActualizar.setDisable(false);
							btnEliminar.setDisable(false);
							btnGuardar.setDisable(true);
						}
					}
				}
				);
		leerInformacionArchivo();
	}
	
	public void leerInformacionArchivo() {
		try {
			ObjectInputStream archivo = new ObjectInputStream(new FileInputStream("telefonos.data"));
			try {
				while (true) {
					Telefono t = (Telefono)archivo.readObject();
					telefonos.add(t);
				}
			} catch (EOFException e) {
				System.out.println("Fin del archivo");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			archivo.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@FXML
	private void guardar() {
		validar();
		if (errores.size()>0) {
			//Copiado y pgado PROOOOOOO!!
			Alert mensaje = new Alert(AlertType.WARNING);
			String cadenaErrores = "";
			for (int i=0;i<errores.size();i++)
				cadenaErrores+=errores.get(i)+"\n";
			
			mensaje.setTitle("Error al guardar");
			mensaje.setContentText(cadenaErrores);
			mensaje.setHeaderText("Se encontraron los siguientes errores: ");
			mensaje.show();
			return; 
		}
		ArrayList<String> otrosComponentesSelecionados = new ArrayList<String>();
		
		if (ckbLTE.isSelected())
			otrosComponentesSelecionados.add("LTE");
		   
		if (ckbNFC.isSelected())
			otrosComponentesSelecionados.add("NFC");
		
		if (ckbBT.isSelected())
			otrosComponentesSelecionados.add("BT");
		
		Telefono telefono = new Telefono(
				Integer.parseInt(tamanioPantalla.getText()), 
				Integer.parseInt(resolucion.getText()), 
				cboSistemasOperativos.getSelectionModel().getSelectedItem(), 
				Integer.parseInt(capacidadMemoria.getText()), 
				Integer.parseInt(capacidadDisco.getText()), 
				cboMarca.getSelectionModel().getSelectedItem(), 
				cboModelo.getSelectionModel().getSelectedItem(), 
				Integer.parseInt(numeroTelefonico.getText()), 
				((RadioButton)compania.getSelectedToggle()).getText(), 
				Integer.parseInt(capacidadCamara.getText()), 
				otrosComponentes = otrosComponentesSelecionados
				);
		System.out.println(telefono);
		telefonos.add(telefono);
		GuardarObjetosArchivo();
	}

	public void GuardarObjetosArchivo() {
		try {
			ObjectOutputStream archivo = new ObjectOutputStream(new FileOutputStream("telefonos.data"));
			for (int i = 0; i < telefonos.size(); i++) {
				archivo.writeObject(telefonos.get(i));
			}
			archivo.flush();
			archivo.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void validar() {
		errores.clear();
		if (!capacidadMemoria.getText().isEmpty()) {
			try {
				Integer.parseInt(capacidadMemoria.getText());
			}catch(NumberFormatException e) {
				errores.add("La capacidad de Memoria debe ser numerico");
			}
		}
		if (!capacidadDisco.getText().isEmpty()) {
			try {
				Integer.parseInt(capacidadDisco.getText());
			}catch(NumberFormatException e) {
				errores.add("La capacidad del disco debe ser numerico");
			}
		}
		if (!resolucion.getText().isEmpty()) {
			try {
				Integer.parseInt(resolucion.getText());
			}catch(NumberFormatException e) {
				errores.add("La resolucion debe ser numerico");
			}
		}
		if (!tamanioPantalla.getText().isEmpty()) {
			try {
				Integer.parseInt(tamanioPantalla.getText());
			}catch(NumberFormatException e) {
				errores.add("El tamaño de la pantalla debe ser numerico");
			}
		}
		if (!numeroTelefonico.getText().isEmpty()) {
			try {
				Integer.parseInt(numeroTelefonico.getText());
			}catch(NumberFormatException e) {
				errores.add("El numero telefonico debe ser numerico");
			}
		}
		if (!capacidadCamara.getText().isEmpty()) {
			try {
				Integer.parseInt(capacidadCamara.getText());
			}catch(NumberFormatException e) {
				errores.add("La capacidad de la camara debe ser numerico");
			}
		}
		
		if (cboMarca.getSelectionModel().getSelectedItem() == null)
			errores.add("El campo Marca esta vacio");
		if (cboModelo.getSelectionModel().getSelectedItem() == null)
			errores.add("El campo Modelo esta vacio");
		if (cboSistemasOperativos.getSelectionModel().getSelectedItem() == null)
			errores.add("El campo Sistema Operativo esta vacio");
		if (capacidadMemoria.getText().isEmpty())
			errores.add("El campo capacidad de Memoria esta vacio");
		if (capacidadDisco.getText().isEmpty())
			errores.add("El campo capacidad de Disco esta vacio");
		if (resolucion.getText().isEmpty())
			errores.add("El campo resolucion de Memoria esta vacio");
		if (tamanioPantalla.getText().isEmpty())
			errores.add("El campo tamaño de pantalla esta vacio");
		if (compania.getSelectedToggle() == null)
			errores.add("El campo compañia esta vacio");
		if (numeroTelefonico.getText().isEmpty())
			errores.add("El campo Numero telefonico esta vacio");
		if (capacidadCamara.getText().isEmpty())
			errores.add("El campo capacidad de camara esta vacio");
	}
	
	@FXML
	private void nuevo() {
		cboMarca.getSelectionModel().clearSelection();
		cboModelo.getSelectionModel().clearSelection();
		cboSistemasOperativos.getSelectionModel().clearSelection();
		capacidadMemoria.clear();
		capacidadDisco.clear();
		resolucion.clear();
		tamanioPantalla.clear();
		rdbtigo.setSelected(false);
		rdbclaro.setSelected(false);
		rdbhondutel.setSelected(false);
		numeroTelefonico.clear();
		capacidadCamara.clear();
		ckbBT.setSelected(false);
		ckbLTE.setSelected(false);
		ckbNFC.setSelected(false);
		btnActualizar.setDisable(true);
		btnGuardar.setDisable(false);
	}
	
	@FXML
	public void actualizar() {
	telefonos.set(lstTelefonos.getSelectionModel().getSelectedIndex(), 
				new Telefono(
						Integer.parseInt(tamanioPantalla.getText()), 
						Integer.parseInt(resolucion.getText()), 
						cboSistemasOperativos.getSelectionModel().getSelectedItem(), 
						Integer.parseInt(capacidadMemoria.getText()), 
						Integer.parseInt(capacidadDisco.getText()), 
						cboMarca.getSelectionModel().getSelectedItem(), 
						cboModelo.getSelectionModel().getSelectedItem(), 
						Integer.parseInt(numeroTelefonico.getText()), 
						((RadioButton)compania.getSelectedToggle()).getText(), 
						Integer.parseInt(capacidadCamara.getText()), 
						otrosComponentes
				)
			);
	}
	
	@FXML
	public void eliminar() {
		telefonos.remove(lstTelefonos.getSelectionModel().getSelectedIndex());
		nuevo();
	}
	
	@FXML
	public void salir() {
		System.exit(0);
	}
	
}
