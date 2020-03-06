package com.ats.webapi.repository.alenqchatrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.alenqchat.AlbumEnqChat;

@Service
public interface AlbumEnqChatRepo extends JpaRepository<AlbumEnqChat, Integer>{

	
	AlbumEnqChat save(AlbumEnqChat albumEnqChat);
	
	List<AlbumEnqChat> findByalbEnqChatIdAndEnqNo(int albEnqChatId,int enqNo);
	
	@Query(value=" SELECT * FROM t_album_enq_chat WHERE t_album_enq_chat.fr_id=:frId  and t_album_enq_chat.alb_enq_chat_id>:albEnqChatId order by t_album_enq_chat.alb_enq_chat_id  desc  " + 
			"" + 
			"",nativeQuery=true)
	
	List<AlbumEnqChat> getChatListSpecFr(@Param("albEnqChatId") int albEnqChatId,@Param("frId") int frId);
	

	@Query(value=" SELECT * FROM t_album_enq_chat WHERE   t_album_enq_chat.alb_enq_chat_id>:albEnqChatId order by t_album_enq_chat.alb_enq_chat_id  desc  " + 
			"" + 
			"",nativeQuery=true)
	
	List<AlbumEnqChat> getChatListAllFr(@Param("albEnqChatId") int albEnqChatId);
	
	//Sachin 04-03-2020
	@Query(value="SELECT COUNT(t_album_enq_chat.alb_enq_chat_id) 	FROM t_album_enq_chat WHERE t_album_enq_chat.del_status=1 AND t_album_enq_chat.enq_no=:enqNo",nativeQuery=true)
	
	int getChatCountForEnqNo(@Param("enqNo") int enqNo);
	
}
