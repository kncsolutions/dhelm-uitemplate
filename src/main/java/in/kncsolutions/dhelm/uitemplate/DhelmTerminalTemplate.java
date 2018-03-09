/**
*Copyright 2018 KNC Solutions Private Limited

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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import in.kncsolutions.dhelm.exceptions.DataException;
import in.kncsolutions.dhelm.interfaces.TerminalTemplateInterface;
import in.kncsolutions.dhelm.uicomponents.dbutton.Dbutton;
import in.kncsolutions.dhelm.uicomponents.dcontainers.DCenterPanel;
import in.kncsolutions.dhelm.uicomponents.dcontainers.DPopUp;
import in.kncsolutions.dhelm.uicomponents.dcontainers.DTerminal;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.control.Tab;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

public abstract class DhelmTerminalTemplate extends DTerminal implements TerminalTemplateInterface{
private Scene scene;
private Stage mainStage;
private Rectangle2D visualBounds;
private Dbutton lgt;
private List<Dbutton> main_toolbar_buttons=new ArrayList<Dbutton>();
private List<String> algoList=new ArrayList<String>();
private DCenterPanel dcp;
private TemplateModel tm;

/**
*@param t : TemplateModel for terminal.
*/
public DhelmTerminalTemplate(TemplateModel t) {
	super();
	tm=t;
	setMainToolBar(tm.getContentMainToolbarButtons());
	mainStage=new Stage();
	visualBounds = Screen.getPrimary().getVisualBounds();

}
/**
*
*/
protected void setMainToolBar(Map<Integer,String> buttonList){
  for (Iterator<Entry<Integer, String>> iterator = buttonList.entrySet().iterator(); iterator.hasNext();) {
	Entry<Integer, String> m = iterator.next();
	Dbutton tmp=new Dbutton(m.getValue().toString());
	 main_toolbar_buttons.add(tmp);
}
	lgt=new Dbutton("Logout");
	lgt.chooseStyle(2);
	final Pane spacer = new Pane();
	HBox.setHgrow(spacer, Priority.ALWAYS);
	spacer.setMinSize(10, 1);
	super.getMainToolBar().setStyle("-fx-background-color: #8bb9f4;");
	for(int i=0;i<main_toolbar_buttons.size();i++) {
		super.getMainToolBar().getItems().add( new Separator());
		super.getMainToolBar().getItems().add(main_toolbar_buttons.get(i).getButton());
	}
	super.getMainToolBar().getItems().addAll(
			                           spacer,
			                           new Separator(),
                                       lgt.getButton(),
                                       new Separator());
	if(!tm.getContentMainToolbarButtonsStatus()) {
		main_toolbar_buttons.get(0).getButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) { 	
            	DhelmTerminalTemplate.this.setCenter(1);
            }
 
          });
		for(int i=1;i<main_toolbar_buttons.size();i++) {
		 main_toolbar_buttons.get(i).getButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) { 	
              DPopUp.Warn("Do your implementations..");
            }
 
          });
		}
		lgt.getButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
              DPopUp.Warn("Do your implementations..");
            }
          });

	}
	else if(tm.getContentMainToolbarButtonsStatus()) {		
		mainToolbarButtonsActions();
	}
 
}
/**
*The method to be implemented for tool bar button actions.  
*/
protected abstract void mainToolbarButtonsActions();
/**
*@param event_id: The id of the external event according to which the center content have to be set. 
*/
public void setCenter(int event_id){
  UIMemo uiMem=new UIMemo();
  Tab tb=new Tab();
  Tab tbOp=new Tab();
  tbOp.setClosable(false);
  dcp=new DCenterPanel();
  algoList.clear();
  algoList.addAll(tm.getContentAlgoList());
  dcp.setAlgoList(algoList);
  dcp.getAlgoSelector().getSelectionModel().selectFirst();
  if(tm.getCenterTabTitle(event_id)!=null)
    tb.setText(tm.getCenterTabTitle(event_id));
  else
	tb.setText("Tab "+Integer.toString(event_id));
  tb.setContent((new ScrollPane(dcp.getDCenterPanel())));
  super.addToCenterPanel(tb);
  tb.getTabPane().getSelectionModel().select(tb);
  if(!tm.getContentAlgoListStatus()) {
	  DhelmTerminalTemplate.this.setBottomPanel(event_id,tbOp,uiMem);
    dcp.getAlgoSelector().valueProperty().addListener((ChangeListener<String>) (ov, t, t1) -> {
	    System.out.println(t1);
	      if(t1.equals(algoList.get(0))){
	        dcp.cleanParamPane();
	       }
	      else {
	    	dcp.cleanParamPane();
	    	StackPane test=new StackPane();
	    	test.getChildren().add(new Label("Add your custom content here.."));
	    	dcp.setParamPane(test);
	    	//DhelmTerminalTemplate.this.setBottomPanel(event_id,tbOp);
	      }
	   });
  }
  else if(tm.getContentAlgoListStatus()) {
	  if(tm.getDefautOpTerminal()) {
		  DhelmTerminalTemplate.this.setBottomPanel(event_id,tbOp,uiMem); 
	  }
	  dcp.getAlgoSelector().valueProperty().addListener((ChangeListener<String>) (ov, t, t1) -> {
	    System.out.println(t1);
	      if(t1.equals(algoList.get(0))){
	        dcp.cleanParamPane();
	       }
	      else {
	    	dcp.cleanParamPane();
	    	uiMem.setInputTab(tb);
	    	uiMem.setOutputTab(tbOp);
	    	uiMem.setAlgoSelector(dcp.getAlgoSelector());
	    	System.out.println("Successful..");
	    	runAlgorithmOnChange(t1,dcp);
	      }
	   });
  }
  if(tm.getDefautOpTerminal()) {
    tb.setOnCloseRequest(new EventHandler<Event>(){
        public void handle(Event arg0){
          tbOp.getTabPane().getTabs().remove(tbOp);
       }
     });
    //if(tb!=null) {
     tb.setOnSelectionChanged(new EventHandler<Event>(){
        public void handle(Event arg0){
          tbOp.getTabPane().getSelectionModel().select(tbOp);
        }
     });
    //}
   }
	
}
/**
*@param algorithm : Specific algorithm selected from drop down combo box as set by TemplateModel class 
*@param d : The DcenterPanel. Here GUI for input fields to be rendered specific to the algorithm.
*/
public abstract void runAlgorithmOnChange(String algorithm,DCenterPanel d);
/**
*@param uiMem 
*@param id : id of the button which is to be retrieved. 
*@return Returns the button with specific id. 
*@throws DataException if the button with specific id does not exist.
* 
*/
public void setBottomPanel(int i,Tab t, UIMemo uiMem){
	DefaultOutputTemplate dop=new DefaultOutputTemplate();
	if(tm.getCenterTabTitle(i)!=null)
	    t.setText(tm.getCenterTabTitle(i));
	  else
		  t.setText("Output Tab "+Integer.toString(i));
	t.setContent(dop.getView());
    super.addToBottomPanel(t);
    t.getTabPane().getSelectionModel().select(t);
}
/**
*@param id : id of the button which is to be retrieved. 
*@return Returns the button with specific id. 
* @throws DataException if the button with specific id does not exist.
* 
*/
public Button getMainToolbarButtonByID(int id) throws DataException {
	if(id<0 || (id-1)>main_toolbar_buttons.size()-1) {
		throw new DataException("The button with specified id is not available.");
	}
	else {
		return main_toolbar_buttons.get((id-1)).getButton();
	}
}
/** 
*@return Returns the button with specific id.  
*/
public Button getLogOutButton() {
	return lgt.getButton();
}
/**
*@return Returns the top node of the Background 
*/
public Node getTop() {
	return super.getMainBackground().getTop();
}
/**
*@return Returns the bottom node of the Background 
*/
public Node getBottom() {
	return super.getMainBackground().getBottom();
}
/**
*@return Returns the right node of the Background 
*/
public Node getRight() {
	return super.getMainBackground().getRight();
}
/**
*@return Returns the left node of the Background 
*/
public Node getLeft() {
	return super.getMainBackground().getLeft();
}
/**
*@return Returns the center node of the Background 
*/
public Node getCenter() {
	return super.getMainBackground().getCenter();
}
/**
*
*/
protected Stage getMainStage(){
  return mainStage;
}
/**
*
*/
protected void setMainStage(){   
	 scene=new Scene(super.getMainBackground(),visualBounds.getWidth(), visualBounds.getHeight());
	 System.out.println("Can reach here......");
	 mainStage.setScene(scene);
	 mainStage.show();
}
/**
*@param rp : the Node to be rendered at the right panel. 
*/
public void setRightPanel(Node rp) {
	super.getMainBackground().setRight(rp);
	
}
/**
*@param lp : the Node to be rendered at the left panel.  
*/
public void setLeftPanel(Node lp) {
	super.getMainBackground().setLeft(lp);	
}
}
