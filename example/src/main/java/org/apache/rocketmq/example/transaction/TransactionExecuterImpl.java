/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.rocketmq.example.transaction;

import org.apache.rocketmq.client.producer.LocalTransactionExecuter;
import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.common.message.Message;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class TransactionExecuterImpl implements LocalTransactionExecuter {
    private AtomicInteger transactionIndex = new AtomicInteger(0);

    @Override
    public LocalTransactionState executeLocalTransactionBranch(final Message msg, final Object arg) {
        Integer cnt = (Integer) arg;
        if(cnt%5==0){
            //return LocalTransactionState.ROLLBACK_MESSAGE;
        }
        try {
            Thread.sleep(new Random().nextInt(200));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return LocalTransactionState.COMMIT_MESSAGE;
       //return LocalTransactionState.UNKNOW;
    }
}
