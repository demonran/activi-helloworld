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
	 * 部署流程定义
	 */
	@Test
	public void deploymentProcessDefinition()
	{
		//与流程定义和部署对象相关的service
		RepositoryService repositoryService = processEngine.getRepositoryService();
		Deployment deployment = repositoryService.createDeployment()
		.addClasspathResource("diagrams/helloworld.bpmn")
		.addClasspathResource("diagrams/helloworld.png")
		.deploy();
		System.out.println(deployment);
	}
	
	/**
	 * 启动流程实例
	 */
	@Test
	public void startProcessInstance()
	{
		//与正在执行的流程实例与执行对象相关
		RuntimeService runtimeService = processEngine.getRuntimeService();
	
		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("helloworld");
	
		System.out.println(processInstance.getBusinessKey());
		System.out.println(processInstance.getId());
		System.out.println(processInstance.getProcessDefinitionId());
		System.out.println(processInstance.getProcessInstanceId());
	}
	
	/**
	 * 查询当前人的个人任务
	 */
	@Test
	public void findMyPresonalTask()
	{
		TaskService taskService =processEngine.getTaskService();
		TaskQuery taskQuery = taskService.createTaskQuery().taskAssignee("李四");
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
