package com.ats.webapi.repository.alenqchatrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.alenqchat.AlbumEnqChat;

@Service
public interface AlbumEnqChatRepo extends JpaRepository<AlbumEnqChat, Integer>{

	
	AlbumEnqChat save(AlbumEnqChat albumEnqChat);
	
	List<AlbumEnqChat> findByalbEnqChatIdAndEnqNo(int albEnqChatId,int enqNo);
	
}
