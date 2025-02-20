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
package com.cskefu.cc.controller.api;

import com.cskefu.cc.controller.Handler;
import com.cskefu.cc.persistence.repository.ChatMessageRepository;
import com.cskefu.cc.util.Menu;
import com.cskefu.cc.util.RestResult;
import com.cskefu.cc.util.RestResultType;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

/**
 * 获取对话内容
 * 获取访客对话的内容
 */
@RestController
@RequestMapping("/api/chatmessage")
public class ApiChatMessageController extends Handler {

    @Autowired
    private ChatMessageRepository chatMessageRes;

    /**
     * 获取访客对话内容
     *
     * @param request
     * @param serviceid AgentServiceID
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    @Menu(type = "apps", subtype = "agentuser", access = true)
    public ResponseEntity<RestResult> list(HttpServletRequest request, @Valid String serviceid) {
        ResponseEntity<RestResult> result = null;
        if (!StringUtils.isBlank(serviceid)) {
            result = new ResponseEntity<>(new RestResult(RestResultType.OK, chatMessageRes.findByAgentserviceid(serviceid, PageRequest.of(super.getP(request), super.getPs(request), Sort.Direction.DESC, "createtime"))), HttpStatus.OK);
        } else {
            result = new ResponseEntity<>(new RestResult(RestResultType.LACKDATA, RestResultType.LACKDATA.getMessage()), HttpStatus.OK);
        }
        return result;
    }
}