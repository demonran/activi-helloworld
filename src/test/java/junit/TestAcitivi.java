package junit;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
import org.junit.Test;


public class TestAcitivi {
	
	/**
	 * ʹ�ô��봴����������Ҫ��23�ű�
	 */
	@Test
	public void createTable()
	{
		ProcessEngineConfiguration processEngineConfiguration = ProcessEngineConfiguration.createStandaloneProcessEngineConfiguration();
		
		processEngineConfiguration.setJdbcDriver("com.mysql.jdbc.Driver");
		processEngineConfiguration.setJdbcUrl("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8");
		processEngineConfiguration.setJdbcUsername("root");
		processEngineConfiguration.setJdbcPassword("12345");
		
		
		processEngineConfiguration.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
		//�������ĺ��Ķ��� ProcessEngine
		ProcessEngine processEngine = processEngineConfiguration.buildProcessEngine();
		
		System.out.println(processEngine);
	}
	
	@Test
	public void createTable_2()
	{
		ProcessEngineConfiguration processEngineConfiguration = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml");
		ProcessEngine processEngine  = processEngineConfiguration.buildProcessEngine();
		System.out.println(processEngine);
	}
	
	@Test
	public void createTable_3()
	{
		ProcessEngine processEngine  = ProcessEngines.getDefaultProcessEngine();
		System.out.println(processEngine);
	}
}
