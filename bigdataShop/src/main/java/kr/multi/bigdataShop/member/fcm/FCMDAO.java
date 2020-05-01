package kr.multi.bigdataShop.member.fcm;


public interface FCMDAO {
	FCMDTO getToken(String token);
	int insert(String token);
	FCMDTO getClientToken(String id);
}