/*
 * Created by Pavel Gavrilov
 */

package com.fofgroup.test.demo;

import com.fofgroup.test.api.MessageBroker;
import com.fofgroup.test.demo.mock.MockMessage;

public class MockMessageGenerator implements MockTopics, Runnable{
    private static final int DELAY = 1;
    private long counter = 0;
    MessageBroker<MockMessage> messageBroker;

    public MockMessageGenerator(MessageBroker<MockMessage> messageBroker) {
        this.messageBroker = messageBroker;
    }

    public void run() {
        generate();
    }

    private void generate() {
        while (true) {
            messageBroker.send(getMessage());
            try {
                Thread.sleep(DELAY);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private MockMessage getMessage() {
        String text = "Message #";
        return new MockMessage(getTopics(), text + counter++);
    }
}
