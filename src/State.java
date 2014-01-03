/*Name: Xianhui Feng
	Course: CS 111B
	CRN: 71755
	Assignment: StateStats.java
	Date:11/30/2013
*/
 

import java.util.ArrayList;

/*
 * This class stores data about State statistic
 */

public class State {

	private ArrayList<String> name;		//name
	private ArrayList<String> abb;		//abbreviation
	private ArrayList<String> pop;		//population
	private ArrayList<Float> per;		//percentage of population of state
	

	/*
	 * This constructor initializes the name,abbreviation,population and percentage
	 * @param pName the name
	 * @param pAbb the abbreviation
	 * @param pPop the population
	 * @param pPer the percentage of population of state
	 */
	
	public State(ArrayList<String> pName, ArrayList<String> pAbb, ArrayList<String> pPop, ArrayList<Float> pPer) {
		
		name = pName;
		abb = pAbb;
		pop = pPop;
		per = pPer;
		
	}
	
	/*
	 * The copy constructor initializes the object as a copy of another State object.
	 * @copyObj The object to copy.
	 */
	
	public State (State copyObj){
		name = copyObj.name;
		abb = copyObj.abb;
		pop = copyObj.pop;
		per = copyObj.per;
	}
	
	/*
	 *getName method
	 *@return the name of the state 
	 */
	
	public ArrayList<String> getName(){
		return name;
	}
	
	/*
	 * getAbb method 
	 * @return the abbreviation of the state
	 */
	
	public ArrayList<String> getAbb(){
		return abb;
	}
	
	/*
	 * getPop method
	 * @return the population of the state
	 */
	
	public ArrayList<String> getPop(){
		return pop;
	}
	
	/*
	 * getPer method
	 * @return the percentage of population of state
	 */
	public ArrayList<Float> getPer(){
		return per;
	}
	
	
}
