package org.workers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.workers.contracts.Story;
import org.workers.contracts.Task;
import org.workers.factory.ManagerFactory;

@SpringBootApplication
public class WorkersApplication {

	public static void main(String[] args) {
		//SpringApplication.run(WorkersApplication.class, args);
		ManagerFactory.getManager().assignStory(new Story() {

			@Override
			public int progressReport() {

				return 0;
			}

			@Override
			public Task getTask() {

				return new Task() {

					@Override
					public String getTaskName() {

						return "Test";
					}

					@Override
					public void executeTask() {
						System.out.println("Executing test task.");

					}
				};
			}

			@Override
			public String getStoryName() {

				return "Test- Story";
			}

			@Override
			public Long getStoryId() {

				return 1L;
			}

			@Override
			public int getPriority() {

				return 0;
			}

			@Override
			public void closeStory() {

			}
		});
	}

}
