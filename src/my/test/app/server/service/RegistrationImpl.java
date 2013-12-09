/*******************************************************************************
 * Copyright 2011 Google Inc. All Rights Reserved.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package my.test.app.server.service;

import my.test.app.client.service.Registration;
import my.test.app.db.ofy.OfyService;
import my.test.app.entity.Student;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class RegistrationImpl extends RemoteServiceServlet implements Registration {

	private static final long serialVersionUID = 1L;

	@Override
	public Boolean registration(String login, String password, String name, Integer age) {
		Student student = OfyService.ofy().query(Student.class).filter("login", login).get();
		if (student != null) return false;
		
		Student newStudent = new Student(login,password,name,age);
		
		OfyService.ofy().put(newStudent);
		return true;
	}
}
