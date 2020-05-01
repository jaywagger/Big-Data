package kr.multi.bigdataShop.member.fcm;


public interface FCMService {
	int getToken(String token);

	FCMDTO getClientToken(String id);
}
