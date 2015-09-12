package test;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.JerseyClient;
import org.glassfish.jersey.client.JerseyWebTarget;

import com.easemob.server.example.jersey.utils.JerseyUtils;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class Test implements Runnable{

	private static final JsonNodeFactory factory = new JsonNodeFactory(false);
	
	private static int count = 0;
	public static void main(String[] args) {

//		testChangePassword();
//		
//		testChangeNickname();
//		
//		testGetUserInfo();
		
		testAddFriend();
		
		testRemoveFriend();
	}
	
	/*解除好友关系*/
	public static void testRemoveFriend() {
		ObjectNode objectNode = factory.objectNode();
		JerseyClient client = JerseyUtils.getJerseyClient(true);
		
		JerseyWebTarget url = client.target("http://localhost:8080/webchat/friend/123/contacts/456");
		Invocation.Builder inBuilder = url.request();
		
		inBuilder.header("username", "123");
		inBuilder.header("password", "123");
		
//		Response response = inBuilder.get(Response.class);
		
//		Response response = inBuilder.post(Entity.entity(null, MediaType.APPLICATION_JSON) ,Response.class);
		
		Response response = inBuilder.delete(Response.class);
		
		objectNode = response.readEntity(ObjectNode.class);
		objectNode.put("statusCode", response.getStatus());
		
		System.out.println("response : " + response);
		System.out.println("objectNode : " + objectNode.toString());
	}
	/* 添加好友*/
	public static void testAddFriend() {
		ObjectNode objectNode = factory.objectNode();
		JerseyClient client = JerseyUtils.getJerseyClient(true);
		
		JerseyWebTarget url = client.target("http://localhost:8080/webchat/friend/123/contacts/456");
		Invocation.Builder inBuilder = url.request();
		
		inBuilder.header("username", "123");
		inBuilder.header("password", "123");
		
//		Response response = inBuilder.get(Response.class);
		
		Response response = inBuilder.post(Entity.entity(null, MediaType.APPLICATION_JSON) ,Response.class);
		
		objectNode = response.readEntity(ObjectNode.class);
		objectNode.put("statusCode", response.getStatus());
		
		System.out.println("response : " + response);
		System.out.println("objectNode : " + objectNode.toString());
	}
	
	/* 获取用户信息*/
	public static void testGetUserInfo() {
		ObjectNode objectNode = factory.objectNode();
		JerseyClient client = JerseyUtils.getJerseyClient(true);
		
		JerseyWebTarget url = client.target("http://localhost:8080/webchat/user/123");
		Invocation.Builder inBuilder = url.request();
		
		inBuilder.header("username", "123");
		inBuilder.header("password", "123");
		
		Response response = inBuilder.get(Response.class);
		
		objectNode = response.readEntity(ObjectNode.class);
		objectNode.put("statusCode", response.getStatus());
		
		System.out.println("response : " + response);
		System.out.println("objectNode : " + objectNode.toString());
	}
	
	/*修改密码*/
	public static void testChangePassword() {
		ObjectNode objectNode = factory.objectNode();
		JerseyClient client = JerseyUtils.getJerseyClient(true);
		
		JerseyWebTarget url = client.target("http://localhost:8080/webchat/user/123/password");
		Invocation.Builder inBuilder = url.request();
		
		inBuilder.header("username", "123");
		inBuilder.header("password", "123");
		
		ObjectNode json2 = JsonNodeFactory.instance.objectNode();
		json2.put("password", "123");
		json2.put("newPassword", "123");
		
		Response response = inBuilder.put(Entity.entity(json2, MediaType.APPLICATION_JSON) ,Response.class);
		
		objectNode = response.readEntity(ObjectNode.class);
		objectNode.put("statusCode", response.getStatus());
		
		System.out.println("response : " + response);
		System.out.println("objectNode : " + objectNode.toString());
		
	}
	
	/*修改昵称*/
	public static void testChangeNickname() {
		ObjectNode objectNode = factory.objectNode();
		JerseyClient client = JerseyUtils.getJerseyClient(true);
		
		JerseyWebTarget url = client.target("http://localhost:8080/webchat/user/123/nickname");
		Invocation.Builder inBuilder = url.request();
		
		inBuilder.header("username", "123");
		inBuilder.header("password", "123");
		
		ObjectNode json = JsonNodeFactory.instance.objectNode();
		json.put("nickname", "123");
		
		Response response = inBuilder.put(Entity.entity(json, MediaType.APPLICATION_JSON) ,Response.class);
		
		objectNode = response.readEntity(ObjectNode.class);
		objectNode.put("statusCode", response.getStatus());
		
		System.out.println("response : " + response);
		System.out.println("objectNode : " + objectNode.toString());
	}

	public static void testRun() throws InterruptedException {
		for(int i = 1; i < 400; i++) {
			Test t = new Test();
			Thread d = new Thread(t);
			d.start();
		}
	}
	
	public void run() {
		// TODO Auto-generated method stub
		Test test = new Test();
		test.testChangePassword();
	}
	
}
