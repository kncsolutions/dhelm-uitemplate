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
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import in.kncsolutions.dhelm.candlescanner.ScanParams;
import in.kncsolutions.dhelm.exceptions.DataException;
import in.kncsolutions.dhelm.uicomponents.dcontainers.DCandlePatternInput;
import in.kncsolutions.dhelm.uicomponents.dcontainers.DPopUp;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Node;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public abstract class CandleScanTemplate extends DCandlePatternInput{

private ToggleGroup exchange;
private List<String> exchangeNames = new ArrayList<String>();
private List<RadioButton> exchangeSelectors=new ArrayList<RadioButton>();
private List<String>toScanList=new ArrayList<String>();
private Map<String,Node> uiList=new HashMap<String,Node>();
private Tab inputTab,outputTab;
private boolean uiDisableRequest=false;

/**
*  	
*/
public CandleScanTemplate(ExchangeTemplate exchangeNames) {
   super();
   if(exchangeNames.isExchangeTemplateset())
   this.setExchangeSelector(exchangeNames.getExchangeList());
}
/**
*
*/
private void setExchangeSelector(Map<String,String> e){
  super.removeDemoExchanges();
  exchange = new ToggleGroup();
  for (Iterator<Entry<String, String>> iterator = e.entrySet().iterator(); iterator.hasNext();) {
	Entry<String, String> m = iterator.next();
	exchangeNames.add(m.getKey().toString());
	 Text txt=new Text(m.getValue().toString());
	 txt.setFont(Font.font("Tahoma", FontWeight.NORMAL, 12));
	 RadioButton r = new RadioButton(txt.getText());
	 r.setFont(Font.font("Tahoma", FontWeight.BOLD, 12));
	 exchangeSelectors.add(r);
}
  for(int i=0;i<exchangeSelectors.size();i++) {
	  exchangeSelectors.get(i).setToggleGroup(exchange);
	  super.getView().add(exchangeSelectors.get(i),i,2);
  }
  exchange.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
	    public void changed(ObservableValue<? extends Toggle> ov,
	        Toggle old_toggle, Toggle new_toggle) {
	            if (exchange.getSelectedToggle() != null) {
	            	  for(int i=0;i<exchangeSelectors.size();i++) {
	            		if(exchange.getSelectedToggle().equals(exchangeSelectors.get(i))) { 
	            			SelectedExchange=exchangeNames.get(i);
	            			System.out.println(SelectedExchange);
	            			break;
	            		}
	            	  }
	            }                
	       }
	});  
}
/**
*
*/
public void uiToDisable(Map<String,Node> u,Tab ip,Tab op)throws DataException{
  uiList.clear();
  if(u.isEmpty()){
    throw new DataException("No nodes are there to be disbled during execution.");
  }
  else{
    uiList.putAll(u);
  }
  inputTab=ip;
  outputTab=op;
  uiDisableRequest=true;
}
/**
*
*/
public abstract void controlOutputUnit();
/**
*@return Returns the selected Exchange identifier for stock exchange apis. 
*/
public String getSelectedExchange() {
	return SelectedExchange;
}
/**
* 
*/
@Override
public void setScanButtonControl() {
	if(!getCandleScanningStatus()){
      ScanParams.DataGap=CandleScanTemplate.super.getChartDataGap();
      ScanParams.BodyRefNumber=CandleScanTemplate.super.getBodyReferenceNumber();
      ScanParams.LengthRefNumber=CandleScanTemplate.super.getLengthReferenceNumber();
      ScanParams.LongShortRefPercentage=CandleScanTemplate.super.getLongShortPercentage();
      ScanParams.PrevTrendRefNumber=CandleScanTemplate.super.getTrendReferenceNumber();
      ScanParams.LowerShadowRefPercentage=CandleScanTemplate.super.getLowerShadowPercentage();
      ScanParams.UpperShadowRefPercentage=CandleScanTemplate.super.getUpperShadowPercentage();
      toScanList.addAll(setScanList(this.getSelectedExchange()));
      setCandleScanningStatus(true);
      if(this.uiDisableRequest) {
        if(!uiList.isEmpty())
        for(Map.Entry<String,Node> m:uiList.entrySet()){ 
          m.getValue().setDisable(true);
        }
       inputTab.setClosable(false);
       inputTab.getContent().setDisable(true);
       outputTab.setClosable(false);
     }
     doScan();
   }
	else if(getCandleScanningStatus()){
       DPopUp.Warn("Already Scanning..");
    }
}
/**
*
*/
public abstract List<String> setScanList(String exchangeID);
/**
*
*/
public abstract void doScan();
/**
*@return Returns the panel containing the input interface for scanning candle patterns.
*/
public GridPane getParamView(){
  return super.getView();
}

}