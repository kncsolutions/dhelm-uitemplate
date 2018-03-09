/**
*Copyright 2018 Knc Solutions Private Limited

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

import java.awt.Button;
import java.util.HashMap;
import java.util.Map;

import in.kncsolutions.dhelm.exceptions.DataException;
import in.kncsolutions.dhelm.interfaces.UIMemoInterface;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
/**
*
*/
public class UIMemo implements UIMemoInterface {
public Map<Integer,Node> node=new HashMap<Integer,Node>();
public Map<Integer,Tab> tabs=new HashMap<Integer,Tab>();
private Tab inputTab=new Tab();
private Tab outputTab=new Tab();
private ComboBox<?> algoSelector;
public Map<Integer,TextArea> tArea=new HashMap<Integer,TextArea>();
private TextArea progressTArea=new TextArea();
private TextArea rBullishTarea=new TextArea();
private TextArea rBearishTarea=new TextArea();
public Map<Integer,Button> btn=new HashMap<Integer,Button>();
private Button cancelScan;
private Button saveBullish;
private Button saveBearish;
/**
*@param nodeID : The id for the Node which is to be stored in the memo
*@param t : The Node itself with the specified ID. 
*@throws NullPointerException if input argument is null.
*@throws DataException if a Node with specified ID already exists.
*/
@Override
public void setNodeByID(int nodeID, Node t) throws NullPointerException, DataException {
	if(node.containsKey(nodeID)) {
		 throw new DataException("Node with the specified ID already exists.");
	}
	else if(t==null) {
		throw new NullPointerException();
	}
	else {
	    node.put(nodeID, t);
	}
	
}
/**
*@param nodeID : the ID for the Tab which is to be retrieved. 
*@return Returns the Node with the specified id if it exists. 
*/
@Override
public Node getNodeByID(int nodeID) {
	if(!node.containsKey(nodeID)) {
		throw new NullPointerException();		
	}
	return node.get(nodeID);
}
/**
*@param tabID : The id for the Tab which is to be stored in the memo
*@param t : The Tab itself with the specified ID. 
*@throws  NullPointerException if input argument is null.
*@throws  DataException if a Tab with specified ID already exists.
*/
@Override
public void setTabByID(int tabID, Tab t) throws NullPointerException, DataException {
	if(tabs.containsKey(tabID)) {
		 throw new DataException("Node with the specified ID already exists.");
	}
	else if(t==null) {
		throw new NullPointerException();
	}
	else {
	    tabs.put(tabID, t);
	}
	
}
/**
*@param tabID : the ID for the Tab which is to be retrieved. 
*@return Returns the Tab with the specified id if it exists. 
*/
@Override
public Tab getTabByID(int tabID) {
	if(!tabs.containsKey(tabID)) {
		throw new NullPointerException();		
	}
	return tabs.get(tabID);
}
	
/**
*@param t : The input tab.
*@throws  NullPointerException if input argument is null.
*/
public void setInputTab(Tab t) throws NullPointerException {
  if(t==null) {
	  throw new NullPointerException();
  }
  inputTab=t;	
}
/**
*@return Returns the input tab.
*/
public Tab getInputTab() {
	return inputTab;
}
/**
*@param t : The output tab.
*@throws  NullPointerException if input argument is null.
*/
public void setOutputTab(Tab t) throws NullPointerException {
  if(t==null) {
	  throw new NullPointerException();
  }
  inputTab=t;	
}
/**
*@return Returns the output tab.
*/
public Tab getOuputTab() {
	return outputTab;
}
/**
*@param c : The algoselector.
*@throws NullPointerException if input argument is null.
*/
public void setAlgoSelector(ComboBox<?> c) throws NullPointerException {
  if(c==null) {
	  throw new NullPointerException();
  }
  algoSelector=c;	
}
/**
*@return Returns the algorithm selector combobox.
*/
public ComboBox<?> getAlgoSelector() {
	return algoSelector;
}
/**
*@param textAreaID : The id for the textarea which is to be stored in the memo
*@param t : The text area itself with the specified ID. 
*@throws Throws  NullPointerException if input argument is null.
*@throws DataException if a TextArea with specified ID already exists.
*/
public void setTextAreaByID(int textAreaID,TextArea t)throws NullPointerException,DataException {
	if(tArea.containsKey(textAreaID)) {
		 throw new DataException("TextArea with the specified ID already exists.");
	}
	else if(t==null) {
		throw new NullPointerException();
	}
	else {
	    tArea.put(textAreaID, t);
	}
}
/**
*@param textAreaID : the ID for the TextArea which is to be retrieved. 
*@return Returns the text area with the specified id if it exists. 
*/
public TextArea getTextAreaByID(int textAreaID) {
	if(!tArea.containsKey(textAreaID)) {
		throw new NullPointerException();		
	}
	return tArea.get(textAreaID);
}
/**
*@param t : The text area. 
**@throws  NullPointerException if input argument is null.
*/
public void setProgressTextArea(TextArea t)throws NullPointerException{
	 if(t==null) {
		throw new NullPointerException();
	}
	else {
	   progressTArea=t; 
	}
}
/**
*@return Returns the text area with the specified id if it exists. 
*/
public TextArea getProgressTextArea() {
	return progressTArea;
}
/**
*@param t : The text area. 
*@throws  NullPointerException if input argument is null.
*/
public void setBullishResultTextArea(TextArea t)throws NullPointerException{
	 if(t==null) {
		throw new NullPointerException();
	}
	else {
	   rBullishTarea=t; 
	}
}
/**
*@return Returns the text area. 
*/
public TextArea getBullishResultTextArea() {
	return rBullishTarea;
}
/**
*@param t : The text area. 
*@throws   NullPointerException if input argument is null.
*/
public void setBearishResultTextArea(TextArea t)throws NullPointerException{
	 if(t==null) {
		throw new NullPointerException();
	}
	else {
	   rBearishTarea=t; 
	}
}
/**
*@return Returns the text area. 
*/
public TextArea getBearishResultTextArea() {
	return rBearishTarea;
}
/**
*@param buttonID : The id for the Button which is to be stored in the memo
*@param b : The Button itself with the specified ID. 
*@throws  NullPointerException if input argument is null.
*@throws  DataException if a TextArea with specified ID already exists.
*/
public void setButtonByID(int buttonID,Button b)throws NullPointerException,DataException {
	if(btn.containsKey(buttonID)) {
		 throw new DataException("Button with the specified ID already exists.");
	}
	else if(b==null) {
		throw new NullPointerException();
	}
	else {
	    btn.put(buttonID, b);
	}
}
/**
*@param buttonID : the ID for the Button which is to be retrieved. 
*@return Returns the Button with the specified id if it exists. 
*/
public Button getButtonByID(int buttonID) {
	if(!btn.containsKey(buttonID)) {
		throw new NullPointerException();		
	}
	return btn.get(buttonID);
}
/**
*@param b : The Button. 
*@throws NullPointerException if input argument is null.
*/
public void setCancelScanButton(Button b)throws NullPointerException{
	 if(b==null) {
		throw new NullPointerException();
	}
	else {
	   cancelScan=b; 
	}
}
/**
*@return Returns the Button. 
*/
public Button getCancelScanButton() {
	return cancelScan;
}
/**
*@param b : The Button. 
*@throws  NullPointerException if input argument is null.
*/
public void setSaveBullishButton(Button b)throws NullPointerException{
	 if(b==null) {
		throw new NullPointerException();
	}
	else {
	   saveBullish=b; 
	}
}
/**
*@return Returns the Button. 
*/
public Button getSaveBullishButton() {
	return saveBullish;
}
/**
*@param b : The Button. 
*@throws  NullPointerException if input argument is null.
*/
public void setSaveBearishButton(Button b)throws NullPointerException{
	 if(b==null) {
		throw new NullPointerException();
	}
	else {
	   saveBearish=b; 
	}
}
/**
*@return Returns the Button. 
*/
public Button getSaveBearishButton() {
	return saveBearish;
}
}
