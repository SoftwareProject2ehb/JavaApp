package event_handlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.*;

public class CreateCustomer_CreatePressed implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		CustomerController.createCustomer();

	}

}
