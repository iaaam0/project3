package we.are.Mapper;

import java.util.ArrayList;

import we.are.Model.OrderDTO;

public interface StoreMapper {

	//출고 목록 가져오기
	public ArrayList<OrderDTO> store_select();
	
}
