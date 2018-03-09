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

import java.util.HashMap;
import java.util.Map;

import in.kncsolutions.dhelm.exceptions.DataException;

public class ExchangeTemplate {
public Map<String,String> exchangeList=new HashMap<String,String>();
public boolean isSet=false;
/**
*@param e : A hash map where key is a string which is the identifier at the stock exchange itself and the value string is the 
*symbol which will be use in the user interface. 
* @throws DataException 
*/
public void setExchangeList(Map<String,String> e) throws DataException {
	if(e.isEmpty())
		throw new DataException("Cannot be empty");
	exchangeList.clear();
	exchangeList.putAll(e);
	isSet=true;
}
/**
*@return Returns the hash map containing the exchange details required. 
*/
public Map<String,String> getExchangeList(){
	return exchangeList;
}
/**
*@return Returns true if the Exchange template data is set. 
*/
public boolean isExchangeTemplateset() {
	return isSet;
}
}
