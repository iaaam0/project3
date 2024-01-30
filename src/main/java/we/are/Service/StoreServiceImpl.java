package we.are.Service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import we.are.Mapper.StoreMapper;
import we.are.Model.OrderDTO;

@Service
public class StoreServiceImpl implements StoreService {
	
	@Autowired
	StoreMapper sm;
	
	//'수주확인'된 거래처 리스트
	public ArrayList<HashMap<String, Object>> store_select() {
		return sm.store_select();
	}
	//재고량 확인
	public int product_select(String pstock) {
		return sm.product_select(pstock);
	}
	
	//출고일 등록
	public int baljuday_update(String uuid) {
		return sm.baljuday_update(uuid);
	}
	
	public int product_update(OrderDTO od) {
		return sm.product_update(od);
	}
}
