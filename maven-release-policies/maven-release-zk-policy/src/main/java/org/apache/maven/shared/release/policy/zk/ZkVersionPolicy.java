/*
 * File Name: ZkVersionPolicy
 * Created by oujunxiao on 2018/5/25 下午5:24.
 * Copyright:Copyright © 1985-2017 ZKTeco Inc.All right reserved.
 */


package org.apache.maven.shared.release.policy.zk;

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

import org.apache.maven.shared.release.policy.PolicyException;
import org.apache.maven.shared.release.policy.version.VersionPolicy;
import org.apache.maven.shared.release.policy.version.VersionPolicyRequest;
import org.apache.maven.shared.release.policy.version.VersionPolicyResult;
import org.apache.maven.shared.release.versions.VersionParseException;
import org.codehaus.plexus.component.annotations.Component;

/**
 * @author <a href:"mailto:oujunxiao.ou@zkteco.com">oujunxiao</a>
 * @version v1.0
 */
@Component(
        role = VersionPolicy.class,
        hint = "zkteco",
        description = "A VersionPolicy for zkteco rules"
)
public class ZkVersionPolicy implements VersionPolicy {

    private static final String MAILSTONE = "-alpha";
    @Override
    public VersionPolicyResult getReleaseVersion(VersionPolicyRequest request) throws PolicyException, VersionParseException {
        String releaseVersion = new ZkVersionInfo( request.getVersion() ).getReleaseVersionString(MAILSTONE);
        return new VersionPolicyResult().setVersion( releaseVersion );
    }

    @Override
    public VersionPolicyResult getDevelopmentVersion(VersionPolicyRequest request) throws PolicyException, VersionParseException {
        String developmentVersion =
                new ZkVersionInfo( request.getVersion() ).getNextVersion().getSnapshotVersionString(MAILSTONE);
        return new VersionPolicyResult().setVersion( developmentVersion );
    }
}
