/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.cloudstack.storage.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.cloudstack.storage.datastore.utils.DateraRestClient;
import org.apache.cloudstack.storage.datastore.utils.DateraUtil;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DateraUtilTest {
	
	@Test
    public void testValidateUrl(){
    	String url = "  mgmtIP   =       172.19.175.170;   mgmtPort=7718     ;mgmtUserName=admin;mgmtPassword=  password;replica = 3;     " + 
    			"networkPoolName=default   ; datacenter   =  dummy1; volumeGroupName=  vg   2; appName=xen1;storageName=storage-1;";

    	assertTrue(DateraUtil.getValue(DateraUtil.MANAGEMENT_IP, url).equals("172.19.175.170"));
    	assertTrue(DateraUtil.getValue(DateraUtil.MANAGEMENT_PORT, url).equals("7718"));
    	assertTrue(DateraUtil.getValue(DateraUtil.MANAGEMENT_USERNAME, url).equals("admin"));
    	assertTrue(DateraUtil.getValue(DateraUtil.MANAGEMENT_PASSWORD, url).equals("password"));
    	assertTrue(DateraUtil.getValue(DateraUtil.VOLUME_REPLICA, url).equals("3"));
    	assertTrue(DateraUtil.getValue(DateraUtil.NETWORK_POOL_NAME, url).equals("default"));
    	assertTrue(DateraUtil.getValue(DateraUtil.DATACENTER, url).equals("dummy1"));
    	assertTrue(DateraUtil.getValue(DateraUtil.CLVM_VOLUME_GROUP_NAME, url).equals("vg   2"));
    	assertTrue(DateraUtil.getValue(DateraUtil.APP_NAME, url).equals("xen1"));
    	assertTrue(DateraUtil.getValue(DateraUtil.STORAGE_NAME, url).equals("storage-1"));
    }
}