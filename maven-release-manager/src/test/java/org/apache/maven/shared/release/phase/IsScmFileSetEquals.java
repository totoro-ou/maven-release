package org.apache.maven.shared.release.phase;

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

import org.apache.maven.scm.ScmFileSet;
import org.jmock.core.Constraint;

/**
 * JMock constraint to compare file sets since it has no equals method.
 *
 * @author <a href="mailto:brett@apache.org">Brett Porter</a>
 * @todo add an equals() method
 */
public class IsScmFileSetEquals
    implements Constraint
{
    private final ScmFileSet fileSet;

    public IsScmFileSetEquals( ScmFileSet fileSet )
    {
        this.fileSet = fileSet;
    }

    public boolean eval( Object object )
    {
        ScmFileSet fs = (ScmFileSet) object;

        System.out.println( "fs.getBasedir " + fs.getBasedir() );
        System.out.println( "fileSet.getBasedir " + fs.getBasedir() );
        
        return fs.getBasedir().equals( fileSet.getBasedir() ) &&
         fs.getFileList().equals( fileSet.getFileList() );
    }

    public StringBuffer describeTo( StringBuffer stringBuffer )
    {
        return stringBuffer.append( fileSet.toString() );
    }
}
