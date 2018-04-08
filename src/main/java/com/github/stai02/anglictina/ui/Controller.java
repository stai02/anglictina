/**
 * 
 */
package com.github.stai02.anglictina.ui;

import com.github.stai02.anglictina.logika.Hra;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.image.ImageView;
import javafx.scene.control.TextArea;


/**
 * @author Ivka
 *
 */
public class Controller extends GridPane {
	Hra hra = new Hra();
	
	@FXML public TextArea spravne;
	@FXML public TextArea nespravne;
	@FXML public Button hadaj;
	@FXML public Button tl;
	@FXML public Button tr;
	@FXML public Button cl;
	@FXML public Button cr;
	@FXML public Button bl;
	@FXML public Button br;

	
	public void initialize(Hra hra) {
		this.hra = hra;
		noveKoloHry(); 
		}
	
	public void koniec() {
		System.exit(0);
	}
	
	public void noveKoloHry() {
		
		//vytvorí sa zoznam anglických slov pre hru
		hra.vytvorAnglickyZoznam();
		
		// tlačítkam sa priradia obrázky a tooltipy
				
		String image_tl = hra.getSlovnik().get(hra.getAnglickyZoznam().get(1)).getBezDiakritiky() +".png";
		Image image1 = new Image(getClass().getResourceAsStream(image_tl));
		ImageView topLeft = new ImageView();
		topLeft.setImage(image1);
		topLeft.fitWidthProperty().bind(tl.widthProperty());
		topLeft.fitHeightProperty().bind(tl.widthProperty());
		tl.setGraphic(topLeft);
		tl.setText(hra.getSlovnik().get(hra.getAnglickyZoznam().get(1)).getMeno());
		tl.setPadding(new Insets(0));
		
		String image_tr = hra.getSlovnik().get(hra.getAnglickyZoznam().get(2)).getBezDiakritiky()+".png";
		Image image2 = new Image(getClass().getResourceAsStream(image_tr));
		ImageView topRight = new ImageView();
		topRight.setImage(image2);
		tr.setGraphic(topRight);
		tr.setText(hra.getSlovnik().get(hra.getAnglickyZoznam().get(2)).getMeno());
		tr.setPadding(new Insets(0));
		
		String image_cl =  hra.getSlovnik().get(hra.getAnglickyZoznam().get(3)).getBezDiakritiky()+".png";
		Image image3 = new Image(getClass().getResourceAsStream(image_cl));
		ImageView centerLeft = new ImageView();
		centerLeft.setImage(image3);
		cl.setGraphic(centerLeft);
		cl.setText(hra.getSlovnik().get(hra.getAnglickyZoznam().get(3)).getMeno());
		cl.setPadding(new Insets(0));
		
		String image_cr = hra.getSlovnik().get(hra.getAnglickyZoznam().get(4)).getBezDiakritiky()+".png";
		Image image4 = new Image(getClass().getResourceAsStream(image_cr));
		ImageView centerRight = new ImageView();
		centerRight.setImage(image4);
		cr.setGraphic(centerRight);
		cr.setText(hra.getSlovnik().get(hra.getAnglickyZoznam().get(4)).getMeno());
		cr.setPadding(new Insets(0));
		
		String image_bl = hra.getSlovnik().get(hra.getAnglickyZoznam().get(5)).getBezDiakritiky()+".png";
		Image image5 = new Image(getClass().getResourceAsStream(image_bl));
		ImageView bottomLeft = new ImageView();
		bottomLeft.setImage(image5);
		bl.setGraphic(bottomLeft);
		bl.setText(hra.getSlovnik().get(hra.getAnglickyZoznam().get(5)).getMeno());
		bl.setPadding(new Insets(0));
		
		String image_br = hra.getSlovnik().get(hra.getAnglickyZoznam().get(6)).getBezDiakritiky()+".png";
		Image image6 = new Image(getClass().getResourceAsStream(image_br));
		ImageView bottomRight = new ImageView();
		bottomRight.setImage(image6);
		br.setGraphic(bottomRight);
		br.setText(hra.getSlovnik().get(hra.getAnglickyZoznam().get(6)).getMeno());
		br.setPadding(new Insets(0));
		
		String text_tl = hra.getSlovnik().get(hra.getAnglickyZoznam().get(1)).getMeno();
		Tooltip tooltip_tl = new Tooltip(text_tl);
		Tooltip.install(tl, tooltip_tl);
		String text_tr = hra.getSlovnik().get(hra.getAnglickyZoznam().get(2)).getMeno();
		Tooltip tooltip_tr = new Tooltip(text_tr);
		Tooltip.install(tr, tooltip_tr);	
		String text_cl = hra.getSlovnik().get(hra.getAnglickyZoznam().get(3)).getMeno();
		Tooltip tooltip_cl = new Tooltip(text_cl);
		Tooltip.install(cl, tooltip_cl);
		String text_cr = hra.getSlovnik().get(hra.getAnglickyZoznam().get(4)).getMeno();
		Tooltip tooltip_cr = new Tooltip(text_cr);
		Tooltip.install(cr, tooltip_cr);		
		String text_bl = hra.getSlovnik().get(hra.getAnglickyZoznam().get(5)).getMeno();
		Tooltip tooltip_bl = new Tooltip(text_bl);
		Tooltip.install(bl, tooltip_bl);
		String text_br = hra.getSlovnik().get(hra.getAnglickyZoznam().get(6)).getMeno();
		Tooltip tooltip_br = new Tooltip(text_br);
		Tooltip.install(br, tooltip_br);
		hadaj.setDisable(false);
		hadaj.setText("Hádej");
	}
	
	public void getSlovo(){
		hadaj.setText(hra.getAnglickeSlovo());
		hadaj.setDisable(true);
		}
	
	public void skontrolujOdpoved(Event event) {
		Button tlacidlo = (Button) event.getSource();
		
		String odpoved = tlacidlo.getText();
		String slovo = hra.getSlovnik().get(hadaj.getText()).getMeno();
		String vysledok = hra.getVysledok(odpoved, slovo).get(0);
		String skore = hra.getVysledok(odpoved, slovo).get(1);
		hra.skore(odpoved, slovo);
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Skóre");
		alert.setHeaderText(vysledok);
		alert.showAndWait();
		if (skore.equals("spravne")) {
			spravne.setText(String.valueOf(hra.getPocetSpravnych()));
		} else if (skore.equals("nespravne")) {
			nespravne.setText(String.valueOf(hra.getPocetNespravnych()));
		}
		noveKoloHry();
	}
}
