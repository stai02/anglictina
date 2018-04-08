/**
 * 
 */
package com.github.stai02.anglictina.ui;

import java.util.Random;

import com.github.stai02.anglictina.logika.Hra;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.image.ImageView;



/**
 * @author Ivka
 *
 */
public class Controller extends GridPane {
	Hra hra = new Hra();
	
	@FXML public Button hadaj;
	@FXML public Button tl;
	@FXML public Button tr;
	@FXML public Button cl;
	@FXML public Button cr;
	@FXML public Button bl;
	@FXML public Button br;
	
	public void initialize(Hra hra) {
		this.hra = hra;
		
		//vytvorí sa zoznam anglických slov pre hru
		hra.vytvorAnglickyZoznam();
		
		// tlačítkam sa priradia obrázky a tooltipy
				
		String image_tl = hra.getSlovnik().get(hra.getAnglickyZoznam().get(1)).getBezDiakritiky() +".PNG";
		Image image1 = new Image(getClass().getResourceAsStream(image_tl));
		ImageView topLeft = new ImageView();
		topLeft.setImage(image1);
		topLeft.fitWidthProperty().bind(tl.widthProperty());
		topLeft.fitHeightProperty().bind(tl.widthProperty());
		tl.setGraphic(topLeft);

		String image_tr = hra.getSlovnik().get(hra.getAnglickyZoznam().get(2)).getBezDiakritiky()+".PNG";
		Image image2 = new Image(getClass().getResourceAsStream(image_tr));
		ImageView topRight = new ImageView();
		topRight.setImage(image2);
		tr.setGraphic(topRight);
		
		String image_cl =  hra.getSlovnik().get(hra.getAnglickyZoznam().get(3)).getBezDiakritiky()+".PNG";
		Image image3 = new Image(getClass().getResourceAsStream(image_cl));
		ImageView centerLeft = new ImageView();
		centerLeft.setImage(image3);
		cl.setGraphic(centerLeft);
		
		String image_cr = hra.getSlovnik().get(hra.getAnglickyZoznam().get(4)).getBezDiakritiky()+".PNG";
		Image image4 = new Image(getClass().getResourceAsStream(image_cr));
		ImageView centerRight = new ImageView();
		centerRight.setImage(image4);
		cr.setGraphic(centerRight);
		
		String image_bl = hra.getSlovnik().get(hra.getAnglickyZoznam().get(5)).getBezDiakritiky()+".PNG";
		Image image5 = new Image(getClass().getResourceAsStream(image_bl));
		ImageView bottomLeft = new ImageView();
		bottomLeft.setImage(image5);
		bl.setGraphic(bottomLeft);
		
		String image_br = hra.getSlovnik().get(hra.getAnglickyZoznam().get(6)).getBezDiakritiky()+".PNG";
		Image image6 = new Image(getClass().getResourceAsStream(image_br));
		ImageView bottomRight = new ImageView();
		bottomRight.setImage(image6);
		br.setGraphic(bottomRight);
		
		String text_tl = hra.getSlovnik().get(hra.getAnglickyZoznam().get(1)).getBezDiakritiky();
		Tooltip tooltip_tl = new Tooltip(text_tl);
		Tooltip.install(tl, tooltip_tl);
		String text_tr = hra.getSlovnik().get(hra.getAnglickyZoznam().get(2)).getBezDiakritiky();
		Tooltip tooltip_tr = new Tooltip(text_tr);
		Tooltip.install(tr, tooltip_tr);	
		String text_cl = hra.getSlovnik().get(hra.getAnglickyZoznam().get(3)).getBezDiakritiky();
		Tooltip tooltip_cl = new Tooltip(text_cl);
		Tooltip.install(cl, tooltip_cl);
		String text_cr = hra.getSlovnik().get(hra.getAnglickyZoznam().get(4)).getBezDiakritiky();
		Tooltip tooltip_cr = new Tooltip(text_cr);
		Tooltip.install(cr, tooltip_cr);		
		String text_bl = hra.getSlovnik().get(hra.getAnglickyZoznam().get(5)).getBezDiakritiky();
		Tooltip tooltip_bl = new Tooltip(text_bl);
		Tooltip.install(bl, tooltip_bl);
		String text_br = hra.getSlovnik().get(hra.getAnglickyZoznam().get(6)).getBezDiakritiky();
		Tooltip tooltip_br = new Tooltip(text_br);
		Tooltip.install(br, tooltip_br);
	}
	
	@FXML
    public void ovladacUdalosti() {

	}

	public void getSlovo(){
		String text = hra.getAnglickyZoznam().get(new Random().nextInt(hra.getAnglickyZoznam().size()));
		hadaj.setText(text);
	}
}
