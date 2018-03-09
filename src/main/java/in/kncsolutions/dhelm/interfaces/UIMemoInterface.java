package in.kncsolutions.dhelm.interfaces;

import java.awt.Button;

import in.kncsolutions.dhelm.exceptions.DataException;
import javafx.scene.Node;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;

public interface UIMemoInterface {
	/**
	*@param nodeID : The id for the Node which is to be stored in the memo
	*@param t : The Node itself with the specified ID. 
	*@throws  NullPointerException if input argument is null.
	*@throws  DataException if a Node with specified ID already exists.
	*/
	public void setNodeByID(int nodeID,Node t)throws NullPointerException,DataException;
	/**
	*@param nodeID : the ID for the Tab which is to be retrieved. 
	*@return Returns the Node with the specified id if it exists. 
	*/
	public Node getNodeByID(int nodeID);
	/**
	*@param tabID : The id for the Tab which is to be stored in the memo
	*@param t : The Tab itself with the specified ID. 
	*@throws  NullPointerException if input argument is null.
	*@throws  DataException if a Tab with specified ID already exists.
	*/
	public void setTabByID(int tabID,Tab t)throws NullPointerException,DataException;
	/**
	*@param tabID : the ID for the Tab which is to be retrieved. 
	*@return Returns the Tab with the specified id if it exists. 
	*/
	public Tab getTabByID(int tabID);
	/**
	*@param textAreaID : The id for the textarea which is to be stored in the memo
	*@param t : The text area itself with the specified ID. 
	*@throws  NullPointerException if input argument is null.
	*@throws  DataException if a TextArea with specified ID already exists.
	*/
	public void setTextAreaByID(int textAreaID,TextArea t)throws NullPointerException,DataException;
	/**
	*@param textAreaID : the ID for the TextArea which is to be retrieved. 
	*@return Returns the text area with the specified id if it exists. 
	*/
	public TextArea getTextAreaByID(int textAreaID);
	/**
	*@param buttonID : The id for the Button which is to be stored in the memo
	*@param b : The Button itself with the specified ID. 
	*@throws  NullPointerException if input argument is null.
	*@throws  DataException if a TextArea with specified ID already exists.
	*/
	public void setButtonByID(int buttonID,Button b)throws NullPointerException,DataException;
	/**
	*@param buttonID : the ID for the Button which is to be retrieved. 
	*@return Returns the Button with the specified id if it exists. 
	*/
	public Button getButtonByID(int buttonID);
}
