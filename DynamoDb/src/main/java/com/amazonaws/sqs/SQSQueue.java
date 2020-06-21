package com.amazonaws.sqs;

import java.util.List;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.AmazonSQSException;
import com.amazonaws.services.sqs.model.CreateQueueRequest;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.SendMessageRequest;

public class SQSQueue {

	AmazonSQS sqs = AmazonSQSClientBuilder.standard().withRegion(Regions.US_EAST_1).build();

	public static void main(String[] args) throws InterruptedException {
		SQSQueue sqs = new SQSQueue();
		// sqs.createQueue("Salman");
		// sqs.listQueue();
		//sqs.sendmessage("Salman", "SALMAN");
		sqs.listQueue();
	}

	void createQueue(String queue_name) {

		CreateQueueRequest create_request = new CreateQueueRequest(queue_name).addAttributesEntry("DelaySeconds", "5")
				.addAttributesEntry("MessageRetentionPeriod", "86400");
		try {
			sqs.createQueue(create_request);
			System.out.println("##############   :" + sqs.getQueueUrl(queue_name).getQueueUrl());

		} catch (AmazonSQSException e) {
			if (!e.getErrorCode().equals("QueueAlreadyExists")) {
				throw e;
			}
		}
	}

	void listQueue() throws InterruptedException {
		/*
		 * ListQueuesResult lq_result = sqs.listQueues();
		 * System.out.println("Your SQS Queue URLs:"); for (String url :
		 * lq_result.getQueueUrls()) { System.out.println(url); }
		 */

		String url1 = sqs.getQueueUrl("Salman").getQueueUrl();
		List<Message> messages = sqs.receiveMessage(url1).getMessages();
		for (Message url : messages){
		System.out.println("Message  :  " + url.getBody());
		sqs.changeMessageVisibility(sqs.getQueueUrl("Salman").getQueueUrl(),url.getReceiptHandle(),10000);
		//sqs.deleteMessage(sqs.getQueueUrl("Salman").getQueueUrl(), url.getReceiptHandle());
		}
	}

	void sendmessage(String queue_name, String message) {

		SendMessageRequest send_msg_request = new SendMessageRequest()
				.withQueueUrl(sqs.getQueueUrl(queue_name).getQueueUrl()).withMessageBody(message).withDelaySeconds(5);
		sqs.sendMessage(send_msg_request);

	}

}
