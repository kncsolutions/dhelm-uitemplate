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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TemplateModel {
private Map<Integer,String> mainToolBarButtonContent;
private boolean mtbBContentOverriden=false;
private List<String> algoList=new ArrayList<String>();
private boolean algoListOverriden=false;
private Map<Integer,String> centerTabTitles=new HashMap<Integer,String>();
private boolean centerTabTitlesOverriden=false;
private boolean useDefaultOPterminal=true;
/**
* 
*/
public TemplateModel() {
	 setDefault_mainToolBarButtonContent();
	 setDefault_algoList();
	 setDefaultContentcenterTabTitles();
	 	
}
/**
*@param b : A hashmap containing <buttonID,button_name> pair. 
*/
public void setContentMainToolbarButtons(Map<Integer,String> b) {
	mainToolBarButtonContent.clear();
	mainToolBarButtonContent.putAll(b);
	mtbBContentOverriden=true;
}
/**
*@return Returns true if main tool bar buttons are set by calling the method  setContentMainToolbarButtons(Map<Integer,String> b)
*/
public boolean getContentMainToolbarButtonsStatus() {
	return mtbBContentOverriden;
}
/**
*@return Returns all main tool bar button names to be included with their indices. 
*/
public Map<Integer,String> getContentMainToolbarButtons() {
	return mainToolBarButtonContent;
}
/**
*@param algorithms : List of supported algorithms in the implementation. 
*/
public void setContentAlgoList(List<String> algorithms) {
	algoList.clear();
	algoList.add("Select");
	algoList.addAll(algorithms);
	algoListOverriden=true;
}
/**
*@return Returns true if algorithm list is set by calling setContentAlgoList(List<String> algorithms) function.
*/
public boolean getContentAlgoListStatus() {
	return algoListOverriden;
}
/**
*@return Returns the list of all algorithm names to be included in the implementation. 
*/
public List<String> getContentAlgoList() {
	return algoList;
}
/**
*@param b : A hashmap containing <event_no,tab_title> pair. 
*/
public void setContentcenterTabTitles(Map<Integer,String> b) {
	centerTabTitles.clear();
	centerTabTitles.putAll(b);
	centerTabTitlesOverriden=true;
}
/**
*
*/
public String getCenterTabTitle(int event_no) {
	if(centerTabTitles.containsKey(event_no)) {
		return centerTabTitles.get(event_no);
	}
	else {
		return null;
	}
}
/**
*@param b :  
*/
public void setDefaultOpTerminal(boolean b) {
	useDefaultOPterminal=true;
}
/**
*@return   
*/
public boolean getDefautOpTerminal() {
	return useDefaultOPterminal;
}
/**
*@return Returns true if algorithm list is set by calling setContentAlgoList(List<String> algorithms) function.
*/
public boolean getContentcenterTabTitles() {
	return centerTabTitlesOverriden;
}
/**
* 
*/
private void setDefault_mainToolBarButtonContent() {
	mainToolBarButtonContent=new HashMap<Integer,String>();
	mainToolBarButtonContent.put(1,"Button Test");
	mainToolBarButtonContent.put(2,"Button 1");  
	mainToolBarButtonContent.put(3,"Button 2"); 
	mainToolBarButtonContent.put(4,"Button 3");
	mainToolBarButtonContent.put(5,"Button 4");	   
}
/**
* 
*/
private void setDefault_algoList() {
	algoList.add("Select");
	algoList.add("Algo1");
	algoList.add("Algo2");
	algoList.add("Algo3");
	algoList.add(".....");
}
/**
* 
*/
private void setDefaultContentcenterTabTitles() {
	centerTabTitles.clear();
	centerTabTitles.put(1,"Candle Scanning");
}
}
