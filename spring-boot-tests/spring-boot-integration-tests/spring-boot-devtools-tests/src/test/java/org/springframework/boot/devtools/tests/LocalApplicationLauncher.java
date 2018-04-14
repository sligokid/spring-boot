/*
 * Copyright 2012-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.boot.devtools.tests;

import java.io.File;

import org.springframework.boot.devtools.tests.JvmLauncher.LaunchedJvm;

/**
 * {@link ApplicationLauncher} that launches a local application with DevTools enabled.
 *
 * @author Andy Wilkinson
 */
public class LocalApplicationLauncher implements ApplicationLauncher {

	private final ApplicationClasspathHelper applicationClasspathHelper = new ApplicationClasspathHelper();

	@Override
	public LaunchedApplication launchApplication(JvmLauncher jvmLauncher) throws Exception {
		LaunchedJvm jvm = jvmLauncher.launch("local", this.applicationClasspathHelper.createApplicationClassPath(), "com.example.DevToolsTestApplication", "--server.port=0");
		return new LaunchedApplication(new File("target/app"), jvm.getStandardOut(), jvm.getStandardError(), jvm.getProcess());
	}

	protected String createApplicationClassPath() throws Exception {
		return this.applicationClasspathHelper.createApplicationClassPath();
	}


	public String toString() {
		return "local";
	}

}
