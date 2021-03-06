//============================================================
//Copyright 2015, Drona, Inc. All rights reserved.
//============================================================
package com.settleUp.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.settleUp.requestResponse.GroupCreateRequest;
import com.settleUp.requestResponse.GroupsDTO;
import com.settleUp.requestResponse.GroupsResponse;
import com.settleUp.requestResponse.JsonResponse;
import com.settleUp.service.GroupService;


/**
 * @author Vinayak Mumbai <vinayak.s.mumbai@gmail.com> Created on Dec 1, 2015
 */
@Controller
public class GroupsController extends BaseController{
//private final Logger logger=Logger.getLogger(GroupsController.class);
    @Autowired
    private GroupService groupService;

    @RequestMapping(value = "/groups", method = RequestMethod.GET)
    public @ResponseBody GroupsResponse getGroupsCollection() {
        List<GroupsDTO> groups = groupService.getAllGroups();

        return buildResponse(groups);

    }

    @RequestMapping(value = "/groups/{groupId}", method = RequestMethod.GET)
    public @ResponseBody GroupsResponse getGroupEntity(@PathVariable(value = "groupId") long groupId) throws RuntimeException {
        GroupsDTO group = groupService.getGroup(groupId);
        return buildResponse(Arrays.asList(group));

    }

    @RequestMapping(value = "/groups", method = RequestMethod.POST)
    public @ResponseBody JsonResponse createGroupEntity(@RequestBody GroupCreateRequest request) {
        if (request == null) {
            throw new RuntimeException("Invalid request");
        }
        groupService.createGroup(request);
        JsonResponse response =
            new JsonResponse(HttpStatus.CREATED, "Entity has been created sucessfully");

        return response;

    }
   
    private GroupsResponse buildResponse(List<GroupsDTO> groups) {
        GroupsResponse response = new GroupsResponse();
        response.setStaus(HttpStatus.OK);
        response.setMessage("Success");
        if (groups != null && !groups.isEmpty()) {
            response.setGroups(groups);
        }
        return response;
    }

}
