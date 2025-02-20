/*
 * Copyright (C) 2023 Beijing Huaxia Chunsong Technology Co., Ltd. 
 * <https://www.chatopera.com>, Licensed under the Chunsong Public 
 * License, Version 1.0  (the "License"), https://docs.cskefu.com/licenses/v1.html
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * Copyright (C) 2018- Jun. 2023 Chatopera Inc, <https://www.chatopera.com>,  Licensed under the Apache License, Version 2.0, 
 * http://www.apache.org/licenses/LICENSE-2.0
 * Copyright (C) 2017 优客服-多渠道客服系统,  Licensed under the Apache License, Version 2.0, 
 * http://www.apache.org/licenses/LICENSE-2.0
 */
package com.cskefu.cc.util;

public enum RestResultType {
	OK(200, "OK") ,
	AUTH_ERROR(300, "AUTHORIZATION FAILD") ,
	USER_DELETE(400, "ADMIN USER"),
	ORGAN_DELETE(500, "NOT EXIST"), 
	LACKDATA(501, "LACK OF NECESSARY PARAMETERS") ,
	WORKORDERS_DELETE(600 , "WORKORDERS NOT EXIST"),
	WORKORDERS_NOTEXIST(601 , "WORKORDERS NOT EXIST"),
	XIAOE_TOPIC_DELETE(700, "TOPIC NOT EXIST") , 
	XIAOE_TOPIC_NOT_EMPTY(701, "TYPE NOT EXIST") , 
	XIAOE_TYPE_DELETE(702, "TYPE NOT EXIST");
	
	public int status ;
	private String message ;
	
	RestResultType(int status, String message) {
		this.status = status;
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
