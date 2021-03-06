package com.denissys.springboot.taskmanager.service;

import static org.mockito.Mockito.doReturn;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.denissys.springboot.taskmanager.enums.TaskType;
import com.denissys.springboot.taskmanager.exception.MalformedYamlException;
import com.denissys.springboot.taskmanager.yml.settings.Settings;
import com.denissys.springboot.taskmanager.yml.settings.Task;

@RunWith(MockitoJUnitRunner.class)
public class SettingsServiceTest {

	@Mock Settings settings;
	
	@InjectMocks SettingsService settingsService = new SettingsService();
	
	@Test(expected = MalformedYamlException.class)
	public void onApplicationEvent_withoutTasksInYml_shouldThrowsException() {
		settingsService.onApplicationEvent(null);
	}
	
	public void onApplicationEvent_withTasksInYml_() {
		doReturn(getTasks()).when(settings).getTask();
		settingsService.onApplicationEvent(null);
		
	}

	private List<Task> getTasks() {
		List<Task> tasks = new ArrayList<>();
		Task task = new Task();
		task.setDescription("Xpto");
		task.setName("xpto");
		task.setPath("http://netshoes.com.br");
		task.setPeriodInMs(10L);
		task.setType(TaskType.REST);
		tasks.add(task);
		return tasks;
	}

}
