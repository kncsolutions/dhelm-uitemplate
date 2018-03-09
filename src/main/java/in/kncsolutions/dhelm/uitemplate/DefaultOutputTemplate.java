/**
*Copyright 2018 @KNC Solutions Private Limited

*Licensed under the Apache License, Version 2.0 (the "License");
*you may not use this file except in compliance with the License.
*You may obtain a copy of the License at

* http://www.apache.org/licenses/LICENSE-2.0

*Unless required by applicable law or agreed to in writing, software
*distributed under the License is distributed on an "AS IS" BASIS,
*WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
*See the License for the specific language governing permissions and
*limitations under the License.
*/
package in.kncsolutions.dhelm.uitemplate;

import in.kncsolutions.dhelm.uicomponents.dbutton.Dbutton;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Screen;

public class DefaultOutputTemplate {
	
private GridPane b1,b2,b3;
private TabPane tBottom;
private Tab t1,t2,t3;
private TextArea ta1;
private Rectangle2D visualBounds;
private TextArea ta2;
private TextArea ta3;
private Dbutton saveBullish;
private Dbutton saveBearish;
private VBox panelCancel;
private Dbutton cancelScan;
private VBox panelBullish;
private VBox panelBearish;

/**
* 
*/
public DefaultOutputTemplate(){
	visualBounds = Screen.getPrimary().getVisualBounds();
	b1=new GridPane();
	b1.setMaxWidth(visualBounds.getWidth());
	b2=new GridPane();
	b2.setMaxWidth(visualBounds.getWidth());
	b3=new GridPane();
	b3.setMaxWidth(visualBounds.getWidth());
	tBottom=new TabPane();
	
	t1=new Tab();
	t1.setText("Progress");
	t1.setClosable(false);
	t2=new Tab();
	t2.setText("Bullish Patterns");
	t2.setClosable(false);
	t3=new Tab();
	t3.setText("Bearish Patterns");
	t3.setClosable(false);
    
	tBottom.setBorder(new Border(new BorderStroke(Color.ALICEBLUE, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(7))));
   
    b1.setBorder(new Border(new BorderStroke(Color.DARKGRAY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(2))));
    b2.setBorder(new Border(new BorderStroke(Color.DARKGRAY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(2))));
    b3.setBorder(new Border(new BorderStroke(Color.DARKGRAY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(2))));
   
    ta1=new TextArea();
    ta1.setMinWidth(visualBounds.getWidth()-180);    
    ta1.selectEnd();
    ta2=new TextArea();
    ta2.setMinWidth(visualBounds.getWidth()-150);
    ta3=new TextArea();
    ta3.setMinWidth(visualBounds.getWidth()-150);
    
    
    cancelScan=new Dbutton("Cancel");
    cancelScan.chooseStyle(1);
    saveBullish=new Dbutton("Save");
    saveBullish.chooseStyle(1);
    saveBearish=new Dbutton("Save");
    saveBearish.chooseStyle(1);
    
    panelCancel=new VBox();
    panelCancel.setSpacing(5);
    panelCancel.setAlignment(Pos.CENTER);
    panelCancel.setMinWidth(130);
    panelCancel.setStyle("-fx-background-color: #336699;");
    panelCancel.getChildren().addAll(  new Separator(),
                                       cancelScan.getButton(),
                                       new Separator(),
                                       new Separator());
    panelBullish=new VBox();
    panelBullish.setSpacing(5);
    panelBullish.setAlignment(Pos.CENTER);
    panelBullish.setMinWidth(100);
    panelBullish.setStyle("-fx-background-color: #336699;");
    panelBullish.getChildren().addAll( new Separator(),
                                       saveBullish.getButton(),
                                       new Separator(),
                                       new Separator());
    panelBearish=new VBox();
    panelBearish.setSpacing(5);
    panelBearish.setAlignment(Pos.CENTER);
    panelBearish.setMinWidth(100);    
    panelBearish.setStyle("-fx-background-color: #336699;");
    panelBearish.getChildren().addAll( new Separator(),
                                       saveBearish.getButton(),
                                       new Separator(),
                                       new Separator());

    b1.add(ta1,0,0);
    b1.add(panelCancel,1,0);
    t1.setContent(b1);
    b2.add(ta2,0,0);
    b2.add(panelBullish,1,0);
    t2.setContent(b2);
    b3.add(ta3,0,0);
    b3.add(panelBearish,1,0);
    t3.setContent(b3);
    tBottom.getTabs().add(t1);
    tBottom.getTabs().add(t2);
    tBottom.getTabs().add(t3);
}
/**
*
*/
private HBox getTitlePanel(String title){
 HBox h=new HBox();
 h.setAlignment(Pos.CENTER);
 h.setStyle("-fx-background-color: #336699;");
 Label l=new Label(title); 
 l.setFont(Font.font ("Verdana",FontWeight.BOLD, 16));
 l.setTextFill(Color.WHITE);
 h.getChildren().add(l);
 return h;
}	
/**
*@return  
*/
public TabPane getView() {
	return tBottom;
}
/**
*@return Returns the progress text area. 
*/
public TextArea getProgressTextArea() {
	return ta1;
}
/**
*@return Returns the bullish pattern text area. 
*/
public TextArea getBullishPatternTextArea() {
	return ta2;
}
/**
*@return Returns the Bearish pattern text area. 
*/
public TextArea getBeraishPatternTextArea() {
	return ta3;
}
/**
*@return Returns the cancel button for progress text area. 
*/
public Button getProgressCancelButton() {
	return cancelScan.getButton();
}
/**
*@return Returns the save bullish button. 
*/
public Button getBullishPatternSaveButton() {
	return saveBullish.getButton();
}
/**
*@return Returns the save bearish button. 
*/
public Button getBearishPatternSaveButton() {
	return saveBearish.getButton();
}
}
