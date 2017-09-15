package com.ats.webapi.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.Info;
import com.ats.webapi.model.Message;
import com.ats.webapi.repository.MessageRepository;
import com.ats.webapi.util.JsonUtil;

@Service()
public class MessageServiceImpl implements MessageService {
	String jsonMessage = "{}";
	Message message = null;
	@Autowired
	MessageRepository messageRepository;

	@Override
	public String save(Message message) {
		
		try {
			if(message.getMsgDetails()!=null && !message.getMsgDetails().trim().equals("") 
					&& message.getMsgHeader()!=null &&!message.getMsgHeader().trim().equals("")
					&& message.getMsgImage()!=null 
					&& !message.getMsgImage().trim().equals("")&& message.getMsgImage()!=null 
					&& !message.getMsgImage().trim().equals("")) {
				message = messageRepository.save(message);
				Info info= new Info();
				info.setError(false);
				info.setMessage("Message inserted Successfully");
				jsonMessage=JsonUtil.javaToJson(info);
			}
			else {
				message.setMsgDetails(message.getMsgDetails());
				message.setMsgHeader(message.getMsgHeader());
				message.setMsgImage(message.getMsgImage());
				Info info= new Info();
				info.setError(true);
				info.setMessage("Message insertion failed");
				jsonMessage=JsonUtil.javaToJson(info);
			}
				
		} catch (Exception e) {
			System.out.println("MsgServiceImp Excep: " + e.getMessage());

		}
	return jsonMessage;
	}

	@Override
	public List<Message> findAllMessage() {
			List<Message> messageList=messageRepository.findByDelStatus(0);
	return messageList;
	}

	@Override
	public Message findMessage(int id) {
		Message message=messageRepository.findOne(id);
	return message;
	}
	@Override
	public List<Message> showAllMessage(Date cDate) {
		
		List<Message> messsageList=messageRepository.findMessage(cDate);
		
		return messsageList;
	}

}
