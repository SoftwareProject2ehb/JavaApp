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
		FrameController.getFrame().switchTo("REPORT");
	}
	
	public static void switchToPriceConfigView() {
		FrameController.getFrame().switchTo("PRICE_CONFIG");
		FrameController.changeSize(700, 400);
	}
	
	public static void switchToFindUserView() {
		FrameController.getFrame().switchTo("FIND_USER");
	}
	
	public static void switchToCreateUserView() {
		FrameController.getFrame().switchTo("CREATE_USER");
	}
	
	public static void switchToConfigurationView() {
		FrameController.getFrame().switchTo("CONFIGURATION");
	}
	
	public static void createPrice() {
		SystemController.makeTicketType(price_config.getTxtSoort(), betalingsType.PER_HOUR.toString(), 1);
	}
	
	public static void updatePrice() {
		SystemController.updateTicketType(price_config.getPrice());
	}
	
	public static void deletePrice() {
		SystemController.deleteTicketType(price_config.getPrice());
	}
	
	public static void createSubPrice() {
		SystemController.makeSubscriptionPrice(price_config.getSubTxtSoort(), betalingsType.PER_HOUR.toString(), 1, price_config.getMonths());
	}
	
	public static void updateSubPrice() {
		SystemController.updateSubscriptionType(price_config.getSubscriptionPrice());
	}
	
	public static void deleteSubPrice() {
		SystemController.deleteSubscriptionType(price_config.getSubscriptionPrice());
	}
}