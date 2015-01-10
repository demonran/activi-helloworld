package com.tcl.activi.helloworld;

import java.util.List;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.junit.Test;

public class HelloWorld {
	
	ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
	/**
	 * �������̶���
	 */
	@Test
	public void deploymentProcessDefinition()
	{
		//�����̶���Ͳ��������ص�service
		RepositoryService repositoryService = processEngine.getRepositoryService();
		Deployment deployment = repositoryService.createDeployment()
		.addClasspathResource("diagrams/helloworld.bpmn")
		.addClasspathResource("diagrams/helloworld.png")
		.deploy();
		System.out.println(deployment);
	}
	
	/**
	 * ��������ʵ��
	 */
	@Test
	public void startProcessInstance()
	{
		//������ִ�е�����ʵ����ִ�ж������
		RuntimeService runtimeService = processEngine.getRuntimeService();
	
		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("helloworld");
	
		System.out.println(processInstance.getBusinessKey());
		System.out.println(processInstance.getId());
		System.out.println(processInstance.getProcessDefinitionId());
		System.out.println(processInstance.getProcessInstanceId());
	}
	
	/**
	 * ��ѯ��ǰ�˵ĸ�������
	 */
	@Test
	public void findMyPresonalTask()
	{
		TaskService taskService =processEngine.getTaskService();
		TaskQuery taskQuery = taskService.createTaskQuery().taskAssignee("����");
		List<Task> tasks = taskQuery.list();
		
		for(Task task : tasks)
		{
			System.out.println(task.getId());
			System.out.println(task.getName());
			System.out.println(task.getAssignee());
			System.out.println(task.getCreateTime());
		}
	}
	@Test
	public void completeMyPersonTask()
	{
		TaskService taskService = processEngine.getTaskService();
		taskService.complete("404");
	}
}
