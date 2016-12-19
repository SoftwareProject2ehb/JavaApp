package unit_tests;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import data_control.LogFileDAO;
import model.LogFile;

public class LogFileDAOTest {

	private LogFile log;
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreateLogFile() {
		Timestamp date = new Timestamp(new Date().getTime());
		log = new LogFile("aanmaken ticket", date, 15);
		LogFileDAO.createLogFile(log);
		LogFile log2 = LogFileDAO.getLatestEntry();
		assertTrue(log.getDescription().equals(log2.getDescription()));
		//assertTrue(log.getTime().equals(log2.getTime()));
		assertTrue(log.getUserID() == log2.getUserID());
		assertTrue(log.getLogFileID() == -1 && log2.getLogFileID() > 0);
	}
	
	@Test
	public void testUpdateStop() {
		LogFile log2 = LogFileDAO.getLatestEntry();
		Timestamp date = new Timestamp(new Date().getTime());
		log = new LogFile(log2.getLogFileID(),"aanmaken user", date, 17);
		LogFileDAO.updateLogfile(log);
		log2 = LogFileDAO.getLatestEntry();
		assertTrue(log.getLogFileID() == log2.getLogFileID());
		assertTrue(log.getUserID() == log2.getUserID());
		assertTrue(log.getDescription().equals(log2.getDescription()));
	}
	
	@Test
	public void testFindLogFileById() {
		LogFile log2 = LogFileDAO.getLatestEntry();
		log = LogFileDAO.findLogFileById(log2.getLogFileID());
		assertTrue(log.getLogFileID() == log2.getLogFileID());
		assertTrue(log.getUserID() == log2.getUserID());
		assertTrue(log.getDescription().equals(log2.getDescription()));
	}
	
	@Test
	public void testGetAllLogFiles() {
		LogFile log2 = LogFileDAO.getLatestEntry();
		List<LogFile> logs = LogFileDAO.getAllLogFiles();
		assertTrue(logs.size() == log2.getLogFileID());
	}

}
