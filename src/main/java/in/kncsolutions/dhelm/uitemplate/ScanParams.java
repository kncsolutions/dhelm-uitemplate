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
/**
*
*/
public class ScanParams{
public static String DataGap;
public static long VolumeThreshold;
/**
*@param dg : data gap
*/
public static void setDataGap(String dg){
  DataGap=dg;
}
/**
*@param vt : volume threshold
*/
public static void setVolumeThreshold(long vt){
  VolumeThreshold=vt;
}
/**
*@return data gap
*/
public static String getDataGap(){
  return DataGap;
}
/**
*@return volume threshold
*/
public static long getVolumeThreshold(long vt){
  return VolumeThreshold;
}
}