/*Name: Xianhui Feng
	Course: CS 111B
	CRN: 71755
	Assignment: StateStats.java
	Date:11/30/2013
*/



import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * This class demonstrates the List component
 */

public class ListForm extends JFrame {

	private State myState;		// The state
	private JList stateList;
	private JPanel statePanel;
	private JPanel selectedStatePanel;
	private JTextField selectedState;
	private JLabel label;
	
	/**
	 * This constructor initialize the state and create a list.
	 * @param state An state object
	 */
	
	public ListForm(State state){
		
		//create a new State object, passing state as an argument to the copy constructor
		myState = new State(state);
		
		//set the title, specify an action for the close button and add a borderLayout manager
		setTitle("StateStats Form");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		//Build the state and SelectedState panels
		buildStatePanel();
		buildSelectedStatePanel();
		
		//add panels to the content pane
		add(statePanel, BorderLayout.CENTER);
		add(selectedStatePanel, BorderLayout.SOUTH);
		
		//pack and display the window
		pack();
		setVisible(true);
	}
	
	
	/**
	 * getList method
	 * @return A list containing state name and abbreviation 
	 */
	
	public String[] getList(){
		
		String[] myList = new String[myState.getName().size()];
		for (int index = 0; index < myState.getName().size(); index++) {
			
			myList[index] = myState.getName().get(index) + "," + myState.getAbb().get(index);
			
		}
		return myList;

	}
	
	/**
	 * The buildStatePanel method adds a list to a panel
	 */
	public void buildStatePanel(){

		//Create a panel to hold the list
		statePanel = new JPanel();
		
		//Create the list
		stateList = new JList(getList());
		
		//Set the selectionMode to singel selection
		stateList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		//Register the list selection listener
		stateList.addListSelectionListener(new ListListener());
		
		//Add the list to panel.
		statePanel.add(stateList);		
	}
	
	/**
	 * The buildSelectedStatePanel method adds textdfield to a panel
	 */
	public void buildSelectedStatePanel(){
		
		//Create a panel to hold the text field
		selectedStatePanel = new JPanel();
		
		//Create a panel
		label = new JLabel("Population: ");
		
		//Create a text field
		selectedState = new JTextField(20);
		
		//Make the text field uneditable
		selectedState.setEditable(false);
		
		//Add the label and text field to the panel
		selectedStatePanel.add(label);
		selectedStatePanel.add(selectedState);
	}
	
	/**
	 * Private inner class that handles the event when the user selects an item from the list.
	 * @author xianh_000
	 *
	 */
	private class ListListener implements ListSelectionListener{
		public void valueChanged(ListSelectionEvent e ){
			
			//Get the selected population related to name
			String selection = myState.getPop().get(stateList.getSelectedIndex());

			//test if the first line of list is selected
			if(stateList.getSelectedIndex() == 0){
				JOptionPane.showMessageDialog(null, "Please choose one state!");
			}
			
			//put the selected population
			selectedState.setText(selection);	
		}
	}
}
