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

/**
 * {@link ApplicationLauncher} that launches a remote application with its classes
 * available directly on the file system.
 *
 * @author Andy Wilkinson
 */
public class ExplodedRemoteApplicationLauncher extends RemoteApplicationLauncher {

	private final ApplicationClasspathHelper applicationClasspathHelper = new ApplicationClasspathHelper();

	@Override
	protected String createApplicationClassPath() throws Exception {
		return this.applicationClasspathHelper.createApplicationClassPath();
	}

	@Override
	public String toString() {
		return "exploded remote";
	}

}
