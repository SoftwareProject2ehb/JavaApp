package controller;

import java.security.InvalidParameterException;

import model.Price.betalingsType;
import view.*;

public class ConfigurationController {
	public static ReportView report;
	public static PriceConfigView price_config;
	public static UserView find_user;
	public static CreateUserView create_user;
	public static ConfigurationView configuration;
	
	public static void initialize(ReportView report, PriceConfigView price_config, UserView find_user, CreateUserView create_user, ConfigurationView configuration) {
		ConfigurationController.report = report;
		ConfigurationController.price_config = price_config;
		ConfigurationController.find_user = find_user;
		ConfigurationController.create_user = create_user;
		ConfigurationController.configuration = configuration;
	}
	
	public static void switchToReportView() {
		SystemController.frame.switchTo("REPORT");
	}
	
	public static void switchToPriceConfigView() {
		SystemController.frame.switchTo("PRICE_CONFIG");
	}
	
	public static void switchToFindUserView() {
		SystemController.frame.switchTo("FIND_USER");
	}
	
	public static void switchToCreateUserView() {
		SystemController.frame.switchTo("CREATE_USER");
	}
	
	public static void switchToConfigurationView() {
		SystemController.frame.switchTo("CONFIGURATION");
	}
	
	public static void createPrice() {
		SystemController.makeTicketType(price_config.getTxtSoort(), betalingsType.PER_HOUR.toString(), 1);
	}
	
	public static void updatePrice() {
		SystemController.updateTicketType(price_config.getPrice());
	}
}